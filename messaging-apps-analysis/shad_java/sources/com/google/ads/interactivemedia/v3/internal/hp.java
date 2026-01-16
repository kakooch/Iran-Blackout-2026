package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class hp {
    private final ho a;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;

    public hp(AudioTrack audioTrack) {
        if (aeu.a >= 19) {
            this.a = new ho(audioTrack);
            e();
        } else {
            this.a = null;
            h(3);
        }
    }

    private final void h(int i) {
        this.b = i;
        if (i == 0) {
            this.e = 0L;
            this.f = -1L;
            this.c = System.nanoTime() / 1000;
            this.d = 10000L;
            return;
        }
        if (i == 1) {
            this.d = 10000L;
        } else if (i == 2 || i == 3) {
            this.d = 10000000L;
        } else {
            this.d = 500000L;
        }
    }

    public final boolean a(long j) {
        ho hoVar = this.a;
        if (hoVar != null && j - this.e >= this.d) {
            this.e = j;
            boolean zA = hoVar.a();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && zA) {
                            e();
                            return true;
                        }
                    } else if (!zA) {
                        e();
                        return false;
                    }
                } else if (!zA) {
                    e();
                } else if (this.a.c() > this.f) {
                    h(2);
                    return true;
                }
            } else {
                if (zA) {
                    if (this.a.b() < this.c) {
                        return false;
                    }
                    this.f = this.a.c();
                    h(1);
                    return true;
                }
                if (j - this.c > 500000) {
                    h(3);
                }
            }
            return zA;
        }
        return false;
    }

    public final void b() {
        h(4);
    }

    public final void c() {
        if (this.b == 4) {
            e();
        }
    }

    public final boolean d() {
        return this.b == 2;
    }

    public final void e() {
        if (this.a != null) {
            h(0);
        }
    }

    public final long f() {
        ho hoVar = this.a;
        if (hoVar != null) {
            return hoVar.b();
        }
        return -9223372036854775807L;
    }

    public final long g() {
        ho hoVar = this.a;
        if (hoVar != null) {
            return hoVar.c();
        }
        return -1L;
    }
}
