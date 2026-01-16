package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import ir.nasim.AbstractC12710f43;
import ir.nasim.C7452Rt7;
import java.util.List;

/* loaded from: classes2.dex */
final class x0 {
    private static final MediaSource.MediaPeriodId s = new MediaSource.MediaPeriodId(new Object());
    public final J0 a;
    public final MediaSource.MediaPeriodId b;
    public final long c;
    public final long d;
    public final int e;
    public final ExoPlaybackException f;
    public final boolean g;
    public final TrackGroupArray h;
    public final C7452Rt7 i;
    public final List j;
    public final MediaSource.MediaPeriodId k;
    public final boolean l;
    public final int m;
    public final y0 n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;

    public x0(J0 j0, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, int i, ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, C7452Rt7 c7452Rt7, List list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i2, y0 y0Var, long j3, long j4, long j5, boolean z3) {
        this.a = j0;
        this.b = mediaPeriodId;
        this.c = j;
        this.d = j2;
        this.e = i;
        this.f = exoPlaybackException;
        this.g = z;
        this.h = trackGroupArray;
        this.i = c7452Rt7;
        this.j = list;
        this.k = mediaPeriodId2;
        this.l = z2;
        this.m = i2;
        this.n = y0Var;
        this.p = j3;
        this.q = j4;
        this.r = j5;
        this.o = z3;
    }

    public static x0 j(C7452Rt7 c7452Rt7) {
        J0 j0 = J0.a;
        MediaSource.MediaPeriodId mediaPeriodId = s;
        return new x0(j0, mediaPeriodId, -9223372036854775807L, 0L, 1, null, false, TrackGroupArray.d, c7452Rt7, AbstractC12710f43.V(), mediaPeriodId, false, 0, y0.d, 0L, 0L, 0L, false);
    }

    public static MediaSource.MediaPeriodId k() {
        return s;
    }

    public x0 a(boolean z) {
        return new x0(this.a, this.b, this.c, this.d, this.e, this.f, z, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public x0 b(MediaSource.MediaPeriodId mediaPeriodId) {
        return new x0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, mediaPeriodId, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public x0 c(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, TrackGroupArray trackGroupArray, C7452Rt7 c7452Rt7, List list) {
        return new x0(this.a, mediaPeriodId, j2, j3, this.e, this.f, this.g, trackGroupArray, c7452Rt7, list, this.k, this.l, this.m, this.n, this.p, j4, j, this.o);
    }

    public x0 d(boolean z, int i) {
        return new x0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, z, i, this.n, this.p, this.q, this.r, this.o);
    }

    public x0 e(ExoPlaybackException exoPlaybackException) {
        return new x0(this.a, this.b, this.c, this.d, this.e, exoPlaybackException, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public x0 f(y0 y0Var) {
        return new x0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, y0Var, this.p, this.q, this.r, this.o);
    }

    public x0 g(int i) {
        return new x0(this.a, this.b, this.c, this.d, i, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }

    public x0 h(boolean z) {
        return new x0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, z);
    }

    public x0 i(J0 j0) {
        return new x0(j0, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
}
