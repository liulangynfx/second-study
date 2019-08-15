#include "jni.h"
#include "com_rainea_jni_HelloJNI.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_rainea_jni_HelloJNI_sayHelloWorld(JNIEnv *env,jclass obj){
    printf("Hello World!\n");
    return;
}