package com.discord.model;

import java.util.List;

public record Embed(
        String title,
        String description,
        String url,
        String timestamp,
        Integer color,
        Footer footer,
        Image image,
        Thumbnail thumbnail,
        Video video,
        Provider provider,
        Author author,
        List<Field> fields
) {

    public static class Builder {
        private String title;
        private String description;
        private String url;
        private String timestamp;
        private Integer color;
        private Footer footer;
        private Image image;
        private Thumbnail thumbnail;
        private Video video;
        private Provider provider;
        private Author author;
        private List<Field> fields;

        public Builder() {
        }

        public Embed build() {
            return new Embed(title, description, url, timestamp, color, footer, image, thumbnail, video, provider, author, fields);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setColor(Integer color) {
            this.color = color;
            return this;
        }

        public Builder setFooter(Footer footer) {
            this.footer = footer;
            return this;
        }

        public Builder setImage(Image image) {
            this.image = image;
            return this;
        }

        public Builder setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder setVideo(Video video) {
            this.video = video;
            return this;
        }

        public Builder setProvider(Provider provider) {
            this.provider = provider;
            return this;
        }

        public Builder setAuthor(Author author) {
            this.author = author;
            return this;
        }

        public Builder setFields(List<Field> fields) {
            this.fields = fields;
            return this;
        }
    }
}
