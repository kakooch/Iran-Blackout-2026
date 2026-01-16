package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.util.DisplayMetrics;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C22464vH3;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.ScreenCapturerAndroid;
import livekit.org.webrtc.SurfaceTextureHelper;
import livekit.org.webrtc.VideoCapturer;
import livekit.org.webrtc.VideoProcessor;
import livekit.org.webrtc.VideoSource;
import livekit.org.webrtc.VideoTrack;

/* renamed from: ir.nasim.dH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11599dH3 extends C22464vH3 {
    public static final b Companion = new b(null);
    private int C;
    private int D;
    private final DisplayMetrics E;
    private final WindowManager F;
    private final e G;
    private final io.livekit.android.room.track.screencapture.a H;

    /* renamed from: ir.nasim.dH3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(AbstractC21649tt7 abstractC21649tt7) {
            AbstractC13042fc3.i(abstractC21649tt7, "it");
            C11599dH3.this.q();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21649tt7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dH3$b */
    public static final class b {
        private b() {
        }

        private final ScreenCapturerAndroid a(Intent intent, d dVar) {
            return new ScreenCapturerAndroid(intent, dVar);
        }

        public final C11599dH3 b(Intent intent, PeerConnectionFactory peerConnectionFactory, Context context, String str, C23060wH3 c23060wH3, EglBase eglBase, c cVar, VideoProcessor videoProcessor, UA2 ua2) {
            AbstractC13042fc3.i(intent, "mediaProjectionPermissionResultData");
            AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(c23060wH3, "options");
            AbstractC13042fc3.i(eglBase, "rootEglBase");
            AbstractC13042fc3.i(cVar, "screencastVideoTrackFactory");
            AbstractC13042fc3.i(ua2, "onStop");
            VideoSource videoSourceCreateVideoSource = peerConnectionFactory.createVideoSource(c23060wH3.f());
            videoSourceCreateVideoSource.setVideoProcessor(videoProcessor);
            d dVar = new d();
            dVar.a(ua2);
            ScreenCapturerAndroid screenCapturerAndroidA = a(intent, dVar);
            screenCapturerAndroidA.initialize(SurfaceTextureHelper.create("ScreenVideoCaptureThread", eglBase.getEglBaseContext()), context, videoSourceCreateVideoSource.getCapturerObserver());
            VideoTrack videoTrackCreateVideoTrack = peerConnectionFactory.createVideoTrack(UUID.randomUUID().toString(), videoSourceCreateVideoSource);
            AbstractC13042fc3.f(videoSourceCreateVideoSource);
            AbstractC13042fc3.f(videoTrackCreateVideoTrack);
            return cVar.a(screenCapturerAndroidA, videoSourceCreateVideoSource, str, c23060wH3, videoTrackCreateVideoTrack, dVar);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dH3$c */
    public interface c {
        C11599dH3 a(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, d dVar);
    }

    /* renamed from: ir.nasim.dH3$d */
    public static final class d extends MediaProjection.Callback {
        private AbstractC21649tt7 a;
        private final List b = new ArrayList();

        public final void a(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "callback");
            this.b.add(ua2);
        }

        public final void b(AbstractC21649tt7 abstractC21649tt7) {
            this.a = abstractC21649tt7;
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            for (UA2 ua2 : this.b) {
                AbstractC21649tt7 abstractC21649tt7 = this.a;
                AbstractC13042fc3.f(abstractC21649tt7);
                ua2.invoke(abstractC21649tt7);
            }
        }
    }

    /* renamed from: ir.nasim.dH3$e */
    public static final class e extends OrientationEventListener {
        final /* synthetic */ C11599dH3 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Context context, C11599dH3 c11599dH3) {
            super(context);
            this.a = c11599dH3;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (this.a.j()) {
                disable();
            } else {
                this.a.P();
            }
        }
    }

    /* renamed from: ir.nasim.dH3$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C11599dH3.this.O(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11599dH3(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, d dVar, PeerConnectionFactory peerConnectionFactory, Context context, EglBase eglBase, C19977rG1 c19977rG1, C22464vH3.b bVar, FF5 ff5) {
        super(videoCapturer, videoSource, str, c23060wH3, videoTrack, peerConnectionFactory, context, eglBase, c19977rG1, bVar, null, ff5, 1024, null);
        AbstractC13042fc3.i(videoCapturer, "capturer");
        AbstractC13042fc3.i(videoSource, "source");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(c23060wH3, "options");
        AbstractC13042fc3.i(videoTrack, "rtcTrack");
        AbstractC13042fc3.i(dVar, "mediaProjectionCallback");
        AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(eglBase, "eglBase");
        AbstractC13042fc3.i(c19977rG1, "defaultsManager");
        AbstractC13042fc3.i(bVar, "videoTrackFactory");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.E = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.F = (WindowManager) systemService;
        this.G = new e(context, this);
        this.H = new io.livekit.android.room.track.screencapture.a(context);
        dVar.b(this);
        dVar.a(new a());
    }

    private final XV4 N(int i, int i2) {
        if (A().c().d() != 0 || A().c().b() != 0) {
            if (i > i2) {
                i = A().c().d();
                i2 = A().c().b();
            } else {
                i = A().c().b();
                i2 = A().c().d();
            }
        }
        return AbstractC4616Fw7.a(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        this.F.getDefaultDisplay().getRealMetrics(this.E);
        DisplayMetrics displayMetrics = this.E;
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i == this.C && i2 == this.D) {
            return;
        }
        this.C = i;
        this.D = i2;
        XV4 xv4N = N(i, i2);
        try {
            y().changeCaptureFormat(((Number) xv4N.a()).intValue(), ((Number) xv4N.b()).intValue(), A().c().c());
        } catch (Exception e2) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(e2, "Exception when changing capture format of the screen share track.", new Object[0]);
        }
    }

    @Override // ir.nasim.C22464vH3
    public void H() {
        this.F.getDefaultDisplay().getRealMetrics(this.E);
        DisplayMetrics displayMetrics = this.E;
        XV4 xv4N = N(displayMetrics.widthPixels, displayMetrics.heightPixels);
        y().startCapture(((Number) xv4N.a()).intValue(), ((Number) xv4N.b()).intValue(), A().c().c());
        if (this.G.canDetectOrientation()) {
            this.G.enable();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(java.lang.Integer r5, android.app.Notification r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C11599dH3.f
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.dH3$f r0 = (ir.nasim.C11599dH3.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.dH3$f r0 = new ir.nasim.dH3$f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.c
            r6 = r5
            android.app.Notification r6 = (android.app.Notification) r6
            java.lang.Object r5 = r0.b
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r0 = r0.a
            ir.nasim.dH3 r0 = (ir.nasim.C11599dH3) r0
            ir.nasim.AbstractC10685c16.b(r7)
            goto L53
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            ir.nasim.AbstractC10685c16.b(r7)
            io.livekit.android.room.track.screencapture.a r7 = r4.H
            r0.a = r4
            r0.b = r5
            r0.c = r6
            r0.f = r3
            java.lang.Object r7 = r7.e(r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            r0 = r4
        L53:
            io.livekit.android.room.track.screencapture.a r7 = r0.H
            r7.h(r5, r6)
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11599dH3.O(java.lang.Integer, android.app.Notification, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.C22464vH3, ir.nasim.EV7, ir.nasim.AbstractC21649tt7
    public void q() {
        super.q();
        this.H.i();
        this.G.disable();
    }
}
