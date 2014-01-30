# clojure-retrofit-spike

A simple example on how to play with [retrofit](http://square.github.io/retrofit/) in a clojure project.

Clojurians would probably go with [simpler](https://github.com/clojure/data.json) [alternatives](http://http-kit.org/client.html), specially for interacting
with the [github api](https://github.com/Raynes/tentacles).

## Usage

lein repl

```
clojure-retrofit-spike.core=> (def gh (create-github-adapter))
#'clojure-retrofit-spike.core/gh
clojure-retrofit-spike.core=> (map #(get % "name") (.. gh (listRepos "gbenatti")))
("Boobel" "Boospec" "ChuckFacts" "CocosNet" "Hulk" "mono-reactive" "monomac" "our-boxen" "TDWorld" "trends-report" "UrubuDB")
clojure-retrofit-spike.core=>
```

## License

Public Domain.
