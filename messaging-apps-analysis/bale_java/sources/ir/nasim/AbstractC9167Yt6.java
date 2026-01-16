package ir.nasim;

import com.google.protobuf.GeneratedMessageLite;
import livekit.LivekitRtc$SessionDescription;
import livekit.org.webrtc.SessionDescription;

/* renamed from: ir.nasim.Yt6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9167Yt6 {
    public static final LivekitRtc$SessionDescription a(SessionDescription sessionDescription) {
        AbstractC13042fc3.i(sessionDescription, "<this>");
        LivekitRtc$SessionDescription.a aVarNewBuilder = LivekitRtc$SessionDescription.newBuilder();
        aVarNewBuilder.A(sessionDescription.description);
        aVarNewBuilder.B(sessionDescription.type.canonicalForm());
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (LivekitRtc$SessionDescription) generatedMessageLiteA;
    }
}
