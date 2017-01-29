package com.flash.logic.rest;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

public abstract class ServiceMethodGenerator {

    protected MethodSpec.Builder mMethodSpec;

    public ServiceMethodGenerator(String methodName, String pathFieldName) {
        // create method with the name and with the specified annotation.
        mMethodSpec = MethodSpec.methodBuilder(methodName);
    }

    public ServiceMethodGenerator setReturnType(TypeName returnType) {
        ClassName retrofitCall = ClassName.get("retrofit2", "Call");
        TypeName methodReturnType = ParameterizedTypeName.get(retrofitCall, returnType);

        mMethodSpec.returns(methodReturnType);
        return this;
    }

    public MethodSpec build() {
        return mMethodSpec.build();
    }
}
