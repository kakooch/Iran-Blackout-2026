package ir.nasim;

import java.util.List;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.SoftwareVideoEncoderFactory;
import livekit.org.webrtc.VideoCodecInfo;
import livekit.org.webrtc.VideoEncoder;
import livekit.org.webrtc.VideoEncoderFactory;

/* renamed from: ir.nasim.Jx1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5570Jx1 implements VideoEncoderFactory {
    private boolean a;
    private List b;
    private final SoftwareVideoEncoderFactory c;
    private final C10802cD6 d;

    public C5570Jx1(EglBase.Context context, boolean z, boolean z2, boolean z3, List list) {
        AbstractC13042fc3.i(list, "forceSWCodecs");
        this.a = z3;
        this.b = list;
        this.c = new SoftwareVideoEncoderFactory();
        this.d = new C10802cD6(context, z, z2);
    }

    @Override // livekit.org.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        AbstractC13042fc3.i(videoCodecInfo, "videoCodecInfo");
        return this.a ? this.c.createEncoder(videoCodecInfo) : ((this.b.isEmpty() ^ true) && this.b.contains(videoCodecInfo.name)) ? this.c.createEncoder(videoCodecInfo) : this.d.createEncoder(videoCodecInfo);
    }

    @Override // livekit.org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        if (!this.a || !this.b.isEmpty()) {
            return this.d.getSupportedCodecs();
        }
        VideoCodecInfo[] supportedCodecs = this.c.getSupportedCodecs();
        AbstractC13042fc3.f(supportedCodecs);
        return supportedCodecs;
    }

    public /* synthetic */ C5570Jx1(EglBase.Context context, boolean z, boolean z2, boolean z3, List list, int i, ED1 ed1) {
        this(context, z, z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? AbstractC9766aX0.e("VP9") : list);
    }
}
