package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.VitrineOuterClass$Action;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.jaryan.discover.model.Action;

/* renamed from: ir.nasim.yv, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24617yv implements InterfaceC14123hO3 {
    private final InterfaceC14123hO3 a;

    public C24617yv(InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerConverter");
        this.a = interfaceC14123hO3;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Action a(VitrineOuterClass$Action vitrineOuterClass$Action) {
        AbstractC13042fc3.i(vitrineOuterClass$Action, "input");
        boolean z = vitrineOuterClass$Action.getType() == EnumC17790nZ7.ActionType_URL;
        String url = vitrineOuterClass$Action.getPayload().getUrl();
        InterfaceC14123hO3 interfaceC14123hO3 = this.a;
        PeersStruct$ExPeer exPeer = vitrineOuterClass$Action.getPayload().getExPeer();
        AbstractC13042fc3.h(exPeer, "getExPeer(...)");
        return new Action(z, url, (ExPeer) interfaceC14123hO3.a(exPeer));
    }
}
