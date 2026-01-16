package ir.nasim.features.mxp.entity;

import ir.nasim.AbstractC12217eE5;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.KB5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class a {
    public static final C1181a d;
    public static final a e = new a("UNKNOWN", 0, 0, AbstractC12217eE5.mxp_puppet_unknown, KB5.ic_bale);
    public static final a f = new a("IGAP", 1, 2, AbstractC12217eE5.mxp_puppet_igap, KB5.ic_mxp_puppet_igap);
    public static final a g = new a("GAP", 2, 3, AbstractC12217eE5.mxp_puppet_gap, KB5.ic_mxp_puppet_gap);
    public static final a h = new a("EITTA", 3, 4, AbstractC12217eE5.mxp_puppet_eitta, KB5.ic_mxp_puppet_eitaa);
    public static final a i = new a("RUBIKA", 4, 5, AbstractC12217eE5.mxp_puppet_rubika, KB5.ic_mxp_puppet_rubika);
    public static final a j = new a("SPLUS", 5, 6, AbstractC12217eE5.mxp_puppet_splus, KB5.ic_mxp_puppet_splus);
    private static final /* synthetic */ a[] k;
    private static final /* synthetic */ F92 l;
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: ir.nasim.features.mxp.entity.a$a, reason: collision with other inner class name */
    public static final class C1181a {
        private C1181a() {
        }

        public final a a(int i) {
            for (a aVar : a.values()) {
                if (aVar.r() == i) {
                    return aVar;
                }
            }
            return null;
        }

        public /* synthetic */ C1181a(ED1 ed1) {
            this();
        }
    }

    static {
        a[] aVarArrA = a();
        k = aVarArrA;
        l = G92.a(aVarArrA);
        d = new C1181a(null);
    }

    private a(String str, int i2, int i3, int i4, int i5) {
        this.a = i3;
        this.b = i4;
        this.c = i5;
    }

    private static final /* synthetic */ a[] a() {
        return new a[]{e, f, g, h, i, j};
    }

    public static final a j(int i2) {
        return d.a(i2);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) k.clone();
    }

    public final int p() {
        return this.c;
    }

    public final int q() {
        return this.b;
    }

    public final int r() {
        return this.a;
    }

    public final boolean s() {
        return this != e;
    }
}
