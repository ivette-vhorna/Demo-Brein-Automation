# Demo-Brein

Configurations in Eclipse:
___________________________

The tools used to automate eclipse
The configurations that must be made before executing the project are the following:

Project->properties->Libraries->add Jars
|
-> /src/test/resources/ejecutables/ATUTestRecorder_2.1.jar
-> /src/test/resources/ejecutables/ATUReporter_testNG_2.1.jar

Configurations in Project:
___________________________                                   
LoginTest->beforeClass()-> loginPage.chromeDriverConnection("L");
| "L" = Linux
| "W" = Windows
