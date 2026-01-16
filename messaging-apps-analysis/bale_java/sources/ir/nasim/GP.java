package ir.nasim;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* loaded from: classes3.dex */
public abstract class GP {
    public static final com.google.android.gms.common.api.a a;
    public static final com.google.android.gms.common.api.a b;
    public static final com.google.android.gms.common.api.a c;
    public static final InterfaceC9202Yx5 d;
    public static final InterfaceC20966su1 e;
    public static final VJ2 f;
    public static final a.g g;
    public static final a.g h;
    private static final a.AbstractC0169a i;
    private static final a.AbstractC0169a j;

    public static class a implements a.d {
        public static final a d = new a(new C0390a());
        private final String a = null;
        private final boolean b;
        private final String c;

        /* renamed from: ir.nasim.GP$a$a, reason: collision with other inner class name */
        public static class C0390a {
            protected Boolean a;
            protected String b;

            public C0390a() {
                this.a = Boolean.FALSE;
            }

            public final C0390a a(String str) {
                this.b = str;
                return this;
            }

            public C0390a(a aVar) {
                this.a = Boolean.FALSE;
                a.b(aVar);
                this.a = Boolean.valueOf(aVar.b);
                this.b = aVar.c;
            }
        }

        public a(C0390a c0390a) {
            this.b = c0390a.a.booleanValue();
            this.c = c0390a.b;
        }

        static /* bridge */ /* synthetic */ String b(a aVar) {
            String str = aVar.a;
            return null;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.b);
            bundle.putString("log_session_id", this.c);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            String str = aVar.a;
            return DG4.a(null, null) && this.b == aVar.b && DG4.a(this.c, aVar.c);
        }

        public int hashCode() {
            return DG4.b(null, Boolean.valueOf(this.b), this.c);
        }
    }

    static {
        a.g gVar = new a.g();
        g = gVar;
        a.g gVar2 = new a.g();
        h = gVar2;
        Zf8 zf8 = new Zf8();
        i = zf8;
        C11071cg8 c11071cg8 = new C11071cg8();
        j = c11071cg8;
        a = JQ.a;
        b = new com.google.android.gms.common.api.a("Auth.CREDENTIALS_API", zf8, gVar);
        c = new com.google.android.gms.common.api.a("Auth.GOOGLE_SIGN_IN_API", c11071cg8, gVar2);
        d = JQ.b;
        e = new C17269mg8();
        f = new C13705gg8();
    }
}
