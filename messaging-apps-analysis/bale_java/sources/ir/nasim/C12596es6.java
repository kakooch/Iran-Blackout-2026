package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.bank.mybank.model.ServiceShortcutEntity;
import java.util.List;

/* renamed from: ir.nasim.es6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12596es6 {
    public static final a h = new a(null);
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;

    /* renamed from: ir.nasim.es6$a */
    public static final class a {
        private a() {
        }

        public final C12596es6 a(ServiceShortcutEntity serviceShortcutEntity) {
            AbstractC13042fc3.i(serviceShortcutEntity, "serviceShortcutEntity");
            List listM0 = AbstractC20762sZ6.M0(serviceShortcutEntity.getIcon(), new char[]{'|'}, false, 2, 2, null);
            return new C12596es6(serviceShortcutEntity.getId(), serviceShortcutEntity.getTitle(), (String) AbstractC15401jX0.t0(listM0, 0), (String) AbstractC15401jX0.t0(listM0, 1), serviceShortcutEntity.getBgColorLight(), serviceShortcutEntity.getBgColorDark(), serviceShortcutEntity.getNavCategoryID());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12596es6(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str4, "bgColorLight");
        AbstractC13042fc3.i(str5, "bgColorDark");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = i2;
    }

    public final String a() {
        return this.f;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.c;
    }

    public final int e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12596es6)) {
            return false;
        }
        C12596es6 c12596es6 = (C12596es6) obj;
        return this.a == c12596es6.a && AbstractC13042fc3.d(this.b, c12596es6.b) && AbstractC13042fc3.d(this.c, c12596es6.c) && AbstractC13042fc3.d(this.d, c12596es6.d) && AbstractC13042fc3.d(this.e, c12596es6.e) && AbstractC13042fc3.d(this.f, c12596es6.f) && this.g == c12596es6.g;
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ServiceShortcutUI(id=" + this.a + ", title=" + this.b + ", iconUrlLight=" + this.c + ", iconUrlDark=" + this.d + ", bgColorLight=" + this.e + ", bgColorDark=" + this.f + ", sectionId=" + this.g + Separators.RPAREN;
    }
}
