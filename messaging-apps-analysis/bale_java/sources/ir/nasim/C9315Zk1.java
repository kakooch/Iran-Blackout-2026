package ir.nasim;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Zk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9315Zk1 {
    private final Map a = new HashMap();
    private final List b = new ArrayList();

    private C9315Zk1 a(String str, Object obj) {
        this.a.put((String) AbstractC20011rK.e(str), AbstractC20011rK.e(obj));
        this.b.remove(str);
        return this;
    }

    public static C9315Zk1 g(C9315Zk1 c9315Zk1, long j) {
        return c9315Zk1.e("exo_len", j);
    }

    public static C9315Zk1 h(C9315Zk1 c9315Zk1, Uri uri) {
        return uri == null ? c9315Zk1.d("exo_redir") : c9315Zk1.f("exo_redir", uri.toString());
    }

    public Map b() {
        HashMap map = new HashMap(this.a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public List c() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    public C9315Zk1 d(String str) {
        this.b.add(str);
        this.a.remove(str);
        return this;
    }

    public C9315Zk1 e(String str, long j) {
        return a(str, Long.valueOf(j));
    }

    public C9315Zk1 f(String str, String str2) {
        return a(str, str2);
    }
}
