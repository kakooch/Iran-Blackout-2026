package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.PlaybackException;

/* renamed from: ir.nasim.dg5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11863dg5 {
    private final boolean a;
    private final boolean b;
    private final int c;
    private final PlaybackException d;
    private final float e;
    private final long f;
    private final boolean g;

    public C11863dg5(boolean z, boolean z2, int i, PlaybackException playbackException, float f, long j, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = playbackException;
        this.e = f;
        this.f = j;
        this.g = z3;
    }

    public final C11863dg5 a(boolean z, boolean z2, int i, PlaybackException playbackException, float f, long j, boolean z3) {
        return new C11863dg5(z, z2, i, playbackException, f, j, z3);
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.f;
    }

    public final PlaybackException e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11863dg5)) {
            return false;
        }
        C11863dg5 c11863dg5 = (C11863dg5) obj;
        return this.a == c11863dg5.a && this.b == c11863dg5.b && this.c == c11863dg5.c && AbstractC13042fc3.d(this.d, c11863dg5.d) && Float.compare(this.e, c11863dg5.e) == 0 && this.f == c11863dg5.f && this.g == c11863dg5.g;
    }

    public final float f() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        PlaybackException playbackException = this.d;
        return ((((((iHashCode + (playbackException == null ? 0 : playbackException.hashCode())) * 31) + Float.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Boolean.hashCode(this.g);
    }

    public String toString() {
        return "PlayerConfiguration(isPlaying=" + this.a + ", isPaused=" + this.b + ", playBackState=" + this.c + ", playerException=" + this.d + ", volume=" + this.e + ", playPosition=" + this.f + ", firstFrameRendered=" + this.g + Separators.RPAREN;
    }
}
