

# EmberRootZoo [![](http://cf.way2muchnoise.eu/273711.svg)](https://minecraft.curseforge.com/projects/emberroot-zoo) [![](http://cf.way2muchnoise.eu/versions/273711.svg)](https://minecraft.curseforge.com/projects/emberroot-zoo)

Minecraft mod written in Java using the Minecraft Forge API.

Includes some open source code by Elucent and CrazyPants.  See citations within the repo as well as in the code.

-------------------------------------------
Desired ROTN Changes
-------------------------------------------
1. Done: All fae mobs have bugged targeting - when they lose aggro, they just circle back and forth endlessly and do not return to wandering They just glide back and forth endlessly, unable to stop targeting their nonexistent target.
2. Done: The Sprite Projectile needs a clearer sound effect/slower travel time for quality of life (can replace empty sound files. can change speed in config)
3. Done: Config to disable taming faeries with glowstone
5. Done: [If possible] New AI/behavior for Guardian of Sprites: Faster at lower health (can change speed in config)
4. Done: Sound tweaks: for fairy, sprouts, sprite projectile, golem (can replace empty sound files)



-------------------------------------------
Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "unrenamed" MCP source code (aka
srgnames) - this means that you will not be able to read them directly against
normal code.

Source pack installation information:

Standalone source installation
==============================

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: Once you have a command window up in the folder that the downloaded material was placed, type:

Windows: "gradlew setupDecompWorkspace"
Linux/Mac OS: "./gradlew setupDecompWorkspace"

Step 3: After all that finished, you're left with a choice.
For eclipse, run "gradlew eclipse" (./gradlew eclipse if you are on Mac/Linux)

If you preffer to use IntelliJ, steps are a little different.
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Once it's finished you must close IntelliJ and run the following command:

"gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)

Step 4: The final step is to open Eclipse and switch your workspace to /eclipse/ (if you use IDEA, it should automatically start on your project)

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not effect your code} and then start the processs again.

Should it still not work, 
Refer to #ForgeGradle on EsperNet for more information about the gradle environment.

Tip:
If you do not care about seeing Minecraft's source code you can replace "setupDecompWorkspace" with one of the following:
"setupDevWorkspace": Will patch, deobfusicated, and gather required assets to run minecraft, but will not generated human readable source code.
"setupCIWorkspace": Same as Dev but will not download any assets. This is useful in build servers as it is the fastest because it does the least work.

Tip:
When using Decomp workspace, the Minecraft source code is NOT added to your workspace in a editable way. Minecraft is treated like a normal Library. Sources are there for documentation and research purposes and usually can be accessed under the 'referenced libraries' section of your IDE.

Forge source installation
=========================
MinecraftForge ships with this code and installs it as part of the forge
installation process, no further action is required on your part.

LexManos' Install Video
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

For more details update more often refer to the Forge Forums:
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html
