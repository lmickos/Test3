Product properties implementation
=================================

Problem
-------
A product can have many different types of attributes, and they can vary
between products, e.g. a Bike can have the following attributes:
{price, color, size} and the product Kitchen table:
{price, width, depth, height}.

Product Attributes are organized in a hierarchical group structure, where a Product Attribute Group can contain one or several Product Attributes and/or Product Attribute Groups.
Write the code needed in java to handle the above described products and a print function that prints the data in such a way that it is clear which attributes belong to which product and which attribute group if any.

Note that the order of attributes and groups are important!

Solution
--------

The solution creates a Product class enclosing the attributes
(AttributeProductProperty) and attribute groups
(AttributeGroupProductProperty) that are separate classes inheriting a
common property class (ProductProperty).

Product exposes a print Print service based on a Print action class
(PrintVisitor) that utilizes a variant of the well known Visitor
pattern (GOF). Utilizing this pattern and a generic interface
(ProductPropertyVisitor) the class is prepared for further expansion
of new services acting on the hierarchy.

The visitor pattern also makes it easy to do JUnit testing with the help
of Mockito e.g. ensuring the correct order of execution in traversing
the tree.

The code was developed using the TDD methodology. Tests were written
first and thereafter the code was imp+lemented.

Project build has been made using Gradle and includes complete build
files for project build using gradle (including a gradle wrapper).
However, the project should be easy to import into any IDE for running
(It was developed using IntelliJ IDEA).

Running
-------
The code has been written to build and run on most modern versions of
Java, but has only been tested to run using a Java7 and a Java8 JDK.
Dependencies may incur further limitations for earlier versions.
JDK8 is recommended.

To build and run the code with the given example all you have to do is
execute:
```
gradlew run
```

If you just want to do a clean build
```
gradlew clean build
```


Testing
-------
There are currently two JUnit test classes in the code. Although they
do not cover every method of the enclosed classes they have been designed
to test all the complex methods and functionality meaningful for the
overall task. Simple methods and classes (e.g. POJO getters and setters)
have not been priotirized, in order to keep the time budget reasonable.

However, the indirect use of methods and classes should prove to give
a decent code coverage.

Extensibility
-------------
The implementations have been made with the notion of possibilities of
future extensibility. If this would have been intended as a one-time use
code the structure could have been more simple and condensed at the
prize of extensibility.

* The visitor pattern and the generic interface makes implementations of
other actions over the structure easy.
* More Junit tests could be added so that all classes have their own
set of test methods.


