package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acf implements abq, adh {
    public static final arp<String, Integer> a = o();
    public static final arn<Long> b = arn.k(6100000L, 3800000L, 2100000L, 1300000L, 590000L);
    public static final arn<Long> c = arn.k(218000L, 159000L, 145000L, 130000L, 112000L);
    public static final arn<Long> d = arn.k(2200000L, 1300000L, 930000L, 730000L, 530000L);
    public static final arn<Long> e = arn.k(4800000L, 2700000L, 1800000L, 1200000L, 630000L);
    public static final arn<Long> f = arn.k(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);
    private static acf g;
    private final Context h;
    private final ars<Integer, Long> i;
    private final abo j;
    private final aej k;
    private final adk l;
    private int m;
    private long n;
    private long o;
    private int p;
    private long q;
    private long r;
    private long s;
    private long t;

    @Deprecated
    public acf() {
        ars.a();
        adk adkVar = adk.a;
        throw null;
    }

    /* synthetic */ acf(Context context, Map map, int i, adk adkVar, boolean z) {
        this.h = context == null ? null : context.getApplicationContext();
        this.i = ars.d(map);
        this.j = new abo();
        this.k = new aej(2000);
        this.l = adkVar;
        int iAd = context == null ? 0 : aeu.ad(context);
        this.p = iAd;
        this.s = m(iAd);
        if (context != null) {
            ace.a(context).b(this);
        }
    }

    public static synchronized acf e(Context context) {
        if (g == null) {
            Context applicationContext = context == null ? null : context.getApplicationContext();
            arn<Integer> arnVarC = a.c(aeu.ae(context));
            if (arnVarC.isEmpty()) {
                arnVarC = arn.k(2, 2, 2, 2, 2);
            }
            HashMap map = new HashMap(6);
            map.put(0, 1000000L);
            arn<Long> arnVar = b;
            map.put(2, arnVar.get(arnVarC.get(0).intValue()));
            map.put(3, c.get(arnVarC.get(1).intValue()));
            map.put(4, d.get(arnVarC.get(2).intValue()));
            map.put(5, e.get(arnVarC.get(3).intValue()));
            map.put(9, f.get(arnVarC.get(4).intValue()));
            map.put(7, arnVar.get(arnVarC.get(0).intValue()));
            g = acs.a(applicationContext, map, 2000, adk.a, true);
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void k() {
        Context context = this.h;
        int iAd = context == null ? 0 : aeu.ad(context);
        if (this.p == iAd) {
            return;
        }
        this.p = iAd;
        if (iAd != 1 && iAd != 0 && iAd != 8) {
            this.s = m(iAd);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            l(this.m > 0 ? (int) (jElapsedRealtime - this.n) : 0, this.o, this.s);
            this.n = jElapsedRealtime;
            this.o = 0L;
            this.r = 0L;
            this.q = 0L;
            this.k.a();
        }
    }

    private final void l(int i, long j, long j2) {
        int i2;
        if (i != 0) {
            i2 = i;
        } else if (j == 0 && j2 == this.t) {
            return;
        } else {
            i2 = 0;
        }
        this.t = j2;
        this.j.c(i2, j, j2);
    }

    private final long m(int i) {
        Long l = this.i.get(Integer.valueOf(i));
        if (l == null) {
            l = this.i.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private static boolean n(acb acbVar, boolean z) {
        return z && !acbVar.b(8);
    }

    private static arp<String, Integer> o() {
        aro aroVarB = arp.b();
        aroVarB.c("AD", 1, 2, 0, 0, 2);
        aroVarB.c("AE", 1, 4, 4, 4, 1);
        aroVarB.c("AF", 4, 4, 3, 4, 2);
        aroVarB.c("AG", 2, 2, 1, 1, 2);
        aroVarB.c("AI", 1, 2, 2, 2, 2);
        aroVarB.c("AL", 1, 1, 0, 1, 2);
        aroVarB.c("AM", 2, 2, 1, 2, 2);
        aroVarB.c("AO", 3, 4, 4, 2, 2);
        aroVarB.c("AR", 2, 4, 2, 2, 2);
        aroVarB.c("AS", 2, 2, 4, 3, 2);
        aroVarB.c("AT", 0, 3, 0, 0, 2);
        aroVarB.c("AU", 0, 2, 0, 1, 1);
        aroVarB.c("AW", 1, 2, 0, 4, 2);
        aroVarB.c("AX", 0, 2, 2, 2, 2);
        aroVarB.c("AZ", 3, 3, 3, 4, 2);
        aroVarB.c("BA", 1, 1, 0, 1, 2);
        aroVarB.c("BB", 0, 2, 0, 0, 2);
        aroVarB.c("BD", 2, 0, 3, 3, 2);
        aroVarB.c("BE", 0, 1, 2, 3, 2);
        aroVarB.c("BF", 4, 4, 4, 2, 2);
        aroVarB.c("BG", 0, 1, 0, 0, 2);
        aroVarB.c("BH", 1, 0, 2, 4, 2);
        aroVarB.c("BI", 4, 4, 4, 4, 2);
        aroVarB.c("BJ", 4, 4, 3, 4, 2);
        aroVarB.c("BL", 1, 2, 2, 2, 2);
        aroVarB.c("BM", 1, 2, 0, 0, 2);
        aroVarB.c("BN", 4, 0, 1, 1, 2);
        aroVarB.c("BO", 2, 3, 3, 2, 2);
        aroVarB.c("BQ", 1, 2, 1, 2, 2);
        aroVarB.c("BR", 2, 4, 2, 1, 2);
        aroVarB.c("BS", 3, 2, 2, 3, 2);
        aroVarB.c("BT", 3, 0, 3, 2, 2);
        aroVarB.c("BW", 3, 4, 2, 2, 2);
        aroVarB.c("BY", 1, 0, 2, 1, 2);
        aroVarB.c("BZ", 2, 2, 2, 1, 2);
        aroVarB.c("CA", 0, 3, 1, 2, 3);
        aroVarB.c("CD", 4, 3, 2, 2, 2);
        aroVarB.c("CF", 4, 2, 2, 2, 2);
        aroVarB.c("CG", 3, 4, 1, 1, 2);
        aroVarB.c("CH", 0, 1, 0, 0, 0);
        aroVarB.c("CI", 3, 3, 3, 3, 2);
        aroVarB.c("CK", 3, 2, 1, 0, 2);
        aroVarB.c("CL", 1, 1, 2, 3, 2);
        aroVarB.c("CM", 3, 4, 3, 2, 2);
        aroVarB.c("CN", 2, 2, 2, 1, 3);
        aroVarB.c("CO", 2, 4, 3, 2, 2);
        aroVarB.c("CR", 2, 3, 4, 4, 2);
        aroVarB.c("CU", 4, 4, 2, 1, 2);
        aroVarB.c("CV", 2, 3, 3, 3, 2);
        aroVarB.c("CW", 1, 2, 0, 0, 2);
        aroVarB.c("CY", 1, 2, 0, 0, 2);
        aroVarB.c("CZ", 0, 1, 0, 0, 2);
        aroVarB.c("DE", 0, 1, 1, 2, 0);
        aroVarB.c("DJ", 4, 1, 4, 4, 2);
        aroVarB.c("DK", 0, 0, 1, 0, 2);
        aroVarB.c("DM", 1, 2, 2, 2, 2);
        aroVarB.c("DO", 3, 4, 4, 4, 2);
        aroVarB.c("DZ", 3, 2, 4, 4, 2);
        aroVarB.c("EC", 2, 4, 3, 2, 2);
        aroVarB.c("EE", 0, 0, 0, 0, 2);
        aroVarB.c("EG", 3, 4, 2, 1, 2);
        aroVarB.c("EH", 2, 2, 2, 2, 2);
        aroVarB.c("ER", 4, 2, 2, 2, 2);
        aroVarB.c("ES", 0, 1, 2, 1, 2);
        aroVarB.c("ET", 4, 4, 4, 1, 2);
        aroVarB.c("FI", 0, 0, 1, 0, 0);
        aroVarB.c("FJ", 3, 0, 3, 3, 2);
        aroVarB.c("FK", 2, 2, 2, 2, 2);
        aroVarB.c("FM", 4, 2, 4, 3, 2);
        aroVarB.c("FO", 0, 2, 0, 0, 2);
        aroVarB.c("FR", 1, 0, 2, 1, 2);
        aroVarB.c("GA", 3, 3, 1, 0, 2);
        aroVarB.c("GB", 0, 0, 1, 2, 2);
        aroVarB.c("GD", 1, 2, 2, 2, 2);
        aroVarB.c("GE", 1, 0, 1, 3, 2);
        aroVarB.c("GF", 2, 2, 2, 4, 2);
        aroVarB.c("GG", 0, 2, 0, 0, 2);
        aroVarB.c("GH", 3, 2, 3, 2, 2);
        aroVarB.c("GI", 0, 2, 0, 0, 2);
        aroVarB.c("GL", 1, 2, 2, 1, 2);
        aroVarB.c("GM", 4, 3, 2, 4, 2);
        aroVarB.c("GN", 4, 3, 4, 2, 2);
        aroVarB.c("GP", 2, 2, 3, 4, 2);
        aroVarB.c("GQ", 4, 2, 3, 4, 2);
        aroVarB.c("GR", 1, 1, 0, 1, 2);
        aroVarB.c("GT", 3, 2, 3, 2, 2);
        aroVarB.c("GU", 1, 2, 4, 4, 2);
        aroVarB.c("GW", 3, 4, 4, 3, 2);
        aroVarB.c("GY", 3, 3, 1, 0, 2);
        aroVarB.c("HK", 0, 2, 3, 4, 2);
        aroVarB.c("HN", 3, 0, 3, 3, 2);
        aroVarB.c("HR", 1, 1, 0, 1, 2);
        aroVarB.c("HT", 4, 3, 4, 4, 2);
        aroVarB.c("HU", 0, 1, 0, 0, 2);
        aroVarB.c("ID", 3, 2, 2, 3, 2);
        aroVarB.c("IE", 0, 0, 1, 1, 2);
        aroVarB.c("IL", 1, 0, 2, 3, 2);
        aroVarB.c("IM", 0, 2, 0, 1, 2);
        aroVarB.c("IN", 2, 1, 3, 3, 2);
        aroVarB.c("IO", 4, 2, 2, 4, 2);
        aroVarB.c("IQ", 3, 2, 4, 3, 2);
        aroVarB.c("IR", 4, 2, 3, 4, 2);
        aroVarB.c("IS", 0, 2, 0, 0, 2);
        aroVarB.c("IT", 0, 0, 1, 1, 2);
        aroVarB.c("JE", 2, 2, 0, 2, 2);
        aroVarB.c("JM", 3, 3, 4, 4, 2);
        aroVarB.c("JO", 1, 2, 1, 1, 2);
        aroVarB.c("JP", 0, 2, 0, 1, 3);
        aroVarB.c("KE", 3, 4, 2, 2, 2);
        aroVarB.c("KG", 1, 0, 2, 2, 2);
        aroVarB.c("KH", 2, 0, 4, 3, 2);
        aroVarB.c("KI", 4, 2, 3, 1, 2);
        aroVarB.c("KM", 4, 2, 2, 3, 2);
        aroVarB.c("KN", 1, 2, 2, 2, 2);
        aroVarB.c("KP", 4, 2, 2, 2, 2);
        aroVarB.c("KR", 0, 2, 1, 1, 1);
        aroVarB.c("KW", 2, 3, 1, 1, 1);
        aroVarB.c("KY", 1, 2, 0, 0, 2);
        aroVarB.c("KZ", 1, 2, 2, 3, 2);
        aroVarB.c("LA", 2, 2, 1, 1, 2);
        aroVarB.c("LB", 3, 2, 0, 0, 2);
        aroVarB.c("LC", 1, 1, 0, 0, 2);
        aroVarB.c("LI", 0, 2, 2, 2, 2);
        aroVarB.c("LK", 2, 0, 2, 3, 2);
        aroVarB.c("LR", 3, 4, 3, 2, 2);
        aroVarB.c("LS", 3, 3, 2, 3, 2);
        aroVarB.c("LT", 0, 0, 0, 0, 2);
        aroVarB.c("LU", 0, 0, 0, 0, 2);
        aroVarB.c("LV", 0, 0, 0, 0, 2);
        aroVarB.c("LY", 4, 2, 4, 3, 2);
        aroVarB.c("MA", 2, 1, 2, 1, 2);
        aroVarB.c("MC", 0, 2, 2, 2, 2);
        aroVarB.c("MD", 1, 2, 0, 0, 2);
        aroVarB.c("ME", 1, 2, 1, 2, 2);
        aroVarB.c("MF", 1, 2, 1, 0, 2);
        aroVarB.c("MG", 3, 4, 3, 3, 2);
        aroVarB.c("MH", 4, 2, 2, 4, 2);
        aroVarB.c("MK", 1, 0, 0, 0, 2);
        aroVarB.c("ML", 4, 4, 1, 1, 2);
        aroVarB.c("MM", 2, 3, 2, 2, 2);
        aroVarB.c("MN", 2, 4, 1, 1, 2);
        aroVarB.c("MO", 0, 2, 4, 4, 2);
        aroVarB.c("MP", 0, 2, 2, 2, 2);
        aroVarB.c("MQ", 2, 2, 2, 3, 2);
        aroVarB.c("MR", 3, 0, 4, 2, 2);
        aroVarB.c("MS", 1, 2, 2, 2, 2);
        aroVarB.c("MT", 0, 2, 0, 1, 2);
        aroVarB.c("MU", 3, 1, 2, 3, 2);
        aroVarB.c("MV", 4, 3, 1, 4, 2);
        aroVarB.c("MW", 4, 1, 1, 0, 2);
        aroVarB.c("MX", 2, 4, 3, 3, 2);
        aroVarB.c("MY", 2, 0, 3, 3, 2);
        aroVarB.c("MZ", 3, 3, 2, 3, 2);
        aroVarB.c("NA", 4, 3, 2, 2, 2);
        aroVarB.c("NC", 2, 0, 4, 4, 2);
        aroVarB.c("NE", 4, 4, 4, 4, 2);
        aroVarB.c("NF", 2, 2, 2, 2, 2);
        aroVarB.c("NG", 3, 3, 2, 2, 2);
        aroVarB.c("NI", 3, 1, 4, 4, 2);
        aroVarB.c("NL", 0, 2, 4, 2, 0);
        aroVarB.c("NO", 0, 1, 1, 0, 2);
        aroVarB.c("NP", 2, 0, 4, 3, 2);
        aroVarB.c("NR", 4, 2, 3, 1, 2);
        aroVarB.c("NU", 4, 2, 2, 2, 2);
        aroVarB.c("NZ", 0, 2, 1, 2, 4);
        aroVarB.c("OM", 2, 2, 0, 2, 2);
        aroVarB.c("PA", 1, 3, 3, 4, 2);
        aroVarB.c("PE", 2, 4, 4, 4, 2);
        aroVarB.c("PF", 2, 2, 1, 1, 2);
        aroVarB.c("PG", 4, 3, 3, 2, 2);
        aroVarB.c("PH", 3, 0, 3, 4, 4);
        aroVarB.c("PK", 3, 2, 3, 3, 2);
        aroVarB.c("PL", 1, 0, 2, 2, 2);
        aroVarB.c("PM", 0, 2, 2, 2, 2);
        aroVarB.c("PR", 1, 2, 2, 3, 4);
        aroVarB.c("PS", 3, 3, 2, 2, 2);
        aroVarB.c("PT", 1, 1, 0, 0, 2);
        aroVarB.c("PW", 1, 2, 3, 0, 2);
        aroVarB.c("PY", 2, 0, 3, 3, 2);
        aroVarB.c("QA", 2, 3, 1, 2, 2);
        aroVarB.c("RE", 1, 0, 2, 1, 2);
        aroVarB.c("RO", 1, 1, 1, 2, 2);
        aroVarB.c("RS", 1, 2, 0, 0, 2);
        aroVarB.c("RU", 0, 1, 0, 1, 2);
        aroVarB.c("RW", 4, 3, 3, 4, 2);
        aroVarB.c("SA", 2, 2, 2, 1, 2);
        aroVarB.c("SB", 4, 2, 4, 2, 2);
        aroVarB.c("SC", 4, 2, 0, 1, 2);
        aroVarB.c("SD", 4, 4, 4, 3, 2);
        aroVarB.c("SE", 0, 0, 0, 0, 2);
        aroVarB.c("SG", 0, 0, 3, 3, 4);
        aroVarB.c("SH", 4, 2, 2, 2, 2);
        aroVarB.c("SI", 0, 1, 0, 0, 2);
        aroVarB.c("SJ", 2, 2, 2, 2, 2);
        aroVarB.c("SK", 0, 1, 0, 0, 2);
        aroVarB.c("SL", 4, 3, 3, 1, 2);
        aroVarB.c("SM", 0, 2, 2, 2, 2);
        aroVarB.c("SN", 4, 4, 4, 3, 2);
        aroVarB.c("SO", 3, 4, 4, 4, 2);
        aroVarB.c("SR", 3, 2, 3, 1, 2);
        aroVarB.c("SS", 4, 1, 4, 2, 2);
        aroVarB.c("ST", 2, 2, 1, 2, 2);
        aroVarB.c("SV", 2, 1, 4, 4, 2);
        aroVarB.c("SX", 2, 2, 1, 0, 2);
        aroVarB.c("SY", 4, 3, 2, 2, 2);
        aroVarB.c("SZ", 3, 4, 3, 4, 2);
        aroVarB.c("TC", 1, 2, 1, 0, 2);
        aroVarB.c("TD", 4, 4, 4, 4, 2);
        aroVarB.c("TG", 3, 2, 1, 0, 2);
        aroVarB.c("TH", 1, 3, 4, 3, 0);
        aroVarB.c("TJ", 4, 4, 4, 4, 2);
        aroVarB.c("TL", 4, 1, 4, 4, 2);
        aroVarB.c("TM", 4, 2, 1, 2, 2);
        aroVarB.c("TN", 2, 1, 1, 1, 2);
        aroVarB.c("TO", 3, 3, 4, 2, 2);
        aroVarB.c("TR", 1, 2, 1, 1, 2);
        aroVarB.c("TT", 1, 3, 1, 3, 2);
        aroVarB.c("TV", 3, 2, 2, 4, 2);
        aroVarB.c("TW", 0, 0, 0, 0, 1);
        aroVarB.c("TZ", 3, 3, 3, 2, 2);
        aroVarB.c("UA", 0, 3, 0, 0, 2);
        aroVarB.c("UG", 3, 2, 2, 3, 2);
        aroVarB.c("US", 0, 1, 3, 3, 3);
        aroVarB.c("UY", 2, 1, 1, 1, 2);
        aroVarB.c("UZ", 2, 0, 3, 2, 2);
        aroVarB.c("VC", 2, 2, 2, 2, 2);
        aroVarB.c("VE", 4, 4, 4, 4, 2);
        aroVarB.c("VG", 2, 2, 1, 2, 2);
        aroVarB.c("VI", 1, 2, 2, 4, 2);
        aroVarB.c("VN", 0, 1, 4, 4, 2);
        aroVarB.c("VU", 4, 1, 3, 1, 2);
        aroVarB.c("WS", 3, 1, 4, 2, 2);
        aroVarB.c("XK", 1, 1, 1, 0, 2);
        aroVarB.c("YE", 4, 4, 4, 4, 2);
        aroVarB.c("YT", 3, 2, 1, 3, 2);
        aroVarB.c("ZA", 2, 3, 2, 2, 2);
        aroVarB.c("ZM", 3, 2, 2, 3, 2);
        aroVarB.c("ZW", 3, 3, 3, 3, 2);
        return aroVarB.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abq
    public final synchronized long a() {
        return this.s;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abq
    public final adh b() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abq
    public final void c(Handler handler, abp abpVar) {
        this.j.a(handler, abpVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abq
    public final void d(abp abpVar) {
        this.j.b(abpVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adh
    public final synchronized void g(acb acbVar, boolean z, int i) {
        if (n(acbVar, z)) {
            this.o += i;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adh
    public final synchronized void h(acb acbVar, boolean z) {
        if (n(acbVar, z)) {
            ary.q(this.m > 0);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (jElapsedRealtime - this.n);
            this.q += i;
            long j = this.r;
            long j2 = this.o;
            this.r = j + j2;
            if (i > 0) {
                this.k.b((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.q >= 2000 || this.r >= 524288) {
                    this.s = (long) this.k.c();
                }
                l(i, this.o, this.s);
                this.n = jElapsedRealtime;
                this.o = 0L;
            }
            this.m--;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adh
    public final void i() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adh
    public final synchronized void j(acb acbVar, boolean z) {
        if (n(acbVar, z)) {
            if (this.m == 0) {
                this.n = SystemClock.elapsedRealtime();
            }
            this.m++;
        }
    }
}
