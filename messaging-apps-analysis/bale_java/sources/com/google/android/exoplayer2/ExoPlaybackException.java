package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.source.MediaPeriodId;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.io.IOException;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public final class ExoPlaybackException extends PlaybackException {
    public static final InterfaceC2029g.a p = new InterfaceC2029g.a() { // from class: ir.nasim.Kd2
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return ExoPlaybackException.g(bundle);
        }
    };
    private static final String q = AbstractC9683aN7.r0(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY);
    private static final String r = AbstractC9683aN7.r0(1002);
    private static final String s = AbstractC9683aN7.r0(1003);
    private static final String t = AbstractC9683aN7.r0(1004);
    private static final String u = AbstractC9683aN7.r0(WebSocketProtocol.CLOSE_NO_STATUS_CODE);
    private static final String v = AbstractC9683aN7.r0(1006);
    public final int i;
    public final String j;
    public final int k;
    public final X l;
    public final int m;
    public final MediaPeriodId n;
    final boolean o;

    private ExoPlaybackException(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    public static /* synthetic */ ExoPlaybackException g(Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }

    public static ExoPlaybackException k(Throwable th, String str, int i, X x, int i2, boolean z, int i3) {
        return new ExoPlaybackException(1, th, null, i3, str, i, x, x == null ? 4 : i2, z);
    }

    public static ExoPlaybackException l(IOException iOException, int i) {
        return new ExoPlaybackException(0, iOException, i);
    }

    public static ExoPlaybackException m(RuntimeException runtimeException) {
        return n(runtimeException, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }

    public static ExoPlaybackException n(RuntimeException runtimeException, int i) {
        return new ExoPlaybackException(2, runtimeException, i);
    }

    private static String p(int i, String str, String str2, int i2, X x, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + x + ", format_supported=" + AbstractC9683aN7.V(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    @Override // com.google.android.exoplayer2.PlaybackException, com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundleA = super.a();
        bundleA.putInt(q, this.i);
        bundleA.putString(r, this.j);
        bundleA.putInt(s, this.k);
        X x = this.l;
        if (x != null) {
            bundleA.putBundle(t, x.a());
        }
        bundleA.putInt(u, this.m);
        bundleA.putBoolean(v, this.o);
        return bundleA;
    }

    ExoPlaybackException j(MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) AbstractC9683aN7.j(getMessage()), getCause(), this.a, this.i, this.j, this.k, this.l, this.m, mediaPeriodId, this.b, this.o);
    }

    private ExoPlaybackException(int i, Throwable th, String str, int i2, String str2, int i3, X x, int i4, boolean z) {
        this(p(i, str, str2, i3, x, i4), th, i2, i, str2, i3, x, i4, null, SystemClock.elapsedRealtime(), z);
    }

    private ExoPlaybackException(Bundle bundle) {
        super(bundle);
        this.i = bundle.getInt(q, 2);
        this.j = bundle.getString(r);
        this.k = bundle.getInt(s, -1);
        Bundle bundle2 = bundle.getBundle(t);
        this.l = bundle2 == null ? null : (X) X.g1.a(bundle2);
        this.m = bundle.getInt(u, 4);
        this.o = bundle.getBoolean(v, false);
        this.n = null;
    }

    private ExoPlaybackException(String str, Throwable th, int i, int i2, String str2, int i3, X x, int i4, MediaPeriodId mediaPeriodId, long j, boolean z) {
        super(str, th, i, j);
        AbstractC20011rK.a(!z || i2 == 1);
        AbstractC20011rK.a(th != null || i2 == 3);
        this.i = i2;
        this.j = str2;
        this.k = i3;
        this.l = x;
        this.m = i4;
        this.n = mediaPeriodId;
        this.o = z;
    }
}
