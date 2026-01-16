package androidx.compose.material.ripple;

import ir.nasim.AbstractC18075o26;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17484n26;
import ir.nasim.InterfaceC16930m63;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22645vb3;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class d implements InterfaceC16930m63 {
    private final boolean a;
    private final e b;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9664aL6 interfaceC9664aL6) {
            super(0);
            this.e = interfaceC9664aL6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C17484n26 invoke() {
            return (C17484n26) this.e.getValue();
        }
    }

    public d(boolean z, InterfaceC9664aL6 interfaceC9664aL6) {
        this.a = z;
        this.b = new e(z, new a(interfaceC9664aL6));
    }

    public abstract void c(InterfaceC6693Oo5.b bVar, InterfaceC20315ro1 interfaceC20315ro1);

    public final void f(InterfaceC17460n02 interfaceC17460n02, float f, long j) throws Throwable {
        this.b.b(interfaceC17460n02, Float.isNaN(f) ? AbstractC18075o26.a(interfaceC17460n02, this.a, interfaceC17460n02.d()) : interfaceC17460n02.w1(f), j);
    }

    public abstract void g(InterfaceC6693Oo5.b bVar);

    public final void h(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20315ro1 interfaceC20315ro1) {
        this.b.c(interfaceC22645vb3, interfaceC20315ro1);
    }
}
