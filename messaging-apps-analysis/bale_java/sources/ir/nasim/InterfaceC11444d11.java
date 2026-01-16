package ir.nasim;

import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

/* renamed from: ir.nasim.d11, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC11444d11 {
    public static final InterfaceC11444d11 a = new InterfaceC11444d11() { // from class: ir.nasim.c11
        @Override // ir.nasim.InterfaceC11444d11
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List a(ComponentRegistrar componentRegistrar);
}
