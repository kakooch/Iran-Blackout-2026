package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class d {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private final a a;
    private final long[] b;
    private AudioTrack c;
    private int d;
    private int e;
    private c f;
    private int g;
    private boolean h;
    private long i;
    private float j;
    private boolean k;
    private long l;
    private long m;
    private Method n;
    private long o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private long t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;
    private long z;

    public interface a {
        void a(long j);

        void b(int i, long j);

        void c(long j);

        void d(long j, long j2, long j3, long j4);

        void e(long j, long j2, long j3, long j4);
    }

    public d(a aVar) {
        this.a = (a) AbstractC20011rK.e(aVar);
        if (AbstractC9683aN7.a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    private boolean a() {
        return this.h && ((AudioTrack) AbstractC20011rK.e(this.c)).getPlayState() == 2 && e() == 0;
    }

    private long b(long j) {
        return (j * 1000000) / this.g;
    }

    private long e() {
        AudioTrack audioTrack = (AudioTrack) AbstractC20011rK.e(this.c);
        if (this.x != -9223372036854775807L) {
            return Math.min(this.A, this.z + ((((SystemClock.elapsedRealtime() * 1000) - this.x) * this.g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.u = this.s;
            }
            playbackHeadPosition += this.u;
        }
        if (AbstractC9683aN7.a <= 29) {
            if (playbackHeadPosition == 0 && this.s > 0 && playState == 3) {
                if (this.y == -9223372036854775807L) {
                    this.y = SystemClock.elapsedRealtime();
                }
                return this.s;
            }
            this.y = -9223372036854775807L;
        }
        if (this.s > playbackHeadPosition) {
            this.t++;
        }
        this.s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    private long f() {
        return b(e());
    }

    private void l(long j, long j2) {
        c cVar = (c) AbstractC20011rK.e(this.f);
        if (cVar.e(j)) {
            long jC = cVar.c();
            long jB = cVar.b();
            if (Math.abs(jC - j) > 5000000) {
                this.a.e(jB, jC, j, j2);
                cVar.f();
            } else if (Math.abs(b(jB) - j2) <= 5000000) {
                cVar.a();
            } else {
                this.a.d(jB, jC, j, j2);
                cVar.f();
            }
        }
    }

    private void m() {
        long jF = f();
        if (jF == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.m >= 30000) {
            long[] jArr = this.b;
            int i = this.v;
            jArr[i] = jF - jNanoTime;
            this.v = (i + 1) % 10;
            int i2 = this.w;
            if (i2 < 10) {
                this.w = i2 + 1;
            }
            this.m = jNanoTime;
            this.l = 0L;
            int i3 = 0;
            while (true) {
                int i4 = this.w;
                if (i3 >= i4) {
                    break;
                }
                this.l += this.b[i3] / i4;
                i3++;
            }
        }
        if (this.h) {
            return;
        }
        l(jNanoTime, jF);
        n(jNanoTime);
    }

    private void n(long j) {
        Method method;
        if (!this.q || (method = this.n) == null || j - this.r < 500000) {
            return;
        }
        try {
            long jIntValue = (((Integer) AbstractC9683aN7.j((Integer) method.invoke(AbstractC20011rK.e(this.c), null))).intValue() * 1000) - this.i;
            this.o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.o = jMax;
            if (jMax > 5000000) {
                this.a.c(jMax);
                this.o = 0L;
            }
        } catch (Exception unused) {
            this.n = null;
        }
        this.r = j;
    }

    private static boolean o(int i) {
        return AbstractC9683aN7.a < 23 && (i == 5 || i == 6);
    }

    private void r() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
    }

    public int c(long j) {
        return this.e - ((int) (j - (e() * this.d)));
    }

    public long d(boolean z) {
        long jF;
        if (((AudioTrack) AbstractC20011rK.e(this.c)).getPlayState() == 3) {
            m();
        }
        long jNanoTime = System.nanoTime() / 1000;
        c cVar = (c) AbstractC20011rK.e(this.f);
        boolean zD = cVar.d();
        if (zD) {
            jF = b(cVar.b()) + AbstractC9683aN7.Y(jNanoTime - cVar.c(), this.j);
        } else {
            jF = this.w == 0 ? f() : this.l + jNanoTime;
            if (!z) {
                jF = Math.max(0L, jF - this.o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j = jNanoTime - this.F;
        if (j < 1000000) {
            long jY = this.E + AbstractC9683aN7.Y(j, this.j);
            long j2 = (j * 1000) / 1000000;
            jF = ((jF * j2) + ((1000 - j2) * jY)) / 1000;
        }
        if (!this.k) {
            long j3 = this.B;
            if (jF > j3) {
                this.k = true;
                this.a.a(System.currentTimeMillis() - AbstractC9683aN7.c1(AbstractC9683aN7.d0(AbstractC9683aN7.c1(jF - j3), this.j)));
            }
        }
        this.C = jNanoTime;
        this.B = jF;
        this.D = zD;
        return jF;
    }

    public void g(long j) {
        this.z = e();
        this.x = SystemClock.elapsedRealtime() * 1000;
        this.A = j;
    }

    public boolean h(long j) {
        return j > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) AbstractC20011rK.e(this.c)).getPlayState() == 3;
    }

    public boolean j(long j) {
        return this.y != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.y >= 200;
    }

    public boolean k(long j) {
        int playState = ((AudioTrack) AbstractC20011rK.e(this.c)).getPlayState();
        if (this.h) {
            if (playState == 2) {
                this.p = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z = this.p;
        boolean zH = h(j);
        this.p = zH;
        if (z && !zH && playState != 1) {
            this.a.b(this.e, AbstractC9683aN7.c1(this.i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.x != -9223372036854775807L) {
            return false;
        }
        ((c) AbstractC20011rK.e(this.f)).g();
        return true;
    }

    public void q() {
        r();
        this.c = null;
        this.f = null;
    }

    public void s(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new c(audioTrack);
        this.g = audioTrack.getSampleRate();
        this.h = z && o(i);
        boolean zU0 = AbstractC9683aN7.u0(i);
        this.q = zU0;
        this.i = zU0 ? b(i3 / i2) : -9223372036854775807L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.p = false;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }

    public void t(float f) {
        this.j = f;
        c cVar = this.f;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void u() {
        ((c) AbstractC20011rK.e(this.f)).g();
    }
}
