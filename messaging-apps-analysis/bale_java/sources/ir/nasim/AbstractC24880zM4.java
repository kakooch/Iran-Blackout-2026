package ir.nasim;

/* renamed from: ir.nasim.zM4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24880zM4 {
    public static long a(int i, int i2, int i3, int i4) {
        return b(AbstractC19606qe1.a(i, i2, i3, i4));
    }

    public static long c(long j, EnumC5311Iu3 enumC5311Iu3) {
        EnumC5311Iu3 enumC5311Iu32 = EnumC5311Iu3.a;
        return a(enumC5311Iu3 == enumC5311Iu32 ? C17833ne1.n(j) : C17833ne1.m(j), enumC5311Iu3 == enumC5311Iu32 ? C17833ne1.l(j) : C17833ne1.k(j), enumC5311Iu3 == enumC5311Iu32 ? C17833ne1.m(j) : C17833ne1.n(j), enumC5311Iu3 == enumC5311Iu32 ? C17833ne1.k(j) : C17833ne1.l(j));
    }

    public static final long d(long j, int i, int i2, int i3, int i4) {
        return a(i, i2, i3, i4);
    }

    public static /* synthetic */ long e(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = C17833ne1.n(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = C17833ne1.l(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = C17833ne1.m(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = C17833ne1.k(j);
        }
        return d(j, i6, i7, i8, i4);
    }

    public static final long f(long j, EnumC5311Iu3 enumC5311Iu3) {
        return enumC5311Iu3 == EnumC5311Iu3.a ? AbstractC19606qe1.a(C17833ne1.n(j), C17833ne1.l(j), C17833ne1.m(j), C17833ne1.k(j)) : AbstractC19606qe1.a(C17833ne1.m(j), C17833ne1.k(j), C17833ne1.n(j), C17833ne1.l(j));
    }

    private static long b(long j) {
        return j;
    }
}
