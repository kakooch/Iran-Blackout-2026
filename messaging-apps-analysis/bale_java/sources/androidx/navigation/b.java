package androidx.navigation;

import android.os.Bundle;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes2.dex */
public final class b {
    private final o a;
    private final boolean b;
    private final boolean c;
    private final Object d;

    public static final class a {
        private o a;
        private boolean b;
        private Object c;
        private boolean d;

        public final b a() {
            o oVarA = this.a;
            if (oVarA == null) {
                oVarA = o.c.a(this.c);
                AbstractC13042fc3.g(oVarA, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
            }
            return new b(oVarA, this.b, this.c, this.d);
        }

        public final a b(Object obj) {
            this.c = obj;
            this.d = true;
            return this;
        }

        public final a c(boolean z) {
            this.b = z;
            return this;
        }

        public final a d(o oVar) {
            AbstractC13042fc3.i(oVar, "type");
            this.a = oVar;
            return this;
        }
    }

    public b(o oVar, boolean z, Object obj, boolean z2) {
        AbstractC13042fc3.i(oVar, "type");
        if (!oVar.c() && z) {
            throw new IllegalArgumentException((oVar.b() + " does not allow nullable values").toString());
        }
        if (!z && z2 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + oVar.b() + " has null value but is not nullable.").toString());
        }
        this.a = oVar;
        this.b = z;
        this.d = obj;
        this.c = z2;
    }

    public final o a() {
        return this.a;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.b;
    }

    public final void d(String str, Bundle bundle) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(bundle, "bundle");
        if (this.c) {
            this.a.h(bundle, str, this.d);
        }
    }

    public final boolean e(String str, Bundle bundle) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(bundle, "bundle");
        if (!this.b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.a.a(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AbstractC13042fc3.d(b.class, obj.getClass())) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b != bVar.b || this.c != bVar.c || !AbstractC13042fc3.d(this.a, bVar.a)) {
            return false;
        }
        Object obj2 = this.d;
        return obj2 != null ? AbstractC13042fc3.d(obj2, bVar.d) : bVar.d == null;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.d;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b.class.getSimpleName());
        sb.append(" Type: " + this.a);
        sb.append(" Nullable: " + this.b);
        if (this.c) {
            sb.append(" DefaultValue: " + this.d);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }
}
