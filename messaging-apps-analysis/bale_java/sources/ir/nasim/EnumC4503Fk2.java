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
/* renamed from: ir.nasim.Fk2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC4503Fk2 {
    public static final EnumC4503Fk2 A;
    public static final EnumC4503Fk2 A0;
    public static final EnumC4503Fk2 B;
    public static final EnumC4503Fk2 B0;
    public static final EnumC4503Fk2 C0;
    public static final EnumC4503Fk2 D;
    public static final EnumC4503Fk2 D0;
    public static final EnumC4503Fk2 E0;
    public static final EnumC4503Fk2 F0;
    public static final EnumC4503Fk2 G;
    public static final EnumC4503Fk2 G0;
    public static final EnumC4503Fk2 H;
    public static final EnumC4503Fk2 H0;
    public static final EnumC4503Fk2 I0;
    public static final EnumC4503Fk2 J;
    public static final EnumC4503Fk2 J0;
    public static final EnumC4503Fk2 K0;
    public static final EnumC4503Fk2 L0;
    public static final EnumC4503Fk2 M0;
    public static final EnumC4503Fk2 N0;
    public static final EnumC4503Fk2 O0;
    public static final EnumC4503Fk2 P0;
    public static final EnumC4503Fk2 Q0;
    public static final EnumC4503Fk2 R0;
    public static final EnumC4503Fk2 S0;
    public static final EnumC4503Fk2 T0;
    public static final EnumC4503Fk2 U0;
    private static final EnumC4503Fk2[] V0;
    private static final Type[] W0;
    private static final /* synthetic */ EnumC4503Fk2[] X0;
    public static final EnumC4503Fk2 Y;
    public static final EnumC4503Fk2 Z;
    public static final EnumC4503Fk2 f;
    public static final EnumC4503Fk2 g;
    public static final EnumC4503Fk2 h;
    public static final EnumC4503Fk2 i;
    public static final EnumC4503Fk2 j;
    public static final EnumC4503Fk2 k;
    public static final EnumC4503Fk2 l;
    public static final EnumC4503Fk2 m;
    public static final EnumC4503Fk2 n;
    public static final EnumC4503Fk2 o;
    public static final EnumC4503Fk2 p;
    public static final EnumC4503Fk2 q;
    public static final EnumC4503Fk2 r;
    public static final EnumC4503Fk2 s;
    public static final EnumC4503Fk2 t;
    public static final EnumC4503Fk2 u;
    public static final EnumC4503Fk2 v;
    public static final EnumC4503Fk2 w;
    public static final EnumC4503Fk2 x;
    public static final EnumC4503Fk2 y;
    public static final EnumC4503Fk2 z;
    public static final EnumC4503Fk2 z0;
    private final EnumC6377Ni3 a;
    private final int b;
    private final b c;
    private final Class d;
    private final boolean e;

    /* renamed from: ir.nasim.Fk2$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC6377Ni3.values().length];
            b = iArr;
            try {
                iArr[EnumC6377Ni3.k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC6377Ni3.m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC6377Ni3.j.ordinal()] = 3;
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

    /* renamed from: ir.nasim.Fk2$b */
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
        EnumC6377Ni3 enumC6377Ni3 = EnumC6377Ni3.h;
        EnumC4503Fk2 enumC4503Fk2 = new EnumC4503Fk2("DOUBLE", 0, 0, bVar, enumC6377Ni3);
        f = enumC4503Fk2;
        EnumC6377Ni3 enumC6377Ni32 = EnumC6377Ni3.g;
        EnumC4503Fk2 enumC4503Fk22 = new EnumC4503Fk2("FLOAT", 1, 1, bVar, enumC6377Ni32);
        g = enumC4503Fk22;
        EnumC6377Ni3 enumC6377Ni33 = EnumC6377Ni3.f;
        EnumC4503Fk2 enumC4503Fk23 = new EnumC4503Fk2("INT64", 2, 2, bVar, enumC6377Ni33);
        h = enumC4503Fk23;
        EnumC4503Fk2 enumC4503Fk24 = new EnumC4503Fk2("UINT64", 3, 3, bVar, enumC6377Ni33);
        i = enumC4503Fk24;
        EnumC6377Ni3 enumC6377Ni34 = EnumC6377Ni3.e;
        EnumC4503Fk2 enumC4503Fk25 = new EnumC4503Fk2("INT32", 4, 4, bVar, enumC6377Ni34);
        j = enumC4503Fk25;
        EnumC4503Fk2 enumC4503Fk26 = new EnumC4503Fk2("FIXED64", 5, 5, bVar, enumC6377Ni33);
        k = enumC4503Fk26;
        EnumC4503Fk2 enumC4503Fk27 = new EnumC4503Fk2("FIXED32", 6, 6, bVar, enumC6377Ni34);
        l = enumC4503Fk27;
        EnumC6377Ni3 enumC6377Ni35 = EnumC6377Ni3.i;
        EnumC4503Fk2 enumC4503Fk28 = new EnumC4503Fk2("BOOL", 7, 7, bVar, enumC6377Ni35);
        m = enumC4503Fk28;
        EnumC6377Ni3 enumC6377Ni36 = EnumC6377Ni3.j;
        EnumC4503Fk2 enumC4503Fk29 = new EnumC4503Fk2("STRING", 8, 8, bVar, enumC6377Ni36);
        n = enumC4503Fk29;
        EnumC6377Ni3 enumC6377Ni37 = EnumC6377Ni3.m;
        EnumC4503Fk2 enumC4503Fk210 = new EnumC4503Fk2(TokenNames.MESSAGE, 9, 9, bVar, enumC6377Ni37);
        o = enumC4503Fk210;
        EnumC6377Ni3 enumC6377Ni38 = EnumC6377Ni3.k;
        EnumC4503Fk2 enumC4503Fk211 = new EnumC4503Fk2("BYTES", 10, 10, bVar, enumC6377Ni38);
        p = enumC4503Fk211;
        EnumC4503Fk2 enumC4503Fk212 = new EnumC4503Fk2("UINT32", 11, 11, bVar, enumC6377Ni34);
        q = enumC4503Fk212;
        EnumC6377Ni3 enumC6377Ni39 = EnumC6377Ni3.l;
        EnumC4503Fk2 enumC4503Fk213 = new EnumC4503Fk2("ENUM", 12, 12, bVar, enumC6377Ni39);
        r = enumC4503Fk213;
        EnumC4503Fk2 enumC4503Fk214 = new EnumC4503Fk2("SFIXED32", 13, 13, bVar, enumC6377Ni34);
        s = enumC4503Fk214;
        EnumC4503Fk2 enumC4503Fk215 = new EnumC4503Fk2("SFIXED64", 14, 14, bVar, enumC6377Ni33);
        t = enumC4503Fk215;
        EnumC4503Fk2 enumC4503Fk216 = new EnumC4503Fk2("SINT32", 15, 15, bVar, enumC6377Ni34);
        u = enumC4503Fk216;
        EnumC4503Fk2 enumC4503Fk217 = new EnumC4503Fk2("SINT64", 16, 16, bVar, enumC6377Ni33);
        v = enumC4503Fk217;
        EnumC4503Fk2 enumC4503Fk218 = new EnumC4503Fk2("GROUP", 17, 17, bVar, enumC6377Ni37);
        w = enumC4503Fk218;
        b bVar2 = b.VECTOR;
        EnumC4503Fk2 enumC4503Fk219 = new EnumC4503Fk2("DOUBLE_LIST", 18, 18, bVar2, enumC6377Ni3);
        x = enumC4503Fk219;
        EnumC4503Fk2 enumC4503Fk220 = new EnumC4503Fk2("FLOAT_LIST", 19, 19, bVar2, enumC6377Ni32);
        y = enumC4503Fk220;
        EnumC4503Fk2 enumC4503Fk221 = new EnumC4503Fk2("INT64_LIST", 20, 20, bVar2, enumC6377Ni33);
        z = enumC4503Fk221;
        EnumC4503Fk2 enumC4503Fk222 = new EnumC4503Fk2("UINT64_LIST", 21, 21, bVar2, enumC6377Ni33);
        A = enumC4503Fk222;
        EnumC4503Fk2 enumC4503Fk223 = new EnumC4503Fk2("INT32_LIST", 22, 22, bVar2, enumC6377Ni34);
        B = enumC4503Fk223;
        EnumC4503Fk2 enumC4503Fk224 = new EnumC4503Fk2("FIXED64_LIST", 23, 23, bVar2, enumC6377Ni33);
        D = enumC4503Fk224;
        EnumC4503Fk2 enumC4503Fk225 = new EnumC4503Fk2("FIXED32_LIST", 24, 24, bVar2, enumC6377Ni34);
        G = enumC4503Fk225;
        EnumC4503Fk2 enumC4503Fk226 = new EnumC4503Fk2("BOOL_LIST", 25, 25, bVar2, enumC6377Ni35);
        H = enumC4503Fk226;
        EnumC4503Fk2 enumC4503Fk227 = new EnumC4503Fk2("STRING_LIST", 26, 26, bVar2, enumC6377Ni36);
        J = enumC4503Fk227;
        EnumC4503Fk2 enumC4503Fk228 = new EnumC4503Fk2("MESSAGE_LIST", 27, 27, bVar2, enumC6377Ni37);
        Y = enumC4503Fk228;
        EnumC4503Fk2 enumC4503Fk229 = new EnumC4503Fk2("BYTES_LIST", 28, 28, bVar2, enumC6377Ni38);
        Z = enumC4503Fk229;
        EnumC4503Fk2 enumC4503Fk230 = new EnumC4503Fk2("UINT32_LIST", 29, 29, bVar2, enumC6377Ni34);
        z0 = enumC4503Fk230;
        EnumC4503Fk2 enumC4503Fk231 = new EnumC4503Fk2("ENUM_LIST", 30, 30, bVar2, enumC6377Ni39);
        A0 = enumC4503Fk231;
        EnumC4503Fk2 enumC4503Fk232 = new EnumC4503Fk2("SFIXED32_LIST", 31, 31, bVar2, enumC6377Ni34);
        B0 = enumC4503Fk232;
        EnumC4503Fk2 enumC4503Fk233 = new EnumC4503Fk2("SFIXED64_LIST", 32, 32, bVar2, enumC6377Ni33);
        C0 = enumC4503Fk233;
        EnumC4503Fk2 enumC4503Fk234 = new EnumC4503Fk2("SINT32_LIST", 33, 33, bVar2, enumC6377Ni34);
        D0 = enumC4503Fk234;
        EnumC4503Fk2 enumC4503Fk235 = new EnumC4503Fk2("SINT64_LIST", 34, 34, bVar2, enumC6377Ni33);
        E0 = enumC4503Fk235;
        b bVar3 = b.PACKED_VECTOR;
        EnumC4503Fk2 enumC4503Fk236 = new EnumC4503Fk2("DOUBLE_LIST_PACKED", 35, 35, bVar3, enumC6377Ni3);
        F0 = enumC4503Fk236;
        EnumC4503Fk2 enumC4503Fk237 = new EnumC4503Fk2("FLOAT_LIST_PACKED", 36, 36, bVar3, enumC6377Ni32);
        G0 = enumC4503Fk237;
        EnumC4503Fk2 enumC4503Fk238 = new EnumC4503Fk2("INT64_LIST_PACKED", 37, 37, bVar3, enumC6377Ni33);
        H0 = enumC4503Fk238;
        EnumC4503Fk2 enumC4503Fk239 = new EnumC4503Fk2("UINT64_LIST_PACKED", 38, 38, bVar3, enumC6377Ni33);
        I0 = enumC4503Fk239;
        EnumC4503Fk2 enumC4503Fk240 = new EnumC4503Fk2("INT32_LIST_PACKED", 39, 39, bVar3, enumC6377Ni34);
        J0 = enumC4503Fk240;
        EnumC4503Fk2 enumC4503Fk241 = new EnumC4503Fk2("FIXED64_LIST_PACKED", 40, 40, bVar3, enumC6377Ni33);
        K0 = enumC4503Fk241;
        EnumC4503Fk2 enumC4503Fk242 = new EnumC4503Fk2("FIXED32_LIST_PACKED", 41, 41, bVar3, enumC6377Ni34);
        L0 = enumC4503Fk242;
        EnumC4503Fk2 enumC4503Fk243 = new EnumC4503Fk2("BOOL_LIST_PACKED", 42, 42, bVar3, enumC6377Ni35);
        M0 = enumC4503Fk243;
        EnumC4503Fk2 enumC4503Fk244 = new EnumC4503Fk2("UINT32_LIST_PACKED", 43, 43, bVar3, enumC6377Ni34);
        N0 = enumC4503Fk244;
        EnumC4503Fk2 enumC4503Fk245 = new EnumC4503Fk2("ENUM_LIST_PACKED", 44, 44, bVar3, enumC6377Ni39);
        O0 = enumC4503Fk245;
        EnumC4503Fk2 enumC4503Fk246 = new EnumC4503Fk2("SFIXED32_LIST_PACKED", 45, 45, bVar3, enumC6377Ni34);
        P0 = enumC4503Fk246;
        EnumC4503Fk2 enumC4503Fk247 = new EnumC4503Fk2("SFIXED64_LIST_PACKED", 46, 46, bVar3, enumC6377Ni33);
        Q0 = enumC4503Fk247;
        EnumC4503Fk2 enumC4503Fk248 = new EnumC4503Fk2("SINT32_LIST_PACKED", 47, 47, bVar3, enumC6377Ni34);
        R0 = enumC4503Fk248;
        EnumC4503Fk2 enumC4503Fk249 = new EnumC4503Fk2("SINT64_LIST_PACKED", 48, 48, bVar3, enumC6377Ni33);
        S0 = enumC4503Fk249;
        EnumC4503Fk2 enumC4503Fk250 = new EnumC4503Fk2("GROUP_LIST", 49, 49, bVar2, enumC6377Ni37);
        T0 = enumC4503Fk250;
        EnumC4503Fk2 enumC4503Fk251 = new EnumC4503Fk2("MAP", 50, 50, b.MAP, EnumC6377Ni3.d);
        U0 = enumC4503Fk251;
        X0 = new EnumC4503Fk2[]{enumC4503Fk2, enumC4503Fk22, enumC4503Fk23, enumC4503Fk24, enumC4503Fk25, enumC4503Fk26, enumC4503Fk27, enumC4503Fk28, enumC4503Fk29, enumC4503Fk210, enumC4503Fk211, enumC4503Fk212, enumC4503Fk213, enumC4503Fk214, enumC4503Fk215, enumC4503Fk216, enumC4503Fk217, enumC4503Fk218, enumC4503Fk219, enumC4503Fk220, enumC4503Fk221, enumC4503Fk222, enumC4503Fk223, enumC4503Fk224, enumC4503Fk225, enumC4503Fk226, enumC4503Fk227, enumC4503Fk228, enumC4503Fk229, enumC4503Fk230, enumC4503Fk231, enumC4503Fk232, enumC4503Fk233, enumC4503Fk234, enumC4503Fk235, enumC4503Fk236, enumC4503Fk237, enumC4503Fk238, enumC4503Fk239, enumC4503Fk240, enumC4503Fk241, enumC4503Fk242, enumC4503Fk243, enumC4503Fk244, enumC4503Fk245, enumC4503Fk246, enumC4503Fk247, enumC4503Fk248, enumC4503Fk249, enumC4503Fk250, enumC4503Fk251};
        W0 = new Type[0];
        EnumC4503Fk2[] enumC4503Fk2ArrValues = values();
        V0 = new EnumC4503Fk2[enumC4503Fk2ArrValues.length];
        for (EnumC4503Fk2 enumC4503Fk252 : enumC4503Fk2ArrValues) {
            V0[enumC4503Fk252.b] = enumC4503Fk252;
        }
    }

    private EnumC4503Fk2(String str, int i2, int i3, b bVar, EnumC6377Ni3 enumC6377Ni3) {
        int i4;
        this.b = i3;
        this.c = bVar;
        this.a = enumC6377Ni3;
        int i5 = a.a[bVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.d = enumC6377Ni3.a();
        } else {
            this.d = null;
        }
        this.e = (bVar != b.SCALAR || (i4 = a.b[enumC6377Ni3.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : true;
    }

    public static EnumC4503Fk2 valueOf(String str) {
        return (EnumC4503Fk2) Enum.valueOf(EnumC4503Fk2.class, str);
    }

    public static EnumC4503Fk2[] values() {
        return (EnumC4503Fk2[]) X0.clone();
    }

    public int a() {
        return this.b;
    }
}
