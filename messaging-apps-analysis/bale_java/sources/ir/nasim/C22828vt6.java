package ir.nasim;

import ai.bale.proto.GarsonOuterClass$ResponseGetServices;
import ai.bale.proto.GarsonStruct$GarsonBanner;
import ai.bale.proto.GarsonStruct$GarsonBot;
import ai.bale.proto.GarsonStruct$GarsonItem;
import ai.bale.proto.GarsonStruct$GarsonSection;
import ai.bale.proto.GarsonStruct$GarsonServiceItem;
import ai.bale.proto.GarsonStruct$GarsonServicesCategory;
import ai.bale.proto.GarsonStruct$GarsonShortcut;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19670qk5;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.network.RpcException;
import ir.nasim.features.bank.mybank.model.ServiceBannerEntity;
import ir.nasim.features.bank.mybank.model.ServiceShortcutEntity;
import ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.vt6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22828vt6 {
    public static final C22829a l = new C22829a(null);
    public static final int m = 8;
    private final SettingsModule a;
    private final InterfaceC6721Or6 b;
    private final InterfaceC7346Ri0 c;
    private final C20961st6 d;
    private final C6222Mr6 e;
    private final InterfaceC19483qR f;
    private final AbstractC13778go1 g;
    private final AbstractC13778go1 h;
    private final InterfaceC23475wz1 i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;

    /* renamed from: ir.nasim.vt6$A */
    public static final class A implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.vt6$A$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.vt6$A$a$a, reason: collision with other inner class name */
            public static final class C1724a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1724a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C22828vt6.A.a.C1724a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.vt6$A$a$a r0 = (ir.nasim.C22828vt6.A.a.C1724a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.vt6$A$a$a r0 = new ir.nasim.vt6$A$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.vt6$b r2 = ir.nasim.C22828vt6.C22830b.a
                    ir.nasim.qk5$a r2 = r2.c()
                    java.lang.Object r5 = r5.b(r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.A.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public A(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vt6$B */
    static final class B extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        B(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C22828vt6.this.L(null, this);
        }
    }

    /* renamed from: ir.nasim.vt6$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ List d;
        final /* synthetic */ C22828vt6 e;

        /* renamed from: ir.nasim.vt6$C$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ List c;
            final /* synthetic */ C22828vt6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, C22828vt6 c22828vt6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = list;
                this.d = c22828vt6;
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
                    List list = this.c;
                    if (list != null) {
                        C22828vt6 c22828vt6 = this.d;
                        this.b = 1;
                        if (c22828vt6.P(list, this) == objE) {
                            return objE;
                        }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(List list, C22828vt6 c22828vt6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = c22828vt6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C c = new C(this.d, this.e, interfaceC20295rm1);
            c.c = obj;
            return c;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(this.d, this.e, null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        D(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new D(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C22828vt6.this.d.g(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            E e = new E(this.d, interfaceC20295rm1);
            e.c = obj;
            return e;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C22830b.a.c(), this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$F */
    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ GarsonOuterClass$ResponseGetServices d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F(GarsonOuterClass$ResponseGetServices garsonOuterClass$ResponseGetServices, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = garsonOuterClass$ResponseGetServices;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            F f = new F(this.d, interfaceC20295rm1);
            f.c = obj;
            return f;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C22830b.a.b(), String.valueOf(this.d.getVersion()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$a, reason: case insensitive filesystem */
    public static final class C22829a {
        private C22829a() {
        }

        public /* synthetic */ C22829a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vt6$b, reason: case insensitive filesystem */
    private static final class C22830b {
        public static final C22830b a = new C22830b();
        private static final AbstractC19670qk5.a b = AbstractC21557tk5.f("services_page_sections");
        private static final AbstractC19670qk5.a c = AbstractC21557tk5.f("service_shortcuts");
        private static final AbstractC19670qk5.a d = AbstractC21557tk5.f("bot_banners");
        private static final AbstractC19670qk5.a e = AbstractC21557tk5.f("request_data_version");

        private C22830b() {
        }

        public final AbstractC19670qk5.a a() {
            return d;
        }

        public final AbstractC19670qk5.a b() {
            return e;
        }

        public final AbstractC19670qk5.a c() {
            return b;
        }

        public final AbstractC19670qk5.a d() {
            return c;
        }
    }

    /* renamed from: ir.nasim.vt6$c, reason: case insensitive filesystem */
    static final class C22831c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.vt6$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C4772Gm4) this.c).f();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C22831c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new C22831c(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0074 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.b
                java.lang.String r2 = "services_last_cache_force_delete"
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L27
                if (r1 == r5) goto L23
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                ir.nasim.AbstractC10685c16.b(r11)
                goto L75
            L17:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1f:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L66
            L23:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L57
            L27:
                ir.nasim.AbstractC10685c16.b(r11)
                ir.nasim.Bk5 r11 = ir.nasim.C7183Qq.p()
                r6 = 0
                long r6 = r11.getLong(r2, r6)
                ir.nasim.vt6 r11 = ir.nasim.C22828vt6.this
                ir.nasim.core.modules.settings.SettingsModule r11 = ir.nasim.C22828vt6.k(r11)
                long r8 = r11.T3()
                int r11 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r11 <= 0) goto L80
                ir.nasim.vt6 r11 = ir.nasim.C22828vt6.this
                ir.nasim.wz1 r11 = ir.nasim.C22828vt6.f(r11)
                ir.nasim.vt6$c$a r1 = new ir.nasim.vt6$c$a
                r6 = 0
                r1.<init>(r6)
                r10.b = r5
                java.lang.Object r11 = ir.nasim.AbstractC22147uk5.a(r11, r1, r10)
                if (r11 != r0) goto L57
                return r0
            L57:
                ir.nasim.vt6 r11 = ir.nasim.C22828vt6.this
                ir.nasim.Or6 r11 = ir.nasim.C22828vt6.h(r11)
                r10.b = r4
                java.lang.Object r11 = r11.a(r10)
                if (r11 != r0) goto L66
                return r0
            L66:
                ir.nasim.vt6 r11 = ir.nasim.C22828vt6.this
                ir.nasim.Ri0 r11 = ir.nasim.C22828vt6.e(r11)
                r10.b = r3
                java.lang.Object r11 = r11.a(r10)
                if (r11 != r0) goto L75
                return r0
            L75:
                ir.nasim.Bk5 r11 = ir.nasim.C7183Qq.p()
                long r0 = ir.nasim.AbstractC20507s76.o()
                r11.putLong(r2, r0)
            L80:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.C22831c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C22831c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$d, reason: case insensitive filesystem */
    static final class C22832d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        C22832d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C22828vt6.this.q(null, this);
        }
    }

    /* renamed from: ir.nasim.vt6$e, reason: case insensitive filesystem */
    static final class C22833e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ GarsonOuterClass$ResponseGetServices e;

        /* renamed from: ir.nasim.vt6$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C22828vt6 c;
            final /* synthetic */ GarsonOuterClass$ResponseGetServices d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22828vt6 c22828vt6, GarsonOuterClass$ResponseGetServices garsonOuterClass$ResponseGetServices, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c22828vt6;
                this.d = garsonOuterClass$ResponseGetServices;
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
                    C22828vt6 c22828vt6 = this.c;
                    List<GarsonStruct$GarsonServicesCategory> categoriesList = this.d.getServices().getCategoriesList();
                    AbstractC13042fc3.h(categoriesList, "getCategoriesList(...)");
                    this.b = 1;
                    if (c22828vt6.O(categoriesList, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C22833e(GarsonOuterClass$ResponseGetServices garsonOuterClass$ResponseGetServices, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = garsonOuterClass$ResponseGetServices;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C22833e c22833e = C22828vt6.this.new C22833e(this.e, interfaceC20295rm1);
            c22833e.c = obj;
            return c22833e;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(C22828vt6.this, this.e, null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C22833e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$f, reason: case insensitive filesystem */
    static final class C22834f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ List e;

        /* renamed from: ir.nasim.vt6$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C22828vt6 c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22828vt6 c22828vt6, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c22828vt6;
                this.d = list;
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
                    C22828vt6 c22828vt6 = this.c;
                    List list = this.d;
                    this.b = 1;
                    if (c22828vt6.P(list, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C22834f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C22834f c22834f = C22828vt6.this.new C22834f(this.e, interfaceC20295rm1);
            c22834f.c = obj;
            return c22834f;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(C22828vt6.this, this.e, null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C22834f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GarsonStruct$GarsonSection c;
        final /* synthetic */ KS2 d;
        final /* synthetic */ InterfaceC23475wz1 e;

        /* renamed from: ir.nasim.vt6$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C4772Gm4) this.c).j(C22830b.a.a(), this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(GarsonStruct$GarsonSection garsonStruct$GarsonSection, KS2 ks2, InterfaceC23475wz1 interfaceC23475wz1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = garsonStruct$GarsonSection;
            this.d = ks2;
            this.e = interfaceC23475wz1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List<GarsonStruct$GarsonBanner> bannersList = this.c.getBanners().getBannersList();
                AbstractC13042fc3.h(bannersList, "getBannersList(...)");
                List<GarsonStruct$GarsonBanner> list = bannersList;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (GarsonStruct$GarsonBanner garsonStruct$GarsonBanner : list) {
                    ServiceBannerEntity.Companion companion = ServiceBannerEntity.INSTANCE;
                    AbstractC13042fc3.f(garsonStruct$GarsonBanner);
                    arrayList.add(companion.a(garsonStruct$GarsonBanner));
                }
                String strT = this.d.t(arrayList);
                InterfaceC23475wz1 interfaceC23475wz1 = this.e;
                a aVar = new a(strT, null);
                this.b = 1;
                if (AbstractC22147uk5.a(interfaceC23475wz1, aVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GarsonStruct$GarsonSection c;
        final /* synthetic */ KS2 d;
        final /* synthetic */ InterfaceC23475wz1 e;

        /* renamed from: ir.nasim.vt6$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C4772Gm4) this.c).j(C22830b.a.d(), this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(GarsonStruct$GarsonSection garsonStruct$GarsonSection, KS2 ks2, InterfaceC23475wz1 interfaceC23475wz1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = garsonStruct$GarsonSection;
            this.d = ks2;
            this.e = interfaceC23475wz1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List<GarsonStruct$GarsonShortcut> shortcutsList = this.c.getShortcuts().getShortcutsList();
                AbstractC13042fc3.h(shortcutsList, "getShortcutsList(...)");
                List<GarsonStruct$GarsonShortcut> list = shortcutsList;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut : list) {
                    ServiceShortcutEntity.Companion companion = ServiceShortcutEntity.INSTANCE;
                    AbstractC13042fc3.f(garsonStruct$GarsonShortcut);
                    arrayList.add(companion.a(garsonStruct$GarsonShortcut));
                }
                String strT = this.d.t(arrayList);
                InterfaceC23475wz1 interfaceC23475wz1 = this.e;
                a aVar = new a(strT, null);
                this.b = 1;
                if (AbstractC22147uk5.a(interfaceC23475wz1, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.vt6$i */
    static final class i extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objX = C22828vt6.this.x(this);
            return objX == AbstractC14862ic3.e() ? objX : C9475a16.a(objX);
        }
    }

    /* renamed from: ir.nasim.vt6$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20961st6 c20961st6 = C22828vt6.this.d;
                this.b = 1;
                objA = c20961st6.a(this);
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
            return C9475a16.a(objA);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$k */
    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objY = C22828vt6.this.y(this);
            return objY == AbstractC14862ic3.e() ? objY : C9475a16.a(objY);
        }
    }

    /* renamed from: ir.nasim.vt6$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.vt6$l$a */
        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.vt6$l$a$a, reason: collision with other inner class name */
            public static final class C1725a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.vt6$l$a$a$a, reason: collision with other inner class name */
                public static final class C1726a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1726a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1725a.this.a(null, this);
                    }
                }

                public C1725a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                        boolean r0 = r6 instanceof ir.nasim.C22828vt6.l.a.C1725a.C1726a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.vt6$l$a$a$a r0 = (ir.nasim.C22828vt6.l.a.C1725a.C1726a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.vt6$l$a$a$a r0 = new ir.nasim.vt6$l$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                        ir.nasim.vt6$b r2 = ir.nasim.C22828vt6.C22830b.a
                        ir.nasim.qk5$a r2 = r2.b()
                        java.lang.Object r5 = r5.b(r2)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.l.a.C1725a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1725a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.vt6$l$b */
        static final class b extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ C22828vt6 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C22828vt6 c22828vt6, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = c22828vt6;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C20961st6 c20961st6 = this.c.d;
                    int i2 = this.d;
                    this.b = 1;
                    obj = c20961st6.e(i2, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new l(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0076 A[Catch: Exception -> 0x001b, TRY_ENTER, TryCatch #0 {Exception -> 0x001b, blocks: (B:8:0x0016, B:38:0x00ab, B:30:0x0076, B:32:0x0085, B:35:0x0098), top: B:51:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00d3  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$m */
    public static final class m implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.vt6$m$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.vt6$m$a$a, reason: collision with other inner class name */
            public static final class C1727a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1727a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C22828vt6.m.a.C1727a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.vt6$m$a$a r0 = (ir.nasim.C22828vt6.m.a.C1727a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.vt6$m$a$a r0 = new ir.nasim.vt6$m$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.vt6$b r2 = ir.nasim.C22828vt6.C22830b.a
                    ir.nasim.qk5$a r2 = r2.a()
                    java.lang.Object r5 = r5.b(r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.m.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public m(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vt6$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = C22828vt6.this.new n(interfaceC20295rm1);
            nVar.c = obj;
            return nVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                ServiceBannerEntity[] serviceBannerEntityArr = (ServiceBannerEntity[]) C22828vt6.this.C().k((String) this.c, ServiceBannerEntity[].class);
                if (serviceBannerEntityArr != null) {
                    return AbstractC10242bK.f1(serviceBannerEntityArr);
                }
                return null;
            } catch (Exception e) {
                C19406qI3.a("ServicesRepository", e.getMessage(), new Object[0]);
                if (e instanceof CancellationException) {
                    throw e;
                }
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$o */
    static final class o extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C22828vt6.this.A(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.vt6$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20961st6 c20961st6 = C22828vt6.this.d;
                this.b = 1;
                objB = c20961st6.b(this);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$q */
    static final class q extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C22828vt6.this.B(null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.vt6$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new r(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object obj2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20961st6 c20961st6 = C22828vt6.this.d;
                String str = this.e;
                this.c = 1;
                objC = c20961st6.c(str, this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj2 = this.b;
                    AbstractC10685c16.b(obj);
                    objC = obj2;
                    return C9475a16.a(objC);
                }
                AbstractC10685c16.b(obj);
                objC = ((C9475a16) obj).l();
            }
            C22828vt6 c22828vt6 = C22828vt6.this;
            Throwable thE = C9475a16.e(objC);
            if (thE != null && (thE instanceof RpcException) && ((RpcException) thE).getCode() == 7) {
                InterfaceC19483qR interfaceC19483qR = c22828vt6.f;
                SR sr = SR.b;
                this.b = objC;
                this.c = 2;
                if (interfaceC19483qR.b(sr, this) == objE) {
                    return objE;
                }
                obj2 = objC;
                objC = obj2;
            }
            return C9475a16.a(objC);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$s */
    static final class s extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C22828vt6.this.D(this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.vt6$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new t(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C9475a16.a(C22828vt6.this.d.d());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$u */
    public static final class u implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.vt6$u$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.vt6$u$a$a, reason: collision with other inner class name */
            public static final class C1728a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1728a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C22828vt6.u.a.C1728a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.vt6$u$a$a r0 = (ir.nasim.C22828vt6.u.a.C1728a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.vt6$u$a$a r0 = new ir.nasim.vt6$u$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.vt6$b r2 = ir.nasim.C22828vt6.C22830b.a
                    ir.nasim.qk5$a r2 = r2.d()
                    java.lang.Object r5 = r5.b(r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.u.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public u(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vt6$v */
    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            v vVar = C22828vt6.this.new v(interfaceC20295rm1);
            vVar.c = obj;
            return vVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                ServiceShortcutEntity[] serviceShortcutEntityArr = (ServiceShortcutEntity[]) C22828vt6.this.C().k((String) this.c, ServiceShortcutEntity[].class);
                if (serviceShortcutEntityArr != null) {
                    return AbstractC10242bK.f1(serviceShortcutEntityArr);
                }
                return null;
            } catch (Exception e) {
                C19406qI3.a("ServicesRepository", e.getMessage(), new Object[0]);
                if (e instanceof CancellationException) {
                    throw e;
                }
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$w */
    public static final class w implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.vt6$w$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.vt6$w$a$a, reason: collision with other inner class name */
            public static final class C1729a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1729a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C22828vt6.w.a.C1729a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.vt6$w$a$a r0 = (ir.nasim.C22828vt6.w.a.C1729a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.vt6$w$a$a r0 = new ir.nasim.vt6$w$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.vt6$b r2 = ir.nasim.C22828vt6.C22830b.a
                    ir.nasim.qk5$a r2 = r2.c()
                    java.lang.Object r5 = r5.b(r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.w.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public w(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vt6$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        x(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            x xVar = C22828vt6.this.new x(interfaceC20295rm1);
            xVar.c = obj;
            return xVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                ServicesPageSectionEntity[] servicesPageSectionEntityArr = (ServicesPageSectionEntity[]) C22828vt6.this.H().k((String) this.c, ServicesPageSectionEntity[].class);
                if (servicesPageSectionEntityArr != null) {
                    return AbstractC10242bK.f1(servicesPageSectionEntityArr);
                }
                return null;
            } catch (Exception e) {
                C19406qI3.a("ServicesRepository", e.getMessage(), new Object[0]);
                if (e instanceof CancellationException) {
                    throw e;
                }
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vt6$y */
    static final class y extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        y(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objJ = C22828vt6.this.J(this);
            return objJ == AbstractC14862ic3.e() ? objJ : C9475a16.a(objJ);
        }
    }

    /* renamed from: ir.nasim.vt6$z */
    static final class z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22828vt6.this.new z(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20961st6 c20961st6 = C22828vt6.this.d;
                this.b = 1;
                objF = c20961st6.f(this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = ((C9475a16) obj).l();
            }
            return C9475a16.a(objF);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22828vt6(SettingsModule settingsModule, InterfaceC6721Or6 interfaceC6721Or6, InterfaceC7346Ri0 interfaceC7346Ri0, C20961st6 c20961st6, C6222Mr6 c6222Mr6, InterfaceC19483qR interfaceC19483qR, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC23475wz1 interfaceC23475wz1) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC6721Or6, "serviceItemsDao");
        AbstractC13042fc3.i(interfaceC7346Ri0, "botItemsDao");
        AbstractC13042fc3.i(c20961st6, "servicesRemoteService");
        AbstractC13042fc3.i(c6222Mr6, "serviceItemProtoToServiceItemEntityMapper");
        AbstractC13042fc3.i(interfaceC19483qR, "authenticatorLocalDataSource");
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC23475wz1, "dataStore");
        this.a = settingsModule;
        this.b = interfaceC6721Or6;
        this.c = interfaceC7346Ri0;
        this.d = c20961st6;
        this.e = c6222Mr6;
        this.f = interfaceC19483qR;
        this.g = abstractC13778go1;
        this.h = abstractC13778go12;
        this.i = interfaceC23475wz1;
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.tt6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22828vt6.K();
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ut6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22828vt6.N();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KS2 C() {
        return (KS2) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KS2 H() {
        return (KS2) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KS2 K() {
        return new KS2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(ai.bale.proto.GarsonOuterClass$ResponseGetServices r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.L(ai.bale.proto.GarsonOuterClass$ResponseGetServices, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KS2 N() {
        return new LS2().c(ServicesPageSectionEntity.class, new ir.nasim.features.bank.mybank.model.a()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object O(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GarsonStruct$GarsonServicesCategory garsonStruct$GarsonServicesCategory = (GarsonStruct$GarsonServicesCategory) it.next();
            for (GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem : garsonStruct$GarsonServicesCategory.getItemsList()) {
                C6222Mr6 c6222Mr6 = this.e;
                AbstractC13042fc3.f(garsonStruct$GarsonServiceItem);
                arrayList.add(c6222Mr6.a(garsonStruct$GarsonServiceItem, garsonStruct$GarsonServicesCategory.getId()));
            }
        }
        Object objB = this.b.b(arrayList, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object P(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC22147uk5.a(this.i, new E(H().u(list.toArray(new ServicesPageSectionEntity[0]), ServicesPageSectionEntity[].class), null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    private final Object Q(GarsonOuterClass$ResponseGetServices garsonOuterClass$ResponseGetServices, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC22147uk5.a(this.i, new F(garsonOuterClass$ResponseGetServices, null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(ai.bale.proto.GarsonOuterClass$ResponseGetServices r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.q(ai.bale.proto.GarsonOuterClass$ResponseGetServices, ir.nasim.rm1):java.lang.Object");
    }

    private final ServicesPageSectionEntity.Banner r(GarsonStruct$GarsonSection garsonStruct$GarsonSection, List list, KS2 ks2, InterfaceC23475wz1 interfaceC23475wz1) {
        if (!garsonStruct$GarsonSection.hasBanners()) {
            return null;
        }
        list.add(AbstractC10533bm0.d(AbstractC20906so1.a(this.h), null, null, new g(garsonStruct$GarsonSection, ks2, interfaceC23475wz1, null), 3, null));
        return new ServicesPageSectionEntity.Banner(garsonStruct$GarsonSection.getSectionId(), ServicesPageSectionEntity.BANNERS_SECTION_TITLE);
    }

    private final ServicesPageSectionEntity.BotsVitrine s(GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        if (!garsonStruct$GarsonSection.hasBotsVitrine()) {
            return null;
        }
        int sectionId = garsonStruct$GarsonSection.getSectionId();
        List<GarsonStruct$GarsonBot> botsList = garsonStruct$GarsonSection.getBotsVitrine().getBotsList();
        AbstractC13042fc3.h(botsList, "getBotsList(...)");
        List<GarsonStruct$GarsonBot> list = botsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((GarsonStruct$GarsonBot) it.next()).getBotUserId()));
        }
        return new ServicesPageSectionEntity.BotsVitrine(sectionId, ServicesPageSectionEntity.BOTS_VITRINE_SECTION_TITLE, AbstractC15401jX0.j0(arrayList));
    }

    private final ServicesPageSectionEntity.CustomServices t(GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        if (!garsonStruct$GarsonSection.hasCustomServices()) {
            return null;
        }
        int sectionId = garsonStruct$GarsonSection.getSectionId();
        List<Integer> itemsList = garsonStruct$GarsonSection.getCustomServices().getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        return new ServicesPageSectionEntity.CustomServices(sectionId, ServicesPageSectionEntity.CUSTOM_SERVICES_SECTION_TITLE, itemsList);
    }

    private final ServicesPageSectionEntity u(GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        if (!garsonStruct$GarsonSection.hasExtra()) {
            return null;
        }
        List<GarsonStruct$GarsonItem> itemsList = garsonStruct$GarsonSection.getExtra().getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        GarsonStruct$GarsonItem garsonStruct$GarsonItem = (GarsonStruct$GarsonItem) AbstractC15401jX0.t0(itemsList, 0);
        if (garsonStruct$GarsonItem == null) {
            return null;
        }
        if (garsonStruct$GarsonItem.hasService()) {
            int sectionId = garsonStruct$GarsonSection.getSectionId();
            String title = garsonStruct$GarsonSection.getExtra().getTitle();
            AbstractC13042fc3.h(title, "getTitle(...)");
            int number = garsonStruct$GarsonSection.getExtra().getBadgeType().getNumber();
            int number2 = garsonStruct$GarsonSection.getExtra().getButtonNavigation().getType().getNumber();
            int serviceCategoryId = garsonStruct$GarsonSection.getExtra().getButtonNavigation().getServiceCategoryId();
            String buttonText = garsonStruct$GarsonSection.getExtra().getButtonText();
            AbstractC13042fc3.h(buttonText, "getButtonText(...)");
            List<GarsonStruct$GarsonItem> itemsList2 = garsonStruct$GarsonSection.getExtra().getItemsList();
            AbstractC13042fc3.h(itemsList2, "getItemsList(...)");
            List<GarsonStruct$GarsonItem> list = itemsList2;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((GarsonStruct$GarsonItem) it.next()).getService().getId()));
            }
            return new ServicesPageSectionEntity.ServiceItemsExtra(sectionId, title, number, serviceCategoryId, number2, buttonText, arrayList);
        }
        if (!garsonStruct$GarsonItem.hasBot()) {
            return null;
        }
        int sectionId2 = garsonStruct$GarsonSection.getSectionId();
        String title2 = garsonStruct$GarsonSection.getExtra().getTitle();
        AbstractC13042fc3.h(title2, "getTitle(...)");
        int number3 = garsonStruct$GarsonSection.getExtra().getBadgeType().getNumber();
        int number4 = garsonStruct$GarsonSection.getExtra().getButtonNavigation().getType().getNumber();
        String value = garsonStruct$GarsonSection.getExtra().getButtonNavigation().getDestinationUrl().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        int serviceCategoryId2 = garsonStruct$GarsonSection.getExtra().getButtonNavigation().getServiceCategoryId();
        String buttonText2 = garsonStruct$GarsonSection.getExtra().getButtonText();
        AbstractC13042fc3.h(buttonText2, "getButtonText(...)");
        List<GarsonStruct$GarsonItem> itemsList3 = garsonStruct$GarsonSection.getExtra().getItemsList();
        AbstractC13042fc3.h(itemsList3, "getItemsList(...)");
        List<GarsonStruct$GarsonItem> list2 = itemsList3;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(((GarsonStruct$GarsonItem) it2.next()).getBot().getBotUserId()));
        }
        return new ServicesPageSectionEntity.BotsVitrineExtra(sectionId2, title2, number3, serviceCategoryId2, number4, value, buttonText2, arrayList2);
    }

    private final ServicesPageSectionEntity v(GarsonStruct$GarsonSection garsonStruct$GarsonSection, List list) {
        ServicesPageSectionEntity.Shortcut shortcutW = w(garsonStruct$GarsonSection, list, C(), this.i);
        if (shortcutW != null) {
            return shortcutW;
        }
        ServicesPageSectionEntity.CustomServices customServicesT = t(garsonStruct$GarsonSection);
        if (customServicesT != null) {
            return customServicesT;
        }
        ServicesPageSectionEntity.Banner bannerR = r(garsonStruct$GarsonSection, list, C(), this.i);
        if (bannerR != null) {
            return bannerR;
        }
        ServicesPageSectionEntity.BotsVitrine botsVitrineS = s(garsonStruct$GarsonSection);
        return botsVitrineS != null ? botsVitrineS : u(garsonStruct$GarsonSection);
    }

    private final ServicesPageSectionEntity.Shortcut w(GarsonStruct$GarsonSection garsonStruct$GarsonSection, List list, KS2 ks2, InterfaceC23475wz1 interfaceC23475wz1) {
        if (!garsonStruct$GarsonSection.hasShortcuts()) {
            return null;
        }
        list.add(AbstractC10533bm0.d(AbstractC20906so1.a(this.h), null, null, new h(garsonStruct$GarsonSection, ks2, interfaceC23475wz1, null), 3, null));
        return new ServicesPageSectionEntity.Shortcut(garsonStruct$GarsonSection.getSectionId(), ServicesPageSectionEntity.SHORTCUTS_SECTION_TITLE);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C22828vt6.o
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.vt6$o r0 = (ir.nasim.C22828vt6.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vt6$o r0 = new ir.nasim.vt6$o
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.h
            ir.nasim.vt6$p r2 = new ir.nasim.vt6$p
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.A(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C22828vt6.q
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.vt6$q r0 = (ir.nasim.C22828vt6.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vt6$q r0 = new ir.nasim.vt6$q
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.h
            ir.nasim.vt6$r r2 = new ir.nasim.vt6$r
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.B(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C22828vt6.s
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.vt6$s r0 = (ir.nasim.C22828vt6.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vt6$s r0 = new ir.nasim.vt6$s
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.h
            ir.nasim.vt6$t r2 = new ir.nasim.vt6$t
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.D(ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 E() {
        return this.b.e();
    }

    public final InterfaceC4557Fq2 F() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.X(AbstractC6459Nq2.v(new u(this.i.getData())), new v(null)), this.h);
    }

    public final InterfaceC4557Fq2 G() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.X(AbstractC6459Nq2.v(new w(this.i.getData())), new x(null)), this.h);
    }

    public final List I() {
        try {
            Object objK = C().k(this.a.J4(), Integer[].class);
            AbstractC13042fc3.h(objK, "fromJson(...)");
            return AbstractC10242bK.f1((Object[]) objK);
        } catch (Exception e) {
            C19406qI3.a("ServicesRepository", e.getMessage(), new Object[0]);
            return AbstractC10360bX0.m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C22828vt6.y
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.vt6$y r0 = (ir.nasim.C22828vt6.y) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vt6$y r0 = new ir.nasim.vt6$y
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.g
            ir.nasim.vt6$z r2 = new ir.nasim.vt6$z
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.J(ir.nasim.rm1):java.lang.Object");
    }

    public final Object M(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.h, new D(list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final void o(int i2) {
        Set setQ1 = AbstractC15401jX0.q1(I());
        if (setQ1.add(Integer.valueOf(i2))) {
            this.a.P7(C().t(setQ1));
        }
    }

    public final Object p(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.h, new C22831c(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C22828vt6.i
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.vt6$i r0 = (ir.nasim.C22828vt6.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vt6$i r0 = new ir.nasim.vt6$i
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.g
            ir.nasim.vt6$j r2 = new ir.nasim.vt6$j
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.x(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C22828vt6.k
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.vt6$k r0 = (ir.nasim.C22828vt6.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vt6$k r0 = new ir.nasim.vt6$k
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.h
            ir.nasim.vt6$l r2 = new ir.nasim.vt6$l
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22828vt6.y(ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 z() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.X(AbstractC6459Nq2.v(new m(this.i.getData())), new n(null)), this.h);
    }
}
