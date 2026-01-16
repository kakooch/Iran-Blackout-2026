package ir.nasim;

import android.util.ArrayMap;
import java.util.Map;

/* renamed from: ir.nasim.cn4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C11310cn4 extends C14935ij7 {
    private C11310cn4(Map map) {
        super(map);
    }

    public static C11310cn4 g() {
        return new C11310cn4(new ArrayMap());
    }

    public static C11310cn4 h(C14935ij7 c14935ij7) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : c14935ij7.e()) {
            arrayMap.put(str, c14935ij7.d(str));
        }
        return new C11310cn4(arrayMap);
    }

    public void f(C14935ij7 c14935ij7) {
        Map map;
        Map map2 = this.a;
        if (map2 == null || (map = c14935ij7.a) == null) {
            return;
        }
        map2.putAll(map);
    }

    public void i(String str, Object obj) {
        this.a.put(str, obj);
    }
}
