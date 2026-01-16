package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessageContentChanged;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class EE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public EE7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerStructToPeerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DE7 a(MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged) {
        AbstractC24063xz abstractC24063xzA0;
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessageContentChanged, "input");
        if (!messagingOuterClass$UpdateMessageContentChanged.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessageContentChanged.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25A = u25.a(peer);
        long rid = messagingOuterClass$UpdateMessageContentChanged.getRid();
        if (messagingOuterClass$UpdateMessageContentChanged.hasMessage()) {
            C18732p92 c18732p92 = C18732p92.a;
            MessagingStruct$Message message = messagingOuterClass$UpdateMessageContentChanged.getMessage();
            AbstractC13042fc3.h(message, "getMessage(...)");
            abstractC24063xzA0 = c18732p92.A0(message);
        } else {
            abstractC24063xzA0 = null;
        }
        return new DE7(c11458d25A, rid, abstractC24063xzA0, messagingOuterClass$UpdateMessageContentChanged.hasDate() ? Long.valueOf(messagingOuterClass$UpdateMessageContentChanged.getDate().getValue()) : null, messagingOuterClass$UpdateMessageContentChanged.getUpdaterUserId().getValue());
    }
}
