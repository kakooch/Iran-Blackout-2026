package com.google.android.exoplayer2.extractor.flv;

import ir.nasim.EW4;
import ir.nasim.P12;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class c extends TagPayloadReader {
    private long b;
    private long[] c;
    private long[] d;

    public c() {
        super(new P12());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    private static Boolean g(EW4 ew4) {
        return Boolean.valueOf(ew4.F() == 1);
    }

    private static Object h(EW4 ew4, int i) {
        if (i == 0) {
            return j(ew4);
        }
        if (i == 1) {
            return g(ew4);
        }
        if (i == 2) {
            return n(ew4);
        }
        if (i == 3) {
            return l(ew4);
        }
        if (i == 8) {
            return k(ew4);
        }
        if (i == 10) {
            return m(ew4);
        }
        if (i != 11) {
            return null;
        }
        return i(ew4);
    }

    private static Date i(EW4 ew4) {
        Date date = new Date((long) j(ew4).doubleValue());
        ew4.T(2);
        return date;
    }

    private static Double j(EW4 ew4) {
        return Double.valueOf(Double.longBitsToDouble(ew4.y()));
    }

    private static HashMap k(EW4 ew4) {
        int iJ = ew4.J();
        HashMap map = new HashMap(iJ);
        for (int i = 0; i < iJ; i++) {
            String strN = n(ew4);
            Object objH = h(ew4, o(ew4));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    private static HashMap l(EW4 ew4) {
        HashMap map = new HashMap();
        while (true) {
            String strN = n(ew4);
            int iO = o(ew4);
            if (iO == 9) {
                return map;
            }
            Object objH = h(ew4, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    private static ArrayList m(EW4 ew4) {
        int iJ = ew4.J();
        ArrayList arrayList = new ArrayList(iJ);
        for (int i = 0; i < iJ; i++) {
            Object objH = h(ew4, o(ew4));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    private static String n(EW4 ew4) {
        int iL = ew4.L();
        int iF = ew4.f();
        ew4.T(iL);
        return new String(ew4.e(), iF, iL);
    }

    private static int o(EW4 ew4) {
        return ew4.F();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(EW4 ew4) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(EW4 ew4, long j) {
        if (o(ew4) != 2 || !"onMetaData".equals(n(ew4)) || ew4.a() == 0 || o(ew4) != 8) {
            return false;
        }
        HashMap mapK = k(ew4);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
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

    public long d() {
        return this.b;
    }

    public long[] e() {
        return this.d;
    }

    public long[] f() {
        return this.c;
    }
}
