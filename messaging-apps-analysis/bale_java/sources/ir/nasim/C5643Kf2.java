package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Kf2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5643Kf2 implements InterfaceC5409Jf2 {
    public static final a b = new a(null);
    private final InterfaceC16847ly a;

    /* renamed from: ir.nasim.Kf2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Kf2$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4707Gf2.values().length];
            try {
                iArr[EnumC4707Gf2.LinkStatus_APPROVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4707Gf2.LinkStatus_BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4707Gf2.LinkStatus_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC4707Gf2.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Kf2$c */
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
            Object objA = C5643Kf2.this.a(null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public C5643Kf2(InterfaceC16847ly interfaceC16847ly) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateWay");
        this.a = interfaceC16847ly;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC5409Jf2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.C5643Kf2.c
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.Kf2$c r0 = (ir.nasim.C5643Kf2.c) r0
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
            ir.nasim.Kf2$c r0 = new ir.nasim.Kf2$c
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r9 = 1
            if (r1 == 0) goto L33
            if (r1 != r9) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L67
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus$a r12 = ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus.newBuilder()
            ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus$a r11 = r12.A(r11)
            com.google.protobuf.GeneratedMessageLite r11 = r11.a()
            ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus r11 = (ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus) r11
            ir.nasim.vx5 r2 = new ir.nasim.vx5
            ir.nasim.AbstractC13042fc3.f(r11)
            ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus r12 = ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus.getDefaultInstance()
            java.lang.String r1 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r12, r1)
            java.lang.String r1 = "/bale.falake.v1.Falake/GetLinkStatus"
            r2.<init>(r1, r11, r12)
            ir.nasim.ly r1 = r10.a
            r6.c = r9
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            java.lang.Object r12 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r12 != r0) goto L67
            return r0
        L67:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r11 = r12 instanceof ir.nasim.Z06.a
            if (r11 == 0) goto L7e
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r11 = r12.a()
            ir.nasim.a16$a r12 = ir.nasim.C9475a16.b
            java.lang.Object r11 = ir.nasim.AbstractC10685c16.a(r11)
            java.lang.Object r11 = ir.nasim.C9475a16.b(r11)
            goto Lba
        L7e:
            boolean r11 = r12 instanceof ir.nasim.Z06.b
            if (r11 == 0) goto Lbb
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r12 = (ir.nasim.Z06.b) r12
            com.google.protobuf.P r11 = r12.a()
            ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus r11 = (ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus) r11
            ir.nasim.Gf2 r11 = r11.getLinkStatus()
            if (r11 != 0) goto L94
            r11 = -1
            goto L9c
        L94:
            int[] r12 = ir.nasim.C5643Kf2.b.a
            int r11 = r11.ordinal()
            r11 = r12[r11]
        L9c:
            if (r11 == r9) goto Lb4
            r12 = 2
            if (r11 == r12) goto Lb1
            r12 = 3
            if (r11 == r12) goto Lae
            r12 = 4
            if (r11 != r12) goto La8
            goto Lae
        La8:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        Lae:
            ir.nasim.Ff2 r11 = ir.nasim.EnumC4458Ff2.c
            goto Lb6
        Lb1:
            ir.nasim.Ff2 r11 = ir.nasim.EnumC4458Ff2.b
            goto Lb6
        Lb4:
            ir.nasim.Ff2 r11 = ir.nasim.EnumC4458Ff2.a
        Lb6:
            java.lang.Object r11 = ir.nasim.C9475a16.b(r11)
        Lba:
            return r11
        Lbb:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5643Kf2.a(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
