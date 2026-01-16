package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.Cy5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3930Cy5 {
    private final Map a;
    private final C21653tu1 b;

    public C3930Cy5(Map map, C21653tu1 c21653tu1) {
        AbstractC13042fc3.i(map, "base64Keys");
        AbstractC13042fc3.i(c21653tu1, "keyStore");
        this.a = map;
        this.b = c21653tu1;
    }

    public final Wb8 a(int i) {
        String string = this.b.a(i).getString("push_encrypted_key", null);
        if (string == null) {
            return null;
        }
        return new Wb8(C14582i90.a(string));
    }

    public final Wb8 b(int i) {
        if (this.a.containsKey(Integer.valueOf(i))) {
            return (Wb8) this.a.get(Integer.valueOf(i));
        }
        Wb8 wb8A = a(i);
        if (wb8A == null) {
            return null;
        }
        this.a.put(Integer.valueOf(i), wb8A);
        return wb8A;
    }
}
