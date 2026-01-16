package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class OW {
    public static final a b;
    public static final OW c = new OW("HEADER", 0, 10);
    public static final OW d = new OW("BADGE", 1, 11);
    public static final OW e = new OW("SHIMMER", 2, 12);
    public static final OW f = new OW("HEADER_SHIMMER", 3, 13);
    private static final /* synthetic */ OW[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    public static final class a {
        private a() {
        }

        public final OW a(int i) {
            Object next;
            Iterator<E> it = OW.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((OW) next).getNumber() == i) {
                    break;
                }
            }
            OW ow = (OW) next;
            return ow == null ? OW.c : ow;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        OW[] owArrA = a();
        g = owArrA;
        h = G92.a(owArrA);
        b = new a(null);
    }

    private OW(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ OW[] a() {
        return new OW[]{c, d, e, f};
    }

    public static F92 j() {
        return h;
    }

    public static OW valueOf(String str) {
        return (OW) Enum.valueOf(OW.class, str);
    }

    public static OW[] values() {
        return (OW[]) g.clone();
    }

    public final int getNumber() {
        return this.a;
    }
}
