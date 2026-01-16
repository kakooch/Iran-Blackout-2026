package org.webrtc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import org.webrtc.EglBase;
import org.webrtc.VideoDecoderFactory;

/* loaded from: classes3.dex */
public class DefaultVideoDecoderFactory implements VideoDecoderFactory {
    private final VideoDecoderFactory hardwareVideoDecoderFactory;
    private final VideoDecoderFactory platformSoftwareVideoDecoderFactory;
    private final VideoDecoderFactory softwareVideoDecoderFactory;

    @Override // org.webrtc.VideoDecoderFactory
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return VideoDecoderFactory.CC.$default$createDecoder(this, str);
    }

    public DefaultVideoDecoderFactory(EglBase.Context eglContext) {
        this.softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        this.hardwareVideoDecoderFactory = new HardwareVideoDecoderFactory(eglContext);
        this.platformSoftwareVideoDecoderFactory = new PlatformSoftwareVideoDecoderFactory(eglContext);
    }

    DefaultVideoDecoderFactory(VideoDecoderFactory hardwareVideoDecoderFactory) {
        this.softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        this.hardwareVideoDecoderFactory = hardwareVideoDecoderFactory;
        this.platformSoftwareVideoDecoderFactory = null;
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoDecoder createDecoder(VideoCodecInfo codecType) {
        VideoDecoderFactory videoDecoderFactory;
        VideoDecoder videoDecoderCreateDecoder = this.softwareVideoDecoderFactory.createDecoder(codecType);
        VideoDecoder videoDecoderCreateDecoder2 = this.hardwareVideoDecoderFactory.createDecoder(codecType);
        if (videoDecoderCreateDecoder == null && (videoDecoderFactory = this.platformSoftwareVideoDecoderFactory) != null) {
            videoDecoderCreateDecoder = videoDecoderFactory.createDecoder(codecType);
        }
        if (videoDecoderCreateDecoder2 == null || videoDecoderCreateDecoder == null) {
            return videoDecoderCreateDecoder2 != null ? videoDecoderCreateDecoder2 : videoDecoderCreateDecoder;
        }
        return new VideoDecoderFallback(videoDecoderCreateDecoder, videoDecoderCreateDecoder2);
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(Arrays.asList(this.softwareVideoDecoderFactory.getSupportedCodecs()));
        linkedHashSet.addAll(Arrays.asList(this.hardwareVideoDecoderFactory.getSupportedCodecs()));
        VideoDecoderFactory videoDecoderFactory = this.platformSoftwareVideoDecoderFactory;
        if (videoDecoderFactory != null) {
            linkedHashSet.addAll(Arrays.asList(videoDecoderFactory.getSupportedCodecs()));
        }
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
    }
}
