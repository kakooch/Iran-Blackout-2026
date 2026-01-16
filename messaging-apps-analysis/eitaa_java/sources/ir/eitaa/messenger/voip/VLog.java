package ir.eitaa.messenger.voip;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes.dex */
class VLog {
    public static native void d(String msg);

    public static native void e(String msg);

    public static native void i(String msg);

    public static native void v(String msg);

    public static native void w(String msg);

    VLog() {
    }

    public static void e(Throwable x) {
        e(null, x);
    }

    public static void e(String msg, Throwable x) {
        StringWriter stringWriter = new StringWriter();
        if (!TextUtils.isEmpty(msg)) {
            stringWriter.append((CharSequence) msg);
            stringWriter.append((CharSequence) ": ");
        }
        x.printStackTrace(new PrintWriter(stringWriter));
        String[] strArrSplit = stringWriter.toString().split("\n");
        for (String str : strArrSplit) {
            e(str);
        }
    }
}
