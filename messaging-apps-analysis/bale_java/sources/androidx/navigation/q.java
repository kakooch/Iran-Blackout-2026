package androidx.navigation;

import androidx.navigation.p;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.ED1;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class q {
    public static final a b = new a(null);
    private static final Map c = new LinkedHashMap();
    private final Map a = new LinkedHashMap();

    public static final class a {
        private a() {
        }

        public final String a(Class cls) {
            AbstractC13042fc3.i(cls, "navigatorClass");
            String strValue = (String) q.c.get(cls);
            if (strValue == null) {
                p.b bVar = (p.b) cls.getAnnotation(p.b.class);
                strValue = bVar != null ? bVar.value() : null;
                if (!b(strValue)) {
                    throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + cls.getSimpleName()).toString());
                }
                q.c.put(cls, strValue);
            }
            AbstractC13042fc3.f(strValue);
            return strValue;
        }

        public final boolean b(String str) {
            return str != null && str.length() > 0;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public final p b(p pVar) {
        AbstractC13042fc3.i(pVar, "navigator");
        return c(b.a(pVar.getClass()), pVar);
    }

    public p c(String str, p pVar) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(pVar, "navigator");
        if (!b.b(str)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        p pVar2 = (p) this.a.get(str);
        if (AbstractC13042fc3.d(pVar2, pVar)) {
            return pVar;
        }
        boolean z = false;
        if (pVar2 != null && pVar2.c()) {
            z = true;
        }
        if (!(!z)) {
            throw new IllegalStateException(("Navigator " + pVar + " is replacing an already attached " + pVar2).toString());
        }
        if (!pVar.c()) {
            return (p) this.a.put(str, pVar);
        }
        throw new IllegalStateException(("Navigator " + pVar + " is already attached to another NavController").toString());
    }

    public final p d(Class cls) {
        AbstractC13042fc3.i(cls, "navigatorClass");
        return e(b.a(cls));
    }

    public p e(String str) {
        AbstractC13042fc3.i(str, "name");
        if (!b.b(str)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        p pVar = (p) this.a.get(str);
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    public final Map f() {
        return AbstractC20051rO3.y(this.a);
    }
}
