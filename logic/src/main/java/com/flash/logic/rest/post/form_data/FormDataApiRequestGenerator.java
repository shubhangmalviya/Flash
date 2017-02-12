package com.flash.logic.rest.post.form_data;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;

public class FormDataApiRequestGenerator {

    private TypeSpec.Builder mClassBuilder;

    public FormDataApiRequestGenerator(String className, String packageName) {

        ClassName apiClassName = ClassName.get(packageName, className);

        mClassBuilder = TypeSpec.classBuilder(apiClassName)
                .addModifiers(Modifier.PUBLIC);
    }

    public void generate(ClassName requestClass, ClassName responseClass,
                         ClassName serviceClassName, MethodSpec servicesRequestMethod) {
        generateSuperclassHierarchy(requestClass, responseClass, serviceClassName);
        generateConstructor();
        generateMakeRequestMethod(requestClass, responseClass, serviceClassName);
        generateServiceClassMethod(responseClass, serviceClassName);
    }

    private void generateSuperclassHierarchy(ClassName requestClass, ClassName responseClass,
                                             ClassName serviceClassName) {
        ClassName apiRequestClass = ClassName.get("com.libapi", "ApiRequest");
        TypeName superclassName = ParameterizedTypeName.get(apiRequestClass,
                requestClass, responseClass, serviceClassName);

        mClassBuilder.superclass(superclassName);
    }

    private void generateServiceClassMethod(ClassName responseClass,
                                            ClassName serviceClassName) {

        ClassName clazz = ClassName.get(Class.class);
        TypeName classOfServiceService = ParameterizedTypeName.get(clazz, serviceClassName);

        MethodSpec.Builder serviceClassMethod = MethodSpec.methodBuilder("getServiceClass")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PROTECTED)
                .returns(classOfServiceService)
                .addStatement("return $T", responseClass);

        mClassBuilder.addMethod(serviceClassMethod.build());
    }

    private void generateMakeRequestMethod(ClassName requestClass, ClassName responseClass,
                                           ClassName serviceClassName) {

        ClassName retrofitCall = ClassName.get("retrofit2", "Call");
        TypeName callOfResponse = ParameterizedTypeName.get(retrofitCall, responseClass);

        MethodSpec.Builder makeRequestMethod = MethodSpec.methodBuilder("makeRequest")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PROTECTED)
                .returns(callOfResponse)
                .addParameter(requestClass, "reqPostFormData")
                .addParameter(serviceClassName, "service");
        // TODO add the return parameter.

        mClassBuilder.addMethod(makeRequestMethod.build());
    }

    private void generateConstructor() {

        ClassName errorResponseTransformer = ClassName.get("com.libapi", "ErrorResponseTransformer");
        ClassName serviceCreator = ClassName.get("com.libapi", "ServiceCreator");

        String parameterServiceCreator = "serviceCreator";
        String parameterErrorResponseTransformer = "errorResponseTransformer";

        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(serviceCreator, parameterServiceCreator)
                .addParameter(errorResponseTransformer, parameterErrorResponseTransformer)
                .addStatement("super($N, $N);", parameterErrorResponseTransformer, parameterServiceCreator);

        mClassBuilder.addMethod(constructorBuilder.build());
    }
}
