package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.o25, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18074o25 extends AbstractC18385oa2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C11458d25 a;
    private ExPeerType b;

    /* renamed from: ir.nasim.o25$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C18074o25(C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = c11458d25;
        this.b = exPeerType;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "peer_chat_opened";
    }

    public final ExPeerType b() {
        return this.b;
    }

    public final C11458d25 c() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String toString() {
        return "peer_chat_opened {" + this.a.D() + "}";
    }
}
