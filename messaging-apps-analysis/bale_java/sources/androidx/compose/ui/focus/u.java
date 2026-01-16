package androidx.compose.ui.focus;

import ir.nasim.AbstractC10434bc1;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.C22391v93;
import ir.nasim.ED1;
import ir.nasim.InterfaceC22987w93;
import ir.nasim.InterfaceC9814ac1;

/* loaded from: classes2.dex */
public abstract class u {
    public static final a a = new a(null);
    private static final int b = e(1);
    private static final int c = e(0);
    private static final int d = e(2);

    public static final class a {
        private a() {
        }

        public final int a() {
            return u.b;
        }

        public final int b() {
            return u.d;
        }

        public final int c() {
            return u.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean d(int i, InterfaceC9814ac1 interfaceC9814ac1) {
        if (f(i, b)) {
            return true;
        }
        if (f(i, c)) {
            return true ^ C22391v93.f(((InterfaceC22987w93) AbstractC10434bc1.a(interfaceC9814ac1, AbstractC13040fc1.m())).a(), C22391v93.b.b());
        }
        if (f(i, d)) {
            return false;
        }
        throw new IllegalStateException("Unknown Focusability".toString());
    }

    private static int e(int i) {
        return i;
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }
}
