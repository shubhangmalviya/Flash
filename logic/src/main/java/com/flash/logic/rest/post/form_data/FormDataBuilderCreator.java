package com.flash.logic.rest.post.form_data;

import com.flash.logic.utils.NameUtils;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.HashMap;
import java.util.Map;

public class FormDataBuilderCreator {

    public static final String REQUEST_BODY_MAP = "mRequestBodyMap";
    private TypeSpec.Builder mClassBuilder;

    public FormDataBuilderCreator(String packageName) {

        ClassName builder = ClassName.get(packageName, "Builder");

        mClassBuilder = TypeSpec.classBuilder(builder)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);

        createFields();

    }

    private void createFields() {
        // create map
        ClassName map = ClassName.get(Map.class);
        ClassName hashMap = ClassName.get(HashMap.class);
        ClassName string = ClassName.get(String.class);
        ClassName requestBody = ClassName.get("okhttp3", "RequestBody");
        TypeName mapOfStringandRequestBody = ParameterizedTypeName.get(map, string, requestBody);

        FieldSpec builderClassFields
                = FieldSpec.builder(mapOfStringandRequestBody, REQUEST_BODY_MAP, Modifier.PRIVATE, Modifier.FINAL)
                .build();

        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$N = new $T<>()", REQUEST_BODY_MAP, hashMap)
                .build();

        mClassBuilder.addMethod(constructor).addField(builderClassFields);
    }

    public TypeSpec getAndEndClassBuilder() {
        return mClassBuilder.build();
    }

    public void addBuilderMethod(String identifier) {
        NameUtils nameUtils = new NameUtils();
        String constantFieldName = "PART_" + nameUtils.getCapitalised(identifier);
        String methodName = nameUtils.getCamelCase(identifier, true);
        String parameterName = nameUtils.getCamelCase(identifier, false);

        ClassName requestBody = ClassName.get("okhttp3", "RequestBody");
        ClassName mediaType = ClassName.get("okhttp3", "MediaType");

        FieldSpec constantField
                = FieldSpec.builder(String.class, constantFieldName, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S", identifier).build();

        MethodSpec builderMethod = MethodSpec.methodBuilder("with" + methodName)
                .addParameter(String.class, parameterName)
                .addModifiers(Modifier.PUBLIC)
                // TODO include the api utils class for the request body creation.
                .addStatement("$N.put($N, $T.create($T.parse(\"text/plain\"), $N))", REQUEST_BODY_MAP, constantFieldName, requestBody, mediaType, parameterName)
                .build();

        mClassBuilder.addField(constantField).addMethod(builderMethod);

    }

    public void addFileBuilderMethod(String identifier) {
        // TODO create file body method.
    }

    public void createBuildsMethod(TypeName typeName) {
        MethodSpec buildMethod = MethodSpec.methodBuilder("build")
                .returns(typeName)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return new $T(this)", typeName)
                .build();

        mClassBuilder.addMethod(buildMethod);
    }
}
