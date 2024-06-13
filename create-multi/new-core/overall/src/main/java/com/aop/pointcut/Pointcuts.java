package com.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {


    @Pointcut("execution(* shoppingmall.project..*(..))")
    public void allPoint(){} // signature

    @Pointcut("within(shoppingmall.project..*Service*)")
    public void allService(){}

    @Pointcut("within(shoppingmall.project..*Controller*)")
    public void allController(){}

    @Pointcut("within(shoppingmall.project..*Repository*)")
    public void allRepository(){}

    @Pointcut("allPoint() && (allService() || allController() || allRepository())")
    public void allPointAndMvc(){}

    @Pointcut("execution(* *..*Init*.*(..))")
    public void initClass(){}

    @Pointcut("allPoint() ! initClass()")
    public void allPointNotInit(){}
}
