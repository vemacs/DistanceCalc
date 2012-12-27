DistanceCalc
============

A small plugin that tells users their distance from spawn.

Usage
-----

All the user needs to do is run `/distance`, and it tells the user their 3-dimensional and 2-dimensional distance from spawn.

Permissions
-----------

The permission `DistanceCalc.calc`, which should be given by default, allows the user to check their distance from spawn.

Configuration
-------------

Be sure to edit the `config.yml` to be your spawn's y-position. The Bukkit `getSpawnLocation()` function doesn't do this properly.

Commands
--------

`/distance` reports to the player how far they are from spawn, in both 3-d and 2-d.

Credits
-------

- vemacs, code and idea
