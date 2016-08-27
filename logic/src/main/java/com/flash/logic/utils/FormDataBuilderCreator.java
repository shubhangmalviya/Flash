package com.flash.logic.utils;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.Map;

public class FormDataBuilderCreator {

    TypeSpec.Builder mClassBuilder;
    FieldSpec builderClassFields;

    public FormDataBuilderCreator(String packageName) {

        ClassName builder = ClassName.get(packageName, "Builder");



        mClassBuilder = TypeSpec.classBuilder(builder)
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);

        builderClassFields = FieldSpec.builder(Map.class, "mRequestBodyMap", Modifier.PRIVATE, Modifier.FINAL).build();
    }

    protected void createFields() {

    }

    public TypeSpec.Builder getClassBuilder() {
        return mClassBuilder;
    }

    public void addBuilderMethod(String identifier) {

    }

    public void createBuildsMethod() {

    }
}
