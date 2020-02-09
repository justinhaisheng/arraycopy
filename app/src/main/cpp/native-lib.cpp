#include <jni.h>
#include <string>
#include <string.h>
#include <android/log.h>
#include <stdexcept>

/*
class Exception: public out_of_range
{
public:
    string msg;

public:
    Exception(string msg):out_of_range(msg){
        this->msg = msg;
    }

public:
    const char *what() const {
        return this->msg.c_str();
    }

};
*/

extern "C" JNIEXPORT jstring JNICALL
Java_com_aispeech_array_1copy_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT void JNICALL
Java_com_aispeech_array_1copy_MainActivity_arraycopy(JNIEnv *env, jclass type, jobject src, jint srcPos,
                                                 jobject dest, jint destPos, jint length) {

    // 做一些列的判断 ，是不是数组
    // 做一系列的准备工作 ，如果有异常，挂了，程序是会崩掉
    // buggly  so库报错 ，如果有抛 java 层的异常，是可以 try ，但是很多情况下并不会抛java层的异常
    // 如果没抛 java 层的异常，在 java 层 try 了 依旧会蹦
    // src
    // dest
    // 都是 java 数组，需要类型转换 reinterpret_cast static_cast dynamic_cast(最佳)
    // dynamic_cast 但是必须包含多态类型
    jobjectArray src_array = reinterpret_cast<jobjectArray>(src);
    jobjectArray dest_array = reinterpret_cast<jobjectArray>(dest);
    if (src_array != NULL && dest_array != NULL) {
        __android_log_print(ANDROID_LOG_ERROR, "TAG", "转换成功");

        // 设置值
        for (int i = srcPos; i < srcPos + length; ++i) {
            jobject obj = env->GetObjectArrayElement(src_array,i);
            // 放到新的数组里面
            env->SetObjectArrayElement(dest_array,i,obj);
        }
        // 完毕
    }
}