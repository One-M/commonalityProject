package com.ybf.lottery.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by XQyi on 2018/3/3.
 * Use: Scope 通过自定义注解限定注解作用域。
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
