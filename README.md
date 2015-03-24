# ScaffoldGDX

ScaffoldGDX is a game development framework built on top of libGDX which follows an MVC or Model-View-
Controller design pattern and streamlines production of large scale games.

The MVC design pattern means that every object is a collection of three separate objects, a
modelObject which holds all the information about its state, a viewObject which holds information
about drawing it to the screen and handles drawing, and a controlObject, which handles interfacing
with it. This is convenient if, for example, you want to save the game's state, or serve it over a
network and let the client handle rendering, or if you want to change the way it's displayed in
different situations while keeping the state constant.

ScaffoldGDX uses a custom scene graph for holding its game objects, called ObjectNodes.
Before drawing, ObjectNodes are sorted by their z coordinate and then rendered according
to the painter's algorithm.

ScaffoldGDX tries in general to maintain an Ask, Don't Tell attitude towards objects, meaning
objects tell each other what to do, rather than asking them about their state to make decisions for
them. This is enforced where practical. However, viewObjects do ask their modelObjects about their
state in order to make decisions about how to draw themselves. This is to maintain separation of
the model from the view. The framework prioritizes maintaining MVC over enforcing Ask, Don't Tell.

## Installation

Simply git clone the project into a directory on your computer, import it into your favorite IDE,
and you're done. Optionally change directory names to suit your project.

## Usage

A simple Snake game is included with ScaffoldGDX as an example of its usage.

## License

Licensed under the Apache 2 license just like libGDX, meaning you can do anything with it that you
can with libGDX itself.