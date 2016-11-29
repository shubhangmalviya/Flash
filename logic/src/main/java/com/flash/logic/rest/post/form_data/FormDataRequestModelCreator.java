package com.flash.logic.rest.post.form_data;

import com.flash.logic.postman.collection.detail.model.Formdata;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FormDataRequestModelCreator {

    private static final String REQUEST_BODY_MAP = "mRequestBodyMap";
    private static final String TYPE_TEXT = "text";
    private static final String TYPE_FILE = "file";

    private Formdata[] mFormdatas;
    private String mPackageName;
    private TypeSpec.Builder mFormDataRequestClassBuilder;

    private ClassName mMapClass = ClassName.get(Map.class);
    private ClassName mStringClass = ClassName.get(String.class);
    private ClassName mRequestBodyClass = ClassName.get("okhttp3", "RequestBody");
    private TypeName mMapOfStringAndRequestBodyType = ParameterizedTypeName.get(mMapClass, mStringClass, mRequestBodyClass);
    private ClassName mClassName;

    public FormDataRequestModelCreator(Formdata[] formdatas) {
        mFormdatas = formdatas;
    }

    public void createClass(String packageName, String clazz) {
        mPackageName = packageName;
        mClassName = ClassName.get(packageName, clazz);

        TypeSpec builder = createBuilder();
        ClassName builderClass = ClassName.get("", builder.name);

        String parameterRequestBuilder = "requestBuilder";
        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .addParameter(builderClass, parameterRequestBuilder)
                .addStatement("$N = $N.$N", REQUEST_BODY_MAP, parameterRequestBuilder, FormDataRequestModelCreator.REQUEST_BODY_MAP)
                .build();

        mFormDataRequestClassBuilder = TypeSpec.classBuilder(mClassName)
                .addModifiers(Modifier.PUBLIC)
                .addType(builder)
                .addMethod(constructor);

        createFields();
        createMethods();

    }

    private void createFields() {

        FieldSpec mapField
                = FieldSpec.builder(mMapOfStringAndRequestBodyType, REQUEST_BODY_MAP, Modifier.PRIVATE, Modifier.FINAL)
                .build();

        mFormDataRequestClassBuilder.addField(mapField);
    }

    private void createMethods() {
        MethodSpec methodRequestBody = MethodSpec.methodBuilder("getRequestBodyMap")
                .returns(mMapOfStringAndRequestBodyType)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return $N", REQUEST_BODY_MAP)
                .build();

        mFormDataRequestClassBuilder.addMethod(methodRequestBody);
    }

    private TypeSpec createBuilder() {
        FormDataBuilderCreator formDataBuilderCreator = new FormDataBuilderCreator();

        for (Formdata formdata :  mFormdatas) {
            if (TYPE_TEXT.equals(formdata.getType())) {
                formDataBuilderCreator.addBuilderMethod(formdata.getKey());
            }else if (TYPE_FILE.equals(formdata.getType())) {
                formDataBuilderCreator.addFileBuilderMethod(formdata.getKey());
            }
        }

        formDataBuilderCreator.createBuildsMethod(mClassName);

        return formDataBuilderCreator.getAndEndClassBuilder();
    }

    public void createFile(String destinationFolder) throws IOException {
        JavaFile javaFile = JavaFile.builder(mPackageName, mFormDataRequestClassBuilder.build()).indent("    ").build();
        javaFile.writeTo(new File(destinationFolder));
    }
}
