# Village Electric Usage Counter

### Apis
This middleware ships with the following apis:

* method:POST,      url:/api/v1/villages
```
{id:1,name:Village 1}
```

* method:POST,  url:/api/v1/counters
```
{id:1,villageId:1,address:}
```

* method:GET,  url:/api/v1/counters/{counterid}
```
{id:1,villageName:Village 1}
```
* method: POST, url:/api/v1/counters/counterId{}/callback
```
{id:1,villageName:Village 1}
```
* method:GET, url:/api/v1/reports/village/consumption?duration=24h
```
[{villageName:Village 1,consumption:48.07},{villageName:Village 2,consumption:48.07},{villageName:Village 3,consumption:48.07}]
```

### Running Tests
There are three test cases present. which are ran dynamically
```
http00.json
http01.json
http02.json
```

The test cases consist of requests and expected responses. <br> <br>
To run the tests, use commands

#### Plain tests
```
 ./gradlew test && cat target/customReports/result.txt 
```

#### Tests with debug enabled
```
 ./gradlew test --debug && cat target/customReports/result.txt 
```