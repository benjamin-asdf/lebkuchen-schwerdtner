(ns dev.build
  (:require [shadow.css.build :as cb]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [clojure.edn :as edn]
            [hiccup.page :as hp]
            [clj.bennischwerdtner.paiwebsite.page.index]
            [clj.bennischwerdtner.paiwebsite.page.base :as
             base]))

(defn css-release
  [& args]
  (let
    [build-state
       (->
         (cb/start)
         (cb/index-path (io/file "src" "clj") {})
         (cb/generate
           '{:ui
               {:entries
                  [clj.bennischwerdtner.paiwebsite.page.index]}})
         (cb/minify)
         (cb/write-outputs-to (io/file "public" "css")))]
    (doseq [mod (:outputs build-state)
            {:as warning :keys [warning-type]} (:warnings
                                                 mod)]
      (prn [:CSS (name warning-type)
            (dissoc warning :warning-type)]))))


#_(defn scittle-release
  []
  (doseq [file (filter #(str/ends-with? % ".cljs")
                       (file-seq (io/file "src" "cljs")))]
    (io/copy file
             (io/file "public"
                      (java.io.File/.getName file)))))

(defn pages-release
  [dev?]
  (binding [base/*dev* dev?]
    (doseq
        [[file content]
         [["index.html"
           (base/base
            (clj.bennischwerdtner.paiwebsite.page.index/page))]]]
      (spit (io/file "public" file) (hp/html5 content)))))

(comment
  ;; (scittle-release)
  (pages-release true))
