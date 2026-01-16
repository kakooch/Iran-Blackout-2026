package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.St7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7686St7 {
    private static C7686St7 e;
    private C24438yd0 a;
    private C3263Ad0 b;
    private C20939sr4 c;
    private OO6 d;

    private C7686St7(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        Context applicationContext = context.getApplicationContext();
        this.a = new C24438yd0(applicationContext, interfaceC5684Kj7);
        this.b = new C3263Ad0(applicationContext, interfaceC5684Kj7);
        this.c = new C20939sr4(applicationContext, interfaceC5684Kj7);
        this.d = new OO6(applicationContext, interfaceC5684Kj7);
    }

    public static synchronized C7686St7 c(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        try {
            if (e == null) {
                e = new C7686St7(context, interfaceC5684Kj7);
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    public C24438yd0 a() {
        return this.a;
    }

    public C3263Ad0 b() {
        return this.b;
    }

    public C20939sr4 d() {
        return this.c;
    }

    public OO6 e() {
        return this.d;
    }
}
