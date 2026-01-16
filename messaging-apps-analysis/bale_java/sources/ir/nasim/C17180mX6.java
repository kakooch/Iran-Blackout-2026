package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$MediaStory;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.ZV6;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.mX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17180mX6 extends VW7 {
    public static final b l = new b(null);
    public static final int m = 8;
    private final SettingsModule b;
    private final JX7 c;
    private final HH5 d;
    private final InterfaceC3570Bk5 e;
    private final C10928cR6 f;
    private final E84 g;
    private String h;
    private final InterfaceC8327Vm4 i;
    private final InterfaceC10040ay6 j;
    private ZV6 k;

    /* renamed from: ir.nasim.mX6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.mX6$a$a, reason: collision with other inner class name */
        static final class C1400a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C17180mX6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1400a(C17180mX6 c17180mX6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c17180mX6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1400a c1400a = new C1400a(this.d, interfaceC20295rm1);
                c1400a.c = obj;
                return c1400a;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0059 A[RETURN] */
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
                    if (r1 == 0) goto L22
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L5a
                L12:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1a:
                    java.lang.Object r1 = r5.c
                    java.util.List r1 = (java.util.List) r1
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L22:
                    ir.nasim.AbstractC10685c16.b(r6)
                    java.lang.Object r6 = r5.c
                    r1 = r6
                    java.util.List r1 = (java.util.List) r1
                    ir.nasim.mX6 r6 = r5.d
                    java.lang.String r6 = ir.nasim.C17180mX6.P0(r6)
                    if (r6 == 0) goto L47
                    ir.nasim.mX6 r4 = r5.d
                    ir.nasim.zG1 r6 = ir.nasim.C17180mX6.R0(r4, r6)
                    r5.c = r1
                    r5.b = r3
                    java.lang.Object r6 = r6.y(r5)
                    if (r6 != r0) goto L43
                    return r0
                L43:
                    java.util.List r6 = (java.util.List) r6
                    if (r6 != 0) goto L48
                L47:
                    r6 = r1
                L48:
                    ir.nasim.mX6 r1 = r5.d
                    ir.nasim.Vm4 r1 = ir.nasim.C17180mX6.U0(r1)
                    r3 = 0
                    r5.c = r3
                    r5.b = r2
                    java.lang.Object r6 = r1.a(r6, r5)
                    if (r6 != r0) goto L5a
                    return r0
                L5a:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17180mX6.a.C1400a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1400a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6B = C17180mX6.this.d.b();
                C1400a c1400a = new C1400a(C17180mX6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6B, c1400a, this) == objE) {
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

    /* renamed from: ir.nasim.mX6$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.mX6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17180mX6.this.h = null;
                InterfaceC8327Vm4 interfaceC8327Vm4 = C17180mX6.this.i;
                Object value = C17180mX6.this.d.b().getValue();
                this.b = 1;
                if (interfaceC8327Vm4.a(value, this) == objE) {
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

    /* renamed from: ir.nasim.mX6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Iterable<C12853fH5> iterable = (Iterable) C17180mX6.this.d.b().getValue();
            String str = this.d;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            for (C12853fH5 c12853fH5 : iterable) {
                if (AbstractC13042fc3.d(c12853fH5.a(), str)) {
                    c12853fH5 = new C12853fH5(c12853fH5.a(), true);
                }
                arrayList.add(c12853fH5);
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.mX6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new e(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r5)
                goto L5b
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ir.nasim.AbstractC10685c16.b(r5)
                goto L38
            L1e:
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.mX6 r5 = ir.nasim.C17180mX6.this
                java.lang.String r5 = ir.nasim.C17180mX6.P0(r5)
                if (r5 == 0) goto L3c
                ir.nasim.mX6 r1 = ir.nasim.C17180mX6.this
                ir.nasim.zG1 r5 = ir.nasim.C17180mX6.R0(r1, r5)
                r4.b = r3
                java.lang.Object r5 = r5.y(r4)
                if (r5 != r0) goto L38
                return r0
            L38:
                java.util.List r5 = (java.util.List) r5
                if (r5 != 0) goto L4c
            L3c:
                ir.nasim.mX6 r5 = ir.nasim.C17180mX6.this
                ir.nasim.HH5 r5 = ir.nasim.C17180mX6.S0(r5)
                ir.nasim.bL6 r5 = r5.b()
                java.lang.Object r5 = r5.getValue()
                java.util.List r5 = (java.util.List) r5
            L4c:
                ir.nasim.mX6 r1 = ir.nasim.C17180mX6.this
                ir.nasim.Vm4 r1 = ir.nasim.C17180mX6.U0(r1)
                r4.b = r2
                java.lang.Object r5 = r1.a(r5, r4)
                if (r5 != r0) goto L5b
                return r0
            L5b:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17180mX6.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.mX6$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ EnumC10088b35 e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, EnumC10088b35 enumC10088b35, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = enumC10088b35;
            this.f = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new f(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HH5 hh5 = C17180mX6.this.d;
                String str = this.d;
                EnumC10088b35 enumC10088b35 = this.e;
                String str2 = this.f;
                this.b = 1;
                if (hh5.d(str, enumC10088b35, str2, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.mX6$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ EnumC10088b35 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, EnumC10088b35 enumC10088b35, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = enumC10088b35;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new g(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HH5 hh5 = C17180mX6.this.d;
                String str = this.d;
                EnumC10088b35 enumC10088b35 = this.e;
                this.b = 1;
                if (hh5.e(str, enumC10088b35, this) == objE) {
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

    /* renamed from: ir.nasim.mX6$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C17180mX6 d;
        final /* synthetic */ String e;
        final /* synthetic */ QQ6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(boolean z, C17180mX6 c17180mX6, String str, QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c17180mX6;
            this.e = str;
            this.f = qq6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            EnumC10088b35 type;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            enumC23779xV6B = null;
            EnumC23779xV6 enumC23779xV6B = null;
            if (this.c) {
                this.d.l1(this.e);
                C17180mX6 c17180mX6 = this.d;
                String strL = this.f.l();
                PeersStruct$ExPeer peersStruct$ExPeerG = this.f.g();
                c17180mX6.g1(strL, peersStruct$ExPeerG != null ? peersStruct$ExPeerG.getType() : null, this.e);
                ZV6 zv6D1 = this.d.d1();
                if (zv6D1 != null) {
                    C17180mX6 c17180mX62 = this.d;
                    QQ6 qq6 = this.f;
                    ZV6.e eVar = new ZV6.e(zv6D1, qq6.l(), XV6.b.a(qq6.e()));
                    PeersStruct$ExPeer peersStruct$ExPeerG2 = qq6.g();
                    if (peersStruct$ExPeerG2 != null && (type = peersStruct$ExPeerG2.getType()) != null) {
                        enumC23779xV6B = AbstractC24369yV6.b(type);
                    }
                    c17180mX62.s1(eVar, enumC23779xV6B);
                }
            } else {
                this.d.Y0();
                C17180mX6 c17180mX63 = this.d;
                String strL2 = this.f.l();
                PeersStruct$ExPeer peersStruct$ExPeerG3 = this.f.g();
                c17180mX63.h1(strL2, peersStruct$ExPeerG3 != null ? peersStruct$ExPeerG3.getType() : null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.mX6$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new i(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC8327Vm4 interfaceC8327Vm4;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17180mX6.this.h = this.e;
                interfaceC8327Vm4 = C17180mX6.this.i;
                InterfaceC24823zG1 interfaceC24823zG1A1 = C17180mX6.this.a1(this.e);
                this.b = interfaceC8327Vm4;
                this.c = 1;
                obj = interfaceC24823zG1A1.y(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC8327Vm4 = (InterfaceC8327Vm4) this.b;
                AbstractC10685c16.b(obj);
            }
            this.b = null;
            this.c = 2;
            if (interfaceC8327Vm4.a(obj, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.mX6$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QQ6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qq6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17180mX6.this.new j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            EnumC10088b35 type;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ZV6 zv6D1 = C17180mX6.this.d1();
                if (zv6D1 != null) {
                    C17180mX6 c17180mX6 = C17180mX6.this;
                    QQ6 qq6 = this.d;
                    String strL = qq6.l();
                    XV6 xv6A = XV6.b.a(qq6.e());
                    StoryStruct$MediaStory storyStruct$MediaStoryD = qq6.d();
                    ZV6.g gVar = new ZV6.g(zv6D1, storyStruct$MediaStoryD != null ? (int) storyStruct$MediaStoryD.getFileSize() : 0, strL, xv6A);
                    PeersStruct$ExPeer peersStruct$ExPeerG = qq6.g();
                    c17180mX6.s1(gVar, (peersStruct$ExPeerG == null || (type = peersStruct$ExPeerG.getType()) == null) ? null : AbstractC24369yV6.b(type));
                }
                if (this.d.u() == YK6.c && AbstractC13042fc3.d(this.d.s(), AbstractC11710dT6.a.a)) {
                    JX7 jx7 = C17180mX6.this.c;
                    String strL2 = this.d.l();
                    PeersStruct$ExPeer peersStruct$ExPeerG2 = this.d.g();
                    EnumC10088b35 type2 = peersStruct$ExPeerG2 != null ? peersStruct$ExPeerG2.getType() : null;
                    this.b = 1;
                    if (jx7.h(strL2, type2, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17180mX6(SettingsModule settingsModule, JX7 jx7, HH5 hh5, InterfaceC3570Bk5 interfaceC3570Bk5, C10928cR6 c10928cR6, E84 e84) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(jx7, "viewStoryRepository");
        AbstractC13042fc3.i(hh5, "reactionRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(c10928cR6, "storyItemToStoryEntityMapper");
        AbstractC13042fc3.i(e84, "messagesModule");
        this.b = settingsModule;
        this.c = jx7;
        this.d = hh5;
        this.e = interfaceC3570Bk5;
        this.f = c10928cR6;
        this.g = e84;
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.i = interfaceC8327Vm4B;
        this.j = interfaceC8327Vm4B;
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC24823zG1 a1(String str) {
        return AbstractC10533bm0.b(AbstractC9773aX7.a(this), C12366eV1.a(), null, new d(str, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 g1(String str, EnumC10088b35 enumC10088b35, String str2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(str, enumC10088b35, str2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 h1(String str, EnumC10088b35 enumC10088b35) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(str, enumC10088b35, null), 3, null);
    }

    public final InterfaceC13730gj3 Y0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final InterfaceC10040ay6 Z0() {
        return this.j;
    }

    public final boolean b1() {
        return this.e.h("STORY_REACTION_PANEL_IS_OPEN", true);
    }

    public final InterfaceC13730gj3 c1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final ZV6 d1() {
        return this.k;
    }

    public final void e1(WV6 wv6, Integer num, EnumC23779xV6 enumC23779xV6) {
        AbstractC13042fc3.i(wv6, "origin");
        AbstractC13042fc3.i(enumC23779xV6, "storyType");
        ZV6.a aVar = new ZV6.a(AbstractC17026mG5.a.j(0, Integer.MAX_VALUE), wv6, num);
        C23144wQ6 c23144wQ6 = C23144wQ6.a;
        int iE = aVar.e();
        String strA = aVar.a();
        YV6 yv6C = aVar.c();
        XV6 xv6B = aVar.b();
        c23144wQ6.k(yv6C, aVar.getOrigin(), aVar.getIndex(), xv6B, strA, Integer.valueOf(iE), null, AbstractC24369yV6.a(enumC23779xV6));
        this.k = aVar;
    }

    public final void f1() {
        SettingsModule settingsModule = this.b;
        settingsModule.I7(settingsModule.o4() + 1);
        settingsModule.I7(settingsModule.o4());
        this.e.g("GET_STORY_TRIGGER", false);
    }

    public final InterfaceC13730gj3 i1(String str, boolean z, QQ6 qq6) {
        AbstractC13042fc3.i(str, "emojiUnicode");
        AbstractC13042fc3.i(qq6, "storyItem");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new h(z, this, str, qq6, null), 2, null);
    }

    public final void j1(String str, int i2, QQ6 qq6) {
        EnumC10088b35 type;
        AbstractC13042fc3.i(str, "replyText");
        AbstractC13042fc3.i(qq6, "storyItem");
        this.g.H2(C11458d25.E(i2), str, this.f.a(qq6));
        ZV6 zv6 = this.k;
        if (zv6 != null) {
            ZV6.f fVar = new ZV6.f(zv6, qq6.l(), XV6.b.a(qq6.e()));
            PeersStruct$ExPeer peersStruct$ExPeerG = qq6.g();
            s1(fVar, (peersStruct$ExPeerG == null || (type = peersStruct$ExPeerG.getType()) == null) ? null : AbstractC24369yV6.b(type));
        }
        C23144wQ6.a.f();
    }

    public final void k1(QQ6 qq6) {
        EnumC10088b35 type;
        AbstractC13042fc3.i(qq6, "storyItem");
        ZV6 zv6 = this.k;
        if (zv6 != null) {
            ZV6.d dVar = new ZV6.d(zv6, qq6.l(), XV6.b.a(qq6.e()));
            PeersStruct$ExPeer peersStruct$ExPeerG = qq6.g();
            s1(dVar, (peersStruct$ExPeerG == null || (type = peersStruct$ExPeerG.getType()) == null) ? null : AbstractC24369yV6.b(type));
        }
        C23144wQ6.a.e(qq6.l());
    }

    public final InterfaceC13730gj3 l1(String str) {
        AbstractC13042fc3.i(str, "unicode");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(str, null), 3, null);
    }

    public final void m1(boolean z) {
        this.e.g("STORY_REACTION_PANEL_IS_OPEN", z);
    }

    public final boolean o1() {
        return this.e.h("GET_STORY_TRIGGER", false) && this.b.o4() < 1;
    }

    public final boolean p1() {
        int iO4 = this.b.o4();
        return this.e.h("GET_STORY_TRIGGER", false) && 1 <= iO4 && iO4 < 4;
    }

    public final InterfaceC13730gj3 q1(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(qq6, null), 3, null);
    }

    public final void s1(ZV6 zv6, EnumC23779xV6 enumC23779xV6) {
        AbstractC13042fc3.i(zv6, "storyViewEvents");
        C23144wQ6 c23144wQ6 = C23144wQ6.a;
        int iE = zv6.e();
        String strA = zv6.a();
        c23144wQ6.k(zv6.c(), zv6.getOrigin(), zv6.getIndex(), zv6.b(), strA, Integer.valueOf(iE), null, enumC23779xV6 != null ? AbstractC24369yV6.a(enumC23779xV6) : null);
        ZV6 zv62 = zv6 instanceof ZV6.g ? zv6 : null;
        if (zv62 != null) {
            zv62.d(null);
        }
        this.k = zv6;
    }
}
