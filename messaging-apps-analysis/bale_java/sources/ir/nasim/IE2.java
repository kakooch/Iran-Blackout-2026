package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class IE2 {
    private final C4627Fy0 a;

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = IE2.this.a(false, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public IE2(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = c4627Fy0;
    }

    public static /* synthetic */ Object b(IE2 ie2, boolean z, Long l, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            l = null;
        }
        return ie2.a(z, l, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(boolean r9, java.lang.Long r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ir.nasim.IE2.a
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.IE2$a r0 = (ir.nasim.IE2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.IE2$a r0 = new ir.nasim.IE2$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r9 = r11.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Fy0 r11 = r8.a
            r0.c = r3
            java.lang.Object r9 = r11.a0(r9, r10, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            boolean r10 = ir.nasim.C9475a16.j(r9)
            if (r10 == 0) goto Lbe
            r10 = r9
            ai.bale.proto.MeetOuterClass$ResponseGenerateCallLink r10 = (ai.bale.proto.MeetOuterClass$ResponseGenerateCallLink) r10
            ir.nasim.bM2 r0 = ir.nasim.C10263bM2.a
            ai.bale.proto.MeetStruct$GroupCall r11 = r10.getGroupCall()
            long r1 = r11.getId()
            ai.bale.proto.MeetStruct$GroupCall r11 = r10.getGroupCall()
            java.util.List r11 = r11.getInCallParticipantsList()
            java.lang.String r3 = "getInCallParticipantsList(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r3)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = ir.nasim.ZW0.x(r11, r4)
            r3.<init>(r4)
            java.util.Iterator r11 = r11.iterator()
        L76:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L8e
            java.lang.Object r4 = r11.next()
            ai.bale.proto.PeersStruct$OutExPeer r4 = (ai.bale.proto.PeersStruct$OutExPeer) r4
            int r4 = r4.getId()
            java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
            r3.add(r4)
            goto L76
        L8e:
            ai.bale.proto.MeetStruct$GroupCall r11 = r10.getGroupCall()
            int r4 = r11.getInitiatorUserId()
            ai.bale.proto.MeetStruct$GroupCall r11 = r10.getGroupCall()
            java.lang.String r5 = r11.getTitle()
            ai.bale.proto.MeetStruct$GroupCall r11 = r10.getGroupCall()
            java.lang.String r6 = r11.getLink()
            java.lang.String r11 = "getLink(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r11)
            ai.bale.proto.MeetStruct$GroupCall r10 = r10.getGroupCall()
            ai.bale.proto.CollectionsStruct$Int64Value r10 = r10.getCreateDate()
            long r10 = r10.getValue()
            java.lang.Long r7 = ir.nasim.AbstractC6392Nk0.e(r10)
            r0.h(r1, r3, r4, r5, r6, r7)
        Lbe:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IE2.a(boolean, java.lang.Long, ir.nasim.rm1):java.lang.Object");
    }
}
