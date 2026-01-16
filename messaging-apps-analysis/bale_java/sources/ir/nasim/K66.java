package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import java.util.List;

/* loaded from: classes.dex */
public final class K66 implements InterfaceC10970cW3, G66 {
    private final C24254yJ.e a;
    private final InterfaceC12529em.c b;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5[] e;
        final /* synthetic */ K66 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ int[] i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5[] abstractC21430te5Arr, K66 k66, int i, int i2, int[] iArr) {
            super(1);
            this.e = abstractC21430te5Arr;
            this.f = k66;
            this.g = i;
            this.h = i2;
            this.i = iArr;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5[] abstractC21430te5Arr = this.e;
            K66 k66 = this.f;
            int i = this.g;
            int i2 = this.h;
            int[] iArr = this.i;
            int length = abstractC21430te5Arr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                AbstractC21430te5 abstractC21430te5 = abstractC21430te5Arr[i3];
                AbstractC13042fc3.f(abstractC21430te5);
                AbstractC21430te5.a.h(aVar, abstractC21430te5, iArr[i4], k66.v(abstractC21430te5, F66.d(abstractC21430te5), i, i2), 0.0f, 4, null);
                i3++;
                i4++;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public K66(C24254yJ.e eVar, InterfaceC12529em.c cVar) {
        this.a = eVar;
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int v(AbstractC21430te5 abstractC21430te5, I66 i66, int i, int i2) {
        AbstractC5075Hu1 abstractC5075Hu1A = i66 != null ? i66.a() : null;
        return abstractC5075Hu1A != null ? abstractC5075Hu1A.a(i - abstractC21430te5.A0(), EnumC12613eu3.a, abstractC21430te5, i2) : this.b.a(0, i - abstractC21430te5.A0());
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return C9816ac3.a.c(list, i, interfaceC10436bc3.B0(this.a.a()));
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        return H66.a(this, C17833ne1.n(j), C17833ne1.m(j), C17833ne1.l(j), C17833ne1.k(j), interfaceC12377eW3.B0(this.a.a()), interfaceC12377eW3, list, new AbstractC21430te5[list.size()], 0, list.size(), (SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER & 1024) != 0 ? null : null, (SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER & 2048) != 0 ? 0 : 0);
    }

    @Override // ir.nasim.G66
    public int c(AbstractC21430te5 abstractC21430te5) {
        return abstractC21430te5.A0();
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return C9816ac3.a.b(list, i, interfaceC10436bc3.B0(this.a.a()));
    }

    @Override // ir.nasim.G66
    public InterfaceC11734dW3 e(AbstractC21430te5[] abstractC21430te5Arr, InterfaceC12377eW3 interfaceC12377eW3, int i, int[] iArr, int i2, int i3, int[] iArr2, int i4, int i5, int i6) {
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, i2, i3, null, new a(abstractC21430te5Arr, this, i3, i, iArr), 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K66)) {
            return false;
        }
        K66 k66 = (K66) obj;
        return AbstractC13042fc3.d(this.a, k66.a) && AbstractC13042fc3.d(this.b, k66.b);
    }

    @Override // ir.nasim.G66
    public long f(int i, int i2, int i3, int i4, boolean z) {
        return J66.a(z, i, i2, i3, i4);
    }

    @Override // ir.nasim.G66
    public int g(AbstractC21430te5 abstractC21430te5) {
        return abstractC21430te5.P0();
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return C9816ac3.a.d(list, i, interfaceC10436bc3.B0(this.a.a()));
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return C9816ac3.a.a(list, i, interfaceC10436bc3.B0(this.a.a()));
    }

    @Override // ir.nasim.G66
    public void j(int i, int[] iArr, int[] iArr2, InterfaceC12377eW3 interfaceC12377eW3) {
        this.a.b(interfaceC12377eW3, i, iArr, interfaceC12377eW3.getLayoutDirection(), iArr2);
    }

    public String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.a + ", verticalAlignment=" + this.b + ')';
    }
}
