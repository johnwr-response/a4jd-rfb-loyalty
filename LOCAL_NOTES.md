#Local Notes

###### CircleCi:

[![CircleCI](https://circleci.com/gh/johnwr-response/a4jd-rfb-loyalty/tree/start01.svg?style=svg)](https://circleci.com/gh/johnwr-response/a4jd-rfb-loyalty/tree/start01)

```
# Developing steps
mvn clean compile jib:dockerBuild -DskipTests
mvn clean compile jib:build -Dimage=johnwr/rfbloyalty -DskipTests

# Create a master maven password and put it in settings-security.xml
mvn --encrypt-master-password

# Encrypt the docker hub password and put it in settings.xml
mvn --encrypt-password

mvn clean compile jib:build -DskipTests

# Copy settings.xml to .mvn/wrapper/settings.xml in project
```

# Git

```
git add .
git remote add origin https://github.com/johnwr-response/a4jd-rfb-loyalty.git
git push origin master
```
