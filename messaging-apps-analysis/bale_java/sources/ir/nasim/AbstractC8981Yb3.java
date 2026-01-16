package ir.nasim;

import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.Yb3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8981Yb3 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(C12544en4 c12544en4, int i) {
        int iO = c12544en4.o() - 1;
        int i2 = 0;
        while (i2 < iO) {
            int i3 = ((iO - i2) / 2) + i2;
            int iB = ((InterfaceC8727Xb3.a) c12544en4.a[i3]).b();
            if (iB == i) {
                return i3;
            }
            if (iB < i) {
                i2 = i3 + 1;
                if (i < ((InterfaceC8727Xb3.a) c12544en4.a[i2]).b()) {
                    return i3;
                }
            } else {
                iO = i3 - 1;
            }
        }
        return i2;
    }
}
