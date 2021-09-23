# WORLDSENSING Sensor Data Processor

## Program is build to store records from Sensors.
Additionally program modifies messages received from Sensors to make it more readable.
Program read messages from JSON files.
Program save messages as JSON files.

## Help
Pass the path to message (JSON file) as the first command line
argument.

If you want to configure sensor settings use only this Strings:

trim - to trim the payload 
add - to add timestamp to payload
pad - to pad to multiple and fll with "#" sign

do not use white signs, separate strings with coma (eg. "trim,add")


## Authors

Contributors names and contact info

Przemek Stępski  
@ przemek.stepski@gmail.com

## Version History

* 0.1
    * Initial Release
