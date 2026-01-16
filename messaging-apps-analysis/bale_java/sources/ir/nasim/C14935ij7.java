package ir.nasim;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.ij7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C14935ij7 {
    private static final C14935ij7 b = new C14935ij7(new ArrayMap());
    protected final Map a;

    protected C14935ij7(Map map) {
        this.a = map;
    }

    public static C14935ij7 a(Pair pair) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put((String) pair.first, pair.second);
        return new C14935ij7(arrayMap);
    }

    public static C14935ij7 b() {
        return b;
    }

    public static C14935ij7 c(C14935ij7 c14935ij7) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : c14935ij7.e()) {
            arrayMap.put(str, c14935ij7.d(str));
        }
        return new C14935ij7(arrayMap);
    }

    public Object d(String str) {
        return this.a.get(str);
    }

    public Set e() {
        return this.a.keySet();
    }

    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
