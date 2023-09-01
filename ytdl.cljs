(ns ytdl
  (:require ["ytdl-core$default" :as ytdl]
            ["fs" :as fs]
            [promesa.core :as p]))

(defn save
  "Fetches a YouTube url and writes it to a file."
  [url name]
  (p/let [stream (ytdl url)]
    (.pipe stream (fs/createWriteStream name))))

(comment
  (save "https://www.youtube.com/watch?v=XIWZjQrCnzc"  "video.mp4"))