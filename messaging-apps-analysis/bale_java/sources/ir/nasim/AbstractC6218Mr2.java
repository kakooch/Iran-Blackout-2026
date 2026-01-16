package ir.nasim;

import androidx.compose.ui.focus.FocusTargetNode;

/* renamed from: ir.nasim.Mr2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6218Mr2 {
    public static final C6468Nr2 a(FocusTargetNode focusTargetNode) {
        C3419Au3 c3419Au3G1;
        InterfaceC23714xO4 interfaceC23714xO4Z0;
        InterfaceC4566Fr2 focusOwner;
        XA4 xa4T1 = focusTargetNode.h().T1();
        if (xa4T1 == null || (c3419Au3G1 = xa4T1.G1()) == null || (interfaceC23714xO4Z0 = c3419Au3G1.z0()) == null || (focusOwner = interfaceC23714xO4Z0.getFocusOwner()) == null) {
            return null;
        }
        return focusOwner.e();
    }

    public static final void b(FocusTargetNode focusTargetNode) {
        KG1.p(focusTargetNode).getFocusOwner().j(focusTargetNode);
    }

    public static final C6468Nr2 c(FocusTargetNode focusTargetNode) {
        return KG1.p(focusTargetNode).getFocusOwner().e();
    }
}
