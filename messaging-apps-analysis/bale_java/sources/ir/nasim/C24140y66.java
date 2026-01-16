package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.y66, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24140y66 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final Q64 b;
    private final ExPeerType c;

    public C24140y66(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(q64, "reaction");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = c11458d25;
        this.b = q64;
        this.c = exPeerType;
    }

    public final ExPeerType a() {
        return this.c;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public final Q64 c() {
        return this.b;
    }
}
