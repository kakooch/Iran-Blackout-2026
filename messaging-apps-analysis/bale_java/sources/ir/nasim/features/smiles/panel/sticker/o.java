package ir.nasim.features.smiles.panel.sticker;

import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
final class o {
    public static final a b;
    public static final o c = new o("STICKER", 0, 1010);
    public static final o d = new o("IMAGE", 1, 1020);
    private static final /* synthetic */ o[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    public static final class a {
        private a() {
        }

        public final o a(int i) {
            o oVar;
            o[] oVarArrValues = o.values();
            int length = oVarArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    oVar = null;
                    break;
                }
                oVar = oVarArrValues[i2];
                if (oVar.getNumber() == i) {
                    break;
                }
                i2++;
            }
            return oVar == null ? o.d : oVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        o[] oVarArrA = a();
        e = oVarArrA;
        f = G92.a(oVarArrA);
        b = new a(null);
    }

    private o(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ o[] a() {
        return new o[]{c, d};
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) e.clone();
    }

    public final int getNumber() {
        return this.a;
    }
}
