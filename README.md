# cats-effect-timout-bug

## Run tests

```shell
sbt test
```

Usage of timeout produces stack trace

```shell
...
[info] TimeoutSpec:
[info] IO
java.lang.Exception: moi 1
| => rat test.TimeoutSpec.$anonfun$new$4(TimeoutSpec.scala:20)
at delay @ test.TimeoutSpec.$anonfun$new$3(TimeoutSpec.scala:20)
[info] - with timeout (267 milliseconds)
[info] - with timeout and attempt (184 milliseconds)
[info] - without timeout (2 milliseconds)
[info] Run completed in 1 second, 348 milliseconds.
[info] Total number of tests run: 3
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 3, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 2 s, completed Apr 14, 2022 10:52:02 PM
```
