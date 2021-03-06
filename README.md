Program related instructions:

->>Import the project on Intellij and run the main method in Main class

->> main method is in Main class which calls the Client class.

->> Client class is where 3 usecases are added.
    usecase 1: Between Human and Computer(Sequence engine)
    usecase 2: Between Human and Computer(Random engine)
    usecase 3: Between Human and Human
    Since this is a client, you can comment out any two use cases out of the three. 
    
->> GameController class controls the gaming aspect of a game.

->> Symbol class instead of free text.

->> Game attributes like status and result are encapsulated in GameStatus and GameResult classes.

How to play:

Each cell is represented using 2 numbers.

->> Top left cell is 0 0 

->> Centre cell is 1 1

->>Bottom right cell is 2 2

Referring Tic-Tac-Toe to T3.

->> Preferred super-type(interface) to Concrete implementations to add flexibility.

->> PlayerSpec is introduced to provide attributes specific to the game for an player which includes his preferred symbol for that game.

->> Used strategy design pattern for implementation of T3 engines, this will allow us to add new T3 engines without making code changes.
This helps us to adhere to the principle of open closed principle.

->> Currently, the rules are hardcoded. We could decouple the rules in the GameController. We could let all the rules to implement
 an interface(isSatified()) and then run the associated rules using this interface method. The same holds for the win conditions.
 In fact, if there is anything that is bound to change then it would be better we encapsulate it.
