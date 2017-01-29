package com.flash.logic.rest.post.form_data;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

public class FormDataApiRequestGenerator {

    private TypeSpec.Builder mClassBuilder;

    public FormDataApiRequestGenerator(String className, String packageName) {

        ClassName apiClassName = ClassName.get(packageName, className);

        mClassBuilder = TypeSpec.classBuilder(apiClassName)
                .addModifiers(Modifier.PUBLIC);
    }

    public void setServiceParameters(ClassName requestClass, ClassName responseClass,
                                     ClassName serviceClassName) {

        ClassName apiRequestClass = ClassName.get("com.libapi", "ApiRequest");
        TypeName superclassName = ParameterizedTypeName.get(apiRequestClass,
                requestClass, responseClass, serviceClassName);

        mClassBuilder.superclass(superclassName);

    }
}
