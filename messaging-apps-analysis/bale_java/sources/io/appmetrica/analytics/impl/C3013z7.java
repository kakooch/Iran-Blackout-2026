package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13610gX0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.z7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3013z7 implements ClientComponentsInitializer {
    public final List a = AbstractC10360bX0.p("io.appmetrica.analytics.adrevenue.admob.v23.internal.AdMobClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.applovin.v12.internal.AppLovinClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.fyber.v3.internal.FyberClientModuleEntryPoint", "io.appmetrica.analytics.adrevenue.ironsource.v7.internal.IronSourceClientModuleEntryPoint");

    @Override // io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer
    public final void onCreate() {
        if (C2747o4.g().a.c()) {
            C3018zc c3018zc = C2747o4.g().l;
            List list = this.a;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C2867t5((String) it.next()));
            }
            Object[] array = arrayList.toArray(new C2867t5[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            C2867t5[] c2867t5Arr = (C2867t5[]) array;
            InterfaceC2994yc[] interfaceC2994ycArr = (InterfaceC2994yc[]) Arrays.copyOf(c2867t5Arr, c2867t5Arr.length);
            synchronized (c3018zc) {
                AbstractC13610gX0.E(c3018zc.a, interfaceC2994ycArr);
            }
        }
    }
}
