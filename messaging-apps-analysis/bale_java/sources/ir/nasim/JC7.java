package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallEvent;
import java.util.Map;

/* loaded from: classes5.dex */
public final class JC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IC7 a(MeetOuterClass$UpdateCallEvent meetOuterClass$UpdateCallEvent) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallEvent, "proto");
        long callId = meetOuterClass$UpdateCallEvent.getCallId();
        String triggererIdentity = meetOuterClass$UpdateCallEvent.getTriggererIdentity();
        AbstractC13042fc3.h(triggererIdentity, "getTriggererIdentity(...)");
        Map<String, String> extraDataMap = meetOuterClass$UpdateCallEvent.getExtraDataMap();
        AbstractC13042fc3.h(extraDataMap, "getExtraDataMap(...)");
        return new IC7(callId, triggererIdentity, extraDataMap);
    }
}
