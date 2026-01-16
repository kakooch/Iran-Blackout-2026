package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DISTINCT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
final class V2 {
    public static final V2 DISTINCT;
    public static final V2 ORDERED;
    public static final V2 SHORT_CIRCUIT;
    public static final V2 SIZED;
    public static final V2 SORTED;
    static final int a;
    static final int b;
    static final int c;
    private static final int d;
    private static final int e;
    private static final int f;
    static final int g;
    static final int h;
    static final int i;
    static final int j;
    static final int k;
    static final int l;
    static final int m;
    static final int n;
    static final int o;
    static final int p;
    private static final /* synthetic */ V2[] q;
    private final Map r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;

    private static class a {
        final Map a;

        a(Map map) {
            this.a = map;
        }

        a a(b bVar) {
            this.a.put(bVar, 2);
            return this;
        }

        a b(b bVar) {
            this.a.put(bVar, 1);
            return this;
        }

        a c(b bVar) {
            this.a.put(bVar, 3);
            return this;
        }
    }

    enum b {
        SPLITERATOR,
        STREAM,
        OP,
        TERMINAL_OP,
        UPSTREAM_TERMINAL_OP
    }

    static {
        b bVar = b.SPLITERATOR;
        a aVarV = v(bVar);
        b bVar2 = b.STREAM;
        aVarV.b(bVar2);
        b bVar3 = b.OP;
        aVarV.c(bVar3);
        V2 v2 = new V2("DISTINCT", 0, 0, aVarV);
        DISTINCT = v2;
        a aVarV2 = v(bVar);
        aVarV2.b(bVar2);
        aVarV2.c(bVar3);
        V2 v22 = new V2("SORTED", 1, 1, aVarV2);
        SORTED = v22;
        a aVarV3 = v(bVar);
        aVarV3.b(bVar2);
        aVarV3.c(bVar3);
        b bVar4 = b.TERMINAL_OP;
        aVarV3.a(bVar4);
        b bVar5 = b.UPSTREAM_TERMINAL_OP;
        aVarV3.a(bVar5);
        V2 v23 = new V2("ORDERED", 2, 2, aVarV3);
        ORDERED = v23;
        a aVarV4 = v(bVar);
        aVarV4.b(bVar2);
        aVarV4.a(bVar3);
        V2 v24 = new V2("SIZED", 3, 3, aVarV4);
        SIZED = v24;
        a aVarV5 = v(bVar3);
        aVarV5.b(bVar4);
        V2 v25 = new V2("SHORT_CIRCUIT", 4, 12, aVarV5);
        SHORT_CIRCUIT = v25;
        q = new V2[]{v2, v22, v23, v24, v25};
        a = j(bVar);
        int iJ = j(bVar2);
        b = iJ;
        c = j(bVar3);
        j(bVar4);
        j(bVar5);
        V2[] v2ArrValues = values();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            i2 |= v2ArrValues[i3].v;
        }
        d = i2;
        e = iJ;
        int i4 = iJ << 1;
        f = i4;
        g = iJ | i4;
        h = v2.t;
        i = v2.u;
        j = v22.t;
        k = v22.u;
        l = v23.t;
        m = v23.u;
        n = v24.t;
        o = v24.u;
        p = v25.t;
    }

    private V2(String str, int i2, int i3, a aVar) {
        b[] bVarArrValues = b.values();
        for (int i4 = 0; i4 < 5; i4++) {
            b bVar = bVarArrValues[i4];
            Map map = aVar.a;
            if (map instanceof j$.util.Map) {
                ((j$.util.Map) map).putIfAbsent(bVar, 0);
            } else {
                Map.CC.$default$putIfAbsent(map, bVar, 0);
            }
        }
        this.r = aVar.a;
        int i5 = i3 * 2;
        this.s = i5;
        this.t = 1 << i5;
        this.u = 2 << i5;
        this.v = 3 << i5;
    }

    static int h(int i2, int i3) {
        return i2 | (i3 & (i2 == 0 ? d : ((((e & i2) << 1) | i2) | ((f & i2) >> 1)) ^ (-1)));
    }

    private static int j(b bVar) {
        V2[] v2ArrValues = values();
        int iIntValue = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            V2 v2 = v2ArrValues[i2];
            iIntValue |= ((Integer) v2.r.get(bVar)).intValue() << v2.s;
        }
        return iIntValue;
    }

    static int l(Spliterator spliterator) {
        int iCharacteristics = spliterator.characteristics();
        return ((iCharacteristics & 4) == 0 || spliterator.getComparator() == null) ? a & iCharacteristics : a & iCharacteristics & (-5);
    }

    private static a v(b bVar) {
        EnumMap enumMap = new EnumMap(b.class);
        a aVar = new a(enumMap);
        enumMap.put((EnumMap) bVar, (b) 1);
        return aVar;
    }

    public static V2 valueOf(String str) {
        return (V2) Enum.valueOf(V2.class, str);
    }

    public static V2[] values() {
        return (V2[]) q.clone();
    }

    static int w(int i2) {
        return i2 & ((i2 ^ (-1)) >> 1) & e;
    }

    boolean n(int i2) {
        return (i2 & this.v) == this.t;
    }

    boolean t(int i2) {
        int i3 = this.v;
        return (i2 & i3) == i3;
    }
}
