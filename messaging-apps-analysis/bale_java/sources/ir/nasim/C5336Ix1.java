package ir.nasim;

import java.util.List;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.SoftwareVideoDecoderFactory;
import livekit.org.webrtc.VideoCodecInfo;
import livekit.org.webrtc.VideoDecoder;
import livekit.org.webrtc.VideoDecoderFactory;
import livekit.org.webrtc.WrappedVideoDecoderFactory;

/* renamed from: ir.nasim.Ix1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5336Ix1 implements VideoDecoderFactory {
    private boolean a;
    private List b;
    private final SoftwareVideoDecoderFactory c;
    private final WrappedVideoDecoderFactory d;

    public C5336Ix1(EglBase.Context context, boolean z, List list) {
        AbstractC13042fc3.i(list, "forceSWCodecs");
        this.a = z;
        this.b = list;
        this.c = new SoftwareVideoDecoderFactory();
        this.d = new WrappedVideoDecoderFactory(context);
    }

    @Override // livekit.org.webrtc.VideoDecoderFactory
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        AbstractC13042fc3.i(videoCodecInfo, "videoCodecInfo");
        return this.a ? this.c.createDecoder(videoCodecInfo) : ((this.b.isEmpty() ^ true) && this.b.contains(videoCodecInfo.name)) ? this.c.createDecoder(videoCodecInfo) : this.d.createDecoder(videoCodecInfo);
    }

    @Override // livekit.org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        if (this.a && this.b.isEmpty()) {
            VideoCodecInfo[] supportedCodecs = this.c.getSupportedCodecs();
            AbstractC13042fc3.f(supportedCodecs);
            return supportedCodecs;
        }
        VideoCodecInfo[] supportedCodecs2 = this.d.getSupportedCodecs();
        AbstractC13042fc3.f(supportedCodecs2);
        return supportedCodecs2;
    }

    public /* synthetic */ C5336Ix1(EglBase.Context context, boolean z, List list, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? false : z, (i & 4) != 0 ? AbstractC9766aX0.e("VP9") : list);
    }
}
