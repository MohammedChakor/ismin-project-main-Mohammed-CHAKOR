Part of Android & Web Development - ISMIN 2021

Course followed by students of Mines St Etienne, ISMIN - M2 Computer Science.

[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

# Project template

This project template contains:
 - a skeleton NestJS app in `api`  (can be opened in Webstorm, Visual Studio Code etc)
 - a skeleton Android app in `android` (can be opened in Android Studio)
 

__________________________________________________________________________________________


This project only contains an Android app that collects an open source database of tributes to WWII heroes in Paris using JSON kotlin integrated functions, and displays them in a list with clickable items to show details and it also displays them in a map.
The dataset link : https://opendata.paris.fr/api/records/1.0/search/?dataset=plaques_commemoratives_1939-1945&q=&rows=100&exclude.precision_adresse=NULL&exclude.datasetid=NULL&exclude.recordid=NULL&exclude.commemore=NULL&exclude.xy=NULL&exclude.adresse_complete=NULL
/n
The Kotlin/XML files for the Android app are located in the "android" directory.

Running the app:

To run the app, you can open the "android" directory as a project on Android Studio, and run it on a virtual Android device, or directly on your Android smartphone by allowing the USB Debugger configuration in the Android Developers settings.
In the app, you have access to the list, you can click on items to see more details. You can also see the location of the different items on the map.
One bug that has been noticed is the app that crashes when we go way down in the list (i assume its a ressources problem). /n
Credits :
Mohammed CHAKOR
