(defproject lein-cljsbuild-example "1.2.3"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :cljsbuild {:builds {:test  
                        {:source-paths ["test"]
                         :compiler {:output-to "resources/public/unit-test.js"
                                    :static-fns true
                                    :optimizations :whitespace
                                    :pretty-print true}}}})
