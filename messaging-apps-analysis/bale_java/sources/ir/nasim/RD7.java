package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateGroupCallStarted;
import ai.bale.proto.MeetStruct$GroupCall;

/* loaded from: classes5.dex */
public final class RD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QD7 a(MeetOuterClass$UpdateGroupCallStarted meetOuterClass$UpdateGroupCallStarted) {
        AbstractC13042fc3.i(meetOuterClass$UpdateGroupCallStarted, "proto");
        MeetStruct$GroupCall groupCall = meetOuterClass$UpdateGroupCallStarted.getGroupCall();
        AbstractC13042fc3.h(groupCall, "getGroupCall(...)");
        return new QD7(groupCall);
    }
}
