package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002 \u0017B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\nH×\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lir/nasim/b18;", "", "Lir/nasim/a18;", "voiceTranscriptState", "", "voiceTranscript", "", "isReacted", "<init>", "(Lir/nasim/a18;Ljava/lang/String;Z)V", "", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILir/nasim/a18;Ljava/lang/String;ZLir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "g", "(Lir/nasim/b18;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "b", "(Lir/nasim/a18;Ljava/lang/String;Z)Lir/nasim/b18;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lir/nasim/a18;", "e", "()Lir/nasim/a18;", "Ljava/lang/String;", "d", "c", "Z", "f", "()Z", "Companion", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.b18, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public final /* data */ class VoiceTranscript {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] d = {EnumC9477a18.INSTANCE.serializer(), null, null};

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final EnumC9477a18 voiceTranscriptState;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String voiceTranscript;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean isReacted;

    /* renamed from: ir.nasim.b18$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer serializer() {
            return a.a;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ VoiceTranscript(int i, EnumC9477a18 enumC9477a18, String str, boolean z, AbstractC21618tq6 abstractC21618tq6) {
        this.voiceTranscriptState = (i & 1) == 0 ? EnumC9477a18.b : enumC9477a18;
        if ((i & 2) == 0) {
            this.voiceTranscript = null;
        } else {
            this.voiceTranscript = str;
        }
        if ((i & 4) == 0) {
            this.isReacted = false;
        } else {
            this.isReacted = z;
        }
    }

    public static /* synthetic */ VoiceTranscript c(VoiceTranscript voiceTranscript, EnumC9477a18 enumC9477a18, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC9477a18 = voiceTranscript.voiceTranscriptState;
        }
        if ((i & 2) != 0) {
            str = voiceTranscript.voiceTranscript;
        }
        if ((i & 4) != 0) {
            z = voiceTranscript.isReacted;
        }
        return voiceTranscript.b(enumC9477a18, str, z);
    }

    public static final /* synthetic */ void g(VoiceTranscript self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = d;
        if (output.z(serialDesc, 0) || self.voiceTranscriptState != EnumC9477a18.b) {
            output.B(serialDesc, 0, kSerializerArr[0], self.voiceTranscriptState);
        }
        if (output.z(serialDesc, 1) || self.voiceTranscript != null) {
            output.m(serialDesc, 1, VY6.a, self.voiceTranscript);
        }
        if (output.z(serialDesc, 2) || self.isReacted) {
            output.x(serialDesc, 2, self.isReacted);
        }
    }

    public final VoiceTranscript b(EnumC9477a18 voiceTranscriptState, String voiceTranscript, boolean isReacted) {
        AbstractC13042fc3.i(voiceTranscriptState, "voiceTranscriptState");
        return new VoiceTranscript(voiceTranscriptState, voiceTranscript, isReacted);
    }

    /* renamed from: d, reason: from getter */
    public final String getVoiceTranscript() {
        return this.voiceTranscript;
    }

    /* renamed from: e, reason: from getter */
    public final EnumC9477a18 getVoiceTranscriptState() {
        return this.voiceTranscriptState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceTranscript)) {
            return false;
        }
        VoiceTranscript voiceTranscript = (VoiceTranscript) other;
        return this.voiceTranscriptState == voiceTranscript.voiceTranscriptState && AbstractC13042fc3.d(this.voiceTranscript, voiceTranscript.voiceTranscript) && this.isReacted == voiceTranscript.isReacted;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsReacted() {
        return this.isReacted;
    }

    public int hashCode() {
        int iHashCode = this.voiceTranscriptState.hashCode() * 31;
        String str = this.voiceTranscript;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isReacted);
    }

    public String toString() {
        return "VoiceTranscript(voiceTranscriptState=" + this.voiceTranscriptState + ", voiceTranscript=" + this.voiceTranscript + ", isReacted=" + this.isReacted + Separators.RPAREN;
    }

    public VoiceTranscript(EnumC9477a18 enumC9477a18, String str, boolean z) {
        AbstractC13042fc3.i(enumC9477a18, "voiceTranscriptState");
        this.voiceTranscriptState = enumC9477a18;
        this.voiceTranscript = str;
        this.isReacted = z;
    }

    public /* synthetic */ VoiceTranscript(EnumC9477a18 enumC9477a18, String str, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? EnumC9477a18.b : enumC9477a18, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
    }
}
