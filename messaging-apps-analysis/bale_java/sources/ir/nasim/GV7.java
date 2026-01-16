package ir.nasim;

import ir.nasim.AbstractC21649tt7;
import java.util.List;
import livekit.org.webrtc.RtpParameters;

/* loaded from: classes3.dex */
public final class GV7 extends AbstractC16049kd0 implements InterfaceC5306It7 {
    private final String a;
    private final C9737aT7 b;
    private final boolean c;
    private final String d;
    private final String e;
    private final C12373eW f;
    private final AbstractC21649tt7.g g;
    private final String h;
    private final RtpParameters.DegradationPreference i;
    private final List j;

    public GV7(String str, C9737aT7 c9737aT7, boolean z, String str2, String str3, C12373eW c12373eW, AbstractC21649tt7.g gVar, String str4, RtpParameters.DegradationPreference degradationPreference, List list) {
        AbstractC13042fc3.i(str2, "videoCodec");
        this.a = str;
        this.b = c9737aT7;
        this.c = z;
        this.d = str2;
        this.e = str3;
        this.f = c12373eW;
        this.g = gVar;
        this.h = str4;
        this.i = degradationPreference;
        this.j = list;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public C12373eW a() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public RtpParameters.DegradationPreference b() {
        return this.i;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public String c() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public boolean d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public List e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GV7)) {
            return false;
        }
        GV7 gv7 = (GV7) obj;
        return AbstractC13042fc3.d(this.a, gv7.a) && AbstractC13042fc3.d(this.b, gv7.b) && this.c == gv7.c && AbstractC13042fc3.d(this.d, gv7.d) && AbstractC13042fc3.d(this.e, gv7.e) && AbstractC13042fc3.d(this.f, gv7.f) && this.g == gv7.g && AbstractC13042fc3.d(this.h, gv7.h) && this.i == gv7.i && AbstractC13042fc3.d(this.j, gv7.j);
    }

    @Override // ir.nasim.AbstractC16049kd0
    public String f() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC16049kd0
    public C9737aT7 g() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC5306It7
    public String getName() {
        return this.a;
    }

    public final GV7 h(String str, C9737aT7 c9737aT7, boolean z, String str2, String str3, C12373eW c12373eW, AbstractC21649tt7.g gVar, String str4, RtpParameters.DegradationPreference degradationPreference, List list) {
        AbstractC13042fc3.i(str2, "videoCodec");
        return new GV7(str, c9737aT7, z, str2, str3, c12373eW, gVar, str4, degradationPreference, list);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        C9737aT7 c9737aT7 = this.b;
        int iHashCode2 = (((((iHashCode + (c9737aT7 == null ? 0 : c9737aT7.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        String str2 = this.e;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        C12373eW c12373eW = this.f;
        int iHashCode4 = (iHashCode3 + (c12373eW == null ? 0 : c12373eW.hashCode())) * 31;
        AbstractC21649tt7.g gVar = this.g;
        int iHashCode5 = (iHashCode4 + (gVar == null ? 0 : gVar.hashCode())) * 31;
        String str3 = this.h;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        RtpParameters.DegradationPreference degradationPreference = this.i;
        int iHashCode7 = (iHashCode6 + (degradationPreference == null ? 0 : degradationPreference.hashCode())) * 31;
        List list = this.j;
        return iHashCode7 + (list != null ? list.hashCode() : 0);
    }

    @Override // ir.nasim.InterfaceC5306It7
    public String i() {
        return this.h;
    }

    public AbstractC21649tt7.g k() {
        return this.g;
    }

    public String toString() {
        return "VideoTrackPublishOptions(name=" + this.a + ", videoEncoding=" + this.b + ", simulcast=" + this.c + ", videoCodec=" + this.d + ", scalabilityMode=" + this.e + ", backupCodec=" + this.f + ", source=" + this.g + ", stream=" + this.h + ", degradationPreference=" + this.i + ", simulcastLayers=" + this.j + ')';
    }

    public /* synthetic */ GV7(String str, AbstractC16049kd0 abstractC16049kd0, AbstractC21649tt7.g gVar, String str2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, abstractC16049kd0, (i & 4) != 0 ? null : gVar, (i & 8) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GV7(String str, AbstractC16049kd0 abstractC16049kd0, AbstractC21649tt7.g gVar, String str2) {
        this(str, abstractC16049kd0.g(), abstractC16049kd0.d(), abstractC16049kd0.f(), abstractC16049kd0.c(), abstractC16049kd0.a(), gVar, str2, abstractC16049kd0.b(), abstractC16049kd0.e());
        AbstractC13042fc3.i(abstractC16049kd0, "base");
    }
}
