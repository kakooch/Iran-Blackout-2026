package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class ST1 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C4627Fy0 a;
    private final A08 b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

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
            return ST1.this.a(null, this);
        }
    }

    public ST1(C4627Fy0 c4627Fy0, A08 a08) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(a08, "voiceCallModule");
        this.a = c4627Fy0;
        this.b = a08;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ai.bale.proto.MeetStruct$Call r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.ST1.b
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.ST1$b r0 = (ir.nasim.ST1.b) r0
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
            ir.nasim.ST1$b r0 = new ir.nasim.ST1$b
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
            ir.nasim.ST1 r10 = (ir.nasim.ST1) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L80
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.nz0 r11 = ir.nasim.C18039nz0.a
            ir.nasim.bL6 r11 = r11.d()
            java.lang.Object r11 = r11.getValue()
            ir.nasim.mz0 r11 = (ir.nasim.C17448mz0) r11
            long r3 = r11.c()
            long r7 = r10.getId()
            int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            r1 = 0
            if (r11 != 0) goto L86
            ir.nasim.Fy0 r11 = r9.a
            ir.nasim.K04 r3 = r10.getDiscardReason()
            if (r3 == 0) goto L60
            ir.nasim.dv0 r3 = ir.nasim.TT1.a(r3)
            goto L61
        L60:
            r3 = 0
        L61:
            int r4 = r10.getDuration()
            if (r4 <= 0) goto L6b
            int r1 = r10.getDuration()
        L6b:
            r4 = r1
            long r7 = r10.getId()
            r6.a = r9
            r6.d = r2
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r7
            java.lang.Object r10 = r1.S0(r2, r3, r4, r6)
            if (r10 != r0) goto L7f
            return r0
        L7f:
            r10 = r9
        L80:
            ir.nasim.A08 r10 = r10.b
            r10.S()
            goto La7
        L86:
            long r10 = r10.getId()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "update call discarded ignored, because no call with id: "
            r0.append(r2)
            r0.append(r10)
            java.lang.String r10 = " is in progress."
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            java.lang.Object[] r11 = new java.lang.Object[r1]
            java.lang.String r0 = "DiscardCallUseCase"
            ir.nasim.C19406qI3.a(r0, r10, r11)
        La7:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ST1.a(ai.bale.proto.MeetStruct$Call, ir.nasim.rm1):java.lang.Object");
    }
}
