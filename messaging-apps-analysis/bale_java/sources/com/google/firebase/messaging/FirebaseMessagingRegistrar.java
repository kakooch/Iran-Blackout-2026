package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import ir.nasim.AbstractC10662bz3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.C10226bI1;
import ir.nasim.C5490Jo2;
import ir.nasim.I01;
import ir.nasim.InterfaceC10344bV2;
import ir.nasim.InterfaceC17465n07;
import ir.nasim.InterfaceC19410qI7;
import ir.nasim.InterfaceC6025Lv7;
import ir.nasim.InterfaceC7875To2;
import ir.nasim.InterfaceC8343Vo2;
import ir.nasim.S01;
import ir.nasim.Y01;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(S01 s01) {
        C5490Jo2 c5490Jo2 = (C5490Jo2) s01.a(C5490Jo2.class);
        AbstractC18350oW3.a(s01.a(InterfaceC8343Vo2.class));
        return new FirebaseMessaging(c5490Jo2, null, s01.d(InterfaceC19410qI7.class), s01.d(InterfaceC10344bV2.class), (InterfaceC7875To2) s01.a(InterfaceC7875To2.class), (InterfaceC6025Lv7) s01.a(InterfaceC6025Lv7.class), (InterfaceC17465n07) s01.a(InterfaceC17465n07.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<I01> getComponents() {
        return Arrays.asList(I01.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(C10226bI1.i(C5490Jo2.class)).b(C10226bI1.g(InterfaceC8343Vo2.class)).b(C10226bI1.h(InterfaceC19410qI7.class)).b(C10226bI1.h(InterfaceC10344bV2.class)).b(C10226bI1.g(InterfaceC6025Lv7.class)).b(C10226bI1.i(InterfaceC7875To2.class)).b(C10226bI1.i(InterfaceC17465n07.class)).f(new Y01() { // from class: ir.nasim.bp2
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return FirebaseMessagingRegistrar.lambda$getComponents$0(s01);
            }
        }).c().d(), AbstractC10662bz3.b(LIBRARY_NAME, "23.1.1"));
    }
}
