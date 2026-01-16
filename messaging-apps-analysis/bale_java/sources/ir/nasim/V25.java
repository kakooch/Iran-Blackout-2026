package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class V25 implements InterfaceC20468s37 {
    private final InterfaceC11621dJ7 a;
    private final KM2 b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

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
            return V25.this.a(null, this);
        }
    }

    public V25(InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        this.a = interfaceC11621dJ7;
        this.b = km2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.C11458d25 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ir.nasim.V25.b
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.V25$b r0 = (ir.nasim.V25.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.V25$b r0 = new ir.nasim.V25$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            ir.nasim.AbstractC10685c16.b(r10)
            goto L5c
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            ir.nasim.AbstractC10685c16.b(r10)
            goto La9
        L39:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.W25 r10 = r9.s()
            int[] r2 = ir.nasim.V25.a.a
            int r10 = r10.ordinal()
            r10 = r2[r10]
            if (r10 == r5) goto L99
            if (r10 != r4) goto L82
            ir.nasim.KM2 r10 = r8.b
            int r9 = r9.getPeerId()
            long r5 = (long) r9
            r0.c = r4
            java.lang.Object r10 = r10.l(r5, r0)
            if (r10 != r1) goto L5c
            return r1
        L5c:
            ir.nasim.iL2 r10 = (ir.nasim.C14697iL2) r10
            if (r10 == 0) goto Lce
            ai.bale.proto.PeersStruct$OutPeer$a r9 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            ir.nasim.l35 r0 = ir.nasim.EnumC16311l35.PeerType_GROUP
            ai.bale.proto.PeersStruct$OutPeer$a r9 = r9.C(r0)
            int r0 = r10.p0()
            ai.bale.proto.PeersStruct$OutPeer$a r9 = r9.B(r0)
            long r0 = r10.getAccessHash()
            ai.bale.proto.PeersStruct$OutPeer$a r9 = r9.A(r0)
            com.google.protobuf.GeneratedMessageLite r9 = r9.a()
            r3 = r9
            ai.bale.proto.PeersStruct$OutPeer r3 = (ai.bale.proto.PeersStruct$OutPeer) r3
            goto Lce
        L82:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown peer: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        L99:
            ir.nasim.dJ7 r10 = r8.a
            int r9 = r9.getPeerId()
            long r6 = (long) r9
            r0.c = r5
            java.lang.Object r10 = r10.a(r6, r0)
            if (r10 != r1) goto La9
            return r1
        La9:
            ir.nasim.nI7 r10 = (ir.nasim.C17637nI7) r10
            if (r10 == 0) goto Lce
            ai.bale.proto.PeersStruct$OutPeer$a r9 = ai.bale.proto.PeersStruct$OutPeer.newBuilder()
            ir.nasim.l35 r0 = ir.nasim.EnumC16311l35.PeerType_PRIVATE
            ai.bale.proto.PeersStruct$OutPeer$a r9 = r9.C(r0)
            int r0 = r10.n0()
            ai.bale.proto.PeersStruct$OutPeer$a r9 = r9.B(r0)
            long r0 = r10.getAccessHash()
            ai.bale.proto.PeersStruct$OutPeer$a r9 = r9.A(r0)
            com.google.protobuf.GeneratedMessageLite r9 = r9.a()
            r3 = r9
            ai.bale.proto.PeersStruct$OutPeer r3 = (ai.bale.proto.PeersStruct$OutPeer) r3
        Lce:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V25.a(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }
}
