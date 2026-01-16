package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import ir.nasim.C12889fL5;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.f7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2535f7 {
    public final Context a;
    public final int b;
    public final M8 c;
    public final C2870t8 d;
    public final C2404a0 e;
    public final C8 f;
    public final C2607i7 g;
    public final Q5 h;

    public C2535f7(Context context, Uj uj, int i, M8 m8, C2870t8 c2870t8, C2404a0 c2404a0, C8 c8, C2607i7 c2607i7) {
        this.a = context;
        this.b = i;
        this.c = m8;
        this.d = c2870t8;
        this.e = c2404a0;
        this.f = c8;
        this.g = c2607i7;
        this.h = c2870t8.a;
    }

    public static String b() {
        C12889fL5 c12889fL5 = new C12889fL5();
        C2669km c2669kmZ = C2586ha.C.z();
        C2511e7 c2511e7 = new C2511e7(c12889fL5);
        synchronized (c2669kmZ) {
            c2669kmZ.b.a(c2511e7);
        }
        return (String) c12889fL5.a;
    }

    public final C2436b7 a() throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        Dn dn;
        Location location;
        Integer numValueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        M8 m8 = this.c;
        int i = this.b;
        tn tnVar = m8.a.a;
        synchronized (tnVar) {
            jSONObjectOptJSONObject = tnVar.a.a().optJSONObject("numbers_of_type");
        }
        long jOptLong = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optLong(String.valueOf(i)) : 0L;
        m8.a.a(i, 1 + jOptLong);
        Long lValueOf = Long.valueOf(jOptLong);
        C2607i7 c2607i7 = this.g;
        Cg cg = c2607i7.a;
        Location location2 = cg.e;
        if (location2 != null) {
            int i2 = Dn.b;
            Location location3 = new Location(location2);
            String provider = location3.getProvider();
            location3.setProvider("");
            dn = new Dn(location3, provider);
        } else {
            dn = (!cg.d || (location = C2586ha.C.j().getLocation()) == null) ? null : new Dn(new Location(location), "");
        }
        boolean z = c2607i7.a.d;
        Double dValueOf = dn != null ? Double.valueOf(dn.getLatitude()) : null;
        Double dValueOf2 = dn != null ? Double.valueOf(dn.getLongitude()) : null;
        Long lValueOf2 = dn != null ? Long.valueOf(dn.getTime()) : null;
        Integer numValueOf2 = dn != null ? Integer.valueOf((int) dn.getAccuracy()) : null;
        C2559g7 c2559g7 = new C2559g7(Boolean.valueOf(z), dValueOf2, dValueOf, dn != null ? Integer.valueOf((int) dn.getAltitude()) : null, dn != null ? Integer.valueOf((int) dn.getBearing()) : null, numValueOf2, dn != null ? Integer.valueOf((int) dn.getSpeed()) : null, lValueOf2, dn != null ? dn.getProvider() : null, dn != null ? dn.a : null);
        String str = this.h.c;
        C2404a0 c2404a0 = this.e;
        String str2 = c2404a0.a;
        Long lValueOf3 = Long.valueOf(c2404a0.b);
        Integer numValueOf3 = Integer.valueOf(this.h.g);
        Context context = this.a;
        SafePackageManager safePackageManager = Vd.a;
        Integer num = (Integer) Vd.d.a((Ud) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ud.UNDEFINED, new Td()));
        num.intValue();
        String strB = b();
        B8 b8 = this.d.b;
        Q5 q5 = this.h;
        return new C2436b7(numValueOf, name, value, lValueOf, c2559g7, str, str2, lValueOf3, numValueOf3, num, strB, b8, q5.h, q5.k, q5.l, q5.n, q5.o, this.f.fromModel(q5.p));
    }

    public /* synthetic */ C2535f7(Context context, Uj uj, int i, M8 m8, C2870t8 c2870t8, Cg cg, C2404a0 c2404a0) {
        this(context, uj, i, m8, c2870t8, c2404a0, new C8(), new C2607i7(cg));
    }
}
