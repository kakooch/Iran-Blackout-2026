package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class F25 extends AbstractC18385oa2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C11458d25 a;
    private final ExPeerType b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public F25(C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = c11458d25;
        this.b = exPeerType;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "peer_info_opened";
    }

    public final ExPeerType b() {
        return this.b;
    }

    public final C11458d25 c() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String toString() {
        return "peer_info_opened {" + this.a.D() + "}";
    }
}
