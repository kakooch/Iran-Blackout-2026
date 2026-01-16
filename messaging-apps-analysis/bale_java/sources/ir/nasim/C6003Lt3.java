package ir.nasim;

import ir.nasim.C9475a16;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Lt3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6003Lt3 {
    private final Object a = new Object();
    private List b = new ArrayList();
    private List c = new ArrayList();
    private boolean d = true;

    /* renamed from: ir.nasim.Lt3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ HE0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HE0 he0) {
            super(1);
            this.f = he0;
        }

        public final void a(Throwable th) {
            Object obj = C6003Lt3.this.a;
            C6003Lt3 c6003Lt3 = C6003Lt3.this;
            HE0 he0 = this.f;
            synchronized (obj) {
                c6003Lt3.b.remove(he0);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        if (e()) {
            return C19938rB7.a;
        }
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        synchronized (this.a) {
            this.b.add(ie0);
        }
        ie0.J(new a(ie0));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    public final void d() {
        synchronized (this.a) {
            this.d = false;
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }

    public final void f() {
        synchronized (this.a) {
            try {
                if (e()) {
                    return;
                }
                List list = this.b;
                this.b = this.c;
                this.c = list;
                this.d = true;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    InterfaceC20295rm1 interfaceC20295rm1 = (InterfaceC20295rm1) list.get(i);
                    C9475a16.a aVar = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
                }
                list.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
