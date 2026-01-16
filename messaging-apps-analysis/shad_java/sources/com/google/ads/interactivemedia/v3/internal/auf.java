package com.google.ads.interactivemedia.v3.internal;

import java.io.PrintStream;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class auf {
    static final atz a;

    static {
        atz audVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            audVar = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new auc() : new aud() : new aue();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = aud.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            audVar = new aud();
        }
        a = audVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void a(Throwable th, Throwable th2) {
        a.a(th, th2);
    }

    public static void b(Throwable th) {
        a.b(th);
    }
}
