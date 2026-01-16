package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateFolderEdited;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class CD7 implements InterfaceC14123hO3 {
    private final C8655Wx a;

    public CD7(C8655Wx c8655Wx) {
        AbstractC13042fc3.i(c8655Wx, "apiExPeerMapper");
        this.a = c8655Wx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BD7 a(MessagingOuterClass$UpdateFolderEdited messagingOuterClass$UpdateFolderEdited) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateFolderEdited, "input");
        int folderId = messagingOuterClass$UpdateFolderEdited.getFolderId();
        String value = messagingOuterClass$UpdateFolderEdited.getNewName().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        List<PeersStruct$ExPeer> addedPeersList = messagingOuterClass$UpdateFolderEdited.getAddedPeersList();
        AbstractC13042fc3.h(addedPeersList, "getAddedPeersList(...)");
        List<PeersStruct$ExPeer> list = addedPeersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list) {
            C8655Wx c8655Wx = this.a;
            AbstractC13042fc3.f(peersStruct$ExPeer);
            arrayList.add(c8655Wx.a(peersStruct$ExPeer));
        }
        List<PeersStruct$ExPeer> deletedPeersList = messagingOuterClass$UpdateFolderEdited.getDeletedPeersList();
        AbstractC13042fc3.h(deletedPeersList, "getDeletedPeersList(...)");
        List<PeersStruct$ExPeer> list2 = deletedPeersList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer2 : list2) {
            C8655Wx c8655Wx2 = this.a;
            AbstractC13042fc3.f(peersStruct$ExPeer2);
            arrayList2.add(c8655Wx2.a(peersStruct$ExPeer2));
        }
        return new BD7(folderId, value, arrayList, arrayList2);
    }
}
