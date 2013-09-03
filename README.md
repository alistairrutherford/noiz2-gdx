noiz2-gdx
=========

Noiz2 - Vector Shoot Em Up

This is my original port of Kenta Chos esoteric shooter converted to use LibGDX and my netthreads-libgdx extensions library.

It's very much a work in progress. Not all the original features have been added yet.

The codebase consists of a slightly modified set of the original game files (in their own package) and all the additions in another package.


My original contributions were:

- rewrite the bulletml parser to use XML Pull parser. This was so it would work with Android.
- abstract the drawing primitives to ease the application of different rendering modes.
- OpenGL and Canvas renderers because I was being bloody minded.
- difficulty settings as the original on a phone was insanely difficult (it still is..a bit).

The only renderer now is OpenGL as that's what LibGDX uses.

Now that I have ported it over to use LibGDX it brings some nice additions such as the moving star background and the sliding transitions between screens.

Launch view.

![Demo](https://github.com/alistairrutherford/images/raw/master/noiz2_1.png) 

Main Game

![Demo](https://github.com/alistairrutherford/images/raw/master/noiz2_2.png)


Build Instructions
-------------------

https://github.com/alistairrutherford/noiz2-gdx/wiki/Build-Instructions

License
--------
[Copyright - Alistair Rutherford 2013 - www.netthreads.co.uk]

Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
