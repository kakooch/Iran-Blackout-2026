package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.y64, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24138y64 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final J44 b;
    private final ExPeerType c;
    private final List d;
    private final int e;
    private final long f;

    public C24138y64(C11458d25 c11458d25, J44 j44, ExPeerType exPeerType, List list, int i, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, "topMessage");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(list, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
        this.a = c11458d25;
        this.b = j44;
        this.c = exPeerType;
        this.d = list;
        this.e = i;
        this.f = j;
    }

    public final ExPeerType a() {
        return this.c;
    }

    public final int b() {
        return this.e;
    }

    public final long c() {
        return this.f;
    }

    public final C11458d25 d() {
        return this.a;
    }

    public final J44 e() {
        return this.b;
    }

    public final List f() {
        return this.d;
    }
}
