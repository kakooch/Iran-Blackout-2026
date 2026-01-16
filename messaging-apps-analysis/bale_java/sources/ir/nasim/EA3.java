package ir.nasim;

import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.SearchOuterClass$RequestSearchMessagesMore;
import ai.bale.proto.SearchOuterClass$ResponseSearchMessages;
import ai.bale.proto.SearchStruct$SearchCondition;
import ai.bale.proto.SearchStruct$SearchDateCondition;
import ai.bale.proto.SearchStruct$SearchHasLinkCondition;
import ai.bale.proto.SearchStruct$SearchPeerCondition;
import ai.bale.proto.SearchStruct$SearchPieceText;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C16970mA3;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public final class EA3 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final C11458d25 a;
    private final C6287Mz b;
    private final AbstractC13778go1 c;
    private final V25 d;
    private final C10299bQ2 e;
    private final OK7 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        EA3 a(C11458d25 c11458d25);
    }

    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return EA3.this.i(null, this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ BytesValue d;
        final /* synthetic */ EA3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(BytesValue bytesValue, EA3 ea3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bytesValue;
            this.e = ea3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objB2;
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = SearchOuterClass$RequestSearchMessagesMore.newBuilder().B(this.d).A(AbstractC10360bX0.p(EnumC16902m35.UpdateOptimization_STRIP_ENTITIES, EnumC16902m35.UpdateOptimization_STRIP_COUNTERS, EnumC16902m35.UpdateOptimization_COMPACT_USERS)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                SearchOuterClass$ResponseSearchMessages defaultInstance = SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/SearchMessageMore", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.b;
                this.c = 1;
                objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    searchOuterClass$ResponseSearchMessages = (SearchOuterClass$ResponseSearchMessages) this.b;
                    AbstractC10685c16.b(obj);
                    BytesValue loadMoreState = searchOuterClass$ResponseSearchMessages.getLoadMoreState();
                    AbstractC13042fc3.h(loadMoreState, "getLoadMoreState(...)");
                    objB2 = C9475a16.b(new C16970mA3.a((List) obj, loadMoreState));
                    return C9475a16.a(objB2);
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            EA3 ea3 = this.e;
            if (!C9475a16.j(objB)) {
                objB2 = C9475a16.b(objB);
                return C9475a16.a(objB2);
            }
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages2 = (SearchOuterClass$ResponseSearchMessages) objB;
            C11458d25 c11458d25 = ea3.a;
            AbstractC13042fc3.f(searchOuterClass$ResponseSearchMessages2);
            this.b = searchOuterClass$ResponseSearchMessages2;
            this.c = 2;
            Object objL = ea3.l(c11458d25, searchOuterClass$ResponseSearchMessages2, this);
            if (objL == objE) {
                return objE;
            }
            searchOuterClass$ResponseSearchMessages = searchOuterClass$ResponseSearchMessages2;
            obj = objL;
            BytesValue loadMoreState2 = searchOuterClass$ResponseSearchMessages.getLoadMoreState();
            AbstractC13042fc3.h(loadMoreState2, "getLoadMoreState(...)");
            objB2 = C9475a16.b(new C16970mA3.a((List) obj, loadMoreState2));
            return C9475a16.a(objB2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return EA3.this.j(null, null, false, this);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        final /* synthetic */ String i;
        final /* synthetic */ Long j;
        final /* synthetic */ boolean k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Long l, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = str;
            this.j = l;
            this.k = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return EA3.this.new f(this.i, this.j, this.k, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0121  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EA3.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ SearchOuterClass$ResponseSearchMessages f;
        final /* synthetic */ EA3 g;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            int g;
            final /* synthetic */ HE0 h;
            final /* synthetic */ SearchOuterClass$ResponseSearchMessages i;
            final /* synthetic */ EA3 j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(HE0 he0, SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, EA3 ea3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.h = he0;
                this.i = searchOuterClass$ResponseSearchMessages;
                this.j = ea3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.h, this.i, this.j, interfaceC20295rm1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:51:0x01e3, code lost:
            
                r10 = r6;
                r6 = 2;
             */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0154  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0159  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0180  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x01b9  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x01be  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x01e9  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x01ef  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x01b0 -> B:34:0x01b3). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r25) {
                /*
                    Method dump skipped, instructions count: 503
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EA3.g.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, EA3 ea3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = searchOuterClass$ResponseSearchMessages;
            this.g = ea3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.f, this.g, interfaceC20295rm1);
            gVar.e = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.e;
                SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages = this.f;
                EA3 ea3 = this.g;
                this.e = interfaceC20315ro1;
                this.b = searchOuterClass$ResponseSearchMessages;
                this.c = ea3;
                this.d = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(ie0, searchOuterClass$ResponseSearchMessages, ea3, null), 3, null);
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public EA3(C11458d25 c11458d25, C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, V25 v25, C10299bQ2 c10299bQ2, OK7 ok7) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(v25, "peerToOutPeerMapper");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(ok7, "userModule");
        this.a = c11458d25;
        this.b = c6287Mz;
        this.c = abstractC13778go1;
        this.d = v25;
        this.e = c10299bQ2;
        this.f = ok7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set h(PeersStruct$OutPeer peersStruct$OutPeer, String str, Long l, boolean z) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (peersStruct$OutPeer != null) {
            GeneratedMessageLite generatedMessageLiteA = SearchStruct$SearchCondition.newBuilder().E((SearchStruct$SearchPeerCondition) SearchStruct$SearchPeerCondition.newBuilder().A(peersStruct$OutPeer).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            linkedHashSet.add(generatedMessageLiteA);
        }
        if (str != null) {
            if ((AbstractC20762sZ6.n0(str) ^ true ? str : null) != null) {
                GeneratedMessageLite generatedMessageLiteA2 = SearchStruct$SearchCondition.newBuilder().G((SearchStruct$SearchPieceText) SearchStruct$SearchPieceText.newBuilder().A(str).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                linkedHashSet.add(generatedMessageLiteA2);
            }
        }
        if (l != null) {
            GeneratedMessageLite generatedMessageLiteA3 = SearchStruct$SearchCondition.newBuilder().B((SearchStruct$SearchDateCondition) SearchStruct$SearchDateCondition.newBuilder().A(l.longValue()).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA3, "build(...)");
            linkedHashSet.add(generatedMessageLiteA3);
        }
        if (z) {
            GeneratedMessageLite generatedMessageLiteA4 = SearchStruct$SearchCondition.newBuilder().D((SearchStruct$SearchHasLinkCondition) SearchStruct$SearchHasLinkCondition.newBuilder().A(true).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA4, "build(...)");
            linkedHashSet.add(generatedMessageLiteA4);
        }
        return linkedHashSet;
    }

    public static /* synthetic */ Object k(EA3 ea3, String str, Long l, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return ea3.j(str, l, z, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(C11458d25 c11458d25, SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new g(searchOuterClass$ResponseSearchMessages, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(com.google.protobuf.BytesValue r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.EA3.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.EA3$c r0 = (ir.nasim.EA3.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.EA3$c r0 = new ir.nasim.EA3$c
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
            ir.nasim.go1 r7 = r5.c
            ir.nasim.EA3$d r2 = new ir.nasim.EA3$d
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            ir.nasim.mA3$a r7 = new ir.nasim.mA3$a
            java.util.List r0 = ir.nasim.ZW0.m()
            com.google.protobuf.BytesValue r1 = com.google.protobuf.BytesValue.getDefaultInstance()
            java.lang.String r2 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            r7.<init>(r0, r1)
            boolean r0 = ir.nasim.C9475a16.g(r6)
            if (r0 == 0) goto L64
            r6 = r7
        L64:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EA3.i(com.google.protobuf.BytesValue, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r11, java.lang.Long r12, boolean r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.EA3.e
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.EA3$e r0 = (ir.nasim.EA3.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.EA3$e r0 = new ir.nasim.EA3$e
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.c
            ir.nasim.EA3$f r2 = new ir.nasim.EA3$f
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            ir.nasim.mA3$a r12 = new ir.nasim.mA3$a
            java.util.List r13 = ir.nasim.ZW0.m()
            com.google.protobuf.BytesValue r14 = com.google.protobuf.BytesValue.getDefaultInstance()
            java.lang.String r0 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r14, r0)
            r12.<init>(r13, r14)
            boolean r13 = ir.nasim.C9475a16.g(r11)
            if (r13 == 0) goto L69
            r11 = r12
        L69:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EA3.j(java.lang.String, java.lang.Long, boolean, ir.nasim.rm1):java.lang.Object");
    }
}
