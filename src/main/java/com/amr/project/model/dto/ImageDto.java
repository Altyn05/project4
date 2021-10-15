package com.amr.project.model.dto;

import com.amr.project.util.ImgUtil;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImageDto {
    private Long id;
    private String url;
    private byte[] picture;

    public String toBase64() {
        return ImgUtil.toBase64img(url, picture);
    }

}
