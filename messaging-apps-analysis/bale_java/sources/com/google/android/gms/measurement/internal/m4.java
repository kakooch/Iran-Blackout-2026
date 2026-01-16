package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C2103a0;
import com.google.android.gms.internal.measurement.C2106b0;
import ir.nasim.AbstractC10631bv8;
import ir.nasim.KJ;
import ir.nasim.Us8;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class m4 {
    private String a;
    private boolean b;
    private com.google.android.gms.internal.measurement.Z c;
    private BitSet d;
    private BitSet e;
    private Map f;
    private Map g;
    final /* synthetic */ C2215b h;

    /* synthetic */ m4(C2215b c2215b, String str, AbstractC10631bv8 abstractC10631bv8) {
        this.h = c2215b;
        this.a = str;
        this.b = true;
        this.d = new BitSet();
        this.e = new BitSet();
        this.f = new KJ();
        this.g = new KJ();
    }

    final com.google.android.gms.internal.measurement.F a(int i) {
        ArrayList arrayList;
        List listEmptyList;
        com.google.android.gms.internal.measurement.E eB = com.google.android.gms.internal.measurement.F.B();
        eB.r(i);
        eB.t(this.b);
        com.google.android.gms.internal.measurement.Z z = this.c;
        if (z != null) {
            eB.u(z);
        }
        com.google.android.gms.internal.measurement.Y yF = com.google.android.gms.internal.measurement.Z.F();
        yF.s(a4.H(this.d));
        yF.u(a4.H(this.e));
        Map map = this.f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f.keySet()) {
                int iIntValue = num.intValue();
                Long l = (Long) this.f.get(num);
                if (l != null) {
                    com.google.android.gms.internal.measurement.G gC = com.google.android.gms.internal.measurement.H.C();
                    gC.s(iIntValue);
                    gC.r(l.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.H) gC.m());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            yF.r(arrayList);
        }
        Map map2 = this.g;
        if (map2 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.g.keySet()) {
                C2103a0 c2103a0D = C2106b0.D();
                c2103a0D.s(num2.intValue());
                List list = (List) this.g.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    c2103a0D.r(list);
                }
                arrayList3.add((C2106b0) c2103a0D.m());
            }
            listEmptyList = arrayList3;
        }
        yF.t(listEmptyList);
        eB.s(yF);
        return (com.google.android.gms.internal.measurement.F) eB.m();
    }

    final void c(p4 p4Var) {
        int iA = p4Var.a();
        Boolean bool = p4Var.c;
        if (bool != null) {
            this.e.set(iA, bool.booleanValue());
        }
        Boolean bool2 = p4Var.d;
        if (bool2 != null) {
            this.d.set(iA, bool2.booleanValue());
        }
        if (p4Var.e != null) {
            Map map = this.f;
            Integer numValueOf = Integer.valueOf(iA);
            Long l = (Long) map.get(numValueOf);
            long jLongValue = p4Var.e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.f.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (p4Var.f != null) {
            Map map2 = this.g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.g.put(numValueOf2, arrayList);
            }
            if (p4Var.c()) {
                arrayList.clear();
            }
            Us8.b();
            C2240g c2240gZ = this.h.a.z();
            String str = this.a;
            R0 r0 = S0.Y;
            if (c2240gZ.B(str, r0) && p4Var.b()) {
                arrayList.clear();
            }
            Us8.b();
            if (!this.h.a.z().B(this.a, r0)) {
                arrayList.add(Long.valueOf(p4Var.f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(p4Var.f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    /* synthetic */ m4(C2215b c2215b, String str, com.google.android.gms.internal.measurement.Z z, BitSet bitSet, BitSet bitSet2, Map map, Map map2, AbstractC10631bv8 abstractC10631bv8) {
        this.h = c2215b;
        this.a = str;
        this.d = bitSet;
        this.e = bitSet2;
        this.f = map;
        this.g = new KJ();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.g.put(num, arrayList);
        }
        this.b = false;
        this.c = z;
    }
}
