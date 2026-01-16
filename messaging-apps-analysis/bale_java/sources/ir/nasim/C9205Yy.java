package ir.nasim;

import com.google.android.gms.common.api.a;

/* renamed from: ir.nasim.Yy, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9205Yy {
    private final int a;
    private final com.google.android.gms.common.api.a b;
    private final a.d c;
    private final String d;

    private C9205Yy(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        this.b = aVar;
        this.c = dVar;
        this.d = str;
        this.a = DG4.b(aVar, dVar, str);
    }

    public static C9205Yy a(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        return new C9205Yy(aVar, dVar, str);
    }

    public final String b() {
        return this.b.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C9205Yy)) {
            return false;
        }
        C9205Yy c9205Yy = (C9205Yy) obj;
        return DG4.a(this.b, c9205Yy.b) && DG4.a(this.c, c9205Yy.c) && DG4.a(this.d, c9205Yy.d);
    }

    public final int hashCode() {
        return this.a;
    }
}
