package ir.nasim;

import ai.bale.proto.PremiumOuterClass$ResponseCalculateDiscountedPrice;
import ai.bale.proto.PremiumOuterClass$ResponsePurchasePackage;
import android.net.Uri;
import ir.nasim.AbstractC20417ry5;
import ir.nasim.VT1;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Nn5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6424Nn5 extends VW7 {
    private final InterfaceC5943Lm5 b;
    private final SettingsModule c;
    private final FD7 d;
    private final AbstractC13778go1 e;
    private final InterfaceC9173Yu3 f;
    private final InterfaceC9173Yu3 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC9336Zm4 j;

    /* renamed from: ir.nasim.Nn5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6424Nn5.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objI;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C6424Nn5.this.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, VT1.c.a));
                InterfaceC5943Lm5 interfaceC5943Lm5 = C6424Nn5.this.b;
                long j = this.d;
                String str = this.e;
                this.b = 1;
                objI = interfaceC5943Lm5.i(j, str, this);
                if (objI == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objI = ((C9475a16) obj).l();
            }
            C6424Nn5 c6424Nn5 = C6424Nn5.this;
            if (C9475a16.j(objI)) {
                PremiumOuterClass$ResponseCalculateDiscountedPrice premiumOuterClass$ResponseCalculateDiscountedPrice = (PremiumOuterClass$ResponseCalculateDiscountedPrice) objI;
                InterfaceC9336Zm4 interfaceC9336Zm42 = c6424Nn5.j;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, new VT1.d(premiumOuterClass$ResponseCalculateDiscountedPrice.getDiscountedPrice())));
            }
            C6424Nn5 c6424Nn52 = C6424Nn5.this;
            Throwable thE = C9475a16.e(objI);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c6424Nn52.j;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, new VT1.a(thE)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nn5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Nn5$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C6424Nn5 a;

            a(C6424Nn5 c6424Nn5) {
                this.a = c6424Nn5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.h;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C13161fl5.b((C13161fl5) value, z, 0L, null, 6, null)));
                return C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6424Nn5.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2G = C6424Nn5.this.b.g();
                a aVar = new a(C6424Nn5.this);
                this.b = 1;
                if (interfaceC4557Fq2G.b(aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nn5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Nn5$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C6424Nn5 a;

            a(C6424Nn5 c6424Nn5) {
                this.a = c6424Nn5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).longValue(), interfaceC20295rm1);
            }

            public final Object b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.h;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C13161fl5.b((C13161fl5) value, false, j, null, 5, null)));
                return C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6424Nn5.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2C = C6424Nn5.this.b.c();
                a aVar = new a(C6424Nn5.this);
                this.b = 1;
                if (interfaceC4557Fq2C.b(aVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nn5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        long g;
        int h;
        int i;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6424Nn5.this.new d(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00c2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c3 -> B:25:0x00cc). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 279
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6424Nn5.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nn5$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6424Nn5.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objJ;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C6424Nn5.this.i;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC20417ry5.c.a));
                InterfaceC5943Lm5 interfaceC5943Lm5 = C6424Nn5.this.b;
                long j = this.d;
                String str = this.e;
                this.b = 1;
                objJ = interfaceC5943Lm5.j(j, str, this);
                if (objJ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objJ = ((C9475a16) obj).l();
            }
            C6424Nn5 c6424Nn5 = C6424Nn5.this;
            if (C9475a16.j(objJ)) {
                PremiumOuterClass$ResponsePurchasePackage premiumOuterClass$ResponsePurchasePackage = (PremiumOuterClass$ResponsePurchasePackage) objJ;
                InterfaceC9336Zm4 interfaceC9336Zm42 = c6424Nn5.i;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, new AbstractC20417ry5.d(premiumOuterClass$ResponsePurchasePackage.getSadadPaymentToken())));
            }
            C6424Nn5 c6424Nn52 = C6424Nn5.this;
            Throwable thE = C9475a16.e(objJ);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c6424Nn52.i;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, new AbstractC20417ry5.a(thE)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6424Nn5(InterfaceC5943Lm5 interfaceC5943Lm5, SettingsModule settingsModule, FD7 fd7, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = interfaceC5943Lm5;
        this.c = settingsModule;
        this.d = fd7;
        this.e = abstractC13778go1;
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ln5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6424Nn5.f1(this.a);
            }
        });
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Mn5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6424Nn5.g1(this.a);
            }
        });
        this.h = AbstractC12281eL6.a(new C13161fl5(false, 0L, null, 7, null));
        this.i = AbstractC12281eL6.a(AbstractC20417ry5.b.a);
        this.j = AbstractC12281eL6.a(VT1.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f1(C6424Nn5 c6424Nn5) {
        AbstractC13042fc3.i(c6424Nn5, "this$0");
        List listN0 = AbstractC20762sZ6.N0(c6424Nn5.c.B3(), new String[]{"|splitter|"}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN0) {
            if (!AbstractC20762sZ6.n0((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri g1(C6424Nn5 c6424Nn5) {
        AbstractC13042fc3.i(c6424Nn5, "this$0");
        return Uri.parse(c6424Nn5.c.C3());
    }

    public final InterfaceC13730gj3 W0(String str, long j) {
        AbstractC13042fc3.i(str, "discount");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(j, str, null), 3, null);
    }

    public final InterfaceC10258bL6 X0() {
        return AbstractC6459Nq2.c(this.j);
    }

    public final List Y0() {
        return (List) this.f.getValue();
    }

    public final Uri Z0() {
        return (Uri) this.g.getValue();
    }

    public final InterfaceC10258bL6 a1() {
        return AbstractC6459Nq2.c(this.i);
    }

    public final InterfaceC10258bL6 b1() {
        return AbstractC6459Nq2.c(this.h);
    }

    public final void c1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new b(null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new c(null), 2, null);
    }

    public final InterfaceC13730gj3 d1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new d(null), 2, null);
    }

    public final void e1(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        this.d.d(abstractC20556sC7);
    }

    public final InterfaceC13730gj3 h1(long j, String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(j, str, null), 3, null);
    }

    public final void i1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20417ry5.b.a));
    }

    public final void j1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, VT1.b.a));
    }
}
