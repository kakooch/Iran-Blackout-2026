package ir.nasim.core.modules.settings.entity;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\u0003H×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lir/nasim/core/modules/settings/entity/VoiceConfig;", "", "audioBitrate", "", "audioJitterBufferMaxPackets", "audioJitterBufferFastAccelerate", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAudioBitrate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAudioJitterBufferMaxPackets", "getAudioJitterBufferFastAccelerate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lir/nasim/core/modules/settings/entity/VoiceConfig;", "equals", "other", "hashCode", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class VoiceConfig {
    public static final int $stable = 0;

    @InterfaceC23984xq6("audioBitrate")
    private final Integer audioBitrate;

    @InterfaceC23984xq6("audioJitterBufferFastAccelerate")
    private final Boolean audioJitterBufferFastAccelerate;

    @InterfaceC23984xq6("audioJitterBufferMaxPackets")
    private final Integer audioJitterBufferMaxPackets;

    public VoiceConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VoiceConfig copy$default(VoiceConfig voiceConfig, Integer num, Integer num2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = voiceConfig.audioBitrate;
        }
        if ((i & 2) != 0) {
            num2 = voiceConfig.audioJitterBufferMaxPackets;
        }
        if ((i & 4) != 0) {
            bool = voiceConfig.audioJitterBufferFastAccelerate;
        }
        return voiceConfig.copy(num, num2, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getAudioBitrate() {
        return this.audioBitrate;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getAudioJitterBufferMaxPackets() {
        return this.audioJitterBufferMaxPackets;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getAudioJitterBufferFastAccelerate() {
        return this.audioJitterBufferFastAccelerate;
    }

    public final VoiceConfig copy(Integer audioBitrate, Integer audioJitterBufferMaxPackets, Boolean audioJitterBufferFastAccelerate) {
        return new VoiceConfig(audioBitrate, audioJitterBufferMaxPackets, audioJitterBufferFastAccelerate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceConfig)) {
            return false;
        }
        VoiceConfig voiceConfig = (VoiceConfig) other;
        return AbstractC13042fc3.d(this.audioBitrate, voiceConfig.audioBitrate) && AbstractC13042fc3.d(this.audioJitterBufferMaxPackets, voiceConfig.audioJitterBufferMaxPackets) && AbstractC13042fc3.d(this.audioJitterBufferFastAccelerate, voiceConfig.audioJitterBufferFastAccelerate);
    }

    public final Integer getAudioBitrate() {
        return this.audioBitrate;
    }

    public final Boolean getAudioJitterBufferFastAccelerate() {
        return this.audioJitterBufferFastAccelerate;
    }

    public final Integer getAudioJitterBufferMaxPackets() {
        return this.audioJitterBufferMaxPackets;
    }

    public int hashCode() {
        Integer num = this.audioBitrate;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.audioJitterBufferMaxPackets;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.audioJitterBufferFastAccelerate;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "VoiceConfig(audioBitrate=" + this.audioBitrate + ", audioJitterBufferMaxPackets=" + this.audioJitterBufferMaxPackets + ", audioJitterBufferFastAccelerate=" + this.audioJitterBufferFastAccelerate + Separators.RPAREN;
    }

    public VoiceConfig(Integer num, Integer num2, Boolean bool) {
        this.audioBitrate = num;
        this.audioJitterBufferMaxPackets = num2;
        this.audioJitterBufferFastAccelerate = bool;
    }

    public /* synthetic */ VoiceConfig(Integer num, Integer num2, Boolean bool, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : bool);
    }
}
