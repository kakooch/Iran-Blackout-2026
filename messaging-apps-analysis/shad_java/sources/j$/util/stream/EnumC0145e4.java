package j$.util.stream;

import j$.util.Map;
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
/* renamed from: j$.util.stream.e4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class EnumC0145e4 {
    public static final EnumC0145e4 DISTINCT;
    public static final EnumC0145e4 ORDERED;
    public static final EnumC0145e4 SHORT_CIRCUIT;
    public static final EnumC0145e4 SIZED;
    public static final EnumC0145e4 SORTED;
    static final int f;
    static final int g;
    static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    static final int l;
    static final int m;
    static final int n;
    static final int o;
    static final int p;
    static final int q;
    static final int r;
    static final int s;
    static final int t;
    static final int u;
    private static final /* synthetic */ EnumC0145e4[] v;
    private final Map a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    static {
        EnumC0139d4 enumC0139d4 = EnumC0139d4.SPLITERATOR;
        C0133c4 c0133c4F = f(enumC0139d4);
        EnumC0139d4 enumC0139d42 = EnumC0139d4.STREAM;
        c0133c4F.b(enumC0139d42);
        EnumC0139d4 enumC0139d43 = EnumC0139d4.OP;
        c0133c4F.c(enumC0139d43);
        EnumC0145e4 enumC0145e4 = new EnumC0145e4("DISTINCT", 0, 0, c0133c4F);
        DISTINCT = enumC0145e4;
        C0133c4 c0133c4F2 = f(enumC0139d4);
        c0133c4F2.b(enumC0139d42);
        c0133c4F2.c(enumC0139d43);
        EnumC0145e4 enumC0145e42 = new EnumC0145e4("SORTED", 1, 1, c0133c4F2);
        SORTED = enumC0145e42;
        C0133c4 c0133c4F3 = f(enumC0139d4);
        c0133c4F3.b(enumC0139d42);
        c0133c4F3.c(enumC0139d43);
        EnumC0139d4 enumC0139d44 = EnumC0139d4.TERMINAL_OP;
        c0133c4F3.a(enumC0139d44);
        EnumC0139d4 enumC0139d45 = EnumC0139d4.UPSTREAM_TERMINAL_OP;
        c0133c4F3.a(enumC0139d45);
        EnumC0145e4 enumC0145e43 = new EnumC0145e4("ORDERED", 2, 2, c0133c4F3);
        ORDERED = enumC0145e43;
        C0133c4 c0133c4F4 = f(enumC0139d4);
        c0133c4F4.b(enumC0139d42);
        c0133c4F4.a(enumC0139d43);
        EnumC0145e4 enumC0145e44 = new EnumC0145e4("SIZED", 3, 3, c0133c4F4);
        SIZED = enumC0145e44;
        C0133c4 c0133c4F5 = f(enumC0139d43);
        c0133c4F5.b(enumC0139d44);
        EnumC0145e4 enumC0145e45 = new EnumC0145e4("SHORT_CIRCUIT", 4, 12, c0133c4F5);
        SHORT_CIRCUIT = enumC0145e45;
        v = new EnumC0145e4[]{enumC0145e4, enumC0145e42, enumC0145e43, enumC0145e44, enumC0145e45};
        f = b(enumC0139d4);
        int iB = b(enumC0139d42);
        g = iB;
        h = b(enumC0139d43);
        b(enumC0139d44);
        b(enumC0139d45);
        int i2 = 0;
        for (EnumC0145e4 enumC0145e46 : values()) {
            i2 |= enumC0145e46.e;
        }
        i = i2;
        j = iB;
        int i3 = iB << 1;
        k = i3;
        l = iB | i3;
        m = enumC0145e4.c;
        n = enumC0145e4.d;
        o = enumC0145e42.c;
        p = enumC0145e42.d;
        q = enumC0145e43.c;
        r = enumC0145e43.d;
        s = enumC0145e44.c;
        t = enumC0145e44.d;
        u = enumC0145e45.c;
    }

    private EnumC0145e4(String str, int i2, int i3, C0133c4 c0133c4) {
        for (EnumC0139d4 enumC0139d4 : EnumC0139d4.values()) {
            Map map = c0133c4.a;
            if (map instanceof j$.util.Map) {
                ((j$.util.Map) map).putIfAbsent(enumC0139d4, 0);
            } else {
                Map.CC.$default$putIfAbsent(map, enumC0139d4, 0);
            }
        }
        this.a = c0133c4.a;
        int i4 = i3 * 2;
        this.b = i4;
        this.c = 1 << i4;
        this.d = 2 << i4;
        this.e = 3 << i4;
    }

    static int a(int i2, int i3) {
        return i2 | (i3 & (i2 == 0 ? i : ((((j & i2) << 1) | i2) | ((k & i2) >> 1)) ^ (-1)));
    }

    private static int b(EnumC0139d4 enumC0139d4) {
        int iIntValue = 0;
        for (EnumC0145e4 enumC0145e4 : values()) {
            iIntValue |= ((Integer) enumC0145e4.a.get(enumC0139d4)).intValue() << enumC0145e4.b;
        }
        return iIntValue;
    }

    static int c(j$.util.t tVar) {
        int iCharacteristics = tVar.characteristics();
        return ((iCharacteristics & 4) == 0 || tVar.getComparator() == null) ? f & iCharacteristics : f & iCharacteristics & (-5);
    }

    private static C0133c4 f(EnumC0139d4 enumC0139d4) {
        EnumMap enumMap = new EnumMap(EnumC0139d4.class);
        C0133c4 c0133c4 = new C0133c4(enumMap);
        enumMap.put((EnumMap) enumC0139d4, (EnumC0139d4) 1);
        return c0133c4;
    }

    static int g(int i2) {
        return i2 & ((i2 ^ (-1)) >> 1) & j;
    }

    public static EnumC0145e4 valueOf(String str) {
        return (EnumC0145e4) Enum.valueOf(EnumC0145e4.class, str);
    }

    public static EnumC0145e4[] values() {
        return (EnumC0145e4[]) v.clone();
    }

    boolean d(int i2) {
        return (i2 & this.e) == this.c;
    }

    boolean e(int i2) {
        int i3 = this.e;
        return (i2 & i3) == i3;
    }
}
