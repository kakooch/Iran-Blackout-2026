package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC24849zJ0;
import ir.nasim.core.network.RpcException;
import ir.nasim.group.create.creategroup.ChannelIdError;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.Pr1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6950Pr1 extends VW7 {
    public static final c g = new c(null);
    public static final int h = 8;
    private final C22434vE0 b;
    private final Context c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC9336Zm4 e;
    private final InterfaceC10258bL6 f;

    /* renamed from: ir.nasim.Pr1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WF2 c;
        final /* synthetic */ C6950Pr1 d;

        /* renamed from: ir.nasim.Pr1$a$a, reason: collision with other inner class name */
        static final class C0583a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6950Pr1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0583a(C6950Pr1 c6950Pr1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6950Pr1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0583a c0583a = new C0583a(this.d, interfaceC20295rm1);
                c0583a.c = obj;
                return c0583a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C19951rD2 c19951rD2 = (C19951rD2) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.e;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C4693Gd6.b((C4693Gd6) value, ((KW3) AbstractC15401jX0.q0(c19951rD2.a())).b(), null, null, null, null, 30, null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C19951rD2 c19951rD2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0583a) create(c19951rD2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(WF2 wf2, C6950Pr1 c6950Pr1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = wf2;
            this.d = c6950Pr1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = this.c.a("StoryAdderFragment");
                C0583a c0583a = new C0583a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, c0583a, this) == objE) {
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

    /* renamed from: ir.nasim.Pr1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C6950Pr1.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
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
                if (AbstractC20762sZ6.n0(str)) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = C6950Pr1.this.e;
                    do {
                        value3 = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value3, C4693Gd6.b((C4693Gd6) value3, null, null, null, null, AbstractC24849zJ0.b.a, 15, null)));
                    return C19938rB7.a;
                }
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                String string = C6950Pr1.this.c.getString(HD5.app_name);
                AbstractC13042fc3.h(string, "getString(...)");
                String lowerCase2 = string.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
                if (AbstractC20762sZ6.X(lowerCase, lowerCase2, false, 2, null)) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = C6950Pr1.this.e;
                    do {
                        value2 = interfaceC9336Zm42.getValue();
                    } while (!interfaceC9336Zm42.f(value2, C4693Gd6.b((C4693Gd6) value2, null, null, null, null, new AbstractC24849zJ0.a(new ChannelIdError.UsingAppName()), 15, null)));
                    return C19938rB7.a;
                }
                if (str.length() < 5) {
                    InterfaceC9336Zm4 interfaceC9336Zm43 = C6950Pr1.this.e;
                    do {
                        value = interfaceC9336Zm43.getValue();
                    } while (!interfaceC9336Zm43.f(value, C4693Gd6.b((C4693Gd6) value, null, null, null, null, new AbstractC24849zJ0.a(new ChannelIdError.InvalidChannelInput()), 15, null)));
                    return C19938rB7.a;
                }
                C22434vE0 c22434vE0 = C6950Pr1.this.b;
                this.b = 1;
                objA = c22434vE0.a(str, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            C6950Pr1 c6950Pr1 = C6950Pr1.this;
            if (C9475a16.j(objA)) {
                if (((Boolean) objA).booleanValue()) {
                    InterfaceC9336Zm4 interfaceC9336Zm44 = c6950Pr1.e;
                    do {
                        value7 = interfaceC9336Zm44.getValue();
                    } while (!interfaceC9336Zm44.f(value7, C4693Gd6.b((C4693Gd6) value7, null, null, null, null, AbstractC24849zJ0.c.a, 15, null)));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm45 = c6950Pr1.e;
                    do {
                        value8 = interfaceC9336Zm45.getValue();
                    } while (!interfaceC9336Zm45.f(value8, C4693Gd6.b((C4693Gd6) value8, null, null, null, null, new AbstractC24849zJ0.a(new Exception("Channel Nickname exists")), 15, null)));
                }
            }
            C6950Pr1 c6950Pr12 = C6950Pr1.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                boolean z = thE instanceof RpcException;
                if (z && AbstractC20762sZ6.X(((RpcException) thE).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), "invalid user nick name", false, 2, null)) {
                    InterfaceC9336Zm4 interfaceC9336Zm46 = c6950Pr12.e;
                    do {
                        value6 = interfaceC9336Zm46.getValue();
                    } while (!interfaceC9336Zm46.f(value6, C4693Gd6.b((C4693Gd6) value6, null, null, null, null, new AbstractC24849zJ0.a(new ChannelIdError.InvalidChannelNick()), 15, null)));
                } else if (z && AbstractC20762sZ6.X(((RpcException) thE).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), "forbidden user nick name", false, 2, null)) {
                    InterfaceC9336Zm4 interfaceC9336Zm47 = c6950Pr12.e;
                    do {
                        value5 = interfaceC9336Zm47.getValue();
                    } while (!interfaceC9336Zm47.f(value5, C4693Gd6.b((C4693Gd6) value5, null, null, null, null, new AbstractC24849zJ0.a(new ChannelIdError.ForbiddenNick()), 15, null)));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm48 = c6950Pr12.e;
                    do {
                        value4 = interfaceC9336Zm48.getValue();
                    } while (!interfaceC9336Zm48.f(value4, C4693Gd6.b((C4693Gd6) value4, null, null, null, null, new AbstractC24849zJ0.a(thE), 15, null)));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pr1$c */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Pr1$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Pr1$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Pr1$d$a$a, reason: collision with other inner class name */
            public static final class C0584a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0584a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C6950Pr1.d.a.C0584a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Pr1$d$a$a r0 = (ir.nasim.C6950Pr1.d.a.C0584a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Pr1$d$a$a r0 = new ir.nasim.Pr1$d$a$a
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
                    ir.nasim.Gd6 r5 = (ir.nasim.C4693Gd6) r5
                    java.lang.String r5 = r5.d()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6950Pr1.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    public C6950Pr1(C22434vE0 c22434vE0, WF2 wf2, Context context, final androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(c22434vE0, "canSetNickNameUseCase");
        AbstractC13042fc3.i(wf2, "galleryResultUseCase");
        AbstractC13042fc3.i(context, "applicationContext");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = c22434vE0;
        this.c = context;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Or1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6950Pr1.W0(yVar);
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C4693Gd6(null, null, null, U0() == ZN2.GROUP ? OM2.b : OM2.c, null, 23, null));
        this.e = interfaceC9336Zm4A;
        InterfaceC10258bL6 interfaceC10258bL6C = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.f = interfaceC10258bL6C;
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(wf2, this, null), 3, null);
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(AbstractC6459Nq2.v(new d(interfaceC10258bL6C)), 200L), new b(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZN2 W0(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        ZN2 zn2 = (ZN2) yVar.c("groupTypeKey");
        return zn2 == null ? ZN2.GROUP : zn2;
    }

    public final ZN2 U0() {
        return (ZN2) this.d.getValue();
    }

    public final InterfaceC10258bL6 V0() {
        return this.f;
    }

    public final void X0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C4693Gd6.b((C4693Gd6) value, null, null, null, null, null, 30, null)));
    }

    public final void Y0(String str) throws IOException {
        Object value;
        C4693Gd6 c4693Gd6;
        String string;
        AbstractC13042fc3.i(str, "id");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
            c4693Gd6 = (C4693Gd6) value;
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
        } while (!interfaceC9336Zm4.f(value, C4693Gd6.b(c4693Gd6, null, null, string, null, AbstractC24849zJ0.b.a, 11, null)));
    }

    public final void Z0(String str) {
        Object value;
        AbstractC13042fc3.i(str, "name");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C4693Gd6.b((C4693Gd6) value, null, AbstractC15401jX0.A0(AbstractC20762sZ6.u0(AbstractC20153rZ6.M(AbstractC20153rZ6.M(str, Separators.LESS_THAN, "", false, 4, null), Separators.GREATER_THAN, "", false, 4, null)), "", null, null, 0, null, null, 62, null), null, null, null, 29, null)));
    }

    public final void a1(OM2 om2) {
        Object value;
        AbstractC13042fc3.i(om2, "type");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C4693Gd6.b((C4693Gd6) value, null, null, null, om2, null, 23, null)));
    }
}
