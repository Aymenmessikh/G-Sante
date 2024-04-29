package com.example.gmt.Exeption;

public enum ErrorCode {
    EMPLOYER_POSSED_DOSSIER(1000),
    UTILISATEURE_NOT_VALID(2000);
    private int code;
    ErrorCode(int code){

        this.code=code;
    }
}
