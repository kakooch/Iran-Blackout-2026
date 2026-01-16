package ir.nasim;

import android.content.SharedPreferences;
import android.os.Build;
import java.nio.charset.Charset;

/* renamed from: ir.nasim.wI7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23073wI7 {
    public static int d;
    public static byte[] f;
    public static boolean i;
    public static boolean j;
    public static long k;
    private static long l;
    private static final String m;
    public static boolean n;
    private static final Object o;
    public static final int p;
    public static final C23073wI7 a = new C23073wI7();
    public static int b = -210000;
    private static int c = -210000;
    public static boolean e = true;
    public static String g = "";
    private static String h = "";

    static {
        String strSubstring = (Build.SERIAL + "m0").substring(1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        m = strSubstring;
        o = new Object();
        f = new byte[16];
        p = 8;
    }

    private C23073wI7() {
    }

    public static final boolean b(String str) {
        AbstractC13042fc3.i(str, "passcode");
        if (f.length != 0) {
            try {
                Charset charsetForName = Charset.forName("UTF-8");
                AbstractC13042fc3.h(charsetForName, "forName(...)");
                byte[] bytes = str.getBytes(charsetForName);
                AbstractC13042fc3.h(bytes, "getBytes(...)");
                int length = bytes.length + 32;
                byte[] bArr = new byte[length];
                System.arraycopy(f, 0, bArr, 0, 16);
                System.arraycopy(bytes, 0, bArr, 16, bytes.length);
                System.arraycopy(f, 0, bArr, bytes.length + 16, 16);
                return AbstractC13042fc3.d(g, AbstractC15318jN7.b(AbstractC15318jN7.c(bArr, 0, length)));
            } catch (Exception e2) {
                C19406qI3.d("baleMessages", e2);
                return false;
            }
        }
        boolean zD = AbstractC13042fc3.d(AbstractC15318jN7.a(str), g);
        if (zD) {
            try {
                Charset charsetForName2 = Charset.forName("UTF-8");
                AbstractC13042fc3.h(charsetForName2, "forName(...)");
                byte[] bytes2 = str.getBytes(charsetForName2);
                AbstractC13042fc3.h(bytes2, "getBytes(...)");
                int length2 = bytes2.length + 32;
                byte[] bArr2 = new byte[length2];
                System.arraycopy(f, 0, bArr2, 0, 16);
                System.arraycopy(bytes2, 0, bArr2, 16, bytes2.length);
                System.arraycopy(f, 0, bArr2, bytes2.length + 16, 16);
                String strB = AbstractC15318jN7.b(AbstractC15318jN7.c(bArr2, 0, length2));
                g = strB;
                h = strB;
                e();
            } catch (Exception e3) {
                C19406qI3.d("baleMessages", e3);
            }
        }
        return zD;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00bc A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0003, B:6:0x0025, B:10:0x0073, B:12:0x007d, B:14:0x0081, B:22:0x0105, B:24:0x0151, B:26:0x0159, B:27:0x0186, B:16:0x00bc, B:18:0x00c0, B:20:0x00c8, B:9:0x0034), top: B:32:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0105 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0003, B:6:0x0025, B:10:0x0073, B:12:0x007d, B:14:0x0081, B:22:0x0105, B:24:0x0151, B:26:0x0159, B:27:0x0186, B:16:0x00bc, B:18:0x00c0, B:20:0x00c8, B:9:0x0034), top: B:32:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c() {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23073wI7.c():void");
    }

    public static final boolean d() {
        a.c();
        return n;
    }

    public static final void e() {
        C9248Zc6 c9248Zc6H = new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.uI7
            @Override // java.lang.Runnable
            public final void run() {
                C23073wI7.f();
            }
        })).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        String name;
        boolean z;
        synchronized (o) {
            try {
                try {
                    SharedPreferences.Editor editorEdit = C5721Ko.a.d().getSharedPreferences(EnumC18608ow5.q.getValue(), 0).edit();
                    if (!n) {
                        g = AbstractC15318jN7.a(m + AbstractC15318jN7.a(Build.DEVICE));
                    }
                    boolean z2 = true;
                    if (AbstractC13042fc3.d(g, h)) {
                        z = false;
                    } else {
                        InterfaceC3570Bk5 interfaceC3570Bk5D0 = AbstractC5969Lp4.d().d0();
                        String str = MO6.d;
                        String str2 = g;
                        AbstractC13042fc3.f(str2);
                        byte[] bytes = str2.getBytes(C12275eL0.b);
                        AbstractC13042fc3.h(bytes, "getBytes(...)");
                        interfaceC3570Bk5D0.n(str, bytes);
                        h = g;
                        z = true;
                    }
                    long j2 = l;
                    long j3 = k;
                    if (j2 != j3) {
                        editorEdit.putLong("lastPauseTime1", j3);
                        l = k;
                        z = true;
                    }
                    int i2 = c;
                    int i3 = b;
                    if (i2 != i3) {
                        editorEdit.putInt("lastLocalId", i3);
                        c = b;
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        editorEdit.apply();
                    }
                } catch (Exception e2) {
                    if (a.getClass().isAnonymousClass()) {
                        name = C23073wI7.class.getName();
                        if (name.length() <= 23) {
                            AbstractC13042fc3.f(name);
                        } else {
                            AbstractC13042fc3.f(name);
                            name = name.substring(name.length() - 23, name.length());
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    } else {
                        name = C23073wI7.class.getSimpleName();
                        if (name.length() <= 23) {
                            AbstractC13042fc3.f(name);
                        } else {
                            AbstractC13042fc3.f(name);
                            name = name.substring(0, 23);
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    }
                    C19406qI3.d(name, e2);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
