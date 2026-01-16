package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;

/* renamed from: com.google.android.gms.internal.vision.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2187o extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2187o zzi;
    private static volatile InterfaceC25180zr8 zzj;
    private int zzc;
    private C2167e zzd;
    private C2179k zze;
    private C2175i zzf;
    private int zzg;
    private boolean zzh;

    /* renamed from: com.google.android.gms.internal.vision.o$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2187o.zzi);
        }

        public final a r(C2175i c2175i) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2187o) this.b).w(c2175i);
            return this;
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2187o c2187o = new C2187o();
        zzi = c2187o;
        AbstractC2178j0.p(C2187o.class, c2187o);
    }

    private C2187o() {
    }

    public static a v() {
        return (a) zzi.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(C2175i c2175i) {
        c2175i.getClass();
        this.zzf = c2175i;
        this.zzc |= 4;
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2187o();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003\u0005ဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzj;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2187o.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzj;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzi);
                                zzj = aVar;
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
