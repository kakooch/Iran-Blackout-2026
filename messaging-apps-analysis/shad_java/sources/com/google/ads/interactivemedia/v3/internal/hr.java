package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class hr {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private final hq a;
    private final long[] b;
    private AudioTrack c;
    private int d;
    private int e;
    private hp f;
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

    public hr(hq hqVar) {
        this.a = hqVar;
        if (aeu.a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    private final long m(long j) {
        return (j * 1000000) / this.g;
    }

    private final void n() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
    }

    private final long o() {
        return m(p());
    }

    private final long p() {
        AudioTrack audioTrack = this.c;
        ary.t(audioTrack);
        if (this.x != -9223372036854775807L) {
            return Math.min(this.A, this.z + ((((SystemClock.elapsedRealtime() * 1000) - this.x) * this.g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.h) {
            if (playState == 2) {
                if (playbackHeadPosition == 0) {
                    this.u = this.s;
                }
                playState = 2;
            }
            playbackHeadPosition += this.u;
        }
        if (aeu.a <= 29) {
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

    public final void a(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new hp(audioTrack);
        this.g = audioTrack.getSampleRate();
        boolean z2 = true;
        if (!z || aeu.a >= 23 || (i != 5 && i != 6)) {
            z2 = false;
        }
        this.h = z2;
        boolean zX = aeu.X(i);
        this.q = zX;
        this.i = zX ? m(i3 / i2) : -9223372036854775807L;
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

    public final long b(boolean z) {
        long jMax;
        long j;
        Method method;
        AudioTrack audioTrack = this.c;
        ary.t(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long jO = o();
            if (jO != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.m >= 30000) {
                    long[] jArr = this.b;
                    int i = this.v;
                    jArr[i] = jO - jNanoTime;
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
                if (!this.h) {
                    hp hpVar = this.f;
                    ary.t(hpVar);
                    if (hpVar.a(jNanoTime)) {
                        long jF = hpVar.f();
                        long jG = hpVar.g();
                        if (Math.abs(jF - jNanoTime) > 5000000) {
                            j = jNanoTime;
                            this.a.c(jG, jF, jNanoTime, jO);
                            hpVar.b();
                        } else {
                            j = jNanoTime;
                            if (Math.abs(m(jG) - jO) > 5000000) {
                                this.a.b(jG, jF, j, jO);
                                hpVar.b();
                            } else {
                                hpVar.c();
                            }
                        }
                    } else {
                        j = jNanoTime;
                    }
                    if (this.q && (method = this.n) != null) {
                        long j2 = j;
                        if (j2 - this.r >= 500000) {
                            try {
                                AudioTrack audioTrack2 = this.c;
                                ary.t(audioTrack2);
                                Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                                int i5 = aeu.a;
                                long jIntValue = (num.intValue() * 1000) - this.i;
                                this.o = jIntValue;
                                long jMax2 = Math.max(jIntValue, 0L);
                                this.o = jMax2;
                                if (jMax2 > 5000000) {
                                    this.a.d(jMax2);
                                    this.o = 0L;
                                }
                            } catch (Exception unused) {
                                this.n = null;
                            }
                            this.r = j2;
                        }
                    }
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        hp hpVar2 = this.f;
        ary.t(hpVar2);
        boolean zD = hpVar2.d();
        if (zD) {
            jMax = m(hpVar2.g()) + aeu.O(jNanoTime2 - hpVar2.f(), this.j);
        } else {
            long jO2 = this.w == 0 ? o() : this.l + jNanoTime2;
            jMax = !z ? Math.max(0L, jO2 - this.o) : jO2;
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j3 = jNanoTime2 - this.F;
        if (j3 < 1000000) {
            long j4 = (j3 * 1000) / 1000000;
            jMax = ((jMax * j4) + ((1000 - j4) * (this.E + aeu.O(j3, this.j)))) / 1000;
        }
        if (!this.k) {
            long j5 = this.B;
            if (jMax > j5) {
                this.k = true;
                this.a.a(System.currentTimeMillis() - bi.a(aeu.P(bi.a(jMax - j5), this.j)));
            }
        }
        this.C = jNanoTime2;
        this.B = jMax;
        this.D = zD;
        return jMax;
    }

    public final void c() {
        hp hpVar = this.f;
        ary.t(hpVar);
        hpVar.e();
    }

    public final boolean d() {
        AudioTrack audioTrack = this.c;
        ary.t(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    public final boolean e(long j) {
        AudioTrack audioTrack = this.c;
        ary.t(audioTrack);
        int playState = audioTrack.getPlayState();
        if (this.h) {
            if (playState == 2) {
                this.p = false;
                return false;
            }
            if (playState == 1) {
                if (p() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.p;
        boolean zJ = j(j);
        this.p = zJ;
        if (z && !zJ && playState != 1) {
            this.a.e(this.e, bi.a(this.i));
        }
        return true;
    }

    public final int f(long j) {
        return this.e - ((int) (j - (p() * this.d)));
    }

    public final long g(long j) {
        return bi.a(m(j - p()));
    }

    public final boolean h(long j) {
        return this.y != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.y >= 200;
    }

    public final void i(long j) {
        this.z = p();
        this.x = SystemClock.elapsedRealtime() * 1000;
        this.A = j;
    }

    public final boolean j(long j) {
        if (j > p()) {
            return true;
        }
        if (!this.h) {
            return false;
        }
        AudioTrack audioTrack = this.c;
        ary.t(audioTrack);
        return audioTrack.getPlayState() == 2 && p() == 0;
    }

    public final boolean k() {
        n();
        if (this.x != -9223372036854775807L) {
            return false;
        }
        hp hpVar = this.f;
        ary.t(hpVar);
        hpVar.e();
        return true;
    }

    public final void l() {
        n();
        this.c = null;
        this.f = null;
    }
}
