package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallStarted;
import ai.bale.proto.MeetStruct$Call;

/* loaded from: classes5.dex */
public final class RC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QC7 a(MeetOuterClass$UpdateCallStarted meetOuterClass$UpdateCallStarted) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallStarted, "proto");
        MeetStruct$Call call = meetOuterClass$UpdateCallStarted.getCall();
        AbstractC13042fc3.h(call, "getCall(...)");
        return new QC7(call);
    }
}
