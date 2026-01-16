package ir.nasim;

import ai.bale.proto.MagazineStruct$SimilarMessageContainer;
import ai.bale.proto.MagazineStruct$SimilarMessageParentId;

/* renamed from: ir.nasim.vC6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22422vC6 implements InterfaceC14123hO3 {
    private final ir.nasim.jaryan.feed.model.db.a a;

    public C22422vC6(ir.nasim.jaryan.feed.model.db.a aVar) {
        AbstractC13042fc3.i(aVar, "feedEntityMapper");
        this.a = aVar;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C22114uh2 a(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "input");
        C22114uh2 c22114uh2A = this.a.a(AbstractC4616Fw7.a(((MagazineStruct$SimilarMessageContainer) xv4.e()).getMessage(), xv4.f()));
        MagazineStruct$SimilarMessageParentId parentId = ((MagazineStruct$SimilarMessageContainer) xv4.e()).getParentId();
        c22114uh2A.t(parentId != null ? new CW4(parentId.getExPeer().getId(), parentId.getMessageId().getRid(), parentId.getMessageId().getDate(), Long.valueOf(((MagazineStruct$SimilarMessageContainer) xv4.e()).getMessage().getGroupedId().getValue())) : null);
        return c22114uh2A;
    }
}
