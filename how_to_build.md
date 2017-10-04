1. Download [ikvm.exe](https://netcologne.dl.sourceforge.net/project/ikvm/ikvm/7.2.4630.5/ikvmbin-7.2.4630.5.zip) and put it in a folder `ikvm` on the root of the repo (add it to ignore list) : this path is referenced in the pom.xml
2. Build the project : `mvn clean package`
3. the .dll is generated in the output dir
4. you will also find a folder proparse.net next to this repo folder containing all the needed files for prolint