package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Fm4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4523Fm4 {
    private static final C4523Fm4 b = new C4523Fm4();
    private final Map a = new HashMap();

    C4523Fm4() {
    }

    public static C4523Fm4 b() {
        return b;
    }

    public synchronized AbstractC20124rW4 a(String str) {
        if (!this.a.containsKey(str)) {
            throw new GeneralSecurityException("Name " + str + " does not exist");
        }
        return (AbstractC20124rW4) this.a.get(str);
    }

    public synchronized void c(String str, AbstractC20124rW4 abstractC20124rW4) {
        try {
            if (!this.a.containsKey(str)) {
                this.a.put(str, abstractC20124rW4);
                return;
            }
            if (((AbstractC20124rW4) this.a.get(str)).equals(abstractC20124rW4)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + this.a.get(str) + "), cannot insert " + abstractC20124rW4);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c((String) entry.getKey(), (AbstractC20124rW4) entry.getValue());
        }
    }
}
