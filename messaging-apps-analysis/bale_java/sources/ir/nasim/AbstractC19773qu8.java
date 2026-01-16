package ir.nasim;

import java.io.PrintStream;

/* renamed from: ir.nasim.qu8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC19773qu8 {
    private static final AbstractC24616yu8 a;
    private static final int b;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x0007, B:7:0x000f, B:10:0x0017, B:12:0x0020, B:13:0x0026), top: B:25:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = a()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L17
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L15
            r3 = 19
            if (r2 < r3) goto L17
            ir.nasim.nv8 r2 = new ir.nasim.nv8     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            goto L5d
        L15:
            r2 = move-exception
            goto L2e
        L17:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L15
            r2 = r2 ^ r0
            if (r2 == 0) goto L26
            ir.nasim.fv8 r2 = new ir.nasim.fv8     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            goto L5d
        L26:
            ir.nasim.qu8$a r2 = new ir.nasim.qu8$a     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            goto L5d
        L2c:
            r2 = move-exception
            r1 = 0
        L2e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<ir.nasim.qu8$a> r4 = ir.nasim.AbstractC19773qu8.a.class
            java.lang.String r4 = r4.getName()
            int r5 = r4.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            r2.printStackTrace(r3)
            ir.nasim.qu8$a r2 = new ir.nasim.qu8$a
            r2.<init>()
        L5d:
            ir.nasim.AbstractC19773qu8.a = r2
            if (r1 != 0) goto L62
            goto L66
        L62:
            int r0 = r1.intValue()
        L66:
            ir.nasim.AbstractC19773qu8.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19773qu8.<clinit>():void");
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(printStream);
            return null;
        }
    }

    public static void b(Throwable th, Throwable th2) {
        a.a(th, th2);
    }

    /* renamed from: ir.nasim.qu8$a */
    static final class a extends AbstractC24616yu8 {
        a() {
        }

        @Override // ir.nasim.AbstractC24616yu8
        public final void a(Throwable th, Throwable th2) {
        }
    }
}
