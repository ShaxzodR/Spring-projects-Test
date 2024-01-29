package com.example.spring.domain.enumation;

public enum Status {
    ACTIVE, //Yangi yaratilganda shu statusda bo'ladi
    PENDING, //Topshiriq ish jarayonida ekanligini bildiradi
    STOPPED, //Topshiriq vaqtincha to'xtatilganligini bildiradi
    FINISHED,//Topshiriq muvoffaqiyatli yakunlanganini bildiradi
    REJECTED//Topshiriq bekor qilinganini bildiradi
}
