# NBAManager

## NBA fantasy league system

This is an application that creates sports fantasy league particularly Basketball.
People can now create their own fantasy clubs, play in leagues and can get 
to the leaderboard by getting player and club points.

This is the menu for the code:
- Create a new club and adds it to the fixtures 
- select a club and add a new player to that club
 #####  - When adding a new player, another menu is described further : 
           - It asks to add the player's position, like Center, Small Forward, etc
           It then asks the user to enter number of baskets and assists.
- Displays the list of clubs in the league
- Enter the player name and check the player's points
- Enter the club name and check the points for the club 


In this application, the user stories are as follows:

1) As a user, I want to create my fantasy club (myClub) and add it to the list of clubs (fantasyClub), 
i.e the fixtures.

2) As a user, I want to select a club, and my fantasy player to that club.
   When I would add my player, it would further display me a menu with the player positions. 
   This is because players would different positions would be having different individual points. 
   It, would then ask me to add the number of baskets and assists made on the basis of which it would calcuate the
   player's points. 
   
3) As a user, I want to select a club, and then choose a player from it and display it's points in the fixtures.
   I would search up the club in the list of clubs, extract the club name and then further search up for the player name 
   in order to get the player's points.
   
4) As a user, I also want to display the club's points in total by selecting a club from the list of clubs in the
fixtures. My total club points would be based on the sum of the individual player's points present in the club.



  #####  - This is phase 2 of the project, where the program is using JSON:
  
  => The User stories for phase 2 are as follows.
  1. The program saves the list of clubs in myLeague where myLeague manages the fixtures.
  2. Another user story is that the program can also load the data from the previous save and can then make updates/
     changes in the NbaMangaer and then save the updated version.
     
  #####  - This is phase 3 of the project, where the program is using GUI:
  This is the 3rd phase of this project. A Basic GUI has been implemented along with save and load features.
  These are the following user stories : 
  
  - Create a new Club and add it to the fixtures.
  - Add player to a club.
  - Display the list of clubs in the fantasy league,
  - Show Player Points 
  - Show club points  
  - Save the league 
  - Load the league. 
  
  One interesting feature this phase holds is that a set of sound effects were added on pressing of the buttons. 
  
  1) As a user, I want to create my fantasy club (myClub) and add it to the list of clubs (fantasyClub), 
  i.e the fixtures.
  
  2) As a user, I want to select a club, and my fantasy player to that club.
     When I would add my player, it would further display me a menu with the player positions. 
     This is because players would different positions would be having different individual points. 
     It, would then ask me to add the number of baskets and assists made on the basis of which it would calcuate the
     player's points. 
     
  3) As a user, I want to select a club, and then choose a player from it and display it's points in the fixtures.
     I would search up the club in the list of clubs, extract the club name and then further search up for the player name 
     in order to get the player's points.
     
  4) As a user, I also want to display the club's points in total by selecting a club from the list of clubs in the
  fixtures. My total club points would be based on the sum of the individual player's points present in the club.
  
  #####  - PHASE 4 : TASK 2
  
  1. For my project I opted for option 1, that is test and design a class in the model package that is robust. In my 
  Club class, I had a requires clause in my addPlayer method where a club cannot consist of more than 6 players. To make 
  this class robust, I created a ClubFullException that is caught whenever a team exceeds 6 players.
  
  
  #####  - PHASE 4 : TASK 3
  
  -> One of the things that I could have done to make my project better is that I could have included HashMap. For this 
     project, I used LinkedList to depict my squad, that is a list of Players in my team. 
     
  -> A HashMap provides the basic implementation of the Map interface. It stores the data in (Key, Value) pairs, and you can access them by index of
     another type. 
     
  -> Furthermore, a Hashmap stores unique values that can be helpful for me while adding the names of the 
     players in my squad since each player in the NBA playoffs have a unique name. 

