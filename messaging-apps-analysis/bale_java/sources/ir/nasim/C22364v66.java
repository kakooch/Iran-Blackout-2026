package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;

/* renamed from: ir.nasim.v66, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22364v66 implements InterfaceC15283jK {
    private final String a;
    private final PeersStruct$Peer b;
    private final long c;
    private final long d;
    private final long e;
    private final String f;

    public C22364v66(String str, PeersStruct$Peer peersStruct$Peer, long j, long j2, long j3, String str2) {
        AbstractC13042fc3.i(str, "sourceWalletId");
        AbstractC13042fc3.i(peersStruct$Peer, "peer");
        AbstractC13042fc3.i(str2, "regarding");
        this.a = str;
        this.b = peersStruct$Peer;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = str2;
    }

    public final long a() {
        return this.e;
    }

    public final long b() {
        return this.d;
    }

    public final PeersStruct$Peer c() {
        return this.b;
    }

    public final long d() {
        return this.c;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.a;
    }
}
