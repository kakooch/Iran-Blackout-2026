package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.s7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20500s7 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C6287Mz a;
    private final C14970in2 b;

    /* renamed from: ir.nasim.s7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.s7$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C20500s7.this.b(null, this);
        }
    }

    /* renamed from: ir.nasim.s7$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C20500s7.this.c(this);
        }
    }

    /* renamed from: ir.nasim.s7$e */
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
            return C20500s7.this.d(0, false, this);
        }
    }

    /* renamed from: ir.nasim.s7$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objE = C20500s7.this.e(0, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.s7$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C20500s7.this.f(0, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    public C20500s7(C6287Mz c6287Mz, C14970in2 c14970in2) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.a = c6287Mz;
        this.b = c14970in2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.core.modules.file.entity.FileReference r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof ir.nasim.C20500s7.b
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.s7$b r0 = (ir.nasim.C20500s7.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.s7$b r0 = new ir.nasim.s7$b
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r14)
            goto L8a
        L2c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L34:
            java.lang.Object r13 = r0.b
            ir.nasim.core.modules.file.entity.FileReference r13 = (ir.nasim.core.modules.file.entity.FileReference) r13
            java.lang.Object r13 = r0.a
            ir.nasim.s7 r13 = (ir.nasim.C20500s7) r13
            ir.nasim.AbstractC10685c16.b(r14)
            goto L77
        L40:
            ir.nasim.AbstractC10685c16.b(r14)
            r0.a = r12
            r0.b = r13
            r0.e = r4
            ir.nasim.IE0 r14 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r14.<init>(r2, r4)
            r14.w()
            ir.nasim.in2 r5 = a(r12)
            ir.nasim.s7$c r7 = new ir.nasim.s7$c
            r7.<init>(r14)
            r10 = 12
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r13
            ir.nasim.C14970in2.K(r5, r6, r7, r8, r9, r10, r11)
            java.lang.Object r14 = r14.t()
            java.lang.Object r13 = ir.nasim.AbstractC13660gc3.e()
            if (r14 != r13) goto L74
            ir.nasim.WA1.c(r0)
        L74:
            if (r14 != r1) goto L77
            return r1
        L77:
            java.lang.String r14 = (java.lang.String) r14
            r13 = 0
            if (r14 != 0) goto L7d
            return r13
        L7d:
            r0.a = r13
            r0.b = r13
            r0.e = r3
            java.lang.Object r14 = ir.nasim.QI2.b(r14, r0)
            if (r14 != r1) goto L8a
            return r1
        L8a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20500s7.b(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.C20500s7.d
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.s7$d r0 = (ir.nasim.C20500s7.d) r0
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
            ir.nasim.s7$d r0 = new ir.nasim.s7$d
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
            goto L6e
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r10)
            ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider r10 = ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider.getDefaultInstance()
            ai.bale.proto.AdvertisementOuterClass$RequestGetAdProvider$a r1 = ai.bale.proto.AdvertisementOuterClass$RequestGetAdProvider.newBuilder()
            ir.nasim.Uf r3 = ir.nasim.EnumC8025Uf.AdvertisementType_NATIVE
            r1.C(r3)
            ir.nasim.Hf r3 = ir.nasim.EnumC4938Hf.AdSpot_DIALOG
            r1.B(r3)
            ir.nasim.vx5 r3 = new ir.nasim.vx5
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            java.lang.String r4 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r4)
            ir.nasim.AbstractC13042fc3.f(r10)
            java.lang.String r4 = "/bale.advertisement.v1.Advertisement/GetAdProvider"
            r3.<init>(r4, r1, r10)
            ir.nasim.Mz r1 = r9.a
            r6.c = r2
            r4 = 0
            r10 = 0
            r7 = 6
            r8 = 0
            r2 = r3
            r3 = r4
            r5 = r10
            java.lang.Object r10 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r10 != r0) goto L6e
            return r0
        L6e:
            ir.nasim.Z06 r10 = (ir.nasim.Z06) r10
            boolean r0 = r10 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto Lcc
            ir.nasim.Z06$b r10 = (ir.nasim.Z06.b) r10
            com.google.protobuf.P r10 = r10.a()
            ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider r10 = (ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider) r10
            java.util.List r10 = r10.getContentList()
            java.lang.String r0 = "getContentList(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r10 = r10.iterator()
        L90:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto La9
            java.lang.Object r1 = r10.next()
            r2 = r1
            ai.bale.proto.AdvertisementStruct$AdContent r2 = (ai.bale.proto.AdvertisementStruct$AdContent) r2
            ai.bale.proto.AdvertisementStruct$AdContent$b r2 = r2.getTraitCase()
            ai.bale.proto.AdvertisementStruct$AdContent$b r3 = ai.bale.proto.AdvertisementStruct$AdContent.b.BALE_CUSTOM_AD
            if (r2 != r3) goto L90
            r0.add(r1)
            goto L90
        La9:
            java.util.ArrayList r10 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r0, r1)
            r10.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        Lb8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Ld4
            java.lang.Object r1 = r0.next()
            ai.bale.proto.AdvertisementStruct$AdContent r1 = (ai.bale.proto.AdvertisementStruct$AdContent) r1
            ai.bale.proto.AdvertisementStruct$BaleCustomAd r1 = r1.getBaleCustomAd()
            r10.add(r1)
            goto Lb8
        Lcc:
            boolean r10 = r10 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto Ld5
            java.util.List r10 = ir.nasim.ZW0.m()
        Ld4:
            return r10
        Ld5:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20500s7.c(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r10, boolean r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20500s7.d(int, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C20500s7.f
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.s7$f r0 = (ir.nasim.C20500s7.f) r0
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
            ir.nasim.s7$f r0 = new ir.nasim.s7$f
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
            goto L6f
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ai.bale.proto.AdvertisementOuterClass$RequestGetChannelIncomeReport$a r11 = ai.bale.proto.AdvertisementOuterClass$RequestGetChannelIncomeReport.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r1 = ai.bale.proto.PeersStruct$GroupOutPeer.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r10 = r1.B(r10)
            ai.bale.proto.AdvertisementOuterClass$RequestGetChannelIncomeReport$a r10 = r11.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            ai.bale.proto.AdvertisementOuterClass$RequestGetChannelIncomeReport r10 = (ai.bale.proto.AdvertisementOuterClass$RequestGetChannelIncomeReport) r10
            ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelIncomeReport r11 = ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelIncomeReport.getDefaultInstance()
            ir.nasim.vx5 r3 = new ir.nasim.vx5
            ir.nasim.AbstractC13042fc3.f(r10)
            ir.nasim.AbstractC13042fc3.f(r11)
            java.lang.String r1 = "/bale.advertisement.v1.Advertisement/GetChannelIncomeReport"
            r3.<init>(r1, r10, r11)
            ir.nasim.Mz r1 = r9.a
            r6.c = r2
            r10 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r3
            r3 = r10
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L6f
            return r0
        L6f:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L86
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L9c
        L86:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto L9d
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelIncomeReport r10 = (ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelIncomeReport) r10
            java.util.List r10 = r10.getIncomeReportsList()
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L9c:
            return r10
        L9d:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20500s7.e(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C20500s7.g
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.s7$g r0 = (ir.nasim.C20500s7.g) r0
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
            ir.nasim.s7$g r0 = new ir.nasim.s7$g
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
            goto L6f
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ai.bale.proto.AdvertisementOuterClass$RequestChangeChannelIncomeOwner$a r11 = ai.bale.proto.AdvertisementOuterClass$RequestChangeChannelIncomeOwner.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r1 = ai.bale.proto.PeersStruct$GroupOutPeer.newBuilder()
            ai.bale.proto.PeersStruct$GroupOutPeer$a r10 = r1.B(r10)
            ai.bale.proto.AdvertisementOuterClass$RequestChangeChannelIncomeOwner$a r10 = r11.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            ai.bale.proto.AdvertisementOuterClass$RequestChangeChannelIncomeOwner r10 = (ai.bale.proto.AdvertisementOuterClass$RequestChangeChannelIncomeOwner) r10
            ai.bale.proto.AdvertisementOuterClass$ResponseChangeChannelIncomeOwner r11 = ai.bale.proto.AdvertisementOuterClass$ResponseChangeChannelIncomeOwner.getDefaultInstance()
            ir.nasim.vx5 r3 = new ir.nasim.vx5
            ir.nasim.AbstractC13042fc3.f(r10)
            ir.nasim.AbstractC13042fc3.f(r11)
            java.lang.String r1 = "/bale.advertisement.v1.Advertisement/ChangeChannelIncomeOwner"
            r3.<init>(r1, r10, r11)
            ir.nasim.Mz r1 = r9.a
            r6.c = r2
            r10 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r3
            r3 = r10
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L6f
            return r0
        L6f:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L86
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L9a
        L86:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto L9b
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.AdvertisementOuterClass$ResponseChangeChannelIncomeOwner r10 = (ai.bale.proto.AdvertisementOuterClass$ResponseChangeChannelIncomeOwner) r10
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L9a:
            return r10
        L9b:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20500s7.f(int, ir.nasim.rm1):java.lang.Object");
    }

    /* renamed from: ir.nasim.s7$c */
    public static final class c implements InterfaceC8807Xk2 {
        final /* synthetic */ HE0 a;

        c(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AbstractC24549yo1.c(this.a, interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void g(DX1 dx1) {
            AbstractC24549yo1.c(this.a, null);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
        }
    }
}
