package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ac3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9816ac3 {
    public static final C9816ac3 a = new C9816ac3();

    private C9816ac3() {
    }

    public final int a(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i2, i);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i3);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            if (fE == 0.0f) {
                int iMin2 = Math.min(interfaceC9236Zb3.k0(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, interfaceC9236Zb3.z(iMin2));
            } else if (fE > 0.0f) {
                f += fE;
            }
        }
        int iRound = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) list.get(i4);
            float fE2 = F66.e(F66.c(interfaceC9236Zb32));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, interfaceC9236Zb32.z(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int b(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i3 = 0;
        float f = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i4);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            int iK0 = interfaceC9236Zb3.k0(i);
            if (fE == 0.0f) {
                i3 += iK0;
            } else if (fE > 0.0f) {
                f += fE;
                iMax = Math.max(iMax, Math.round(iK0 / fE));
            }
        }
        return Math.round(iMax * f) + i3 + ((list.size() - 1) * i2);
    }

    public final int c(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i2, i);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i3);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            if (fE == 0.0f) {
                int iMin2 = Math.min(interfaceC9236Zb3.k0(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, interfaceC9236Zb3.Z(iMin2));
            } else if (fE > 0.0f) {
                f += fE;
            }
        }
        int iRound = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) list.get(i4);
            float fE2 = F66.e(F66.c(interfaceC9236Zb32));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, interfaceC9236Zb32.Z(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int d(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i3 = 0;
        float f = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i4);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            int iI0 = interfaceC9236Zb3.i0(i);
            if (fE == 0.0f) {
                i3 += iI0;
            } else if (fE > 0.0f) {
                f += fE;
                iMax = Math.max(iMax, Math.round(iI0 / fE));
            }
        }
        return Math.round(iMax * f) + i3 + ((list.size() - 1) * i2);
    }

    public final int e(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i3 = 0;
        float f = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i4);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            int iZ = interfaceC9236Zb3.z(i);
            if (fE == 0.0f) {
                i3 += iZ;
            } else if (fE > 0.0f) {
                f += fE;
                iMax = Math.max(iMax, Math.round(iZ / fE));
            }
        }
        return Math.round(iMax * f) + i3 + ((list.size() - 1) * i2);
    }

    public final int f(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i2, i);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i3);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            if (fE == 0.0f) {
                int iMin2 = Math.min(interfaceC9236Zb3.z(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, interfaceC9236Zb3.k0(iMin2));
            } else if (fE > 0.0f) {
                f += fE;
            }
        }
        int iRound = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) list.get(i4);
            float fE2 = F66.e(F66.c(interfaceC9236Zb32));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, interfaceC9236Zb32.k0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int g(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i3 = 0;
        float f = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i4);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            int iZ = interfaceC9236Zb3.Z(i);
            if (fE == 0.0f) {
                i3 += iZ;
            } else if (fE > 0.0f) {
                f += fE;
                iMax = Math.max(iMax, Math.round(iZ / fE));
            }
        }
        return Math.round(iMax * f) + i3 + ((list.size() - 1) * i2);
    }

    public final int h(List list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i2, i);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i3);
            float fE = F66.e(F66.c(interfaceC9236Zb3));
            if (fE == 0.0f) {
                int iMin2 = Math.min(interfaceC9236Zb3.z(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, interfaceC9236Zb3.i0(iMin2));
            } else if (fE > 0.0f) {
                f += fE;
            }
        }
        int iRound = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) list.get(i4);
            float fE2 = F66.e(F66.c(interfaceC9236Zb32));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, interfaceC9236Zb32.i0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }
}
