package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.eW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC12377eW3 extends InterfaceC10436bc3 {

    /* renamed from: ir.nasim.eW3$a */
    public static final class a {
    }

    static /* synthetic */ InterfaceC11734dW3 Q1(InterfaceC12377eW3 interfaceC12377eW3, int i, int i2, Map map, UA2 ua2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i3 & 4) != 0) {
            map = AbstractC20051rO3.k();
        }
        return interfaceC12377eW3.P1(i, i2, map, ua2);
    }

    InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22);

    default InterfaceC11734dW3 P1(int i, int i2, Map map, UA2 ua2) {
        return E0(i, i2, map, null, ua2);
    }
}
