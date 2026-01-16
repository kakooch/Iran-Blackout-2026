package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.cct.a;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import ir.nasim.AbstractC10662bz3;
import ir.nasim.C10226bI1;
import ir.nasim.C7470Rv7;
import ir.nasim.I01;
import ir.nasim.InterfaceC6025Lv7;
import ir.nasim.S01;
import ir.nasim.Y01;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC6025Lv7 lambda$getComponents$0(S01 s01) {
        C7470Rv7.f((Context) s01.a(Context.class));
        return C7470Rv7.c().g(a.h);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<I01> getComponents() {
        return Arrays.asList(I01.c(InterfaceC6025Lv7.class).h(LIBRARY_NAME).b(C10226bI1.i(Context.class)).f(new Y01() { // from class: ir.nasim.Qv7
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return TransportRegistrar.lambda$getComponents$0(s01);
            }
        }).d(), AbstractC10662bz3.b(LIBRARY_NAME, "18.1.7"));
    }
}
