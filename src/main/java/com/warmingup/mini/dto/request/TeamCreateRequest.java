package com.warmingup.mini.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeamCreateRequest {
    private String name;

    public void checkNotNullName(){
        if(this.name.isEmpty()){
            throw new IllegalArgumentException("팀 이름을 입력해주세요");
        }
    }
}
