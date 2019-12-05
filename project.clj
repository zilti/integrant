(defproject integrant "0.8.0-alpha2"
  (:description "Micro-framework for data-driven architecture"
                :url "https://github.com/weavejester/integrant"
                :license {:name "The MIT License"
                          :url "http://opensource.org/licenses/MIT"}
                :dependencies [[org.clojure/clojure "1.9.0"]
                               [weavejester/dependency "0.2.1"]]
                :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.9.946"]]}}
                :plugins [[lein-codox "0.10.4"]
                          [lein-doo "0.1.7"]]
                :codox
                {:output-path "codox"
                 :source-uri "http://github.com/weavejester/integrant/blob/{version}/{filepath}#L{line}"}
                :cljsbuild
                {:builds [{:id "test-phantom"
                           :source-paths ["src" "test"]
                           :compiler {:output-to  "target/cljs/test-phantom/test-integrant.js"
                                      :output-dir "target/cljs/test-phantom/out"
                                      :main integrant.test-runner
                                      :optimizations :none
                                      :process-shim false}}
                          {:id "test-nashorn"
                           :source-paths ["src" "test"]
                           :compiler {:output-to  "target/cljs/test-nashorn/test-integrant.js"
                                      :output-dir "target/cljs/test-nashorn/out"
                                      :main integrant.test-runner
                                      :optimizations :simple
                                      :process-shim false}}
                          {:id "test-node"
                           :source-paths ["src" "test"]
                           :compiler {:target :nodejs
                                      :output-to  "target/cljs/test-node/test-integrant.js"
                                      :output-dir "target/cljs/test-node/out"
                                      :main integrant.test-runner
                                      :optimizations :none
                                      :process-shim false}}]}
                :aliases {"test-phantom" ["doo" "phantom" "test-phantom" "once"]
                          "test-nashorn" ["doo" "nashorn" "test-nashorn" "once"]
                          "test-node"    ["doo" "node" "test-node" "once"]
                          "test-cljs"    ["do" ["test-phantom"] ["test-nashorn"] ["test-node"]]
                          "test-all"     ["do" ["test"] ["test-cljs"]]
                          "test"         ["test" ":only" "integrant.core-test"]})
  
