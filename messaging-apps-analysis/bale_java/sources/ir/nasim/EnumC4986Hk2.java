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
/* renamed from: ir.nasim.Hk2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC4986Hk2 {
    public static final EnumC4986Hk2 A;
    public static final EnumC4986Hk2 A0;
    public static final EnumC4986Hk2 B;
    public static final EnumC4986Hk2 B0;
    public static final EnumC4986Hk2 C0;
    public static final EnumC4986Hk2 D;
    public static final EnumC4986Hk2 D0;
    public static final EnumC4986Hk2 E0;
    public static final EnumC4986Hk2 F0;
    public static final EnumC4986Hk2 G;
    public static final EnumC4986Hk2 G0;
    public static final EnumC4986Hk2 H;
    public static final EnumC4986Hk2 H0;
    public static final EnumC4986Hk2 I0;
    public static final EnumC4986Hk2 J;
    public static final EnumC4986Hk2 J0;
    public static final EnumC4986Hk2 K0;
    public static final EnumC4986Hk2 L0;
    public static final EnumC4986Hk2 M0;
    public static final EnumC4986Hk2 N0;
    public static final EnumC4986Hk2 O0;
    public static final EnumC4986Hk2 P0;
    public static final EnumC4986Hk2 Q0;
    public static final EnumC4986Hk2 R0;
    public static final EnumC4986Hk2 S0;
    public static final EnumC4986Hk2 T0;
    public static final EnumC4986Hk2 U0;
    private static final EnumC4986Hk2[] V0;
    private static final Type[] W0;
    private static final /* synthetic */ EnumC4986Hk2[] X0;
    public static final EnumC4986Hk2 Y;
    public static final EnumC4986Hk2 Z;
    public static final EnumC4986Hk2 f;
    public static final EnumC4986Hk2 g;
    public static final EnumC4986Hk2 h;
    public static final EnumC4986Hk2 i;
    public static final EnumC4986Hk2 j;
    public static final EnumC4986Hk2 k;
    public static final EnumC4986Hk2 l;
    public static final EnumC4986Hk2 m;
    public static final EnumC4986Hk2 n;
    public static final EnumC4986Hk2 o;
    public static final EnumC4986Hk2 p;
    public static final EnumC4986Hk2 q;
    public static final EnumC4986Hk2 r;
    public static final EnumC4986Hk2 s;
    public static final EnumC4986Hk2 t;
    public static final EnumC4986Hk2 u;
    public static final EnumC4986Hk2 v;
    public static final EnumC4986Hk2 w;
    public static final EnumC4986Hk2 x;
    public static final EnumC4986Hk2 y;
    public static final EnumC4986Hk2 z;
    public static final EnumC4986Hk2 z0;
    private final EnumC5905Li3 a;
    private final int b;
    private final b c;
    private final Class d;
    private final boolean e;

    /* renamed from: ir.nasim.Hk2$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC5905Li3.values().length];
            b = iArr;
            try {
                iArr[EnumC5905Li3.k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC5905Li3.m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC5905Li3.j.ordinal()] = 3;
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

    /* renamed from: ir.nasim.Hk2$b */
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
        EnumC5905Li3 enumC5905Li3 = EnumC5905Li3.h;
        EnumC4986Hk2 enumC4986Hk2 = new EnumC4986Hk2("DOUBLE", 0, 0, bVar, enumC5905Li3);
        f = enumC4986Hk2;
        EnumC5905Li3 enumC5905Li32 = EnumC5905Li3.g;
        EnumC4986Hk2 enumC4986Hk22 = new EnumC4986Hk2("FLOAT", 1, 1, bVar, enumC5905Li32);
        g = enumC4986Hk22;
        EnumC5905Li3 enumC5905Li33 = EnumC5905Li3.f;
        EnumC4986Hk2 enumC4986Hk23 = new EnumC4986Hk2("INT64", 2, 2, bVar, enumC5905Li33);
        h = enumC4986Hk23;
        EnumC4986Hk2 enumC4986Hk24 = new EnumC4986Hk2("UINT64", 3, 3, bVar, enumC5905Li33);
        i = enumC4986Hk24;
        EnumC5905Li3 enumC5905Li34 = EnumC5905Li3.e;
        EnumC4986Hk2 enumC4986Hk25 = new EnumC4986Hk2("INT32", 4, 4, bVar, enumC5905Li34);
        j = enumC4986Hk25;
        EnumC4986Hk2 enumC4986Hk26 = new EnumC4986Hk2("FIXED64", 5, 5, bVar, enumC5905Li33);
        k = enumC4986Hk26;
        EnumC4986Hk2 enumC4986Hk27 = new EnumC4986Hk2("FIXED32", 6, 6, bVar, enumC5905Li34);
        l = enumC4986Hk27;
        EnumC5905Li3 enumC5905Li35 = EnumC5905Li3.i;
        EnumC4986Hk2 enumC4986Hk28 = new EnumC4986Hk2("BOOL", 7, 7, bVar, enumC5905Li35);
        m = enumC4986Hk28;
        EnumC5905Li3 enumC5905Li36 = EnumC5905Li3.j;
        EnumC4986Hk2 enumC4986Hk29 = new EnumC4986Hk2("STRING", 8, 8, bVar, enumC5905Li36);
        n = enumC4986Hk29;
        EnumC5905Li3 enumC5905Li37 = EnumC5905Li3.m;
        EnumC4986Hk2 enumC4986Hk210 = new EnumC4986Hk2(TokenNames.MESSAGE, 9, 9, bVar, enumC5905Li37);
        o = enumC4986Hk210;
        EnumC5905Li3 enumC5905Li38 = EnumC5905Li3.k;
        EnumC4986Hk2 enumC4986Hk211 = new EnumC4986Hk2("BYTES", 10, 10, bVar, enumC5905Li38);
        p = enumC4986Hk211;
        EnumC4986Hk2 enumC4986Hk212 = new EnumC4986Hk2("UINT32", 11, 11, bVar, enumC5905Li34);
        q = enumC4986Hk212;
        EnumC5905Li3 enumC5905Li39 = EnumC5905Li3.l;
        EnumC4986Hk2 enumC4986Hk213 = new EnumC4986Hk2("ENUM", 12, 12, bVar, enumC5905Li39);
        r = enumC4986Hk213;
        EnumC4986Hk2 enumC4986Hk214 = new EnumC4986Hk2("SFIXED32", 13, 13, bVar, enumC5905Li34);
        s = enumC4986Hk214;
        EnumC4986Hk2 enumC4986Hk215 = new EnumC4986Hk2("SFIXED64", 14, 14, bVar, enumC5905Li33);
        t = enumC4986Hk215;
        EnumC4986Hk2 enumC4986Hk216 = new EnumC4986Hk2("SINT32", 15, 15, bVar, enumC5905Li34);
        u = enumC4986Hk216;
        EnumC4986Hk2 enumC4986Hk217 = new EnumC4986Hk2("SINT64", 16, 16, bVar, enumC5905Li33);
        v = enumC4986Hk217;
        EnumC4986Hk2 enumC4986Hk218 = new EnumC4986Hk2("GROUP", 17, 17, bVar, enumC5905Li37);
        w = enumC4986Hk218;
        b bVar2 = b.VECTOR;
        EnumC4986Hk2 enumC4986Hk219 = new EnumC4986Hk2("DOUBLE_LIST", 18, 18, bVar2, enumC5905Li3);
        x = enumC4986Hk219;
        EnumC4986Hk2 enumC4986Hk220 = new EnumC4986Hk2("FLOAT_LIST", 19, 19, bVar2, enumC5905Li32);
        y = enumC4986Hk220;
        EnumC4986Hk2 enumC4986Hk221 = new EnumC4986Hk2("INT64_LIST", 20, 20, bVar2, enumC5905Li33);
        z = enumC4986Hk221;
        EnumC4986Hk2 enumC4986Hk222 = new EnumC4986Hk2("UINT64_LIST", 21, 21, bVar2, enumC5905Li33);
        A = enumC4986Hk222;
        EnumC4986Hk2 enumC4986Hk223 = new EnumC4986Hk2("INT32_LIST", 22, 22, bVar2, enumC5905Li34);
        B = enumC4986Hk223;
        EnumC4986Hk2 enumC4986Hk224 = new EnumC4986Hk2("FIXED64_LIST", 23, 23, bVar2, enumC5905Li33);
        D = enumC4986Hk224;
        EnumC4986Hk2 enumC4986Hk225 = new EnumC4986Hk2("FIXED32_LIST", 24, 24, bVar2, enumC5905Li34);
        G = enumC4986Hk225;
        EnumC4986Hk2 enumC4986Hk226 = new EnumC4986Hk2("BOOL_LIST", 25, 25, bVar2, enumC5905Li35);
        H = enumC4986Hk226;
        EnumC4986Hk2 enumC4986Hk227 = new EnumC4986Hk2("STRING_LIST", 26, 26, bVar2, enumC5905Li36);
        J = enumC4986Hk227;
        EnumC4986Hk2 enumC4986Hk228 = new EnumC4986Hk2("MESSAGE_LIST", 27, 27, bVar2, enumC5905Li37);
        Y = enumC4986Hk228;
        EnumC4986Hk2 enumC4986Hk229 = new EnumC4986Hk2("BYTES_LIST", 28, 28, bVar2, enumC5905Li38);
        Z = enumC4986Hk229;
        EnumC4986Hk2 enumC4986Hk230 = new EnumC4986Hk2("UINT32_LIST", 29, 29, bVar2, enumC5905Li34);
        z0 = enumC4986Hk230;
        EnumC4986Hk2 enumC4986Hk231 = new EnumC4986Hk2("ENUM_LIST", 30, 30, bVar2, enumC5905Li39);
        A0 = enumC4986Hk231;
        EnumC4986Hk2 enumC4986Hk232 = new EnumC4986Hk2("SFIXED32_LIST", 31, 31, bVar2, enumC5905Li34);
        B0 = enumC4986Hk232;
        EnumC4986Hk2 enumC4986Hk233 = new EnumC4986Hk2("SFIXED64_LIST", 32, 32, bVar2, enumC5905Li33);
        C0 = enumC4986Hk233;
        EnumC4986Hk2 enumC4986Hk234 = new EnumC4986Hk2("SINT32_LIST", 33, 33, bVar2, enumC5905Li34);
        D0 = enumC4986Hk234;
        EnumC4986Hk2 enumC4986Hk235 = new EnumC4986Hk2("SINT64_LIST", 34, 34, bVar2, enumC5905Li33);
        E0 = enumC4986Hk235;
        b bVar3 = b.PACKED_VECTOR;
        EnumC4986Hk2 enumC4986Hk236 = new EnumC4986Hk2("DOUBLE_LIST_PACKED", 35, 35, bVar3, enumC5905Li3);
        F0 = enumC4986Hk236;
        EnumC4986Hk2 enumC4986Hk237 = new EnumC4986Hk2("FLOAT_LIST_PACKED", 36, 36, bVar3, enumC5905Li32);
        G0 = enumC4986Hk237;
        EnumC4986Hk2 enumC4986Hk238 = new EnumC4986Hk2("INT64_LIST_PACKED", 37, 37, bVar3, enumC5905Li33);
        H0 = enumC4986Hk238;
        EnumC4986Hk2 enumC4986Hk239 = new EnumC4986Hk2("UINT64_LIST_PACKED", 38, 38, bVar3, enumC5905Li33);
        I0 = enumC4986Hk239;
        EnumC4986Hk2 enumC4986Hk240 = new EnumC4986Hk2("INT32_LIST_PACKED", 39, 39, bVar3, enumC5905Li34);
        J0 = enumC4986Hk240;
        EnumC4986Hk2 enumC4986Hk241 = new EnumC4986Hk2("FIXED64_LIST_PACKED", 40, 40, bVar3, enumC5905Li33);
        K0 = enumC4986Hk241;
        EnumC4986Hk2 enumC4986Hk242 = new EnumC4986Hk2("FIXED32_LIST_PACKED", 41, 41, bVar3, enumC5905Li34);
        L0 = enumC4986Hk242;
        EnumC4986Hk2 enumC4986Hk243 = new EnumC4986Hk2("BOOL_LIST_PACKED", 42, 42, bVar3, enumC5905Li35);
        M0 = enumC4986Hk243;
        EnumC4986Hk2 enumC4986Hk244 = new EnumC4986Hk2("UINT32_LIST_PACKED", 43, 43, bVar3, enumC5905Li34);
        N0 = enumC4986Hk244;
        EnumC4986Hk2 enumC4986Hk245 = new EnumC4986Hk2("ENUM_LIST_PACKED", 44, 44, bVar3, enumC5905Li39);
        O0 = enumC4986Hk245;
        EnumC4986Hk2 enumC4986Hk246 = new EnumC4986Hk2("SFIXED32_LIST_PACKED", 45, 45, bVar3, enumC5905Li34);
        P0 = enumC4986Hk246;
        EnumC4986Hk2 enumC4986Hk247 = new EnumC4986Hk2("SFIXED64_LIST_PACKED", 46, 46, bVar3, enumC5905Li33);
        Q0 = enumC4986Hk247;
        EnumC4986Hk2 enumC4986Hk248 = new EnumC4986Hk2("SINT32_LIST_PACKED", 47, 47, bVar3, enumC5905Li34);
        R0 = enumC4986Hk248;
        EnumC4986Hk2 enumC4986Hk249 = new EnumC4986Hk2("SINT64_LIST_PACKED", 48, 48, bVar3, enumC5905Li33);
        S0 = enumC4986Hk249;
        EnumC4986Hk2 enumC4986Hk250 = new EnumC4986Hk2("GROUP_LIST", 49, 49, bVar2, enumC5905Li37);
        T0 = enumC4986Hk250;
        EnumC4986Hk2 enumC4986Hk251 = new EnumC4986Hk2("MAP", 50, 50, b.MAP, EnumC5905Li3.d);
        U0 = enumC4986Hk251;
        X0 = new EnumC4986Hk2[]{enumC4986Hk2, enumC4986Hk22, enumC4986Hk23, enumC4986Hk24, enumC4986Hk25, enumC4986Hk26, enumC4986Hk27, enumC4986Hk28, enumC4986Hk29, enumC4986Hk210, enumC4986Hk211, enumC4986Hk212, enumC4986Hk213, enumC4986Hk214, enumC4986Hk215, enumC4986Hk216, enumC4986Hk217, enumC4986Hk218, enumC4986Hk219, enumC4986Hk220, enumC4986Hk221, enumC4986Hk222, enumC4986Hk223, enumC4986Hk224, enumC4986Hk225, enumC4986Hk226, enumC4986Hk227, enumC4986Hk228, enumC4986Hk229, enumC4986Hk230, enumC4986Hk231, enumC4986Hk232, enumC4986Hk233, enumC4986Hk234, enumC4986Hk235, enumC4986Hk236, enumC4986Hk237, enumC4986Hk238, enumC4986Hk239, enumC4986Hk240, enumC4986Hk241, enumC4986Hk242, enumC4986Hk243, enumC4986Hk244, enumC4986Hk245, enumC4986Hk246, enumC4986Hk247, enumC4986Hk248, enumC4986Hk249, enumC4986Hk250, enumC4986Hk251};
        W0 = new Type[0];
        EnumC4986Hk2[] enumC4986Hk2ArrValues = values();
        V0 = new EnumC4986Hk2[enumC4986Hk2ArrValues.length];
        for (EnumC4986Hk2 enumC4986Hk252 : enumC4986Hk2ArrValues) {
            V0[enumC4986Hk252.b] = enumC4986Hk252;
        }
    }

    private EnumC4986Hk2(String str, int i2, int i3, b bVar, EnumC5905Li3 enumC5905Li3) {
        int i4;
        this.b = i3;
        this.c = bVar;
        this.a = enumC5905Li3;
        int i5 = a.a[bVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.d = enumC5905Li3.a();
        } else {
            this.d = null;
        }
        this.e = (bVar != b.SCALAR || (i4 = a.b[enumC5905Li3.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : true;
    }

    public static EnumC4986Hk2 valueOf(String str) {
        return (EnumC4986Hk2) Enum.valueOf(EnumC4986Hk2.class, str);
    }

    public static EnumC4986Hk2[] values() {
        return (EnumC4986Hk2[]) X0.clone();
    }

    public int a() {
        return this.b;
    }
}
