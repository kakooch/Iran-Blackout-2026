package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C10802cD6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.HardwareVideoEncoderFactory;
import livekit.org.webrtc.SimulcastVideoEncoderFactory;
import livekit.org.webrtc.SoftwareVideoEncoderFactory;
import livekit.org.webrtc.VideoCodecInfo;
import livekit.org.webrtc.VideoCodecStatus;
import livekit.org.webrtc.VideoEncoder;
import livekit.org.webrtc.VideoEncoderFactory;
import livekit.org.webrtc.VideoEncoderFallback;
import livekit.org.webrtc.VideoFrame;
import livekit.org.webrtc.WrappedNativeVideoEncoder;

/* renamed from: ir.nasim.cD6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C10802cD6 implements VideoEncoderFactory {
    private final VideoEncoderFactory a;
    private final VideoEncoderFactory b;
    private final SimulcastVideoEncoderFactory c;

    /* renamed from: ir.nasim.cD6$a */
    private static final class a implements VideoEncoderFactory {
        private final VideoEncoderFactory a;
        private final VideoEncoderFactory b;

        public a(VideoEncoderFactory videoEncoderFactory) {
            AbstractC13042fc3.i(videoEncoderFactory, "hardwareVideoEncoderFactory");
            this.a = videoEncoderFactory;
            this.b = new SoftwareVideoEncoderFactory();
        }

        @Override // livekit.org.webrtc.VideoEncoderFactory
        public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
            AbstractC13042fc3.i(videoCodecInfo, ParameterNames.INFO);
            VideoEncoder videoEncoderCreateEncoder = this.b.createEncoder(videoCodecInfo);
            VideoEncoder videoEncoderCreateEncoder2 = this.a.createEncoder(videoCodecInfo);
            return (videoEncoderCreateEncoder2 == null || videoEncoderCreateEncoder == null) ? videoEncoderCreateEncoder == null ? videoEncoderCreateEncoder2 : videoEncoderCreateEncoder : new VideoEncoderFallback(videoEncoderCreateEncoder2, videoEncoderCreateEncoder);
        }

        @Override // livekit.org.webrtc.VideoEncoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            ArrayList arrayList = new ArrayList();
            VideoCodecInfo[] supportedCodecs = this.b.getSupportedCodecs();
            AbstractC13042fc3.h(supportedCodecs, "getSupportedCodecs(...)");
            AbstractC13610gX0.E(arrayList, supportedCodecs);
            VideoCodecInfo[] supportedCodecs2 = this.a.getSupportedCodecs();
            AbstractC13042fc3.h(supportedCodecs2, "getSupportedCodecs(...)");
            AbstractC13610gX0.E(arrayList, supportedCodecs2);
            return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[0]);
        }
    }

    /* renamed from: ir.nasim.cD6$b */
    private static final class b {
        public static final a Companion = new a(null);
        private final String a;
        private final Map b;
        private final List c;
        public VideoCodecInfo d;

        /* renamed from: ir.nasim.cD6$b$a */
        public static final class a {
            private a() {
            }

            public final b a(VideoCodecInfo videoCodecInfo) {
                AbstractC13042fc3.i(videoCodecInfo, "codecInfo");
                String str = videoCodecInfo.name;
                AbstractC13042fc3.h(str, "name");
                Map<String, String> map = videoCodecInfo.params;
                AbstractC13042fc3.h(map, "params");
                List<String> list = videoCodecInfo.scalabilityModes;
                AbstractC13042fc3.h(list, "scalabilityModes");
                b bVar = new b(str, map, list);
                bVar.b(videoCodecInfo);
                return bVar;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(String str, Map map, List list) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(map, "params");
            AbstractC13042fc3.i(list, "scalabilityModes");
            this.a = str;
            this.b = map;
            this.c = list;
        }

        public final VideoCodecInfo a() {
            VideoCodecInfo videoCodecInfo = this.d;
            if (videoCodecInfo != null) {
                return videoCodecInfo;
            }
            AbstractC13042fc3.y("originalInfo");
            return null;
        }

        public final void b(VideoCodecInfo videoCodecInfo) {
            AbstractC13042fc3.i(videoCodecInfo, "<set-?>");
            this.d = videoCodecInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "HashableVideoCodecInfo(name=" + this.a + ", params=" + this.b + ", scalabilityModes=" + this.c + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.cD6$c */
    static final class c implements VideoEncoder {
        private final VideoEncoder a;
        private final ExecutorService b;
        private VideoEncoder.Settings c;

        public c(VideoEncoder videoEncoder) {
            AbstractC13042fc3.i(videoEncoder, "encoder");
            this.a = videoEncoder;
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            AbstractC13042fc3.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            this.b = executorServiceNewSingleThreadExecutor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Long l(c cVar, long j) {
            AbstractC13042fc3.i(cVar, "this$0");
            return Long.valueOf(cVar.a.createNative(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoCodecStatus m(c cVar, VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
            AbstractC13042fc3.i(cVar, "this$0");
            AbstractC13042fc3.i(videoFrame, "$frame");
            if (cVar.c == null) {
                return cVar.a.encode(videoFrame, encodeInfo);
            }
            int width = videoFrame.getBuffer().getWidth();
            VideoEncoder.Settings settings = cVar.c;
            AbstractC13042fc3.f(settings);
            if (width == settings.width) {
                return cVar.a.encode(videoFrame, encodeInfo);
            }
            VideoFrame.Buffer buffer = videoFrame.getBuffer();
            int width2 = buffer.getWidth();
            int height = buffer.getHeight();
            VideoEncoder.Settings settings2 = cVar.c;
            AbstractC13042fc3.f(settings2);
            int i = settings2.width;
            VideoEncoder.Settings settings3 = cVar.c;
            AbstractC13042fc3.f(settings3);
            VideoFrame.Buffer bufferCropAndScale = buffer.cropAndScale(0, 0, width2, height, i, settings3.height);
            VideoCodecStatus videoCodecStatusEncode = cVar.a.encode(new VideoFrame(bufferCropAndScale, videoFrame.getRotation(), videoFrame.getTimestampNs()), encodeInfo);
            bufferCropAndScale.release();
            return videoCodecStatusEncode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoEncoder.EncoderInfo n(c cVar) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.getEncoderInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String o(c cVar) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.getImplementationName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoEncoder.ResolutionBitrateLimits[] p(c cVar) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.getResolutionBitrateLimits();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoEncoder.ScalingSettings q(c cVar) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.getScalingSettings();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoCodecStatus r(c cVar, VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
            AbstractC13042fc3.i(cVar, "this$0");
            AbstractC13042fc3.i(settings, "$settings");
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.g(null, AbstractC16016kZ6.i("initEncode() thread=" + Thread.currentThread().getName() + " [" + Thread.currentThread().getId() + "]\n                |  encoder=" + cVar.a.getImplementationName() + "\n                |  streamSettings:\n                |    numberOfCores=" + settings.numberOfCores + "\n                |    width=" + settings.width + "\n                |    height=" + settings.height + "\n                |    startBitrate=" + settings.startBitrate + "\n                |    maxFramerate=" + settings.maxFramerate + "\n                |    automaticResizeOn=" + settings.automaticResizeOn + "\n                |    numberOfSimulcastStreams=" + settings.numberOfSimulcastStreams + "\n                |    lossNotification=" + settings.capabilities.lossNotification + "\n                        ", null, 1, null), new Object[0]);
            }
            return cVar.a.initEncode(settings, callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean s(c cVar) {
            AbstractC13042fc3.i(cVar, "this$0");
            return Boolean.valueOf(cVar.a.isHardwareEncoder());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoCodecStatus t(c cVar) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoCodecStatus u(c cVar, VideoEncoder.BitrateAllocation bitrateAllocation, int i) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.setRateAllocation(bitrateAllocation, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoCodecStatus v(c cVar, VideoEncoder.RateControlParameters rateControlParameters) {
            AbstractC13042fc3.i(cVar, "this$0");
            return cVar.a.setRates(rateControlParameters);
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public long createNative(final long j) throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.jD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.l(this.a, j);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return ((Number) obj).longValue();
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoCodecStatus encode(final VideoFrame videoFrame, final VideoEncoder.EncodeInfo encodeInfo) throws ExecutionException, InterruptedException {
            AbstractC13042fc3.i(videoFrame, "frame");
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.mD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.m(this.a, videoFrame, encodeInfo);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoCodecStatus) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoEncoder.EncoderInfo getEncoderInfo() throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.hD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.n(this.a);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoEncoder.EncoderInfo) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public String getImplementationName() throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.fD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.o(this.a);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (String) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoEncoder.ResolutionBitrateLimits[] getResolutionBitrateLimits() throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.gD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.p(this.a);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoEncoder.ResolutionBitrateLimits[]) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoEncoder.ScalingSettings getScalingSettings() throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.dD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.q(this.a);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoEncoder.ScalingSettings) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoCodecStatus initEncode(final VideoEncoder.Settings settings, final VideoEncoder.Callback callback) throws ExecutionException, InterruptedException {
            AbstractC13042fc3.i(settings, "settings");
            this.c = settings;
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.nD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.r(this.a, settings, callback);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoCodecStatus) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public boolean isHardwareEncoder() throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.kD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.s(this.a);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return ((Boolean) obj).booleanValue();
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoCodecStatus release() throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.lD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.t(this.a);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoCodecStatus) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoCodecStatus setRateAllocation(final VideoEncoder.BitrateAllocation bitrateAllocation, final int i) throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.iD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.u(this.a, bitrateAllocation, i);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoCodecStatus) obj;
        }

        @Override // livekit.org.webrtc.VideoEncoder
        public VideoCodecStatus setRates(final VideoEncoder.RateControlParameters rateControlParameters) throws ExecutionException, InterruptedException {
            Object obj = this.b.submit(new Callable() { // from class: ir.nasim.eD6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return C10802cD6.c.v(this.a, rateControlParameters);
                }
            }).get();
            AbstractC13042fc3.h(obj, "get(...)");
            return (VideoCodecStatus) obj;
        }
    }

    /* renamed from: ir.nasim.cD6$d */
    private static final class d implements VideoEncoderFactory {
        private final VideoEncoderFactory a;

        public d(VideoEncoderFactory videoEncoderFactory) {
            AbstractC13042fc3.i(videoEncoderFactory, "factory");
            this.a = videoEncoderFactory;
        }

        @Override // livekit.org.webrtc.VideoEncoderFactory
        public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
            VideoEncoder videoEncoderCreateEncoder = this.a.createEncoder(videoCodecInfo);
            if (videoEncoderCreateEncoder == null) {
                return null;
            }
            return videoEncoderCreateEncoder instanceof WrappedNativeVideoEncoder ? videoEncoderCreateEncoder : new c(videoEncoderCreateEncoder);
        }

        @Override // livekit.org.webrtc.VideoEncoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            VideoCodecInfo[] supportedCodecs = this.a.getSupportedCodecs();
            AbstractC13042fc3.h(supportedCodecs, "getSupportedCodecs(...)");
            return supportedCodecs;
        }
    }

    public C10802cD6(EglBase.Context context, boolean z, boolean z2) {
        d dVar = new d(new HardwareVideoEncoderFactory(context, z, z2));
        this.a = dVar;
        d dVar2 = new d(new a(dVar));
        this.b = dVar2;
        this.c = new SimulcastVideoEncoderFactory(dVar, dVar2);
    }

    @Override // livekit.org.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        return this.c.createEncoder(videoCodecInfo);
    }

    @Override // livekit.org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        Map<String, String> map;
        VideoCodecInfo[] supportedCodecs = this.c.getSupportedCodecs();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        AbstractC13042fc3.f(supportedCodecs);
        for (VideoCodecInfo videoCodecInfo : supportedCodecs) {
            if (!AbstractC20153rZ6.D(videoCodecInfo.name, "vp9", true) || ((map = videoCodecInfo.params) != null && !map.isEmpty())) {
                b.a aVar = b.Companion;
                AbstractC13042fc3.f(videoCodecInfo);
                linkedHashSet.add(aVar.a(videoCodecInfo));
            }
        }
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(linkedHashSet, 10));
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((b) it.next()).a());
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[0]);
    }
}
