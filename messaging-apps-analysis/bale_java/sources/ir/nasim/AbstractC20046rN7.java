package ir.nasim;

import android.os.Looper;

/* renamed from: ir.nasim.rN7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20046rN7 {
    private static final UA2 a = a.e;

    /* renamed from: ir.nasim.rN7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(InterfaceC9764aW7 interfaceC9764aW7) {
            AbstractC13042fc3.i(interfaceC9764aW7, "$noName_0");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC9764aW7) obj);
            return C19938rB7.a;
        }
    }

    public static final void a() {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException("The method must be called on the main thread".toString());
        }
    }

    public static final void b(String str) {
        AbstractC13042fc3.i(str, "reason");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        throw new IllegalStateException(("The method must be called on the main thread. Reason: " + str + '.').toString());
    }

    public static final UA2 c() {
        return a;
    }
}
