package io.sentry;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.Locale;

/* loaded from: classes3.dex */
public enum X2 implements A0 {
    Session(ParameterNames.SESSION),
    Event("event"),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction("transaction"),
    Profile("profile"),
    ProfileChunk("profile_chunk"),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    ReplayVideo("replay_video"),
    CheckIn("check_in"),
    Feedback("feedback"),
    Log("log"),
    Unknown("__unknown__");

    private final String itemType;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public X2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            return X2.valueOfLabel(interfaceC3118g1.T0().toLowerCase(Locale.ROOT));
        }
    }

    X2(String str) {
        this.itemType = str;
    }

    public static X2 resolve(Object obj) {
        return obj instanceof L2 ? ((L2) obj).C().f() == null ? Event : Feedback : obj instanceof io.sentry.protocol.C ? Transaction : obj instanceof C3 ? Session : obj instanceof io.sentry.clientreport.c ? ClientReport : Attachment;
    }

    public static X2 valueOfLabel(String str) {
        for (X2 x2 : values()) {
            if (x2.itemType.equals(str)) {
                return x2;
            }
        }
        return Unknown;
    }

    public String getItemType() {
        return this.itemType;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.h(this.itemType);
    }
}
