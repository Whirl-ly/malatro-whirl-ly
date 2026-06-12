# Entrega Parcial 6 | Entrega Final Tarea 2
This document details important information about the taken decisions to approach 
the requirements described on the ``EP6-EF2`` statement.

## Organization of the code

The code has been organized in this way:
- Each distinguishable property of a card has been assigned to a package/folder
- Each package/folder contains:
  - A trait
  - Classes
  - Abstract classes (if necessary)
  - Sub-packages (only when it's possible)¹

Also, the only files that are excluded from this type of organization are 
[Score Class](src/main/scala/EF2/Score.scala) & [Card Class](src/main/scala/EF2/Card.scala), because they don't follow Trait's rules.

<small>¹: Only when certain classes inside a package have common features.
Take [Straight Combinations](src/main/scala/EF2/combinations/straights) and
[Other Combinations](src/main/scala/EF2/combinations/otherCombinations) packages as examples </small>



## Relevant design decisions 

### 1. [Combinations](src/main/scala/EF2/combinations) package
#### About the code duplication problem:
Code duplication was noted on the ``validate()`` method inside each class during the construction/abstraction stage of the package.
This problem emerged due to the similarities of each combination type. 

For example:

-  [StraightFlush](src/main/scala/EF2/combinations/straights/StraightFlush.scala) is a stricter variant of 
[Straight](src/main/scala/EF2/combinations/straights/Straight.scala). 
(same reason why these classes were integrated in the same subpackage)

- The only difference between [Trio](src/main/scala/EF2/combinations/otherCombinations/Trio.scala) and 
[Pair](src/main/scala/EF2/combinations/otherCombinations/Pair.scala) 
classes is the number of cards that describes each combination respectively.

The proposed solution to this problem in my repo consists in the creation of an abstract class: [CombinationBase](src/main/scala/EF2/combinations/CombinationBase.scala),
which contains every method that was causing code duplication conflicts.


#### About the ``ResolveHand.scala`` package:
During the construction of the package, an important question emerged: **¿how can I handle conflictive combination cases 
without a "priority" property on each combination type?**

The best answer that I could think of was creating a new class by composition:
``ResolveHand.scala``. Said class initializes each combination type and validates them in the order specified on the
``EP2.md`` file. 

The downside of this approach is that we have to use this specific class to resolve conflictive cases 
instead of the already defined ``validate()`` methods inside each class.
### 2. ``ranges`` package
I took a specific decision about the ``clasification`` property inside this package. 
Instead of defining a different trait to abstract the behavior, I took a simpler approach by defining 
the type of ``clasification`` as a string.


### 3. ``Hand.scala`` class and ``ListOps.scala`` object
#### About code duplication:
During the phase of construction of methods inside this class, code duplication was noted.

To prevent that problem, I decided to create a sePairate object (``ListOps.scala``) which contains general methods 
(specifically ``addElem`` & ``removeElem``). This is so we can add card or joker card types to a hand without worries.

This approach is different from the already seen one in the ``combinations`` package. 
The reason behind this is that I determined that it wasn't necessary to create an abstract class since it was a 
singular file that was having this problem.

Therefore, I concluded that creating an abstract class would have added unnecessary complexities.

#### About mutable lists:
To accomplish the objectives of this delivery, I decided that using mutable list's (instead of immutable ones) to 
add cards/jokers to a hand was the optimal solution overall.

This decision was made because of the nature of the game that we are modeling (Balatro). Creating new immutable list's each time a card/joker is added to a hand doesn't make 
any sense, it would be a waste of memory and players won't need a history of the hand's played during rounds (which is
the only reason that I could think of that we would desire to use immutable lists).  
### Design patterns
Throughout the process, certain design patterns appeared on the files:
1. Using trait as a contract: Different classes implement the same contract. 
2. Abstract Classes for shared code: Reutilizes common logic in subclasses.
3. Generic methods: Solution for multiple variable types with common logic (``Hand.scala``)
4. Composition: Used in ``ResolveHand.scala`` class
5. Mutability in card/joker lists


### About the organization of the testing files
The test's files has been assigned to the [test](src/test) package to provide better code-reading to the user reviewing
the repo. The classes inside consists of:

1. [ScoreTest](src/test/scala/ScoreTest.scala): Contains test's for constructing, accessing, modifying and comparing
   Score properties (such as chips and multiplier)
2. [RankTest](src/test/scala/RankTest.scala) & [SuitTest](src/test/scala/SuitTest.scala):
   Contains test's for constructing, comparing and verifying applyScore method's for both classes respectively.
3. [CardTest](src/test/scala/CardTest.scala) & [JokerTest](src/test/scala/SuitTest.scala):
   Contains test's for constructing and comparing these cards properties respectively.
4. [HandTest](src/test/scala/HandTest.scala): Contains test's for constructing, playing & discarding methods,
   adding & removing cards/jokers. 

   Those Hand test's considers exception handling too
   (like [MaxPlayCountException](src/main/scala/EF2/exceptions/MaxPlayCountException.scala) for example).
    

