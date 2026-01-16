package ir.nasim;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import ir.nasim.TN;
import java.util.Iterator;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes5.dex */
public abstract class TN {
    public static final c d = new c(null);
    public static final int e = 8;
    private final AudioManager a;
    private boolean b;
    private final AudioManager.OnAudioFocusChangeListener c;

    private static final class a extends TN {
        public static final C0649a f = new C0649a(null);
        private static final AudioAttributes g = new AudioAttributes.Builder().setContentType(1).setUsage(2).setLegacyStreamType(0).build();

        /* renamed from: ir.nasim.TN$a$a, reason: collision with other inner class name */
        public static final class C0649a {
            private C0649a() {
            }

            public /* synthetic */ C0649a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context, null);
            AbstractC13042fc3.i(context, "context");
        }

        @Override // ir.nasim.TN
        public void b() {
            int iAbandonAudioFocus;
            if (!e() || (iAbandonAudioFocus = d().abandonAudioFocus(f())) == 1) {
                return;
            }
            C19406qI3.j("AudioManagerCompat.class", "abandonCallAudioFocus: Audio focus abandon failed. Result code: " + iAbandonAudioFocus, new Object[0]);
        }

        @Override // ir.nasim.TN
        public SoundPool c() {
            SoundPool soundPoolBuild = new SoundPool.Builder().setAudioAttributes(g).setMaxStreams(1).build();
            AbstractC13042fc3.h(soundPoolBuild, "build(...)");
            return soundPoolBuild;
        }

        @Override // ir.nasim.TN
        public boolean l() {
            int iRequestAudioFocus = d().requestAudioFocus(f(), 0, 4);
            if (iRequestAudioFocus == 1) {
                return true;
            }
            C19406qI3.j("AudioManagerCompat.class", "requestCallAudioFocus: Audio focus not granted. Result code: " + iRequestAudioFocus, new Object[0]);
            return false;
        }

        @Override // ir.nasim.TN
        public boolean m() {
            int iRequestAudioFocus = d().requestAudioFocus(f(), 2, 4);
            if (iRequestAudioFocus == 1) {
                return true;
            }
            C19406qI3.j("AudioManagerCompat.class", "requestRingtoneAudioFocus: Audio focus not granted. Result code: " + iRequestAudioFocus, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends TN {
        public static final a g = new a(null);
        private static final InterfaceC9173Yu3 h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UN
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TN.b.w();
            }
        });
        private static final InterfaceC9173Yu3 i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VN
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TN.b.v();
            }
        });
        private AudioFocusRequest f;

        public static final class a {
            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AudioAttributes c() {
                return (AudioAttributes) b.i.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AudioAttributes d() {
                return (AudioAttributes) b.h.getValue();
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context, null);
            AbstractC13042fc3.i(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AudioAttributes v() {
            return new AudioAttributes.Builder().setContentType(4).setUsage(6).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AudioAttributes w() {
            return new AudioAttributes.Builder().setContentType(1).setUsage(2).build();
        }

        @Override // ir.nasim.TN
        public void b() {
            int iAbandonAudioFocusRequest;
            AudioFocusRequest audioFocusRequest = this.f;
            if (audioFocusRequest != null && (iAbandonAudioFocusRequest = d().abandonAudioFocusRequest(audioFocusRequest)) != 1) {
                C19406qI3.j("AudioManagerCompat.class", "audioFocusRequest: Audio focus abandon failed. Result code: " + iAbandonAudioFocusRequest, new Object[0]);
            }
            this.f = null;
        }

        @Override // ir.nasim.TN
        public SoundPool c() {
            SoundPool soundPoolBuild = new SoundPool.Builder().setAudioAttributes(g.d()).setMaxStreams(1).build();
            AbstractC13042fc3.h(soundPoolBuild, "build(...)");
            return soundPoolBuild;
        }

        @Override // ir.nasim.TN
        public boolean l() {
            this.f = BN.a(4).setAudioAttributes(g.d()).setOnAudioFocusChangeListener(f()).build();
            AudioManager audioManagerD = d();
            AudioFocusRequest audioFocusRequest = this.f;
            AbstractC13042fc3.f(audioFocusRequest);
            int iRequestAudioFocus = audioManagerD.requestAudioFocus(audioFocusRequest);
            if (iRequestAudioFocus == 1) {
                return true;
            }
            C19406qI3.j("AudioManagerCompat.class", "Audio focus not granted. Result code: " + iRequestAudioFocus, new Object[0]);
            return false;
        }

        @Override // ir.nasim.TN
        public boolean m() {
            this.f = BN.a(4).setAudioAttributes(g.c()).setOnAudioFocusChangeListener(f()).build();
            AudioManager audioManagerD = d();
            AudioFocusRequest audioFocusRequest = this.f;
            AbstractC13042fc3.f(audioFocusRequest);
            int iRequestAudioFocus = audioManagerD.requestAudioFocus(audioFocusRequest);
            if (iRequestAudioFocus == 1) {
                return true;
            }
            C19406qI3.j("AudioManagerCompat.class", "requestRingtoneAudioFocus: Audio focus not granted. Result code: " + iRequestAudioFocus, new Object[0]);
            return false;
        }
    }

    public static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float c(int i, int i2) {
            if (i2 == 0 || i > i2) {
                return 0.5f;
            }
            return (float) (1 - (Math.log(r7 - i) / Math.log(i2 + 1)));
        }

        public final TN b(Context context) {
            AbstractC13042fc3.i(context, "context");
            return Build.VERSION.SDK_INT >= 26 ? new b(context) : new a(context);
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ TN(Context context, ED1 ed1) {
        this(context);
    }

    private final void i(boolean z) {
        this.a.setSpeakerphoneOn(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TN tn, int i) {
        AbstractC13042fc3.i(tn, "this$0");
        C19406qI3.a("AudioManagerCompat.class", "onAudioFocusChangeListener: " + i, new Object[0]);
        tn.b = i == 1;
    }

    public abstract void b();

    public abstract SoundPool c();

    public final AudioManager d() {
        return this.a;
    }

    protected final boolean e() {
        return this.b;
    }

    protected final AudioManager.OnAudioFocusChangeListener f() {
        return this.c;
    }

    public final boolean g() {
        return this.a.isBluetoothScoAvailableOffCall();
    }

    public final boolean h() {
        AudioDeviceInfo[] devices = this.a.getDevices(2);
        AbstractC13042fc3.h(devices, "getDevices(...)");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        Iterator itA = DJ.a(this.a.getDevices(3));
        while (itA.hasNext()) {
            int type = ((AudioDeviceInfo) itA.next()).getType();
            if (type == 3 || type == 11) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean l();

    public abstract boolean m();

    public final float n() {
        int streamVolume = this.a.getStreamVolume(2);
        int streamMaxVolume = this.a.getStreamMaxVolume(2);
        c cVar = d;
        return AbstractC23053wG5.d(cVar.c(streamVolume, streamMaxVolume), cVar.c(15, 100));
    }

    public final void o(boolean z) {
        this.a.setBluetoothScoOn(z);
    }

    public final void p(int i) {
        this.a.setMode(i);
    }

    public final void q(boolean z) {
        i(z);
    }

    public final void r() {
        this.a.startBluetoothSco();
    }

    public final void s() {
        this.a.stopBluetoothSco();
    }

    private TN(Context context) {
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.a = (AudioManager) systemService;
        this.c = new AudioManager.OnAudioFocusChangeListener() { // from class: ir.nasim.SN
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                TN.k(this.a, i);
            }
        };
    }
}
