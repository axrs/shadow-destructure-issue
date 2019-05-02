# Destructuring Issue

A function destructuring regression issue appears to have come into the releases from version `2.7.24` and onwards
(still broken in `2.8.36`). The provided test here consistently shows the issue. I believe it has to do with
ClojureScript `1.10.516`.

## Testing

`npm install && npx shadow-cljs watch test`

### Expected behaviour

The arguments should be destructured from a varargs definition.

### Actual behaviour

The arguments are destructured, but incorrectly. Some are wrapped in a collection when they shouldn't be.

## Works in

shadow-cljs 2.7.9


### 2.7.9 - Works

```
shadow-cljs - config: /Projects/shadow_destructure_issue/shadow-cljs.edn  cli version: 2.7.9  node: v10.15.3
shadow-cljs - starting ...
[:test] Compiling ...
========= Running Tests =======================

Testing io.axrs.shadow-destructure-issue-test
nil nil
1 nil
1 2

Ran 1 tests containing 3 assertions.
0 failures, 0 errors.
===============================================
[:test] Build completed. (27 files, 8 compiled, 0 warnings, 24.86s)
```

### 2.7.23 - Works

```
shadow-cljs - config: /Users/xander/Projects/shadow_destructure_issue/shadow-cljs.edn  cli version: 2.7.23  node: v10.15.3
shadow-cljs - updating dependencies
Retrieving thheller/shadow-cljs/2.7.23/shadow-cljs-2.7.23.pom from https://clojars.org/repo/
Retrieving thheller/shadow-cljs/2.7.23/shadow-cljs-2.7.23-aot.jar from https://clojars.org/repo/
shadow-cljs - dependencies updated
[:test] Compiling ...
========= Running Tests =======================

Testing io.axrs.shadow-destructure-issue-test
nil nil
1 nil
1 2

Ran 1 tests containing 3 assertions.
0 failures, 0 errors.
===============================================
[:test] Build completed. (27 files, 8 compiled, 0 warnings, 18.19s)
```

### 2.7.24 - Fails

```
shadow-cljs - config: /Users/xander/Projects/shadow_destructure_issue/shadow-cljs.edn  cli version: 2.7.24  node: v10.15.3
shadow-cljs - updating dependencies
Retrieving thheller/shadow-cljs/2.7.24/shadow-cljs-2.7.24.pom from https://clojars.org/repo/
Retrieving thheller/shadow-cljs/2.7.24/shadow-cljs-2.7.24-aot.jar from https://clojars.org/repo/
shadow-cljs - dependencies updated
[:test] Compiling ...
========= Running Tests =======================

Testing io.axrs.shadow-destructure-issue-test
(nil) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (nil? (f nil))
  actual: (not (nil? (nil)))
(1) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1))
  actual: (not (= 1 (1)))
(1 2) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1 2))
  actual: (not (= 1 (1 2)))

Ran 1 tests containing 3 assertions.
3 failures, 0 errors.
===============================================
[:test] Build completed. (27 files, 8 compiled, 0 warnings, 26.77s)
```

### 2.7.25 - Fails

```
shadow-cljs - config: /Users/xander/Projects/shadow_destructure_issue/shadow-cljs.edn  cli version: 2.7.25  node: v10.15.3
shadow-cljs - updating dependencies
Retrieving thheller/shadow-cljs/2.7.25/shadow-cljs-2.7.25.pom from https://clojars.org/repo/
Retrieving org/clojure/clojurescript/1.10.516/clojurescript-1.10.516.pom from https://repo1.maven.org/maven2/
Retrieving org/clojure/clojurescript/1.10.516/clojurescript-1.10.516.jar from https://repo1.maven.org/maven2/
Retrieving thheller/shadow-cljs/2.7.25/shadow-cljs-2.7.25-aot.jar from https://clojars.org/repo/
shadow-cljs - dependencies updated
[:test] Compiling ...
========= Running Tests =======================

Testing io.axrs.shadow-destructure-issue-test
(nil) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (nil? (f nil))
  actual: (not (nil? (nil)))
(1) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1))
  actual: (not (= 1 (1)))
(1 2) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1 2))
  actual: (not (= 1 (1 2)))

Ran 1 tests containing 3 assertions.
3 failures, 0 errors.
===============================================
[:test] Build completed. (27 files, 8 compiled, 0 warnings, 14.21s)
```

### 2.7.36 - Fails

```
shadow-cljs - config: /Projects/shadow_destructure_issue/shadow-cljs.edn  cli version: 2.7.36  node: v10.15.3
shadow-cljs - updating dependencies
shadow-cljs - dependencies updated
[:test] Compiling ...
========= Running Tests =======================

Testing io.axrs.shadow-destructure-issue-test
(nil) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (nil? (f nil))
  actual: (not (nil? (nil)))
(1) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1))
  actual: (not (= 1 (1)))
(1 2) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1 2))
  actual: (not (= 1 (1 2)))

Ran 1 tests containing 3 assertions.
3 failures, 0 errors.
===============================================
[:test] Build completed. (27 files, 8 compiled, 0 warnings, 18.09s)
```

### 2.8.0 - Fails

```
shadow-cljs - config: /Projects/shadow_destructure_issue/shadow-cljs.edn  cli version: 2.8.0  node: v10.15.3
shadow-cljs - updating dependencies
shadow-cljs - dependencies updated
[:test] Compiling ...
========= Running Tests =======================

Testing io.axrs.shadow-destructure-issue-test
(nil) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (nil? (f nil))
  actual: (not (nil? (nil)))
(1) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1))
  actual: (not (= 1 (1)))
(1 2) nil

FAIL in (destructure-test) (cljs-runtime/cljs/test.cljs:475:6)
expected: (= 1 (f 1 2))
  actual: (not (= 1 (1 2)))

Ran 1 tests containing 3 assertions.
3 failures, 0 errors.
===============================================
[:test] Build completed. (28 files, 28 compiled, 0 warnings, 19.76s)
```
