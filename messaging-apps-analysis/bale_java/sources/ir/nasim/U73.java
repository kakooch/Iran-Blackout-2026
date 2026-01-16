package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* loaded from: classes5.dex */
public final class U73 {
    private final String a;
    private final boolean b;
    private final String c;
    private final String d;
    private final String e;
    private final C6750Ov f;
    private a g;
    private final C18611ox h;

    public static final class a {
        private final String a;

        public a(String str) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "CopyText(text=" + this.a + Separators.RPAREN;
        }
    }

    public U73(C4875Gy c4875Gy) {
        AbstractC13042fc3.i(c4875Gy, "apiInlineKeyboardButton");
        String strW = c4875Gy.w();
        AbstractC13042fc3.h(strW, "getText(...)");
        this.a = strW;
        this.b = AbstractC13042fc3.d(c4875Gy.C(), Boolean.TRUE);
        this.c = c4875Gy.y();
        this.d = c4875Gy.r();
        C23610xD c23610xDZ = c4875Gy.z();
        this.e = c23610xDZ != null ? c23610xDZ.q() : null;
        this.f = c4875Gy.q();
        this.h = c4875Gy.u();
        C15656jx c15656jxS = c4875Gy.s();
        if (c15656jxS != null) {
            String strQ = c15656jxS.q();
            AbstractC13042fc3.h(strQ, "getText(...)");
            this.g = new a(strQ);
        }
    }

    public final C6750Ov a() {
        return this.f;
    }

    public final String b() {
        return this.d;
    }

    public final a c() {
        return this.g;
    }

    public final C18611ox d() {
        return this.h;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(U73.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.InlineKeyboardButton");
        U73 u73 = (U73) obj;
        return this.b == u73.b && AbstractC13042fc3.d(this.a, u73.a) && AbstractC13042fc3.d(this.c, u73.c) && AbstractC13042fc3.d(this.d, u73.d) && AbstractC13042fc3.d(this.e, u73.e) && AbstractC13042fc3.d(this.f, u73.f) && AbstractC13042fc3.d(this.g, u73.g) && AbstractC13042fc3.d(this.h, u73.h);
    }

    public final String f() {
        return this.a;
    }

    public final String g() {
        return this.c;
    }

    public final String h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.b) * 31) + this.a.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        C6750Ov c6750Ov = this.f;
        int iHashCode5 = (iHashCode4 + (c6750Ov != null ? c6750Ov.hashCode() : 0)) * 31;
        a aVar = this.g;
        int iHashCode6 = (iHashCode5 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        C18611ox c18611ox = this.h;
        return iHashCode6 + (c18611ox != null ? c18611ox.hashCode() : 0);
    }
}
