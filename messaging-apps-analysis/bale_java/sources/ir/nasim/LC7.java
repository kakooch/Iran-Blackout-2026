package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallJoinRequestAnswered;

/* loaded from: classes5.dex */
public final class LC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public KC7 a(MeetOuterClass$UpdateCallJoinRequestAnswered meetOuterClass$UpdateCallJoinRequestAnswered) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallJoinRequestAnswered, "proto");
        return new KC7(meetOuterClass$UpdateCallJoinRequestAnswered.getIsAllowed(), meetOuterClass$UpdateCallJoinRequestAnswered.getCallId());
    }
}
