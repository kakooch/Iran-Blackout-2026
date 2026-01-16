package com.google.android.gms.internal.vision;

import android.gov.nist.core.Separators;
import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Mq8;
import ir.nasim.Oq8;
import ir.nasim.Pq8;

/* renamed from: com.google.android.gms.internal.vision.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2167e extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2167e zzl;
    private static volatile InterfaceC25180zr8 zzm;
    private int zzc;
    private boolean zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private boolean zzk;
    private String zzd = "";
    private String zzj = "";

    /* renamed from: com.google.android.gms.internal.vision.e$a */
    public static final class a extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private a() {
            super(C2167e.zzl);
        }

        /* synthetic */ a(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.e$b */
    public enum b implements Mq8 {
        REASON_UNKNOWN(0),
        REASON_MISSING(1),
        REASON_UPGRADE(2),
        REASON_INVALID(3);

        private static final Pq8 f = new r();
        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            if (i == 0) {
                return REASON_UNKNOWN;
            }
            if (i == 1) {
                return REASON_MISSING;
            }
            if (i == 2) {
                return REASON_UPGRADE;
            }
            if (i != 3) {
                return null;
            }
            return REASON_INVALID;
        }

        public static Oq8 j() {
            return C2194s.a;
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

    static {
        C2167e c2167e = new C2167e();
        zzl = c2167e;
        AbstractC2178j0.p(C2167e.class, c2167e);
    }

    private C2167e() {
    }

    /* JADX WARN: Type inference failed for: r11v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2167e();
            case 2:
                return new a(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", b.j(), "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzm;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2167e.class) {
                        try {
                            InterfaceC25180zr8 interfaceC25180zr83 = zzm;
                            InterfaceC25180zr8 interfaceC25180zr84 = interfaceC25180zr83;
                            if (interfaceC25180zr83 == null) {
                                ?? aVar = new AbstractC2178j0.a(zzl);
                                zzm = aVar;
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
