package com.flash.logic.rest.post.form_data;

import com.flash.logic.utils.NameUtils;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

public class RetrofitInterfaceCreator {

    private TypeSpec.Builder mServiceInterface;
    private String mPackageName;

    public RetrofitInterfaceCreator(String interfaceName, String packageName) {
        mServiceInterface = TypeSpec.interfaceBuilder(interfaceName).addModifiers(Modifier.PUBLIC);
        mPackageName = packageName;
    }

    public void addConstantRequestPath(String requestPath) {
        NameUtils nameUtils = new NameUtils();
        String javaIdentifierName = nameUtils.getLegalJavaIdentifier(requestPath);
        String constantFieldName = "PATH_" + nameUtils.getCapitalised(javaIdentifierName);
        String methodName = nameUtils.getCamelCase(javaIdentifierName, true, '/');

        generateField(requestPath, constantFieldName);
    }

    public void addMemberFunction(MethodSpec methodSpec) {
        mServiceInterface.addMethod(methodSpec);
    }

    private void generateField(String path, String constantFieldName) {

        FieldSpec mapField
                = FieldSpec.builder(String.class, constantFieldName)
                .initializer("$S", path)
                .build();

        mServiceInterface.addField(mapField);
    }

    public void createFile(String destinationFolder) throws IOException{
        JavaFile javaFile = JavaFile.builder(mPackageName, mServiceInterface.build()).indent("    ").build();
        javaFile.writeTo(new File(destinationFolder));
    }

}
