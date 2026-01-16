package ir.nasim;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.xu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24017xu {
    private static final C9424Zw2 a = new C9424Zw2("javax.annotation.meta.TypeQualifierNickname");
    private static final C9424Zw2 b = new C9424Zw2("javax.annotation.meta.TypeQualifier");
    private static final C9424Zw2 c = new C9424Zw2("javax.annotation.meta.TypeQualifierDefault");
    private static final C9424Zw2 d = new C9424Zw2("kotlin.annotations.jvm.UnderMigration");
    private static final List e;
    private static final Map f;
    private static final Map g;
    private static final Set h;

    static {
        EnumC23427wu enumC23427wu = EnumC23427wu.FIELD;
        EnumC23427wu enumC23427wu2 = EnumC23427wu.METHOD_RETURN_TYPE;
        EnumC23427wu enumC23427wu3 = EnumC23427wu.VALUE_PARAMETER;
        List listP = AbstractC10360bX0.p(enumC23427wu, enumC23427wu2, enumC23427wu3, EnumC23427wu.TYPE_PARAMETER_BOUNDS, EnumC23427wu.TYPE_USE);
        e = listP;
        C9424Zw2 c9424Zw2G = AbstractC25115zl3.g();
        EnumC14043hF4 enumC14043hF4 = EnumC14043hF4.NOT_NULL;
        Map mapG = AbstractC19460qO3.g(AbstractC4616Fw7.a(c9424Zw2G, new C9876ai3(new C14645iF4(enumC14043hF4, false, 2, null), listP, false)));
        f = mapG;
        g = AbstractC20051rO3.t(AbstractC20051rO3.n(AbstractC4616Fw7.a(new C9424Zw2("javax.annotation.ParametersAreNullableByDefault"), new C9876ai3(new C14645iF4(EnumC14043hF4.NULLABLE, false, 2, null), AbstractC9766aX0.e(enumC23427wu3), false, 4, null)), AbstractC4616Fw7.a(new C9424Zw2("javax.annotation.ParametersAreNonnullByDefault"), new C9876ai3(new C14645iF4(enumC14043hF4, false, 2, null), AbstractC9766aX0.e(enumC23427wu3), false, 4, null))), mapG);
        h = AbstractC4597Fu6.i(AbstractC25115zl3.f(), AbstractC25115zl3.e());
    }

    public static final Map a() {
        return g;
    }

    public static final Set b() {
        return h;
    }

    public static final Map c() {
        return f;
    }

    public static final C9424Zw2 d() {
        return d;
    }

    public static final C9424Zw2 e() {
        return c;
    }

    public static final C9424Zw2 f() {
        return b;
    }

    public static final C9424Zw2 g() {
        return a;
    }
}
