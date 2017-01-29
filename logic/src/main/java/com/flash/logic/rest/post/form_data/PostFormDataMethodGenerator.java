package com.flash.logic.rest.post.form_data;

import com.flash.logic.rest.ServiceMethodGenerator;
import com.flash.logic.utils.NameUtils;
import com.squareup.javapoet.*;

import java.util.List;
import java.util.Map;

import static com.flash.logic.utils.RetrofitAnnotation.getRetrofitAnnotation;

public class PostFormDataMethodGenerator extends ServiceMethodGenerator {

    public PostFormDataMethodGenerator(String methodName, String pathFieldName) {
        super(methodName, pathFieldName);

        // multipart annotation
        AnnotationSpec multipartAnnotation = getRetrofitAnnotation("Multipart", null);

        // post annotation
        AnnotationSpec postAnnotation = getRetrofitAnnotation("POST", pathFieldName);

        // create method with the name and with the specified annotation.
        mMethodSpec.addAnnotation(multipartAnnotation)
                   .addAnnotation(postAnnotation);
    }

    public PostFormDataMethodGenerator addFileListParameter() {
        AnnotationSpec partAnnotation = getRetrofitAnnotation("Part", null);
        ClassName list = ClassName.get(List.class);
        ClassName multipartBodyPart = ClassName.get("okhttp3.MultipartBody", "Part");
        TypeName listOfMultipartBodyPart = ParameterizedTypeName.get(list, multipartBodyPart);

        ParameterSpec parameterSpec = ParameterSpec.builder(listOfMultipartBodyPart, "filePart")
                .addAnnotation(partAnnotation).build();

        mMethodSpec.addParameter(parameterSpec);

        return this;
    }

    public PostFormDataMethodGenerator addFileParameter() {
        AnnotationSpec partAnnotation = getRetrofitAnnotation("Part", null);
        ClassName multipartBodyPart = ClassName.get("okhttp3.MultipartBody", "Part");

        ParameterSpec parameterSpec = ParameterSpec.builder(multipartBodyPart, "part")
                .addAnnotation(partAnnotation).build();

        mMethodSpec.addParameter(parameterSpec);

        return this;
    }

    public PostFormDataMethodGenerator addRequestBodyParameter(String requestBodyName) {
        NameUtils nameUtils = new NameUtils();
        AnnotationSpec partAnnotation = getRetrofitAnnotation("Part", requestBodyName);
        String javaIdentifier = nameUtils.getLegalJavaIdentifier(requestBodyName);
        String parameterName = nameUtils.getCamelCase(javaIdentifier, false, '_');

        ClassName requestBody = ClassName.get("okhttp3", "RequestBody");

        ParameterSpec parameterSpec = ParameterSpec.builder(requestBody, parameterName)
                .addAnnotation(partAnnotation).build();

        mMethodSpec.addParameter(parameterSpec);
        return this;
    }

    public PostFormDataMethodGenerator addRequestBodyMapParameter() {
        AnnotationSpec partMap = getRetrofitAnnotation("PartMap", null);

        ClassName map = ClassName.get(Map.class);
        ClassName string = ClassName.get(String.class);
        ClassName requestBody = ClassName.get("okhttp3", "RequestBody");

        TypeName mapOfStringandRequestBody = ParameterizedTypeName.get(map, string, requestBody);

        ParameterSpec parameterSpec = ParameterSpec.builder(mapOfStringandRequestBody, "requestBodyMap")
                .addAnnotation(partMap).build();

        mMethodSpec.addParameter(parameterSpec);

        return this;
    }
}
