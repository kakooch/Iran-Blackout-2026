package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.fe6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C13065fe6 {
    private final C9023Yd6 a;
    private final InterfaceC20315ro1 b;
    private Integer c;

    /* renamed from: ir.nasim.fe6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13065fe6.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9023Yd6 c9023Yd6 = C13065fe6.this.a;
                int i2 = this.d;
                InterfaceC5766Kt interfaceC5766Kt = AbstractC8794Xi7.b;
                this.b = 1;
                if (c9023Yd6.k(i2, interfaceC5766Kt, this) == objE) {
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

    public C13065fe6(C9023Yd6 c9023Yd6, InterfaceC20315ro1 interfaceC20315ro1) {
        this.a = c9023Yd6;
        this.b = interfaceC20315ro1;
    }

    private final int b(C7587Si7 c7587Si7, WH1 wh1, int i, List list) {
        int iB0 = wh1.B0(((C7587Si7) AbstractC15401jX0.C0(list)).b()) + i;
        int iN = iB0 - this.a.n();
        return AbstractC23053wG5.m(wh1.B0(c7587Si7.a()) - ((iN / 2) - (wh1.B0(c7587Si7.c()) / 2)), 0, AbstractC23053wG5.e(iB0 - iN, 0));
    }

    public final void c(WH1 wh1, int i, List list, int i2) {
        int iB;
        Integer num = this.c;
        if (num != null && num.intValue() == i2) {
            return;
        }
        this.c = Integer.valueOf(i2);
        C7587Si7 c7587Si7 = (C7587Si7) AbstractC15401jX0.t0(list, i2);
        if (c7587Si7 == null || this.a.o() == (iB = b(c7587Si7, wh1, i, list))) {
            return;
        }
        AbstractC10533bm0.d(this.b, null, null, new a(iB, null), 3, null);
    }
}
