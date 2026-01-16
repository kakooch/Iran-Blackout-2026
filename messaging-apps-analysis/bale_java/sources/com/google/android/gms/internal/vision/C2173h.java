package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;

/* renamed from: com.google.android.gms.internal.vision.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2173h extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2173h zzj;
    private static volatile InterfaceC25180zr8 zzk;
    private int zzc;
    private float zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;

    /* renamed from: com.google.android.gms.internal.vision.h$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2173h.zzj);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2173h c2173h = new C2173h();
        zzj = c2173h;
        AbstractC2178j0.p(C2173h.class, c2173h);
    }

    private C2173h() {
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2173h();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzk;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2173h.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzk;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzj);
                                zzk = aVar;
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
