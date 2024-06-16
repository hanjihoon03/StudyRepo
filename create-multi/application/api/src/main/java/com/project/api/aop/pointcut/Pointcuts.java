package com.project.api.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {


    @Pointcut("execution(* com.project.application..*(..))")
    public void allPoint(){} // signature

    @Pointcut("within(com.project.application..*Service*)")
    public void allService(){}

    @Pointcut("within(com.project.application..*Controller*)")
    public void allController(){}

    @Pointcut("within(com.project.application..*Repository*)")
    public void allRepository(){}

    @Pointcut("allPoint() && (allService() || allController() || allRepository())")
    public void allPointAndMvc(){}

    @Pointcut("execution(* *..*Init*.*(..))")
    public void initClass(){}

    @Pointcut("allPoint() && ! initClass()")
    public void allPointNotInit(){}
}
