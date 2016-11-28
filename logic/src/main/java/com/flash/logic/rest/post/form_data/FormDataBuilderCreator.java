package com.flash.logic.rest.post.form_data;

import com.flash.logic.utils.NameUtils;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.util.*;

public class FormDataBuilderCreator {

    public static final String NAME_REQUEST_BODY_MAP = "mRequestBodyMap";
    public static final String NAME_FILE_PART_LIST = "mFilePartList";

    private TypeSpec.Builder mClassBuilder;
    private Set<String> mIdentifiers = new HashSet<String>();
    private MethodSpec.Builder mConstructorBuilder;
    private boolean mIsFileBuilderAdded = false;
    private final ClassName mBuilderClass;

    public FormDataBuilderCreator() {

        mBuilderClass = ClassName.get("", "Builder");

        mClassBuilder = TypeSpec.classBuilder(mBuilderClass)
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

        FieldSpec fieldMapRequestBody
                = FieldSpec.builder(mapOfStringandRequestBody, NAME_REQUEST_BODY_MAP, Modifier.PRIVATE, Modifier.FINAL)
                .build();

        mConstructorBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$N = new $T<>()", NAME_REQUEST_BODY_MAP, hashMap)
                ;

       mClassBuilder.addField(fieldMapRequestBody);
    }

    public TypeSpec getAndEndClassBuilder() {
        return mClassBuilder.build();
    }

    public void addBuilderMethod(String identifier) {

        NameUtils nameUtils = new NameUtils();
        String javaIdentifierName = nameUtils.getLegalJavaItentifier(identifier);

        if (mIdentifiers.contains(javaIdentifierName)) {
            return;
        }

        mIdentifiers.add(javaIdentifierName);

        String constantFieldName = "PART_" + nameUtils.getCapitalised(javaIdentifierName);
        String methodName = nameUtils.getCamelCase(javaIdentifierName, true);
        String parameterName = nameUtils.getCamelCase(javaIdentifierName, false);


        ClassName requestBody = ClassName.get("okhttp3", "RequestBody");
        ClassName mediaType = ClassName.get("okhttp3", "MediaType");

        FieldSpec constantField
                = FieldSpec.builder(String.class, constantFieldName, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S", identifier).build();

        MethodSpec builderMethod = MethodSpec.methodBuilder("with" + methodName)
                .returns(mBuilderClass.topLevelClassName())
                .addParameter(String.class, parameterName)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$N.put($N, $T.create($T.parse(\"text/plain\"), $N))", NAME_REQUEST_BODY_MAP, constantFieldName, requestBody, mediaType, parameterName)
                .addStatement("return this")
                .build();

        mClassBuilder.addField(constantField).addMethod(builderMethod);

    }

    public void addFileBuilderMethod(String identifier) {

        NameUtils nameUtils = new NameUtils();
        String javaIdentifierName = nameUtils.getLegalJavaItentifier(identifier);

        if (mIdentifiers.contains(javaIdentifierName)) {
            return;
        }

        mIdentifiers.add(javaIdentifierName);

        if (!mIsFileBuilderAdded) {
            ClassName arrayList = ClassName.get(ArrayList.class);
            ClassName list = ClassName.get(List.class);
            ClassName multipartBodyPart = ClassName.get("okhttp3.MultipartBody", "Part");
            TypeName listOfMultipartBodyPart = ParameterizedTypeName.get(list, multipartBodyPart);
            FieldSpec fieldListMultipartRequestBody
                    = FieldSpec.builder(listOfMultipartBodyPart, NAME_FILE_PART_LIST, Modifier.PRIVATE, Modifier.FINAL)
                    .build();

            mClassBuilder.addField(fieldListMultipartRequestBody);
            mConstructorBuilder.addStatement("$N = new $T<>()", NAME_FILE_PART_LIST, arrayList);
            mIsFileBuilderAdded = true;
        }

        String constantFieldName = "PART_" + nameUtils.getCapitalised(javaIdentifierName);
        String methodName = nameUtils.getCamelCase(javaIdentifierName, true);
        String pathParameterName = nameUtils.getCamelCase(javaIdentifierName, false);
        String parameterUploadCallback = "uploadCallbacks";
        String variableFile = "file";
        String variableRequestBody = "requestBody";

        ClassName uploadCallbackClassName = ClassName.get("com.libapi", "UploadCallbacks");
        ClassName file = ClassName.get(File.class);
        ClassName requestBody = ClassName.get("com.libapi", "ProgressRequestBody");
        ClassName multipartBody = ClassName.get("okhttp3", "MultipartBody");

        FieldSpec constantField
                = FieldSpec.builder(String.class, constantFieldName, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S", identifier).build();

        MethodSpec builderMethod = MethodSpec.methodBuilder("add" + methodName)
                .returns(mBuilderClass.topLevelClassName())
                .addParameter(String.class, pathParameterName)
                .addParameter(uploadCallbackClassName, parameterUploadCallback)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$T $N = new $T($N)", file, variableFile, file, pathParameterName)
                .addStatement("$T $N = new $T($N, $N)", requestBody, variableRequestBody, requestBody, variableFile, parameterUploadCallback)
                .addStatement("$N.add($T.Part.createFormData($N, $N.getName(), $N))", NAME_FILE_PART_LIST, multipartBody, constantField, variableFile, variableRequestBody)
                .addStatement("return this")
                .build();

        mClassBuilder.addField(constantField).addMethod(builderMethod);
    }

    public void createBuildsMethod(TypeName typeName) {
        mClassBuilder.addMethod(mConstructorBuilder.build());

        MethodSpec buildMethod = MethodSpec.methodBuilder("build")
                .returns(typeName)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return new $T(this)", typeName)
                .build();

        mClassBuilder.addMethod(buildMethod);
    }
}
