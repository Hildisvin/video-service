package se.edufy.videoservice.dto;

import jakarta.validation.constraints.Size;

public record UpdateChannelRequest(
        @Size(max = 200)
        String name,

        @Size(max = 100)
        String handle
) {}
