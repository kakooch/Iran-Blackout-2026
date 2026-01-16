package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Co6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3841Co6 {
    private final C6559Oa2 a;

    public C3841Co6(C6559Oa2 c6559Oa2) {
        AbstractC13042fc3.i(c6559Oa2, "eventBus");
        this.a = c6559Oa2;
    }

    public final void a(C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        if (c11458d25.C()) {
            C6559Oa2 c6559Oa2 = this.a;
            C11458d25 c11458d25E = C11458d25.E(c11458d25.getPeerId());
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            c6559Oa2.f(new F25(c11458d25E, exPeerType));
            return;
        }
        C6559Oa2 c6559Oa22 = this.a;
        C11458d25 c11458d25Y = C11458d25.y(c11458d25.getPeerId());
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        c6559Oa22.f(new F25(c11458d25Y, exPeerType));
    }
}
