package ir.nasim.core.modules.settings.entity;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lir/nasim/core/modules/settings/entity/CallRemoteConfig;", "", "videoConfig", "Lir/nasim/core/modules/settings/entity/VideoConfig;", "screenShareVideoConfig", "voiceConfig", "Lir/nasim/core/modules/settings/entity/VoiceConfig;", "<init>", "(Lir/nasim/core/modules/settings/entity/VideoConfig;Lir/nasim/core/modules/settings/entity/VideoConfig;Lir/nasim/core/modules/settings/entity/VoiceConfig;)V", "getVideoConfig", "()Lir/nasim/core/modules/settings/entity/VideoConfig;", "getScreenShareVideoConfig", "getVoiceConfig", "()Lir/nasim/core/modules/settings/entity/VoiceConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class CallRemoteConfig {
    public static final int $stable = 0;

    @InterfaceC23984xq6("screenShareVideoConfig")
    private final VideoConfig screenShareVideoConfig;

    @InterfaceC23984xq6("videoConfig")
    private final VideoConfig videoConfig;

    @InterfaceC23984xq6("voiceConfig")
    private final VoiceConfig voiceConfig;

    public CallRemoteConfig(VideoConfig videoConfig, VideoConfig videoConfig2, VoiceConfig voiceConfig) {
        AbstractC13042fc3.i(videoConfig, "videoConfig");
        AbstractC13042fc3.i(videoConfig2, "screenShareVideoConfig");
        AbstractC13042fc3.i(voiceConfig, "voiceConfig");
        this.videoConfig = videoConfig;
        this.screenShareVideoConfig = videoConfig2;
        this.voiceConfig = voiceConfig;
    }

    public static /* synthetic */ CallRemoteConfig copy$default(CallRemoteConfig callRemoteConfig, VideoConfig videoConfig, VideoConfig videoConfig2, VoiceConfig voiceConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            videoConfig = callRemoteConfig.videoConfig;
        }
        if ((i & 2) != 0) {
            videoConfig2 = callRemoteConfig.screenShareVideoConfig;
        }
        if ((i & 4) != 0) {
            voiceConfig = callRemoteConfig.voiceConfig;
        }
        return callRemoteConfig.copy(videoConfig, videoConfig2, voiceConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final VideoConfig getVideoConfig() {
        return this.videoConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final VideoConfig getScreenShareVideoConfig() {
        return this.screenShareVideoConfig;
    }

    /* renamed from: component3, reason: from getter */
    public final VoiceConfig getVoiceConfig() {
        return this.voiceConfig;
    }

    public final CallRemoteConfig copy(VideoConfig videoConfig, VideoConfig screenShareVideoConfig, VoiceConfig voiceConfig) {
        AbstractC13042fc3.i(videoConfig, "videoConfig");
        AbstractC13042fc3.i(screenShareVideoConfig, "screenShareVideoConfig");
        AbstractC13042fc3.i(voiceConfig, "voiceConfig");
        return new CallRemoteConfig(videoConfig, screenShareVideoConfig, voiceConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallRemoteConfig)) {
            return false;
        }
        CallRemoteConfig callRemoteConfig = (CallRemoteConfig) other;
        return AbstractC13042fc3.d(this.videoConfig, callRemoteConfig.videoConfig) && AbstractC13042fc3.d(this.screenShareVideoConfig, callRemoteConfig.screenShareVideoConfig) && AbstractC13042fc3.d(this.voiceConfig, callRemoteConfig.voiceConfig);
    }

    public final VideoConfig getScreenShareVideoConfig() {
        return this.screenShareVideoConfig;
    }

    public final VideoConfig getVideoConfig() {
        return this.videoConfig;
    }

    public final VoiceConfig getVoiceConfig() {
        return this.voiceConfig;
    }

    public int hashCode() {
        return (((this.videoConfig.hashCode() * 31) + this.screenShareVideoConfig.hashCode()) * 31) + this.voiceConfig.hashCode();
    }

    public String toString() {
        return "CallRemoteConfig(videoConfig=" + this.videoConfig + ", screenShareVideoConfig=" + this.screenShareVideoConfig + ", voiceConfig=" + this.voiceConfig + Separators.RPAREN;
    }
}
