package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingOuterClass$UpdateMessage;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageAttributes;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class HE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public HE7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CE7 a(MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessage, "input");
        int senderUid = messagingOuterClass$UpdateMessage.getSenderUid();
        long rid = messagingOuterClass$UpdateMessage.getRid();
        long date = messagingOuterClass$UpdateMessage.getDate();
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessage.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25A = u25.a(peer);
        C18732p92 c18732p92 = C18732p92.a;
        MessagingStruct$Message message = messagingOuterClass$UpdateMessage.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        AbstractC24063xz abstractC24063xzA0 = c18732p92.A0(message);
        C21762u54 c21762u54 = new C21762u54();
        MessagingStruct$MessageAttributes attributes = messagingOuterClass$UpdateMessage.getAttributes();
        AbstractC13042fc3.h(attributes, "getAttributes(...)");
        C21088t54 c21088t54A = c21762u54.a(attributes);
        C16975mB c16975mBU0 = c18732p92.U0(messagingOuterClass$UpdateMessage.getQuotedMessage());
        C3460Az c3460AzD0 = c18732p92.D0(messagingOuterClass$UpdateMessage.getPreviousMessageId());
        CollectionsStruct$Int64Value groupedId = messagingOuterClass$UpdateMessage.getGroupedId();
        return new CE7(senderUid, c11458d25A, rid, date, abstractC24063xzA0, c21088t54A, c16975mBU0, c3460AzD0, groupedId != null ? Long.valueOf(groupedId.getValue()) : null, messagingOuterClass$UpdateMessage.getIsSilent(), messagingOuterClass$UpdateMessage.getHasComment(), new C7880To7(messagingOuterClass$UpdateMessage.getThreadId().getRid(), messagingOuterClass$UpdateMessage.getThreadId().getDate(), null, 4, null));
    }
}
