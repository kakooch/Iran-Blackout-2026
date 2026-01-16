package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateDialogsUnpinned;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.pD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18774pD7 implements InterfaceC14123hO3 {
    private final C8655Wx a;

    public C18774pD7(C8655Wx c8655Wx) {
        AbstractC13042fc3.i(c8655Wx, "apiExPeerMapper");
        this.a = c8655Wx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C18183oD7 a(MessagingOuterClass$UpdateDialogsUnpinned messagingOuterClass$UpdateDialogsUnpinned) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateDialogsUnpinned, "input");
        int folderId = messagingOuterClass$UpdateDialogsUnpinned.getFolderId();
        List<PeersStruct$ExPeer> unpinnedPeersList = messagingOuterClass$UpdateDialogsUnpinned.getUnpinnedPeersList();
        AbstractC13042fc3.h(unpinnedPeersList, "getUnpinnedPeersList(...)");
        List<PeersStruct$ExPeer> list = unpinnedPeersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list) {
            C8655Wx c8655Wx = this.a;
            AbstractC13042fc3.f(peersStruct$ExPeer);
            arrayList.add(c8655Wx.a(peersStruct$ExPeer));
        }
        return new C18183oD7(folderId, arrayList);
    }
}
