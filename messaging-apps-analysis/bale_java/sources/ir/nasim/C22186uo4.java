package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.banking.entity.MyBankData;

/* renamed from: ir.nasim.uo4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22186uo4 {
    private String a;
    private Boolean b;
    private String c;
    private Integer d;
    private String e;
    private Integer f;
    private boolean g;
    private boolean h;
    private String i;
    private boolean j;
    private Boolean k;
    private Boolean l;
    private String m;
    private MyBankData.Payload n;
    private Integer o;

    public C22186uo4(String str, Boolean bool, String str2, Integer num, String str3, Integer num2, boolean z, boolean z2, String str4, boolean z3, Boolean bool2, Boolean bool3, String str5, MyBankData.Payload payload, Integer num3) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str3, ParameterNames.ICON);
        this.a = str;
        this.b = bool;
        this.c = str2;
        this.d = num;
        this.e = str3;
        this.f = num2;
        this.g = z;
        this.h = z2;
        this.i = str4;
        this.j = z3;
        this.k = bool2;
        this.l = bool3;
        this.m = str5;
        this.n = payload;
        this.o = num3;
    }

    public final MyBankData.Payload a() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22186uo4)) {
            return false;
        }
        C22186uo4 c22186uo4 = (C22186uo4) obj;
        return AbstractC13042fc3.d(this.a, c22186uo4.a) && AbstractC13042fc3.d(this.b, c22186uo4.b) && AbstractC13042fc3.d(this.c, c22186uo4.c) && AbstractC13042fc3.d(this.d, c22186uo4.d) && AbstractC13042fc3.d(this.e, c22186uo4.e) && AbstractC13042fc3.d(this.f, c22186uo4.f) && this.g == c22186uo4.g && this.h == c22186uo4.h && AbstractC13042fc3.d(this.i, c22186uo4.i) && this.j == c22186uo4.j && AbstractC13042fc3.d(this.k, c22186uo4.k) && AbstractC13042fc3.d(this.l, c22186uo4.l) && AbstractC13042fc3.d(this.m, c22186uo4.m) && AbstractC13042fc3.d(this.n, c22186uo4.n) && AbstractC13042fc3.d(this.o, c22186uo4.o);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Boolean bool = this.b;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode4 = (((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.e.hashCode()) * 31;
        Integer num2 = this.f;
        int iHashCode5 = (((((iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31;
        String str2 = this.i;
        int iHashCode6 = (((iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.j)) * 31;
        Boolean bool2 = this.k;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.l;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str3 = this.m;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MyBankData.Payload payload = this.n;
        int iHashCode10 = (iHashCode9 + (payload == null ? 0 : payload.hashCode())) * 31;
        Integer num3 = this.o;
        return iHashCode10 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "MyBankItemView(title=" + this.a + ", isEditable=" + this.b + ", eventKey=" + this.c + ", id=" + this.d + ", icon=" + this.e + ", action=" + this.f + ", isFixed=" + this.g + ", isCategory=" + this.h + ", badge=" + this.i + ", blinkBadge=" + this.j + ", isDisable=" + this.k + ", isAd=" + this.l + ", message=" + this.m + ", payload=" + this.n + ", badgeType=" + this.o + Separators.RPAREN;
    }

    public /* synthetic */ C22186uo4(String str, Boolean bool, String str2, Integer num, String str3, Integer num2, boolean z, boolean z2, String str4, boolean z3, Boolean bool2, Boolean bool3, String str5, MyBankData.Payload payload, Integer num3, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? null : str2, num, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? 0 : num2, (i & 64) != 0 ? true : z, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? "" : str4, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? Boolean.FALSE : bool2, (i & 2048) != 0 ? Boolean.FALSE : bool3, (i & 4096) != 0 ? "" : str5, (i & 8192) != 0 ? null : payload, (i & 16384) != 0 ? 0 : num3);
    }
}
