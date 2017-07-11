**Welcome to 'Janusz na wakacjach' game!** 

This project is about exercizing creating a game and practicing writing unit tests (or other) for it. 

Technologies
------------

This project can be developed on any platform. It needs for development: 
 * Java 
 * Maven 
 * JUnit 
 * Hamcrest

For running it needs: 

 * OS X / Linux
 * Java installed

NOTE: it runs on Windows but looks crap and arrow buttons don't work. 


Where are docs
--------------

Under [docs/](/docs) folder.


How to setup
------------

Clone github repo:

    git clone https://github.com/QAtrain/janusz-na-wakacjach.git


How to open in IntelliJ
-----------------------

Open IntelliJ > **File > New > Project from Existing Sources... > Choose janushgame module > Maven > select "Search for projects recursively" and "import Maven projects automatically" > Next > Next** 


How to build
------------

    cd janushgame
    mvn clean install


How to test
-----------

    cd janushgame
    mvn clean test
    
    
How to create a jar
--------------------

    cd janushgame
    mvn clean package


How to run
==========

Note: game needs real console. In case you are in GIT Bash / IntelliJ console you will be alerted with a msg about fake console. Real console is for example Terminal on Mac OSX. 

### From command line

After building and running tests - from classes directory (`./target/classes` when building using IntelliJ):

    java -cp . com.qatrain.janushgame.Game
    

### From command line using jar

On Linux / \*nix / OSX system run from module directory: 
    
    cd janushgame
    mvn clean package
    clear
    java -jar janushgame-<version>.jar
    
For example: 
    
    java -jar janushgame-1.0.jar


Issue tracker
=============

Check out [Trello](https://trello.com/b/9wxF1KN5/weekly-janusz-planing).
