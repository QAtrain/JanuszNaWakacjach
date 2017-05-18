**Welcome to 'Janusz na wakacjach' game!** 

This project is about exercizing creating a game and practicing wrtiting unit tests (or other) for it. 

## Technologies 

 * Java 
 * Maven  


## Where are docs

Under [docs/](.docs) folder.


## How to setup 

Clone github repo: 

    git clone https://github.com/QAtrain/janusz-na-wakacjach.git


## How to setup in IntelliJ

Open IntelliJ > **File > New > Project from Existing Sources... > Maven > select "Search for projects recursively" and "import Maven projects automatically" > Next > Next** 


## How to run

### In IntelliJ

Right click on `MainApp` class and click *Run*.

### From command line
    
From classes directory (`./target/classes` when building using IntelliJ):

    java -cp . com.dxc.gameproject.MainApp

### Maven 

TODO 


## How to test 

    cd gameproject
    mvn clean test
    
    
## How to build 

TODO describe

    mvn clean install
