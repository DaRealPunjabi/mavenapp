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

add the following to pom.xml
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

mvn clean package

java -jar ./target/HelloWorld-1.0-SNAPSHOT.jar

```
Hello World!
```