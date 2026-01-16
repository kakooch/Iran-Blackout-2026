package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.util.Log;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.internal.clearcut.C0;
import ir.nasim.AbstractC11975dr8;
import ir.nasim.Bh8;
import ir.nasim.C12568ep8;
import ir.nasim.C22130ui8;
import ir.nasim.Fb8;
import ir.nasim.Iv8;
import ir.nasim.K75;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class E0 implements a.b {
    private static final Charset b = Charset.forName("UTF-8");
    private static final C22130ui8 c;
    private static final C22130ui8 d;
    private static final ConcurrentHashMap e;
    private static final HashMap f;
    private static Boolean g;
    private static Long h;
    private static final Bh8 i;
    private final Context a;

    static {
        C22130ui8 c22130ui8H = new C22130ui8(K75.a("com.google.android.gms.clearcut.public")).f("gms:playlog:service:samplingrules_").h("LogSamplingRules__");
        c = c22130ui8H;
        d = new C22130ui8(K75.a("com.google.android.gms.clearcut.public")).f("gms:playlog:service:sampling_").h("LogSampling__");
        e = new ConcurrentHashMap();
        f = new HashMap();
        g = null;
        h = null;
        i = c22130ui8H.e("enable_log_sampling_rules", false);
    }

    public E0(Context context) {
        this.a = context;
        if (context != null) {
            Bh8.b(context);
        }
    }

    private static long b(String str, long j) {
        if (str == null || str.isEmpty()) {
            return AbstractC11975dr8.c(ByteBuffer.allocate(8).putLong(j).array());
        }
        byte[] bytes = str.getBytes(b);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 8);
        byteBufferAllocate.put(bytes);
        byteBufferAllocate.putLong(j);
        return AbstractC11975dr8.c(byteBufferAllocate.array());
    }

    private static C0.b c(String str) throws NumberFormatException {
        String strSubstring;
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(44);
        int i2 = 0;
        if (iIndexOf >= 0) {
            i2 = iIndexOf + 1;
            strSubstring = str.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        int iIndexOf2 = str.indexOf(47, i2);
        if (iIndexOf2 <= 0) {
            Log.e("LogSamplerImpl", str.length() != 0 ? "Failed to parse the rule: ".concat(str) : new String("Failed to parse the rule: "));
            return null;
        }
        try {
            long j = Long.parseLong(str.substring(i2, iIndexOf2));
            long j2 = Long.parseLong(str.substring(iIndexOf2 + 1));
            if (j >= 0 && j2 >= 0) {
                return (C0.b) C0.b.x().o(strSubstring).p(j).q(j2).n();
            }
            StringBuilder sb = new StringBuilder(72);
            sb.append("negative values not supported: ");
            sb.append(j);
            sb.append(Separators.SLASH);
            sb.append(j2);
            Log.e("LogSamplerImpl", sb.toString());
            return null;
        } catch (NumberFormatException e2) {
            Log.e("LogSamplerImpl", str.length() != 0 ? "parseLong() failed while parsing: ".concat(str) : new String("parseLong() failed while parsing: "), e2);
            return null;
        }
    }

    private static boolean d(long j, long j2, long j3) {
        if (j2 < 0 || j3 <= 0) {
            return true;
        }
        return ((j > 0L ? 1 : (j == 0L ? 0 : -1)) >= 0 ? j % j3 : (((Long.MAX_VALUE % j3) + 1) + ((j & Long.MAX_VALUE) % j3)) % j3) < j2;
    }

    private static boolean e(Context context) {
        if (g == null) {
            g = Boolean.valueOf(Fb8.a(context).a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return g.booleanValue();
    }

    private static long f(Context context) {
        if (h == null) {
            if (context == null) {
                return 0L;
            }
            h = Long.valueOf(e(context) ? Iv8.a(context.getContentResolver(), "android_id", 0L) : 0L);
        }
        return h.longValue();
    }

    @Override // com.google.android.gms.clearcut.a.b
    public final boolean a(zze zzeVar) throws NumberFormatException {
        List<C0.b> listP;
        zzr zzrVar = zzeVar.a;
        String strValueOf = zzrVar.g;
        int i2 = zzrVar.c;
        C12568ep8 c12568ep8 = zzeVar.i;
        int i3 = c12568ep8 != null ? c12568ep8.f : 0;
        String str = null;
        if (!((Boolean) i.a()).booleanValue()) {
            if (strValueOf == null || strValueOf.isEmpty()) {
                strValueOf = i2 >= 0 ? String.valueOf(i2) : null;
            }
            if (strValueOf == null) {
                return true;
            }
            Context context = this.a;
            if (context != null && e(context)) {
                HashMap map = f;
                Bh8 bh8B = (Bh8) map.get(strValueOf);
                if (bh8B == null) {
                    bh8B = d.b(strValueOf, null);
                    map.put(strValueOf, bh8B);
                }
                str = (String) bh8B.a();
            }
            C0.b bVarC = c(str);
            if (bVarC != null) {
                return d(b(bVarC.u(), f(this.a)), bVarC.v(), bVarC.w());
            }
            return true;
        }
        if (strValueOf == null || strValueOf.isEmpty()) {
            strValueOf = i2 >= 0 ? String.valueOf(i2) : null;
        }
        if (strValueOf == null) {
            return true;
        }
        if (this.a == null) {
            listP = Collections.emptyList();
        } else {
            ConcurrentHashMap concurrentHashMap = e;
            Bh8 bh8A = (Bh8) concurrentHashMap.get(strValueOf);
            if (bh8A == null) {
                bh8A = c.a(strValueOf, C0.q(), F0.a);
                Bh8 bh8 = (Bh8) concurrentHashMap.putIfAbsent(strValueOf, bh8A);
                if (bh8 != null) {
                    bh8A = bh8;
                }
            }
            listP = ((C0) bh8A.a()).p();
        }
        for (C0.b bVar : listP) {
            if (!bVar.t() || bVar.p() == 0 || bVar.p() == i3) {
                if (!d(b(bVar.u(), f(this.a)), bVar.v(), bVar.w())) {
                    return false;
                }
            }
        }
        return true;
    }
}
