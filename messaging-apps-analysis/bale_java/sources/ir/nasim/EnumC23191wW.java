package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wW, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC23191wW {
    public static final a b;
    public static final EnumC23191wW c = new EnumC23191wW("GIF", 0, 1);
    public static final EnumC23191wW d = new EnumC23191wW("JSON_LOTTIE", 1, 2);
    public static final EnumC23191wW e = new EnumC23191wW("PNG", 2, 3);
    public static final EnumC23191wW f = new EnumC23191wW("UNKNOWN", 3, -1);
    private static final /* synthetic */ EnumC23191wW[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    /* renamed from: ir.nasim.wW$a */
    public static final class a {
        private a() {
        }

        public final EnumC23191wW a(int i) {
            Object next;
            Iterator<E> it = EnumC23191wW.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EnumC23191wW) next).p() == i) {
                    break;
                }
            }
            EnumC23191wW enumC23191wW = (EnumC23191wW) next;
            return enumC23191wW == null ? EnumC23191wW.f : enumC23191wW;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC23191wW[] enumC23191wWArrA = a();
        g = enumC23191wWArrA;
        h = G92.a(enumC23191wWArrA);
        b = new a(null);
    }

    private EnumC23191wW(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC23191wW[] a() {
        return new EnumC23191wW[]{c, d, e, f};
    }

    public static F92 j() {
        return h;
    }

    public static EnumC23191wW valueOf(String str) {
        return (EnumC23191wW) Enum.valueOf(EnumC23191wW.class, str);
    }

    public static EnumC23191wW[] values() {
        return (EnumC23191wW[]) g.clone();
    }

    public final int p() {
        return this.a;
    }
}
