package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Zf5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC9274Zf5 {
    public static final a c;
    public static final EnumC9274Zf5 d = new EnumC9274Zf5("HALF_X", 0, 0.5f, AbstractC24778zB5.ic_half_x_speed_voice);
    public static final EnumC9274Zf5 e = new EnumC9274Zf5("ONE_X", 1, 1.0f, AbstractC24778zB5.icon_speed_one_x);
    public static final EnumC9274Zf5 f = new EnumC9274Zf5("ONE_AND_HALF_X", 2, 1.5f, AbstractC24778zB5.icon_speed_one_and_half_x);
    public static final EnumC9274Zf5 g = new EnumC9274Zf5("TWO_X", 3, 2.0f, AbstractC24778zB5.icon_speed_two_x);
    private static final /* synthetic */ EnumC9274Zf5[] h;
    private static final /* synthetic */ F92 i;
    private final float a;
    private final int b;

    /* renamed from: ir.nasim.Zf5$a */
    public static final class a {
        private a() {
        }

        public final EnumC9274Zf5 a() {
            return EnumC9274Zf5.e;
        }

        public final EnumC9274Zf5 b(float f) {
            Object next;
            Iterator<E> it = EnumC9274Zf5.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EnumC9274Zf5) next).q() == f) {
                    break;
                }
            }
            EnumC9274Zf5 enumC9274Zf5 = (EnumC9274Zf5) next;
            return enumC9274Zf5 == null ? a() : enumC9274Zf5;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC9274Zf5[] enumC9274Zf5ArrA = a();
        h = enumC9274Zf5ArrA;
        i = G92.a(enumC9274Zf5ArrA);
        c = new a(null);
    }

    private EnumC9274Zf5(String str, int i2, float f2, int i3) {
        this.a = f2;
        this.b = i3;
    }

    private static final /* synthetic */ EnumC9274Zf5[] a() {
        return new EnumC9274Zf5[]{d, e, f, g};
    }

    public static F92 j() {
        return i;
    }

    public static EnumC9274Zf5 valueOf(String str) {
        return (EnumC9274Zf5) Enum.valueOf(EnumC9274Zf5.class, str);
    }

    public static EnumC9274Zf5[] values() {
        return (EnumC9274Zf5[]) h.clone();
    }

    public final int p() {
        return this.b;
    }

    public final float q() {
        return this.a;
    }
}
