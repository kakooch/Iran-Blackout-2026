package ir.nasim.features.smiles.panel.sticker;

import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class i {
    public static final a b;
    public static final i c = new i("HEADER", 0, 1010);
    public static final i d = new i("STICKER", 1, 1020);
    public static final i e = new i("RECENT_STICKER", 2, 1030);
    private static final /* synthetic */ i[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    public static final class a {
        private a() {
        }

        public final i a(int i) {
            i iVar;
            i[] iVarArrValues = i.values();
            int length = iVarArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    iVar = null;
                    break;
                }
                iVar = iVarArrValues[i2];
                if (iVar.getNumber() == i) {
                    break;
                }
                i2++;
            }
            return iVar == null ? i.c : iVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        i[] iVarArrA = a();
        f = iVarArrA;
        g = G92.a(iVarArrA);
        b = new a(null);
    }

    private i(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ i[] a() {
        return new i[]{c, d, e};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f.clone();
    }

    public final int getNumber() {
        return this.a;
    }
}
