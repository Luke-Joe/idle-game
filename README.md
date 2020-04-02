# Farming Simulator

## Project Proposal

The application is going to be a **clicker/idle game** that revolves around hitting minions. Defeating a minion gets you
gold which can be exchanged to add new champions and items to your arsenal that assist you in doing more damage to minions. 
As the game progresses, the minions health pool increase as well as the gold dropped. 

This is a game that could be used by *anyone* who has spare time.

The project is of interest to me as I want to develop games and clicker games have a significant playerbase while being relatively simple. 
I have also put my own spin on the genre by correlating it to minions, which I have a deep hatred for.


##User Stories
- As a user, I want to be able to add an item to my arsenal
- As a user, I want to be able to remove an item from my arsenal
- As a user, I want to be able to view my balance
- As a user, I want to be able to view a list of items that can be bought
- As a user, I want to be able to click on a minion to hit them
- As a user, I want to be able to purchase units to hit minions for me
- As a user, I want to be able to save my items as well as the gold I have earned
- As a user, I want to be able to load the game with all my progress stored from the last save

##Instructions for Grader
- Clicking the "Create New User" button creates a new save with the input username. Clicking the "Load Save"
button loads an old save with the given username.
- Once ingame, clicking save will save the users data
- Click "Shop" and then "Buy" and then select a buyable item to add that item to the players inventory
- Click "Shop" and then "Sell" and then select an item in your inventory to sell that item and remove it from the players inventory
- Buying an item in the shop will play an audioclip 

##Phase 4: Task 2
- I implemented the first option (Test and design a class that is robust).
- This was implemented in the Player class, specifically in the buyItem method. 
- The method was adjusted to throw a "cannotBuyException" if a situation was encountered
  in which the item cannot be bought (inventory is full or balance is too low).


##Phase 4: Task 3
- I noticed that the Shop class was performing the functionality of playing a sound. This is 
  an example of poor cohesion, as the Shop class should solely revolve around the buying of items.
- To improve cohesion, I created a new Sound class that has the proper setup and methods (previously in the shop class)
  to play a wav file given the file name. 

- Looking at the Game class in ui, I noticed that there was a click method for what occurs when a minion is attacked.
  Within this method, there is code that appears to be exactly the same as the onKill method in Player. The method also has the same
  functionality as the onKill method in player. 
- To fix this problematic coupling, I replaced it with the onKill method, which changes the fields in player accordingly following a minion kill.

- Within many classes in gui, including Decision, MainMenu, and Sell, I noticed that one method was performing most of the work in setting up both the
  JFrame as well as the JPanel. To increase method cohesiveness, I refactored the panel setup code into a separate method. 


