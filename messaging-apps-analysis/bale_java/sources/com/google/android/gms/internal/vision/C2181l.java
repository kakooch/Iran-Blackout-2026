package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;

/* renamed from: com.google.android.gms.internal.vision.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2181l extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2181l zzf;
    private static volatile InterfaceC25180zr8 zzg;
    private int zzc;
    private long zzd;
    private long zze;

    /* renamed from: com.google.android.gms.internal.vision.l$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2181l.zzf);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2181l c2181l = new C2181l();
        zzf = c2181l;
        AbstractC2178j0.p(C2181l.class, c2181l);
    }

    private C2181l() {
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2181l();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzg;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2181l.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzg;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzf);
                                zzg = aVar;
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
