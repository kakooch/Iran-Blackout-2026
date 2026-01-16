package ir.nasim;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.SearchOuterClass$RequestUpdateSearchContentClick;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Locale;

/* renamed from: ir.nasim.i16, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14503i16 extends VW7 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final InterfaceC12521el1 b;
    private final InterfaceC12762f95 c;
    private final C6287Mz d;
    private final UG7 e;
    private final V25 f;
    private InterfaceC4557Fq2 g;
    private String h;
    private InterfaceC4557Fq2 i;

    /* renamed from: ir.nasim.i16$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.i16$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C14503i16.this.c1(0, this);
        }
    }

    /* renamed from: ir.nasim.i16$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String d;
        final /* synthetic */ InterfaceC14341hl1 e;
        final /* synthetic */ int f;
        final /* synthetic */ C14503i16 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC14341hl1 interfaceC14341hl1, int i, C14503i16 c14503i16, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = interfaceC14341hl1;
            this.f = i;
            this.g = c14503i16;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MessagingStruct$HistoryMessageIdentifier.a aVarA;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                XV4 xv4A = AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(5));
                XV4 xv4A2 = AbstractC4616Fw7.a("query_text", this.d);
                XV4 xv4A3 = AbstractC4616Fw7.a("event_type", "any");
                XV4 xv4A4 = AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, AbstractC6392Nk0.e(this.e.l().f()));
                XV4 xv4A5 = AbstractC4616Fw7.a("peer_id", AbstractC6392Nk0.d(this.e.l().e().getPeerId()));
                String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                C3343Am.i("flow_search_v2", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, AbstractC4616Fw7.a("peer_type", lowerCase), AbstractC4616Fw7.a("index", AbstractC6392Nk0.d(this.f))));
                aVarA = MessagingStruct$HistoryMessageIdentifier.newBuilder().D(this.e.l().f()).A(this.e.l().d());
                V25 v25 = this.g.f;
                C11458d25 c11458d25E = this.e.l().e();
                this.b = aVarA;
                this.c = 1;
                obj = v25.a(c11458d25E, this);
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
                aVarA = (MessagingStruct$HistoryMessageIdentifier.a) this.b;
                AbstractC10685c16.b(obj);
            }
            SearchOuterClass$RequestUpdateSearchContentClick searchOuterClass$RequestUpdateSearchContentClick = (SearchOuterClass$RequestUpdateSearchContentClick) SearchOuterClass$RequestUpdateSearchContentClick.newBuilder().A((MessagingStruct$HistoryMessageIdentifier) aVarA.C((PeersStruct$OutPeer) obj).a()).B(EnumC6132Mh6.SearchContentTab_CONTENT).a();
            C6287Mz c6287Mz = this.g.d;
            AbstractC13042fc3.f(searchOuterClass$RequestUpdateSearchContentClick);
            SearchOuterClass$RequestUpdateSearchContentClick defaultInstance = SearchOuterClass$RequestUpdateSearchContentClick.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/UpdateSearchContentClick", searchOuterClass$RequestUpdateSearchContentClick, defaultInstance);
            this.b = null;
            this.c = 2;
            if (InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.i16$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ InterfaceC7331Rg3 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC7331Rg3 interfaceC7331Rg3, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC7331Rg3;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14503i16.this.new d(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MessagingStruct$HistoryMessageIdentifier.a aVarA;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                XV4 xv4A = AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(5));
                XV4 xv4A2 = AbstractC4616Fw7.a("query_text", C14503i16.this.h);
                XV4 xv4A3 = AbstractC4616Fw7.a("event_type", "photo");
                XV4 xv4A4 = AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, AbstractC6392Nk0.e(this.e.i()));
                XV4 xv4A5 = AbstractC4616Fw7.a("peer_id", AbstractC6392Nk0.d(this.e.a()));
                String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                C3343Am.i("flow_search_v2", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, AbstractC4616Fw7.a("peer_type", lowerCase), AbstractC4616Fw7.a("index", AbstractC6392Nk0.d(this.f))));
                aVarA = MessagingStruct$HistoryMessageIdentifier.newBuilder().D(this.e.i()).A(this.e.h());
                V25 v25 = C14503i16.this.f;
                C11458d25 c11458d25 = new C11458d25(W25.b, this.e.a());
                this.b = aVarA;
                this.c = 1;
                obj = v25.a(c11458d25, this);
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
                aVarA = (MessagingStruct$HistoryMessageIdentifier.a) this.b;
                AbstractC10685c16.b(obj);
            }
            SearchOuterClass$RequestUpdateSearchContentClick searchOuterClass$RequestUpdateSearchContentClick = (SearchOuterClass$RequestUpdateSearchContentClick) SearchOuterClass$RequestUpdateSearchContentClick.newBuilder().A((MessagingStruct$HistoryMessageIdentifier) aVarA.C((PeersStruct$OutPeer) obj).a()).B(EnumC6132Mh6.SearchContentTab_PHOTO).a();
            C6287Mz c6287Mz = C14503i16.this.d;
            AbstractC13042fc3.f(searchOuterClass$RequestUpdateSearchContentClick);
            SearchOuterClass$RequestUpdateSearchContentClick defaultInstance = SearchOuterClass$RequestUpdateSearchContentClick.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/UpdateSearchContentClick", searchOuterClass$RequestUpdateSearchContentClick, defaultInstance);
            this.b = null;
            this.c = 2;
            if (InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C14503i16(InterfaceC12521el1 interfaceC12521el1, InterfaceC12762f95 interfaceC12762f95, C6287Mz c6287Mz, UG7 ug7, V25 v25) {
        AbstractC13042fc3.i(interfaceC12521el1, "contentResultPageFactory");
        AbstractC13042fc3.i(interfaceC12762f95, "photoPageFactory");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(v25, "peerToOutPeerMapper");
        this.b = interfaceC12521el1;
        this.c = interfaceC12762f95;
        this.d = c6287Mz;
        this.e = ug7;
        this.f = v25;
        this.h = "";
    }

    private final InterfaceC4557Fq2 W0(final String str) {
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(5, 0, true, 0, 0, 0, 58, null), null, new SA2() { // from class: ir.nasim.g16
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14503i16.X0(this.a, str);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.g = interfaceC4557Fq2A;
        if (interfaceC4557Fq2A != null) {
            return interfaceC4557Fq2A;
        }
        AbstractC13042fc3.y("contentPager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 X0(C14503i16 c14503i16, String str) {
        AbstractC13042fc3.i(c14503i16, "this$0");
        AbstractC13042fc3.i(str, "$query");
        return c14503i16.b.a(str);
    }

    private final InterfaceC4557Fq2 Y0(final String str) {
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(10, 0, true, 0, 0, 0, 58, null), null, new SA2() { // from class: ir.nasim.h16
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14503i16.Z0(this.a, str);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.i = interfaceC4557Fq2A;
        if (interfaceC4557Fq2A != null) {
            return interfaceC4557Fq2A;
        }
        AbstractC13042fc3.y("photoPager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 Z0(C14503i16 c14503i16, String str) {
        AbstractC13042fc3.i(c14503i16, "this$0");
        AbstractC13042fc3.i(str, "$query");
        return c14503i16.c.a(str);
    }

    public final void V0(String str) {
        AbstractC13042fc3.i(str, "query");
        this.h = str;
        W0(str);
        Y0(str);
    }

    public final InterfaceC4557Fq2 a1() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.g;
        if (interfaceC4557Fq2 == null) {
            return W0(this.h);
        }
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        AbstractC13042fc3.y("contentPager");
        return null;
    }

    public final InterfaceC4557Fq2 b1() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.i;
        if (interfaceC4557Fq2 == null) {
            return Y0(this.h);
        }
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        AbstractC13042fc3.y("photoPager");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c1(int r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C14503i16.b
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.i16$b r0 = (ir.nasim.C14503i16.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.i16$b r0 = new ir.nasim.i16$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            r9.l()
            goto L62
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.UG7 r9 = r7.e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            ir.nasim.zy r4 = new ir.nasim.zy
            r5 = 0
            r4.<init>(r8, r5)
            ir.nasim.zy[] r8 = new ir.nasim.C25238zy[]{r4}
            java.util.ArrayList r8 = ir.nasim.ZW0.g(r8)
            ir.nasim.Nv5 r8 = r9.s0(r2, r8)
            java.lang.String r9 = "loadRequiredPeers(...)"
            ir.nasim.AbstractC13042fc3.h(r8, r9)
            r0.c = r3
            r9 = 0
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r9, r0, r3, r9)
            if (r8 != r1) goto L62
            return r1
        L62:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14503i16.c1(int, ir.nasim.rm1):java.lang.Object");
    }

    public final void d1(InterfaceC14341hl1 interfaceC14341hl1, String str, int i) {
        AbstractC13042fc3.i(interfaceC14341hl1, "content");
        AbstractC13042fc3.i(str, "query");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(str, interfaceC14341hl1, i, this, null), 3, null);
    }

    public final void e1(InterfaceC7331Rg3 interfaceC7331Rg3, int i) {
        AbstractC13042fc3.i(interfaceC7331Rg3, "content");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(interfaceC7331Rg3, i, null), 3, null);
    }
}
