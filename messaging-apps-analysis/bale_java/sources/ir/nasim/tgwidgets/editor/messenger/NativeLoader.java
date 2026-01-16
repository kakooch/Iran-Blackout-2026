package ir.nasim.tgwidgets.editor.messenger;

import android.os.Build;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;

/* loaded from: classes7.dex */
public abstract class NativeLoader {
    private static volatile boolean a = false;
    public static StringBuilder b = new StringBuilder();

    public static String a() {
        String str;
        String str2 = "mips";
        String str3 = "armeabi";
        try {
            str = Build.CPU_ABI;
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        if (str.equalsIgnoreCase("x86_64")) {
            str2 = "x86_64";
        } else if (str.equalsIgnoreCase("arm64-v8a")) {
            str2 = "arm64-v8a";
        } else {
            if (!str.equalsIgnoreCase("armeabi-v7a")) {
                if (str.equalsIgnoreCase("armeabi")) {
                    str2 = "armeabi";
                } else if (str.equalsIgnoreCase("x86")) {
                    str2 = "x86";
                } else if (!str.equalsIgnoreCase("mips")) {
                    if (AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.b("Unsupported arch: " + str);
                    }
                    str2 = "armeabi";
                }
                String property = System.getProperty("os.arch");
                return (property == null && property.contains("686")) ? "x86" : str3;
            }
            str2 = "armeabi-v7a";
        }
        str3 = str2;
        String property2 = System.getProperty("os.arch");
        if (property2 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[Catch: all -> 0x001b, TryCatch #3 {all -> 0x001b, blocks: (B:9:0x000a, B:11:0x0015, B:19:0x0022, B:21:0x0053, B:23:0x0057, B:26:0x005f, B:30:0x007a, B:32:0x007e, B:33:0x00ad, B:29:0x006a), top: B:50:0x000a, outer: #4, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void b(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.NativeLoader.b(android.content.Context):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.NativeLoader.c(android.content.Context, java.io.File, java.io.File, java.lang.String):boolean");
    }

    public static boolean d() {
        return a;
    }

    private static native void init(String str, boolean z);
}
