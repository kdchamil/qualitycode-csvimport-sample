# qualitycode
Simple scenario written in an anti-pattern is re-written in quality way.

This program exposes a simple REST API to upload a csv file containing user information in the following pattern.

"Chamil", "83, Quality Road, Sri Lanka",36

The program will then validate the file, each record and convert them into User objects. The user objects will be stored in a database.

The code contains many packages named as com.chamil.qualitycode.v0 and com.chamil.qualitycode.v1
The package ends with "v0" contains the traditional code and the v1 and above are steps towards the final quality code.

##V1 package
the package v1 contains a decoupled code with unit tests covering each class separately.
The classes are SOLID by the design.

The ImportCommand class can be used to import any other data type into another destination storage as well. The only thing 
to do is writing the right mapper, validator and the store classes.

Just implement a new DataSource class if you want to change from CSV to excel or any other data type. 

## Disclaimer
This code is purely a demonstration of clean code. It is not well tested. You are invited to test it for all possible unhappy paths. 
