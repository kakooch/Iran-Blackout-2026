package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Xt7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC8893Xt7 {
    public static final a b;
    public static final EnumC8893Xt7 c = new EnumC8893Xt7("STORY", 0, 1);
    public static final EnumC8893Xt7 d = new EnumC8893Xt7("CHANNEL", 1, 2);
    public static final EnumC8893Xt7 e = new EnumC8893Xt7("MAGAZINE", 2, 3);
    public static final EnumC8893Xt7 f = new EnumC8893Xt7("GROUP", 3, 4);
    public static final EnumC8893Xt7 g = new EnumC8893Xt7("BOT", 4, 5);
    public static final EnumC8893Xt7 h = new EnumC8893Xt7("USER", 5, 6);
    public static final EnumC8893Xt7 i = new EnumC8893Xt7("PROFILE", 6, 7);
    private static final /* synthetic */ EnumC8893Xt7[] j;
    private static final /* synthetic */ F92 k;
    private final int a;

    /* renamed from: ir.nasim.Xt7$a */
    public static final class a {
        private a() {
        }

        public final EnumC8893Xt7 a(int i) {
            Object next;
            Iterator<E> it = EnumC8893Xt7.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EnumC8893Xt7) next).p() == i) {
                    break;
                }
            }
            return (EnumC8893Xt7) next;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC8893Xt7[] enumC8893Xt7ArrA = a();
        j = enumC8893Xt7ArrA;
        k = G92.a(enumC8893Xt7ArrA);
        b = new a(null);
    }

    private EnumC8893Xt7(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC8893Xt7[] a() {
        return new EnumC8893Xt7[]{c, d, e, f, g, h, i};
    }

    public static F92 j() {
        return k;
    }

    public static EnumC8893Xt7 valueOf(String str) {
        return (EnumC8893Xt7) Enum.valueOf(EnumC8893Xt7.class, str);
    }

    public static EnumC8893Xt7[] values() {
        return (EnumC8893Xt7[]) j.clone();
    }

    public final int p() {
        return this.a;
    }
}
