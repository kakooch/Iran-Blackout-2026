package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.c62, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10731c62 {
    public static final a f = new a(null);
    private final int a;
    private final String b;
    private final int c;
    private final String d;
    private final String e;

    /* renamed from: ir.nasim.c62$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C10731c62(int i, String str, int i2, String str2, String str3) {
        AbstractC13042fc3.i(str, "emojiCode");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = str2;
        this.e = str3;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10731c62)) {
            return false;
        }
        C10731c62 c10731c62 = (C10731c62) obj;
        return this.a == c10731c62.a && AbstractC13042fc3.d(this.b, c10731c62.b) && this.c == c10731c62.c && AbstractC13042fc3.d(this.d, c10731c62.d) && AbstractC13042fc3.d(this.e, c10731c62.e);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "EmojiKeywordEntity(id=" + this.a + ", emojiCode=" + this.b + ", packId=" + this.c + ", keywordsEn=" + this.d + ", keywordsFa=" + this.e + Separators.RPAREN;
    }
}
