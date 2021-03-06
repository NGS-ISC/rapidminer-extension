RapidMiner Extension Supporting NGS
===================================

# rapidminer-extension
A template project for creating a RapidMiner Studio extension. 

### Prerequisite
* Requires Gradle 2.3+ (get it [here](http://gradle.org/installation) or use the Gradle wrapper shipped with this template)

### Getting started
1. Clone the extension template

2. Change the extension settings in _build.gradle_ (e.g. replace 'Template' by the desired extension name)

3. Initialize the extension project by executing the _initializeExtensionProject_ Gradle task (e.g. via 'gradlew initializeExtensionProject')

4. Add an extension icon by placing an image named "icon.png" in  _src/main/resources/META-INF/_. 

5. Build and install your extension by executing the _installExtension_ Gradle task 

6. Start RapidMiner Studio and check whether your extension has been loaded


Icons taken from http://www.flaticon.com/free-icon/dna_450590#term=genetic&page=1&position=92

### Interesting references

Presentation on NGS and Software used there https://www.slideshare.net/tillmanneitelberg1/bioinformatics-on-azure-62334970


