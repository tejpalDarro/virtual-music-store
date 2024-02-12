package com.jwt.spring_security_html.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private String title;
    private String descName;
    private Date date;

}
