# Install & Configure Tomcat

## Prerequisite
The following instruction requires java to be installed

```
echo $JAVA_HOME
/usr/lib/jvm/java-8-openjdk-amd64
```

## Install Tomcat
```
sudo apt install unzip wget
cd /tmp
wget http://mirrors.estointernet.in/apache/tomcat/tomcat-9/v9.0.37/bin/apache-tomcat-9.0.37.zip

unzip apache-tomcat-*.zip
sudo mkdir -p /opt/tomcat
sudo mv apache-tomcat-9.0.37 /opt/tomcat/
```

## Change Tomcat Server Port

Jenkins is running on Port 8080, and tomcat defalut port is also 8080. Change the Tomcat port to 9090

Update /opt/tomcat/apache-tomcat-9.0.37/conf/server.xml file

```
    <!--
    <Connector port="8080" protocol="HTTP/1.1"
    -->
    <Connector port="9090" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="9443" />
    <!--
               redirectPort="8443" />
    -->
```

## Make the scripts exceutable

```
ls -l /opt/tomcat/apache-tomcat-9.0.37/bin
sudo chmod a+x /opt/tomcat/apache-tomcat-9.0.37/bin/*.sh
```

## Set Credentials of Tomcat that Jenkins use.

Update  /opt/tomcat/apache-tomcat-9.0.37/conf/tomcat-users.xml
roles : manager-script & admin-gui

```
  <role rolename="manager-script"/>
  <role rolename="admin-gui"/>
  <user username="darealpunjabi" password="my-password" roles="manager-script,admin-gui"/>
```

## Start Stop the tomcat server

```
/opt/tomcat/apache-tomcat-9.0.37/bin/startup.sh
/opt/tomcat/apache-tomcat-9.0.37/bin/shutdown.sh
```

## Ensure firewall rule allow traffic on port 9090

```
gcloud compute firewall-rules create jenkins-allow-ingress \
  --direction=INGRESS \
  --priority=1000 \
  --action=ALLOW \
  --target-tags=http-server,https-server \
  --source-ranges=0.0.0.0/0 \
  --rules=tcp:8080,tcp:9090 \
  --network=default
```

## Test tomcat

From the browser

```
http://<external-ip-address>:9090

Apache Tomcat/9.0.37
```
