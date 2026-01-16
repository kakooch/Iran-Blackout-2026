package ir.nasim;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class CH3 {
    public static final a b = new a(null);
    private final Locale a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public CH3(Locale locale) {
        this.a = locale;
    }

    public final Locale a() {
        return this.a;
    }

    public final String b() {
        return AbstractC14893if5.a(this.a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CH3)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return AbstractC13042fc3.d(b(), ((CH3) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b();
    }

    public CH3(String str) {
        this(AbstractC14283hf5.a().a(str));
    }
}
