## World

### Tile layers

The world `.bin` files consist of three tile layers. I personally call them like this:

1. Background - such as the vines in Angkor Wat
2. Player - the layer where the player is, thus these blocks/tiles/entities collide with the player
3. Foreground - decorations in the foreground, such as overlay chains in Bavaria, the buddhas in Angkor Wat, but also
   things like secret paths (you don't see them, but they don't have collisions)

### Background layer tiles

| Num       | Name       | Description                            |
|-----------|------------|----------------------------------------|
| 99 or 255 | Background | The vine background in Angkor Wat, ... |

### Player layer tiles

Source: [my Diamond Rush asset viewer](https://github.com/kubikaugustyn/diamondRush/blob/main/browser/all_files_new/file_types/stages.js)

| Num | Name               | Description                                                                                                |
|-----|--------------------|------------------------------------------------------------------------------------------------------------|
| 0   | Boulder            |                                                                                                            |
| 1   | Violet gem         |                                                                                                            |
| 8   | Bomb               | The Bavarian bomb                                                                                          |
| 10  | Leaves             | Bavaria: cobweb, Siberia: ice block                                                                        |
| 11  | Fireball           | The Angkor Wat/Bavarian fireball entity                                                                    |
| 18  | Trapdoor switch    |                                                                                                            |
| 22  | Fire spitter right | The fire spitter block in Angkor Wat, facing right                                                         |
| 23  | Fire spitter left  | This time facing left                                                                                      |
| 30  | Beans              | The block you cannot break withou a mallet                                                                 |
| 34  | Blue trapdoor      | Opens/closes with the actuation of the Trapdoor switch                                                     |
| 35  | Red trapdoor       | Its opening state is always the opposite of the Blue trapdoor                                              |
| 37  | Bomb cloth         | The Bavarian block you break using a bomb                                                                  |
| 44  | Icicle             | The Siberian icicle that breaks and falls on you when you stand below it                                   |
| 45  | Monkey             | The Siberian monkey that moves in the direction to get to you one block at a time (doesn't do pathfinding) |
| 46  | Wasp               | The Siberian wasp that shoots you with a spear if you're above or next to it (not diagonally)              |
| 47  | Fan pot            | The Siberian fan pot that floats the boulders, frozen entities, gems etc. up in a vertical column          |
| 79  | Spawn point        | The block where the player spawns at (animates arrival from the left), with a locked door to its left      |
| 255 | Nothing            | Air                                                                                                        |

### Foreground layer tiles

Source: [my Diamond Rush asset viewer](https://github.com/kubikaugustyn/diamondRush/blob/main/browser/all_files_new/file_types/stages.js)

| Num | Name                    | Description                                                                 |
|-----|-------------------------|-----------------------------------------------------------------------------|
| 20  | Decoration top left     | The animated 2x2 decoration (Angkor Wat buddha, Bavarian candle chandelier) |
| 21  | Decoration top right    |                                                                             |
| 22  | Decoration bottom left  |                                                                             |
| 23  | Decoration bottom right |                                                                             |
| 34  | Broken icicle           | Doesn't fall at the player                                                  |
| 255 | Nothing                 | Air                                                                         |

### Special combinations

The tables above represent single-layer tiles and entities, but the following are special combinations, mostly chests
and entities, that don't render like the normal 3-layer tiles.

#### Wall tiles

Okay, this one's not really special, but it's dynamic (the game will freeze (not crash) if you place non-existent tile
numbers on the map) depending on the location. The JavaScript for it is simple:

```javascript
const wallTileSprite = (await blocksFileChunks[2].parse()).data.sprite // Block file (0.f for Angkor Wat, etc.), chunk 2
const wallTiles = Object.fromEntries(
    new Array(wallTileSprite.frames.length)
        .fill(0)
        .map((_, index) =>
            [80 + index, wallTileSprite.frames[index].getParsedData(0)]
        )
)
```

Basically, player layer code 80 renders frame 0 of the block file's (`x.f`) second chunk. Block 104 will render frame
no. 24.

This also applies to the foreground layer, with the difference being the player can go into the foreground tiles (if
there isn't an obstacle in the player layer there), whereas the player's blocked by the tile if it is in the player
layer. There can also be 2 tiles layered on top of each other.

Note that some of the wall tiles don't start at the origin of the tile, so they need to be offset by a few pixels here
and there.

#### Checkpoint

- Background: checkpoint index
- Player: most likely ignored
- Foreground: 4
- Rendered background: default background (255)
- Rendered player: Checkpoint
- Rendered foreground: nothing

If the checkpoint index is 0 and the map doesn't contain a Spawn point, this tile becomes the Spawn point.

#### The Great Anaconda

- Background: 0
- Player: 43
- Foreground: most likely ignored
- Rendered background: default background (255)
- Rendered player: nothing
- Rendered foreground: nothing

This is the tile that marks the Great Anaconda should be spawned. The details aren't clear, bosses are only spawned in
one stage.

#### Snake

- Background: direction (1 and 3 are vertical, etc.)
- Player: 19 (normal) or 43 (red)
- Foreground: most likely ignored
- Rendered background: default background (255)
- Rendered player: a snake or spider of the appropriate color, moving in the provided direction
- Rendered foreground: nothing

The snake is rendered as a spider in Bavaria. They're blue in Siberia and green in Angkor Wat. The red variant is
obviously red, but I don't know what it looks like in Siberia.

#### Pressure plate

- Background: door index
- Player: most likely ignored (but probably used for whatever the player moves into the tile in-game)
- Foreground: 6
- Rendered background: default background (255)
- Rendered player: a pressure plate
- Rendered foreground: nothing

The pressure plate opens a door when the player steps on it or when a boulder, gem, frozen entity, etc. is on it.

#### TODO

There are a lot more special cases, but I don't have time today to finish transcribing them all from the code:

https://github.com/kubikaugustyn/diamondRush/blob/6a5f2f7778176c702524bb8fbda30d3f0384edc1/browser/all_files_new/file_types/stages.js#L572-L943