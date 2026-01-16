package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateMultiPeerCallStarted;
import ai.bale.proto.PeersStruct$OutExPeer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.dF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11585dF7 implements InterfaceC14123hO3 {
    private final NM4 a;

    public C11585dF7(NM4 nm4) {
        AbstractC13042fc3.i(nm4, "mapper");
        this.a = nm4;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C10821cF7 a(MeetOuterClass$UpdateMultiPeerCallStarted meetOuterClass$UpdateMultiPeerCallStarted) {
        AbstractC13042fc3.i(meetOuterClass$UpdateMultiPeerCallStarted, "proto");
        long id = meetOuterClass$UpdateMultiPeerCallStarted.getId();
        long initiator = meetOuterClass$UpdateMultiPeerCallStarted.getInitiator();
        List<PeersStruct$OutExPeer> participantsList = meetOuterClass$UpdateMultiPeerCallStarted.getParticipantsList();
        AbstractC13042fc3.h(participantsList, "getParticipantsList(...)");
        List<PeersStruct$OutExPeer> list = participantsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$OutExPeer peersStruct$OutExPeer : list) {
            NM4 nm4 = this.a;
            AbstractC13042fc3.f(peersStruct$OutExPeer);
            arrayList.add(nm4.a(peersStruct$OutExPeer));
        }
        return new C10821cF7(id, initiator, arrayList, meetOuterClass$UpdateMultiPeerCallStarted.getUpdateCreateDate());
    }
}
