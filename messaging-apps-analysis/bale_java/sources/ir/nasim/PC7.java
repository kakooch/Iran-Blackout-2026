package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallReceived;
import ai.bale.proto.PeersStruct$OutPeer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class PC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public OC7 a(MeetOuterClass$UpdateCallReceived meetOuterClass$UpdateCallReceived) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallReceived, "proto");
        long callId = meetOuterClass$UpdateCallReceived.getCallId();
        List<PeersStruct$OutPeer> participantsList = meetOuterClass$UpdateCallReceived.getParticipantsList();
        AbstractC13042fc3.h(participantsList, "getParticipantsList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = participantsList.iterator();
        while (it.hasNext()) {
            C11458d25 c11458d25N = C18732p92.n(C18732p92.a.I0((PeersStruct$OutPeer) it.next()));
            if (c11458d25N != null) {
                arrayList.add(c11458d25N);
            }
        }
        return new OC7(callId, arrayList);
    }
}
