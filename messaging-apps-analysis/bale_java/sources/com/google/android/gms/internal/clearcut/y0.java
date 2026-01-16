package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;
import ir.nasim.InterfaceC22160ul8;
import ir.nasim.InterfaceC22760vm8;
import ir.nasim.InterfaceC23346wl8;
import ir.nasim.Km8;

/* loaded from: classes3.dex */
public final class y0 extends AbstractC2101z implements InterfaceC22760vm8 {
    private static final y0 zzbfc;
    private static volatile Km8 zzbg;
    private int zzbb;
    private int zzbfa = -1;
    private int zzbfb;

    public static final class a extends AbstractC2101z.a implements InterfaceC22760vm8 {
        private a() {
            super(y0.zzbfc);
        }

        /* synthetic */ a(z0 z0Var) {
            this();
        }
    }

    public enum b implements InterfaceC22160ul8 {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);

        private static final InterfaceC23346wl8 w = new A0();
        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            if (i == 100) {
                return COMBINED;
            }
            switch (i) {
                case 0:
                    return UNKNOWN_MOBILE_SUBTYPE;
                case 1:
                    return GPRS;
                case 2:
                    return EDGE;
                case 3:
                    return UMTS;
                case 4:
                    return CDMA;
                case 5:
                    return EVDO_0;
                case 6:
                    return EVDO_A;
                case 7:
                    return RTT;
                case 8:
                    return HSDPA;
                case 9:
                    return HSUPA;
                case 10:
                    return HSPA;
                case 11:
                    return IDEN;
                case 12:
                    return EVDO_B;
                case 13:
                    return LTE;
                case 14:
                    return EHRPD;
                case 15:
                    return HSPAP;
                case 16:
                    return GSM;
                case 17:
                    return TD_SCDMA;
                case 18:
                    return IWLAN;
                case 19:
                    return LTE_CA;
                default:
                    return null;
            }
        }

        public static InterfaceC23346wl8 j() {
            return w;
        }
    }

    public enum c implements InterfaceC22160ul8 {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);

        private static final InterfaceC23346wl8 u = new B0();
        private final int a;

        c(int i) {
            this.a = i;
        }

        public static c a(int i) {
            switch (i) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static InterfaceC23346wl8 j() {
            return u;
        }
    }

    static {
        y0 y0Var = new y0();
        zzbfc = y0Var;
        AbstractC2101z.l(y0.class, y0Var);
    }

    private y0() {
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.z$b, ir.nasim.Km8] */
    @Override // com.google.android.gms.internal.clearcut.AbstractC2101z
    protected final Object i(int i, Object obj, Object obj2) {
        z0 z0Var = null;
        switch (z0.a[i - 1]) {
            case 1:
                return new y0();
            case 2:
                return new a(z0Var);
            case 3:
                return AbstractC2101z.j(zzbfc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzbb", "zzbfa", c.j(), "zzbfb", b.j()});
            case 4:
                return zzbfc;
            case 5:
                Km8 km8 = zzbg;
                Km8 km82 = km8;
                if (km8 == null) {
                    synchronized (y0.class) {
                        try {
                            Km8 km83 = zzbg;
                            Km8 km84 = km83;
                            if (km83 == null) {
                                ?? bVar = new AbstractC2101z.b(zzbfc);
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
}
