package com.flash.logic.rest.post.form_data;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

public class RetrofitInterfaceCreator {

    private TypeSpec.Builder mServiceInterface;
    private String mPackageName;

    public void generateImports() {

    }

    public void createMembers() {

    }

    public void createInterface(String packageName, String interfaceName) {
        mPackageName = packageName;
        mServiceInterface = TypeSpec.interfaceBuilder(interfaceName).addModifiers(Modifier.PUBLIC);

    }

    public void createFile(String destinationFolder) throws IOException{
        JavaFile javaFile = JavaFile.builder(mPackageName, mServiceInterface.build()).indent("    ").build();
        javaFile.writeTo(new File(destinationFolder));
    }

}
