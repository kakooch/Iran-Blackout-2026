package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Mo7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC6196Mo7 {
    public static final a b;
    public static final EnumC6196Mo7 c = new EnumC6196Mo7("NOT_SET", 0, -1000);
    public static final EnumC6196Mo7 d = new EnumC6196Mo7("LIGHT", 1, 1);
    public static final EnumC6196Mo7 e = new EnumC6196Mo7("DARK", 2, 2);
    public static final EnumC6196Mo7 f = new EnumC6196Mo7("FOLLOW_SYSTEM", 3, -1);
    public static final EnumC6196Mo7 g = new EnumC6196Mo7("FOLLOW_TIME", 4, 0);
    private static final /* synthetic */ EnumC6196Mo7[] h;
    private static final /* synthetic */ F92 i;
    private final int a;

    /* renamed from: ir.nasim.Mo7$a */
    public static final class a {
        private a() {
        }

        public final EnumC6196Mo7 a(int i) {
            Object next;
            Iterator<E> it = EnumC6196Mo7.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EnumC6196Mo7) next).p() == i) {
                    break;
                }
            }
            EnumC6196Mo7 enumC6196Mo7 = (EnumC6196Mo7) next;
            return enumC6196Mo7 == null ? EnumC6196Mo7.c : enumC6196Mo7;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC6196Mo7[] enumC6196Mo7ArrA = a();
        h = enumC6196Mo7ArrA;
        i = G92.a(enumC6196Mo7ArrA);
        b = new a(null);
    }

    private EnumC6196Mo7(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC6196Mo7[] a() {
        return new EnumC6196Mo7[]{c, d, e, f, g};
    }

    public static F92 j() {
        return i;
    }

    public static EnumC6196Mo7 valueOf(String str) {
        return (EnumC6196Mo7) Enum.valueOf(EnumC6196Mo7.class, str);
    }

    public static EnumC6196Mo7[] values() {
        return (EnumC6196Mo7[]) h.clone();
    }

    public final int p() {
        return this.a;
    }

    public final boolean q() {
        return this == e || (this == g && C5495Jo7.a.I2()) || (this == f && C5495Jo7.a.H2());
    }
}
