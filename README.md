# TestAndroidPerformaceAdvice
Testing advice for android performance

Based on https://www.youtube.com/watch?v=b6zKBZcg5fk 

I don't like when someone say about optimization and don't benchmarks/ mesure what say. 
Because of that I say check.

Maybe my benchmarks are not so super profecional,but give me more or less  information which algorithm is faster. 

@JakeWharton said that this algotithm should be faster

```LoopAlgorithm2
List<String> names = new ArrayList<String>(users.size());
        for (String name : names) {
            names.add(name);
        }
        
```        
then this

```LoopAlgorithm1
List<String> names = new ArrayList<String>();
        for (String name : names) {
            names.add(name);
        }
        return names;
```

I check this on JVM and android and it looks like Jack don't have right. 
On android the algotithm `LoopAlgorithm2` is 10 times slower then `LoopAlgorithm1`, regardless of the order !! 

Please confirm that on your devices is the same and I didn't made a stupid mistake. 
