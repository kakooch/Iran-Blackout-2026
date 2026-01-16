package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C3419Au3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class B46 extends C3419Au3.f {
    public static final B46 b = new B46();

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.p(aVar, this.e, 0, 0, 0.0f, null, 12, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list) {
            super(1);
            this.e = list;
        }

        public final void a(AbstractC21430te5.a aVar) {
            List list = this.e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AbstractC21430te5.a.p(aVar, (AbstractC21430te5) list.get(i), 0, 0, 0.0f, null, 12, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    private B46() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        int size = list.size();
        if (size == 0) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.n(j), C17833ne1.m(j), null, a.e, 4, null);
        }
        if (size == 1) {
            AbstractC21430te5 abstractC21430te5L0 = ((ZV3) list.get(0)).l0(j);
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, AbstractC19606qe1.g(j, abstractC21430te5L0.P0()), AbstractC19606qe1.f(j, abstractC21430te5L0.A0()), null, new b(abstractC21430te5L0), 4, null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            AbstractC21430te5 abstractC21430te5L02 = ((ZV3) list.get(i)).l0(j);
            iMax = Math.max(abstractC21430te5L02.P0(), iMax);
            iMax2 = Math.max(abstractC21430te5L02.A0(), iMax2);
            arrayList.add(abstractC21430te5L02);
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, AbstractC19606qe1.g(j, iMax), AbstractC19606qe1.f(j, iMax2), null, new c(arrayList), 4, null);
    }

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }

        public final void a(AbstractC21430te5.a aVar) {
        }
    }
}
