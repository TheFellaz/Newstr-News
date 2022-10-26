package com.example.Newsternews.API;

public class ArticleClass {
    linkedListClass head;

    static class linkedListClass{
        //information the API is producing
        String name;
        String url;
        String description;

        linkedListClass nextNode;

        //constructors - getters/setters
            //no arg constructor
        public linkedListClass() {
        }
            //all data constructor
        public linkedListClass(String name,
                               String url,
                               String description,
                               linkedListClass nextNode) {
            this.name = name;
            this.url = url;
            this.description = description;
            this.nextNode = nextNode = null;
        }

            //all getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public linkedListClass getNextNode() {
            return nextNode;
        }

        public void setNextNode(linkedListClass nextNode) {
            this.nextNode = nextNode;
        }

            //toString
        @Override
        public String toString() {
            return "linkedListClass{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", description='" + description + '\'' +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }

}
