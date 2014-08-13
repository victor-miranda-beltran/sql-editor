# SQL Editor Portlet

[SQL Editor](https://github.com/victormiranda/sql-editor) is a Liferay portlet designed for interacting with your portal's database.

You don't need to have direct access to your DB Machine, the connection is got from portal infraestructure.

## Compatibility.
At this time, this portlet works with Liferay 6.2 and these DBs:
- MySQL
- Oracle (tested with 10G)
- Postgres
- Hypersonic DB

If your DB is not included, you can contribute writing a new SQLDialog. Its very simple

This portlet has been tested on Chrome 36, Safari 8.0 and Firefox 31

## Usage

### Option 1 - Download from Liferay Marketplace (ASAP)
This portlet will be located in [Liferay Marketplace](http://www.liferay.com/marketplace). Now it is validation process.

### Option 2 - Download from here and deploy
You can download the war file from github [WAR] (https://github.com/victormiranda/sql-editor/blob/master/dist/sql-editor.war?raw=true) and set it in DEPLOY folder.

### Option 3 - Fork and build
You can fork this repo and build the portlet using the Liferay SDK

##Access in portal
You can access this portlet in Control panel - Configuration - SQL Editor

## Some tips
You can launch queries with shortcut <kbd>CTRL</kbd> + <kbd>INTRO</kbd> or <kbd>&#8984;</kbd> + <kbd>INTRO</kbd>. More shortcuts will be added.

## Screencast
![sql editor](https://raw.githubusercontent.com/victormiranda/sql-editor/master/screenshots/screencast.gif)

# Project status
This project is under heavy development, so new features will be added ASAP. If you want to contribute, go ahead :D

## Features

### Autocomplete table names
![sql editor](https://raw.githubusercontent.com/victormiranda/sql-editor/master/screenshots/autocomplete.png)


### Save queries as snippets
![sql editor](https://raw.githubusercontent.com/victormiranda/sql-editor/master/screenshots/save-snippets.png)


### Load snippets
![sql editor](https://raw.githubusercontent.com/victormiranda/sql-editor/master/screenshots/load-snippets.png)


### Export results in CSV Format
![sql editor](https://raw.githubusercontent.com/victormiranda/sql-editor/master/screenshots/export-csv.png)
