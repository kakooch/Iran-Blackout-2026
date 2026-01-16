package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdatePinnedDialogsChanged;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16428lF7 implements InterfaceC14123hO3 {
    private final C8655Wx a;

    public C16428lF7(C8655Wx c8655Wx) {
        AbstractC13042fc3.i(c8655Wx, "apiExPeerMapper");
        this.a = c8655Wx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C15837kF7 a(MessagingOuterClass$UpdatePinnedDialogsChanged messagingOuterClass$UpdatePinnedDialogsChanged) {
        AbstractC13042fc3.i(messagingOuterClass$UpdatePinnedDialogsChanged, "input");
        int folderId = messagingOuterClass$UpdatePinnedDialogsChanged.getFolderId();
        List<PeersStruct$ExPeer> pinnedPeersList = messagingOuterClass$UpdatePinnedDialogsChanged.getPinnedPeersList();
        AbstractC13042fc3.h(pinnedPeersList, "getPinnedPeersList(...)");
        List<PeersStruct$ExPeer> list = pinnedPeersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list) {
            C8655Wx c8655Wx = this.a;
            AbstractC13042fc3.f(peersStruct$ExPeer);
            arrayList.add(c8655Wx.a(peersStruct$ExPeer));
        }
        return new C15837kF7(folderId, arrayList);
    }
}
