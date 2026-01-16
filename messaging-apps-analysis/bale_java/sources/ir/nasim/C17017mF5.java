package ir.nasim;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import ir.nasim.AbstractC6718Or3;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import livekit.org.webrtc.AudioProcessingFactory;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.Loggable;
import livekit.org.webrtc.Logging;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.RtpCapabilities;
import livekit.org.webrtc.SoftwareVideoDecoderFactory;
import livekit.org.webrtc.SoftwareVideoEncoderFactory;
import livekit.org.webrtc.VideoDecoderFactory;
import livekit.org.webrtc.VideoEncoderFactory;
import livekit.org.webrtc.audio.AudioDeviceModule;
import livekit.org.webrtc.audio.JavaAudioDeviceModule;

/* renamed from: ir.nasim.mF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17017mF5 {
    public static final C17017mF5 a = new C17017mF5();
    private static boolean b;

    /* renamed from: ir.nasim.mF5$a */
    public static final class a implements JavaAudioDeviceModule.AudioRecordErrorCallback {
        a() {
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
        public void onWebRtcAudioRecordError(String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "onWebRtcAudioRecordError: " + str, new Object[0]);
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
        public void onWebRtcAudioRecordInitError(String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "onWebRtcAudioRecordInitError: " + str, new Object[0]);
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
        public void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "onWebRtcAudioRecordStartError: " + audioRecordStartErrorCode + ". " + str, new Object[0]);
        }
    }

    /* renamed from: ir.nasim.mF5$b */
    public static final class b implements JavaAudioDeviceModule.AudioRecordStateCallback {
        b() {
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioRecordStateCallback
        public void onWebRtcAudioRecordStart() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.k(null, "Audio recording starts", new Object[0]);
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioRecordStateCallback
        public void onWebRtcAudioRecordStop() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.k(null, "Audio recording stops", new Object[0]);
        }
    }

    /* renamed from: ir.nasim.mF5$c */
    public static final class c implements JavaAudioDeviceModule.AudioTrackErrorCallback {
        c() {
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
        public void onWebRtcAudioTrackError(String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "onWebRtcAudioTrackError: " + str, new Object[0]);
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
        public void onWebRtcAudioTrackInitError(String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "onWebRtcAudioTrackInitError: " + str, new Object[0]);
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
        public void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "onWebRtcAudioTrackStartError: " + audioTrackStartErrorCode + ". " + str, new Object[0]);
        }
    }

    /* renamed from: ir.nasim.mF5$d */
    public static final class d implements JavaAudioDeviceModule.AudioTrackStateCallback {
        final /* synthetic */ InterfaceC10670c01 a;

        d(InterfaceC10670c01 interfaceC10670c01) {
            this.a = interfaceC10670c01;
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioTrackStateCallback
        public void onWebRtcAudioTrackStart() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "Audio playout starts", new Object[0]);
            }
            this.a.b();
        }

        @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioTrackStateCallback
        public void onWebRtcAudioTrackStop() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "Audio playout stops", new Object[0]);
            }
            this.a.a();
        }
    }

    /* renamed from: ir.nasim.mF5$e */
    public static final class e implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ Context b;

        public e(FF5 ff5, Context context) {
            this.a = ff5;
            this.b = context;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (!C17017mF5.b) {
                C17017mF5.b = true;
                PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(this.b).setNativeLibraryName("lkjingle_peerconnection_so").setInjectableLogger(f.a, Logging.Severity.LS_VERBOSE).createInitializationOptions());
            }
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mF5$f */
    static final class f implements Loggable {
        public static final f a = new f();

        /* renamed from: ir.nasim.mF5$f$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Logging.Severity.values().length];
                try {
                    iArr[Logging.Severity.LS_VERBOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Logging.Severity.LS_INFO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Logging.Severity.LS_WARNING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Logging.Severity.LS_ERROR.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        f() {
        }

        @Override // livekit.org.webrtc.Loggable
        public final void onLogMessage(String str, Logging.Severity severity, String str2) {
            if (UC3.c()) {
                int i = severity == null ? -1 : a.a[severity.ordinal()];
                UI3 ui3 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? UI3.g : UI3.e : UI3.d : UI3.c : UI3.a;
                if (ui3.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                    return;
                }
                AbstractC5270Ip7.h(ui3.j(), str2 + ": " + str, new Object[0]);
            }
        }
    }

    /* renamed from: ir.nasim.mF5$g */
    public static final class g implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ AudioDeviceModule b;
        final /* synthetic */ AudioProcessingFactory c;
        final /* synthetic */ VideoEncoderFactory d;
        final /* synthetic */ VideoDecoderFactory e;
        final /* synthetic */ PeerConnectionFactory.Options f;
        final /* synthetic */ ZV0 g;

        public g(FF5 ff5, AudioDeviceModule audioDeviceModule, AudioProcessingFactory audioProcessingFactory, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, PeerConnectionFactory.Options options, ZV0 zv0) {
            this.a = ff5;
            this.b = audioDeviceModule;
            this.c = audioProcessingFactory;
            this.d = videoEncoderFactory;
            this.e = videoDecoderFactory;
            this.f = options;
            this.g = zv0;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            PeerConnectionFactory.Builder videoDecoderFactory = PeerConnectionFactory.builder().setAudioDeviceModule(this.b).setAudioProcessingFactory(this.c).setVideoEncoderFactory(this.d).setVideoDecoderFactory(this.e);
            PeerConnectionFactory.Options options = this.f;
            if (options != null) {
                videoDecoderFactory.setOptions(options);
            }
            PeerConnectionFactory peerConnectionFactoryCreatePeerConnectionFactory = videoDecoderFactory.createPeerConnectionFactory();
            AbstractC13042fc3.f(peerConnectionFactoryCreatePeerConnectionFactory);
            C24689z25 c24689z25 = new C24689z25(peerConnectionFactoryCreatePeerConnectionFactory);
            this.g.a(new h(c24689z25));
            return c24689z25;
        }
    }

    /* renamed from: ir.nasim.mF5$h */
    static final class h implements Closeable {
        final /* synthetic */ C24689z25 a;

        /* renamed from: ir.nasim.mF5$h$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C24689z25 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24689z25 c24689z25) {
                super(0);
                this.e = c24689z25;
            }

            public final void a() {
                this.e.a();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        h(C24689z25 c24689z25) {
            this.a = c24689z25;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            IF5.d(new GF5(this.a), new a(this.a));
        }
    }

    /* renamed from: ir.nasim.mF5$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ PeerConnectionFactory e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(PeerConnectionFactory peerConnectionFactory) {
            super(1);
            this.e = peerConnectionFactory;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RtpCapabilities invoke(MediaStreamTrack.MediaType mediaType) {
            AbstractC13042fc3.i(mediaType, "mediaType");
            RtpCapabilities rtpSenderCapabilities = this.e.getRtpSenderCapabilities(mediaType);
            AbstractC13042fc3.h(rtpSenderCapabilities, "getRtpSenderCapabilities(...)");
            return rtpSenderCapabilities;
        }
    }

    private C17017mF5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(JavaAudioDeviceModule javaAudioDeviceModule) {
        javaAudioDeviceModule.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(EglBase eglBase) {
        eglBase.release();
    }

    public final AudioDeviceModule e(AudioDeviceModule audioDeviceModule, UA2 ua2, AudioAttributes audioAttributes, Context context, ZV0 zv0, InterfaceC10670c01 interfaceC10670c01, JO jo, QM qm) {
        AbstractC13042fc3.i(audioAttributes, "audioOutputAttributes");
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(zv0, "closeableManager");
        AbstractC13042fc3.i(interfaceC10670c01, "communicationWorkaround");
        AbstractC13042fc3.i(jo, "audioRecordSamplesDispatcher");
        AbstractC13042fc3.i(qm, "audioBufferCallbackDispatcher");
        if (audioDeviceModule != null) {
            return audioDeviceModule;
        }
        a aVar = new a();
        c cVar = new c();
        b bVar = new b();
        d dVar = new d(interfaceC10670c01);
        boolean z = Build.VERSION.SDK_INT >= 29;
        JavaAudioDeviceModule.Builder audioBufferCallback = JavaAudioDeviceModule.builder(context).setUseHardwareAcousticEchoCanceler(z).setUseHardwareNoiseSuppressor(z).setAudioRecordErrorCallback(aVar).setAudioTrackErrorCallback(cVar).setAudioRecordStateCallback(bVar).setAudioTrackStateCallback(dVar).setSamplesReadyCallback(jo).setAudioSource(7).setAudioAttributes(audioAttributes).setAudioBufferCallback(qm);
        if (ua2 != null) {
            AbstractC13042fc3.f(audioBufferCallback);
            ua2.invoke(audioBufferCallback);
        }
        final JavaAudioDeviceModule javaAudioDeviceModuleCreateAudioDeviceModule = audioBufferCallback.createAudioDeviceModule();
        zv0.a(new Closeable() { // from class: ir.nasim.kF5
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                C17017mF5.f(javaAudioDeviceModuleCreateAudioDeviceModule);
            }
        });
        AbstractC13042fc3.h(javaAudioDeviceModuleCreateAudioDeviceModule, "apply(...)");
        return javaAudioDeviceModuleCreateAudioDeviceModule;
    }

    public final IO g(AudioDeviceModule audioDeviceModule) {
        AbstractC13042fc3.i(audioDeviceModule, "audioDeviceModule");
        return audioDeviceModule instanceof JavaAudioDeviceModule ? new C6628Oh3((JavaAudioDeviceModule) audioDeviceModule) : new BA4();
    }

    public final InterfaceC24893zO h(C7239Qw1 c7239Qw1) {
        AbstractC13042fc3.i(c7239Qw1, "customAudioProcessingFactory");
        return c7239Qw1;
    }

    public final AudioProcessingFactory i(C7239Qw1 c7239Qw1) {
        AbstractC13042fc3.i(c7239Qw1, "customAudioProcessingFactory");
        return c7239Qw1.f();
    }

    public final C7239Qw1 j(C8668Wy3 c8668Wy3, CO co) {
        AbstractC13042fc3.i(c8668Wy3, "webrtcInitialization");
        if (co == null) {
            co = new CO(null, false, null, false, 15, null);
        }
        return new C7239Qw1(co);
    }

    public final EglBase k(EglBase eglBase, ZV0 zv0) {
        AbstractC13042fc3.i(zv0, "memoryManager");
        if (eglBase != null) {
            return eglBase;
        }
        final EglBase eglBaseCreate = EglBase.create();
        zv0.a(new Closeable() { // from class: ir.nasim.lF5
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                C17017mF5.l(eglBaseCreate);
            }
        });
        AbstractC13042fc3.h(eglBaseCreate, "apply(...)");
        return eglBaseCreate;
    }

    public final EglBase.Context m(EglBase eglBase) {
        AbstractC13042fc3.i(eglBase, "eglBase");
        EglBase.Context eglBaseContext = eglBase.getEglBaseContext();
        AbstractC13042fc3.h(eglBaseContext, "getEglBaseContext(...)");
        return eglBaseContext;
    }

    public final C8668Wy3 n(Context context) throws ExecutionException, InterruptedException {
        AbstractC13042fc3.i(context, "appContext");
        if (!b) {
            C8954Xy3 c8954Xy3 = C8954Xy3.a;
            if (!c8954Xy3.a()) {
                String name = Thread.currentThread().getName();
                AbstractC13042fc3.h(name, "getName(...)");
                if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                    IF5.b.submit(new e(c8954Xy3, context)).get();
                } else if (!b) {
                    b = true;
                    PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setNativeLibraryName("lkjingle_peerconnection_so").setInjectableLogger(f.a, Logging.Severity.LS_VERBOSE).createInitializationOptions());
                }
            }
        }
        return C8668Wy3.a;
    }

    public final QM o() {
        return new QM();
    }

    public final JO p() {
        return new JO();
    }

    public final PeerConnectionFactory q(C24689z25 c24689z25) {
        AbstractC13042fc3.i(c24689z25, "peerConnectionFactoryManager");
        return c24689z25.b();
    }

    public final C24689z25 r(C8668Wy3 c8668Wy3, AudioDeviceModule audioDeviceModule, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, PeerConnectionFactory.Options options, ZV0 zv0, AudioProcessingFactory audioProcessingFactory) throws ExecutionException, InterruptedException {
        AbstractC13042fc3.i(c8668Wy3, "webrtcInitialization");
        AbstractC13042fc3.i(audioDeviceModule, "audioDeviceModule");
        AbstractC13042fc3.i(videoEncoderFactory, "videoEncoderFactory");
        AbstractC13042fc3.i(videoDecoderFactory, "videoDecoderFactory");
        AbstractC13042fc3.i(zv0, "memoryManager");
        AbstractC13042fc3.i(audioProcessingFactory, "audioProcessingFactory");
        C8954Xy3 c8954Xy3 = C8954Xy3.a;
        Object obj = null;
        if (!c8954Xy3.a()) {
            String name = Thread.currentThread().getName();
            AbstractC13042fc3.h(name, "getName(...)");
            if (AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                PeerConnectionFactory.Builder videoDecoderFactory2 = PeerConnectionFactory.builder().setAudioDeviceModule(audioDeviceModule).setAudioProcessingFactory(audioProcessingFactory).setVideoEncoderFactory(videoEncoderFactory).setVideoDecoderFactory(videoDecoderFactory);
                if (options != null) {
                    videoDecoderFactory2.setOptions(options);
                }
                PeerConnectionFactory peerConnectionFactoryCreatePeerConnectionFactory = videoDecoderFactory2.createPeerConnectionFactory();
                AbstractC13042fc3.f(peerConnectionFactoryCreatePeerConnectionFactory);
                C24689z25 c24689z25 = new C24689z25(peerConnectionFactoryCreatePeerConnectionFactory);
                zv0.a(new h(c24689z25));
                obj = c24689z25;
            } else {
                obj = IF5.b.submit(new g(c8954Xy3, audioDeviceModule, audioProcessingFactory, videoEncoderFactory, videoDecoderFactory, options, zv0)).get();
            }
        }
        AbstractC13042fc3.f(obj);
        return (C24689z25) obj;
    }

    public final FF5 s(C24689z25 c24689z25) {
        AbstractC13042fc3.i(c24689z25, "peerConnectionFactoryManager");
        return new GF5(c24689z25);
    }

    public final C25048ze6 t() {
        return C25048ze6.c();
    }

    public final UA2 u(PeerConnectionFactory peerConnectionFactory) {
        AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
        return new i(peerConnectionFactory);
    }

    public final VideoDecoderFactory v(C8668Wy3 c8668Wy3, boolean z, EglBase.Context context, VideoDecoderFactory videoDecoderFactory) {
        AbstractC13042fc3.i(c8668Wy3, "webrtcInitialization");
        AbstractC13042fc3.i(context, "eglContext");
        return videoDecoderFactory == null ? z ? new C5336Ix1(context, false, null, 6, null) : new SoftwareVideoDecoderFactory() : videoDecoderFactory;
    }

    public final VideoEncoderFactory w(C8668Wy3 c8668Wy3, boolean z, EglBase.Context context, VideoEncoderFactory videoEncoderFactory) {
        AbstractC13042fc3.i(c8668Wy3, "webrtcInitialization");
        AbstractC13042fc3.i(context, "eglContext");
        if (videoEncoderFactory != null) {
            return videoEncoderFactory;
        }
        if (!z) {
            return new SoftwareVideoEncoderFactory();
        }
        return new C5570Jx1(context, true, false, false, null, 24, null);
    }

    public final boolean x() {
        return true;
    }
}
