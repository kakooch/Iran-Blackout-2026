package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class YE4 {
    private final C6559Oa2 a;

    public YE4(C6559Oa2 c6559Oa2) {
        AbstractC13042fc3.i(c6559Oa2, "eventBus");
        this.a = c6559Oa2;
    }

    public final void a(int i, ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        if (exPeerType == ExPeerType.PRIVATE) {
            C6559Oa2 c6559Oa2 = this.a;
            C11458d25 c11458d25E = C11458d25.E(i);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            c6559Oa2.f(new F25(c11458d25E, exPeerType));
            return;
        }
        C6559Oa2 c6559Oa22 = this.a;
        C11458d25 c11458d25Y = C11458d25.y(i);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        c6559Oa22.f(new F25(c11458d25Y, exPeerType));
    }
}
