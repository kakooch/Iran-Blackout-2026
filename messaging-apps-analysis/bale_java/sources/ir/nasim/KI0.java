package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AJ0;
import ir.nasim.core.network.RpcException;
import ir.nasim.sharedmedia.ui.state.ChangeNickErrorState;
import java.io.IOException;
import java.util.List;

/* loaded from: classes7.dex */
public final class KI0 extends VW7 {
    private final C10299bQ2 b;
    private final C22434vE0 c;
    private final androidx.lifecycle.y d;
    private final C19854r32 e;
    private final Context f;
    private final InterfaceC9173Yu3 g;
    private final InterfaceC9173Yu3 h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9336Zm4 l;
    private final InterfaceC10040ay6 m;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = KI0.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objA;
            Object value2;
            Object value3;
            Object value4;
            Object value5;
            Object value6;
            Object value7;
            Object value8;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String str = (String) this.c;
                if (!AbstractC20762sZ6.n0(str)) {
                    if (!AbstractC13042fc3.d(str, KI0.this.e1() == ZN2.CHANNEL ? "Channel Id" : "Group Id")) {
                        if (str.length() < 5) {
                            InterfaceC9336Zm4 interfaceC9336Zm4 = KI0.this.l;
                            do {
                                value3 = interfaceC9336Zm4.getValue();
                            } while (!interfaceC9336Zm4.f(value3, MI0.b((MI0) value3, null, null, null, new AJ0.a(ChangeNickErrorState.InvalidChannelInput.a), 7, null)));
                            return C19938rB7.a;
                        }
                        if (AbstractC13042fc3.d(str, KI0.this.d1())) {
                            InterfaceC9336Zm4 interfaceC9336Zm42 = KI0.this.l;
                            do {
                                value2 = interfaceC9336Zm42.getValue();
                            } while (!interfaceC9336Zm42.f(value2, MI0.b((MI0) value2, null, null, null, AJ0.c.a, 7, null)));
                            return C19938rB7.a;
                        }
                        C22434vE0 c22434vE0 = KI0.this.c;
                        this.b = 1;
                        objA = c22434vE0.a(str, this);
                        if (objA == objE) {
                            return objE;
                        }
                    }
                }
                InterfaceC9336Zm4 interfaceC9336Zm43 = KI0.this.l;
                do {
                    value = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value, MI0.b((MI0) value, null, null, null, AJ0.b.a, 7, null)));
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            objA = ((C9475a16) obj).l();
            KI0 ki0 = KI0.this;
            if (C9475a16.j(objA)) {
                if (((Boolean) objA).booleanValue()) {
                    InterfaceC9336Zm4 interfaceC9336Zm44 = ki0.l;
                    do {
                        value7 = interfaceC9336Zm44.getValue();
                    } while (!interfaceC9336Zm44.f(value7, MI0.b((MI0) value7, null, null, null, AJ0.c.a, 7, null)));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm45 = ki0.l;
                    do {
                        value8 = interfaceC9336Zm45.getValue();
                    } while (!interfaceC9336Zm45.f(value8, MI0.b((MI0) value8, null, null, null, new AJ0.a(new Exception("Channel Nickname exists")), 7, null)));
                }
            }
            KI0 ki02 = KI0.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                boolean z = thE instanceof RpcException;
                if (z && AbstractC20762sZ6.X(((RpcException) thE).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), ChangeNickErrorState.InvalidChannelNick.a.a(), false, 2, null)) {
                    InterfaceC9336Zm4 interfaceC9336Zm46 = ki02.l;
                    do {
                        value6 = interfaceC9336Zm46.getValue();
                    } while (!interfaceC9336Zm46.f(value6, MI0.b((MI0) value6, null, null, null, new AJ0.a(ChangeNickErrorState.InvalidChannelNick.a), 7, null)));
                } else if (z && AbstractC20762sZ6.X(((RpcException) thE).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), ChangeNickErrorState.ForbiddenNick.a.a(), false, 2, null)) {
                    InterfaceC9336Zm4 interfaceC9336Zm47 = ki02.l;
                    do {
                        value5 = interfaceC9336Zm47.getValue();
                    } while (!interfaceC9336Zm47.f(value5, MI0.b((MI0) value5, null, null, null, new AJ0.a(ChangeNickErrorState.ForbiddenNick.a), 7, null)));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm48 = ki02.l;
                    do {
                        value4 = interfaceC9336Zm48.getValue();
                    } while (!interfaceC9336Zm48.f(value4, MI0.b((MI0) value4, null, null, null, new AJ0.a(thE), 7, null)));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ W06 e;
        final /* synthetic */ String f;
        final /* synthetic */ SA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, W06 w06, String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = w06;
            this.f = str;
            this.g = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KI0.this.new b(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C10299bQ2 c10299bQ2 = KI0.this.b;
                int i2 = this.d;
                W06 w06 = this.e;
                String str = this.f;
                KI0 ki0 = KI0.this;
                if (w06 != W06.PUBLIC || str == null || str.length() == 0 || AbstractC13042fc3.d(str, ki0.d1()) || (!C8386Vt0.a.D9() && ki0.e1() != ZN2.CHANNEL)) {
                    str = null;
                }
                C6517Nv5 c6517Nv5P1 = c10299bQ2.p1(i2, w06, str);
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5P1, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            SA2 sa2 = this.g;
            if (C9475a16.j(objD)) {
                sa2.invoke();
            }
            KI0 ki02 = KI0.this;
            Throwable thE = C9475a16.e(objD);
            if (thE != null) {
                ki02.b1(UN2.a(thE, ki02.e1()));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return ((MI0) this.c).f();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(MI0 mi0, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(mi0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.KI0$d$a$a, reason: collision with other inner class name */
            public static final class C0462a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0462a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.KI0.d.a.C0462a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.KI0$d$a$a r0 = (ir.nasim.KI0.d.a.C0462a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.KI0$d$a$a r0 = new ir.nasim.KI0$d$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L45
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.MI0 r5 = (ir.nasim.MI0) r5
                    java.lang.String r5 = r5.e()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KI0.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public KI0(C10299bQ2 c10299bQ2, C22434vE0 c22434vE0, androidx.lifecycle.y yVar, C19854r32 c19854r32, Context context) {
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(c22434vE0, "canSetNickNameUseCase");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(c19854r32, "editGroupNickUseCase");
        AbstractC13042fc3.i(context, "applicationContext");
        this.b = c10299bQ2;
        this.c = c22434vE0;
        this.d = yVar;
        this.e = c19854r32;
        this.f = context;
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.FI0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KI0.j1(this.a);
            }
        });
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.GI0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KI0.l1(this.a);
            }
        });
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.HI0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KI0.k1(this.a);
            }
        });
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.II0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KI0.i1(this.a);
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.JI0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KI0.a1(this.a);
            }
        });
        W06 w06G1 = g1();
        String strD1 = d1();
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new MI0(strD1 == null ? "" : strD1, w06G1, null, null, 12, null));
        this.l = interfaceC9336Zm4A;
        this.m = AbstractC9370Zq2.h(AbstractC6459Nq2.X(interfaceC9336Zm4A, new c(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), 0, 4, null);
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(AbstractC6459Nq2.v(new d(c1())), 200L), new a(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a1(KI0 ki0) {
        AbstractC13042fc3.i(ki0, "this$0");
        return (String) ki0.d.c("DEFAULT_ID");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(String str) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, MI0.b((MI0) value, null, null, str, null, 11, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i1(KI0 ki0) {
        AbstractC13042fc3.i(ki0, "this$0");
        String str = (String) ki0.d.c("NAME_OF_GROUP");
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZN2 j1(KI0 ki0) {
        AbstractC13042fc3.i(ki0, "this$0");
        ZN2 zn2 = (ZN2) ki0.d.c("GROUP_TYPE");
        return zn2 == null ? ZN2.GROUP : zn2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer k1(KI0 ki0) {
        AbstractC13042fc3.i(ki0, "this$0");
        return (Integer) ki0.d.c("PEER_ID_ARG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W06 l1(KI0 ki0) {
        AbstractC13042fc3.i(ki0, "this$0");
        W06 w06 = (W06) ki0.d.c("RESTRICTION");
        return w06 == null ? W06.PRIVATE : w06;
    }

    public final void Z0(W06 w06, String str, SA2 sa2) {
        AbstractC13042fc3.i(w06, "restriction");
        AbstractC13042fc3.i(sa2, "onSuccess");
        Integer numF1 = f1();
        if (numF1 != null) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(numF1.intValue(), w06, str, sa2, null), 3, null);
        }
    }

    public final InterfaceC10258bL6 c1() {
        return AbstractC6459Nq2.c(this.l);
    }

    public final String d1() {
        return (String) this.k.getValue();
    }

    public final ZN2 e1() {
        return (ZN2) this.g.getValue();
    }

    public final Integer f1() {
        return (Integer) this.i.getValue();
    }

    public final W06 g1() {
        return (W06) this.h.getValue();
    }

    public final InterfaceC10040ay6 h1() {
        return this.m;
    }

    public final void m1(String str) throws IOException {
        Object value;
        MI0 mi0;
        String string;
        AbstractC13042fc3.i(str, "id");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
            mi0 = (MI0) value;
            if (AbstractC13042fc3.d(e1() == ZN2.CHANNEL ? "Channel Id" : "Group Id", str)) {
                string = "";
            } else {
                StringBuilder sb = new StringBuilder();
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    List listS0 = AbstractC15401jX0.S0(AbstractC15401jX0.P0(new C12266eK0('a', 'z'), new C12266eK0('0', '9')), '_');
                    if (cCharAt != ' ' && listS0.contains(Character.valueOf(Character.toLowerCase(cCharAt)))) {
                        sb.append(cCharAt);
                    }
                }
                string = sb.toString();
                AbstractC13042fc3.h(string, "toString(...)");
            }
        } while (!interfaceC9336Zm4.f(value, MI0.b(mi0, string, null, null, AJ0.b.a, 6, null)));
    }

    public final void o1(W06 w06) {
        Object value;
        AbstractC13042fc3.i(w06, "type");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, MI0.b((MI0) value, null, w06, null, null, 13, null)));
    }
}
