package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Tq8;

/* renamed from: com.google.android.gms.internal.vision.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2165d extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2165d zzd;
    private static volatile InterfaceC25180zr8 zze;
    private Tq8 zzc = AbstractC2178j0.u();

    /* renamed from: com.google.android.gms.internal.vision.d$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2165d.zzd);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2165d c2165d = new C2165d();
        zzd = c2165d;
        AbstractC2178j0.p(C2165d.class, c2165d);
    }

    private C2165d() {
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2165d();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", C2183m.class});
            case 4:
                return zzd;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zze;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2165d.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zze;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzd);
                                zze = aVar;
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
