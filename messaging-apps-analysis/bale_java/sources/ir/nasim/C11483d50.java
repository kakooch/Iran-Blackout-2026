package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.d50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11483d50 {
    private final int a;
    private final AbstractC20471s40 b;
    private final a c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final Integer h;
    private final Integer i;
    private final Integer j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.d50$a */
    public static final class a {
        public static final a a = new a("SOURCE", 0);
        public static final a b = new a("DESTINATION", 1);
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

    public C11483d50(int i, AbstractC20471s40 abstractC20471s40, a aVar, int i2, String str, String str2, String str3, Integer num, Integer num2, Integer num3) {
        AbstractC13042fc3.i(abstractC20471s40, "bankCard");
        AbstractC13042fc3.i(aVar, "type");
        AbstractC13042fc3.i(str, "cardNumber");
        AbstractC13042fc3.i(str2, "cardNumberMasked");
        this.a = i;
        this.b = abstractC20471s40;
        this.c = aVar;
        this.d = i2;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = num;
        this.i = num2;
        this.j = num3;
    }

    public final AbstractC20471s40 a() {
        return this.b;
    }

    public final int b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11483d50)) {
            return false;
        }
        C11483d50 c11483d50 = (C11483d50) obj;
        return this.a == c11483d50.a && AbstractC13042fc3.d(this.b, c11483d50.b) && this.c == c11483d50.c && this.d == c11483d50.d && AbstractC13042fc3.d(this.e, c11483d50.e) && AbstractC13042fc3.d(this.f, c11483d50.f) && AbstractC13042fc3.d(this.g, c11483d50.g) && AbstractC13042fc3.d(this.h, c11483d50.h) && AbstractC13042fc3.d(this.i, c11483d50.i) && AbstractC13042fc3.d(this.j, c11483d50.j);
    }

    public final a f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.h;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.i;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.j;
        return iHashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "BankCardSuggest(id=" + this.a + ", bankCard=" + this.b + ", type=" + this.c + ", bankLogoId=" + this.d + ", cardNumber=" + this.e + ", cardNumberMasked=" + this.f + ", cardOwnerName=" + this.g + ", cvv2=" + this.h + ", expireMonth=" + this.i + ", expireYear=" + this.j + Separators.RPAREN;
    }

    public /* synthetic */ C11483d50(int i, AbstractC20471s40 abstractC20471s40, a aVar, int i2, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i3, ED1 ed1) {
        this(i, abstractC20471s40, aVar, i2, str, str2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : num, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : num3);
    }
}
