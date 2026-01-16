package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.PlaybackException;

/* renamed from: ir.nasim.cg5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11068cg5 {
    private final float a;
    private final boolean b;
    private final boolean c;
    private final long d;
    private final boolean e;
    private final boolean f;
    private final PlaybackException g;
    private final C2018a0 h;
    private final boolean i;
    private final C12372eV7 j;
    private final int k;

    public C11068cg5(float f, boolean z, boolean z2, long j, boolean z3, boolean z4, PlaybackException playbackException, C2018a0 c2018a0, boolean z5, C12372eV7 c12372eV7, int i) {
        AbstractC13042fc3.i(c12372eV7, "videoSize");
        this.a = f;
        this.b = z;
        this.c = z2;
        this.d = j;
        this.e = z3;
        this.f = z4;
        this.g = playbackException;
        this.h = c2018a0;
        this.i = z5;
        this.j = c12372eV7;
        this.k = i;
    }

    public final C11068cg5 a(float f, boolean z, boolean z2, long j, boolean z3, boolean z4, PlaybackException playbackException, C2018a0 c2018a0, boolean z5, C12372eV7 c12372eV7, int i) {
        AbstractC13042fc3.i(c12372eV7, "videoSize");
        return new C11068cg5(f, z, z2, j, z3, z4, playbackException, c2018a0, z5, c12372eV7, i);
    }

    public final C2018a0 c() {
        return this.h;
    }

    public final PlaybackException d() {
        return this.g;
    }

    public final boolean e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11068cg5)) {
            return false;
        }
        C11068cg5 c11068cg5 = (C11068cg5) obj;
        return Float.compare(this.a, c11068cg5.a) == 0 && this.b == c11068cg5.b && this.c == c11068cg5.c && this.d == c11068cg5.d && this.e == c11068cg5.e && this.f == c11068cg5.f && AbstractC13042fc3.d(this.g, c11068cg5.g) && AbstractC13042fc3.d(this.h, c11068cg5.h) && this.i == c11068cg5.i && AbstractC13042fc3.d(this.j, c11068cg5.j) && this.k == c11068cg5.k;
    }

    public final boolean f() {
        return this.f;
    }

    public final int g() {
        return this.k;
    }

    public final float h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Float.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31;
        PlaybackException playbackException = this.g;
        int iHashCode2 = (iHashCode + (playbackException == null ? 0 : playbackException.hashCode())) * 31;
        C2018a0 c2018a0 = this.h;
        return ((((((iHashCode2 + (c2018a0 != null ? c2018a0.hashCode() : 0)) * 31) + Boolean.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k);
    }

    public final long i() {
        return this.d;
    }

    public final C12372eV7 j() {
        return this.j;
    }

    public final boolean k() {
        return this.e;
    }

    public final boolean l() {
        return this.c;
    }

    public String toString() {
        return "PlayerConfiguration(speed=" + this.a + ", isMute=" + this.b + ", isPlaying=" + this.c + ", totalDurationMs=" + this.d + ", isLoading=" + this.e + ", playWhenReady=" + this.f + ", error=" + this.g + ", currentMediaItem=" + this.h + ", onFirstFrameRendered=" + this.i + ", videoSize=" + this.j + ", playbackState=" + this.k + Separators.RPAREN;
    }

    public /* synthetic */ C11068cg5(float f, boolean z, boolean z2, long j, boolean z3, boolean z4, PlaybackException playbackException, C2018a0 c2018a0, boolean z5, C12372eV7 c12372eV7, int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 1.0f : f, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? -1L : j, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? false : z4, (i2 & 64) != 0 ? null : playbackException, (i2 & 128) == 0 ? c2018a0 : null, (i2 & 256) == 0 ? z5 : false, (i2 & 512) != 0 ? C12372eV7.e : c12372eV7, (i2 & 1024) != 0 ? 1 : i);
    }
}
