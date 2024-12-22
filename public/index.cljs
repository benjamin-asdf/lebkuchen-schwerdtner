(ns bennischwerdtner.paiwebsite.index
  (:require
   [reagent.core :as r]
   [reagent.dom :as rdom])
  (:require-macros [shadow.css]))

(defn page []
  ;; [:div {:class (css)} "hello"]
  )

(rdom/render [page] (.getElementById js/document "app"))
