package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ax3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10028ax3 {
    public static final int a(InterfaceC9425Zw3 interfaceC9425Zw3) {
        List listI = interfaceC9425Zw3.i();
        int size = listI.size();
        int iF = 0;
        for (int i = 0; i < size; i++) {
            iF += ((InterfaceC7948Tw3) listI.get(i)).f();
        }
        return (iF / listI.size()) + interfaceC9425Zw3.h();
    }
}
