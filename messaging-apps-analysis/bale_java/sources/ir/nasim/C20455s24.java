package ir.nasim;

import java.util.Comparator;

/* renamed from: ir.nasim.s24, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C20455s24 implements Comparator {
    public static final C20455s24 a = new C20455s24();

    private C20455s24() {
    }

    private static Integer b(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
        int iC = c(interfaceC12795fB12) - c(interfaceC12795fB1);
        if (iC != 0) {
            return Integer.valueOf(iC);
        }
        if (OI1.B(interfaceC12795fB1) && OI1.B(interfaceC12795fB12)) {
            return 0;
        }
        int iCompareTo = interfaceC12795fB1.getName().compareTo(interfaceC12795fB12.getName());
        if (iCompareTo != 0) {
            return Integer.valueOf(iCompareTo);
        }
        return null;
    }

    private static int c(InterfaceC12795fB1 interfaceC12795fB1) {
        if (OI1.B(interfaceC12795fB1)) {
            return 8;
        }
        if (interfaceC12795fB1 instanceof InterfaceC21426te1) {
            return 7;
        }
        if (interfaceC12795fB1 instanceof InterfaceC20989sw5) {
            return ((InterfaceC20989sw5) interfaceC12795fB1).Q() == null ? 6 : 5;
        }
        if (interfaceC12795fB1 instanceof AB2) {
            return ((AB2) interfaceC12795fB1).Q() == null ? 4 : 3;
        }
        if (interfaceC12795fB1 instanceof InterfaceC21331tU0) {
            return 2;
        }
        return interfaceC12795fB1 instanceof InterfaceC7722Sx7 ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
        Integer numB = b(interfaceC12795fB1, interfaceC12795fB12);
        if (numB != null) {
            return numB.intValue();
        }
        return 0;
    }
}
