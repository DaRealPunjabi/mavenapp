# HelloTomcat  - Build Instructions

## Generate the project structure

```
cd mavenapp
mvn archetype:generate -DgroupId=com.darealpunjabi\
 -DartifactId=HelloTomcat\
 -DarchetypeArtifactId=maven-archetype-webapp\
 -DinteractiveMode=false
 ```

## Configure compiler version

Add the following to pom.xml

```
cd HelloTomcat
```

```
  <properties>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```

## Delete index.jsp

```
rm -f src/main/webapp/index.jsp
```

## Add src/main/java/com/darealpunjabi/HelloServlet.java
```
package com.darealpunjabi;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        // Very simple - just return some plain text
        PrintWriter writer = response.getWriter();
        writer.print("Hello World");
    }
}
```

## Change src/main/webapp/WEB-INF/web.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
  version="3.0"> 

    <display-name>Hello World Web Application</display-name>

    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>org.example.HelloServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>
```

## Add the servlet dependency

```
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.0.1</version>
        <scope>provided</scope>
    </dependency>
```

## Build the war

```
mvn clean package
```
