package ir.nasim;

import ai.bale.proto.MagazineOuterClass$RequestLoadCategories;
import ai.bale.proto.MagazineOuterClass$ResponseLoadCategories;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.Z06;

/* renamed from: ir.nasim.Og2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6613Og2 {
    private static final a b = new a(null);
    public static final int c = C6287Mz.e;
    private final C6287Mz a;

    /* renamed from: ir.nasim.Og2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Og2$b */
    public static final class b {
        public static final a b;
        public static final b c = new b("DOCUMENT_MESSAGE", 0, "DOCUMENT_MESSAGE");
        public static final b d = new b("TEXT_MESSAGE", 1, "TEXT_MESSAGE");
        private static final /* synthetic */ b[] e;
        private static final /* synthetic */ F92 f;
        private final String a;

        /* renamed from: ir.nasim.Og2$b$a */
        public static final class a {
            private a() {
            }

            public final b a(String str) {
                AbstractC13042fc3.i(str, "valueCase");
                b bVar = b.c;
                if (AbstractC13042fc3.d(str, bVar.a)) {
                    return bVar;
                }
                b bVar2 = b.d;
                if (AbstractC13042fc3.d(str, bVar2.a)) {
                    return bVar2;
                }
                return null;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static {
            b[] bVarArrA = a();
            e = bVarArrA;
            f = G92.a(bVarArrA);
            b = new a(null);
        }

        private b(String str, int i, String str2) {
            this.a = str2;
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{c, d};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.Og2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C6613Og2.this.c(null, 0L, 0, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.Og2$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objE = C6613Og2.this.e(null, 0L, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.Og2$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6613Og2.this.g(0, 0L, 0L, this);
        }
    }

    /* renamed from: ir.nasim.Og2$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6613Og2.this.h(null, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Og2$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6613Og2.this.i(0, 0L, 0L, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.Og2$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6613Og2.this.j(null, 0, 0L, 0L, this);
        }
    }

    public C6613Og2(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    public static /* synthetic */ Object b(C6613Og2 c6613Og2, long j, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 16500;
        }
        return c6613Og2.a(j, interfaceC20295rm1);
    }

    public static /* synthetic */ Object d(C6613Og2 c6613Og2, byte[] bArr, long j, int i, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 3000;
        }
        return c6613Og2.c(bArr, j, i, interfaceC20295rm1);
    }

    public static /* synthetic */ Object f(C6613Og2 c6613Og2, byte[] bArr, long j, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 3000;
        }
        return c6613Og2.e(bArr, j, interfaceC20295rm1);
    }

    private final void k(Z06 z06, long j, String str) {
        C19406qI3.a("FeedApiService", "result fetched in " + (System.currentTimeMillis() - j) + " for " + str + ", result was " + (z06 instanceof Z06.b ? "success" : "fail"), new Object[0]);
    }

    public final Object a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = MagazineOuterClass$RequestLoadCategories.newBuilder().a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MagazineOuterClass$ResponseLoadCategories defaultInstance = MagazineOuterClass$ResponseLoadCategories.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return AbstractC6547Nz.c(this.a, new C22871vx5("/bale.magazine.v1.Magazine/LoadCategories", generatedMessageLiteA, defaultInstance), j, 16500, 2, 3, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(byte[] r15, long r16, int r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6613Og2.c(byte[], long, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(byte[] r17, long r18, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6613Og2.e(byte[], long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(int r17, long r18, long r20, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r22
            boolean r2 = r1 instanceof ir.nasim.C6613Og2.e
            if (r2 == 0) goto L18
            r2 = r1
            ir.nasim.Og2$e r2 = (ir.nasim.C6613Og2.e) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f = r3
        L16:
            r10 = r2
            goto L1e
        L18:
            ir.nasim.Og2$e r2 = new ir.nasim.Og2$e
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r10.d
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r10.f
            r4 = 1
            if (r3 == 0) goto L42
            if (r3 != r4) goto L3a
            long r2 = r10.c
            java.lang.Object r4 = r10.b
            ir.nasim.vx5 r4 = (ir.nasim.C22871vx5) r4
            java.lang.Object r5 = r10.a
            ir.nasim.Og2 r5 = (ir.nasim.C6613Og2) r5
            ir.nasim.AbstractC10685c16.b(r1)
            goto Lba
        L3a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L42:
            ir.nasim.AbstractC10685c16.b(r1)
            ai.bale.proto.MagazineOuterClass$RequestGetMessageUpvoters$a r1 = ai.bale.proto.MagazineOuterClass$RequestGetMessageUpvoters.newBuilder()
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = ai.bale.proto.MessagingStruct$HistoryMessageIdentifier.newBuilder()
            ai.bale.proto.PeersStruct$OutPeer$a r5 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            r6 = r17
            ai.bale.proto.PeersStruct$OutPeer$a r5 = r5.B(r6)
            ir.nasim.l35 r6 = ir.nasim.EnumC16311l35.PeerType_GROUP
            ai.bale.proto.PeersStruct$OutPeer$a r5 = r5.C(r6)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            ai.bale.proto.PeersStruct$OutPeer r5 = (ai.bale.proto.PeersStruct$OutPeer) r5
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.C(r5)
            r5 = r18
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.D(r5)
            r5 = r20
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.A(r5)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            java.lang.String r5 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier r3 = (ai.bale.proto.MessagingStruct$HistoryMessageIdentifier) r3
            ir.nasim.vx5 r13 = new ir.nasim.vx5
            ai.bale.proto.MagazineOuterClass$RequestGetMessageUpvoters$a r1 = r1.B(r3)
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            ir.nasim.AbstractC13042fc3.h(r1, r5)
            ai.bale.proto.MagazineOuterClass$ResponseGetMessageUpvoters r3 = ai.bale.proto.MagazineOuterClass$ResponseGetMessageUpvoters.getDefaultInstance()
            java.lang.String r5 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            java.lang.String r5 = "/bale.magazine.v1.Magazine/GetMessageUpvoters"
            r13.<init>(r5, r1, r3)
            long r14 = java.lang.System.currentTimeMillis()
            ir.nasim.Mz r3 = r0.a
            r10.a = r0
            r10.b = r13
            r10.c = r14
            r10.f = r4
            r5 = 0
            r7 = 16500(0x4074, float:2.3121E-41)
            r8 = 2
            r9 = 3
            r11 = 2
            r12 = 0
            r4 = r13
            java.lang.Object r1 = ir.nasim.AbstractC6547Nz.d(r3, r4, r5, r7, r8, r9, r10, r11, r12)
            if (r1 != r2) goto Lb7
            return r2
        Lb7:
            r5 = r0
            r4 = r13
            r2 = r14
        Lba:
            r6 = r1
            ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
            java.lang.String r4 = r4.a()
            r5.k(r6, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6613Og2.g(int, long, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.C11458d25 r17, long r18, ir.nasim.C8755Xe4 r20, ir.nasim.InterfaceC20295rm1 r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r21
            boolean r2 = r1 instanceof ir.nasim.C6613Og2.f
            if (r2 == 0) goto L18
            r2 = r1
            ir.nasim.Og2$f r2 = (ir.nasim.C6613Og2.f) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f = r3
        L16:
            r10 = r2
            goto L1e
        L18:
            ir.nasim.Og2$f r2 = new ir.nasim.Og2$f
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r10.d
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r10.f
            r4 = 1
            if (r3 == 0) goto L42
            if (r3 != r4) goto L3a
            long r2 = r10.c
            java.lang.Object r4 = r10.b
            ir.nasim.vx5 r4 = (ir.nasim.C22871vx5) r4
            java.lang.Object r5 = r10.a
            ir.nasim.Og2 r5 = (ir.nasim.C6613Og2) r5
            ir.nasim.AbstractC10685c16.b(r1)
            goto Lcc
        L3a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L42:
            ir.nasim.AbstractC10685c16.b(r1)
            ai.bale.proto.PeersStruct$OutPeer$a r1 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            int r3 = r17.getPeerId()
            ai.bale.proto.PeersStruct$OutPeer$a r1 = r1.B(r3)
            ir.nasim.l35 r3 = ir.nasim.EnumC16311l35.PeerType_GROUP
            ai.bale.proto.PeersStruct$OutPeer$a r1 = r1.C(r3)
            r5 = r18
            ai.bale.proto.PeersStruct$OutPeer$a r1 = r1.A(r5)
            ai.bale.proto.MessagingStruct$MessageId$a r3 = ai.bale.proto.MessagingStruct$MessageId.newBuilder()
            long r5 = r20.h()
            ai.bale.proto.MessagingStruct$MessageId$a r3 = r3.A(r5)
            long r5 = r20.i()
            ai.bale.proto.MessagingStruct$MessageId$a r3 = r3.B(r5)
            r5 = 0
            ai.bale.proto.MessagingStruct$MessageId$a r3 = r3.C(r5)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            java.util.List r3 = ir.nasim.ZW0.e(r3)
            ir.nasim.vx5 r13 = new ir.nasim.vx5
            ai.bale.proto.AbacusOuterClass$RequestLoadReactions$a r5 = ai.bale.proto.AbacusOuterClass$RequestLoadReactions.newBuilder()
            ai.bale.proto.AbacusOuterClass$RequestLoadReactions$a r1 = r5.C(r1)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            ai.bale.proto.AbacusOuterClass$RequestLoadReactions$a r1 = r1.A(r3)
            r3 = 0
            ai.bale.proto.AbacusOuterClass$RequestLoadReactions$a r1 = r1.B(r3)
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            ai.bale.proto.AbacusOuterClass$ResponseLoadReactions r3 = ai.bale.proto.AbacusOuterClass$ResponseLoadReactions.getDefaultInstance()
            java.lang.String r5 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            java.lang.String r5 = "/bale.abacus.v1.Abacus/LoadReactions"
            r13.<init>(r5, r1, r3)
            long r14 = java.lang.System.currentTimeMillis()
            ir.nasim.Mz r3 = r0.a
            r10.a = r0
            r10.b = r13
            r10.c = r14
            r10.f = r4
            r5 = 0
            r7 = 16500(0x4074, float:2.3121E-41)
            r8 = 2
            r9 = 3
            r11 = 2
            r12 = 0
            r4 = r13
            java.lang.Object r1 = ir.nasim.AbstractC6547Nz.d(r3, r4, r5, r7, r8, r9, r10, r11, r12)
            if (r1 != r2) goto Lc9
            return r2
        Lc9:
            r5 = r0
            r4 = r13
            r2 = r14
        Lcc:
            r6 = r1
            ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
            java.lang.String r4 = r4.a()
            r5.k(r6, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6613Og2.h(ir.nasim.d25, long, ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(int r15, long r16, long r18, byte[] r20, long r21, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            r14 = this;
            r0 = r14
            r1 = r23
            boolean r2 = r1 instanceof ir.nasim.C6613Og2.g
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.Og2$g r2 = (ir.nasim.C6613Og2.g) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f = r3
        L15:
            r10 = r2
            goto L1d
        L17:
            ir.nasim.Og2$g r2 = new ir.nasim.Og2$g
            r2.<init>(r1)
            goto L15
        L1d:
            java.lang.Object r1 = r10.d
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r10.f
            r4 = 1
            if (r3 == 0) goto L41
            if (r3 != r4) goto L39
            long r2 = r10.c
            java.lang.Object r4 = r10.b
            ir.nasim.vx5 r4 = (ir.nasim.C22871vx5) r4
            java.lang.Object r5 = r10.a
            ir.nasim.Og2 r5 = (ir.nasim.C6613Og2) r5
            ir.nasim.AbstractC10685c16.b(r1)
            goto Lcc
        L39:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L41:
            ir.nasim.AbstractC10685c16.b(r1)
            ai.bale.proto.MagazineOuterClass$RequestGetSimilarPosts$a r1 = ai.bale.proto.MagazineOuterClass$RequestGetSimilarPosts.newBuilder()
            if (r20 == 0) goto L5f
            com.google.protobuf.BytesValue$b r3 = com.google.protobuf.BytesValue.newBuilder()
            com.google.protobuf.g r5 = com.google.protobuf.AbstractC2383g.F(r20)
            com.google.protobuf.BytesValue$b r3 = r3.A(r5)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            com.google.protobuf.BytesValue r3 = (com.google.protobuf.BytesValue) r3
            r1.A(r3)
        L5f:
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = ai.bale.proto.MessagingStruct$HistoryMessageIdentifier.newBuilder()
            ai.bale.proto.PeersStruct$OutPeer$a r5 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            r6 = r15
            ai.bale.proto.PeersStruct$OutPeer$a r5 = r5.B(r15)
            ir.nasim.l35 r6 = ir.nasim.EnumC16311l35.PeerType_GROUP
            ai.bale.proto.PeersStruct$OutPeer$a r5 = r5.C(r6)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            ai.bale.proto.PeersStruct$OutPeer r5 = (ai.bale.proto.PeersStruct$OutPeer) r5
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.C(r5)
            r5 = r16
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.D(r5)
            r5 = r18
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.A(r5)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            java.lang.String r5 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier r3 = (ai.bale.proto.MessagingStruct$HistoryMessageIdentifier) r3
            r1.B(r3)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            ir.nasim.AbstractC13042fc3.h(r1, r5)
            ai.bale.proto.MagazineOuterClass$ResponseGetSimilarPosts r3 = ai.bale.proto.MagazineOuterClass$ResponseGetSimilarPosts.getDefaultInstance()
            java.lang.String r5 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            java.lang.String r5 = "/bale.magazine.v1.Magazine/GetSimilarPosts"
            r11.<init>(r5, r1, r3)
            long r12 = java.lang.System.currentTimeMillis()
            ir.nasim.Mz r3 = r0.a
            r10.a = r0
            r10.b = r11
            r10.c = r12
            r10.f = r4
            r7 = 16500(0x4074, float:2.3121E-41)
            r8 = 2
            r9 = 3
            r4 = r11
            r5 = r21
            java.lang.Object r1 = ir.nasim.AbstractC6547Nz.c(r3, r4, r5, r7, r8, r9, r10)
            if (r1 != r2) goto Lc9
            return r2
        Lc9:
            r5 = r0
            r4 = r11
            r2 = r12
        Lcc:
            r6 = r1
            ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
            java.lang.String r4 = r4.a()
            r5.k(r6, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6613Og2.i(int, long, long, byte[], long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(byte[] r17, int r18, long r19, long r21, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r23
            boolean r2 = r1 instanceof ir.nasim.C6613Og2.h
            if (r2 == 0) goto L18
            r2 = r1
            ir.nasim.Og2$h r2 = (ir.nasim.C6613Og2.h) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f = r3
        L16:
            r10 = r2
            goto L1e
        L18:
            ir.nasim.Og2$h r2 = new ir.nasim.Og2$h
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r10.d
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r10.f
            r4 = 1
            if (r3 == 0) goto L42
            if (r3 != r4) goto L3a
            long r2 = r10.c
            java.lang.Object r4 = r10.b
            ir.nasim.vx5 r4 = (ir.nasim.C22871vx5) r4
            java.lang.Object r5 = r10.a
            ir.nasim.Og2 r5 = (ir.nasim.C6613Og2) r5
            ir.nasim.AbstractC10685c16.b(r1)
            goto Ld1
        L3a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L42:
            ir.nasim.AbstractC10685c16.b(r1)
            ai.bale.proto.MagazineOuterClass$RequestGetMessageUpvoters$a r1 = ai.bale.proto.MagazineOuterClass$RequestGetMessageUpvoters.newBuilder()
            if (r17 == 0) goto L60
            com.google.protobuf.BytesValue$b r3 = com.google.protobuf.BytesValue.newBuilder()
            com.google.protobuf.g r5 = com.google.protobuf.AbstractC2383g.F(r17)
            com.google.protobuf.BytesValue$b r3 = r3.A(r5)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            com.google.protobuf.BytesValue r3 = (com.google.protobuf.BytesValue) r3
            r1.A(r3)
        L60:
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = ai.bale.proto.MessagingStruct$HistoryMessageIdentifier.newBuilder()
            ai.bale.proto.PeersStruct$OutPeer$a r5 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            r6 = r18
            ai.bale.proto.PeersStruct$OutPeer$a r5 = r5.B(r6)
            ir.nasim.l35 r6 = ir.nasim.EnumC16311l35.PeerType_GROUP
            ai.bale.proto.PeersStruct$OutPeer$a r5 = r5.C(r6)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            ai.bale.proto.PeersStruct$OutPeer r5 = (ai.bale.proto.PeersStruct$OutPeer) r5
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.C(r5)
            r5 = r19
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.D(r5)
            r5 = r21
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier$a r3 = r3.A(r5)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            java.lang.String r5 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            ai.bale.proto.MessagingStruct$HistoryMessageIdentifier r3 = (ai.bale.proto.MessagingStruct$HistoryMessageIdentifier) r3
            ir.nasim.vx5 r13 = new ir.nasim.vx5
            ai.bale.proto.MagazineOuterClass$RequestGetMessageUpvoters$a r1 = r1.B(r3)
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            ir.nasim.AbstractC13042fc3.h(r1, r5)
            ai.bale.proto.MagazineOuterClass$ResponseGetMessageUpvoters r3 = ai.bale.proto.MagazineOuterClass$ResponseGetMessageUpvoters.getDefaultInstance()
            java.lang.String r5 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            java.lang.String r5 = "/bale.magazine.v1.Magazine/GetMessageUpvoters"
            r13.<init>(r5, r1, r3)
            long r14 = java.lang.System.currentTimeMillis()
            ir.nasim.Mz r3 = r0.a
            r10.a = r0
            r10.b = r13
            r10.c = r14
            r10.f = r4
            r5 = 0
            r7 = 16500(0x4074, float:2.3121E-41)
            r8 = 2
            r9 = 3
            r11 = 2
            r12 = 0
            r4 = r13
            java.lang.Object r1 = ir.nasim.AbstractC6547Nz.d(r3, r4, r5, r7, r8, r9, r10, r11, r12)
            if (r1 != r2) goto Lce
            return r2
        Lce:
            r5 = r0
            r4 = r13
            r2 = r14
        Ld1:
            r6 = r1
            ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
            java.lang.String r4 = r4.a()
            r5.k(r6, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6613Og2.j(byte[], int, long, long, ir.nasim.rm1):java.lang.Object");
    }
}
