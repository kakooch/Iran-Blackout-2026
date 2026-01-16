package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;
import ir.nasim.InterfaceC22760vm8;
import ir.nasim.Km8;

/* loaded from: classes3.dex */
public final class x0 extends AbstractC2101z implements InterfaceC22760vm8 {
    private static volatile Km8 zzbg;
    private static final x0 zztx;
    private int zzbb;
    private int zztu;
    private String zztv = "";
    private String zztw = "";

    public static final class a extends AbstractC2101z.a implements InterfaceC22760vm8 {
        private a() {
            super(x0.zztx);
        }

        /* synthetic */ a(z0 z0Var) {
            this();
        }
    }

    static {
        x0 x0Var = new x0();
        zztx = x0Var;
        AbstractC2101z.l(x0.class, x0Var);
    }

    private x0() {
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.z$b, ir.nasim.Km8] */
    @Override // com.google.android.gms.internal.clearcut.AbstractC2101z
    protected final Object i(int i, Object obj, Object obj2) {
        z0 z0Var = null;
        switch (z0.a[i - 1]) {
            case 1:
                return new x0();
            case 2:
                return new a(z0Var);
            case 3:
                return AbstractC2101z.j(zztx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzbb", "zztu", "zztv", "zztw"});
            case 4:
                return zztx;
            case 5:
                Km8 km8 = zzbg;
                Km8 km82 = km8;
                if (km8 == null) {
                    synchronized (x0.class) {
                        try {
                            Km8 km83 = zzbg;
                            Km8 km84 = km83;
                            if (km83 == null) {
                                ?? bVar = new AbstractC2101z.b(zztx);
                                zzbg = bVar;
                                km84 = bVar;
                            }
                        } finally {
                        }
                    }
                }
                return km82;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
