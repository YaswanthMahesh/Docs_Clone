

Whenever we are using the fetch in the window unload , it will kill all the network operation. 
Because of that, any asynchronous call will not be executed properly. To execute it we need to use 
**keepalive: true** to make that operation run in the background