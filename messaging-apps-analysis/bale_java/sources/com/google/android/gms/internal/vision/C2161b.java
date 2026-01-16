package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.Ho8;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Rq8;
import ir.nasim.Sq8;

/* renamed from: com.google.android.gms.internal.vision.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2161b extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final Rq8 zzd = new C2191q();
    private static final C2161b zze;
    private static volatile InterfaceC25180zr8 zzf;
    private Sq8 zzc = AbstractC2178j0.t();

    /* renamed from: com.google.android.gms.internal.vision.b$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2161b.zze);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.q, ir.nasim.Rq8] */
    static {
        C2161b c2161b = new C2161b();
        zze = c2161b;
        AbstractC2178j0.p(C2161b.class, c2161b);
    }

    private C2161b() {
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2161b();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", Ho8.j()});
            case 4:
                return zze;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzf;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2161b.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzf;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zze);
                                zzf = aVar;
                                interfaceC25180zr84 = aVar;
                            }
                        } finally {
                        }
                    }
                }
                return interfaceC25180zr82;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
