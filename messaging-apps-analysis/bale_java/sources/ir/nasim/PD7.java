package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateGroupCallEnded;
import ai.bale.proto.MeetStruct$GroupCall;

/* loaded from: classes5.dex */
public final class PD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public OD7 a(MeetOuterClass$UpdateGroupCallEnded meetOuterClass$UpdateGroupCallEnded) {
        AbstractC13042fc3.i(meetOuterClass$UpdateGroupCallEnded, "proto");
        MeetStruct$GroupCall groupCall = meetOuterClass$UpdateGroupCallEnded.getGroupCall();
        AbstractC13042fc3.h(groupCall, "getGroupCall(...)");
        return new OD7(groupCall);
    }
}
