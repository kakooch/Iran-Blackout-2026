package ir.nasim;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* renamed from: ir.nasim.nk7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C17899nk7 implements a.d {
    public static final C17899nk7 b = a().a();
    private final String a;

    /* renamed from: ir.nasim.nk7$a */
    public static class a {
        private String a;

        /* synthetic */ a(Pe8 pe8) {
        }

        public C17899nk7 a() {
            return new C17899nk7(this.a, null);
        }
    }

    /* synthetic */ C17899nk7(String str, Qe8 qe8) {
        this.a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C17899nk7) {
            return DG4.a(this.a, ((C17899nk7) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(this.a);
    }
}
