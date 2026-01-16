package com.google.android.gms.internal.vision;

import android.gov.nist.core.Separators;
import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Mq8;
import ir.nasim.Oq8;
import ir.nasim.Pq8;

/* renamed from: com.google.android.gms.internal.vision.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2177j extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2177j zzi;
    private static volatile InterfaceC25180zr8 zzj;
    private int zzc;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    /* renamed from: com.google.android.gms.internal.vision.j$a */
    public enum a implements Mq8 {
        FORMAT_UNKNOWN(0),
        FORMAT_LUMINANCE(1),
        FORMAT_RGB8(2),
        FORMAT_MONOCHROME(3);

        private static final Pq8 f = new C();
        private final int a;

        a(int i) {
            this.a = i;
        }

        public static a a(int i) {
            if (i == 0) {
                return FORMAT_UNKNOWN;
            }
            if (i == 1) {
                return FORMAT_LUMINANCE;
            }
            if (i == 2) {
                return FORMAT_RGB8;
            }
            if (i != 3) {
                return null;
            }
            return FORMAT_MONOCHROME;
        }

        public static Oq8 j() {
            return B.a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Separators.LESS_THAN + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.a + " name=" + name() + '>';
        }

        @Override // ir.nasim.Mq8
        public final int zza() {
            return this.a;
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.j$b */
    public static final class b extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private b() {
            super(C2177j.zzi);
        }

        public final b r(long j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2177j) this.b).w(j);
            return this;
        }

        public final b s(long j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2177j) this.b).z(j);
            return this;
        }

        public final b t(long j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2177j) this.b).B(j);
            return this;
        }

        public final b u(long j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2177j) this.b).D(j);
            return this;
        }

        /* synthetic */ b(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2177j c2177j = new C2177j();
        zzi = c2177j;
        AbstractC2178j0.p(C2177j.class, c2177j);
    }

    private C2177j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j) {
        this.zzc |= 8;
        this.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(long j) {
        this.zzc |= 16;
        this.zzh = j;
    }

    public static b v() {
        return (b) zzi.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long j) {
        this.zzc |= 2;
        this.zze = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(long j) {
        this.zzc |= 4;
        this.zzf = j;
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2177j();
            case 2:
                return new b(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzc", "zzd", a.j(), "zze", "zzf", "zzh", "zzg"});
            case 4:
                return zzi;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzj;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2177j.class) {
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
