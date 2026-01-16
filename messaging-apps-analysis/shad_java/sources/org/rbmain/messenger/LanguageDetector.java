package org.rbmain.messenger;

/* loaded from: classes4.dex */
public class LanguageDetector {

    public interface ExceptionCallback {
        void run(Exception exc);
    }

    public interface StringCallback {
        void run(String str);
    }

    public static void detectLanguage(String str, StringCallback stringCallback, ExceptionCallback exceptionCallback, boolean z) {
    }

    public static boolean hasSupport() {
        return true;
    }

    public static void detectLanguage(String str, StringCallback stringCallback, ExceptionCallback exceptionCallback) {
        detectLanguage(str, stringCallback, exceptionCallback, false);
    }
}
