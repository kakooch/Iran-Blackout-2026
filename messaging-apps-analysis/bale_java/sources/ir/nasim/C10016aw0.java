package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AA3;
import ir.nasim.AbstractC12797fB3;
import ir.nasim.AbstractC4600Fv0;
import ir.nasim.C10016aw0;
import ir.nasim.InterfaceC22848vv0;
import ir.nasim.database.entity.ContactEntity;
import java.util.List;

/* renamed from: ir.nasim.aw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10016aw0 extends VW7 {
    public static final a m = new a(null);
    public static final int n = 8;
    private final IE2 b;
    private final C4495Fj3 c;
    private final C13843gu6 d;
    private final C23631xF2 e;
    private final C15732k47 f;
    private final C4627Fy0 g;
    private final InterfaceC9336Zm4 h;
    private String i;
    private int j;
    private String k;
    private InterfaceC13730gj3 l;

    /* renamed from: ir.nasim.aw0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.aw0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        boolean f;
        int g;
        final /* synthetic */ String i;
        final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = str;
            this.j = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10016aw0.this.new b(this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0137 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x016c  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 371
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10016aw0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw0$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C10016aw0.this.g1(null, this);
        }
    }

    /* renamed from: ir.nasim.aw0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10016aw0.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Object value = C10016aw0.this.j1().getValue();
            AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
            if (cVar != null) {
                C10016aw0 c10016aw0 = C10016aw0.this;
                if (!(cVar.k() instanceof AbstractC12797fB3.c)) {
                    c10016aw0.c.a(cVar.f(), cVar.d(), cVar.i(), cVar.g(), cVar.a(), cVar.h());
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AA3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AA3 aa3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aa3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C10016aw0 c10016aw0, C17637nI7 c17637nI7) {
            c10016aw0.k = c17637nI7.getName();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10016aw0.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Object value = C10016aw0.this.j1().getValue();
                AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
                if (cVar == null) {
                    Object value2 = C10016aw0.this.j1().getValue();
                    AbstractC4600Fv0.b bVar = value2 instanceof AbstractC4600Fv0.b ? (AbstractC4600Fv0.b) value2 : null;
                    if (bVar != null) {
                        final C10016aw0 c10016aw0 = C10016aw0.this;
                        c10016aw0.e1(true, bVar.a());
                        c10016aw0.g.h1();
                        C6517Nv5 c6517Nv5D0 = C4627Fy0.d0(c10016aw0.g, AbstractC5969Lp4.f(), 0L, 2, null);
                        if (c6517Nv5D0 != null) {
                            c6517Nv5D0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.bw0
                                @Override // ir.nasim.InterfaceC24449ye1
                                public final void apply(Object obj2) {
                                    C10016aw0.e.y(c10016aw0, (C17637nI7) obj2);
                                }
                            });
                        }
                    }
                    return C19938rB7.a;
                }
                C10016aw0 c10016aw02 = C10016aw0.this;
                AA3 aa3 = this.d;
                InterfaceC9336Zm4 interfaceC9336Zm4 = c10016aw02.h;
                AbstractC4600Fv0.c cVarB = cVar.b((SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 1) != 0 ? cVar.a : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 2) != 0 ? cVar.b : 0L, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 4) != 0 ? cVar.c : false, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 8) != 0 ? cVar.d : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 16) != 0 ? cVar.e : new AbstractC12797fB3.a(false), (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 32) != 0 ? cVar.f : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 64) != 0 ? cVar.g : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 128) != 0 ? cVar.h : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 256) != 0 ? cVar.i : aa3);
                this.b = 1;
                if (interfaceC9336Zm4.a(cVarB, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ String f;

        /* renamed from: ir.nasim.aw0$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C10016aw0 c;
            final /* synthetic */ String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10016aw0 c10016aw0, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c10016aw0;
                this.d = str;
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
                    this.b = 1;
                    if (HG1.b(700L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.c.u1(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10016aw0.this.new f(this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10016aw0.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw0$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10016aw0.this.new g(this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            String str;
            C10016aw0 c10016aw0;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC4600Fv0 abstractC4600Fv0 = (AbstractC4600Fv0) C10016aw0.this.j1().getValue();
                String str2 = this.f;
                C10016aw0 c10016aw02 = C10016aw0.this;
                if (!AbstractC13042fc3.d(str2, c10016aw02.i) && (abstractC4600Fv0 instanceof AbstractC4600Fv0.c)) {
                    C13843gu6 c13843gu6 = c10016aw02.d;
                    long jF = ((AbstractC4600Fv0.c) abstractC4600Fv0).f();
                    this.b = c10016aw02;
                    this.c = str2;
                    this.d = 1;
                    objA = c13843gu6.a(jF, str2, this);
                    if (objA == objE) {
                        return objE;
                    }
                    str = str2;
                    c10016aw0 = c10016aw02;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.c;
            c10016aw0 = (C10016aw0) this.b;
            AbstractC10685c16.b(obj);
            objA = ((C9475a16) obj).l();
            if (C9475a16.j(objA)) {
                c10016aw0.i = str;
            }
            C9475a16.e(objA);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw0$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC4600Fv0.c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AbstractC4600Fv0.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = cVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10016aw0.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C10016aw0.this.h;
                AbstractC4600Fv0.c cVar = this.d;
                AbstractC4600Fv0.c cVarB = cVar.b((SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 1) != 0 ? cVar.a : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 2) != 0 ? cVar.b : 0L, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 4) != 0 ? cVar.c : false, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 8) != 0 ? cVar.d : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 16) != 0 ? cVar.e : AbstractC12797fB3.b.a, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 32) != 0 ? cVar.f : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 64) != 0 ? cVar.g : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 128) != 0 ? cVar.h : null, (SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER & 256) != 0 ? cVar.i : null);
                this.b = 1;
                if (interfaceC9336Zm4.a(cVarB, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10016aw0(IE2 ie2, C4495Fj3 c4495Fj3, C13843gu6 c13843gu6, C23631xF2 c23631xF2, C15732k47 c15732k47, C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(ie2, "generateCallLinkUseCase");
        AbstractC13042fc3.i(c4495Fj3, "joinCallFromCallIdUseCase");
        AbstractC13042fc3.i(c13843gu6, "setCallTitleUseCase");
        AbstractC13042fc3.i(c23631xF2, "getLinkDetailsUseCase");
        AbstractC13042fc3.i(c15732k47, "syncOnGoingCallUseCase");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.b = ie2;
        this.c = c4495Fj3;
        this.d = c13843gu6;
        this.e = c23631xF2;
        this.f = c15732k47;
        this.g = c4627Fy0;
        this.h = AbstractC12281eL6.a(new AbstractC4600Fv0.b(null, null, 3, null));
    }

    public static /* synthetic */ InterfaceC13730gj3 f1(C10016aw0 c10016aw0, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return c10016aw0.e1(z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g1(java.lang.String r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10016aw0.g1(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    private final void q1(InterfaceC22848vv0 interfaceC22848vv0, long j) {
        this.g.c1(interfaceC22848vv0, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(boolean z) {
        this.g.d1(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 u1(String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(str, null), 3, null);
    }

    public final InterfaceC13730gj3 d1() {
        return this.f.d();
    }

    public final InterfaceC13730gj3 e1(boolean z, String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(str, z, null), 3, null);
    }

    public final Object h1() {
        Long lE;
        Object value = j1().getValue();
        AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
        if (cVar == null || (lE = cVar.e()) == null) {
            return 3;
        }
        return lE;
    }

    public final String i1() {
        Object value = j1().getValue();
        AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
        if (cVar == null) {
            return null;
        }
        return this.g.m0(cVar.a(), cVar.h(), this.k, cVar.g());
    }

    public final InterfaceC10258bL6 j1() {
        return AbstractC6459Nq2.c(this.h);
    }

    public final InterfaceC13730gj3 k1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    public final InterfaceC13730gj3 l1(AA3 aa3) {
        AbstractC13042fc3.i(aa3, "linkScreenView");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(aa3, null), 3, null);
    }

    public final void m1(List list) {
        AbstractC13042fc3.i(list, ContactEntity.TABLE_NAME);
        l1(AA3.a.a);
        this.g.Z(list, i1());
    }

    public final InterfaceC13730gj3 o1(String str) {
        AbstractC13042fc3.i(str, "value");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(str, null), 3, null);
    }

    public final void p1(boolean z) {
        Object value = j1().getValue();
        AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
        if (cVar != null) {
            if (z) {
                q1(new InterfaceC22848vv0.a(0, 1, null), cVar.f());
            } else {
                q1(new InterfaceC22848vv0.b(0, 1, null), cVar.f());
            }
        }
    }

    public final void t1(InterfaceC6775Ox6 interfaceC6775Ox6) {
        AbstractC13042fc3.i(interfaceC6775Ox6, "eventType");
        this.g.j1(interfaceC6775Ox6);
    }

    public final void v1() {
        Object value = j1().getValue();
        AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
        if (cVar != null) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(cVar, null), 3, null);
        }
    }
}
