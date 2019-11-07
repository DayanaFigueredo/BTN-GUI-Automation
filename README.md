# GUI Automation Testing Second Part

On this workshop we are going to test the graphic user interface of one popular web page, Domicilios.com, so we are able to see how important is the information generated of the automated tests.

For the workshop we need to have installed those tools and have access to this API's:

* [Java]
* [Open JDK]
* [Maven]
* [Latest version of Chrome]
* [Selenium Web Driver]
* [IntelliJ IDEA]



## Installation

For [Java] and [Maven], the installation information is available on each ones hyperlink.
If you want to check if you currently have them installed

```sh
$ java -version
```
The [Java] response will be

```sh
java version "1.8.0_221"
Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
```
 And for [Maven]

```sh
$ mvn -v
```

The response is:

```sh
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T13:41:47-05:00)
```


## Implementation

- First we have to open Intellij IDEA

- Create **new project** > **maven** > **Set project SDK to 1.8** > **Next**

- Fill the **GroupId** and **ArtifactId**  with our own information

- Set the **Project name** and click on **Finish**

- We need to install the [Cucumber Plugin] on IntelliJ IDEA

- Create new Files and Packages to have this structure
	- **root**
		 - **src**
			- **test**
				- **java**
					- helpers
					- pages
					- steps
					- utils
				- **resources**
					- features


## Configuration of the POM
This properties setting are for version control and specifications of the project dependencies:

```sh
     <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.5.2</junit.version>
        <selenium.version>3.141.59</selenium.version>
        <cucumber.version>1.2.4</cucumber.version>
        <cucumber-reports.version>0.0.11</cucumber-reports.version>
        <awaitility.version>3.0.0</awaitility.version>
    </properties>
```

This dependency is used for Run the tests
```sh
		<dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
```

This dependency is used for manage the Selenium Web Driver actions
```sh
		 <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>${selenium.version}</version>
            <scope>test</scope>
        </dependency>
```

This dependency is used for support the Selenium Web Driver actions
```sh
		<dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-support</artifactId>
            <version>${selenium.version}</version>
            <scope>test</scope>
        </dependency>

```
This dependency is for set the Selenium Web Driver as a Chrome emulator
```sh
	<dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>${selenium.version}</version>
            <scope>test</scope>
        </dependency>
```
This dependency is for the integration of Allure and Cucumber        
```sh
    <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-cucumber4-jvm</artifactId>
            <version>2.13.0</version>
    </dependency>
```
This dependencies are for the integration of Cucumber BDD   
```sh
     <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-jvm</artifactId>
            <version>${cucumber.version}</version>
            <type>pom</type>
        </dependency>
```

This dependency is for the implementation of Extended Cucumber Reports
```sh
    <dependency>
            <groupId>com.github.mkolisnyk</groupId>
            <artifactId>cucumber-reports</artifactId>
            <version>${cucumber-reports.version}</version>
        </dependency>
```

This dependency is for the integration of Waiters on the tests
```sh
       <dependency>
            <groupId>org.awaitility</groupId>
            <artifactId>awaitility</artifactId>
            <version>${awaitility.version}</version>
            <scope>test</scope>
        </dependency>
```

## Set the plugins of the POM

```
We define the version of Java that will work with **Maven** in this plugin:

```sh
          <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.7.0</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                    <source>1.8</source>
                    <target>1.8</target>
                    <compilerArgument>-Werror</compilerArgument>
                </configuration>
            </plugin>
```
The main plugin is for the actions of execute all tests defined on the **RunGUITests.class** , generate the connection with Cucumber and set the destination folder of all tests, with this entire plugin we choose the **verify** for all the scope of tests:

```sh
<plugin>
                <artifactId>maven-failsafe-plugin</artifactId>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                    <includes>
                        <include>**/*RunGUITests.class</include>
                    </includes>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```

***

## Creating the configuration file of the application

On the route **src/test/resources** we create a new file named **config.properties**, this file will contain important information for out application and it's operation,this information is going to be used constantly and is likely to change.

The **config.properties** file must contain the next information:

```sh
url=https://domicilios.com/
```
***

## Creating the authorization file of the application

On the route **src/test/resources** we create a new file named **auth.properties**, this file will contain classified information for out application and it's operation,this information to be seted every time a person is going to run the test suite 

The **aut.properties** file must contain the next information:

```sh
userName=
userEmail=
userPassword=
```

## Creating our user stories
For the creation of user stories we will use [Cucumber] BDD and to make it understandable we use [Gherkin], to do this we will create two new files called **Search.feature** and **Login.feature**  on the route **src/test/resources/features**.



## Execution
To execute the full GUI tests suite you have to run on your console

```sh
$ mvn clean verify
```
To execute tagged GUI tests you have to run on your console

```sh
$ mvn clean verify -Dcucumber.options="--tags @Regression"
```

To open your reports and deploy them yo need to go to the route **target/cucumber-reports** and select each of the .html formats to be displayed on a browser.
