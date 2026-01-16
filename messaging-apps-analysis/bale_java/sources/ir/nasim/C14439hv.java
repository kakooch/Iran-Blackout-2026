package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.hv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14439hv {
    private final String a;
    private final String b;
    private final a c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.hv$a */
    public static final class a {
        public static final a a = new a("Pin", 0);
        public static final a b = new a("Alert", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    public C14439hv(String str, String str2, a aVar) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, ParameterNames.TEXT);
        AbstractC13042fc3.i(aVar, "type");
        this.a = str;
        this.b = str2;
        this.c = aVar;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final a c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14439hv)) {
            return false;
        }
        C14439hv c14439hv = (C14439hv) obj;
        return AbstractC13042fc3.d(this.a, c14439hv.a) && AbstractC13042fc3.d(this.b, c14439hv.b) && this.c == c14439hv.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AnswerCallbackQuery(title=" + this.a + ", text=" + this.b + ", type=" + this.c + Separators.RPAREN;
    }
}
