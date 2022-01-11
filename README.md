# 背景

​		一般新建项目都是选择maven或spring initializr来生成项目，然后经过一系列的修改、配置、加入自己项目的一些风格。

​		由于微服务越来越流行，一个项目需要新建很多的微服务项目，每次新建项目时都需要花费大量的时间来进行修改、配置，达到所有项目结构和风格一致。如果新建项目的同事不是很熟悉项目风格，就会导致部分项目风格不一致等问题。

​		maven提供了解决这些问题的方法，那就是创建自己项目的脚手架，下面就介绍脚手架项目如何创建和使用。



# 第一步 创建基础项目

创建项目（会以此项目生成脚手架，所有通过该脚手架生成的项目都是此项目的格式和风格）

**例如：**

- **groupId：com.yyds.oa**

- **artifactId：oa-archetype** 

- **version：0.0.1-SNAPSHOT**
- **package：com.yyds.oa.archetype**



**注意：**

创建的启动类最好使用一个所有项目都能用的名字 ，如：**StartApplication**



# 第二步 通过基础项目生成原型（脚手架）

- 在项目**根目录**下添加 **archetype.properties**，参考[maven官方文档](https://maven.apache.org/archetype/maven-archetype-plugin/examples/create-with-property-file.html)，以下**配置仅供参考**

  ```properties
  # 指定哪些文件或目录不打包到 archetype
  excludePatterns=archetype.properties,*.iml,.idea/,.idea/libraries,logs/,build.sh
  
  # 设置变量（由于.gitignore不能直接打包到archetype，并且不能通过archetype生成到新的项目）
  gitignore=.gitignore
  
  # 自定义 archetype 相关配置（不设置则会使用默认的，也就是当前项目配置为基础 + archetype）
  archetype.groupId=com.yyds.oa.framework
  archetype.artifactId=oa-framework-archetype
  # 不指定版本则跟随当前项目
  #archetype.version=0.0.1-SNAPSHOT
  ```

- 复制项目.gitignore文件，并重命名为 **\_\_gitignore\_\_**

  ```shell
  __gitignore__
  ```

  

- 检查项目各项配置，确认无误之后，在项目**根目录**下执行命令：

  ```shell
  mvn archetype:create-from-project -Darchetype.properties=archetype.properties
  ```

- 执行脚本后会在项目**根目录**下生成 **target/generated-sources/archetype**（输出目录无法修改，参考[maven-archetype-plugin源码](https://github.com/apache/maven-archetype/blob/maven-archetype-2.4/maven-archetype-plugin/src/main/java/org/apache/maven/archetype/mojos/CreateArchetypeFromProjectMojo.java#L210-L211)）

- 把archetype复制出来，重命名为 **oa-framework-archetype**

- 使用**开发工具**打开

脚手架到这里就生成好了



**前两步完成之后可以参考：**[https://github.com/zhouxiaofu/create-maven-archetype/tree/main/oa-archetype](https://github.com/zhouxiaofu/create-maven-archetype/tree/main/oa-archetype)



# 第三步 变量与打包

## 变量

由原型生成的项目配置会与基础项目一致，需要有一些自定义的配置，如 **application.yml** 的内容如下

```yaml
spring:
  application:
    name: oa-archetype
server:
  port: 8080
```

通过原型生成的项目也会跟这个一样，需要 每次生成的时候自定义一些配置 如：**spring.application.name、server.port** 等配置，或者是代码中的一些配置

这个时候就可以使用**变量**，修改后：

```yaml
spring:
  application:
    name: ${artifactId}
server:
  port: ${serverPort}
```



打开 **resources/META-INF/maven/archetype-metadata.xml**，生成项目时的大部分配置都在此文件下面，可以根据需要进行修改。

由于 serverPort 变量并不是生成项目时的必填变量，所以我们需要将其设置为必填

在 xml **archetype-descriptor -> requiredProperties** 下添加

```xml
<requiredProperty key="serverPort">
    <!-- 也可以加上defaultValue，则变成非必填 -->
<!--      <defaultValue>8080</defaultValue>-->
</requiredProperty>
```

同时需要在 **test/resources/projects/basic/archetype.properties** 添加 **requiredProperty** 的默认值（用作打包时的测试，否则打包会报错）

```properties
serverPort=8080
```



可以参考：[https://github.com/zhouxiaofu/create-maven-archetype/tree/main/oa-framework-archetype](https://github.com/zhouxiaofu/create-maven-archetype/tree/main/oa-framework-archetype)

## 打包

修改完毕后，打包

- 有maven私服：

  ```shell
  mvn deploy
  ```

- 没有maven私服：

  ```shell
  mvn install
  ```



# 第四步 通过原型生成项目

在需要生成项目的目录下执行

```shell
mvn archetype:generate -DgroupId=com.yyds.oa -DartifactId=oa-user -Dversion=0.0.1-SNAPSHOT -Dpackage=com.yyds.oa.archetype -DserverPort=8081 -DarchetypeGroupId=com.yyds.oa.framework -DarchetypeArtifactId=oa-framework-archetype -DarchetypeVersion=0.0.1-SNAPSHOT
```

**参数介绍：**

- groupId、artifactId、version、package、serverPort  需要生成的项目配置
- archetypeGroupId、archetypeArtifactId、archetypeVersion  指定生成项目的原型

执行时需要进行二次确认，如果不想要二次确认，则可以设置参数interactiveMode（交互模式）为false (interactiveMode为必填参数，默认为true)

```shell
-DinteractiveMode=false
```

 [archetype:generate 官方文档](https://maven.apache.org/archetype/maven-archetype-plugin/generate-mojo.html)



也可以通过IDEA等编辑器配置maven archetype，然后生成项目



















