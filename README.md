# ScaffoldGDX

ScaffoldGDX is a game development framework built on top of libGDX which follows an MVC or Model-View-
Controller design pattern and streamlines production of large scale games.

The MVC design pattern means that every object is a collection of three separate objects, a
modelObject which holds all the information about its state, a viewObject which holds information
about drawing it to the screen and handles drawing, and a controlObject, which handles interfacing
with it. This is convenient if, for example, you want to save the game's state, or serve it over a
network and let the client handle rendering, or if you want to change the way it's displayed in
different situations while keeping the state constant.

Scaffold GDX uses a custom scene graph for holding its game objects, called ObjectNodes.
Before drawing, ObjectNodes are sorted by their z coordinate and then rendered according
to the painter's algorithm.

## Installation

TODO: Installation process

## Usage

TODO: Usage instructions

## License

TODO: Write license