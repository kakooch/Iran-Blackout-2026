package ir.nasim;

import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Eu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4360Eu3 {
    private static final WH1 a = YH1.b(1.0f, 0.0f, 2, null);

    public static final InterfaceC23714xO4 b(C3419Au3 c3419Au3) {
        InterfaceC23714xO4 interfaceC23714xO4Z0 = c3419Au3.z0();
        if (interfaceC23714xO4Z0 != null) {
            return interfaceC23714xO4Z0;
        }
        M73.c("LayoutNode should be attached to an owner");
        throw new KotlinNothingValueException();
    }
}
