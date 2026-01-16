package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media.AudioAttributesCompat;
import ir.nasim.FG4;
import ir.nasim.FN;

/* loaded from: classes2.dex */
public class a {
    static final AudioAttributesCompat g = new AudioAttributesCompat.a().c(1).a();
    private final int a;
    private final AudioManager.OnAudioFocusChangeListener b;
    private final Handler c;
    private final AudioAttributesCompat d;
    private final boolean e;
    private final Object f;

    /* renamed from: androidx.media.a$a, reason: collision with other inner class name */
    private static class C0098a {
        static AudioFocusRequest a(int i, AudioAttributes audioAttributes, boolean z, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            return new AudioFocusRequest.Builder(i).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        }
    }

    public static final class b {
        private int a;
        private AudioManager.OnAudioFocusChangeListener b;
        private Handler c;
        private AudioAttributesCompat d = a.g;
        private boolean e;

        public b(int i) {
            d(i);
        }

        private static boolean b(int i) {
            return i == 1 || i == 2 || i == 3 || i == 4;
        }

        public a a() {
            if (this.b != null) {
                return new a(this.a, this.b, this.c, this.d, this.e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        public b c(AudioAttributesCompat audioAttributesCompat) {
            if (audioAttributesCompat == null) {
                throw new NullPointerException("Illegal null AudioAttributes");
            }
            this.d = audioAttributesCompat;
            return this;
        }

        public b d(int i) {
            if (b(i)) {
                this.a = i;
                return this;
            }
            throw new IllegalArgumentException("Illegal audio focus gain type " + i);
        }

        public b e(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
            return f(onAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
        }

        public b f(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            if (onAudioFocusChangeListener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            }
            if (handler == null) {
                throw new IllegalArgumentException("Handler must not be null");
            }
            this.b = onAudioFocusChangeListener;
            this.c = handler;
            return this;
        }

        public b g(boolean z) {
            this.e = z;
            return this;
        }
    }

    private static class c implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {
        private final Handler a;
        private final AudioManager.OnAudioFocusChangeListener b;

        c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.b = onAudioFocusChangeListener;
            this.a = new Handler(handler.getLooper(), this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 2782386) {
                return false;
            }
            this.b.onAudioFocusChange(message.arg1);
            return true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Handler handler = this.a;
            handler.sendMessage(Message.obtain(handler, 2782386, i, 0));
        }
    }

    a(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z) {
        this.a = i;
        this.c = handler;
        this.d = audioAttributesCompat;
        this.e = z;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 || handler.getLooper() == Looper.getMainLooper()) {
            this.b = onAudioFocusChangeListener;
        } else {
            this.b = new c(onAudioFocusChangeListener, handler);
        }
        if (i2 >= 26) {
            this.f = C0098a.a(i, a(), z, this.b, handler);
        } else {
            this.f = null;
        }
    }

    AudioAttributes a() {
        AudioAttributesCompat audioAttributesCompat = this.d;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.d();
        }
        return null;
    }

    public AudioAttributesCompat b() {
        return this.d;
    }

    AudioFocusRequest c() {
        return FN.a(this.f);
    }

    public int d() {
        return this.a;
    }

    public AudioManager.OnAudioFocusChangeListener e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.e == aVar.e && FG4.a(this.b, aVar.b) && FG4.a(this.c, aVar.c) && FG4.a(this.d, aVar.d);
    }

    public int hashCode() {
        return FG4.b(Integer.valueOf(this.a), this.b, this.c, this.d, Boolean.valueOf(this.e));
    }
}
