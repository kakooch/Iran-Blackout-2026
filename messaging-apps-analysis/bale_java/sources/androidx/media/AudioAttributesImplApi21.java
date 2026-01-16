package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

/* loaded from: classes2.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public AudioAttributes a;
    public int b;

    static class a implements AudioAttributesImpl.a {
        final AudioAttributes.Builder a = new AudioAttributes.Builder();

        a() {
        }

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl a() {
            return new AudioAttributesImplApi21(this.a.build());
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a c(int i) {
            this.a.setContentType(i);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(int i) {
            if (i == 16) {
                i = 12;
            }
            this.a.setUsage(i);
            return this;
        }
    }

    public AudioAttributesImplApi21() {
        this.b = -1;
    }

    public int a() {
        return this.a.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object b() {
        return this.a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        int i = this.b;
        return i != -1 ? i : AudioAttributesCompat.a(false, a(), d());
    }

    public int d() {
        return this.a.getUsage();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.a.equals(((AudioAttributesImplApi21) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.a;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i) {
        this.a = audioAttributes;
        this.b = i;
    }
}
