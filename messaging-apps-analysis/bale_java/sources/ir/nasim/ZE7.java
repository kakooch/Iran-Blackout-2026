package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessages;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.PeersStruct$ExPeer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class ZE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public YE7 a(MessagingOuterClass$UpdateMessages messagingOuterClass$UpdateMessages) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessages, "input");
        if (!messagingOuterClass$UpdateMessages.hasPeer()) {
            return null;
        }
        PeersStruct$ExPeer peer = messagingOuterClass$UpdateMessages.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25L = C18732p92.l(peer);
        List<MessagingStruct$MessageContainer> messageContainersList = messagingOuterClass$UpdateMessages.getMessageContainersList();
        AbstractC13042fc3.h(messageContainersList, "getMessageContainersList(...)");
        List<MessagingStruct$MessageContainer> list = messageContainersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$MessageContainer messagingStruct$MessageContainer : list) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(messagingStruct$MessageContainer);
            arrayList.add(c18732p92.C0(messagingStruct$MessageContainer));
        }
        return new YE7(c11458d25L, arrayList);
    }
}
