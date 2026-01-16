package ir.nasim;

import ai.bale.proto.AbacusOuterClass$UpdateMessageReactions;
import ai.bale.proto.MessagingStruct$MessageReaction;
import ai.bale.proto.PeersStruct$Peer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class NE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public NE7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerStructToPeerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ME7 a(AbacusOuterClass$UpdateMessageReactions abacusOuterClass$UpdateMessageReactions) {
        AbstractC13042fc3.i(abacusOuterClass$UpdateMessageReactions, "input");
        if (!abacusOuterClass$UpdateMessageReactions.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = abacusOuterClass$UpdateMessageReactions.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25A = u25.a(peer);
        long rid = abacusOuterClass$UpdateMessageReactions.getRid();
        long date = abacusOuterClass$UpdateMessageReactions.getDate();
        List<MessagingStruct$MessageReaction> reactionsList = abacusOuterClass$UpdateMessageReactions.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        List<MessagingStruct$MessageReaction> list = reactionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$MessageReaction messagingStruct$MessageReaction : list) {
            String code = messagingStruct$MessageReaction.getCode();
            AbstractC13042fc3.h(code, "getCode(...)");
            List<Integer> usersList = messagingStruct$MessageReaction.getUsersList();
            AbstractC13042fc3.h(usersList, "getUsersList(...)");
            arrayList.add(new GG5(code, usersList, messagingStruct$MessageReaction.getCardinality().getValue()));
        }
        return new ME7(c11458d25A, rid, date, arrayList);
    }
}
