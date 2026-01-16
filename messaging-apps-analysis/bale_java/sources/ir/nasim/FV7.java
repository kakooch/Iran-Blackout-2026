package ir.nasim;

import java.util.List;
import livekit.org.webrtc.RtpParameters;

/* loaded from: classes3.dex */
public final class FV7 extends AbstractC16049kd0 {
    private final C9737aT7 a;
    private final boolean b;
    private final String c;
    private final String d;
    private final C12373eW e;
    private final RtpParameters.DegradationPreference f;
    private final List g;

    public /* synthetic */ FV7(C9737aT7 c9737aT7, boolean z, String str, String str2, C12373eW c12373eW, RtpParameters.DegradationPreference degradationPreference, List list, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : c9737aT7, (i & 2) != 0 ? true : z, (i & 4) != 0 ? CS7.b.j() : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : c12373eW, (i & 32) != 0 ? null : degradationPreference, (i & 64) != 0 ? null : list);
    }

    @Override // ir.nasim.AbstractC16049kd0
    public C12373eW a() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public RtpParameters.DegradationPreference b() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public String c() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public boolean d() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public List e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FV7)) {
            return false;
        }
        FV7 fv7 = (FV7) obj;
        return AbstractC13042fc3.d(this.a, fv7.a) && this.b == fv7.b && AbstractC13042fc3.d(this.c, fv7.c) && AbstractC13042fc3.d(this.d, fv7.d) && AbstractC13042fc3.d(this.e, fv7.e) && this.f == fv7.f && AbstractC13042fc3.d(this.g, fv7.g);
    }

    @Override // ir.nasim.AbstractC16049kd0
    public String f() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public C9737aT7 g() {
        return this.a;
    }

    public int hashCode() {
        C9737aT7 c9737aT7 = this.a;
        int iHashCode = (((((c9737aT7 == null ? 0 : c9737aT7.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        C12373eW c12373eW = this.e;
        int iHashCode3 = (iHashCode2 + (c12373eW == null ? 0 : c12373eW.hashCode())) * 31;
        RtpParameters.DegradationPreference degradationPreference = this.f;
        int iHashCode4 = (iHashCode3 + (degradationPreference == null ? 0 : degradationPreference.hashCode())) * 31;
        List list = this.g;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "VideoTrackPublishDefaults(videoEncoding=" + this.a + ", simulcast=" + this.b + ", videoCodec=" + this.c + ", scalabilityMode=" + this.d + ", backupCodec=" + this.e + ", degradationPreference=" + this.f + ", simulcastLayers=" + this.g + ')';
    }

    public FV7(C9737aT7 c9737aT7, boolean z, String str, String str2, C12373eW c12373eW, RtpParameters.DegradationPreference degradationPreference, List list) {
        AbstractC13042fc3.i(str, "videoCodec");
        this.a = c9737aT7;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = c12373eW;
        this.f = degradationPreference;
        this.g = list;
    }
}
