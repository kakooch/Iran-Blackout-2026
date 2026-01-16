package ir.nasim;

import android.os.Parcel;
import android.util.Base64;
import ir.nasim.C24525yl7;

/* renamed from: ir.nasim.qB1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19341qB1 {
    private final Parcel a;

    public C19341qB1(String str) {
        Parcel parcelObtain = Parcel.obtain();
        this.a = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    private final int a() {
        return this.a.dataAvail();
    }

    private final float b() {
        return C18413od0.c(e());
    }

    private final byte c() {
        return this.a.readByte();
    }

    private final float e() {
        return this.a.readFloat();
    }

    private final int i() {
        return this.a.readInt();
    }

    private final C5566Jw6 j() {
        long jD = d();
        float fE = e();
        float fE2 = e();
        return new C5566Jw6(jD, ZG4.e((Float.floatToRawIntBits(fE) << 32) | (4294967295L & Float.floatToRawIntBits(fE2))), e(), null);
    }

    private final String l() {
        return this.a.readString();
    }

    private final C24525yl7 m() {
        int i = i();
        C24525yl7.a aVar = C24525yl7.b;
        boolean z = (aVar.b().e() & i) != 0;
        boolean z2 = (i & aVar.d().e()) != 0;
        return (z && z2) ? aVar.a(AbstractC10360bX0.p(aVar.b(), aVar.d())) : z ? aVar.b() : z2 ? aVar.d() : aVar.c();
    }

    private final C3590Bm7 n() {
        return new C3590Bm7(e(), e());
    }

    private final long p() {
        return C14599iA7.h(this.a.readLong());
    }

    public final long d() {
        return C24381yX0.l(p());
    }

    public final int f() {
        byte bC = c();
        return bC == 0 ? C3418Au2.b.b() : bC == 1 ? C3418Au2.b.a() : C3418Au2.b.b();
    }

    public final int g() {
        byte bC = c();
        return bC == 0 ? C3657Bu2.b.b() : bC == 1 ? C3657Bu2.b.a() : bC == 3 ? C3657Bu2.b.c() : bC == 2 ? C3657Bu2.b.d() : C3657Bu2.b.b();
    }

    public final C4593Fu2 h() {
        return new C4593Fu2(i());
    }

    public final C12863fI6 k() {
        C8827Xm4 c8827Xm4;
        C8827Xm4 c8827Xm42 = c8827Xm4;
        C8827Xm4 c8827Xm43 = new C8827Xm4(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.a.dataAvail() > 1) {
            byte bC = c();
            if (bC != 1) {
                c8827Xm4 = c8827Xm42;
                if (bC == 2) {
                    if (a() < 5) {
                        break;
                    }
                    c8827Xm4.e(o());
                    c8827Xm42 = c8827Xm4;
                } else if (bC == 3) {
                    if (a() < 4) {
                        break;
                    }
                    c8827Xm4.h(h());
                    c8827Xm42 = c8827Xm4;
                } else if (bC == 4) {
                    if (a() < 1) {
                        break;
                    }
                    c8827Xm4.f(C3418Au2.c(f()));
                    c8827Xm42 = c8827Xm4;
                } else if (bC != 5) {
                    if (bC != 6) {
                        if (bC != 7) {
                            if (bC != 8) {
                                if (bC != 9) {
                                    if (bC != 10) {
                                        if (bC != 11) {
                                            if (bC == 12) {
                                                if (a() < 20) {
                                                    break;
                                                }
                                                c8827Xm4.j(j());
                                            }
                                        } else {
                                            if (a() < 4) {
                                                break;
                                            }
                                            c8827Xm4.k(m());
                                        }
                                    } else {
                                        if (a() < 8) {
                                            break;
                                        }
                                        c8827Xm4.a(d());
                                    }
                                } else {
                                    if (a() < 8) {
                                        break;
                                    }
                                    c8827Xm4.l(n());
                                }
                            } else {
                                if (a() < 4) {
                                    break;
                                }
                                c8827Xm4.b(C18413od0.b(b()));
                            }
                        } else {
                            if (a() < 5) {
                                break;
                            }
                            c8827Xm4.i(o());
                        }
                    } else {
                        c8827Xm4.d(l());
                    }
                    c8827Xm42 = c8827Xm4;
                } else {
                    if (a() < 1) {
                        break;
                    }
                    c8827Xm4.g(C3657Bu2.e(g()));
                    c8827Xm42 = c8827Xm4;
                }
            } else {
                if (a() < 8) {
                    break;
                }
                c8827Xm42.c(d());
            }
        }
        c8827Xm4 = c8827Xm42;
        return c8827Xm4.m();
    }

    public final long o() {
        byte bC = c();
        long jB = bC == 1 ? C14377ho7.b.b() : bC == 2 ? C14377ho7.b.a() : C14377ho7.b.c();
        return C14377ho7.g(jB, C14377ho7.b.c()) ? C13193fo7.b.a() : AbstractC13784go7.a(e(), jB);
    }
}
