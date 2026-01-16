package ir.nasim;

/* renamed from: ir.nasim.wV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC23189wV6 {
    static /* synthetic */ void u3(InterfaceC23189wV6 interfaceC23189wV6, String str, String str2, SA2 sa2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showGetStoryFailureSnackBar");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.vV6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InterfaceC23189wV6.w3();
                }
            };
        }
        interfaceC23189wV6.W0(str, str2, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static C19938rB7 w3() {
        return C19938rB7.a;
    }

    void A0();

    void U2(String str);

    void W0(String str, String str2, SA2 sa2);

    Object q1(InterfaceC20295rm1 interfaceC20295rm1);
}
