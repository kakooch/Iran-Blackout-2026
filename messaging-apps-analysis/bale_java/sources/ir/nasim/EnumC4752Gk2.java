package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: ir.nasim.Gk2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC4752Gk2 {
    public static final EnumC4752Gk2 A;
    public static final EnumC4752Gk2 A0;
    public static final EnumC4752Gk2 B;
    public static final EnumC4752Gk2 B0;
    public static final EnumC4752Gk2 C0;
    public static final EnumC4752Gk2 D;
    public static final EnumC4752Gk2 D0;
    public static final EnumC4752Gk2 E0;
    public static final EnumC4752Gk2 F0;
    public static final EnumC4752Gk2 G;
    public static final EnumC4752Gk2 G0;
    public static final EnumC4752Gk2 H;
    public static final EnumC4752Gk2 H0;
    public static final EnumC4752Gk2 I0;
    public static final EnumC4752Gk2 J;
    public static final EnumC4752Gk2 J0;
    public static final EnumC4752Gk2 K0;
    public static final EnumC4752Gk2 L0;
    public static final EnumC4752Gk2 M0;
    public static final EnumC4752Gk2 N0;
    public static final EnumC4752Gk2 O0;
    public static final EnumC4752Gk2 P0;
    public static final EnumC4752Gk2 Q0;
    public static final EnumC4752Gk2 R0;
    public static final EnumC4752Gk2 S0;
    public static final EnumC4752Gk2 T0;
    public static final EnumC4752Gk2 U0;
    private static final EnumC4752Gk2[] V0;
    private static final Type[] W0;
    private static final /* synthetic */ EnumC4752Gk2[] X0;
    public static final EnumC4752Gk2 Y;
    public static final EnumC4752Gk2 Z;
    public static final EnumC4752Gk2 f;
    public static final EnumC4752Gk2 g;
    public static final EnumC4752Gk2 h;
    public static final EnumC4752Gk2 i;
    public static final EnumC4752Gk2 j;
    public static final EnumC4752Gk2 k;
    public static final EnumC4752Gk2 l;
    public static final EnumC4752Gk2 m;
    public static final EnumC4752Gk2 n;
    public static final EnumC4752Gk2 o;
    public static final EnumC4752Gk2 p;
    public static final EnumC4752Gk2 q;
    public static final EnumC4752Gk2 r;
    public static final EnumC4752Gk2 s;
    public static final EnumC4752Gk2 t;
    public static final EnumC4752Gk2 u;
    public static final EnumC4752Gk2 v;
    public static final EnumC4752Gk2 w;
    public static final EnumC4752Gk2 x;
    public static final EnumC4752Gk2 y;
    public static final EnumC4752Gk2 z;
    public static final EnumC4752Gk2 z0;
    private final EnumC5671Ki3 a;
    private final int b;
    private final b c;
    private final Class d;
    private final boolean e;

    /* renamed from: ir.nasim.Gk2$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC5671Ki3.values().length];
            b = iArr;
            try {
                iArr[EnumC5671Ki3.k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC5671Ki3.m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC5671Ki3.j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            a = iArr2;
            try {
                iArr2[b.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.VECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: ir.nasim.Gk2$b */
    enum b {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);

        private final boolean a;

        b(boolean z) {
            this.a = z;
        }
    }

    static {
        b bVar = b.SCALAR;
        EnumC5671Ki3 enumC5671Ki3 = EnumC5671Ki3.h;
        EnumC4752Gk2 enumC4752Gk2 = new EnumC4752Gk2("DOUBLE", 0, 0, bVar, enumC5671Ki3);
        f = enumC4752Gk2;
        EnumC5671Ki3 enumC5671Ki32 = EnumC5671Ki3.g;
        EnumC4752Gk2 enumC4752Gk22 = new EnumC4752Gk2("FLOAT", 1, 1, bVar, enumC5671Ki32);
        g = enumC4752Gk22;
        EnumC5671Ki3 enumC5671Ki33 = EnumC5671Ki3.f;
        EnumC4752Gk2 enumC4752Gk23 = new EnumC4752Gk2("INT64", 2, 2, bVar, enumC5671Ki33);
        h = enumC4752Gk23;
        EnumC4752Gk2 enumC4752Gk24 = new EnumC4752Gk2("UINT64", 3, 3, bVar, enumC5671Ki33);
        i = enumC4752Gk24;
        EnumC5671Ki3 enumC5671Ki34 = EnumC5671Ki3.e;
        EnumC4752Gk2 enumC4752Gk25 = new EnumC4752Gk2("INT32", 4, 4, bVar, enumC5671Ki34);
        j = enumC4752Gk25;
        EnumC4752Gk2 enumC4752Gk26 = new EnumC4752Gk2("FIXED64", 5, 5, bVar, enumC5671Ki33);
        k = enumC4752Gk26;
        EnumC4752Gk2 enumC4752Gk27 = new EnumC4752Gk2("FIXED32", 6, 6, bVar, enumC5671Ki34);
        l = enumC4752Gk27;
        EnumC5671Ki3 enumC5671Ki35 = EnumC5671Ki3.i;
        EnumC4752Gk2 enumC4752Gk28 = new EnumC4752Gk2("BOOL", 7, 7, bVar, enumC5671Ki35);
        m = enumC4752Gk28;
        EnumC5671Ki3 enumC5671Ki36 = EnumC5671Ki3.j;
        EnumC4752Gk2 enumC4752Gk29 = new EnumC4752Gk2("STRING", 8, 8, bVar, enumC5671Ki36);
        n = enumC4752Gk29;
        EnumC5671Ki3 enumC5671Ki37 = EnumC5671Ki3.m;
        EnumC4752Gk2 enumC4752Gk210 = new EnumC4752Gk2(TokenNames.MESSAGE, 9, 9, bVar, enumC5671Ki37);
        o = enumC4752Gk210;
        EnumC5671Ki3 enumC5671Ki38 = EnumC5671Ki3.k;
        EnumC4752Gk2 enumC4752Gk211 = new EnumC4752Gk2("BYTES", 10, 10, bVar, enumC5671Ki38);
        p = enumC4752Gk211;
        EnumC4752Gk2 enumC4752Gk212 = new EnumC4752Gk2("UINT32", 11, 11, bVar, enumC5671Ki34);
        q = enumC4752Gk212;
        EnumC5671Ki3 enumC5671Ki39 = EnumC5671Ki3.l;
        EnumC4752Gk2 enumC4752Gk213 = new EnumC4752Gk2("ENUM", 12, 12, bVar, enumC5671Ki39);
        r = enumC4752Gk213;
        EnumC4752Gk2 enumC4752Gk214 = new EnumC4752Gk2("SFIXED32", 13, 13, bVar, enumC5671Ki34);
        s = enumC4752Gk214;
        EnumC4752Gk2 enumC4752Gk215 = new EnumC4752Gk2("SFIXED64", 14, 14, bVar, enumC5671Ki33);
        t = enumC4752Gk215;
        EnumC4752Gk2 enumC4752Gk216 = new EnumC4752Gk2("SINT32", 15, 15, bVar, enumC5671Ki34);
        u = enumC4752Gk216;
        EnumC4752Gk2 enumC4752Gk217 = new EnumC4752Gk2("SINT64", 16, 16, bVar, enumC5671Ki33);
        v = enumC4752Gk217;
        EnumC4752Gk2 enumC4752Gk218 = new EnumC4752Gk2("GROUP", 17, 17, bVar, enumC5671Ki37);
        w = enumC4752Gk218;
        b bVar2 = b.VECTOR;
        EnumC4752Gk2 enumC4752Gk219 = new EnumC4752Gk2("DOUBLE_LIST", 18, 18, bVar2, enumC5671Ki3);
        x = enumC4752Gk219;
        EnumC4752Gk2 enumC4752Gk220 = new EnumC4752Gk2("FLOAT_LIST", 19, 19, bVar2, enumC5671Ki32);
        y = enumC4752Gk220;
        EnumC4752Gk2 enumC4752Gk221 = new EnumC4752Gk2("INT64_LIST", 20, 20, bVar2, enumC5671Ki33);
        z = enumC4752Gk221;
        EnumC4752Gk2 enumC4752Gk222 = new EnumC4752Gk2("UINT64_LIST", 21, 21, bVar2, enumC5671Ki33);
        A = enumC4752Gk222;
        EnumC4752Gk2 enumC4752Gk223 = new EnumC4752Gk2("INT32_LIST", 22, 22, bVar2, enumC5671Ki34);
        B = enumC4752Gk223;
        EnumC4752Gk2 enumC4752Gk224 = new EnumC4752Gk2("FIXED64_LIST", 23, 23, bVar2, enumC5671Ki33);
        D = enumC4752Gk224;
        EnumC4752Gk2 enumC4752Gk225 = new EnumC4752Gk2("FIXED32_LIST", 24, 24, bVar2, enumC5671Ki34);
        G = enumC4752Gk225;
        EnumC4752Gk2 enumC4752Gk226 = new EnumC4752Gk2("BOOL_LIST", 25, 25, bVar2, enumC5671Ki35);
        H = enumC4752Gk226;
        EnumC4752Gk2 enumC4752Gk227 = new EnumC4752Gk2("STRING_LIST", 26, 26, bVar2, enumC5671Ki36);
        J = enumC4752Gk227;
        EnumC4752Gk2 enumC4752Gk228 = new EnumC4752Gk2("MESSAGE_LIST", 27, 27, bVar2, enumC5671Ki37);
        Y = enumC4752Gk228;
        EnumC4752Gk2 enumC4752Gk229 = new EnumC4752Gk2("BYTES_LIST", 28, 28, bVar2, enumC5671Ki38);
        Z = enumC4752Gk229;
        EnumC4752Gk2 enumC4752Gk230 = new EnumC4752Gk2("UINT32_LIST", 29, 29, bVar2, enumC5671Ki34);
        z0 = enumC4752Gk230;
        EnumC4752Gk2 enumC4752Gk231 = new EnumC4752Gk2("ENUM_LIST", 30, 30, bVar2, enumC5671Ki39);
        A0 = enumC4752Gk231;
        EnumC4752Gk2 enumC4752Gk232 = new EnumC4752Gk2("SFIXED32_LIST", 31, 31, bVar2, enumC5671Ki34);
        B0 = enumC4752Gk232;
        EnumC4752Gk2 enumC4752Gk233 = new EnumC4752Gk2("SFIXED64_LIST", 32, 32, bVar2, enumC5671Ki33);
        C0 = enumC4752Gk233;
        EnumC4752Gk2 enumC4752Gk234 = new EnumC4752Gk2("SINT32_LIST", 33, 33, bVar2, enumC5671Ki34);
        D0 = enumC4752Gk234;
        EnumC4752Gk2 enumC4752Gk235 = new EnumC4752Gk2("SINT64_LIST", 34, 34, bVar2, enumC5671Ki33);
        E0 = enumC4752Gk235;
        b bVar3 = b.PACKED_VECTOR;
        EnumC4752Gk2 enumC4752Gk236 = new EnumC4752Gk2("DOUBLE_LIST_PACKED", 35, 35, bVar3, enumC5671Ki3);
        F0 = enumC4752Gk236;
        EnumC4752Gk2 enumC4752Gk237 = new EnumC4752Gk2("FLOAT_LIST_PACKED", 36, 36, bVar3, enumC5671Ki32);
        G0 = enumC4752Gk237;
        EnumC4752Gk2 enumC4752Gk238 = new EnumC4752Gk2("INT64_LIST_PACKED", 37, 37, bVar3, enumC5671Ki33);
        H0 = enumC4752Gk238;
        EnumC4752Gk2 enumC4752Gk239 = new EnumC4752Gk2("UINT64_LIST_PACKED", 38, 38, bVar3, enumC5671Ki33);
        I0 = enumC4752Gk239;
        EnumC4752Gk2 enumC4752Gk240 = new EnumC4752Gk2("INT32_LIST_PACKED", 39, 39, bVar3, enumC5671Ki34);
        J0 = enumC4752Gk240;
        EnumC4752Gk2 enumC4752Gk241 = new EnumC4752Gk2("FIXED64_LIST_PACKED", 40, 40, bVar3, enumC5671Ki33);
        K0 = enumC4752Gk241;
        EnumC4752Gk2 enumC4752Gk242 = new EnumC4752Gk2("FIXED32_LIST_PACKED", 41, 41, bVar3, enumC5671Ki34);
        L0 = enumC4752Gk242;
        EnumC4752Gk2 enumC4752Gk243 = new EnumC4752Gk2("BOOL_LIST_PACKED", 42, 42, bVar3, enumC5671Ki35);
        M0 = enumC4752Gk243;
        EnumC4752Gk2 enumC4752Gk244 = new EnumC4752Gk2("UINT32_LIST_PACKED", 43, 43, bVar3, enumC5671Ki34);
        N0 = enumC4752Gk244;
        EnumC4752Gk2 enumC4752Gk245 = new EnumC4752Gk2("ENUM_LIST_PACKED", 44, 44, bVar3, enumC5671Ki39);
        O0 = enumC4752Gk245;
        EnumC4752Gk2 enumC4752Gk246 = new EnumC4752Gk2("SFIXED32_LIST_PACKED", 45, 45, bVar3, enumC5671Ki34);
        P0 = enumC4752Gk246;
        EnumC4752Gk2 enumC4752Gk247 = new EnumC4752Gk2("SFIXED64_LIST_PACKED", 46, 46, bVar3, enumC5671Ki33);
        Q0 = enumC4752Gk247;
        EnumC4752Gk2 enumC4752Gk248 = new EnumC4752Gk2("SINT32_LIST_PACKED", 47, 47, bVar3, enumC5671Ki34);
        R0 = enumC4752Gk248;
        EnumC4752Gk2 enumC4752Gk249 = new EnumC4752Gk2("SINT64_LIST_PACKED", 48, 48, bVar3, enumC5671Ki33);
        S0 = enumC4752Gk249;
        EnumC4752Gk2 enumC4752Gk250 = new EnumC4752Gk2("GROUP_LIST", 49, 49, bVar2, enumC5671Ki37);
        T0 = enumC4752Gk250;
        EnumC4752Gk2 enumC4752Gk251 = new EnumC4752Gk2("MAP", 50, 50, b.MAP, EnumC5671Ki3.d);
        U0 = enumC4752Gk251;
        X0 = new EnumC4752Gk2[]{enumC4752Gk2, enumC4752Gk22, enumC4752Gk23, enumC4752Gk24, enumC4752Gk25, enumC4752Gk26, enumC4752Gk27, enumC4752Gk28, enumC4752Gk29, enumC4752Gk210, enumC4752Gk211, enumC4752Gk212, enumC4752Gk213, enumC4752Gk214, enumC4752Gk215, enumC4752Gk216, enumC4752Gk217, enumC4752Gk218, enumC4752Gk219, enumC4752Gk220, enumC4752Gk221, enumC4752Gk222, enumC4752Gk223, enumC4752Gk224, enumC4752Gk225, enumC4752Gk226, enumC4752Gk227, enumC4752Gk228, enumC4752Gk229, enumC4752Gk230, enumC4752Gk231, enumC4752Gk232, enumC4752Gk233, enumC4752Gk234, enumC4752Gk235, enumC4752Gk236, enumC4752Gk237, enumC4752Gk238, enumC4752Gk239, enumC4752Gk240, enumC4752Gk241, enumC4752Gk242, enumC4752Gk243, enumC4752Gk244, enumC4752Gk245, enumC4752Gk246, enumC4752Gk247, enumC4752Gk248, enumC4752Gk249, enumC4752Gk250, enumC4752Gk251};
        W0 = new Type[0];
        EnumC4752Gk2[] enumC4752Gk2ArrValues = values();
        V0 = new EnumC4752Gk2[enumC4752Gk2ArrValues.length];
        for (EnumC4752Gk2 enumC4752Gk252 : enumC4752Gk2ArrValues) {
            V0[enumC4752Gk252.b] = enumC4752Gk252;
        }
    }

    private EnumC4752Gk2(String str, int i2, int i3, b bVar, EnumC5671Ki3 enumC5671Ki3) {
        int i4;
        this.b = i3;
        this.c = bVar;
        this.a = enumC5671Ki3;
        int i5 = a.a[bVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.d = enumC5671Ki3.a();
        } else {
            this.d = null;
        }
        this.e = (bVar != b.SCALAR || (i4 = a.b[enumC5671Ki3.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : true;
    }

    public static EnumC4752Gk2 valueOf(String str) {
        return (EnumC4752Gk2) Enum.valueOf(EnumC4752Gk2.class, str);
    }

    public static EnumC4752Gk2[] values() {
        return (EnumC4752Gk2[]) X0.clone();
    }

    public int a() {
        return this.b;
    }
}
