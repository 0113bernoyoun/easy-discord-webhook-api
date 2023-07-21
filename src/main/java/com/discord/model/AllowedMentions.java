package com.discord.model;

import java.util.List;

public record AllowedMentions(List<String> parse, List<Long> roles, List<Long> users, Boolean replied_user) {
}
