package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Rl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC7376Rl3 {
    BOOLEAN(EnumC4809Gq5.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(EnumC4809Gq5.CHAR, "char", TokenNames.C, "java.lang.Character"),
    BYTE(EnumC4809Gq5.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(EnumC4809Gq5.SHORT, "short", TokenNames.S, "java.lang.Short"),
    INT(EnumC4809Gq5.INT, "int", TokenNames.I, "java.lang.Integer"),
    FLOAT(EnumC4809Gq5.FLOAT, "float", TokenNames.F, "java.lang.Float"),
    LONG(EnumC4809Gq5.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(EnumC4809Gq5.DOUBLE, "double", "D", "java.lang.Double");

    private static final Set m = new HashSet();
    private static final Map n = new HashMap();
    private static final Map o = new EnumMap(EnumC4809Gq5.class);
    private static final Map p = new HashMap();
    private final EnumC4809Gq5 a;
    private final String b;
    private final String c;
    private final C9424Zw2 d;

    static {
        for (EnumC7376Rl3 enumC7376Rl3 : values()) {
            m.add(enumC7376Rl3.u());
            n.put(enumC7376Rl3.r(), enumC7376Rl3);
            o.put(enumC7376Rl3.s(), enumC7376Rl3);
            p.put(enumC7376Rl3.q(), enumC7376Rl3);
        }
    }

    EnumC7376Rl3(EnumC4809Gq5 enumC4809Gq5, String str, String str2, String str3) {
        if (enumC4809Gq5 == null) {
            a(6);
        }
        if (str == null) {
            a(7);
        }
        if (str2 == null) {
            a(8);
        }
        if (str3 == null) {
            a(9);
        }
        this.a = enumC4809Gq5;
        this.b = str;
        this.c = str2;
        this.d = new C9424Zw2(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r7) {
        /*
            r0 = 4
            r1 = 2
            if (r7 == r1) goto Lc
            if (r7 == r0) goto Lc
            switch(r7) {
                case 10: goto Lc;
                case 11: goto Lc;
                case 12: goto Lc;
                case 13: goto Lc;
                default: goto L9;
            }
        L9:
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        Le:
            if (r7 == r1) goto L17
            if (r7 == r0) goto L17
            switch(r7) {
                case 10: goto L17;
                case 11: goto L17;
                case 12: goto L17;
                case 13: goto L17;
                default: goto L15;
            }
        L15:
            r3 = 3
            goto L18
        L17:
            r3 = r1
        L18:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType"
            r5 = 0
            switch(r7) {
                case 1: goto L3c;
                case 2: goto L39;
                case 3: goto L34;
                case 4: goto L39;
                case 5: goto L2f;
                case 6: goto L2a;
                case 7: goto L3c;
                case 8: goto L2f;
                case 9: goto L25;
                case 10: goto L39;
                case 11: goto L39;
                case 12: goto L39;
                case 13: goto L39;
                default: goto L20;
            }
        L20:
            java.lang.String r6 = "className"
            r3[r5] = r6
            goto L40
        L25:
            java.lang.String r6 = "wrapperClassName"
            r3[r5] = r6
            goto L40
        L2a:
            java.lang.String r6 = "primitiveType"
            r3[r5] = r6
            goto L40
        L2f:
            java.lang.String r6 = "desc"
            r3[r5] = r6
            goto L40
        L34:
            java.lang.String r6 = "type"
            r3[r5] = r6
            goto L40
        L39:
            r3[r5] = r4
            goto L40
        L3c:
            java.lang.String r6 = "name"
            r3[r5] = r6
        L40:
            java.lang.String r5 = "get"
            r6 = 1
            if (r7 == r1) goto L61
            if (r7 == r0) goto L61
            switch(r7) {
                case 10: goto L5c;
                case 11: goto L57;
                case 12: goto L52;
                case 13: goto L4d;
                default: goto L4a;
            }
        L4a:
            r3[r6] = r4
            goto L63
        L4d:
            java.lang.String r4 = "getWrapperFqName"
            r3[r6] = r4
            goto L63
        L52:
            java.lang.String r4 = "getDesc"
            r3[r6] = r4
            goto L63
        L57:
            java.lang.String r4 = "getJavaKeywordName"
            r3[r6] = r4
            goto L63
        L5c:
            java.lang.String r4 = "getPrimitiveType"
            r3[r6] = r4
            goto L63
        L61:
            r3[r6] = r5
        L63:
            switch(r7) {
                case 1: goto L75;
                case 2: goto L77;
                case 3: goto L75;
                case 4: goto L77;
                case 5: goto L70;
                case 6: goto L6b;
                case 7: goto L6b;
                case 8: goto L6b;
                case 9: goto L6b;
                case 10: goto L77;
                case 11: goto L77;
                case 12: goto L77;
                case 13: goto L77;
                default: goto L66;
            }
        L66:
            java.lang.String r4 = "isWrapperClassName"
            r3[r1] = r4
            goto L77
        L6b:
            java.lang.String r4 = "<init>"
            r3[r1] = r4
            goto L77
        L70:
            java.lang.String r4 = "getByDesc"
            r3[r1] = r4
            goto L77
        L75:
            r3[r1] = r5
        L77:
            java.lang.String r2 = java.lang.String.format(r2, r3)
            if (r7 == r1) goto L88
            if (r7 == r0) goto L88
            switch(r7) {
                case 10: goto L88;
                case 11: goto L88;
                case 12: goto L88;
                case 13: goto L88;
                default: goto L82;
            }
        L82:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>(r2)
            goto L8d
        L88:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r2)
        L8d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EnumC7376Rl3.a(int):void");
    }

    public static EnumC7376Rl3 j(EnumC4809Gq5 enumC4809Gq5) {
        if (enumC4809Gq5 == null) {
            a(3);
        }
        EnumC7376Rl3 enumC7376Rl3 = (EnumC7376Rl3) o.get(enumC4809Gq5);
        if (enumC7376Rl3 == null) {
            a(4);
        }
        return enumC7376Rl3;
    }

    public static EnumC7376Rl3 p(String str) {
        if (str == null) {
            a(1);
        }
        EnumC7376Rl3 enumC7376Rl3 = (EnumC7376Rl3) n.get(str);
        if (enumC7376Rl3 != null) {
            return enumC7376Rl3;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public String q() {
        String str = this.c;
        if (str == null) {
            a(12);
        }
        return str;
    }

    public String r() {
        String str = this.b;
        if (str == null) {
            a(11);
        }
        return str;
    }

    public EnumC4809Gq5 s() {
        EnumC4809Gq5 enumC4809Gq5 = this.a;
        if (enumC4809Gq5 == null) {
            a(10);
        }
        return enumC4809Gq5;
    }

    public C9424Zw2 u() {
        C9424Zw2 c9424Zw2 = this.d;
        if (c9424Zw2 == null) {
            a(13);
        }
        return c9424Zw2;
    }
}
