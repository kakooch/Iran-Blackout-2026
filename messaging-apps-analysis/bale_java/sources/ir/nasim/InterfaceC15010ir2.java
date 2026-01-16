package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;

/* renamed from: ir.nasim.ir2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC15010ir2 extends G66 {

    /* renamed from: ir.nasim.ir2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int[] e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ AbstractC21430te5[] i;
        final /* synthetic */ InterfaceC15010ir2 j;
        final /* synthetic */ int k;
        final /* synthetic */ EnumC12613eu3 l;
        final /* synthetic */ int m;
        final /* synthetic */ int[] n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int[] iArr, int i, int i2, int i3, AbstractC21430te5[] abstractC21430te5Arr, InterfaceC15010ir2 interfaceC15010ir2, int i4, EnumC12613eu3 enumC12613eu3, int i5, int[] iArr2) {
            super(1);
            this.e = iArr;
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = abstractC21430te5Arr;
            this.j = interfaceC15010ir2;
            this.k = i4;
            this.l = enumC12613eu3;
            this.m = i5;
            this.n = iArr2;
        }

        public final void a(AbstractC21430te5.a aVar) {
            int[] iArr = this.e;
            int i = iArr != null ? iArr[this.f] : 0;
            for (int i2 = this.g; i2 < this.h; i2++) {
                AbstractC21430te5 abstractC21430te5 = this.i[i2];
                AbstractC13042fc3.f(abstractC21430te5);
                int iR = this.j.r(abstractC21430te5, this.k, this.l, this.m) + i;
                if (this.j.m()) {
                    AbstractC21430te5.a.h(aVar, abstractC21430te5, this.n[i2 - this.g], iR, 0.0f, 4, null);
                } else {
                    AbstractC21430te5.a.h(aVar, abstractC21430te5, iR, this.n[i2 - this.g], 0.0f, 4, null);
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    @Override // ir.nasim.G66
    default int c(AbstractC21430te5 abstractC21430te5) {
        return m() ? abstractC21430te5.F0() : abstractC21430te5.N0();
    }

    @Override // ir.nasim.G66
    default InterfaceC11734dW3 e(AbstractC21430te5[] abstractC21430te5Arr, InterfaceC12377eW3 interfaceC12377eW3, int i, int[] iArr, int i2, int i3, int[] iArr2, int i4, int i5, int i6) {
        int i7;
        int i8;
        if (m()) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i8 = i3;
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, i8, i7, null, new a(iArr2, i4, i5, i6, abstractC21430te5Arr, this, i3, m() ? EnumC12613eu3.a : interfaceC12377eW3.getLayoutDirection(), i, iArr), 4, null);
    }

    @Override // ir.nasim.G66
    default long f(int i, int i2, int i3, int i4, boolean z) {
        return m() ? J66.a(z, i, i2, i3, i4) : XY0.b(z, i, i2, i3, i4);
    }

    @Override // ir.nasim.G66
    default int g(AbstractC21430te5 abstractC21430te5) {
        return m() ? abstractC21430te5.N0() : abstractC21430te5.F0();
    }

    @Override // ir.nasim.G66
    default void j(int i, int[] iArr, int[] iArr2, InterfaceC12377eW3 interfaceC12377eW3) {
        if (m()) {
            s().b(interfaceC12377eW3, i, iArr, interfaceC12377eW3.getLayoutDirection(), iArr2);
        } else {
            t().c(interfaceC12377eW3, i, iArr, iArr2);
        }
    }

    AbstractC5075Hu1 k();

    boolean m();

    default int r(AbstractC21430te5 abstractC21430te5, int i, EnumC12613eu3 enumC12613eu3, int i2) {
        AbstractC5075Hu1 abstractC5075Hu1K;
        I66 i66D = F66.d(abstractC21430te5);
        if (i66D == null || (abstractC5075Hu1K = i66D.a()) == null) {
            abstractC5075Hu1K = k();
        }
        return abstractC5075Hu1K.a(i - c(abstractC21430te5), enumC12613eu3, abstractC21430te5, i2);
    }

    C24254yJ.e s();

    C24254yJ.m t();
}
