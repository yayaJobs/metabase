(ns metabase.shared.visualization
  "Shared code for dealing with visualization settings."
  (:require [clojure.string :as str]
            [clojure.spec.alpha :as clj.spec]))

(clj.spec/def ::visualization-settings-v1 inst?)

(clj.spec/def ::visualization-settings-v2 inst?)

(defn- field-id-key [col]
  (keyword (format "[\"ref\",[\"field\",%d,null]]" (:id col))))

(defn- expression-key [col]
  (keyword (format "[\"ref\",[\"expression\",\"%s\"]]" (:expression_name col))))

(def ^:private col-key-regex #"\[\"ref\",\[(?:\"field\",\d+,null|\"expression\",\".+\")\]\]")

(clj.spec/def ::column-setting-v1-key (clj.spec/and keyword? #(->> %
                                                                   (name)
                                                                   (re-matches col-key-regex))))

(clj.spec/def ::column_title string?)

(clj.spec/def ::date_style #{"M/D/YYYY" "D/M/YYYY" "YYYY/M/D" "MMMM D, YYYY" "D MMMM, YYYY" "dddd, MMMM D, YYYY"})
(clj.spec/def ::date_abbreviate boolean?)
(clj.spec/def ::time_style #{"h:mm A" "k:mm" "h A"})
(clj.spec/def ::time_enabled #{nil "minutes" "seconds" "milliseconds"})

(clj.spec/def ::decimals pos-int?)
(clj.spec/def ::number_separators #(= 2 (count %)))
(clj.spec/def ::number_style #{"decimal" "percent" "scientific" "currency"})
(clj.spec/def ::prefix string?)
(clj.spec/def ::suffix string?)

(clj.spec/def ::column-setting-v1-date-format
  (clj.spec/keys :req-un [::date_style ::time_style ::time_enabled]
                 :opt-un [::column_title]))8

(clj.spec/def ::column-setting-v1-number-format
  (clj.spec/keys :req-un [::decimals ::number_separators ::number_style]
                 :opt-un [::column_title ::prefix ::suffix]))

(clj.spec/def ::column-setting-v1-value (clj.spec/or ::date-column-format ::column-setting-v1-date-format
                                                     ::number-column-format ::column-setting-v1-number-format))

(clj.spec/def ::column_settings (clj.spec/map-of ::column-setting-v1-key ::column-setting-v1-value))

(clj.spec/def ::visualization_settings (clj.spec/keys :opt-un [::column_settings]))

