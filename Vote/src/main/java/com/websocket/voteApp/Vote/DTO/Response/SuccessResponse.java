package com.websocket.voteApp.Vote.DTO.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuccessResponse {
    private String statusCode;
    private String message;
    private Object object;
}
