package ir.nasim;

import ai.bale.proto.MessagingStruct$Folder;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Is2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5292Is2 implements InterfaceC14123hO3 {
    private final C8655Wx a;

    public C5292Is2(C8655Wx c8655Wx) {
        AbstractC13042fc3.i(c8655Wx, "apiExPeerMapper");
        this.a = c8655Wx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C7429Rr2 a(MessagingStruct$Folder messagingStruct$Folder) {
        AbstractC13042fc3.i(messagingStruct$Folder, "input");
        int id = messagingStruct$Folder.getId();
        String name = messagingStruct$Folder.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        List<PeersStruct$ExPeer> peersList = messagingStruct$Folder.getPeersList();
        AbstractC13042fc3.h(peersList, "getPeersList(...)");
        List<PeersStruct$ExPeer> list = peersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list) {
            C8655Wx c8655Wx = this.a;
            AbstractC13042fc3.f(peersStruct$ExPeer);
            arrayList.add(c8655Wx.a(peersStruct$ExPeer));
        }
        return new C7429Rr2(id, name, arrayList);
    }
}
