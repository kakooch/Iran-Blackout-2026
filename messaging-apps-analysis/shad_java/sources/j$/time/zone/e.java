package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.List;

/* loaded from: classes2.dex */
class e implements PrivilegedAction {
    final /* synthetic */ List a;

    e(List list) {
        this.a = list;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property == null) {
            g.d(new f());
            return null;
        }
        try {
            g gVar = (g) g.class.cast(Class.forName(property, true, g.class.getClassLoader()).newInstance());
            g.d(gVar);
            this.a.add(gVar);
            return null;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
