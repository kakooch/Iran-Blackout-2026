package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.x68, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC23552x68 {
    public static final a a;
    public static final EnumC23552x68 b = new EnumC23552x68("FULLSCREEN", 0);
    public static final EnumC23552x68 c = new EnumC23552x68("FULL_SIZE", 1);
    public static final EnumC23552x68 d = new EnumC23552x68("COMPACT", 2);
    private static final /* synthetic */ EnumC23552x68[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.x68$a */
    public static final class a {
        private a() {
        }

        public final EnumC23552x68 a(String str) {
            Object next;
            if (str == null) {
                return EnumC23552x68.c;
            }
            Iterator<E> it = EnumC23552x68.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC20153rZ6.D(((EnumC23552x68) next).name(), str, true)) {
                    break;
                }
            }
            EnumC23552x68 enumC23552x68 = (EnumC23552x68) next;
            return enumC23552x68 == null ? EnumC23552x68.c : enumC23552x68;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC23552x68[] enumC23552x68ArrA = a();
        e = enumC23552x68ArrA;
        f = G92.a(enumC23552x68ArrA);
        a = new a(null);
    }

    private EnumC23552x68(String str, int i) {
    }

    private static final /* synthetic */ EnumC23552x68[] a() {
        return new EnumC23552x68[]{b, c, d};
    }

    public static F92 j() {
        return f;
    }

    public static EnumC23552x68 valueOf(String str) {
        return (EnumC23552x68) Enum.valueOf(EnumC23552x68.class, str);
    }

    public static EnumC23552x68[] values() {
        return (EnumC23552x68[]) e.clone();
    }
}
