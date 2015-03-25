# ScaffoldGDX

ScaffoldGDX is a game development framework built on top of libGDX which follows an MVC or Model-View-
Controller design pattern and streamlines production of large scale games.

### Design Philosophy
The MVC design pattern means that every object is a collection of three separate objects, a
modelObject which holds all the information about its state, a viewObject which holds information
about drawing it to the screen and handles drawing, and a controlObject, which handles interfacing
with it. This is convenient if, for example, you want to save the game's state, or serve it over a
network and let the client handle rendering, or if you want to change the way it's displayed in
different situations while keeping the state constant.

ScaffoldGDX tries in general to maintain an Ask, Don't Tell attitude towards objects, meaning
objects tell each other what to do, rather than asking them about their state to make decisions for
them. This is enforced where practical. However, viewObjects do ask their modelObjects about their
state in order to make decisions about how to draw themselves. This is to maintain separation of
the model from the view. The framework prioritizes maintaining MVC over enforcing Ask, Don't Tell.

### SceneGraph
ScaffoldGDX uses a custom scene graph for holding its game objects, called ObjectNodes.
Before drawing, ObjectNodes are sorted by their z coordinate and then rendered according
to the painter's algorithm.

### ControlSettings
The ControlSettings system allows one to easily configure control settings both through hardcoding
them and also programmatically at runtime. It allows multiple keys set to the same function, the same
key set to different functions, an unlimited number of functions, and also prevents bugs in which
multiple keys with the same function multiply intended behavior.

## Installation

Simply git clone the project into a directory on your computer, import it into your favorite IDE,
and you're done. Optionally change directory names to suit your project.

## Usage

A simple Snake game is included with ScaffoldGDX as an example of its usage. As the framework is
built around MVC, it doesn't make use of any of libGDX's Scene2d classes except for UIs (loading
screens, menus, etc.). As such, when developing on top of ScaffoldGDX, avoid use of anything in
Scene2d (stage, actor, etc.) as well as the Sprite class, as all of these mix the model with the
view.

## License

Licensed under the Apache 2 license just like libGDX, meaning you can do anything with it that you
can with libGDX itself.