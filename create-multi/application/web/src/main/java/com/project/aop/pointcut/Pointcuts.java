package com.project.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {


    @Pointcut("execution(* com.project..*(..))")
    public void allPoint(){} // signature

    @Pointcut("within(com.project..*Service*)")
    public void allService(){}

    @Pointcut("within(com.project..*Controller*)")
    public void allController(){}

    @Pointcut("within(com.project..*Repository*)")
    public void allRepository(){}

    @Pointcut("allPoint() && (allService() || allController() || allRepository())")
    public void allPointAndMvc(){}

    @Pointcut("execution(* *..*Init*.*(..))")
    public void initClass(){}

    @Pointcut("allPoint() && ! initClass()")
    public void allPointNotInit(){}
}
