package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessageDelete;
import ai.bale.proto.PeersStruct$Peer;
import java.util.List;

/* loaded from: classes5.dex */
public final class GE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public GE7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerStructToPeerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FE7 a(MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessageDelete, "input");
        if (!messagingOuterClass$UpdateMessageDelete.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessageDelete.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25A = u25.a(peer);
        List<Long> ridsList = messagingOuterClass$UpdateMessageDelete.getRidsList();
        AbstractC13042fc3.h(ridsList, "getRidsList(...)");
        List<Long> datesList = messagingOuterClass$UpdateMessageDelete.getDates().getDatesList();
        AbstractC13042fc3.h(datesList, "getDatesList(...)");
        return new FE7(c11458d25A, ridsList, datesList);
    }
}
