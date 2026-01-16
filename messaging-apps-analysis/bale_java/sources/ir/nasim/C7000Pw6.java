package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Pw6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C7000Pw6 {
    private C7000Pw6 a;
    private final LW7 b;
    private final List c;
    private final InterfaceC23384wp6 d;

    /* renamed from: ir.nasim.Pw6$a */
    static final class a extends V06 implements InterfaceC14603iB2 {
        Object a;
        int b;
        private /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C7000Pw6.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r5.a
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r5.c
                ir.nasim.Op6 r3 = (ir.nasim.AbstractC6703Op6) r3
                ir.nasim.AbstractC10685c16.b(r6)
                goto L6a
            L1a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L22:
                java.lang.Object r1 = r5.c
                ir.nasim.Op6 r1 = (ir.nasim.AbstractC6703Op6) r1
                ir.nasim.AbstractC10685c16.b(r6)
                goto L3f
            L2a:
                ir.nasim.AbstractC10685c16.b(r6)
                java.lang.Object r6 = r5.c
                r1 = r6
                ir.nasim.Op6 r1 = (ir.nasim.AbstractC6703Op6) r1
                ir.nasim.Pw6 r6 = ir.nasim.C7000Pw6.this
                r5.c = r1
                r5.b = r3
                java.lang.Object r6 = r1.c(r6, r5)
                if (r6 != r0) goto L3f
                return r0
            L3f:
                ir.nasim.Pw6 r6 = ir.nasim.C7000Pw6.this
                java.util.List r6 = r6.c()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Iterator r6 = r6.iterator()
            L50:
                boolean r4 = r6.hasNext()
                if (r4 == 0) goto L64
                java.lang.Object r4 = r6.next()
                ir.nasim.Pw6 r4 = (ir.nasim.C7000Pw6) r4
                ir.nasim.wp6 r4 = r4.b()
                ir.nasim.ZW0.C(r3, r4)
                goto L50
            L64:
                java.util.Iterator r6 = r3.iterator()
                r3 = r1
                r1 = r6
            L6a:
                boolean r6 = r1.hasNext()
                if (r6 == 0) goto L83
                java.lang.Object r6 = r1.next()
                ir.nasim.Pw6 r6 = (ir.nasim.C7000Pw6) r6
                r5.c = r3
                r5.a = r1
                r5.b = r2
                java.lang.Object r6 = r3.c(r6, r5)
                if (r6 != r0) goto L6a
                return r0
            L83:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7000Pw6.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private C7000Pw6(C7000Pw6 c7000Pw6, LW7 lw7) {
        this.a = c7000Pw6;
        this.b = lw7;
        List listC = lw7.c();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(new C7000Pw6(this, (LW7) it.next()));
        }
        this.c = AbstractC15401jX0.p1(arrayList);
        this.d = AbstractC9131Yp6.b(new a(null));
    }

    public final C7000Pw6 a() {
        C7000Pw6 c7000Pw6 = this.a;
        if (c7000Pw6 == null) {
            return this;
        }
        AbstractC13042fc3.f(c7000Pw6);
        return c7000Pw6.a();
    }

    public final InterfaceC23384wp6 b() {
        return this.d;
    }

    public final List c() {
        return this.c;
    }

    public final InterfaceC16813lu3 d() {
        Object objE = this.b.e();
        if (objE instanceof InterfaceC16813lu3) {
            return (InterfaceC16813lu3) objE;
        }
        return null;
    }

    public final void e(C7000Pw6 c7000Pw6) {
        List list;
        C7000Pw6 c7000Pw62 = this.a;
        if (c7000Pw62 != null && (list = c7000Pw62.c) != null) {
            list.remove(this);
        }
        c7000Pw6.c.add(this);
        this.a = c7000Pw6;
    }

    public final LW7 f() {
        String strD = this.b.d();
        int iF = this.b.f();
        C25005za3 c25005za3B = this.b.b();
        TH6 th6G = this.b.g();
        List list = this.c;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((C7000Pw6) it.next()).f());
        }
        return new LW7(strD, iF, c25005za3B, th6G, arrayList, this.b.e());
    }

    public C7000Pw6(LW7 lw7) {
        this(null, lw7);
    }
}
