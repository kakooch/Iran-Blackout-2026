package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdatePeersStateChanged;
import ai.bale.proto.MeetStruct$PeerState;
import java.util.List;

/* renamed from: ir.nasim.hF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14046hF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C13455gF7 a(MeetOuterClass$UpdatePeersStateChanged meetOuterClass$UpdatePeersStateChanged) {
        AbstractC13042fc3.i(meetOuterClass$UpdatePeersStateChanged, "proto");
        long callId = meetOuterClass$UpdatePeersStateChanged.getCallId();
        List<MeetStruct$PeerState> peerStatesList = meetOuterClass$UpdatePeersStateChanged.getPeerStatesList();
        AbstractC13042fc3.h(peerStatesList, "getPeerStatesList(...)");
        return new C13455gF7(callId, peerStatesList);
    }
}
