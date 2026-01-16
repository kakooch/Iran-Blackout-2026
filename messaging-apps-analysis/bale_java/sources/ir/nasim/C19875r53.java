package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.r53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19875r53 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final J44 b;
    private final List c;
    private final ExPeerType d;
    private final int e;
    private final long f;

    public C19875r53(C11458d25 c11458d25, J44 j44, List list, ExPeerType exPeerType, int i, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(list, "mentions");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = c11458d25;
        this.b = j44;
        this.c = list;
        this.d = exPeerType;
        this.e = i;
        this.f = j;
    }

    public final ExPeerType a() {
        return this.d;
    }

    public final List b() {
        return this.c;
    }

    public final J44 c() {
        return this.b;
    }

    public final int d() {
        return this.e;
    }

    public final long e() {
        return this.f;
    }

    public final C11458d25 f() {
        return this.a;
    }
}
