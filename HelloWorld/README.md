# HelloWorld app - Build Instructions

## Generate the code

```
cd mavenapp
mvn archetype:generate -DgroupId=com.darealpunjabi -DartifactId=HelloWorld \
  -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Configure compile config

Add the following to pom.xml

```
cd HelloWorld
```

```
  <properties>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```

## Compile the code

```
mvn clean compile
```

## Run the code

```
cd target/classes
java com.darealpunjabi.App
Hello World!
```

## Build a jar file

Add the following to pom.xml

```
cd ../..
```

```
<build>
  <plugins>
    <plugin>
      <!-- Build an executable JAR -->
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-jar-plugin</artifactId>
      <version>3.1.0</version>
      <configuration>
        <archive>
          <manifest>
            <addClasspath>true</addClasspath>
            <classpathPrefix>lib/</classpathPrefix>
            <mainClass>com.darealpunjabi.App</mainClass>
          </manifest>
        </archive>
      </configuration>
    </plugin>
  </plugins>
</build>
```

```
mvn clean package
java -jar ./target/HelloWorld-1.0-SNAPSHOT.jar
Hello World!
```
