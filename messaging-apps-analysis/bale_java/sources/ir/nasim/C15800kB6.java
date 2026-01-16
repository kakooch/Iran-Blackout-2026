package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.kB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15800kB6 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final InterfaceC14603iB2 e;
    private final String f;
    private final boolean g;
    private final Integer h;
    private final Integer i;
    private final List j;
    private final List k;

    public C15800kB6(String str, String str2, String str3, String str4, InterfaceC14603iB2 interfaceC14603iB2, String str5, boolean z, Integer num, Integer num2, List list, List list2) {
        AbstractC13042fc3.i(str, "componentKey");
        AbstractC13042fc3.i(str2, "group");
        AbstractC13042fc3.i(str3, "componentName");
        AbstractC13042fc3.i(str4, "componentKDoc");
        AbstractC13042fc3.i(interfaceC14603iB2, "component");
        AbstractC13042fc3.i(list, "tags");
        AbstractC13042fc3.i(list2, "extraMetadata");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = interfaceC14603iB2;
        this.f = str5;
        this.g = z;
        this.h = num;
        this.i = num2;
        this.j = list;
        this.k = list2;
    }

    public final InterfaceC14603iB2 a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15800kB6)) {
            return false;
        }
        C15800kB6 c15800kB6 = (C15800kB6) obj;
        return AbstractC13042fc3.d(this.a, c15800kB6.a) && AbstractC13042fc3.d(this.b, c15800kB6.b) && AbstractC13042fc3.d(this.c, c15800kB6.c) && AbstractC13042fc3.d(this.d, c15800kB6.d) && AbstractC13042fc3.d(this.e, c15800kB6.e) && AbstractC13042fc3.d(this.f, c15800kB6.f) && this.g == c15800kB6.g && AbstractC13042fc3.d(this.h, c15800kB6.h) && AbstractC13042fc3.d(this.i, c15800kB6.i) && AbstractC13042fc3.d(this.j, c15800kB6.j) && AbstractC13042fc3.d(this.k, c15800kB6.k);
    }

    public final Integer f() {
        return this.i;
    }

    public final String g() {
        return this.f;
    }

    public final Integer h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String str = this.f;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.g)) * 31;
        Integer num = this.h;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.i;
        return ((((iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }

    public final boolean i() {
        return this.g;
    }

    public String toString() {
        return "ShowkaseBrowserComponent(componentKey=" + this.a + ", group=" + this.b + ", componentName=" + this.c + ", componentKDoc=" + this.d + ", component=" + this.e + ", styleName=" + this.f + ", isDefaultStyle=" + this.g + ", widthDp=" + this.h + ", heightDp=" + this.i + ", tags=" + this.j + ", extraMetadata=" + this.k + Separators.RPAREN;
    }

    public /* synthetic */ C15800kB6(String str, String str2, String str3, String str4, InterfaceC14603iB2 interfaceC14603iB2, String str5, boolean z, Integer num, Integer num2, List list, List list2, int i, ED1 ed1) {
        this(str, str2, str3, str4, interfaceC14603iB2, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? AbstractC10360bX0.m() : list, (i & 1024) != 0 ? AbstractC10360bX0.m() : list2);
    }
}
