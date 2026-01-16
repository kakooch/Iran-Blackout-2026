package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessagesUnPinned;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10205bF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C9611aF7 a(MessagingOuterClass$UpdateMessagesUnPinned messagingOuterClass$UpdateMessagesUnPinned) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessagesUnPinned, "input");
        if (!messagingOuterClass$UpdateMessagesUnPinned.hasPeer()) {
            return null;
        }
        PeersStruct$ExPeer peer = messagingOuterClass$UpdateMessagesUnPinned.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25L = C18732p92.l(peer);
        List<MessagingStruct$MessageId> messageIdsList = messagingOuterClass$UpdateMessagesUnPinned.getMessageIdsList();
        AbstractC13042fc3.h(messageIdsList, "getMessageIdsList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messageIdsList.iterator();
        while (it.hasNext()) {
            C3460Az c3460AzD0 = C18732p92.a.D0((MessagingStruct$MessageId) it.next());
            if (c3460AzD0 != null) {
                arrayList.add(c3460AzD0);
            }
        }
        return new C9611aF7(c11458d25L, arrayList, messagingOuterClass$UpdateMessagesUnPinned.getAll());
    }
}
