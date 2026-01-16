package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Tq8;

/* renamed from: com.google.android.gms.internal.vision.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2175i extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2175i zzg;
    private static volatile InterfaceC25180zr8 zzh;
    private int zzc;
    private C2177j zzd;
    private C2181l zze;
    private Tq8 zzf = AbstractC2178j0.u();

    /* renamed from: com.google.android.gms.internal.vision.i$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2175i.zzg);
        }

        public final a r(C2177j c2177j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2175i) this.b).y(c2177j);
            return this;
        }

        public final a s(Iterable iterable) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2175i) this.b).z(iterable);
            return this;
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2175i c2175i = new C2175i();
        zzg = c2175i;
        AbstractC2178j0.p(C2175i.class, c2175i);
    }

    private C2175i() {
    }

    private final void B() {
        Tq8 tq8 = this.zzf;
        if (tq8.zza()) {
            return;
        }
        this.zzf = AbstractC2178j0.j(tq8);
    }

    public static a v() {
        return (a) zzg.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(C2177j c2177j) {
        c2177j.getClass();
        this.zzd = c2177j;
        this.zzc |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(Iterable iterable) {
        B();
        D.a(iterable, this.zzf);
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2175i();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", C2169f.class});
            case 4:
                return zzg;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzh;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2175i.class) {
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
