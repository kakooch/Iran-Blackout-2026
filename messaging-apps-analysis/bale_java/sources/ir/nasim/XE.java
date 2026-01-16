package ir.nasim;

/* loaded from: classes5.dex */
public final class XE extends AbstractC18385oa2 {
    public static final a b = new a(null);
    public final boolean a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public XE(boolean z) {
        this.a = z;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "app_visible_changed";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof XE) && this.a == ((XE) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String toString() {
        return "app_visible_changed {" + this.a + "}";
    }
}
