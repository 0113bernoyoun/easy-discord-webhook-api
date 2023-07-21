package com.discord.model;

public record File(String name, String contentType, byte[] data) {
}
