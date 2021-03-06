# Simple Fx Dialog

![banner](https://i.imgur.com/jDsThDb.png)

A library with a lot of preset dialogs with simple syntax.

Wiki : [here](https://github.com/LukeOnuke/SimpleFxDialog/wiki)

## Instalation

**MAVEN**

***Step 1.*** Add the JitPack repository to your build file
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
**_Step 2._** Add the dependency
```xml
	<dependency>
	    <groupId>com.github.LukeOnuke</groupId>
	    <artifactId>SimpleFxDialog</artifactId>
	    <version>Tag</version>
	</dependency>
```
**NETBEANS**

- Download the library(jar) from the releases page or click   
  [here](https://github.com/LukeOnuke/SimpleFxDialog/releases)

 1. Paste the downloaded jar into a folder of your choise
 2. Open project settings (Right click onto the project then go `Properties`. After you are in the Project settings go `Libraries -> Add JAR/Folder` and select the jar of this library)

   If you cant find a guide for your IDE follow a guide for using a external library for your IDE of choise

## Documentation
Wiki front page: [here](https://github.com/LukeOnuke/SimpleFxDialog/wiki)
```
Wiki 
│
Wiki front page
|
└───Class : Dialog
│   │   Method : okCancelDialog()
│   │   Method : okDialog()
│   │   Method : formDialog()
│   │   Method : custom2ButtonDialog()   
│   │   Method : formDialog()
│ 	│	Method : aboutDialog()
│
└───Enum : DialogImage
│
│
│
└───Exception : NotSupportedException
│
│
│
└───Class : TrayDialog
│   │   Method : displayTrayNotification()
```


## Contribution
If you want to contribute you are welcome to do in any way imaginable. Easiest way to contribute is to star the repository.
