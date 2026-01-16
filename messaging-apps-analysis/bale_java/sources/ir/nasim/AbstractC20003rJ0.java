package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.rJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20003rJ0 implements LB2 {
    public final InterfaceC11938do1 a;
    public final int b;
    public final EnumC6162Ml0 c;

    /* renamed from: ir.nasim.rJ0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4806Gq2 d;
        final /* synthetic */ AbstractC20003rJ0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4806Gq2 interfaceC4806Gq2, AbstractC20003rJ0 abstractC20003rJ0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4806Gq2;
            this.e = abstractC20003rJ0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4806Gq2 interfaceC4806Gq2 = this.d;
                VI5 vi5P = this.e.p(interfaceC20315ro1);
                this.b = 1;
                if (AbstractC6459Nq2.B(interfaceC4806Gq2, vi5P, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rJ0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = AbstractC20003rJ0.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC20003rJ0 abstractC20003rJ0 = AbstractC20003rJ0.this;
                this.b = 1;
                if (abstractC20003rJ0.j(interfaceC16204ks5, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public AbstractC20003rJ0(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        this.a = interfaceC11938do1;
        this.b = i;
        this.c = enumC6162Ml0;
    }

    static /* synthetic */ Object i(AbstractC20003rJ0 abstractC20003rJ0, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(interfaceC4806Gq2, abstractC20003rJ0, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        return i(this, interfaceC4806Gq2, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // ir.nasim.LB2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.InterfaceC4557Fq2 g(ir.nasim.InterfaceC11938do1 r2, int r3, ir.nasim.EnumC6162Ml0 r4) {
        /*
            r1 = this;
            ir.nasim.do1 r0 = r1.a
            ir.nasim.do1 r2 = r2.X(r0)
            ir.nasim.Ml0 r0 = ir.nasim.EnumC6162Ml0.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.b
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r3 = r3 + r4
            if (r3 < 0) goto L20
            goto L23
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            ir.nasim.Ml0 r4 = r1.c
        L25:
            ir.nasim.do1 r0 = r1.a
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.b
            if (r3 != r0) goto L36
            ir.nasim.Ml0 r0 = r1.c
            if (r4 != r0) goto L36
            return r1
        L36:
            ir.nasim.rJ0 r2 = r1.l(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20003rJ0.g(ir.nasim.do1, int, ir.nasim.Ml0):ir.nasim.Fq2");
    }

    protected String h() {
        return null;
    }

    protected abstract Object j(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0);

    public InterfaceC4557Fq2 m() {
        return null;
    }

    public final InterfaceC14603iB2 n() {
        return new b(null);
    }

    public final int o() {
        int i = this.b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    public VI5 p(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC13822gs5.e(interfaceC20315ro1, this.a, o(), this.c, EnumC23959xo1.ATOMIC, null, n(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strH = h();
        if (strH != null) {
            arrayList.add(strH);
        }
        if (this.a != C18712p72.a) {
            arrayList.add("context=" + this.a);
        }
        if (this.b != -3) {
            arrayList.add("capacity=" + this.b);
        }
        if (this.c != EnumC6162Ml0.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.c);
        }
        return YA1.a(this) + '[' + AbstractC15401jX0.A0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
