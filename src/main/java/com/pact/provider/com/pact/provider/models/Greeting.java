package com.pact.provider.com.pact.provider.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

@Data
@AllArgsConstructor
public class Greeting {

    private long id;
    private String content;

}