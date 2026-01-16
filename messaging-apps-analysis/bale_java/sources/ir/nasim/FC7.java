package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallAccepted;
import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.PeersStruct$OutPeer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class FC7 implements InterfaceC14123hO3 {
    private final U25 a;

    public FC7(U25 u25) {
        AbstractC13042fc3.i(u25, "mapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EC7 a(MeetOuterClass$UpdateCallAccepted meetOuterClass$UpdateCallAccepted) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallAccepted, "proto");
        MeetStruct$Call call = meetOuterClass$UpdateCallAccepted.getCall();
        AbstractC13042fc3.h(call, "getCall(...)");
        List<PeersStruct$OutPeer> participantsList = meetOuterClass$UpdateCallAccepted.getParticipantsList();
        AbstractC13042fc3.h(participantsList, "getParticipantsList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = participantsList.iterator();
        while (it.hasNext()) {
            C11458d25 c11458d25N = C18732p92.n(C18732p92.a.I0((PeersStruct$OutPeer) it.next()));
            if (c11458d25N != null) {
                arrayList.add(c11458d25N);
            }
        }
        return new EC7(call, arrayList);
    }
}
