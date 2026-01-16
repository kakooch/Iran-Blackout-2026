package ir.nasim;

/* renamed from: ir.nasim.cU3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC10952cU3 {
    static /* synthetic */ androidx.lifecycle.r H(InterfaceC10952cU3 interfaceC10952cU3, int i, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategoryMarkets");
        }
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 1;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            z2 = false;
        }
        return interfaceC10952cU3.d0(i, i2, i3, z, z2);
    }

    androidx.lifecycle.r d0(int i, int i2, int i3, boolean z, boolean z2);
}
