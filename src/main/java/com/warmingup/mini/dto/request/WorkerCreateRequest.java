package com.warmingup.mini.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WorkerCreateRequest {

    private String name;

    private String teamName;

    private String role;

    private LocalDate birthday;

    private LocalDate workStartDate;

    public void isRequireValue(){
        if(this.name.isEmpty() || this.workStartDate == null || this.birthday == null || this.role.isEmpty()){
            throw new IllegalArgumentException("필수 값을 입력해주세요");
        }

        if(!this.role.equals("MANAGER") && !this.role.equals("MEMBER")){
            throw new IllegalArgumentException("역할은 MANAGER 또는 MEMBER 여야 합니다.");
        }
    }
}
