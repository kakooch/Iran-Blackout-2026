package ir.nasim;

import ai.bale.proto.AbacusOuterClass$UpdateMessageReactionsReadByMe;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* loaded from: classes5.dex */
public final class PE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public OE7 a(AbacusOuterClass$UpdateMessageReactionsReadByMe abacusOuterClass$UpdateMessageReactionsReadByMe) {
        AbstractC13042fc3.i(abacusOuterClass$UpdateMessageReactionsReadByMe, "input");
        if (abacusOuterClass$UpdateMessageReactionsReadByMe.hasExPeer()) {
            ExPeer exPeer = new ExPeer(ExPeerType.fromValue(abacusOuterClass$UpdateMessageReactionsReadByMe.getExPeer().getTypeValue()), abacusOuterClass$UpdateMessageReactionsReadByMe.getExPeer().getId());
            if (abacusOuterClass$UpdateMessageReactionsReadByMe.hasMessageId()) {
                return new OE7(exPeer, new MessageIdentifier(abacusOuterClass$UpdateMessageReactionsReadByMe.getMessageId().getRid(), abacusOuterClass$UpdateMessageReactionsReadByMe.getMessageId().getDate(), abacusOuterClass$UpdateMessageReactionsReadByMe.getMessageId().getSeq()));
            }
        }
        return null;
    }
}
