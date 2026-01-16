package ir.nasim;

import ai.bale.proto.SearchOuterClass$ResponseSearchPeer;
import ai.bale.proto.SearchStruct$PeerSearchResult;
import ir.nasim.AbstractC3769Cg6;
import ir.nasim.Z06;
import ir.nasim.features.mxp.entity.PuppetGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.yN5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24296yN5 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final C6287Mz a;
    private final C10299bQ2 b;
    private final C4471Fg6 c;
    private final OK7 d;
    private final C11941do4 e;
    private final I25 f;
    private final InterfaceC9173Yu3 g;

    /* renamed from: ir.nasim.yN5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yN5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ String h;
        final /* synthetic */ C24296yN5 i;

        /* renamed from: ir.nasim.yN5$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C24296yN5 c;
            final /* synthetic */ Z06 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24296yN5 c24296yN5, Z06 z06, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c24296yN5;
                this.d = z06;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    OK7 ok7 = this.c.d;
                    List<SearchStruct$PeerSearchResult> searchResultsList = ((SearchOuterClass$ResponseSearchPeer) ((Z06.b) this.d).a()).getSearchResultsList();
                    AbstractC13042fc3.h(searchResultsList, "getSearchResultsList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : searchResultsList) {
                        if (((SearchStruct$PeerSearchResult) obj2).getPeer().getType() == EnumC16311l35.PeerType_PRIVATE) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(AbstractC6392Nk0.d(((SearchStruct$PeerSearchResult) it.next()).getPeer().getId()));
                    }
                    C6517Nv5 c6517Nv5W0 = ok7.w0(arrayList2, false);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5W0, null, this, 1, null);
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
                return C9475a16.a(objD);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.yN5$b$b, reason: collision with other inner class name */
        static final class C1789b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C24296yN5 c;
            final /* synthetic */ Z06 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1789b(C24296yN5 c24296yN5, Z06 z06, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c24296yN5;
                this.d = z06;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1789b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C10299bQ2 c10299bQ2 = this.c.b;
                    List<SearchStruct$PeerSearchResult> searchResultsList = ((SearchOuterClass$ResponseSearchPeer) ((Z06.b) this.d).a()).getSearchResultsList();
                    AbstractC13042fc3.h(searchResultsList, "getSearchResultsList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : searchResultsList) {
                        if (((SearchStruct$PeerSearchResult) obj2).getPeer().getType() == EnumC16311l35.PeerType_GROUP) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(AbstractC6392Nk0.d(((SearchStruct$PeerSearchResult) it.next()).getPeer().getId()));
                    }
                    C6517Nv5 c6517Nv5B2 = c10299bQ2.B2(new ArrayList(arrayList2), false);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5B2, null, this, 1, null);
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
                return C9475a16.a(objD);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1789b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.yN5$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            int f;
            final /* synthetic */ HE0 g;
            final /* synthetic */ Z06 h;
            final /* synthetic */ C24296yN5 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(HE0 he0, Z06 z06, C24296yN5 c24296yN5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.g = he0;
                this.h = z06;
                this.i = c24296yN5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.g, this.h, this.i, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0070 -> B:14:0x0073). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r7.f
                    r2 = 1
                    if (r1 == 0) goto L27
                    if (r1 != r2) goto L1f
                    java.lang.Object r1 = r7.e
                    ir.nasim.HE0 r1 = (ir.nasim.HE0) r1
                    java.lang.Object r3 = r7.d
                    java.util.Iterator r3 = (java.util.Iterator) r3
                    java.lang.Object r4 = r7.c
                    java.util.Collection r4 = (java.util.Collection) r4
                    java.lang.Object r5 = r7.b
                    ir.nasim.yN5 r5 = (ir.nasim.C24296yN5) r5
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L73
                L1f:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L27:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.HE0 r8 = r7.g
                    ir.nasim.Z06 r1 = r7.h
                    ir.nasim.Z06$b r1 = (ir.nasim.Z06.b) r1
                    com.google.protobuf.P r1 = r1.a()
                    ai.bale.proto.SearchOuterClass$ResponseSearchPeer r1 = (ai.bale.proto.SearchOuterClass$ResponseSearchPeer) r1
                    java.util.List r1 = r1.getSearchResultsList()
                    java.lang.String r3 = "getSearchResultsList(...)"
                    ir.nasim.AbstractC13042fc3.h(r1, r3)
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    ir.nasim.yN5 r3 = r7.i
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r1 = r1.iterator()
                    r5 = r3
                    r3 = r1
                    r1 = r8
                L4f:
                    boolean r8 = r3.hasNext()
                    if (r8 == 0) goto L7b
                    java.lang.Object r8 = r3.next()
                    ai.bale.proto.SearchStruct$PeerSearchResult r8 = (ai.bale.proto.SearchStruct$PeerSearchResult) r8
                    ir.nasim.I25 r6 = ir.nasim.C24296yN5.e(r5)
                    ir.nasim.AbstractC13042fc3.f(r8)
                    r7.b = r5
                    r7.c = r4
                    r7.d = r3
                    r7.e = r1
                    r7.f = r2
                    java.lang.Object r8 = r6.a(r8, r7)
                    if (r8 != r0) goto L73
                    return r0
                L73:
                    ir.nasim.Cg6 r8 = (ir.nasim.AbstractC3769Cg6) r8
                    if (r8 == 0) goto L4f
                    r4.add(r8)
                    goto L4f
                L7b:
                    java.util.List r4 = (java.util.List) r4
                    ir.nasim.AbstractC24549yo1.c(r1, r4)
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24296yN5.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, C24296yN5 c24296yN5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = str;
            this.i = c24296yN5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.h, this.i, interfaceC20295rm1);
            bVar.g = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0182 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0199  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x01ca  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01e7 A[LOOP:0: B:42:0x01e1->B:44:0x01e7, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0201  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x01bd -> B:38:0x01c0). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 619
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24296yN5.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yN5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ String g;

        /* renamed from: ir.nasim.yN5$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ HE0 d;
            final /* synthetic */ C24296yN5 e;
            final /* synthetic */ String f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(HE0 he0, C24296yN5 c24296yN5, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = he0;
                this.e = c24296yN5;
                this.f = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                HE0 he0;
                Object objL;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    HE0 he02 = this.d;
                    C6517Nv5 c6517Nv5D = this.e.e.D(this.f);
                    this.b = he02;
                    this.c = 1;
                    Object objD = AbstractC6756Ov5.d(c6517Nv5D, null, this, 1, null);
                    if (objD == objE) {
                        return objE;
                    }
                    he0 = he02;
                    objL = objD;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    he0 = (HE0) this.b;
                    AbstractC10685c16.b(obj);
                    objL = ((C9475a16) obj).l();
                }
                List listM = AbstractC10360bX0.m();
                if (C9475a16.g(objL)) {
                    objL = listM;
                }
                ArrayList arrayList = new ArrayList();
                for (PuppetGroup puppetGroup : (Iterable) objL) {
                    AbstractC3769Cg6.j jVar = puppetGroup.getPuppets().isEmpty() ^ true ? new AbstractC3769Cg6.j(puppetGroup, null, null, null, null, null, 62, null) : null;
                    if (jVar != null) {
                        arrayList.add(jVar);
                    }
                }
                AbstractC24549yo1.c(he0, arrayList);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C24296yN5.this.new c(this.g, interfaceC20295rm1);
            cVar.e = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.e;
                C24296yN5 c24296yN5 = C24296yN5.this;
                String str = this.g;
                this.e = interfaceC20315ro1;
                this.b = c24296yN5;
                this.c = str;
                this.d = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(ie0, c24296yN5, str, null), 3, null);
                obj = ie0.t();
                if (obj == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24296yN5(C6287Mz c6287Mz, C10299bQ2 c10299bQ2, C4471Fg6 c4471Fg6, OK7 ok7, C11941do4 c11941do4, I25 i25) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(ok7, "userModule");
        AbstractC13042fc3.i(c11941do4, "mxpModule");
        AbstractC13042fc3.i(i25, "mapper");
        this.a = c6287Mz;
        this.b = c10299bQ2;
        this.c = c4471Fg6;
        this.d = ok7;
        this.e = c11941do4;
        this.f = i25;
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xN5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24296yN5.i(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WK h() {
        return (WK) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK i(C24296yN5 c24296yN5) {
        AbstractC13042fc3.i(c24296yN5, "this$0");
        DB3 db3H = c24296yN5.c.H();
        AbstractC13042fc3.g(db3H, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3H;
    }

    public final Object j(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(str, this, null), interfaceC20295rm1);
    }

    public final Object k(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(str, null), interfaceC20295rm1);
    }
}
