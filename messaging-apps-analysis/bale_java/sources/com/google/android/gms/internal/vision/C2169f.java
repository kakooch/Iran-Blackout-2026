package com.google.android.gms.internal.vision;

import android.gov.nist.core.Separators;
import com.google.android.gms.internal.vision.AbstractC2178j0;
import ir.nasim.InterfaceC20352rr8;
import ir.nasim.InterfaceC25180zr8;
import ir.nasim.Mq8;
import ir.nasim.Oq8;
import ir.nasim.Pq8;
import ir.nasim.Tq8;

/* renamed from: com.google.android.gms.internal.vision.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2169f extends AbstractC2178j0 implements InterfaceC20352rr8 {
    private static final C2169f zzl;
    private static volatile InterfaceC25180zr8 zzm;
    private int zzc;
    private int zzg;
    private long zzi;
    private long zzj;
    private String zzd = "";
    private String zze = "";
    private Tq8 zzf = AbstractC2178j0.u();
    private String zzh = "";
    private Tq8 zzk = AbstractC2178j0.u();

    /* renamed from: com.google.android.gms.internal.vision.f$a */
    public enum a implements Mq8 {
        RESULT_UNKNOWN(0),
        RESULT_SUCCESS(1),
        RESULT_FAIL(2),
        RESULT_SKIPPED(3);

        private static final Pq8 f = new C2198u();
        private final int a;

        a(int i) {
            this.a = i;
        }

        public static a a(int i) {
            if (i == 0) {
                return RESULT_UNKNOWN;
            }
            if (i == 1) {
                return RESULT_SUCCESS;
            }
            if (i == 2) {
                return RESULT_FAIL;
            }
            if (i != 3) {
                return null;
            }
            return RESULT_SKIPPED;
        }

        public static Oq8 j() {
            return C2196t.a;
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

    /* renamed from: com.google.android.gms.internal.vision.f$b */
    public static final class b extends AbstractC2178j0.b implements InterfaceC20352rr8 {
        private b() {
            super(C2169f.zzl);
        }

        public final b r(long j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2169f) this.b).w(j);
            return this;
        }

        public final b s(Iterable iterable) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2169f) this.b).A(iterable);
            return this;
        }

        public final b t(String str) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2169f) this.b).B(str);
            return this;
        }

        public final b u(long j) {
            if (this.c) {
                n();
                this.c = false;
            }
            ((C2169f) this.b).D(j);
            return this;
        }

        /* synthetic */ b(AbstractC2189p abstractC2189p) {
            this();
        }
    }

    static {
        C2169f c2169f = new C2169f();
        zzl = c2169f;
        AbstractC2178j0.p(C2169f.class, c2169f);
    }

    private C2169f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(Iterable iterable) {
        Tq8 tq8 = this.zzk;
        if (!tq8.zza()) {
            this.zzk = AbstractC2178j0.j(tq8);
        }
        D.a(iterable, this.zzk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(long j) {
        this.zzc |= 32;
        this.zzj = j;
    }

    public static b v() {
        return (b) zzl.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long j) {
        this.zzc |= 16;
        this.zzi = j;
    }

    /* JADX WARN: Type inference failed for: r12v13, types: [com.google.android.gms.internal.vision.j0$a, ir.nasim.zr8] */
    @Override // com.google.android.gms.internal.vision.AbstractC2178j0
    protected final Object m(int i, Object obj, Object obj2) {
        AbstractC2189p abstractC2189p = null;
        switch (AbstractC2189p.a[i - 1]) {
            case 1:
                return new C2169f();
            case 2:
                return new b(abstractC2189p);
            case 3:
                return AbstractC2178j0.n(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", a.j(), "zzh", "zzi", "zzj", "zzk", C2185n.class});
            case 4:
                return zzl;
            case 5:
                InterfaceC25180zr8 interfaceC25180zr8 = zzm;
                InterfaceC25180zr8 interfaceC25180zr82 = interfaceC25180zr8;
                if (interfaceC25180zr8 == null) {
                    synchronized (C2169f.class) {
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
