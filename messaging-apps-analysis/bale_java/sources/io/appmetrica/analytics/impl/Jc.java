package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleServiceEventHandler;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.DY6;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Jc extends AbstractC2568gg {
    public final ArrayList b;

    public Jc(C2484d5 c2484d5) {
        super(c2484d5);
        String strB = c2484d5.b().b();
        strB = strB == null ? "empty" : strB;
        DY6 dy6 = DY6.a;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{strB}, 1));
        LinkedHashMap linkedHashMapA = C2586ha.h().l().a(strB);
        ArrayList arrayList = new ArrayList(linkedHashMapA.size());
        for (Map.Entry entry : linkedHashMapA.entrySet()) {
            arrayList.add(AbstractC4616Fw7.a(entry.getValue(), new Ac(c2484d5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        ArrayList arrayList = this.b;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                XV4 xv4 = (XV4) it.next();
                ModuleServiceEventHandler moduleServiceEventHandler = (ModuleServiceEventHandler) xv4.a();
                Ac ac = (Ac) xv4.b();
                if (moduleServiceEventHandler.handle(new Dc(ac.b, ac.a, new Cc(ac.c, q5)), q5)) {
                    return true;
                }
            }
        }
        return false;
    }
}
