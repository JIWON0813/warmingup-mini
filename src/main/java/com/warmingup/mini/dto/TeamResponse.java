package com.warmingup.mini.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeamResponse {

    private String name;

    private String manager;

    private int memberCount;
}
