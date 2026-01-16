package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import ir.nasim.AbstractC10662bz3;
import ir.nasim.C10226bI1;
import ir.nasim.C5490Jo2;
import ir.nasim.I01;
import ir.nasim.InterfaceC7875To2;
import ir.nasim.InterfaceC9750aV2;
import ir.nasim.S01;
import ir.nasim.Y01;
import ir.nasim.ZU2;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC7875To2 lambda$getComponents$0(S01 s01) {
        return new c((C5490Jo2) s01.a(C5490Jo2.class), s01.d(InterfaceC9750aV2.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<I01> getComponents() {
        return Arrays.asList(I01.c(InterfaceC7875To2.class).h(LIBRARY_NAME).b(C10226bI1.i(C5490Jo2.class)).b(C10226bI1.h(InterfaceC9750aV2.class)).f(new Y01() { // from class: ir.nasim.Uo2
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(s01);
            }
        }).d(), ZU2.a(), AbstractC10662bz3.b(LIBRARY_NAME, "17.1.0"));
    }
}
