# TrcHelper

## Add to your project<br>
1. settings.gradle
````
sourceControl {
    gitRepository("https://github.com/p3tzata/TrcHelper.git") {
        producesModule("org.p3tzata:TrcHelper")
    }
}
````
2. build.gradle
````
dependencies {
  implementation('org.p3tzata:TrcHelper') { version { branch = 'trcHelper' } }
  ...  
}
````
3. Rebuild
````
./gradlew build
````

4. Import

`import static org.p3tzata.TrcHelperFactory.*;`

## Some examples:<br>
Sample line
````
    TrcHelper.LINE(_var("test", 69));
````

If-else
````
    TrcHelper.IF(1 == 1, "isEqual");
    if (1 == 1) {
      String t = "t";
    }
    else {
      String t = "t";
    }
    TrcHelper.EXIT();
    
````
Loop
````
    int i = 0;
    TrcHelper.WHILE(_var("i",i),_lt(),_num(5));
    while(i++<5) {
      TrcHelper.LOOP(_var("i",i));
      int j = i;
      TrcHelper.LINE(_var("j",j));
    }
    TrcHelper.EXIT();
````

Call method
````
  void someMethod_endReturn() {

    TrcHelper.CALL("someMethod");
    ...    
    TrcHelper.RETURN();
    
  }
````

For more example, please see the unit tests.
