package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Ts7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7916Ts7 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final C6287Mz a;

    /* renamed from: ir.nasim.Ts7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ts7$b */
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
            Object objA = C7916Ts7.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Ts7$c */
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
            Object objB = C7916Ts7.this.b(null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    public C7916Ts7(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.C7916Ts7.b
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.Ts7$b r0 = (ir.nasim.C7916Ts7.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Ts7$b r0 = new ir.nasim.Ts7$b
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r10)
            goto L64
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.vx5 r10 = new ir.nasim.vx5
            ai.bale.proto.TopPeerOuterClass$RequestGetTopPeer$a r1 = ai.bale.proto.TopPeerOuterClass$RequestGetTopPeer.newBuilder()
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            ai.bale.proto.TopPeerOuterClass$ResponseGetTopPeer r3 = ai.bale.proto.TopPeerOuterClass$ResponseGetTopPeer.getDefaultInstance()
            java.lang.String r4 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.String r4 = "/bale.top_peer.v1.TopPeer/GetTopPeer"
            r10.<init>(r4, r1, r3)
            ir.nasim.Mz r1 = r9.a
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r10
            java.lang.Object r10 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r10 != r0) goto L64
            return r0
        L64:
            ir.nasim.Z06 r10 = (ir.nasim.Z06) r10
            boolean r0 = r10 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L7b
            ir.nasim.Z06$a r10 = (ir.nasim.Z06.a) r10
            ir.nasim.core.network.RpcException r10 = r10.a()
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L91
        L7b:
            boolean r0 = r10 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L92
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r10 = (ir.nasim.Z06.b) r10
            com.google.protobuf.P r10 = r10.a()
            ai.bale.proto.TopPeerOuterClass$ResponseGetTopPeer r10 = (ai.bale.proto.TopPeerOuterClass$ResponseGetTopPeer) r10
            java.util.List r10 = r10.getTopPeersList()
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L91:
            return r10
        L92:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7916Ts7.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.C11458d25 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C7916Ts7.c
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.Ts7$c r0 = (ir.nasim.C7916Ts7.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Ts7$c r0 = new ir.nasim.Ts7$c
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r11)
            goto L7a
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.TopPeerOuterClass$RequestRemovePeer$a r1 = ai.bale.proto.TopPeerOuterClass$RequestRemovePeer.newBuilder()
            ai.bale.proto.PeersStruct$OutPeer$a r3 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            int r10 = r10.getPeerId()
            ai.bale.proto.PeersStruct$OutPeer$a r10 = r3.B(r10)
            ir.nasim.l35 r3 = ir.nasim.EnumC16311l35.PeerType_PRIVATE
            ai.bale.proto.PeersStruct$OutPeer$a r10 = r10.C(r3)
            ai.bale.proto.TopPeerOuterClass$RequestRemovePeer$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r1 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r1)
            ai.bale.proto.TopPeerOuterClass$ResponseRemovePeer r1 = ai.bale.proto.TopPeerOuterClass$ResponseRemovePeer.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.lang.String r3 = "/bale.top_peer.v1.TopPeer/RemovePeer"
            r11.<init>(r3, r10, r1)
            ir.nasim.Mz r1 = r9.a
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L7a
            return r0
        L7a:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L91
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lab
        L91:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto Lac
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.TopPeerOuterClass$ResponseRemovePeer r10 = (ai.bale.proto.TopPeerOuterClass$ResponseRemovePeer) r10
            boolean r10 = r10.getIsRemoved()
            java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        Lab:
            return r10
        Lac:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7916Ts7.b(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }
}
