package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qt3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19758qt3 {
    public static final a d = new a(null);
    private static final C19758qt3 e = new C19758qt3(EnumC18576ot3.b, false, false);
    private final EnumC18576ot3 a;
    private final boolean b;
    private final boolean c;

    /* renamed from: ir.nasim.qt3$a */
    public static final class a {
        private a() {
        }

        public final C19758qt3 a() {
            return C19758qt3.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C19758qt3(EnumC18576ot3 enumC18576ot3, boolean z, boolean z2) {
        AbstractC13042fc3.i(enumC18576ot3, "languageState");
        this.a = enumC18576ot3;
        this.b = z;
        this.c = z2;
    }

    public static /* synthetic */ C19758qt3 c(C19758qt3 c19758qt3, EnumC18576ot3 enumC18576ot3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC18576ot3 = c19758qt3.a;
        }
        if ((i & 2) != 0) {
            z = c19758qt3.b;
        }
        if ((i & 4) != 0) {
            z2 = c19758qt3.c;
        }
        return c19758qt3.b(enumC18576ot3, z, z2);
    }

    public final C19758qt3 b(EnumC18576ot3 enumC18576ot3, boolean z, boolean z2) {
        AbstractC13042fc3.i(enumC18576ot3, "languageState");
        return new C19758qt3(enumC18576ot3, z, z2);
    }

    public final EnumC18576ot3 d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19758qt3)) {
            return false;
        }
        C19758qt3 c19758qt3 = (C19758qt3) obj;
        return this.a == c19758qt3.a && this.b == c19758qt3.b && this.c == c19758qt3.c;
    }

    public final boolean f() {
        return this.b;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "LanguageUiState(languageState=" + this.a + ", updateLanguage=" + this.b + ", showLoading=" + this.c + Separators.RPAREN;
    }
}
