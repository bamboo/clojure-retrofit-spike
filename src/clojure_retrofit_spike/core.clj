(ns clojure-retrofit-spike.core
  (:gen-class)
  (:import [retrofit.http GET Path]
           [retrofit RestAdapter$Builder]))

(defn create-adapter [interface uri]
  (.. (RestAdapter$Builder.)
      (setServer uri)
      build
      (create interface)))

(definterface GitHubService
  (^{GET "/users/{user}/repos"}
   ^java.util.List
   listRepos [^{Path "user"} user]))

(defn create-github-adapter []
  (create-adapter GitHubService "https://api.github.com"))

(defn -main [& args]
  (let [github (create-github-adapter)]
   (doseq [r (.. github (listRepos "gbenatti"))]
     (println (get r "name")))))
