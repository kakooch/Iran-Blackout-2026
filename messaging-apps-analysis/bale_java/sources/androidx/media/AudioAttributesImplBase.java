package androidx.media;

import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {
    public int a;
    public int b;
    public int c;
    public int d;

    static class a implements AudioAttributesImpl.a {
        private int a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;

        a() {
        }

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl a() {
            return new AudioAttributesImplBase(this.b, this.c, this.a, this.d);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a c(int i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
                this.b = i;
            } else {
                this.b = 0;
            }
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.a = i;
                    return this;
                case 16:
                    this.a = 12;
                    return this;
                default:
                    this.a = 0;
                    return this;
            }
        }
    }

    public AudioAttributesImplBase() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = -1;
    }

    public int a() {
        return this.b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object b() {
        return null;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        int i = this.d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.c, this.a);
    }

    public int d() {
        int i = this.c;
        int iC = c();
        if (iC == 6) {
            i |= 4;
        } else if (iC == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.b == audioAttributesImplBase.a() && this.c == audioAttributesImplBase.d() && this.a == audioAttributesImplBase.e() && this.d == audioAttributesImplBase.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.a), Integer.valueOf(this.d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.e(this.a));
        sb.append(" content=");
        sb.append(this.b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }

    AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.a = i3;
        this.d = i4;
    }
}
