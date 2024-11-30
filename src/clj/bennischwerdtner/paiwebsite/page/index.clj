(ns clj.bennischwerdtner.paiwebsite.page.index
  (:require
   [shadow.css :refer (css)]))

^{:page/html true}
(defn page
  []
  [:div
   {:class
      (css :flex :w-full :justify-center :m-8)}
   [:div
    {:class (css {:max-width "1000px"}
                 :text-xl
                 :w-full :flex
                 :flex-col)}
    [:h1
     {:class (css :text-3xl [:md :text-5xl]
                  :mb-2
                  :font-bold :text-center)}
     "Lebkuchen Schwerdtner"]
    [:div {:class (css :w-full :flex :justify-center)}
     [:img
      {:class (css {:max-width "90%" :width "600px"})
       :src
       "https://www.lebkuchen365.de/wp-content/uploads/2021/10/Original-Nu%CC%88rnberger-Elisen-Lebkuchen-4-scaled.jpg"}]]
    [:div {:class (css :m-2)}]
    [:p {:class (css :w-full :text-center :my-2)}
     "Alfred Schwerdtner, Bäckermeister"]
    [:div {:class (css :grid :grid-cols-2 :gap-2)}
     (for [{:keys [text person]}
           [{:person "Person A as Stadt"
             :text "Einfach die besten Lebkuchen"}
            {:person "Person A as Stadt"
             :text "Einfach die besten Lebkuchen"}]]
       [:div
        {:class (css :flex :flex-col
                     :p-2 :bg-slate-100
                     ;; {:max-width "50%"}
                     )}
        [:div
         {:class
          (css :w-full :text-left
               :m-2
               {:font-family
                "\"Times New Roman\", Times, serif"})}
         text]
        [:div {:class (css :text-right :font-semibold)}
         " - " person]])]

    [:div {:class (css :my-2 :text-center :font-extrabold)} "~~~ + ~~~~"]
    ;; [:div {:class (css :relative)}
    ;;  [:img
    ;;   {:class (css :absolute
    ;;                :w-screen
    ;;                {:height "40px"})
    ;;    :src "./divider.svg"}]]
    [:img
     {:class (css :my-4 :w-screen {:height "40px"})
      :src "./divider.svg"}]]])
