package com.discord.model;

public record Field(String name, String value, Boolean inline) {

    public static class Builder {
        private String name;
        private String value;
        private Boolean inline = false;

        public Builder() {
        }

        public Field build() {
            return new Field(name, value, inline);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }
    }
}
