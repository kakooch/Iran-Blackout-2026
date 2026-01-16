package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.hJ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14080hJ5 extends AbstractC17902nl0 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final InterfaceC3570Bk5 a;
    private final List b;

    /* renamed from: ir.nasim.hJ5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hJ5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14080hJ5.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            byte[] bArrB = C14080hJ5.this.s().b("stickers_recent");
            if (bArrB == null) {
                return AbstractC10360bX0.m();
            }
            try {
                C14080hJ5.this.load(bArrB);
                return C14080hJ5.this.w();
            } catch (Exception e) {
                C19406qI3.b("RecentStickersStorage", "getRecent err: " + e);
                return AbstractC10360bX0.m();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C14080hJ5(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        this.a = interfaceC3570Bk5;
        this.b = new ArrayList();
    }

    public static /* synthetic */ boolean z(C14080hJ5 c14080hJ5, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = null;
        }
        return c14080hJ5.y(arrayList);
    }

    public final void C(List list) {
        AbstractC13042fc3.i(list, "newData");
        this.b.clear();
        this.b.addAll(list);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0 == null) {
            return;
        }
        try {
            this.b.clear();
            List list = this.b;
            List listL = c19084pl0.l(1);
            AbstractC13042fc3.h(listL, "getRepeatedBytes(...)");
            List<byte[]> list2 = listL;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (byte[] bArr : list2) {
                AbstractC13042fc3.f(bArr);
                arrayList.add(new C12871fJ5(bArr));
            }
            list.addAll(arrayList);
        } catch (Exception e) {
            this.b.clear();
            C19406qI3.b("RecentStickersStorage", "parse err: " + e);
        }
    }

    public final void r() {
        this.b.clear();
    }

    public final InterfaceC3570Bk5 s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        try {
            c19675ql0.m(1, this.b);
        } catch (Exception e) {
            C19406qI3.b("RecentStickersStorage", "serialize err: " + e);
        }
    }

    public final Object u(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(null), interfaceC20295rm1);
    }

    public final List w() {
        return this.b;
    }

    public final boolean y(ArrayList arrayList) {
        if (arrayList != null) {
            this.b.clear();
            this.b.addAll(arrayList);
        }
        try {
            this.a.f("stickers_recent", toByteArray());
            return true;
        } catch (Exception e) {
            C19406qI3.b("RecentStickersStorage", "saveRecent err: " + e);
            return false;
        }
    }
}
