package ir.nasim;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import ir.nasim.database.dailogLists.DialogEntity;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.pu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19178pu4 implements InterfaceC17996nu4 {
    private final Context a;
    private SoundPool b;
    private final int[] c;
    private AudioManager d;

    public C19178pu4(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.c = new int[5];
    }

    private final void c() {
        this.b = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(5).setContentType(4).build()).build();
    }

    private final void d() {
        c();
        e();
    }

    private final void e() {
        int[] iArr = this.c;
        SoundPool soundPool = this.b;
        iArr[0] = soundPool != null ? soundPool.load(this.a, AbstractC19954rD5.in_message, 0) : 0;
        int[] iArr2 = this.c;
        SoundPool soundPool2 = this.b;
        iArr2[1] = soundPool2 != null ? soundPool2.load(this.a, AbstractC19954rD5.out_message, 0) : 0;
        int[] iArr3 = this.c;
        SoundPool soundPool3 = this.b;
        iArr3[2] = soundPool3 != null ? soundPool3.load(this.a, AbstractC19954rD5.send_sticker, 0) : 0;
        int[] iArr4 = this.c;
        SoundPool soundPool4 = this.b;
        iArr4[3] = soundPool4 != null ? soundPool4.load(this.a, AbstractC19954rD5.voice_start, 0) : 0;
        int[] iArr5 = this.c;
        SoundPool soundPool5 = this.b;
        iArr5[4] = soundPool5 != null ? soundPool5.load(this.a, AbstractC19954rD5.voice_stop, 0) : 0;
    }

    private final boolean f(J44 j44) {
        return j44.U() == AbstractC5969Lp4.f();
    }

    private final boolean g(J44 j44) {
        return j44.U() == AbstractC5969Lp4.f() && j44.L() == EnumC23558x74.SENT && !(j44.F() instanceof JM6);
    }

    private final boolean h(J44 j44) {
        return (j44.U() == AbstractC5969Lp4.f() || (j44.F() instanceof JM6)) ? false : true;
    }

    private final boolean i(J44 j44) {
        return (j44.F() instanceof JM6) && j44.L() != EnumC23558x74.PENDING;
    }

    private final boolean j(J44 j44) {
        return f(j44) && (j44.F() instanceof J08) && j44.L() == EnumC23558x74.PENDING;
    }

    @Override // ir.nasim.InterfaceC17996nu4
    public void a() {
        AudioManager audioManager = this.d;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getStreamVolume(3)) : null;
        if (numValueOf != null) {
            fIntValue = numValueOf.intValue() / (this.d != null ? r3.getStreamMaxVolume(3) : 0.0f);
        }
        float f = fIntValue;
        SoundPool soundPool = this.b;
        if (soundPool != null) {
            soundPool.play(this.c[3], f, f, 0, 0, 1.0f);
        }
    }

    @Override // ir.nasim.InterfaceC17996nu4
    public void b(J44 j44) {
        SoundPool soundPool;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AudioManager audioManager = this.d;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getStreamVolume(3)) : null;
        if (numValueOf != null) {
            fIntValue = numValueOf.intValue() / (this.d != null ? r3.getStreamMaxVolume(3) : 0.0f);
        }
        float f = fIntValue;
        if (j44.g0()) {
            return;
        }
        if (i(j44)) {
            SoundPool soundPool2 = this.b;
            if (soundPool2 != null) {
                soundPool2.play(this.c[2], f, f, 0, 0, 1.0f);
                return;
            }
            return;
        }
        if (j(j44)) {
            SoundPool soundPool3 = this.b;
            if (soundPool3 != null) {
                soundPool3.play(this.c[4], f, f, 0, 0, 1.0f);
                return;
            }
            return;
        }
        if (g(j44)) {
            SoundPool soundPool4 = this.b;
            if (soundPool4 != null) {
                soundPool4.play(this.c[1], f, f, 0, 0, 1.0f);
                return;
            }
            return;
        }
        if (!h(j44) || (soundPool = this.b) == null) {
            return;
        }
        soundPool.play(this.c[0], f, f, 0, 0, 1.0f);
    }

    @Override // ir.nasim.InterfaceC17996nu4
    public void initialize() {
        Object systemService = this.a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.d = (AudioManager) systemService;
        d();
    }

    @Override // ir.nasim.InterfaceC17996nu4
    public void release() {
        SoundPool soundPool = this.b;
        if (soundPool != null) {
            soundPool.release();
        }
        this.b = null;
        this.d = null;
    }
}
