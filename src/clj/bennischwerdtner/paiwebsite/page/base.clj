(ns clj.bennischwerdtner.paiwebsite.page.base)

(def ^:dynamic *dev*)

(defn base
  [body]
  [:html
   [:head [:meta {:charset "UTF-8"}]
    [:meta
     {:content "width=device-width, initial-scale=1"
      :name "viewport"}]
    [:link {:href "data:," :rel "shortcut icon"}]
    [:link {:href "data:," :rel "apple-touch-icon"}]
    [:link {:href "/ui.css" :rel "stylesheet"}]

    ;; <link rel="preconnect" href="https://fonts.googleapis.com">
    ;; <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    ;; <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">

    [:link {:rel "preconnect" :href "https://fonts.googleapis.com"}]
    [:link {:rel "preconnect" :href "https://fonts.gstatic.com" :crossorigin true}]
    [:link {:href "https://fonts.googleapis.com/css2?family=Satisfy&display=swap" :rel "stylesheet"}]

    ;; .satisfy-regular {
    ;;   font-family: "Satisfy", cursive;
    ;;   font-weight: 400;
    ;;   font-style: normal;
    ;; }

    [:style
     {:type "text/css"}
     ".satisfy-regular { font-family: 'Satisfy', cursive; font-weight: 400; font-style: normal; }"]
    ;; make it the default font
    [:style
     {:type "text/css"}
     "body { font-family: 'Satisfy', normal; }"]

    [:script
     {:src
      "https://cdn.jsdelivr.net/npm/scittle@0.6.20/dist/scittle.js"}]
    (when *dev*
      (list
       [:script {:type "application/javascript"}
        "var SCITTLE_NREPL_WEBSOCKET_PORT = 1340;"]
       [:script
        {:src
         "https://cdn.jsdelivr.net/npm/scittle@0.6.20/dist/scittle.nrepl.js"
         :type "application/javascript"}]))
    [:script
     {:crossorigin true
      :src
      "https://unpkg.com/react@17/umd/react.production.min.js"}]
    [:script
     {:crossorigin true
      :src
      "https://unpkg.com/react-dom@17/umd/react-dom.production.min.js"}]
    [:title "Bäckermeister Schwerdtner"]] body])
