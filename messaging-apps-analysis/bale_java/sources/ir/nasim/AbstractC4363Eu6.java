package ir.nasim;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.Eu6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4363Eu6 {
    public static Set a(Set set) {
        AbstractC13042fc3.i(set, "builder");
        return ((C13252fu6) set).j();
    }

    public static Set b() {
        return new C13252fu6();
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        AbstractC13042fc3.h(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
