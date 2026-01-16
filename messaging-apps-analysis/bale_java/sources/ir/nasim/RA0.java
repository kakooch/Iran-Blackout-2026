package ir.nasim;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.InitializationException;
import ir.nasim.MC0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class RA0 implements MC0 {
    private final C17585nD0 a;
    private int f = 0;
    private final Map c = new HashMap();
    private Set e = new HashSet();
    private final List b = new ArrayList();
    private List d = new ArrayList();

    public RA0(C17585nD0 c17585nD0) {
        this.a = c17585nD0;
        e();
    }

    private void e() {
        Set hashSet = new HashSet();
        try {
            hashSet = this.a.e();
        } catch (CameraAccessExceptionCompat unused) {
            PI3.c("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList((Set) it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                try {
                    if (AbstractC13430gD0.a(this.a, str) && AbstractC13430gD0.a(this.a, str2)) {
                        this.e.add(new HashSet(Arrays.asList(str, str2)));
                        if (!this.c.containsKey(str)) {
                            this.c.put(str, new ArrayList());
                        }
                        if (!this.c.containsKey(str2)) {
                            this.c.put(str2, new ArrayList());
                        }
                        ((List) this.c.get(str)).add((String) arrayList.get(1));
                        ((List) this.c.get(str2)).add((String) arrayList.get(0));
                    }
                } catch (InitializationException unused2) {
                    PI3.a("Camera2CameraCoordinator", "Concurrent camera id pair: (" + str + ", " + str2 + ") is not backward compatible");
                }
            }
        }
    }

    @Override // ir.nasim.MC0
    public void a(MC0.a aVar) {
        this.b.add(aVar);
    }

    @Override // ir.nasim.MC0
    public String b(String str) {
        if (!this.c.containsKey(str)) {
            return null;
        }
        for (String str2 : (List) this.c.get(str)) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                if (str2.equals(C17567nB0.a((InterfaceC14021hD0) it.next()).b())) {
                    return str2;
                }
            }
        }
        return null;
    }

    @Override // ir.nasim.MC0
    public int c() {
        return this.f;
    }

    @Override // ir.nasim.MC0
    public void d(int i) {
        if (i != this.f) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((MC0.a) it.next()).a(this.f, i);
            }
        }
        if (this.f == 2 && i != 2) {
            this.d.clear();
        }
        this.f = i;
    }
}
