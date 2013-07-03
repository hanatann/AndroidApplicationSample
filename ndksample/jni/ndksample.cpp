#include <jni.h>

#include <assert.h>
#include <ndksample.hpp>
/**
 * JNIEXPORTとJNICALLは、実は記述しなくても問題なく動作します。
 * Windows上で動作するJavaアプリケーションを作成するときにJNIを用いるときはいずれも
 * 意味があるようですが、LinuxをベースとするAndroidではどちらも必要ありません
 * （厳密に言うとJNIEXPORTはちょっとだけ意味があるようですが）。
 * 参考書でも、どちらも記述していないものが多いようです。
 * ただ、あっても害があるわけでもなく、いちいち除去するのも面倒なので、
 * そのままコピーペーストしておけば良かろうかと思います。
 * */
JNIEXPORT jstring JNICALL Java_jp_umayahara_ndksample_MainActivity_msgFromNDK
(JNIEnv *env, jobject thiz, jint count) {
    const char *capital[] = { "東京", "ワシントン", "ロンドン", "パリ", "モスクワ", "北京" };
    jstring jstr = env->NewStringUTF(capital[count]);
    assert(jstr);
    return jstr;
}
