package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;

/* renamed from: com.google.android.gms.internal.vision.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2185n extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2185n zzh;
    private static volatile InterfaceC25180zr8 zzi;
    private int zzc;
    private C2165d zzd;
    private int zze;
    private C2173h zzf;
    private C2163c zzg;

    /* renamed from: com.google.android.gms.internal.vision.n$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2185n.zzh);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2185n c2185n = new C2185n();
        zzh = c2185n;
        AbstractC2178j0.p(C2185n.class, c2185n);
    }

    private C2185n() {
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2185n();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzh, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzi;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2185n.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzi;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzh);
                                zzi = aVar;
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
