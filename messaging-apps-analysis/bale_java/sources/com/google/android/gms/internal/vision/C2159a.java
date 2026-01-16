package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;

/* renamed from: com.google.android.gms.internal.vision.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2159a extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2159a zzf;
    private static volatile InterfaceC25180zr8 zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* renamed from: com.google.android.gms.internal.vision.a$a, reason: collision with other inner class name */
    public static final class C0175a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private C0175a() {
            super(C2159a.zzf);
        }

        public final C0175a r(String str) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2159a) this.b).x(str);
            return this;
        }

        public final C0175a s(String str) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2159a) this.b).A(str);
            return this;
        }

        /* synthetic */ C0175a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2159a c2159a = new C2159a();
        zzf = c2159a;
        AbstractC2178j0.p(C2159a.class, c2159a);
    }

    private C2159a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public static C0175a v() {
        return (C0175a) zzf.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2159a();
            case 2:
                return new C0175a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzg;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2159a.class) {
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
