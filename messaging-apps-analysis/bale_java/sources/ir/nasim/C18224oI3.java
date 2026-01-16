package ir.nasim;

import android.content.LocusId;
import android.os.Build;

/* renamed from: ir.nasim.oI3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18224oI3 {
    private final String a;
    private final LocusId b;

    /* renamed from: ir.nasim.oI3$a */
    private static class a {
        static LocusId a(String str) {
            return new LocusId(str);
        }

        static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public C18224oI3(String str) {
        this.a = (String) AbstractC4980Hj5.k(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.b = a.a(str);
        } else {
            this.b = null;
        }
    }

    private String b() {
        return this.a.length() + "_chars";
    }

    public static C18224oI3 d(LocusId locusId) {
        AbstractC4980Hj5.h(locusId, "locusId cannot be null");
        return new C18224oI3((String) AbstractC4980Hj5.k(a.b(locusId), "id cannot be empty"));
    }

    public String a() {
        return this.a;
    }

    public LocusId c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C18224oI3.class != obj.getClass()) {
            return false;
        }
        C18224oI3 c18224oI3 = (C18224oI3) obj;
        String str = this.a;
        return str == null ? c18224oI3.a == null : str.equals(c18224oI3.a);
    }

    public int hashCode() {
        String str = this.a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
