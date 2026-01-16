package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Lp4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5969Lp4 {
    public static String a(String str, ZN2 zn2) {
        if (zn2 == null || zn2.equals(ZN2.GROUP)) {
            return str;
        }
        Context context = C5721Ko.b;
        String string = context.getString(AbstractC12217eE5.dialog_type_group);
        String string2 = context.getString(AbstractC12217eE5.dialog_type_channel);
        return str.replace(string, string2).replaceAll(string.toLowerCase(), string2.toLowerCase());
    }

    public static VL3 b() {
        return d().X();
    }

    public static C21231tK7 c() {
        if (g() == null || g().o().d(f()) == null) {
            return null;
        }
        return (C21231tK7) g().n(f());
    }

    public static C11335cq d() {
        return C5735Kp4.w().i();
    }

    public static C9057Yh4 e() {
        return C5735Kp4.w().i().o2();
    }

    public static int f() {
        return d().X0();
    }

    public static VL3 g() {
        return d().k0();
    }
}
