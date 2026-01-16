package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessagePinned;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* loaded from: classes5.dex */
public final class LE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public KE7 a(MessagingOuterClass$UpdateMessagePinned messagingOuterClass$UpdateMessagePinned) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessagePinned, "input");
        C25247zz c25247zzC0 = null;
        if (!messagingOuterClass$UpdateMessagePinned.hasPeer()) {
            return null;
        }
        ExPeer exPeer = new ExPeer(ExPeerType.fromValue(messagingOuterClass$UpdateMessagePinned.getPeer().getTypeValue()), messagingOuterClass$UpdateMessagePinned.getPeer().getId());
        if (messagingOuterClass$UpdateMessagePinned.hasPinnedMessage()) {
            C18732p92 c18732p92 = C18732p92.a;
            MessagingStruct$MessageContainer pinnedMessage = messagingOuterClass$UpdateMessagePinned.getPinnedMessage();
            AbstractC13042fc3.h(pinnedMessage, "getPinnedMessage(...)");
            c25247zzC0 = c18732p92.C0(pinnedMessage);
        }
        return new KE7(exPeer, c25247zzC0);
    }
}
