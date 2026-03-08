# Java Planner CLI

A command-line planner application written in Java to practice object-oriented design and basic file persistence.

## Features

* User registration and login
* Persistent user storage (`users.dat`)
* Persistent task storage (`tasks.dat`)
* Add tasks with deadlines
* View all tasks
* Mark tasks as complete
* Remove tasks
* Simple CLI menu interface

## Project Structure

```
Planner
├─ src
│  ├─ Main.java
│  ├─ User.java
│  ├─ UserManager.java
│  ├─ Planner.java
│  └─ Task.java
├─ plan.txt
└─ README.md
```

## How It Works

* `UserManager` handles user registration and login.
* `User` owns a `Planner`.
* `Planner` manages a list of `Task` objects.
* Tasks and users are saved using Java object serialization.

Files created automatically when running:

```
users.dat
tasks.dat
```

## Compile

```
javac src/*.java
```

## Run

```
java -cp src Main
```


