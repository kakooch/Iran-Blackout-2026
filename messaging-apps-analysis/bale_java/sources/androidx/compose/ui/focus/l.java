package androidx.compose.ui.focus;

import androidx.compose.ui.focus.m;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC20346rr2;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public final class l implements k {
    private boolean a = true;
    private m b;
    private m c;
    private m d;
    private m e;
    private m f;
    private m g;
    private m h;
    private m i;
    private UA2 j;
    private UA2 k;

    public l() {
        m.a aVar = m.b;
        this.b = aVar.b();
        this.c = aVar.b();
        this.d = aVar.b();
        this.e = aVar.b();
        this.f = aVar.b();
        this.g = aVar.b();
        this.h = aVar.b();
        this.i = aVar.b();
        this.j = a.e;
        this.k = b.e;
    }

    @Override // androidx.compose.ui.focus.k
    public UA2 A() {
        return this.k;
    }

    @Override // androidx.compose.ui.focus.k
    public m b() {
        return this.f;
    }

    @Override // androidx.compose.ui.focus.k
    public m f() {
        return this.h;
    }

    @Override // androidx.compose.ui.focus.k
    public m p() {
        return this.g;
    }

    @Override // androidx.compose.ui.focus.k
    public void q(UA2 ua2) {
        this.j = ua2;
    }

    @Override // androidx.compose.ui.focus.k
    public m r() {
        return this.d;
    }

    @Override // androidx.compose.ui.focus.k
    public m s() {
        return this.i;
    }

    @Override // androidx.compose.ui.focus.k
    public m t() {
        return this.e;
    }

    @Override // androidx.compose.ui.focus.k
    public void u(boolean z) {
        this.a = z;
    }

    @Override // androidx.compose.ui.focus.k
    public boolean v() {
        return this.a;
    }

    @Override // androidx.compose.ui.focus.k
    public m w() {
        return this.c;
    }

    @Override // androidx.compose.ui.focus.k
    public void x(UA2 ua2) {
        this.k = ua2;
    }

    @Override // androidx.compose.ui.focus.k
    public UA2 y() {
        return this.j;
    }

    @Override // androidx.compose.ui.focus.k
    public m z() {
        return this.b;
    }

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC20346rr2) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC20346rr2 interfaceC20346rr2) {
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC20346rr2) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC20346rr2 interfaceC20346rr2) {
        }
    }
}
