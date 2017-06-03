# Simplechatapplication
Simple example demonstrating chat application on console using redis pubsub


## Licensing

The files in this repository are, unless stated otherwise, released under the Apache License. You are free to redistribute this code with or without modification. The full license text is available [here](http://www.apache.org/licenses/LICENSE-2.0).


## Description

Simple example demonstrating chat application on console using redis pubsub.

Upon execution it creates a new channel with argumented username and subscribe to that channel. If any new messages published for this channel name it will be shown on the console.
User can also reply to that message using username and their message.


## Dependencies and Installation

Ensure Maven is installed. If it is not installed this can be done through from their [website](https://maven.apache.org/).

Clone this repository:
```term
$ git clone https://github.com/realjam/simplechatapplication.git
```

Change directory into the application and use `maven` to install the application's dependencies:
```term
$ cd simplechatapplication
$ mvn install
```

## Running the application

* Run the redis server in background
* Execute the Main.class file with argument <username>.