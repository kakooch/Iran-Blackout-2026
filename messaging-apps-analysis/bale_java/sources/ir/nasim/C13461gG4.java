package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.gG4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13461gG4 {
    private String a;

    public C13461gG4(String str) {
        this.a = str;
    }

    private boolean a(C13461gG4 c13461gG4) {
        String str = this.a;
        return str == null || str.isEmpty() || c13461gG4.a == null;
    }

    private boolean b(C13461gG4 c13461gG4) {
        return this.a.equals(c13461gG4.a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C13461gG4)) {
            return false;
        }
        C13461gG4 c13461gG4 = (C13461gG4) obj;
        if (a(c13461gG4)) {
            return false;
        }
        return b(c13461gG4);
    }

    public int hashCode() {
        if (a(this)) {
            return 0;
        }
        return Arrays.hashCode(new Object[]{this.a});
    }
}
