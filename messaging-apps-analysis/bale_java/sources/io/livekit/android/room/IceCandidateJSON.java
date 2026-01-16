package io.livekit.android.room;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.ED1;
import ir.nasim.VY6;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bB7\b\u0011\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b!\u0010\u0016¨\u0006$"}, d2 = {"Lio/livekit/android/room/IceCandidateJSON;", "", "", "candidate", "", "sdpMLineIndex", "sdpMid", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "seen1", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;ILjava/lang/String;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "d", "(Lio/livekit/android/room/IceCandidateJSON;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", TokenNames.I, "c", "Companion", "$serializer", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final /* data */ class IceCandidateJSON {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String candidate;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final int sdpMLineIndex;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String sdpMid;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/livekit/android/room/IceCandidateJSON$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/livekit/android/room/IceCandidateJSON;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer serializer() {
            return IceCandidateJSON$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ IceCandidateJSON(int i, String str, int i2, String str2, AbstractC21618tq6 abstractC21618tq6) {
        if (7 != (i & 7)) {
            AbstractC19039pg5.a(i, 7, IceCandidateJSON$$serializer.INSTANCE.getDescriptor());
        }
        this.candidate = str;
        this.sdpMLineIndex = i2;
        this.sdpMid = str2;
    }

    public static final /* synthetic */ void d(IceCandidateJSON self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        output.y(serialDesc, 0, self.candidate);
        output.w(serialDesc, 1, self.sdpMLineIndex);
        output.m(serialDesc, 2, VY6.a, self.sdpMid);
    }

    /* renamed from: a, reason: from getter */
    public final String getCandidate() {
        return this.candidate;
    }

    /* renamed from: b, reason: from getter */
    public final int getSdpMLineIndex() {
        return this.sdpMLineIndex;
    }

    /* renamed from: c, reason: from getter */
    public final String getSdpMid() {
        return this.sdpMid;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IceCandidateJSON)) {
            return false;
        }
        IceCandidateJSON iceCandidateJSON = (IceCandidateJSON) other;
        return AbstractC13042fc3.d(this.candidate, iceCandidateJSON.candidate) && this.sdpMLineIndex == iceCandidateJSON.sdpMLineIndex && AbstractC13042fc3.d(this.sdpMid, iceCandidateJSON.sdpMid);
    }

    public int hashCode() {
        int iHashCode = ((this.candidate.hashCode() * 31) + Integer.hashCode(this.sdpMLineIndex)) * 31;
        String str = this.sdpMid;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "IceCandidateJSON(candidate=" + this.candidate + ", sdpMLineIndex=" + this.sdpMLineIndex + ", sdpMid=" + this.sdpMid + ')';
    }

    public IceCandidateJSON(String str, int i, String str2) {
        AbstractC13042fc3.i(str, "candidate");
        this.candidate = str;
        this.sdpMLineIndex = i;
        this.sdpMid = str2;
    }
}
