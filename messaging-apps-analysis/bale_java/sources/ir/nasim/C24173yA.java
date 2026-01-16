package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.VitrineOuterClass$Action;
import ai.bale.proto.VitrineOuterClass$PeerItem;
import ir.nasim.jaryan.discover.model.Action;
import ir.nasim.jaryan.discover.model.PeerItem;

/* renamed from: ir.nasim.yA, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24173yA implements InterfaceC14123hO3 {
    private final C24617yv a;
    private final C8941Xx b;

    public C24173yA(C24617yv c24617yv, C8941Xx c8941Xx) {
        AbstractC13042fc3.i(c24617yv, "actionConverter");
        AbstractC13042fc3.i(c8941Xx, "exPeerConverter");
        this.a = c24617yv;
        this.b = c8941Xx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeerItem a(VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem) {
        AbstractC13042fc3.i(vitrineOuterClass$PeerItem, "input");
        C24617yv c24617yv = this.a;
        VitrineOuterClass$Action action = vitrineOuterClass$PeerItem.getAction();
        AbstractC13042fc3.h(action, "getAction(...)");
        Action actionA = c24617yv.a(action);
        C8941Xx c8941Xx = this.b;
        PeersStruct$ExPeer exPeer = vitrineOuterClass$PeerItem.getExPeer();
        AbstractC13042fc3.h(exPeer, "getExPeer(...)");
        return new PeerItem(actionA, c8941Xx.a(exPeer));
    }
}
