(ns hello
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(defn ui [] [:div "hello"])

(rdom/render
 [ui]
 (.getElementById js/document "app"))
