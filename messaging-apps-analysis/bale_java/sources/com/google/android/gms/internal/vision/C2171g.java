package com.google.android.gms.internal.vision;

import android.gov.nist.core.Separators;
import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Mq8;
import ir.nasim.Oq8;
import ir.nasim.Pq8;

/* renamed from: com.google.android.gms.internal.vision.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2171g extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2171g zzj;
    private static volatile InterfaceC25180zr8 zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private float zzi;

    /* renamed from: com.google.android.gms.internal.vision.g$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2171g.zzj);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.g$b */
    public enum b implements Mq8 {
        CLASSIFICATION_UNKNOWN(0),
        CLASSIFICATION_NONE(1),
        CLASSIFICATION_ALL(2);

        private static final Pq8 e = new C2200v();
        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            if (i == 0) {
                return CLASSIFICATION_UNKNOWN;
            }
            if (i == 1) {
                return CLASSIFICATION_NONE;
            }
            if (i != 2) {
                return null;
            }
            return CLASSIFICATION_ALL;
        }

        public static Oq8 j() {
            return C2202w.a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Separators.LESS_THAN + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.a + " name=" + name() + '>';
        }

        @Override // ir.nasim.Mq8
        public final int zza() {
            return this.a;
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.g$c */
    public enum c implements Mq8 {
        LANDMARK_UNKNOWN(0),
        LANDMARK_NONE(1),
        LANDMARK_ALL(2),
        LANDMARK_CONTOUR(3);

        private static final Pq8 f = new C2206y();
        private final int a;

        c(int i) {
            this.a = i;
        }

        public static c a(int i) {
            if (i == 0) {
                return LANDMARK_UNKNOWN;
            }
            if (i == 1) {
                return LANDMARK_NONE;
            }
            if (i == 2) {
                return LANDMARK_ALL;
            }
            if (i != 3) {
                return null;
            }
            return LANDMARK_CONTOUR;
        }

        public static Oq8 j() {
            return C2204x.a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Separators.LESS_THAN + c.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.a + " name=" + name() + '>';
        }

        @Override // ir.nasim.Mq8
        public final int zza() {
            return this.a;
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.g$d */
    public enum d implements Mq8 {
        MODE_UNKNOWN(0),
        MODE_ACCURATE(1),
        MODE_FAST(2),
        MODE_SELFIE(3);

        private static final Pq8 f = new C2208z();
        private final int a;

        d(int i) {
            this.a = i;
        }

        public static d a(int i) {
            if (i == 0) {
                return MODE_UNKNOWN;
            }
            if (i == 1) {
                return MODE_ACCURATE;
            }
            if (i == 2) {
                return MODE_FAST;
            }
            if (i != 3) {
                return null;
            }
            return MODE_SELFIE;
        }

        public static Oq8 j() {
            return A.a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Separators.LESS_THAN + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.a + " name=" + name() + '>';
        }

        @Override // ir.nasim.Mq8
        public final int zza() {
            return this.a;
        }
    }

    static {
        C2171g c2171g = new C2171g();
        zzj = c2171g;
        AbstractC2178j0.p(C2171g.class, c2171g);
    }

    private C2171g() {
    }

    /* JADX WARN: Type inference failed for: r11v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2171g();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", d.j(), "zze", c.j(), "zzf", b.j(), "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzk;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2171g.class) {
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
