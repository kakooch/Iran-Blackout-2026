package ir.nasim;

import android.util.SparseArray;
import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lG1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16431lG1 implements InterfaceC22268uw7.c {
    private final int a;
    private final List b;

    public C16431lG1(int i) {
        this(i, AbstractC12710f43.V());
    }

    private C3580Bl6 c(InterfaceC22268uw7.b bVar) {
        return new C3580Bl6(e(bVar));
    }

    private C23663xI7 d(InterfaceC22268uw7.b bVar) {
        return new C23663xI7(e(bVar));
    }

    private List e(InterfaceC22268uw7.b bVar) {
        String str;
        int i;
        if (f(32)) {
            return this.b;
        }
        EW4 ew4 = new EW4(bVar.d);
        List arrayList = this.b;
        while (ew4.a() > 0) {
            int iF = ew4.F();
            int iF2 = ew4.f() + ew4.F();
            if (iF == 134) {
                arrayList = new ArrayList();
                int iF3 = ew4.F() & 31;
                for (int i2 = 0; i2 < iF3; i2++) {
                    String strC = ew4.C(3);
                    int iF4 = ew4.F();
                    boolean z = (iF4 & 128) != 0;
                    if (z) {
                        i = iF4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bF = (byte) ew4.F();
                    ew4.T(1);
                    arrayList.add(new X.b().g0(str).X(strC).H(i).V(z ? GW0.b((bF & 64) != 0) : null).G());
                }
            }
            ew4.S(iF2);
        }
        return arrayList;
    }

    private boolean f(int i) {
        return (i & this.a) != 0;
    }

    @Override // ir.nasim.InterfaceC22268uw7.c
    public SparseArray a() {
        return new SparseArray();
    }

    @Override // ir.nasim.InterfaceC22268uw7.c
    public InterfaceC22268uw7 b(int i, InterfaceC22268uw7.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new K65(new C4505Fk4(bVar.b));
            }
            if (i == 21) {
                return new K65(new G03());
            }
            if (i == 27) {
                if (f(4)) {
                    return null;
                }
                return new K65(new RS2(c(bVar), f(1), f(8)));
            }
            if (i == 36) {
                return new K65(new SS2(c(bVar)));
            }
            if (i == 89) {
                return new K65(new C11455d22(bVar.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new K65(new C17477n2(bVar.b));
                }
                if (i == 257) {
                    return new C20260ri6(new C16281l05("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (f(16)) {
                        return null;
                    }
                    return new C20260ri6(new C16281l05("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (!f(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case 17:
                            if (!f(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 130:
                                    if (!f(64)) {
                                    }
                                    break;
                            }
                    }
                    return null;
                }
                return new K65(new C15113j2(bVar.b));
            }
            return new K65(new C21720u12(bVar.b));
        }
        return new K65(new PS2(d(bVar)));
    }

    public C16431lG1(int i, List list) {
        this.a = i;
        this.b = list;
    }
}
