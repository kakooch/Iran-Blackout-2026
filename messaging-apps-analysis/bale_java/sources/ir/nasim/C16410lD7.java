package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateDialogsMarkedAsRead;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16410lD7 implements InterfaceC14123hO3 {
    private final C8655Wx a;

    public C16410lD7(C8655Wx c8655Wx) {
        AbstractC13042fc3.i(c8655Wx, "apiExPeerMapper");
        this.a = c8655Wx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C15819kD7 a(MessagingOuterClass$UpdateDialogsMarkedAsRead messagingOuterClass$UpdateDialogsMarkedAsRead) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateDialogsMarkedAsRead, "input");
        List<PeersStruct$ExPeer> peersList = messagingOuterClass$UpdateDialogsMarkedAsRead.getPeersList();
        AbstractC13042fc3.h(peersList, "getPeersList(...)");
        List<PeersStruct$ExPeer> list = peersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list) {
            C8655Wx c8655Wx = this.a;
            AbstractC13042fc3.f(peersStruct$ExPeer);
            arrayList.add(c8655Wx.a(peersStruct$ExPeer));
        }
        return new C15819kD7(arrayList);
    }
}
