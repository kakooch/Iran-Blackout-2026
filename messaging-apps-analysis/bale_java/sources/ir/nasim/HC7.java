package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallDiscarded;
import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.PeersStruct$OutPeer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class HC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GC7 a(MeetOuterClass$UpdateCallDiscarded meetOuterClass$UpdateCallDiscarded) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallDiscarded, "proto");
        MeetStruct$Call call = meetOuterClass$UpdateCallDiscarded.getCall();
        AbstractC13042fc3.h(call, "getCall(...)");
        List<PeersStruct$OutPeer> participantsList = meetOuterClass$UpdateCallDiscarded.getParticipantsList();
        AbstractC13042fc3.h(participantsList, "getParticipantsList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = participantsList.iterator();
        while (it.hasNext()) {
            C11458d25 c11458d25N = C18732p92.n(C18732p92.a.I0((PeersStruct$OutPeer) it.next()));
            if (c11458d25N != null) {
                arrayList.add(c11458d25N);
            }
        }
        return new GC7(call, arrayList);
    }
}
