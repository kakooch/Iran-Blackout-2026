package ir.nasim.designsystem.button;

import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class a {
    public static final C1020a b;
    public static final a c = new a("BALE_BUTTON_GREEN_SOLID", 0, 0);
    public static final a d = new a("BALE_BUTTON_GREEN_SOLID_SMALL", 1, 1);
    public static final a e = new a("BALE_BUTTON_GREEN_BORDER", 2, 2);
    public static final a f = new a("BALE_BUTTON_GREEN_BORDER_MEDIUM", 3, 8);
    public static final a g = new a("BALE_BUTTON_GREEN_BORDER_SMALL", 4, 3);
    public static final a h = new a("BALE_BUTTON_BLUE_SOLID", 5, 4);
    public static final a i = new a("BALE_BUTTON_BLUE_SOLID_SMALL", 6, 5);
    public static final a j = new a("BALE_BUTTON_BLUE_BORDER", 7, 6);
    public static final a k = new a("BALE_BUTTON_BLUE_BORDER_MEDIUM", 8, 9);
    public static final a l = new a("BALE_BUTTON_BLUE_BORDER_SMALL", 9, 7);
    public static final a m = new a("BALE_BUTTON_BANK_BLUE", 10, 10);
    public static final a n = new a("BALE_BUTTON_BANK_GREEN", 11, 11);
    public static final a o = new a("BALE_BUTTON_BANK_BLUE_DISABLED", 12, 12);
    public static final a p = new a("BALE_BUTTON_UPDATE", 13, 13);
    private static final /* synthetic */ a[] q;
    private static final /* synthetic */ F92 r;
    private int a;

    /* renamed from: ir.nasim.designsystem.button.a$a, reason: collision with other inner class name */
    public static final class C1020a {
        private C1020a() {
        }

        public final a a(int i) {
            for (a aVar : a.j()) {
                if (aVar.p() == i) {
                    return aVar;
                }
            }
            throw new IllegalArgumentException();
        }

        public /* synthetic */ C1020a(ED1 ed1) {
            this();
        }
    }

    static {
        a[] aVarArrA = a();
        q = aVarArrA;
        r = G92.a(aVarArrA);
        b = new C1020a(null);
    }

    private a(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ a[] a() {
        return new a[]{c, d, e, f, g, h, i, j, k, l, m, n, o, p};
    }

    public static F92 j() {
        return r;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) q.clone();
    }

    public final int p() {
        return this.a;
    }
}
