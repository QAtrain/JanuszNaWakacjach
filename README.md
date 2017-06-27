**Welcome to 'Janusz na wakacjach' game!** 

This project is about exercizing creating a game and practicing writing unit tests (or other) for it. 

Technologies
------------

 * Java 
 * Maven 
 * JUnit 
 * Hamcrest


Where are docs
--------------

Under [docs/](../docs) folder.


How to setup
------------

Clone github repo:

    git clone https://github.com/QAtrain/janusz-na-wakacjach.git


How to open in IntelliJ
-----------------------

Open IntelliJ > **File > New > Project from Existing Sources... > Maven > select "Search for projects recursively" and "import Maven projects automatically" > Next > Next** 


How to run
----------

### In IntelliJ

In module `janushgame` right click on `MainApp` class and click *Run*.

### From command line
    
From classes directory (`./target/classes` when building using IntelliJ):

    java -cp . com.qatrain.janush.MainApp
    
### From command line using jar

After building a jar (see below) run from main project directory: 

    java -jar janushgame-<version>.jar
    
For example: 
    
    java -jar janushgame-1.0.0-SNAPSHOT.jar
    

Maven 
=====

How to test
-----------

    cd janushgame
    mvn clean test
    
    
How to build
------------

    cd janushgame
    mvn clean install

How to create a jar
--------------------

    cd janushgame
    mvn clean package


How to try console moves
------------------------

    cd janushgame
    mvn clean test
    clear
    java -cp ./target/classes/ ConsoleMoves
