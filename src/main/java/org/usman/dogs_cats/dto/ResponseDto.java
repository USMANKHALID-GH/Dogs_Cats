package org.usman.dogs_cats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto implements BaseDto{
    @Builder.Default
    private  boolean sucess=true;
    @Builder.Default
    private  int statusCode= HttpStatus.OK.value();
    @Builder.Default
    private  String status=HttpStatus.OK.name();

    private  String message;
    @Builder.Default
    private  long timestamp=System.currentTimeMillis();

}
