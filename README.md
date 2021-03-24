Tests the-internet app, goal is to learn some selenium and supporting tools

Prerequisites
- java 11
- docker
- firefox  
- macOS or Windows machine
- macOS only
    - from terminal run xattr -r -d com.apple.quarantine geckodriver (https://firefox-source-docs.mozilla.org/testing/geckodriver/Notarization.html)

How to run project
1. cd to project directory
2. run gradle test (./gradlew test)
    - when docker does the initial pull this sometimes gets stuck can pull the image by docker pull gprestes/the-internet
3. stop with gradle stopApp 