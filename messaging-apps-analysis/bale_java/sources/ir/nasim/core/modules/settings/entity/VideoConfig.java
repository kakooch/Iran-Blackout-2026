package ir.nasim.core.modules.settings.entity;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001f\u001a\u00020\u0003H×\u0001J\t\u0010 \u001a\u00020\u0006H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lir/nasim/core/modules/settings/entity/VideoConfig;", "", "maxBitrate", "", "maxFps", "videoCodec", "", "simulcast", "", "scalabilityMode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getMaxBitrate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxFps", "getVideoCodec", "()Ljava/lang/String;", "getSimulcast", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScalabilityMode", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lir/nasim/core/modules/settings/entity/VideoConfig;", "equals", "other", "hashCode", "toString", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class VideoConfig {
    public static final int $stable = 0;

    @InterfaceC23984xq6("maxBitrate")
    private final Integer maxBitrate;

    @InterfaceC23984xq6("maxFps")
    private final Integer maxFps;

    @InterfaceC23984xq6("scalabilityMode")
    private final String scalabilityMode;

    @InterfaceC23984xq6("simulcast")
    private final Boolean simulcast;

    @InterfaceC23984xq6("videoCodec")
    private final String videoCodec;

    public VideoConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ VideoConfig copy$default(VideoConfig videoConfig, Integer num, Integer num2, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = videoConfig.maxBitrate;
        }
        if ((i & 2) != 0) {
            num2 = videoConfig.maxFps;
        }
        Integer num3 = num2;
        if ((i & 4) != 0) {
            str = videoConfig.videoCodec;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            bool = videoConfig.simulcast;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            str2 = videoConfig.scalabilityMode;
        }
        return videoConfig.copy(num, num3, str3, bool2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getMaxBitrate() {
        return this.maxBitrate;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVideoCodec() {
        return this.videoCodec;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getSimulcast() {
        return this.simulcast;
    }

    /* renamed from: component5, reason: from getter */
    public final String getScalabilityMode() {
        return this.scalabilityMode;
    }

    public final VideoConfig copy(Integer maxBitrate, Integer maxFps, String videoCodec, Boolean simulcast, String scalabilityMode) {
        return new VideoConfig(maxBitrate, maxFps, videoCodec, simulcast, scalabilityMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoConfig)) {
            return false;
        }
        VideoConfig videoConfig = (VideoConfig) other;
        return AbstractC13042fc3.d(this.maxBitrate, videoConfig.maxBitrate) && AbstractC13042fc3.d(this.maxFps, videoConfig.maxFps) && AbstractC13042fc3.d(this.videoCodec, videoConfig.videoCodec) && AbstractC13042fc3.d(this.simulcast, videoConfig.simulcast) && AbstractC13042fc3.d(this.scalabilityMode, videoConfig.scalabilityMode);
    }

    public final Integer getMaxBitrate() {
        return this.maxBitrate;
    }

    public final Integer getMaxFps() {
        return this.maxFps;
    }

    public final String getScalabilityMode() {
        return this.scalabilityMode;
    }

    public final Boolean getSimulcast() {
        return this.simulcast;
    }

    public final String getVideoCodec() {
        return this.videoCodec;
    }

    public int hashCode() {
        Integer num = this.maxBitrate;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.maxFps;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.videoCodec;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.simulcast;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.scalabilityMode;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VideoConfig(maxBitrate=" + this.maxBitrate + ", maxFps=" + this.maxFps + ", videoCodec=" + this.videoCodec + ", simulcast=" + this.simulcast + ", scalabilityMode=" + this.scalabilityMode + Separators.RPAREN;
    }

    public VideoConfig(Integer num, Integer num2, String str, Boolean bool, String str2) {
        this.maxBitrate = num;
        this.maxFps = num2;
        this.videoCodec = str;
        this.simulcast = bool;
        this.scalabilityMode = str2;
    }

    public /* synthetic */ VideoConfig(Integer num, Integer num2, String str, Boolean bool, String str2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str2);
    }
}
