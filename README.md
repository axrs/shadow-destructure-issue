# Destructuring Issue

A function destructuring regression issue appears to have come into the releases from version `1.10.516` and onwards when compiling with `:static-fns true`.

## Expected behaviour

The arguments should be destructured from a varargs definition.

## Actual behaviour

The arguments are destructured, but incorrectly. It appears as if the first destructure value is all arguments.

## Testing

### CLJ Compiled

```
clj -m cljs.main --target node --output-to out/test.js -co '{:static-fns true}' -c io.axrs.shadow-destructure-issue-test 
node out/test.js
```

### Shadow-cljs

```
npm install 
npx shadow-cljs watch test
```

### CLJSBuild

```
lein cljsbuild once test
```

Open `resources/public/index.html` and check the console
