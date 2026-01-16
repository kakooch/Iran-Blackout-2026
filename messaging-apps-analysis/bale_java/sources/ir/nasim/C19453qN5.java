package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.qN5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19453qN5 {
    private static final a c = new a(null);
    private final InterfaceC16847ly a;
    private final InterfaceC14123hO3 b;

    /* renamed from: ir.nasim.qN5$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qN5$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C19453qN5.this.a(0L, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.qN5$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C19453qN5.this.b(null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    public C19453qN5(InterfaceC16847ly interfaceC16847ly, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateway");
        AbstractC13042fc3.i(interfaceC14123hO3, "structInfoToLiveStreamDataMapper");
        this.a = interfaceC16847ly;
        this.b = interfaceC14123hO3;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(long r10, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof ir.nasim.C19453qN5.b
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.qN5$b r0 = (ir.nasim.C19453qN5.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.qN5$b r0 = new ir.nasim.qN5$b
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r10 = r6.a
            ir.nasim.qN5 r10 = (ir.nasim.C19453qN5) r10
            ir.nasim.AbstractC10685c16.b(r12)
            goto L6f
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.vx5 r12 = new ir.nasim.vx5
            ai.bale.proto.LahzeOuterClass$RequestGetLiveInfo$a r1 = ai.bale.proto.LahzeOuterClass$RequestGetLiveInfo.newBuilder()
            ai.bale.proto.LahzeOuterClass$RequestGetLiveInfo$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r11 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            ai.bale.proto.LahzeOuterClass$ResponseGetLiveInfo r11 = ai.bale.proto.LahzeOuterClass$ResponseGetLiveInfo.getDefaultInstance()
            java.lang.String r1 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r1)
            java.lang.String r1 = "/bale.lahze.v1.Lahze/GetLiveInfo"
            r12.<init>(r1, r10, r11)
            ir.nasim.ly r1 = r9.a
            r6.a = r9
            r6.d = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r12
            java.lang.Object r12 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r12 != r0) goto L6e
            return r0
        L6e:
            r10 = r9
        L6f:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r11 = r12 instanceof ir.nasim.Z06.a
            if (r11 == 0) goto L86
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r10 = r12.a()
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto La7
        L86:
            boolean r11 = r12 instanceof ir.nasim.Z06.b
            if (r11 == 0) goto La8
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            ir.nasim.hO3 r10 = r10.b
            ir.nasim.Z06$b r12 = (ir.nasim.Z06.b) r12
            com.google.protobuf.P r11 = r12.a()
            ai.bale.proto.LahzeOuterClass$ResponseGetLiveInfo r11 = (ai.bale.proto.LahzeOuterClass$ResponseGetLiveInfo) r11
            ai.bale.proto.LahzeStruct$LiveInfo r11 = r11.getInfo()
            java.lang.String r12 = "getInfo(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r12)
            java.lang.Object r10 = r10.a(r11)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        La7:
            return r10
        La8:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19453qN5.a(long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.Iterable r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C19453qN5.c
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.qN5$c r0 = (ir.nasim.C19453qN5.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.qN5$c r0 = new ir.nasim.qN5$c
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r10 = r6.a
            ir.nasim.qN5 r10 = (ir.nasim.C19453qN5) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L6f
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.LahzeOuterClass$RequestGetGroupsLives$a r1 = ai.bale.proto.LahzeOuterClass$RequestGetGroupsLives.newBuilder()
            ai.bale.proto.LahzeOuterClass$RequestGetGroupsLives$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r1 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r1)
            ai.bale.proto.LahzeOuterClass$ResponseGetGroupsLives r1 = ai.bale.proto.LahzeOuterClass$ResponseGetGroupsLives.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.lang.String r3 = "/bale.lahze.v1.Lahze/GetGroupsLives"
            r11.<init>(r3, r10, r1)
            ir.nasim.ly r1 = r9.a
            r6.a = r9
            r6.d = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L6e
            return r0
        L6e:
            r10 = r9
        L6f:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r0 = r11 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L86
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto Lcd
        L86:
            boolean r0 = r11 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto Lce
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r11 = r11.a()
            ai.bale.proto.LahzeOuterClass$ResponseGetGroupsLives r11 = (ai.bale.proto.LahzeOuterClass$ResponseGetGroupsLives) r11
            java.util.List r11 = r11.getInfoList()
            java.lang.String r0 = "getInfoList(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r11, r1)
            r0.<init>(r1)
            java.util.Iterator r11 = r11.iterator()
        Lae:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto Lc9
            java.lang.Object r1 = r11.next()
            ai.bale.proto.LahzeStruct$LiveInfo r1 = (ai.bale.proto.LahzeStruct$LiveInfo) r1
            ir.nasim.hO3 r2 = r10.b
            ir.nasim.AbstractC13042fc3.f(r1)
            java.lang.Object r1 = r2.a(r1)
            ir.nasim.FD3 r1 = (ir.nasim.FD3) r1
            r0.add(r1)
            goto Lae
        Lc9:
            java.lang.Object r10 = ir.nasim.C9475a16.b(r0)
        Lcd:
            return r10
        Lce:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19453qN5.b(java.lang.Iterable, ir.nasim.rm1):java.lang.Object");
    }
}
