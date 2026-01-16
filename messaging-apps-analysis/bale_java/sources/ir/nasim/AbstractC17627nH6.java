package ir.nasim;

/* renamed from: ir.nasim.nH6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC17627nH6 {
    private static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(InterfaceC9845af2 interfaceC9845af2) {
        return c(interfaceC9845af2, true, false);
    }

    private static boolean c(InterfaceC9845af2 interfaceC9845af2, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        long length = interfaceC9845af2.getLength();
        long j = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j2 = 4096;
        if (i2 != 0 && length <= 4096) {
            j2 = length;
        }
        int i3 = (int) j2;
        EW4 ew4 = new EW4(64);
        boolean z8 = false;
        int i4 = 0;
        boolean z9 = false;
        while (i4 < i3) {
            ew4.O(8);
            if (!interfaceC9845af2.c(ew4.e(), z8 ? 1 : 0, 8, true)) {
                break;
            }
            long jH = ew4.H();
            int iO = ew4.o();
            if (jH == 1) {
                interfaceC9845af2.m(ew4.e(), 8, 8);
                ew4.R(16);
                i = 16;
                jH = ew4.y();
            } else {
                if (jH == 0) {
                    long length2 = interfaceC9845af2.getLength();
                    if (length2 != j) {
                        jH = (length2 - interfaceC9845af2.g()) + 8;
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (jH < j3) {
                return z8;
            }
            i4 += i;
            if (iO == 1836019574) {
                i3 += (int) jH;
                if (i2 != 0 && i3 > length) {
                    i3 = (int) length;
                }
            } else {
                if (iO == 1836019558 || iO == 1836475768) {
                    z3 = z8 ? 1 : 0;
                    z4 = true;
                    z5 = true;
                    break;
                }
                int i5 = i2;
                if ((i4 + jH) - j3 >= i3) {
                    z3 = false;
                    z4 = true;
                    break;
                }
                int i6 = (int) (jH - j3);
                i4 += i6;
                if (iO != 1718909296) {
                    z6 = false;
                    z9 = z9;
                    if (i6 != 0) {
                        interfaceC9845af2.h(i6);
                        z9 = z9;
                    }
                } else {
                    if (i6 < 8) {
                        return false;
                    }
                    ew4.O(i6);
                    interfaceC9845af2.m(ew4.e(), 0, i6);
                    int i7 = i6 / 4;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= i7) {
                            z7 = z9;
                            break;
                        }
                        if (i8 == 1) {
                            ew4.T(4);
                        } else if (a(ew4.o(), z2)) {
                            z7 = true;
                            break;
                        }
                        i8++;
                    }
                    if (!z7) {
                        return false;
                    }
                    z6 = false;
                    z9 = z7;
                }
                z8 = z6;
                i2 = i5;
            }
            j = -1;
            z9 = z9;
        }
        z3 = z8 ? 1 : 0;
        z4 = true;
        z5 = z3;
        return (z9 && z == z5) ? z4 : z3;
    }

    public static boolean d(InterfaceC9845af2 interfaceC9845af2, boolean z) {
        return c(interfaceC9845af2, false, z);
    }
}
