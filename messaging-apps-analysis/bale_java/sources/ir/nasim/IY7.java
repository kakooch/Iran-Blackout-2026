package ir.nasim;

import ir.nasim.C17784nZ1;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
import ir.nasim.CK5;
import ir.nasim.OD6;
import ir.nasim.ZG4;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IY7 {
    private static final CK5 a;
    private static final Map b;

    static {
        Float fValueOf = Float.valueOf(0.5f);
        a = new CK5(0.5f, 0.5f, 0.5f, 0.5f);
        InterfaceC5342Ix7 interfaceC5342Ix7E = PQ7.e(C15431ja3.a);
        Float fValueOf2 = Float.valueOf(1.0f);
        XV4 xv4A = AbstractC4616Fw7.a(interfaceC5342Ix7E, fValueOf2);
        XV4 xv4A2 = AbstractC4616Fw7.a(PQ7.g(C4414Fa3.b), fValueOf2);
        XV4 xv4A3 = AbstractC4616Fw7.a(PQ7.f(C22045ua3.b), fValueOf2);
        XV4 xv4A4 = AbstractC4616Fw7.a(PQ7.d(C9361Zp2.a), Float.valueOf(0.01f));
        XV4 xv4A5 = AbstractC4616Fw7.a(PQ7.i(CK5.e), fValueOf);
        XV4 xv4A6 = AbstractC4616Fw7.a(PQ7.j(OD6.b), fValueOf);
        XV4 xv4A7 = AbstractC4616Fw7.a(PQ7.h(ZG4.b), fValueOf);
        InterfaceC5342Ix7 interfaceC5342Ix7B = PQ7.b(C17784nZ1.b);
        Float fValueOf3 = Float.valueOf(0.1f);
        b = AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, xv4A6, xv4A7, AbstractC4616Fw7.a(interfaceC5342Ix7B, fValueOf3), AbstractC4616Fw7.a(PQ7.c(C19557qZ1.b), fValueOf3));
    }

    public static final float a(C17784nZ1.a aVar) {
        return C17784nZ1.q(0.1f);
    }

    public static final int b(C15431ja3 c15431ja3) {
        return 1;
    }

    public static final long c(C22045ua3.a aVar) {
        long j = 1;
        return C22045ua3.f((j & 4294967295L) | (j << 32));
    }

    public static final long d(C4414Fa3.a aVar) {
        long j = 1;
        return C4414Fa3.c((j & 4294967295L) | (j << 32));
    }

    public static final long e(ZG4.a aVar) {
        return ZG4.e((Float.floatToRawIntBits(0.5f) << 32) | (Float.floatToRawIntBits(0.5f) & 4294967295L));
    }

    public static final long f(OD6.a aVar) {
        return OD6.d((Float.floatToRawIntBits(0.5f) << 32) | (Float.floatToRawIntBits(0.5f) & 4294967295L));
    }

    public static final CK5 g(CK5.a aVar) {
        return a;
    }

    public static final Map h() {
        return b;
    }
}
