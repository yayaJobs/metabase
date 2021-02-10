**Covered in this guide:**



# Running Metabase on Microsoft Azure

This guide will cover the basics for running your Metabase instance in Microsoft Azure thanks to the power and flexibility of Docker Containers. At the end of this guide you will have set up a Metabase instance with its own database, ready to be scaled in case you need more power.

## Components

For Metabase to work you will need:
- A resource group: where you will have all your assets for easy identifying all the components that Metabase has.
- A VNET: a virtual network that hosts Metabase server and it's application database.
- An Azure Database for PostgreSQL server: a database server that Metabase uses as the application database where it saves all its data. This component can be switched to an Azure Database for MySQL if your tune is the MySQL one.
- A private endpoint connection: so database can be accessed from an internal IP address rather than being exposed to the public.
- A web app: a deployment of an application fully managed by Azure, either by an executable or a Docker container.

## Steps

### Step 1: Create the resource group

On the Azure management console, click on the **Resource Groups** icon at the top of the page or search for Resource Groups to enter that section. If you have a resource group already created, you can skip this step and go straight to [Step 2](#step-2-create-the-network).

On the resource group page, click on the **+ Add** button in the top bar to create a new resource group. On the **Create a resource group** page that opens, select your valid Azure Subscription, enter a resource group name and select a region.

![Create a Resource Group](images/AZResource_group_Add.png)

__NOTE__: remember that you need to select the region for your Metabase instance according to the location of your users, data warehouse and even the cost of the infrastructure of the region or privacy laws that might restrict cross-border data transfers.

### Step 2: Create the network

### Step 3: Create the database

### Step 4: Create the private endpoint connection

### Step 5: Create web application