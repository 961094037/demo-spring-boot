package com.example.demo;

import lombok.Data;

/**
 * @Author: 翁舒航
 * @Description: ${description}
 * @Date: 2020-04-22 0:05
 * @Version: 1.0
 */
@Data
public class TextEntity {

    /** id */
    private Long textId;

    /** 文本名 */
    private String textName;

    /** 文本内容 */
    private String textValue;

    /** 文本url */
    private String textUrl;

}
