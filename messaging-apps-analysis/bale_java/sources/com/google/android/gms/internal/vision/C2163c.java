package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.EnumC11955dp8;
import ir.nasim.Ho8;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;

/* renamed from: com.google.android.gms.internal.vision.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2163c extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2163c zzg;
    private static volatile InterfaceC25180zr8 zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";

    /* renamed from: com.google.android.gms.internal.vision.c$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2163c.zzg);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2163c c2163c = new C2163c();
        zzg = c2163c;
        AbstractC2178j0.p(C2163c.class, c2163c);
    }

    private C2163c() {
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2163c();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzc", "zzd", Ho8.j(), "zze", EnumC11955dp8.j(), "zzf"});
            case 4:
                return zzg;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzh;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2163c.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzh;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzg);
                                zzh = aVar;
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
