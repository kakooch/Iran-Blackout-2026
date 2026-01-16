package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.dj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC11895dj7 {
    public static final a b;
    public static final EnumC11895dj7 c = new EnumC11895dj7("BADGE", 0, 1010);
    public static final EnumC11895dj7 d = new EnumC11895dj7("SHIMMER", 1, 1011);
    private static final /* synthetic */ EnumC11895dj7[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    /* renamed from: ir.nasim.dj7$a */
    public static final class a {
        private a() {
        }

        public final EnumC11895dj7 a(int i) {
            Object next;
            Iterator<E> it = EnumC11895dj7.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EnumC11895dj7) next).getNumber() == i) {
                    break;
                }
            }
            EnumC11895dj7 enumC11895dj7 = (EnumC11895dj7) next;
            return enumC11895dj7 == null ? EnumC11895dj7.c : enumC11895dj7;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC11895dj7[] enumC11895dj7ArrA = a();
        e = enumC11895dj7ArrA;
        f = G92.a(enumC11895dj7ArrA);
        b = new a(null);
    }

    private EnumC11895dj7(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC11895dj7[] a() {
        return new EnumC11895dj7[]{c, d};
    }

    public static F92 j() {
        return f;
    }

    public static EnumC11895dj7 valueOf(String str) {
        return (EnumC11895dj7) Enum.valueOf(EnumC11895dj7.class, str);
    }

    public static EnumC11895dj7[] values() {
        return (EnumC11895dj7[]) e.clone();
    }

    public final int getNumber() {
        return this.a;
    }
}
