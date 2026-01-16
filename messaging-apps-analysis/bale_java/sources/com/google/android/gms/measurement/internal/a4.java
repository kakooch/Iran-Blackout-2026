package com.google.android.gms.measurement.internal;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.C2106b0;
import com.google.android.gms.internal.measurement.C2109c0;
import com.google.android.gms.internal.measurement.C2112d0;
import com.google.android.gms.internal.measurement.C2114e;
import com.google.android.gms.internal.measurement.C2120g;
import com.google.android.gms.internal.measurement.C2126j;
import com.google.android.gms.internal.measurement.C2130l;
import com.google.android.gms.internal.measurement.C2136o;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC24556yo8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C16097kh8;
import ir.nasim.Pr8;
import ir.nasim.Wt8;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public final class a4 extends O3 {
    a4(Y3 y3) {
        super(y3);
    }

    static Pr8 C(Pr8 pr8, byte[] bArr) {
        com.google.android.gms.internal.measurement.H0 h0A = com.google.android.gms.internal.measurement.H0.a();
        return h0A != null ? pr8.N0(bArr, h0A) : pr8.x0(bArr);
    }

    static List H(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    static boolean L(List list, int i) {
        if (i < list.size() * 64) {
            return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    static boolean N(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static final void P(com.google.android.gms.internal.measurement.I i, String str, Object obj) {
        List listG = i.G();
        int i2 = 0;
        while (true) {
            if (i2 >= listG.size()) {
                i2 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.N) listG.get(i2)).G())) {
                break;
            } else {
                i2++;
            }
        }
        com.google.android.gms.internal.measurement.M mE = com.google.android.gms.internal.measurement.N.E();
        mE.A(str);
        if (obj instanceof Long) {
            mE.z(((Long) obj).longValue());
        }
        if (i2 >= 0) {
            i.A(i2, mE);
        } else {
            i.v(mE);
        }
    }

    static final boolean m(zzaw zzawVar, zzq zzqVar) {
        AbstractC3795Cj5.j(zzawVar);
        AbstractC3795Cj5.j(zzqVar);
        return (TextUtils.isEmpty(zzqVar.b) && TextUtils.isEmpty(zzqVar.q)) ? false : true;
    }

    static final com.google.android.gms.internal.measurement.N n(com.google.android.gms.internal.measurement.J j, String str) {
        for (com.google.android.gms.internal.measurement.N n : j.I()) {
            if (n.G().equals(str)) {
                return n;
            }
        }
        return null;
    }

    static final Object o(com.google.android.gms.internal.measurement.J j, String str) {
        com.google.android.gms.internal.measurement.N n = n(j, str);
        if (n == null) {
            return null;
        }
        if (n.Y()) {
            return n.H();
        }
        if (n.W()) {
            return Long.valueOf(n.D());
        }
        if (n.U()) {
            return Double.valueOf(n.A());
        }
        if (n.C() <= 0) {
            return null;
        }
        List<com.google.android.gms.internal.measurement.N> listI = n.I();
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.measurement.N n2 : listI) {
            if (n2 != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.N n3 : n2.I()) {
                    if (n3.Y()) {
                        bundle.putString(n3.G(), n3.H());
                    } else if (n3.W()) {
                        bundle.putLong(n3.G(), n3.D());
                    } else if (n3.U()) {
                        bundle.putDouble(n3.G(), n3.A());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void p(StringBuilder sb, int i, List list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.N n = (com.google.android.gms.internal.measurement.N) it.next();
            if (n != null) {
                r(sb, i2);
                sb.append("param {\n");
                u(sb, i2, "name", n.X() ? this.a.D().e(n.G()) : null);
                u(sb, i2, "string_value", n.Y() ? n.H() : null);
                u(sb, i2, "int_value", n.W() ? Long.valueOf(n.D()) : null);
                u(sb, i2, "double_value", n.U() ? Double.valueOf(n.A()) : null);
                if (n.C() > 0) {
                    p(sb, i2, n.I());
                }
                r(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void q(StringBuilder sb, int i, C2120g c2120g) {
        String str;
        if (c2120g == null) {
            return;
        }
        r(sb, i);
        sb.append("filter {\n");
        if (c2120g.H()) {
            u(sb, i, "complement", Boolean.valueOf(c2120g.G()));
        }
        if (c2120g.J()) {
            u(sb, i, "param_name", this.a.D().e(c2120g.E()));
        }
        if (c2120g.K()) {
            int i2 = i + 1;
            C2136o c2136oD = c2120g.D();
            if (c2136oD != null) {
                r(sb, i2);
                sb.append("string_filter {\n");
                if (c2136oD.I()) {
                    switch (c2136oD.J()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    u(sb, i2, "match_type", str);
                }
                if (c2136oD.H()) {
                    u(sb, i2, "expression", c2136oD.D());
                }
                if (c2136oD.G()) {
                    u(sb, i2, "case_sensitive", Boolean.valueOf(c2136oD.F()));
                }
                if (c2136oD.A() > 0) {
                    r(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : c2136oD.E()) {
                        r(sb, i + 3);
                        sb.append(str2);
                        sb.append(Separators.RETURN);
                    }
                    sb.append("}\n");
                }
                r(sb, i2);
                sb.append("}\n");
            }
        }
        if (c2120g.I()) {
            v(sb, i + 1, "number_filter", c2120g.C());
        }
        r(sb, i);
        sb.append("}\n");
    }

    private static final void r(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final String s(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void t(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.Z z) {
        if (z == null) {
            return;
        }
        r(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (z.B() != 0) {
            r(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : z.K()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (z.D() != 0) {
            r(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : z.M()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (z.A() != 0) {
            r(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (com.google.android.gms.internal.measurement.H h : z.J()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(h.H() ? Integer.valueOf(h.A()) : null);
                sb.append(":");
                sb.append(h.G() ? Long.valueOf(h.B()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (z.C() != 0) {
            r(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (C2106b0 c2106b0 : z.L()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(c2106b0.I() ? Integer.valueOf(c2106b0.B()) : null);
                sb.append(": [");
                Iterator it = c2106b0.F().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        r(sb, 3);
        sb.append("}\n");
    }

    private static final void u(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        r(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void v(StringBuilder sb, int i, String str, C2126j c2126j) {
        if (c2126j == null) {
            return;
        }
        r(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (c2126j.G()) {
            int iL = c2126j.L();
            u(sb, i, "comparison_type", iL != 1 ? iL != 2 ? iL != 3 ? iL != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (c2126j.I()) {
            u(sb, i, "match_as_float", Boolean.valueOf(c2126j.F()));
        }
        if (c2126j.H()) {
            u(sb, i, "comparison_value", c2126j.C());
        }
        if (c2126j.K()) {
            u(sb, i, "min_comparison_value", c2126j.E());
        }
        if (c2126j.J()) {
            u(sb, i, "max_comparison_value", c2126j.D());
        }
        r(sb, i);
        sb.append("}\n");
    }

    static int w(com.google.android.gms.internal.measurement.T t, String str) {
        for (int i = 0; i < t.p0(); i++) {
            if (str.equals(t.j0(i).F())) {
                return i;
            }
        }
        return -1;
    }

    final zzaw A(C16097kh8 c16097kh8) {
        Object obj;
        Bundle bundleY = y(c16097kh8.e(), true);
        String string = (!bundleY.containsKey("_o") || (obj = bundleY.get("_o")) == null) ? "app" : obj.toString();
        String strB = AbstractC24556yo8.b(c16097kh8.d());
        if (strB == null) {
            strB = c16097kh8.d();
        }
        return new zzaw(strB, new zzau(bundleY), string, c16097kh8.a());
    }

    final com.google.android.gms.internal.measurement.J B(C2285p c2285p) {
        com.google.android.gms.internal.measurement.I iE = com.google.android.gms.internal.measurement.J.E();
        iE.C(c2285p.e);
        r rVar = new r(c2285p.f);
        while (rVar.hasNext()) {
            String next = rVar.next();
            com.google.android.gms.internal.measurement.M mE = com.google.android.gms.internal.measurement.N.E();
            mE.A(next);
            Object objA0 = c2285p.f.A0(next);
            AbstractC3795Cj5.j(objA0);
            J(mE, objA0);
            iE.v(mE);
        }
        return (com.google.android.gms.internal.measurement.J) iE.m();
    }

    final String D(com.google.android.gms.internal.measurement.S s) {
        if (s == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.U u : s.D()) {
            if (u != null) {
                r(sb, 1);
                sb.append("bundle {\n");
                if (u.q1()) {
                    u(sb, 1, CommonUrlParts.PROTOCOL_VERSION, Integer.valueOf(u.z1()));
                }
                Wt8.b();
                if (this.a.z().B(null, S0.n0) && this.a.z().B(u.S1(), S0.p0) && u.t1()) {
                    u(sb, 1, "session_stitching_token", u.K());
                }
                u(sb, 1, "platform", u.I());
                if (u.m1()) {
                    u(sb, 1, "gmp_version", Long.valueOf(u.H1()));
                }
                if (u.x1()) {
                    u(sb, 1, "uploading_gmp_version", Long.valueOf(u.M1()));
                }
                if (u.k1()) {
                    u(sb, 1, "dynamite_version", Long.valueOf(u.F1()));
                }
                if (u.h1()) {
                    u(sb, 1, "config_version", Long.valueOf(u.D1()));
                }
                u(sb, 1, "gmp_app_id", u.F());
                u(sb, 1, "admob_app_id", u.R1());
                u(sb, 1, CommonUrlParts.APP_ID, u.S1());
                u(sb, 1, "app_version", u.A());
                if (u.B0()) {
                    u(sb, 1, "app_version_major", Integer.valueOf(u.b0()));
                }
                u(sb, 1, "firebase_instance_id", u.E());
                if (u.j1()) {
                    u(sb, 1, "dev_cert_hash", Long.valueOf(u.E1()));
                }
                u(sb, 1, "app_store", u.U1());
                if (u.w1()) {
                    u(sb, 1, "upload_timestamp_millis", Long.valueOf(u.L1()));
                }
                if (u.u1()) {
                    u(sb, 1, "start_timestamp_millis", Long.valueOf(u.K1()));
                }
                if (u.l1()) {
                    u(sb, 1, "end_timestamp_millis", Long.valueOf(u.G1()));
                }
                if (u.p1()) {
                    u(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(u.J1()));
                }
                if (u.o1()) {
                    u(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(u.I1()));
                }
                u(sb, 1, "app_instance_id", u.T1());
                u(sb, 1, "resettable_device_id", u.J());
                u(sb, 1, "ds_id", u.D());
                if (u.n1()) {
                    u(sb, 1, "limited_ad_tracking", Boolean.valueOf(u.z0()));
                }
                u(sb, 1, CommonUrlParts.OS_VERSION, u.H());
                u(sb, 1, "device_model", u.C());
                u(sb, 1, "user_default_language", u.L());
                if (u.v1()) {
                    u(sb, 1, "time_zone_offset_minutes", Integer.valueOf(u.B1()));
                }
                if (u.C0()) {
                    u(sb, 1, "bundle_sequential_index", Integer.valueOf(u.e1()));
                }
                if (u.s1()) {
                    u(sb, 1, "service_upload", Boolean.valueOf(u.A0()));
                }
                u(sb, 1, "health_monitor", u.G());
                if (u.r1()) {
                    u(sb, 1, "retry_counter", Integer.valueOf(u.A1()));
                }
                if (u.i1()) {
                    u(sb, 1, "consent_signals", u.B());
                }
                List<C2112d0> listO = u.O();
                if (listO != null) {
                    for (C2112d0 c2112d0 : listO) {
                        if (c2112d0 != null) {
                            r(sb, 2);
                            sb.append("user_property {\n");
                            u(sb, 2, "set_timestamp_millis", c2112d0.R() ? Long.valueOf(c2112d0.C()) : null);
                            u(sb, 2, "name", this.a.D().f(c2112d0.F()));
                            u(sb, 2, "string_value", c2112d0.G());
                            u(sb, 2, "int_value", c2112d0.Q() ? Long.valueOf(c2112d0.B()) : null);
                            u(sb, 2, "double_value", c2112d0.P() ? Double.valueOf(c2112d0.A()) : null);
                            r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.F> listM = u.M();
                if (listM != null) {
                    for (com.google.android.gms.internal.measurement.F f : listM) {
                        if (f != null) {
                            r(sb, 2);
                            sb.append("audience_membership {\n");
                            if (f.K()) {
                                u(sb, 2, "audience_id", Integer.valueOf(f.A()));
                            }
                            if (f.L()) {
                                u(sb, 2, "new_audience", Boolean.valueOf(f.J()));
                            }
                            t(sb, 2, "current_data", f.D());
                            if (f.M()) {
                                t(sb, 2, "previous_data", f.E());
                            }
                            r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.J> listN = u.N();
                if (listN != null) {
                    for (com.google.android.gms.internal.measurement.J j : listN) {
                        if (j != null) {
                            r(sb, 2);
                            sb.append("event {\n");
                            u(sb, 2, "name", this.a.D().d(j.H()));
                            if (j.U()) {
                                u(sb, 2, "timestamp_millis", Long.valueOf(j.D()));
                            }
                            if (j.T()) {
                                u(sb, 2, "previous_timestamp_millis", Long.valueOf(j.C()));
                            }
                            if (j.R()) {
                                u(sb, 2, "count", Integer.valueOf(j.A()));
                            }
                            if (j.B() != 0) {
                                p(sb, 2, j.I());
                            }
                            r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                r(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    final String E(C2114e c2114e) {
        if (c2114e == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (c2114e.O()) {
            u(sb, 0, "filter_id", Integer.valueOf(c2114e.B()));
        }
        u(sb, 0, "event_name", this.a.D().d(c2114e.G()));
        String strS = s(c2114e.K(), c2114e.L(), c2114e.M());
        if (!strS.isEmpty()) {
            u(sb, 0, "filter_type", strS);
        }
        if (c2114e.N()) {
            v(sb, 1, "event_count_filter", c2114e.F());
        }
        if (c2114e.A() > 0) {
            sb.append("  filters {\n");
            Iterator it = c2114e.H().iterator();
            while (it.hasNext()) {
                q(sb, 2, (C2120g) it.next());
            }
        }
        r(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    final String F(C2130l c2130l) {
        if (c2130l == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (c2130l.J()) {
            u(sb, 0, "filter_id", Integer.valueOf(c2130l.A()));
        }
        u(sb, 0, "property_name", this.a.D().f(c2130l.E()));
        String strS = s(c2130l.G(), c2130l.H(), c2130l.I());
        if (!strS.isEmpty()) {
            u(sb, 0, "filter_type", strS);
        }
        q(sb, 1, c2130l.B());
        sb.append("}\n");
        return sb.toString();
    }

    final List G(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.a.b().w().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.a.b().w().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    final Map I(Bundle bundle, boolean z) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(I((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(I((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(I((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    final void J(com.google.android.gms.internal.measurement.M m, Object obj) {
        AbstractC3795Cj5.j(obj);
        m.x();
        m.v();
        m.u();
        m.w();
        if (obj instanceof String) {
            m.B((String) obj);
            return;
        }
        if (obj instanceof Long) {
            m.z(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            m.y(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.a.b().r().b("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.M mE = com.google.android.gms.internal.measurement.N.E();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.M mE2 = com.google.android.gms.internal.measurement.N.E();
                    mE2.A(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        mE2.z(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        mE2.B((String) obj2);
                    } else if (obj2 instanceof Double) {
                        mE2.y(((Double) obj2).doubleValue());
                    }
                    mE.t(mE2);
                }
                if (mE.r() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.N) mE.m());
                }
            }
        }
        m.s(arrayList);
    }

    final void K(C2109c0 c2109c0, Object obj) {
        AbstractC3795Cj5.j(obj);
        c2109c0.t();
        c2109c0.s();
        c2109c0.r();
        if (obj instanceof String) {
            c2109c0.y((String) obj);
            return;
        }
        if (obj instanceof Long) {
            c2109c0.v(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            c2109c0.u(((Double) obj).doubleValue());
        } else {
            this.a.b().r().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final boolean M(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.a.c().currentTimeMillis() - j) > j2;
    }

    final byte[] O(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.a.b().r().b("Failed to gzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.O3
    protected final boolean l() {
        return false;
    }

    final long x(byte[] bArr) throws NoSuchAlgorithmException {
        AbstractC3795Cj5.j(bArr);
        this.a.N().h();
        MessageDigest messageDigestT = f4.t();
        if (messageDigestT != null) {
            return f4.q0(messageDigestT.digest(bArr));
        }
        this.a.b().r().a("Failed to get MD5");
        return 0L;
    }

    final Bundle y(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(y((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    final Parcelable z(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.a.b().r().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }
}
