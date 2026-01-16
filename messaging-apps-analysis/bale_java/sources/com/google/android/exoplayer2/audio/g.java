package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.DefaultAudioSink;
import ir.nasim.AbstractC20159ra3;
import ir.nasim.AbstractC8236Vc3;
import ir.nasim.AbstractC9683aN7;
import java.math.RoundingMode;

/* loaded from: classes2.dex */
public class g implements DefaultAudioSink.e {
    protected final int b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;
    public final int g;

    public static class a {
        private int a = 250000;
        private int b = 750000;
        private int c = 4;
        private int d = 250000;
        private int e = 50000000;
        private int f = 2;

        public g g() {
            return new g(this);
        }
    }

    protected g(a aVar) {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
    }

    protected static int b(int i, int i2, int i3) {
        return AbstractC8236Vc3.d(((i * i2) * i3) / 1000000);
    }

    protected static int d(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.e
    public int a(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        return (((Math.max(i, (int) (c(i, i2, i3, i4, i5, i6) * d)) + i4) - 1) / i4) * i4;
    }

    protected int c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 == 0) {
            return g(i, i5, i4);
        }
        if (i3 == 1) {
            return e(i2);
        }
        if (i3 == 2) {
            return f(i2, i6);
        }
        throw new IllegalArgumentException();
    }

    protected int e(int i) {
        return AbstractC8236Vc3.d((this.f * d(i)) / 1000000);
    }

    protected int f(int i, int i2) {
        int i3 = this.e;
        if (i == 5) {
            i3 *= this.g;
        }
        return AbstractC8236Vc3.d((i3 * (i2 != -1 ? AbstractC20159ra3.a(i2, 8, RoundingMode.CEILING) : d(i))) / 1000000);
    }

    protected int g(int i, int i2, int i3) {
        return AbstractC9683aN7.p(i * this.d, b(this.b, i2, i3), b(this.c, i2, i3));
    }
}
