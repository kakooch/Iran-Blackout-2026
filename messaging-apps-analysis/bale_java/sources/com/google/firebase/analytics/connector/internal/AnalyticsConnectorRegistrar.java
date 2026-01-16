package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import ir.nasim.AbstractC10662bz3;
import ir.nasim.C10226bI1;
import ir.nasim.C4050Dm;
import ir.nasim.C5490Jo2;
import ir.nasim.I01;
import ir.nasim.InterfaceC17465n07;
import ir.nasim.InterfaceC3816Cm;
import ir.nasim.S01;
import ir.nasim.Y01;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<I01> getComponents() {
        return Arrays.asList(I01.c(InterfaceC3816Cm.class).b(C10226bI1.i(C5490Jo2.class)).b(C10226bI1.i(Context.class)).b(C10226bI1.i(InterfaceC17465n07.class)).f(new Y01() { // from class: com.google.firebase.analytics.connector.internal.a
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return C4050Dm.c((C5490Jo2) s01.a(C5490Jo2.class), (Context) s01.a(Context.class), (InterfaceC17465n07) s01.a(InterfaceC17465n07.class));
            }
        }).e().d(), AbstractC10662bz3.b("fire-analytics", "21.2.0"));
    }
}
