package com.flash.logic.utils;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

public class RetrofitAnnotation {

    public static AnnotationSpec getRetrofitAnnotation(String name, String value) {

        ClassName className = ClassName.get("retrofit2.http", name);
        AnnotationSpec.Builder builder = AnnotationSpec.builder(className);

        if (value != null) {
            builder.addMember("value", "$L", value);
        }

        return builder.build();

    }

}
