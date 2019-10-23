package com.xiao.processor;//packageElement

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
/*
 * this class just used for example
 */
public class Foo {//typeElement

    private int a;//variableElement
    private Foo other;//variableElement

    public Foo() {
    }//executableElement

    public void setA(int newA /*typeElement*/) {
    }

    //just treat source code like xml
    public void example() {
        TypeElement fooClass = null;
        for (Element e : fooClass.getEnclosedElements()) {
            Element parent = e.getEnclosingElement();
        }
    }
}
