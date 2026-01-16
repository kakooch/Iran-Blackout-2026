package io.sentry;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;

/* renamed from: io.sentry.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC3136k {
    All("__all__"),
    Default("default"),
    Error("error"),
    Feedback("feedback"),
    Session(ParameterNames.SESSION),
    Attachment("attachment"),
    LogItem("log_item"),
    Monitor("monitor"),
    Profile("profile"),
    ProfileChunkUi("profile_chunk_ui"),
    Transaction("transaction"),
    Replay("replay"),
    Span("span"),
    Security("security"),
    UserReport("user_report"),
    Unknown(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE);

    private final String category;

    EnumC3136k(String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
