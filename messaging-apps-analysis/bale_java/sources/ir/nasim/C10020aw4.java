package ir.nasim;

import android.util.Log;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC3769Cg6;
import ir.nasim.C10020aw4;
import ir.nasim.C17624nH3;
import ir.nasim.C21108t74;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.aw4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10020aw4 extends VW7 {
    public static final a D0 = new a(null);
    public static final int E0 = 8;
    private final C14063hH6 A;
    private final InterfaceC9173Yu3 A0;
    private final InterfaceC9664aL6 B;
    private final String B0;
    private final InterfaceC9173Yu3 C0;
    private final InterfaceC9173Yu3 D;
    private final String G;
    private final InterfaceC9336Zm4 H;
    private final long J;
    private C20238rg6 Y;
    private C21782u74 Z;
    private final SettingsModule b;
    private final C4471Fg6 c;
    private final C10299bQ2 d;
    private final OK7 e;
    private final InterfaceC8038Ug3 f;
    private final UG7 g;
    private final E84 h;
    private final C8054Ui1 i;
    private final InterfaceC4308Eo5 j;
    private final InterfaceC3570Bk5 k;
    private final C17624nH3.b l;
    private final C21108t74.b m;
    private final C24296yN5 n;
    private final C20005rJ2 o;
    private final InterfaceC19567qa2 p;
    private final InterfaceC11621dJ7 q;
    private final InterfaceC12607et7 r;
    private final InterfaceC20667sP1 s;
    private final InterfaceC6828Pd5 t;
    private final C15841kG2 u;
    private final int v;
    private final InterfaceC9336Zm4 w;
    private final InterfaceC9336Zm4 x;
    private final InterfaceC9336Zm4 y;
    private final InterfaceC10258bL6 z;
    private final InterfaceC9173Yu3 z0;

    /* renamed from: ir.nasim.aw4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.aw4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        /* renamed from: ir.nasim.aw4$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.c;
                AbstractC3769Cg6 abstractC3769Cg62 = (AbstractC3769Cg6) this.d;
                if (!(abstractC3769Cg6 instanceof AbstractC3769Cg6.c) && (abstractC3769Cg62 instanceof AbstractC3769Cg6.c)) {
                    return new AbstractC3769Cg6.h(AbstractC12217eE5.search__contacts_private, null, null, null, null, null, 62, null);
                }
                if (!(abstractC3769Cg6 instanceof AbstractC3769Cg6.g) && (abstractC3769Cg62 instanceof AbstractC3769Cg6.g)) {
                    return new AbstractC3769Cg6.h(AbstractC12217eE5.dialog_type_group, null, null, null, null, null, 62, null);
                }
                if (!(abstractC3769Cg6 instanceof AbstractC3769Cg6.b) && (abstractC3769Cg62 instanceof AbstractC3769Cg6.b)) {
                    return new AbstractC3769Cg6.h(AbstractC12217eE5.dialog_type_channel, null, null, null, null, null, 62, null);
                }
                if ((abstractC3769Cg6 instanceof AbstractC3769Cg6.a) || !(abstractC3769Cg62 instanceof AbstractC3769Cg6.a)) {
                    return null;
                }
                return new AbstractC3769Cg6.h(AbstractC12217eE5.bot_dialog_tab_type_title, null, null, null, null, null, 62, null);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(AbstractC3769Cg6 abstractC3769Cg6, AbstractC3769Cg6 abstractC3769Cg62, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = abstractC3769Cg6;
                aVar.d = abstractC3769Cg62;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.f((NT4) this.c, null, new a(null), 1, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        /* renamed from: ir.nasim.aw4$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.c;
                AbstractC3769Cg6 abstractC3769Cg62 = (AbstractC3769Cg6) this.d;
                if ((abstractC3769Cg6 instanceof AbstractC3769Cg6.i) || !(abstractC3769Cg62 instanceof AbstractC3769Cg6.i)) {
                    return null;
                }
                return new AbstractC3769Cg6.h(AbstractC12217eE5.call_to_messages, null, null, null, null, null, 62, null);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(AbstractC3769Cg6 abstractC3769Cg6, AbstractC3769Cg6 abstractC3769Cg62, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = abstractC3769Cg6;
                aVar.d = abstractC3769Cg62;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

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
            return UT4.f((NT4) this.c, null, new a(null), 1, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new d(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x015d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x014b A[EDGE_INSN: B:64:0x014b->B:49:0x014b BREAK  A[LOOP:1: B:31:0x00d6->B:66:0x00d6], SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10020aw4.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C11458d25 c11458d25, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C10020aw4 c10020aw4 = C10020aw4.this;
                XV4 xv4A = AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1));
                XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", AbstractC6392Nk0.d(this.d.s().ordinal() + 1));
                XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", AbstractC6392Nk0.d(this.d.getPeerId()));
                String str = (String) C10020aw4.this.x.getValue();
                if (str == null) {
                    str = "";
                }
                c10020aw4.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("query_text", str), AbstractC4616Fw7.a("event_type", this.e ? "jostojuye sarsari goorooh" : "jostojuye sarsari kanal")));
                if (this.e) {
                    C10020aw4.this.m2("Group_join_source", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", AbstractC6392Nk0.d(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", AbstractC6392Nk0.e(System.currentTimeMillis())), AbstractC4616Fw7.a("peer_id", AbstractC6392Nk0.d(this.d.getPeerId())), AbstractC4616Fw7.a("peer_type", AbstractC6392Nk0.d(this.d.s().ordinal() + 1)), AbstractC4616Fw7.a("event_type", "search")));
                }
                C19406qI3.a("Source_Join_Cause", "search joinPublicGroup()", new Object[0]);
                C6517Nv5 c6517Nv5Q2 = C10020aw4.this.d.q2(this.d);
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5Q2, null, this, 1, null);
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
            C11458d25 c11458d25 = this.d;
            if (C9475a16.j(objD)) {
                ((Number) objD).intValue();
                C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        /* synthetic */ Object g;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C10020aw4.this.new f(interfaceC20295rm1);
            fVar.g = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x006b -> B:14:0x006e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0073 -> B:15:0x0070). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.f
                r3 = 1
                if (r2 == 0) goto L2d
                if (r2 != r3) goto L25
                java.lang.Object r2 = r0.e
                ir.nasim.gi6 r2 = (ir.nasim.C13723gi6) r2
                java.lang.Object r4 = r0.d
                java.lang.Object r5 = r0.c
                ir.nasim.aw4 r5 = (ir.nasim.C10020aw4) r5
                java.lang.Object r6 = r0.b
                ir.nasim.Zm4 r6 = (ir.nasim.InterfaceC9336Zm4) r6
                java.lang.Object r7 = r0.g
                java.lang.String r7 = (java.lang.String) r7
                ir.nasim.AbstractC10685c16.b(r18)
                r8 = r18
                goto L6e
            L25:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L2d:
                ir.nasim.AbstractC10685c16.b(r18)
                java.lang.Object r2 = r0.g
                java.lang.String r2 = (java.lang.String) r2
                ir.nasim.aw4 r4 = ir.nasim.C10020aw4.this
                ir.nasim.Zm4 r4 = ir.nasim.C10020aw4.s1(r4)
                ir.nasim.aw4 r5 = ir.nasim.C10020aw4.this
                r7 = r2
                r6 = r4
            L3e:
                java.lang.Object r4 = r6.getValue()
                r2 = r4
                ir.nasim.gi6 r2 = (ir.nasim.C13723gi6) r2
                boolean r8 = ir.nasim.C10020aw4.t1(r5)
                if (r8 == 0) goto L73
                ir.nasim.yN5 r8 = ir.nasim.C10020aw4.i1(r5)
                java.lang.String r9 = ir.nasim.XY6.o(r7)
                java.lang.CharSequence r9 = ir.nasim.AbstractC14836iZ6.n1(r9)
                java.lang.String r9 = r9.toString()
                r0.g = r7
                r0.b = r6
                r0.c = r5
                r0.d = r4
                r0.e = r2
                r0.f = r3
                java.lang.Object r8 = r8.k(r9, r0)
                if (r8 != r1) goto L6e
                return r1
            L6e:
                java.util.List r8 = (java.util.List) r8
            L70:
                r9 = r2
                r14 = r8
                goto L78
            L73:
                java.util.List r8 = ir.nasim.ZW0.m()
                goto L70
            L78:
                r15 = 15
                r16 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                ir.nasim.gi6 r2 = ir.nasim.C13723gi6.b(r9, r10, r11, r12, r13, r14, r15, r16)
                boolean r2 = r6.f(r4, r2)
                if (r2 == 0) goto L3e
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10020aw4.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.aw4$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ C10020aw4 e;

            /* renamed from: ir.nasim.aw4$g$a$a, reason: collision with other inner class name */
            static final class C0889a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C10020aw4 c;
                final /* synthetic */ List d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0889a(C10020aw4 c10020aw4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c10020aw4;
                    this.d = list;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0889a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        UG7 ug7 = this.c.g;
                        List list = this.d;
                        ArrayList arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            C18823pJ2 c18823pJ2 = (C18823pJ2) it.next();
                            C18766pD c18766pD = c18823pJ2.c.C() ? new C18766pD(c18823pJ2.c.getPeerId(), 0L) : null;
                            if (c18766pD != null) {
                                arrayList.add(c18766pD);
                            }
                        }
                        List<C18823pJ2> list2 = this.d;
                        ArrayList arrayList2 = new ArrayList();
                        for (C18823pJ2 c18823pJ22 : list2) {
                            C25238zy c25238zy = new C25238zy(c18823pJ22.c.getPeerId(), 0L);
                            if (!c18823pJ22.c.z()) {
                                c25238zy = null;
                            }
                            if (c25238zy != null) {
                                arrayList2.add(c25238zy);
                            }
                        }
                        ug7.t0(arrayList, arrayList2, false);
                        InterfaceC4308Eo5 interfaceC4308Eo5 = this.c.j;
                        List<C18823pJ2> list3 = this.d;
                        ArrayList arrayList3 = new ArrayList();
                        for (C18823pJ2 c18823pJ23 : list3) {
                            Integer numD = AbstractC6392Nk0.d(c18823pJ23.c.getPeerId());
                            numD.intValue();
                            if (!c18823pJ23.c.C()) {
                                numD = null;
                            }
                            if (numD != null) {
                                arrayList3.add(numD);
                            }
                        }
                        this.b = 1;
                        if (interfaceC4308Eo5.f(arrayList3, true, this) == objE) {
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
                    return ((C0889a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.aw4$g$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C10020aw4 c;
                final /* synthetic */ C18823pJ2 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C10020aw4 c10020aw4, C18823pJ2 c18823pJ2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c10020aw4;
                    this.d = c18823pJ2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C20005rJ2 c20005rJ2 = this.c.o;
                        C18823pJ2 c18823pJ2 = this.d;
                        this.b = 1;
                        obj = c20005rJ2.a(c18823pJ2, this);
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

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, C10020aw4 c10020aw4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
                this.e = c10020aw4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List list = (List) this.c;
                    AbstractC10533bm0.d(this.d, null, null, new C0889a(this.e, list, null), 3, null);
                    List list2 = list;
                    InterfaceC20315ro1 interfaceC20315ro1 = this.d;
                    C10020aw4 c10020aw4 = this.e;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(c10020aw4, (C18823pJ2) it.next(), null), 3, null));
                    }
                    this.b = 1;
                    obj = DV.a(arrayList, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                List listN0 = AbstractC15401jX0.n0((Iterable) obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.e.w;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C13723gi6.b((C13723gi6) value, null, listN0, null, null, null, 29, null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C10020aw4.this.new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2A2 = C10020aw4.this.a2();
                a aVar = new a(interfaceC20315ro1, C10020aw4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A2, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.aw4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.aw4$h$a */
        public static final class a implements FB3 {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ C10020aw4 b;

            a(InterfaceC16204ks5 interfaceC16204ks5, C10020aw4 c10020aw4) {
                this.a = interfaceC16204ks5;
                this.b = c10020aw4;
            }

            @Override // ir.nasim.FB3
            public void b() {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void c(List list) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void d(List list) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void e(long j) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void f(long[] jArr) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void g(List list, EnumC24659yz5 enumC24659yz5) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void a(C18823pJ2 c18823pJ2) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.I1().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C10020aw4 c10020aw4, a aVar) {
            c10020aw4.I1().n(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = C10020aw4.this.new h(interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                if (C10020aw4.this.I1().k() != null) {
                    List listK = C10020aw4.this.I1().k();
                    if (listK == null) {
                        listK = AbstractC10360bX0.m();
                    }
                    interfaceC16204ks5.h(listK);
                }
                final a aVar = new a(interfaceC16204ks5, C10020aw4.this);
                C10020aw4.this.I1().j(aVar);
                final C10020aw4 c10020aw4 = C10020aw4.this;
                SA2 sa2 = new SA2() { // from class: ir.nasim.bw4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C10020aw4.h.y(c10020aw4, aVar);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8038Ug3 interfaceC8038Ug3 = C10020aw4.this.f;
                NJ5 nj5 = NJ5.RecommendationSource_SEARCH;
                this.b = 1;
                if (interfaceC8038Ug3.d(nj5, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.aw4$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C10020aw4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10020aw4 c10020aw4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c10020aw4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                C13723gi6 c13723gi6;
                ArrayList arrayList;
                String strA;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.w;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c13723gi6 = (C13723gi6) value;
                    List<C17067mL1> list2 = list;
                    arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    for (C17067mL1 c17067mL1 : list2) {
                        C15280jJ5 c15280jJ5V = c17067mL1.V();
                        int i = (c15280jJ5V == null || (strA = c15280jJ5V.a()) == null) ? 0 : Integer.parseInt(strA);
                        C15280jJ5 c15280jJ5V2 = c17067mL1.V();
                        arrayList.add(new AbstractC3769Cg6.g(null, i, c15280jJ5V2 != null ? c15280jJ5V2.b() : null, false, c17067mL1.R(), c17067mL1.J(), c17067mL1.H(), null, null, 128, null));
                    }
                } while (!interfaceC9336Zm4.f(value, C13723gi6.b(c13723gi6, null, null, arrayList, null, null, 27, null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4C = C10020aw4.this.f.c();
                a aVar = new a(C10020aw4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4C, aVar, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        /* synthetic */ Object g;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = C10020aw4.this.new k(interfaceC20295rm1);
            kVar.g = obj;
            return kVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0062 -> B:14:0x0065). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006a -> B:15:0x0067). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.f
                r3 = 1
                if (r2 == 0) goto L2d
                if (r2 != r3) goto L25
                java.lang.Object r2 = r0.e
                ir.nasim.gi6 r2 = (ir.nasim.C13723gi6) r2
                java.lang.Object r4 = r0.d
                java.lang.Object r5 = r0.c
                ir.nasim.Zm4 r5 = (ir.nasim.InterfaceC9336Zm4) r5
                java.lang.Object r6 = r0.b
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r7 = r0.g
                ir.nasim.aw4 r7 = (ir.nasim.C10020aw4) r7
                ir.nasim.AbstractC10685c16.b(r18)
                r8 = r18
                goto L65
            L25:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L2d:
                ir.nasim.AbstractC10685c16.b(r18)
                java.lang.Object r2 = r0.g
                java.lang.String r2 = (java.lang.String) r2
                java.lang.String r2 = ir.nasim.XY6.o(r2)
                ir.nasim.aw4 r4 = ir.nasim.C10020aw4.this
                ir.nasim.Zm4 r5 = ir.nasim.C10020aw4.s1(r4)
                r6 = r2
                r7 = r4
            L40:
                java.lang.Object r4 = r5.getValue()
                r2 = r4
                ir.nasim.gi6 r2 = (ir.nasim.C13723gi6) r2
                int r8 = r6.length()
                r9 = 3
                if (r8 < r9) goto L6a
                ir.nasim.yN5 r8 = ir.nasim.C10020aw4.i1(r7)
                r0.g = r7
                r0.b = r6
                r0.c = r5
                r0.d = r4
                r0.e = r2
                r0.f = r3
                java.lang.Object r8 = r8.j(r6, r0)
                if (r8 != r1) goto L65
                return r1
            L65:
                java.util.Map r8 = (java.util.Map) r8
            L67:
                r9 = r2
                r13 = r8
                goto L6f
            L6a:
                java.util.Map r8 = ir.nasim.AbstractC18278oO3.k()
                goto L67
            L6f:
                r15 = 23
                r16 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                ir.nasim.gi6 r2 = ir.nasim.C13723gi6.b(r9, r10, r11, r12, r13, r14, r15, r16)
                boolean r2 = r5.f(r4, r2)
                if (r2 == 0) goto L40
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10020aw4.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$l */
    public static final class l extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C10020aw4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(InterfaceC20295rm1 interfaceC20295rm1, C10020aw4 c10020aw4) {
            super(3, interfaceC20295rm1);
            this.e = c10020aw4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2A1 = this.e.A1(AbstractC20762sZ6.n1(XY6.o((String) this.d)).toString());
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A1, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = new l(interfaceC20295rm1, this.e);
            lVar.c = interfaceC4806Gq2;
            lVar.d = obj;
            return lVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$m */
    public static final class m extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C10020aw4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(InterfaceC20295rm1 interfaceC20295rm1, C10020aw4 c10020aw4) {
            super(3, interfaceC20295rm1);
            this.e = c10020aw4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2C1 = this.e.C1(AbstractC20762sZ6.n1(XY6.o((String) this.d)).toString());
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2C1, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = new m(interfaceC20295rm1, this.e);
            mVar.c = interfaceC4806Gq2;
            mVar.d = obj;
            return mVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5W0 = C10020aw4.this.e.w0(AbstractC9766aX0.e(AbstractC6392Nk0.d(C10020aw4.this.b.i2())), false);
                this.b = 1;
                Object objD = AbstractC6756Ov5.d(c6517Nv5W0, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
                objL = objD;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C10020aw4 c10020aw4 = C10020aw4.this;
            if (C9475a16.j(objL)) {
                C18987pb3 c18987pb3 = C18987pb3.a;
                C11458d25 c11458d25E = C11458d25.E(c10020aw4.b.i2());
                AbstractC13042fc3.h(c11458d25E, "user(...)");
                C18987pb3.x1(c18987pb3, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6828Pd5 interfaceC6828Pd5 = C10020aw4.this.t;
                C14063hH6 c14063hH6K1 = C10020aw4.this.K1();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(c14063hH6K1, 10));
                Iterator<E> it = c14063hH6K1.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(((AbstractC3769Cg6) it.next()).d().u()));
                }
                this.b = 1;
                if (interfaceC6828Pd5.a(0, arrayList, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            C10020aw4.this.K1().clear();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aw4$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10020aw4.this.new p(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
            ArrayList arrayList;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC12607et7 interfaceC12607et7 = C10020aw4.this.r;
                C11458d25 c11458d25 = this.d;
                this.b = 1;
                objA = interfaceC12607et7.a(c11458d25, this);
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
            C10020aw4 c10020aw4 = C10020aw4.this;
            C11458d25 c11458d252 = this.d;
            if (C9475a16.j(objA)) {
                ((Boolean) objA).booleanValue();
                InterfaceC9336Zm4 interfaceC9336Zm4 = c10020aw4.y;
                do {
                    value = interfaceC9336Zm4.getValue();
                    arrayList = new ArrayList();
                    for (Object obj2 : (List) value) {
                        if (((C4346Es7) obj2).b().getPeerId() != c11458d252.getPeerId()) {
                            arrayList.add(obj2);
                        }
                    }
                } while (!interfaceC9336Zm4.f(value, arrayList));
            }
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                Log.i("TopPeers", "removeTopPeer: " + thE.getMessage());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10020aw4(SettingsModule settingsModule, C4471Fg6 c4471Fg6, C10299bQ2 c10299bQ2, OK7 ok7, InterfaceC8038Ug3 interfaceC8038Ug3, UG7 ug7, E84 e84, C8054Ui1 c8054Ui1, InterfaceC4308Eo5 interfaceC4308Eo5, InterfaceC3570Bk5 interfaceC3570Bk5, C17624nH3.b bVar, C21108t74.b bVar2, C24296yN5 c24296yN5, C20005rJ2 c20005rJ2, InterfaceC19567qa2 interfaceC19567qa2, InterfaceC11621dJ7 interfaceC11621dJ7, InterfaceC12607et7 interfaceC12607et7, InterfaceC20667sP1 interfaceC20667sP1, InterfaceC6828Pd5 interfaceC6828Pd5, C15841kG2 c15841kG2, int i2, androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(interfaceC8038Ug3, "jaryanRepository");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(bVar, "localSearchListDataLoaderFactory");
        AbstractC13042fc3.i(bVar2, "messageSearchListDataLoaderFactory");
        AbstractC13042fc3.i(c24296yN5, "remoteSearchListDataLoaderFactory");
        AbstractC13042fc3.i(c20005rJ2, "entityToSearchModelMapper");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(interfaceC12607et7, "topPeersRepository");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(interfaceC6828Pd5, "pinRepository");
        AbstractC13042fc3.i(c15841kG2, "getPeersClickCountsUseCase");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = settingsModule;
        this.c = c4471Fg6;
        this.d = c10299bQ2;
        this.e = ok7;
        this.f = interfaceC8038Ug3;
        this.g = ug7;
        this.h = e84;
        this.i = c8054Ui1;
        this.j = interfaceC4308Eo5;
        this.k = interfaceC3570Bk5;
        this.l = bVar;
        this.m = bVar2;
        this.n = c24296yN5;
        this.o = c20005rJ2;
        this.p = interfaceC19567qa2;
        this.q = interfaceC11621dJ7;
        this.r = interfaceC12607et7;
        this.s = interfaceC20667sP1;
        this.t = interfaceC6828Pd5;
        this.u = c15841kG2;
        this.v = i2;
        this.w = AbstractC12281eL6.a(new C13723gi6(null, null, null, null, null, 31, null));
        this.x = AbstractC12281eL6.a(null);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new ArrayList());
        this.y = interfaceC9336Zm4A;
        this.z = interfaceC9336Zm4A;
        this.A = AbstractC10222bH6.f();
        this.B = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.Rv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C10020aw4.U1(this.a));
            }
        });
        this.D = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Sv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10020aw4.k2(this.a);
            }
        });
        this.G = settingsModule.w4();
        this.H = AbstractC12281eL6.a(Boolean.valueOf(interfaceC3570Bk5.h("GLOBAL_GROUP_BANNER_KEY", true)));
        this.J = settingsModule.k2();
        this.z0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Tv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10020aw4.e2(this.a);
            }
        });
        this.A0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Uv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10020aw4.g2(this.a);
            }
        });
        String str = (String) yVar.c("NEW_SEARCH_HINT");
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.B0 = str;
        this.C0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Vv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C10020aw4.S1(this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 A1(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = str.charAt(!z ? i2 : length) == '@';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        final String string = str.subSequence(i2, length + 1).toString();
        return AbstractC6459Nq2.X(new C12960fT4(new MT4(20, 0, false, 0, 0, 0, 58, null), null, new SA2() { // from class: ir.nasim.Zv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10020aw4.B1(this.a, string);
            }
        }, 2, null).a(), new b(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 B1(C10020aw4 c10020aw4, String str) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        AbstractC13042fc3.i(str, "$trimQuery");
        C20238rg6 c20238rg6 = new C20238rg6(c10020aw4.l.a(str));
        c10020aw4.Y = c20238rg6;
        return c20238rg6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 C1(final String str) {
        return AbstractC6459Nq2.X(new C12960fT4(new MT4(20, 0, false, 20, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Yv4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10020aw4.D1(this.a, str);
            }
        }, 2, null).a(), new c(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 D1(C10020aw4 c10020aw4, String str) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        AbstractC13042fc3.i(str, "$query");
        C21782u74 c21782u74 = new C21782u74(c10020aw4.m.a(str));
        c10020aw4.Z = c21782u74;
        return c21782u74;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WK I1() {
        return (WK) this.D.getValue();
    }

    private final InterfaceC13730gj3 M1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R1() {
        return ((Boolean) this.C0.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S1(C10020aw4 c10020aw4) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        return C8386Vt0.Y7() && c10020aw4.b.K5() && C8386Vt0.a8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U1(C10020aw4 c10020aw4) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        return !c10020aw4.A.isEmpty();
    }

    public static /* synthetic */ InterfaceC13730gj3 W1(C10020aw4 c10020aw4, C11458d25 c11458d25, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return c10020aw4.V1(c11458d25, z);
    }

    private final void X1() {
        this.i.c0();
    }

    private final void Y1() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(AbstractC6459Nq2.F(this.x), 200L), new f(null)), AbstractC9773aX7.a(this));
    }

    private final InterfaceC13730gj3 Z1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 a2() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.f(new h(null)), C12366eV1.b());
    }

    private final void c2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(null), 3, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(null), 3, null);
    }

    private final void d2() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(AbstractC6459Nq2.F(this.x), 200L), new k(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 e2(C10020aw4 c10020aw4) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        return AbstractC6459Nq2.s0(AbstractC6459Nq2.t(AbstractC6459Nq2.F(c10020aw4.x), new UA2() { // from class: ir.nasim.Xv4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(C10020aw4.f2((String) obj));
            }
        }), new l(null, c10020aw4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f2(String str) {
        AbstractC13042fc3.i(str, "it");
        return 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 g2(C10020aw4 c10020aw4) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        return AbstractC6459Nq2.s0(AbstractC6459Nq2.t(AbstractC6459Nq2.F(c10020aw4.x), new UA2() { // from class: ir.nasim.Wv4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(C10020aw4.h2((String) obj));
            }
        }), new m(null, c10020aw4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h2(String str) {
        AbstractC13042fc3.i(str, "it");
        return 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK k2(C10020aw4 c10020aw4) {
        AbstractC13042fc3.i(c10020aw4, "this$0");
        DB3 db3K = c10020aw4.c.K();
        AbstractC13042fc3.g(db3K, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3K;
    }

    public final long E1() {
        return this.J;
    }

    public final InterfaceC4557Fq2 F1() {
        return (InterfaceC4557Fq2) this.z0.getValue();
    }

    public final InterfaceC4557Fq2 G1() {
        return (InterfaceC4557Fq2) this.A0.getValue();
    }

    public final InterfaceC10258bL6 H1() {
        return AbstractC6459Nq2.c(this.x);
    }

    public final String J1() {
        return this.B0;
    }

    public final C14063hH6 K1() {
        return this.A;
    }

    public final InterfaceC10258bL6 L1() {
        return AbstractC6459Nq2.c(this.H);
    }

    public final InterfaceC10258bL6 N1() {
        return this.z;
    }

    public final String O1() {
        return this.G;
    }

    public final InterfaceC10258bL6 P1() {
        return AbstractC6459Nq2.c(this.w);
    }

    public final void Q1() {
        this.h.T0().l();
        X1();
        Z1();
        c2();
        d2();
        Y1();
        if (C8386Vt0.Lb()) {
            M1();
        }
    }

    public final InterfaceC9664aL6 T1() {
        return this.B;
    }

    public final InterfaceC13730gj3 V1(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(c11458d25, z, null), 3, null);
    }

    public final InterfaceC13730gj3 i2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new n(null), 3, null);
    }

    public final void j2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new o(null), 3, null);
    }

    public final InterfaceC13730gj3 l2(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new p(c11458d25, null), 2, null);
    }

    public final void m2(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        this.p.a(str, map);
    }

    public final void n2(String str, long j2, long j3, int i2, int i3) {
        AbstractC13042fc3.i(str, "peerType");
        this.p.a("top_peer", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_type", str), AbstractC4616Fw7.a("peer_id", Long.valueOf(j2)), AbstractC4616Fw7.a("score", Long.valueOf(j3)), AbstractC4616Fw7.a("index", Integer.valueOf(i2 + 1)), AbstractC4616Fw7.a("action_type", Integer.valueOf(i3))));
    }

    public final void o2(String str) {
        Object value;
        Object value2;
        if (str == null || str.length() == 0) {
            p2(new AbstractC17858ng6.a(false, false, false, 5, null));
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.w;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13723gi6.b((C13723gi6) value, null, null, null, null, null, 7, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.x;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, str));
    }

    public final void p2(AbstractC17858ng6 abstractC17858ng6) {
        Object value;
        AbstractC13042fc3.i(abstractC17858ng6, "state");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.w;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13723gi6.b((C13723gi6) value, abstractC17858ng6, null, null, null, null, 30, null)));
    }

    public final void r2(boolean z) {
        Object value;
        this.k.g("GLOBAL_GROUP_BANNER_KEY", z);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void s2(AbstractC3769Cg6 abstractC3769Cg6) {
        AbstractC13042fc3.i(abstractC3769Cg6, "id");
        if (this.A.contains(abstractC3769Cg6)) {
            this.A.remove(abstractC3769Cg6);
        } else {
            this.A.add(abstractC3769Cg6);
        }
    }

    public final void v1(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.c.U(c11458d25);
    }

    public final void w1(AbstractC3769Cg6 abstractC3769Cg6) {
        AbstractC13042fc3.i(abstractC3769Cg6, "id");
        if (C8386Vt0.u8()) {
            if (((Boolean) this.B.getValue()).booleanValue()) {
                z1();
            } else {
                s2(abstractC3769Cg6);
            }
        }
    }

    public final void x1() {
        this.c.P();
    }

    public final void y1(long j2) {
        this.c.Q(j2);
    }

    public final void z1() {
        this.A.clear();
    }
}
