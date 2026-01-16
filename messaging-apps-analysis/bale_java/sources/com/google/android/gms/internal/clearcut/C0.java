package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;
import ir.nasim.InterfaceC22760vm8;
import ir.nasim.InterfaceC25120zl8;
import ir.nasim.Km8;
import java.util.List;

/* loaded from: classes3.dex */
public final class C0 extends AbstractC2101z implements InterfaceC22760vm8 {
    private static volatile Km8 zzbg;
    private static final C0 zzbir;
    private InterfaceC25120zl8 zzbiq = AbstractC2101z.n();

    public static final class a extends AbstractC2101z.a implements InterfaceC22760vm8 {
        private a() {
            super(C0.zzbir);
        }

        /* synthetic */ a(D0 d0) {
            this();
        }
    }

    public static final class b extends AbstractC2101z implements InterfaceC22760vm8 {
        private static volatile Km8 zzbg;
        private static final b zzbiv;
        private int zzbb;
        private String zzbis = "";
        private long zzbit;
        private long zzbiu;
        private int zzya;

        public static final class a extends AbstractC2101z.a implements InterfaceC22760vm8 {
            private a() {
                super(b.zzbiv);
            }

            public final a o(String str) {
                l();
                ((b) this.b).z(str);
                return this;
            }

            public final a p(long j) {
                l();
                ((b) this.b).A(j);
                return this;
            }

            public final a q(long j) {
                l();
                ((b) this.b).B(j);
                return this;
            }

            /* synthetic */ a(D0 d0) {
                this();
            }
        }

        static {
            b bVar = new b();
            zzbiv = bVar;
            AbstractC2101z.l(b.class, bVar);
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void A(long j) {
            this.zzbb |= 4;
            this.zzbit = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B(long j) {
            this.zzbb |= 8;
            this.zzbiu = j;
        }

        public static a x() {
            return (a) ((AbstractC2101z.a) zzbiv.i(AbstractC2101z.c.e, null, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void z(String str) {
            str.getClass();
            this.zzbb |= 2;
            this.zzbis = str;
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.z$b, ir.nasim.Km8] */
        @Override // com.google.android.gms.internal.clearcut.AbstractC2101z
        protected final Object i(int i, Object obj, Object obj2) {
            D0 d0 = null;
            switch (D0.a[i - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(d0);
                case 3:
                    return AbstractC2101z.j(zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                case 4:
                    return zzbiv;
                case 5:
                    Km8 km8 = zzbg;
                    Km8 km82 = km8;
                    if (km8 == null) {
                        synchronized (b.class) {
                            try {
                                Km8 km83 = zzbg;
                                Km8 km84 = km83;
                                if (km83 == null) {
                                    ?? bVar = new AbstractC2101z.b(zzbiv);
                                    zzbg = bVar;
                                    km84 = bVar;
                                }
                            } finally {
                            }
                        }
                    }
                    return km82;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final int p() {
            return this.zzya;
        }

        public final boolean t() {
            return (this.zzbb & 1) == 1;
        }

        public final String u() {
            return this.zzbis;
        }

        public final long v() {
            return this.zzbit;
        }

        public final long w() {
            return this.zzbiu;
        }
    }

    static {
        C0 c0 = new C0();
        zzbir = c0;
        AbstractC2101z.l(C0.class, c0);
    }

    private C0() {
    }

    public static C0 q() {
        return zzbir;
    }

    public static C0 s(byte[] bArr) {
        return (C0) AbstractC2101z.m(zzbir, bArr);
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.clearcut.z$b, ir.nasim.Km8] */
    @Override // com.google.android.gms.internal.clearcut.AbstractC2101z
    protected final Object i(int i, Object obj, Object obj2) {
        D0 d0 = null;
        switch (D0.a[i - 1]) {
            case 1:
                return new C0();
            case 2:
                return new a(d0);
            case 3:
                return AbstractC2101z.j(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", b.class});
            case 4:
                return zzbir;
            case 5:
                Km8 km8 = zzbg;
                Km8 km82 = km8;
                if (km8 == null) {
                    synchronized (C0.class) {
                        try {
                            Km8 km83 = zzbg;
                            Km8 km84 = km83;
                            if (km83 == null) {
                                ?? bVar = new AbstractC2101z.b(zzbir);
                                zzbg = bVar;
                                km84 = bVar;
                            }
                        } finally {
                        }
                    }
                }
                return km82;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List p() {
        return this.zzbiq;
    }
}
