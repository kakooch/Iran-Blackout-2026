package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import ir.nasim.Qh8;
import ir.nasim.Xh8;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.v3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2318v3 extends O3 {
    private final Map d;
    public final C2277n1 e;
    public final C2277n1 f;
    public final C2277n1 g;
    public final C2277n1 h;
    public final C2277n1 i;

    C2318v3(Y3 y3) {
        super(y3);
        this.d = new HashMap();
        C2292q1 c2292q1F = this.a.F();
        c2292q1F.getClass();
        this.e = new C2277n1(c2292q1F, "last_delete_stale", 0L);
        C2292q1 c2292q1F2 = this.a.F();
        c2292q1F2.getClass();
        this.f = new C2277n1(c2292q1F2, "backoff", 0L);
        C2292q1 c2292q1F3 = this.a.F();
        c2292q1F3.getClass();
        this.g = new C2277n1(c2292q1F3, "last_upload", 0L);
        C2292q1 c2292q1F4 = this.a.F();
        c2292q1F4.getClass();
        this.h = new C2277n1(c2292q1F4, "last_upload_attempt", 0L);
        C2292q1 c2292q1F5 = this.a.F();
        c2292q1F5.getClass();
        this.i = new C2277n1(c2292q1F5, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.O3
    protected final boolean l() {
        return false;
    }

    final Pair m(String str) {
        C2313u3 c2313u3;
        AdvertisingIdClient.Info advertisingIdInfo;
        h();
        long jElapsedRealtime = this.a.c().elapsedRealtime();
        C2313u3 c2313u32 = (C2313u3) this.d.get(str);
        if (c2313u32 != null && jElapsedRealtime < c2313u32.c) {
            return new Pair(c2313u32.a, Boolean.valueOf(c2313u32.b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long jR = jElapsedRealtime + this.a.z().r(str, S0.c);
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.f());
        } catch (Exception e) {
            this.a.b().q().b("Unable to get advertising id", e);
            c2313u3 = new C2313u3("", false, jR);
        }
        if (advertisingIdInfo == null) {
            return new Pair("", Boolean.FALSE);
        }
        String id = advertisingIdInfo.getId();
        c2313u3 = id != null ? new C2313u3(id, advertisingIdInfo.isLimitAdTrackingEnabled(), jR) : new C2313u3("", advertisingIdInfo.isLimitAdTrackingEnabled(), jR);
        this.d.put(str, c2313u3);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(c2313u3.a, Boolean.valueOf(c2313u3.b));
    }

    final Pair n(String str, Xh8 xh8) {
        return xh8.i(Qh8.AD_STORAGE) ? m(str) : new Pair("", Boolean.FALSE);
    }

    final String o(String str, boolean z) throws NoSuchAlgorithmException {
        h();
        String str2 = z ? (String) m(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestT = f4.t();
        if (messageDigestT == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestT.digest(str2.getBytes())));
    }
}
