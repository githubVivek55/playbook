package com.vwake.records;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;

public record OperationResult(
        @Positive(message = "Base price should be greater than zero")
        Double discount,
        @Nullable
        @Positive(message = "Base price should be greater than zero")
        Double basePrice,
        @Nullable
        @Positive(message = "Selling price should be greater than zero")
        Double sellingPrice) {
}
