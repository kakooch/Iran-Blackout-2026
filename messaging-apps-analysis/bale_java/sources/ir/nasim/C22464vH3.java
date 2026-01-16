package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C16394lC0;
import ir.nasim.CS7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import livekit.LivekitRtc$SubscribedCodec;
import livekit.LivekitRtc$SubscribedQuality;
import livekit.org.webrtc.CameraEnumerator;
import livekit.org.webrtc.CameraVideoCapturer;
import livekit.org.webrtc.CapturerObserver;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.RtpSender;
import livekit.org.webrtc.RtpTransceiver;
import livekit.org.webrtc.Size;
import livekit.org.webrtc.SurfaceTextureHelper;
import livekit.org.webrtc.VideoCapturer;
import livekit.org.webrtc.VideoProcessor;
import livekit.org.webrtc.VideoSink;
import livekit.org.webrtc.VideoSource;
import livekit.org.webrtc.VideoTrack;

/* renamed from: ir.nasim.vH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C22464vH3 extends EV7 {
    static final /* synthetic */ InterfaceC5239Im3[] B = {AbstractC10882cM5.f(new C5942Lm4(C22464vH3.class, "options", "getOptions()Lio/livekit/android/room/track/LocalVideoTrackOptions;", 0))};
    public static final a Companion = new a(null);
    private final ZV0 A;
    private VideoSource m;
    private final PeerConnectionFactory n;
    private final Context o;
    private final EglBase p;
    private final C19977rG1 q;
    private final b r;
    private HF0 s;
    private VideoCapturer t;
    private VideoTrack u;
    private String v;
    private List w;
    private final Map x;
    private final C9927an4 y;
    private RtpTransceiver z;

    /* renamed from: ir.nasim.vH3$a */
    public static final class a {
        private a() {
        }

        public final C22464vH3 a(PeerConnectionFactory peerConnectionFactory, Context context, String str, C23060wH3 c23060wH3, EglBase eglBase, b bVar, VideoProcessor videoProcessor) {
            AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(c23060wH3, "options");
            AbstractC13042fc3.i(eglBase, "rootEglBase");
            AbstractC13042fc3.i(bVar, "trackFactory");
            if (AbstractC4043Dl1.a(context, "android.permission.CAMERA") != 0) {
                throw new SecurityException("Camera permissions are required to create a camera video track.");
            }
            XV4 xv4D = C16394lC0.a.d(context, c23060wH3);
            if (xv4D != null) {
                return b(peerConnectionFactory, context, str, (VideoCapturer) xv4D.a(), (C23060wH3) xv4D.b(), eglBase, bVar, videoProcessor);
            }
            throw new C22420vC4(null, 1, null);
        }

        public final C22464vH3 b(PeerConnectionFactory peerConnectionFactory, Context context, String str, VideoCapturer videoCapturer, C23060wH3 c23060wH3, EglBase eglBase, b bVar, VideoProcessor videoProcessor) {
            VideoProcessor videoProcessor2;
            HF0 hf0;
            AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(videoCapturer, "capturer");
            AbstractC13042fc3.i(c23060wH3, "options");
            AbstractC13042fc3.i(eglBase, "rootEglBase");
            AbstractC13042fc3.i(bVar, "trackFactory");
            VideoSource videoSourceCreateVideoSource = peerConnectionFactory.createVideoSource(c23060wH3.f());
            if (c23060wH3.c().a()) {
                C15454jc6 c15454jc6 = new C15454jc6(c23060wH3.c().d(), c23060wH3.c().b());
                c15454jc6.b(videoProcessor);
                videoProcessor2 = c15454jc6;
            } else {
                videoProcessor2 = videoProcessor;
            }
            videoSourceCreateVideoSource.setVideoProcessor(videoProcessor2);
            SurfaceTextureHelper surfaceTextureHelperCreate = SurfaceTextureHelper.create("VideoCaptureThread", eglBase.getEglBaseContext());
            if (videoProcessor == null) {
                hf0 = new HF0();
                CapturerObserver capturerObserver = videoSourceCreateVideoSource.getCapturerObserver();
                AbstractC13042fc3.h(capturerObserver, "getCapturerObserver(...)");
                hf0.a(capturerObserver);
            } else {
                hf0 = null;
            }
            HF0 hf02 = hf0;
            videoCapturer.initialize(surfaceTextureHelperCreate, context, hf02 != null ? hf02 : videoSourceCreateVideoSource.getCapturerObserver());
            VideoTrack videoTrackCreateVideoTrack = peerConnectionFactory.createVideoTrack(UUID.randomUUID().toString(), videoSourceCreateVideoSource);
            AbstractC13042fc3.f(videoSourceCreateVideoSource);
            AbstractC13042fc3.f(videoTrackCreateVideoTrack);
            C22464vH3 c22464vH3A = bVar.a(videoCapturer, videoSourceCreateVideoSource, str, c23060wH3, videoTrackCreateVideoTrack, hf02);
            c22464vH3A.A.b(videoTrackCreateVideoTrack, new C16313l37(surfaceTextureHelperCreate));
            return c22464vH3A;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vH3$b */
    public interface b {
        C22464vH3 a(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, HF0 hf0);
    }

    public /* synthetic */ C22464vH3(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, PeerConnectionFactory peerConnectionFactory, Context context, EglBase eglBase, C19977rG1 c19977rG1, b bVar, HF0 hf0, FF5 ff5, int i, ED1 ed1) {
        this(videoCapturer, videoSource, str, c23060wH3, videoTrack, peerConnectionFactory, context, eglBase, c19977rG1, bVar, (i & 1024) != 0 ? null : hf0, ff5);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void F(livekit.org.webrtc.RtpSender r13, java.util.List r14) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22464vH3.F(livekit.org.webrtc.RtpSender, java.util.List):void");
    }

    public static /* synthetic */ void K(C22464vH3 c22464vH3, String str, EnumC23021wD0 enumC23021wD0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchCamera");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            enumC23021wD0 = null;
        }
        c22464vH3.J(str, enumC23021wD0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(C22464vH3 c22464vH3, String str, C12889fL5 c12889fL5) {
        C23060wH3 c23060wH3A = c22464vH3.A();
        C16394lC0.a aVar = (C16394lC0.a) c12889fL5.a;
        c22464vH3.C(C23060wH3.b(c23060wH3A, false, str, aVar != null ? aVar.b() : null, null, 9, null));
    }

    public final C23060wH3 A() {
        return (C23060wH3) this.y.h(this, B[0]);
    }

    public final void B(String str) {
        this.v = str;
    }

    public final void C(C23060wH3 c23060wH3) {
        AbstractC13042fc3.i(c23060wH3, "<set-?>");
        this.y.i(this, B[0], c23060wH3);
    }

    public final List D(List list) {
        AbstractC13042fc3.i(list, "codecs");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "setting publishing codecs: " + list, new Object[0]);
        }
        if (this.v == null && (!list.isEmpty())) {
            List<LivekitRtc$SubscribedQuality> qualitiesList = ((LivekitRtc$SubscribedCodec) AbstractC15401jX0.q0(list)).getQualitiesList();
            AbstractC13042fc3.h(qualitiesList, "getQualitiesList(...)");
            E(qualitiesList);
            return AbstractC10360bX0.m();
        }
        this.w = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LivekitRtc$SubscribedCodec livekitRtc$SubscribedCodec = (LivekitRtc$SubscribedCodec) it.next();
            if (AbstractC13042fc3.d(this.v, livekitRtc$SubscribedCodec.getCodec())) {
                List<LivekitRtc$SubscribedQuality> qualitiesList2 = livekitRtc$SubscribedCodec.getQualitiesList();
                AbstractC13042fc3.h(qualitiesList2, "getQualitiesList(...)");
                E(qualitiesList2);
            } else {
                try {
                    CS7.a aVar2 = CS7.Companion;
                    String codec = livekitRtc$SubscribedCodec.getCodec();
                    AbstractC13042fc3.h(codec, "getCodec(...)");
                    CS7 cs7A = aVar2.a(codec);
                    AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
                    UI3 ui3 = UI3.b;
                    AbstractC6718Or3.a aVar4 = AbstractC6718Or3.Companion;
                    if (ui3.compareTo(aVar4.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                        AbstractC5270Ip7.d(null, "try setPublishingCodec for " + livekitRtc$SubscribedCodec.getCodec(), new Object[0]);
                    }
                    C10186bD6 c10186bD6 = (C10186bD6) this.x.get(cs7A);
                    if ((c10186bD6 != null ? c10186bD6.b() : null) == null) {
                        Iterator<LivekitRtc$SubscribedQuality> it2 = livekitRtc$SubscribedCodec.getQualitiesList().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            if (it2.next().getEnabled()) {
                                arrayList.add(cs7A);
                                break;
                            }
                        }
                    } else {
                        if (ui3.compareTo(aVar4.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.d(null, "try setPublishingLayersForSender " + livekitRtc$SubscribedCodec.getCodec(), new Object[0]);
                        }
                        RtpSender rtpSenderB = c10186bD6.b();
                        AbstractC13042fc3.f(rtpSenderB);
                        List<LivekitRtc$SubscribedQuality> qualitiesList3 = livekitRtc$SubscribedCodec.getQualitiesList();
                        AbstractC13042fc3.h(qualitiesList3, "getQualitiesList(...)");
                        F(rtpSenderB, qualitiesList3);
                    }
                } catch (Exception unused) {
                    AbstractC6718Or3.a aVar5 = AbstractC6718Or3.Companion;
                    if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                        AbstractC5270Ip7.l(null, "unknown publishing codec " + livekitRtc$SubscribedCodec.getCodec() + '!', new Object[0]);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void E(List list) {
        AbstractC13042fc3.i(list, "qualities");
        RtpTransceiver rtpTransceiver = this.z;
        RtpSender sender = rtpTransceiver != null ? rtpTransceiver.getSender() : null;
        if (sender == null) {
            return;
        }
        F(sender, list);
    }

    public final void G(RtpTransceiver rtpTransceiver) {
        this.z = rtpTransceiver;
    }

    public void H() {
        this.t.startCapture(A().c().d(), A().c().b(), A().c().c());
    }

    public void I() {
        this.t.stopCapture();
    }

    public final void J(String str, EnumC23021wD0 enumC23021wD0) {
        VideoCapturer videoCapturer = this.t;
        CameraVideoCapturer cameraVideoCapturer = videoCapturer instanceof CameraVideoCapturer ? (CameraVideoCapturer) videoCapturer : null;
        if (cameraVideoCapturer == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Attempting to switch camera on a non-camera video track!", new Object[0]);
            return;
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        C16394lC0 c16394lC0 = C16394lC0.a;
        CameraEnumerator cameraEnumeratorE = c16394lC0.e(this.o);
        if (str != null || enumC23021wD0 != null) {
            c12889fL5.a = c16394lC0.g(cameraEnumeratorE, str, enumC23021wD0, false);
        }
        if (c12889fL5.a == null) {
            String[] deviceNames = cameraEnumeratorE.getDeviceNames();
            if (deviceNames.length < 2) {
                AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                    return;
                }
                AbstractC5270Ip7.l(null, "No available cameras to switch to!", new Object[0]);
                return;
            }
            AbstractC13042fc3.f(deviceNames);
            c12889fL5.a = C16394lC0.h(c16394lC0, cameraEnumeratorE, deviceNames[(AbstractC10242bK.s0(deviceNames, A().d()) + 1) % deviceNames.length], null, false, 2, null);
        }
        C16394lC0.a aVar3 = (C16394lC0.a) c12889fL5.a;
        String strA = aVar3 != null ? aVar3.a() : null;
        c cVar = new c(cameraVideoCapturer, this, strA, c12889fL5);
        if (c12889fL5.a != null) {
            cameraVideoCapturer.switchCamera(cVar, strA);
            return;
        }
        AbstractC6718Or3.a aVar4 = AbstractC6718Or3.Companion;
        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.l(null, "No target camera found!", new Object[0]);
    }

    @Override // ir.nasim.AbstractC21649tt7
    public void a() {
        super.a();
        this.t.dispose();
        this.A.close();
    }

    @Override // ir.nasim.EV7, ir.nasim.AbstractC21649tt7
    public void q() {
        this.t.stopCapture();
        super.q();
    }

    @Override // ir.nasim.EV7
    public void r(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "renderer");
        HF0 hf0 = this.s;
        if (hf0 == null) {
            super.r(videoSink);
        } else if (hf0 != null) {
            hf0.b(videoSink);
        }
    }

    @Override // ir.nasim.EV7, ir.nasim.AbstractC21649tt7
    /* renamed from: s */
    public VideoTrack h() {
        return this.u;
    }

    @Override // ir.nasim.EV7
    public void u(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "renderer");
        HF0 hf0 = this.s;
        if (hf0 == null) {
            super.u(videoSink);
        } else if (hf0 != null) {
            hf0.c(videoSink);
        }
    }

    public final C10186bD6 x(CS7 cs7, List list) {
        AbstractC13042fc3.i(cs7, "codec");
        AbstractC13042fc3.i(list, "encodings");
        if (!this.x.containsKey(cs7)) {
            C10186bD6 c10186bD6 = new C10186bD6(cs7.j(), h(), null, list, 4, null);
            this.x.put(cs7, c10186bD6);
            return c10186bD6;
        }
        throw new IllegalStateException(cs7 + " already added!");
    }

    public final VideoCapturer y() {
        return this.t;
    }

    public final AbstractC21649tt7.e z() {
        VideoCapturer videoCapturer = this.t;
        BS7 bs7 = videoCapturer instanceof BS7 ? (BS7) videoCapturer : null;
        if (bs7 == null) {
            return new AbstractC21649tt7.e(A().c().d(), A().c().b());
        }
        Size sizeA = bs7.a(A().c().d(), A().c().b());
        return new AbstractC21649tt7.e(sizeA.width, sizeA.height);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22464vH3(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, PeerConnectionFactory peerConnectionFactory, Context context, EglBase eglBase, C19977rG1 c19977rG1, b bVar, HF0 hf0, FF5 ff5) {
        super(str, videoTrack, ff5);
        AbstractC13042fc3.i(videoCapturer, "capturer");
        AbstractC13042fc3.i(videoSource, "source");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(c23060wH3, "options");
        AbstractC13042fc3.i(videoTrack, "rtcTrack");
        AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(eglBase, "eglBase");
        AbstractC13042fc3.i(c19977rG1, "defaultsManager");
        AbstractC13042fc3.i(bVar, "trackFactory");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.m = videoSource;
        this.n = peerConnectionFactory;
        this.o = context;
        this.p = eglBase;
        this.q = c19977rG1;
        this.r = bVar;
        this.s = hf0;
        this.t = videoCapturer;
        this.u = videoTrack;
        this.x = new LinkedHashMap();
        this.y = AbstractC5508Jq2.c(c23060wH3, null, 2, null);
        this.A = new ZV0();
    }

    /* renamed from: ir.nasim.vH3$c */
    public static final class c implements CameraVideoCapturer.CameraSwitchHandler {
        final /* synthetic */ CameraVideoCapturer a;
        final /* synthetic */ C22464vH3 b;
        final /* synthetic */ String c;
        final /* synthetic */ C12889fL5 d;

        c(CameraVideoCapturer cameraVideoCapturer, C22464vH3 c22464vH3, String str, C12889fL5 c12889fL5) {
            this.a = cameraVideoCapturer;
            this.b = c22464vH3;
            this.c = str;
            this.d = c12889fL5;
        }

        @Override // livekit.org.webrtc.CameraVideoCapturer.CameraSwitchHandler
        public void onCameraSwitchDone(boolean z) {
            VideoCapturer videoCapturer = this.a;
            if (videoCapturer instanceof AbstractC16985mC0) {
                ((AbstractC16985mC0) videoCapturer).b().a(new a(this.a, this.b, this.c, this.d));
            } else {
                C22464vH3.L(this.b, this.c, this.d);
            }
        }

        @Override // livekit.org.webrtc.CameraVideoCapturer.CameraSwitchHandler
        public void onCameraSwitchError(String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "switching camera failed: " + str, new Object[0]);
        }

        /* renamed from: ir.nasim.vH3$c$a */
        public static final class a implements CameraVideoCapturer.CameraEventsHandler {
            final /* synthetic */ CameraVideoCapturer a;
            final /* synthetic */ C22464vH3 b;
            final /* synthetic */ String c;
            final /* synthetic */ C12889fL5 d;

            a(CameraVideoCapturer cameraVideoCapturer, C22464vH3 c22464vH3, String str, C12889fL5 c12889fL5) {
                this.a = cameraVideoCapturer;
                this.b = c22464vH3;
                this.c = str;
                this.d = c12889fL5;
            }

            @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraClosed() {
                ((AbstractC16985mC0) this.a).b().b(this);
            }

            @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraDisconnected() {
                ((AbstractC16985mC0) this.a).b().b(this);
            }

            @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraError(String str) {
                ((AbstractC16985mC0) this.a).b().b(this);
            }

            @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onFirstFrameAvailable() {
                C22464vH3.L(this.b, this.c, this.d);
                ((AbstractC16985mC0) this.a).b().b(this);
            }

            @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraFreezed(String str) {
            }

            @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
            public void onCameraOpening(String str) {
            }
        }
    }
}
