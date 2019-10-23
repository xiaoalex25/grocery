package com.xiao.processor;


import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

public class FactoryAnnotatedClass {
    private String id;
    private String simpleTypeName;
    private String qualifiedSuperClassName;
    private TypeElement annotatedClassElement;

    public FactoryAnnotatedClass(TypeElement annotatedClassElement) {
        this.annotatedClassElement = annotatedClassElement;
        Factory annotation = annotatedClassElement.getAnnotation(Factory.class);
        this.id = annotation.id();

        if (id == null || "".equals(id)) {
            throw new IllegalArgumentException( String.format("id() in @%s for class %s is null or empty! that's not allowed",
                    Factory.class.getSimpleName(), annotatedClassElement.getQualifiedName().toString()));
        }

        try {
            Class<?> clazz = annotation.type();
            this.qualifiedSuperClassName = clazz.getCanonicalName();
            this.simpleTypeName = clazz.getSimpleName();
        } catch (MirroredTypeException mte) {
            DeclaredType classTypeMirror = (DeclaredType)mte.getTypeMirror();
            TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            this.qualifiedSuperClassName = classTypeElement.getQualifiedName().toString();
            this.simpleTypeName = classTypeElement.getSimpleName().toString();
        }
    }

    public String getId() {
        return id;
    }

    public String getSimpleFactoryGroupName() {
        return simpleTypeName;
    }

    public String getQualifiedFactoryGroupName() {
        return qualifiedSuperClassName;
    }

    public TypeElement getTypeElement() {
        return annotatedClassElement;
    }
}
