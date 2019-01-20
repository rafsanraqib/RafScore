# RafScore
This program has a GUI that prompts the user to enter the name of the player, how many matches the player has played and how many runs the player has scored in the corresponding match. After entering all the fields the user can press "Done". After clicking done the program will connect to the database and save all the records in the database. 

Database 
The database will have four fields. Player Name, Matches, Runs and Average. Each time the user enters information in the GUI the feilds in the database will be updated accordingly. The last field, average will calculate the average of eah player by using the total number of matches and the total number of runs scored. This will always provide the current average of every player.

Database Connectivity
The program uses the java.sql library to connect and execute queries in the database. I used Xaamp to connect to mysql server and then created a table with the four different fields "Player Name" , "Matches", "Runs", and "Average". 

Sockets
I utilized java sockets to transfer the entries of the user from the GUI.java file to the server.java file. The server was then responsible for establishing a connection with the database and updating all the records.   







