package ir.nasim;

import ai.bale.proto.AbacusOuterClass$UpdateMessageNewReaction;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* loaded from: classes5.dex */
public final class JE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IE7 a(AbacusOuterClass$UpdateMessageNewReaction abacusOuterClass$UpdateMessageNewReaction) {
        AbstractC13042fc3.i(abacusOuterClass$UpdateMessageNewReaction, "input");
        if (abacusOuterClass$UpdateMessageNewReaction.hasExPeer()) {
            ExPeer exPeer = new ExPeer(ExPeerType.fromValue(abacusOuterClass$UpdateMessageNewReaction.getExPeer().getTypeValue()), abacusOuterClass$UpdateMessageNewReaction.getExPeer().getId());
            if (abacusOuterClass$UpdateMessageNewReaction.hasMessageId()) {
                return new IE7(exPeer, new MessageIdentifier(abacusOuterClass$UpdateMessageNewReaction.getMessageId().getRid(), abacusOuterClass$UpdateMessageNewReaction.getMessageId().getDate(), abacusOuterClass$UpdateMessageNewReaction.getMessageId().getSeq()));
            }
        }
        return null;
    }
}
