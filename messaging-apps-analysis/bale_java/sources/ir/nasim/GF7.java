package ir.nasim;

/* loaded from: classes5.dex */
public final class GF7 implements InterfaceC14123hO3 {
    private final NM4 a;

    public GF7(NM4 nm4) {
        AbstractC13042fc3.i(nm4, "peerMapper");
        this.a = nm4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.EF7 a(ai.bale.proto.Turing$UpdateTranscriptReady r8) {
        /*
            r7 = this;
            java.lang.String r0 = "input"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            boolean r0 = r8.hasOutPeer()
            r1 = 0
            if (r0 == 0) goto L74
            ir.nasim.NM4 r0 = r7.a
            ai.bale.proto.PeersStruct$OutExPeer r2 = r8.getOutPeer()
            java.lang.String r3 = "getOutPeer(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r3)
            ir.nasim.core.modules.profile.entity.ExPeer r0 = r0.a(r2)
            ir.nasim.d25 r2 = new ir.nasim.d25
            r2.<init>(r0)
            boolean r0 = r8.hasMessageId()
            if (r0 == 0) goto L31
            ir.nasim.p92 r0 = ir.nasim.C18732p92.a
            ai.bale.proto.MessagingStruct$MessageId r3 = r8.getMessageId()
            ir.nasim.Az r0 = r0.D0(r3)
            goto L32
        L31:
            r0 = r1
        L32:
            if (r0 != 0) goto L35
            return r1
        L35:
            ir.nasim.EF7 r3 = new ir.nasim.EF7
            boolean r4 = r8.hasDownloadSource()
            if (r4 == 0) goto L61
            ir.nasim.QY1 r4 = new ir.nasim.QY1
            ai.bale.proto.TuringStruct$DownloadSource r5 = r8.getDownloadSource()
            boolean r5 = r5.hasDocumentMessage()
            if (r5 == 0) goto L5c
            ir.nasim.p92 r5 = ir.nasim.C18732p92.a
            ai.bale.proto.TuringStruct$DownloadSource r6 = r8.getDownloadSource()
            ai.bale.proto.MessagingStruct$DocumentMessage r6 = r6.getDocumentMessage()
            ir.nasim.Lx r5 = r5.d0(r6)
            boolean r6 = r5 instanceof ir.nasim.C6035Lx
            if (r6 == 0) goto L5c
            goto L5d
        L5c:
            r5 = r1
        L5d:
            r4.<init>(r5)
            goto L62
        L61:
            r4 = r1
        L62:
            boolean r5 = r8.hasError()
            if (r5 == 0) goto L70
            ai.bale.proto.TuringStruct$TuringError r8 = r8.getError()
            java.lang.String r1 = r8.getMessage()
        L70:
            r3.<init>(r2, r0, r4, r1)
            return r3
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GF7.a(ai.bale.proto.Turing$UpdateTranscriptReady):ir.nasim.EF7");
    }
}
