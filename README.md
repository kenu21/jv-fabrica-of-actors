# jv-fabrica-of-actors

Build an application with n‐actors (n can should be specifiable as input to the application).
Each actor should be assigned an id between 1 to n (unique).
In the main program a message should be sent to the actor with id 1.
The message object should contain a field numberOfHopsTravelled (int, initialized to 0).

Actor 1 forwards the message to the actor with id 2 when receiving the message from actor 1,
but before doing so, increases the numberOfHopsTravelled by one in the message.
This continues in this way until the message reaches actor n.
When actor n receives the message, it prints out the numberOfHopsTravelled field in the received message.