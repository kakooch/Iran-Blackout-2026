package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class lg extends li {
    private long b;
    private long[] c;
    private long[] d;

    public lg() {
        super(new jx());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    private static Double g(aee aeeVar) {
        return Double.valueOf(Double.longBitsToDouble(aeeVar.x()));
    }

    private static String h(aee aeeVar) {
        int iO = aeeVar.o();
        int iG = aeeVar.g();
        aeeVar.k(iO);
        return new String(aeeVar.i(), iG, iO);
    }

    private static HashMap<String, Object> i(aee aeeVar) {
        int iB = aeeVar.B();
        HashMap<String, Object> map = new HashMap<>(iB);
        for (int i = 0; i < iB; i++) {
            String strH = h(aeeVar);
            Object objJ = j(aeeVar, aeeVar.n());
            if (objJ != null) {
                map.put(strH, objJ);
            }
        }
        return map;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.li
    protected final boolean a(aee aeeVar) {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.li
    protected final boolean b(aee aeeVar, long j) {
        if (aeeVar.n() != 2 || !"onMetaData".equals(h(aeeVar)) || aeeVar.n() != 8) {
            return false;
        }
        HashMap<String, Object> mapI = i(aeeVar);
        Object obj = mapI.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapI.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public final long c() {
        return this.b;
    }

    public final long[] d() {
        return this.c;
    }

    public final long[] e() {
        return this.d;
    }

    private static Object j(aee aeeVar, int i) {
        if (i == 0) {
            return g(aeeVar);
        }
        if (i == 1) {
            return Boolean.valueOf(aeeVar.n() == 1);
        }
        if (i == 2) {
            return h(aeeVar);
        }
        if (i != 3) {
            if (i == 8) {
                return i(aeeVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) g(aeeVar).doubleValue());
                aeeVar.k(2);
                return date;
            }
            int iB = aeeVar.B();
            ArrayList arrayList = new ArrayList(iB);
            for (int i2 = 0; i2 < iB; i2++) {
                Object objJ = j(aeeVar, aeeVar.n());
                if (objJ != null) {
                    arrayList.add(objJ);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strH = h(aeeVar);
            int iN = aeeVar.n();
            if (iN == 9) {
                return map;
            }
            Object objJ2 = j(aeeVar, iN);
            if (objJ2 != null) {
                map.put(strH, objJ2);
            }
        }
    }
}
