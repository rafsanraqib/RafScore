# RafScore
This program has a GUI that prompts the user to enter the name of the player, how many matches the player has played and how many runs the player has scored in the corresponding match. After entering all the fields the user can press "Done". After clicking done the program will connect to the database and save all the records in the database. 

Database 
The database will have four fields. Player Name, Matches, Runs and Average. Each time the user enters information in the GUI the feilds in the database will be updated accordingly. The last field, average will calculate the average of eah player by using the total number of matches and the total number of runs scored. This will always provide the current average of every player.

Database Connectivity
The program uses the java.sql library to connect and execute queries in the database. I used Xaamp to connect to mysql server and then created a table with the name "records" with the four different fields "Name" , "Matches", "Runs", and "Average". 

Sockets
I utilized java sockets to transfer the entries of the user from the GUI.java file to the server.java file. The server was then responsible for establishing a connection with the database and updating all the records.   

Database Entry Logic
To enter a particular record in the database, the server.java file first checks the database to ensure whether records with the same player name exists already. If it does then that record is updated rather then creating a new record. If there are no prior records that exist a new record is created. 

How to run
To run this program, first run the Sever.java file to activate the server. Then run the GUI.java file to pull up the GUI. Fill out all the fields and then click done. To confirm that all the changes are made, go to the shell in Xaamp and then write the command mysql -uroot -p. The system will ask for password. Enter your password and then once you are granted access write the command use records. Then write a select statement to see the records in the database. There are numerous short youtube videos that show how to install and create a database using Xaamp. 







