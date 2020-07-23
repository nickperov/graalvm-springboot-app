# GraalVM study project

## Description
Study project to lear GraalVM and ways to use it with spring including native-image build. 

Resources used:
 * https://www.graalvm.org/getting-started/
 * https://spring.io/blog/2020/04/16/spring-tips-the-graalvm-native-image-builder-feature

## Prerequisites
 * Maven installed;
 * Latest version (20.1.0) of  GraalVM installed;
 * GraalVM home/bin added to the **PATH**;
 * **JAVA_HOME** is pointing to GraalVM home.


## Build instructions
Go to module:

    sd {module_name}

Build application as usual:

    mvn -DskipTests=true clean package

Create META-INF directory:

    export MI=src/main/resources/META-INF
    mkdir -p $MI

Run application with native image agent:

    java -agentlib:native-image-agent=config-output-dir=${MI}/native-image -jar target/${module_name}.jar

Stop the running application.
META-INF.native-image should contain next files: 

    ├── jni-config.json
    ├── proxy-config.json
    ├── reflect-config.json
    └── resource-config.json
Run build with graal profile

    mvn -Pgraal clean package


## Authors
Nikolay Perov

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
