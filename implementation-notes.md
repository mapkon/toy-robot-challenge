# Introduction

These are my short implementation notes on some of the decisions I made during the exercise. I am happy to go over these decisions in depth on a call or if there is need to answer on email.

Please turn on word wrap before reading the doc.

## Testing

The over arching theme I use for normal development cycle is to write tests before anything. Since I do not want to be married to any design, I will always start with the simplest of tests to
assert the existence of the interface that I intend to design. Which explains why in the tests, the first test is to assert `nullity`:

 ` assertNotNull(foo.method()) `

I use this for two reasons:

1. As an exploration mechanism regarding where I want to go. Instead of bogging down my code with design, I use the tests to drive the design of the code I am writing
2. I use the tests as a structure to document how I arrived where I am, with every subsequent test adding onto the previous existing functionality.

My aim is to help the maintainer look at the code and reason about my decisions, hopefully with the same mind and arc like I did.

And also, just as a class should do one thing, a method one thing, I also make the test test one thing, meaning one assert per test. Yeah, I am that creepy about tests.

# Design

This was a tough one, but I will document the major decisions I made.

## Robot

I created an interface with defines a contract for any robot that the system will interact with. This forces me to design to a contract as opposed to a concrete implementation,
but it farther allows me to switch out the current robot, for another.

For example, say that we want to implement an intelligent robot that cannot fall off the table when it is given a wrong coordinate. We would just have to implement the interface
and define a new Robot that reasons about the position in a much more intelligent manner, and the calling code and tests would not really have to change much since they are
pegged to an interface.

## Surface

The surface is what the robot is moving on, so I was torn between making the surface aware of the robot or the robot aware of the surface. The second option seems more invasive to me
since naturally, the entity (like a person) is aware of the surface, which for most of the time is a dumb inanimate thing.

Similarly, the surface had to be abstract to be switchable. I imagine that the surface can be switched to something like a round surface (maybe a robot that is on a pod). This forced me to extract the validation to the surface (since another surface like a round one would have to account for radius boundaries)
as opposed to shoe horning it in the Robot or position, since the robot should not care about the boundaries of the surface, it should just care where it is, only validating a position when it should move.

## CommandFactory

I did not want the caller to have to case code on the command for execution, rather, it seemed extensible to me to provide an interface that allows a command to be executed, returning the Robot that has been modified.
Thus, I went for the command factory pattern for this implementation. It seemed to me at first to use the visitor pattern, visiting the particular Robot with a command algorithm, but on implementation, that seemed overkill.

## Direction

Similarly, Left and Right are inversely proportional (in that they turn the robot 90 degrees), which if approached in that matter lends itself naturally to bundling them in the same file and checking if it is left or right before performing an action.

However, I have a strong dislike to case coding because I think it is a code smell, which informed my separation of left and right concerns into different files, with one extending another but composing its functionality to fit the DRY principle.

## Things that I would do differently

- Implementing and dealing with obstacles.
- Implement the intelligent robot, as it seems a nice challenge.
- Implement another surface to see how far we can probe the app in that Direction
- Refactor the MoveCommand execute method, it is too large and the switch statement looks ugly

## Robot notes

- READ FROM file
- LOG Each Command starting with name (on surface and replay)

- Intelligent robot that cannot exceed boundaries

  - When at end of EAST, MOVE SOUTH || WEST || NORTH
  - When at end of SOUTH, MOVE WEST || NORTH || EAST
  - When at end of WEST MOVE NORTH || EAST || SOUTH
  - When at end of NORTH, MOVE EAST || WEST || SOUTH 

Happy reviewing.
