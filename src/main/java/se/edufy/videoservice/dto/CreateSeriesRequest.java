package se.edufy.videoservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSeriesRequest(
        @NotBlank
        @Size(max = 200)
        String title
) {}
