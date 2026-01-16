package ir.nasim;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Pair;
import android.util.Size;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.zB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24773zB0 implements XC0 {
    private final Map a;
    private final InterfaceC21808uA0 b;

    /* renamed from: ir.nasim.zB0$a */
    class a implements InterfaceC21808uA0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC21808uA0
        public CamcorderProfile a(int i, int i2) {
            return CamcorderProfile.get(i, i2);
        }

        @Override // ir.nasim.InterfaceC21808uA0
        public boolean b(int i, int i2) {
            return CamcorderProfile.hasProfile(i, i2);
        }
    }

    public C24773zB0(Context context, Object obj, Set set) {
        this(context, new a(), obj, set);
    }

    private void c(Context context, C17585nD0 c17585nD0, Set set) {
        AbstractC4980Hj5.g(context);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            this.a.put(str, new C18667p27(context, str, c17585nD0, this.b));
        }
    }

    @Override // ir.nasim.XC0
    public Pair a(int i, String str, List list, Map map, boolean z, boolean z2) {
        AbstractC4980Hj5.b(!map.isEmpty(), "No new use cases to be bound.");
        C18667p27 c18667p27 = (C18667p27) this.a.get(str);
        if (c18667p27 != null) {
            return c18667p27.A(i, list, map, z, z2);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + str);
    }

    @Override // ir.nasim.XC0
    public AbstractC19849r27 b(int i, String str, int i2, Size size) {
        C18667p27 c18667p27 = (C18667p27) this.a.get(str);
        if (c18667p27 != null) {
            return c18667p27.M(i, i2, size);
        }
        return null;
    }

    C24773zB0(Context context, InterfaceC21808uA0 interfaceC21808uA0, Object obj, Set set) {
        this.a = new HashMap();
        AbstractC4980Hj5.g(interfaceC21808uA0);
        this.b = interfaceC21808uA0;
        c(context, obj instanceof C17585nD0 ? (C17585nD0) obj : C17585nD0.a(context), set);
    }
}
