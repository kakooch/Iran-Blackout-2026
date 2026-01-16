package androidx.compose.ui.focus;

import ir.nasim.InterfaceC14603iB2;

/* loaded from: classes2.dex */
public abstract class r {
    public static final q a(int i, InterfaceC14603iB2 interfaceC14603iB2) {
        return new FocusTargetNode(i, interfaceC14603iB2, null, 4, null);
    }

    public static /* synthetic */ q b(int i, InterfaceC14603iB2 interfaceC14603iB2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = u.a.a();
        }
        if ((i2 & 2) != 0) {
            interfaceC14603iB2 = null;
        }
        return a(i, interfaceC14603iB2);
    }
}
