package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C2125i0;
import com.google.android.gms.internal.measurement.C2129k0;
import com.google.android.gms.internal.measurement.C2143s;
import com.google.android.gms.internal.measurement.C2147u;
import com.google.android.gms.internal.measurement.C2149v;
import com.google.android.gms.internal.measurement.C2157z;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzkp;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC24556yo8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Au8;
import ir.nasim.C17660nL3;
import ir.nasim.C24006xs8;
import ir.nasim.Ik8;
import ir.nasim.KJ;
import ir.nasim.Xu8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class B1 extends O3 implements InterfaceC2235f {
    private final Map d;
    final Map e;
    final Map f;
    final Map g;
    private final Map h;
    private final Map i;
    final C17660nL3 j;
    final Au8 k;
    private final Map l;
    private final Map m;
    private final Map n;

    B1(Y3 y3) {
        super(y3);
        this.d = new KJ();
        this.e = new KJ();
        this.f = new KJ();
        this.g = new KJ();
        this.h = new KJ();
        this.l = new KJ();
        this.m = new KJ();
        this.n = new KJ();
        this.i = new KJ();
        this.j = new C2331y1(this, 20);
        this.k = new C2336z1(this);
    }

    private final C2149v m(String str, byte[] bArr) {
        if (bArr == null) {
            return C2149v.G();
        }
        try {
            C2149v c2149v = (C2149v) ((C2147u) a4.C(C2149v.E(), bArr)).m();
            this.a.b().v().c("Parsed config. version, gmp_app_id", c2149v.R() ? Long.valueOf(c2149v.C()) : null, c2149v.Q() ? c2149v.H() : null);
            return c2149v;
        } catch (zzkp e) {
            this.a.b().w().c("Unable to merge remote config. appId", C2227d1.z(str), e);
            return C2149v.G();
        } catch (RuntimeException e2) {
            this.a.b().w().c("Unable to merge remote config. appId", C2227d1.z(str), e2);
            return C2149v.G();
        }
    }

    private final void n(String str, C2147u c2147u) {
        HashSet hashSet = new HashSet();
        KJ kj = new KJ();
        KJ kj2 = new KJ();
        KJ kj3 = new KJ();
        Iterator it = c2147u.x().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.r) it.next()).B());
        }
        for (int i = 0; i < c2147u.r(); i++) {
            C2143s c2143s = (C2143s) c2147u.s(i).x();
            if (c2143s.t().isEmpty()) {
                this.a.b().w().a("EventConfig contained null event name");
            } else {
                String strT = c2143s.t();
                String strB = AbstractC24556yo8.b(c2143s.t());
                if (!TextUtils.isEmpty(strB)) {
                    c2143s.s(strB);
                    c2147u.u(i, c2143s);
                }
                if (c2143s.w() && c2143s.u()) {
                    kj.put(strT, Boolean.TRUE);
                }
                if (c2143s.x() && c2143s.v()) {
                    kj2.put(c2143s.t(), Boolean.TRUE);
                }
                if (c2143s.y()) {
                    if (c2143s.r() < 2 || c2143s.r() > 65535) {
                        this.a.b().w().c("Invalid sampling rate. Event name, sample rate", c2143s.t(), Integer.valueOf(c2143s.r()));
                    } else {
                        kj3.put(c2143s.t(), Integer.valueOf(c2143s.r()));
                    }
                }
            }
        }
        this.e.put(str, hashSet);
        this.f.put(str, kj);
        this.g.put(str, kj2);
        this.i.put(str, kj3);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void o(java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.B1.o(java.lang.String):void");
    }

    private final void p(final String str, C2149v c2149v) {
        if (c2149v.A() == 0) {
            this.j.g(str);
            return;
        }
        this.a.b().v().b("EES programs found", Integer.valueOf(c2149v.A()));
        C2129k0 c2129k0 = (C2129k0) c2149v.L().get(0);
        try {
            Ik8 ik8 = new Ik8();
            ik8.d("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.w1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new C24006xs8("internal.remoteConfig", new A1(this.a, str));
                }
            });
            ik8.d("internal.appMetadata", new Callable() { // from class: ir.nasim.Jn8
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final com.google.android.gms.measurement.internal.B1 b1 = this.a;
                    final String str2 = str;
                    return new C13855gv8("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.v1
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            B1 b12 = b1;
                            String str3 = str2;
                            C2263k2 c2263k2R = b12.b.W().R(str3);
                            HashMap map = new HashMap();
                            map.put("platform", ConstantDeviceInfo.APP_PLATFORM);
                            map.put("package_name", str3);
                            b12.a.z().q();
                            map.put("gmp_version", 74029L);
                            if (c2263k2R != null) {
                                String strG0 = c2263k2R.g0();
                                if (strG0 != null) {
                                    map.put("app_version", strG0);
                                }
                                map.put("app_version_int", Long.valueOf(c2263k2R.L()));
                                map.put("dynamite_version", Long.valueOf(c2263k2R.U()));
                            }
                            return map;
                        }
                    });
                }
            });
            ik8.d("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.x1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new Xu8(this.a.k);
                }
            });
            ik8.c(c2129k0);
            this.j.f(str, ik8);
            this.a.b().v().c("EES program loaded for appId, activities", str, Integer.valueOf(c2129k0.A().A()));
            Iterator it = c2129k0.A().D().iterator();
            while (it.hasNext()) {
                this.a.b().v().b("EES program activity", ((C2125i0) it.next()).B());
            }
        } catch (zzd unused) {
            this.a.b().r().b("Failed to load EES program. appId", str);
        }
    }

    private static final Map q(C2149v c2149v) {
        KJ kj = new KJ();
        if (c2149v != null) {
            for (C2157z c2157z : c2149v.M()) {
                kj.put(c2157z.B(), c2157z.C());
            }
        }
        return kj;
    }

    static /* bridge */ /* synthetic */ Ik8 s(B1 b1, String str) throws Throwable {
        b1.i();
        AbstractC3795Cj5.f(str);
        if (!b1.C(str)) {
            return null;
        }
        if (!b1.h.containsKey(str) || b1.h.get(str) == null) {
            b1.o(str);
        } else {
            b1.p(str, (C2149v) b1.h.get(str));
        }
        return (Ik8) b1.j.k().get(str);
    }

    final void A(String str) {
        h();
        this.h.remove(str);
    }

    final boolean B(String str) {
        h();
        C2149v c2149vT = t(str);
        if (c2149vT == null) {
            return false;
        }
        return c2149vT.P();
    }

    public final boolean C(String str) {
        C2149v c2149v;
        return (TextUtils.isEmpty(str) || (c2149v = (C2149v) this.h.get(str)) == null || c2149v.A() == 0) ? false : true;
    }

    final boolean D(String str) {
        return "1".equals(e(str, "measurement.upload.blacklist_internal"));
    }

    final boolean E(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        o(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean F(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        o(str);
        if (D(str) && f4.W(str2)) {
            return true;
        }
        if (G(str) && f4.X(str2)) {
            return true;
        }
        Map map = (Map) this.f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean G(String str) {
        return "1".equals(e(str, "measurement.upload.blacklist_public"));
    }

    protected final boolean H(String str, byte[] bArr, String str2, String str3) {
        i();
        h();
        AbstractC3795Cj5.f(str);
        C2147u c2147u = (C2147u) m(str, bArr).x();
        n(str, c2147u);
        p(str, (C2149v) c2147u.m());
        this.h.put(str, (C2149v) c2147u.m());
        this.l.put(str, c2147u.v());
        this.m.put(str, str2);
        this.n.put(str, str3);
        this.d.put(str, q((C2149v) c2147u.m()));
        this.b.W().n(str, new ArrayList(c2147u.w()));
        try {
            c2147u.t();
            bArr = ((C2149v) c2147u.m()).g();
        } catch (RuntimeException e) {
            this.a.b().w().c("Unable to serialize reduced-size config. Storing full config instead. appId", C2227d1.z(str), e);
        }
        C2260k c2260kW = this.b.W();
        AbstractC3795Cj5.f(str);
        c2260kW.h();
        c2260kW.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        if (c2260kW.a.z().B(null, S0.q0)) {
            contentValues.put("e_tag", str3);
        }
        try {
            if (c2260kW.P().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                c2260kW.a.b().r().b("Failed to update remote config (got 0). appId", C2227d1.z(str));
            }
        } catch (SQLiteException e2) {
            c2260kW.a.b().r().c("Error storing remote config. appId", C2227d1.z(str), e2);
        }
        this.h.put(str, (C2149v) c2147u.m());
        return true;
    }

    final boolean I(String str) throws Throwable {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("app_instance_id");
    }

    final boolean J(String str) throws Throwable {
        h();
        o(str);
        if (this.e.get(str) != null) {
            return ((Set) this.e.get(str)).contains("device_model") || ((Set) this.e.get(str)).contains("device_info");
        }
        return false;
    }

    final boolean K(String str) throws Throwable {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("enhanced_user_id");
    }

    final boolean L(String str) throws Throwable {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("google_signals");
    }

    final boolean M(String str) throws Throwable {
        h();
        o(str);
        if (this.e.get(str) != null) {
            return ((Set) this.e.get(str)).contains(CommonUrlParts.OS_VERSION) || ((Set) this.e.get(str)).contains("device_info");
        }
        return false;
    }

    final boolean N(String str) throws Throwable {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("user_id");
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2235f
    public final String e(String str, String str2) throws Throwable {
        h();
        o(str);
        Map map = (Map) this.d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.O3
    protected final boolean l() {
        return false;
    }

    final int r(String str, String str2) throws Throwable {
        Integer num;
        h();
        o(str);
        Map map = (Map) this.i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    protected final C2149v t(String str) {
        i();
        h();
        AbstractC3795Cj5.f(str);
        o(str);
        return (C2149v) this.h.get(str);
    }

    protected final String u(String str) {
        h();
        return (String) this.n.get(str);
    }

    protected final String v(String str) {
        h();
        return (String) this.m.get(str);
    }

    final String w(String str) throws Throwable {
        h();
        o(str);
        return (String) this.l.get(str);
    }

    final Set y(String str) {
        h();
        o(str);
        return (Set) this.e.get(str);
    }

    protected final void z(String str) {
        h();
        this.m.put(str, null);
    }
}
