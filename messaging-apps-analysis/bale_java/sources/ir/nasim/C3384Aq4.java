package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.Aq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3384Aq4 implements InterfaceC24572yq4 {
    private final View a;
    private final C5276Iq4 b;
    private final int[] c;

    public C3384Aq4(View view) {
        this.a = view;
        C5276Iq4 c5276Iq4 = new C5276Iq4(view);
        c5276Iq4.n(true);
        this.b = c5276Iq4;
        this.c = new int[2];
        AbstractC12990fW7.D0(view, true);
    }

    private final void a() {
        if (this.b.l(0)) {
            this.b.s(0);
        }
        if (this.b.l(1)) {
            this.b.s(1);
        }
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long H0(long j, long j2, int i) {
        if (!this.b.q(AbstractC3623Bq4.g(j2), AbstractC3623Bq4.k(i))) {
            return ZG4.b.c();
        }
        AbstractC9648aK.w(this.c, 0, 0, 0, 6, null);
        this.b.e(AbstractC3623Bq4.f(Float.intBitsToFloat((int) (j >> 32))), AbstractC3623Bq4.f(Float.intBitsToFloat((int) (j & 4294967295L))), AbstractC3623Bq4.f(Float.intBitsToFloat((int) (j2 >> 32))), AbstractC3623Bq4.f(Float.intBitsToFloat((int) (j2 & 4294967295L))), null, AbstractC3623Bq4.k(i), this.c);
        return AbstractC3623Bq4.j(this.c, j2);
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public Object i0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!this.b.a(AbstractC3623Bq4.l(C17718nR7.h(j2)), AbstractC3623Bq4.l(C17718nR7.i(j2)), true)) {
            j2 = C17718nR7.b.a();
        }
        a();
        return C17718nR7.b(j2);
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long s1(long j, int i) {
        if (!this.b.q(AbstractC3623Bq4.g(j), AbstractC3623Bq4.k(i))) {
            return ZG4.b.c();
        }
        AbstractC9648aK.w(this.c, 0, 0, 0, 6, null);
        this.b.d(AbstractC3623Bq4.f(Float.intBitsToFloat((int) (j >> 32))), AbstractC3623Bq4.f(Float.intBitsToFloat((int) (4294967295L & j))), this.c, null, AbstractC3623Bq4.k(i));
        return AbstractC3623Bq4.j(this.c, j);
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public Object w0(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!this.b.b(AbstractC3623Bq4.l(C17718nR7.h(j)), AbstractC3623Bq4.l(C17718nR7.i(j)))) {
            j = C17718nR7.b.a();
        }
        a();
        return C17718nR7.b(j);
    }
}
