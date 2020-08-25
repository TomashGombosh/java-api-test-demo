package com.tomash.gombosh.api.processor;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
@Data
public class ErrorResponse {
    @SerializedName("error")
    private String errorMessage;
}
