# mavenapp HelloWorld app

cd mavenapp

```
mvn archetype:generate -DgroupId=com.darealpunjabi -DartifactId=HelloWorld \
  -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

cd HelloWorld

add the following to pom.xml
```
  <properties>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```

mvn clean compile
cd target/classes

java com.darealpunjabi.App

```
Hello World!
```