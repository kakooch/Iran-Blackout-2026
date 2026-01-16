package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class HT4 implements InterfaceC11049ce6 {
    public static final g h = new g(null);
    private static final InterfaceC8230Vb6 i = WB3.a(e.e, f.e);
    private final C19206px3 a;
    private final InterfaceC9102Ym4 b;
    private final InterfaceC9102Ym4 c = AbstractC13472gH6.d(0, null, 2, null);
    private final InterfaceC9664aL6 d = AbstractC10222bH6.d(new d());
    private final InterfaceC9664aL6 e = AbstractC10222bH6.d(new c());
    private final InterfaceC9102Ym4 f = AbstractC13472gH6.d(null, null, 2, null);
    private final InterfaceC9102Ym4 g = AbstractC13472gH6.d(null, null, 2, null);

    static final class a extends AbstractC22163um1 {
        Object a;
        int b;
        int c;
        float d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return HT4.this.i(0, 0.0f, this);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            float fL;
            if (HT4.this.l() != null) {
                fL = AbstractC23053wG5.l((-r0.getOffset()) / (r0.f() + HT4.this.n()), -0.5f, 0.5f);
            } else {
                fL = 0.0f;
            }
            return Float.valueOf(fL);
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(HT4.this.o().x().g());
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(InterfaceC8730Xb6 interfaceC8730Xb6, HT4 ht4) {
            AbstractC13042fc3.i(interfaceC8730Xb6, "$this$listSaver");
            AbstractC13042fc3.i(ht4, "it");
            return AbstractC9766aX0.e(Integer.valueOf(ht4.k()));
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HT4 invoke(List list) {
            AbstractC13042fc3.i(list, "it");
            Object obj = list.get(0);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Int");
            return new HT4(((Integer) obj).intValue());
        }
    }

    public static final class g {
        private g() {
        }

        public final InterfaceC8230Vb6 a() {
            return HT4.i;
        }

        public /* synthetic */ g(ED1 ed1) {
            this();
        }
    }

    public HT4(int i2) {
        this.a = new C19206px3(i2, 0, 2, null);
        this.b = AbstractC13472gH6.d(Integer.valueOf(i2), null, 2, null);
    }

    public static /* synthetic */ Object j(HT4 ht4, int i2, float f2, InterfaceC20295rm1 interfaceC20295rm1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = 0.0f;
        }
        return ht4.i(i2, f2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC7948Tw3 l() {
        Object objPrevious;
        List listI = this.a.x().i();
        ListIterator listIterator = listI.listIterator(listI.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((InterfaceC7948Tw3) objPrevious).getIndex() == k()) {
                break;
            }
        }
        return (InterfaceC7948Tw3) objPrevious;
    }

    private final int r() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final void t(int i2, String str) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException((str + '[' + i2 + "] must be >= 0").toString());
    }

    private final void u(float f2, String str) {
        if (-1.0f > f2 || f2 > 1.0f) {
            throw new IllegalArgumentException((str + " must be >= -1 and <= 1").toString());
        }
    }

    private final void v(Integer num) {
        this.f.setValue(num);
    }

    private final void z(int i2) {
        this.b.setValue(Integer.valueOf(i2));
    }

    public final void A() {
        InterfaceC7948Tw3 interfaceC7948Tw3P = p();
        if (interfaceC7948Tw3P != null) {
            w(interfaceC7948Tw3P.getIndex());
        }
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public Object b(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.a.b(enumC15562jn4, interfaceC14603iB2, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean c() {
        return this.a.c();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public float f(float f2) {
        return this.a.f(f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0032, B:74:0x017d, B:75:0x018d, B:77:0x0193, B:80:0x01a1, B:82:0x01a5, B:84:0x01b0, B:57:0x00fd, B:58:0x010d, B:60:0x0113, B:64:0x0122, B:66:0x0126, B:69:0x0143, B:71:0x0150, B:48:0x00c4, B:50:0x00cf, B:53:0x00e2), top: B:91:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e2 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0032, B:74:0x017d, B:75:0x018d, B:77:0x0193, B:80:0x01a1, B:82:0x01a5, B:84:0x01b0, B:57:0x00fd, B:58:0x010d, B:60:0x0113, B:64:0x0122, B:66:0x0126, B:69:0x0143, B:71:0x0150, B:48:0x00c4, B:50:0x00cf, B:53:0x00e2), top: B:91:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0113 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0032, B:74:0x017d, B:75:0x018d, B:77:0x0193, B:80:0x01a1, B:82:0x01a5, B:84:0x01b0, B:57:0x00fd, B:58:0x010d, B:60:0x0113, B:64:0x0122, B:66:0x0126, B:69:0x0143, B:71:0x0150, B:48:0x00c4, B:50:0x00cf, B:53:0x00e2), top: B:91:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0126 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0032, B:74:0x017d, B:75:0x018d, B:77:0x0193, B:80:0x01a1, B:82:0x01a5, B:84:0x01b0, B:57:0x00fd, B:58:0x010d, B:60:0x0113, B:64:0x0122, B:66:0x0126, B:69:0x0143, B:71:0x0150, B:48:0x00c4, B:50:0x00cf, B:53:0x00e2), top: B:91:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0143 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0032, B:74:0x017d, B:75:0x018d, B:77:0x0193, B:80:0x01a1, B:82:0x01a5, B:84:0x01b0, B:57:0x00fd, B:58:0x010d, B:60:0x0113, B:64:0x0122, B:66:0x0126, B:69:0x0143, B:71:0x0150, B:48:0x00c4, B:50:0x00cf, B:53:0x00e2), top: B:91:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0193 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0032, B:74:0x017d, B:75:0x018d, B:77:0x0193, B:80:0x01a1, B:82:0x01a5, B:84:0x01b0, B:57:0x00fd, B:58:0x010d, B:60:0x0113, B:64:0x0122, B:66:0x0126, B:69:0x0143, B:71:0x0150, B:48:0x00c4, B:50:0x00cf, B:53:0x00e2), top: B:91:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(int r13, float r14, ir.nasim.InterfaceC20295rm1 r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HT4.i(int, float, ir.nasim.rm1):java.lang.Object");
    }

    public final int k() {
        return r();
    }

    public final float m() {
        return ((Number) this.e.getValue()).floatValue();
    }

    public final int n() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final C19206px3 o() {
        return this.a;
    }

    public final InterfaceC7948Tw3 p() {
        Object obj;
        InterfaceC9425Zw3 interfaceC9425Zw3X = this.a.x();
        Iterator it = interfaceC9425Zw3X.i().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) next;
                int iMin = Math.min(interfaceC7948Tw3.getOffset() + interfaceC7948Tw3.f(), interfaceC9425Zw3X.d() - interfaceC9425Zw3X.c()) - Math.max(interfaceC7948Tw3.getOffset(), 0);
                do {
                    Object next2 = it.next();
                    InterfaceC7948Tw3 interfaceC7948Tw32 = (InterfaceC7948Tw3) next2;
                    int iMin2 = Math.min(interfaceC7948Tw32.getOffset() + interfaceC7948Tw32.f(), interfaceC9425Zw3X.d() - interfaceC9425Zw3X.c()) - Math.max(interfaceC7948Tw32.getOffset(), 0);
                    if (iMin < iMin2) {
                        next = next2;
                        iMin = iMin2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (InterfaceC7948Tw3) obj;
    }

    public final int q() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final void s() {
        v(null);
    }

    public String toString() {
        return "PagerState(pageCount=" + q() + ", currentPage=" + k() + ", currentPageOffset=" + m() + ')';
    }

    public final void w(int i2) {
        if (i2 != r()) {
            z(i2);
        }
    }

    public final void x(SA2 sa2) {
        this.g.setValue(sa2);
    }

    public final void y(int i2) {
        this.c.setValue(Integer.valueOf(i2));
    }
}
