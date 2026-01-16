package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Oq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6705Oq implements InterfaceC10970cW3 {
    public static final C6705Oq a = new C6705Oq();

    /* renamed from: ir.nasim.Oq$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.l(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Oq$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list) {
            super(1);
            this.e = list;
        }

        public final void a(AbstractC21430te5.a aVar) {
            int iO = AbstractC10360bX0.o(this.e);
            if (iO < 0) {
                return;
            }
            int i = 0;
            while (true) {
                AbstractC21430te5.a.l(aVar, (AbstractC21430te5) this.e.get(i), 0, 0, 0.0f, 4, null);
                if (i == iO) {
                    return;
                } else {
                    i++;
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        int size = list.size();
        if (size == 0) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, 0, 0, null, a.e, 4, null);
        }
        if (size == 1) {
            AbstractC21430te5 abstractC21430te5L0 = ((ZV3) list.get(0)).l0(j);
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new b(abstractC21430te5L0), 4, null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            AbstractC21430te5 abstractC21430te5L02 = ((ZV3) list.get(i)).l0(j);
            iMax = Math.max(iMax, abstractC21430te5L02.P0());
            iMax2 = Math.max(iMax2, abstractC21430te5L02.A0());
            arrayList.add(abstractC21430te5L02);
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iMax, iMax2, null, new c(arrayList), 4, null);
    }

    /* renamed from: ir.nasim.Oq$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        public a() {
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
