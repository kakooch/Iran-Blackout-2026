package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.wB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23009wB6 {
    private final List a;
    private final List b;
    private final List c;

    public C23009wB6(List list, List list2, List list3) {
        AbstractC13042fc3.i(list, "componentList");
        AbstractC13042fc3.i(list2, "colorList");
        AbstractC13042fc3.i(list3, "typographyList");
        this.a = list;
        this.b = list2;
        this.c = list3;
    }

    public final List a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public final List d() {
        return this.b;
    }

    public final List e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23009wB6)) {
            return false;
        }
        C23009wB6 c23009wB6 = (C23009wB6) obj;
        return AbstractC13042fc3.d(this.a, c23009wB6.a) && AbstractC13042fc3.d(this.b, c23009wB6.b) && AbstractC13042fc3.d(this.c, c23009wB6.c);
    }

    public final List f() {
        return this.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ShowkaseElementsMetadata(componentList=" + this.a + ", colorList=" + this.b + ", typographyList=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C23009wB6(List list, List list2, List list3, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC10360bX0.m() : list, (i & 2) != 0 ? AbstractC10360bX0.m() : list2, (i & 4) != 0 ? AbstractC10360bX0.m() : list3);
    }
}
