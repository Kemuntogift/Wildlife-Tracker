# Wildlife Tracker

Wildlife Tracker is an app that allows one to record sightings of various animal,It allows one to create and view animals and sightings.

## Author
- [Gift Kemunto](https://github.com/Kemuntogift)

## Preview
  [![screenshot-from-2022-05-11-07-32-47.png](https://i.postimg.cc/gkyhNY36/screenshot-from-2022-05-11-07-32-47.png)](https://postimg.cc/GH29pn7c)
  [![Screenshot-from-2022-05-12-23-02-48.png](https://i.postimg.cc/SRw750Wv/Screenshot-from-2022-05-12-23-02-48.png)](https://postimg.cc/kRvb6pYQ)
  [![Screenshot-from-2022-05-12-23-14-40-1.png](https://i.postimg.cc/kGBPsScy/Screenshot-from-2022-05-12-23-14-40-1.png)](https://postimg.cc/305qJdzy)
## Prerequisites

- Basic Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK version 11. 
- 
## Setup/Installation Requirements
* Fork this repo
* Clone this repo
* Open terminal
* Navigate to appropriate directory using the cd command
* type in the command git clone and paste the url of clone and then press enter
## Setup Requirements for Database
* In PSQL:
  SET MODE PostgreSQL;
  CREATE DATABASE wildlife_tracker;
  \c wildlife_tracker
  CREATE TABLE sightings (id serial PRIMARY KEY, animalName varchar,location varchar,rangername varchar,lastseen timestamp);
  CREATE TABLE animals (id serial PRIMARY KEY, name varchar,health varchar,age varchar, type varchar);
  CREATE TABLE rangers (id serial PRIMARY KEY,name VARCHAR,badge_number INT);
  CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;## 

* In order to run locally
* Go to DB.class in main/java folder and make necessary changes
* Go to DatabaseRule in test/java folder and make necessary changes

## Technologies Used
* Java
* Heroku
* CSS
* Handlebars
* Maven

### Development

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request

## Known Bugs

If you find a bug, kindly open an issue [here](https://github.com/Kemuntogift/Wildlife-Tracker/issues/new) by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue [here](https://github.com/Kemuntogift/HeroSquad/issues/new). Please include sample queries and their corresponding results.

## Licence
*MIT*
Copyright (c) 2022 **Gift Kemunto**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
