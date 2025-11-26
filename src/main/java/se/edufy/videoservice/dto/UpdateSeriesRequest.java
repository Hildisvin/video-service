package se.edufy.videoservice.dto;

import jakarta.validation.constraints.Size;

public record UpdateSeriesRequest(
        @Size(max = 200)
        String title
) {}
