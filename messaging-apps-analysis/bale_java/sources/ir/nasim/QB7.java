package ir.nasim;

import ai.bale.proto.MessagingStruct$UnreadPeer;
import ai.bale.proto.PeersStruct$ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.database.dailogLists.DialogPeerUnreadStateEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes5.dex */
public final class QB7 {
    private final InterfaceC14123hO3 a;

    public QB7(InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC14123hO3, "structExPeerTypeToExPeer");
        this.a = interfaceC14123hO3;
    }

    public final List a(Collection collection) {
        AbstractC13042fc3.i(collection, "peers");
        Collection<MessagingStruct$UnreadPeer> collection2 = collection;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection2, 10));
        for (MessagingStruct$UnreadPeer messagingStruct$UnreadPeer : collection2) {
            InterfaceC14123hO3 interfaceC14123hO3 = this.a;
            PeersStruct$ExPeer peer = messagingStruct$UnreadPeer.getPeer();
            AbstractC13042fc3.h(peer, "getPeer(...)");
            arrayList.add(new DialogPeerUnreadStateEntity(new C11458d25((ExPeer) interfaceC14123hO3.a(peer)).u(), messagingStruct$UnreadPeer.getIsMuted()));
        }
        return arrayList;
    }
}
