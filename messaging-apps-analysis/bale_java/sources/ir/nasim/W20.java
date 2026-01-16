package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.View;
import java.util.List;

/* loaded from: classes3.dex */
public final class W20 {
    private final View a;
    private final List b;
    private final E20 c;
    private final int d;
    private final int e;
    private final EnumC4935He5 f;

    public W20(View view, List list, E20 e20, int i, int i2, EnumC4935He5 enumC4935He5) {
        AbstractC13042fc3.i(view, "anchor");
        AbstractC13042fc3.i(list, "subAnchors");
        AbstractC13042fc3.i(e20, "align");
        AbstractC13042fc3.i(enumC4935He5, "type");
        this.a = view;
        this.b = list;
        this.c = e20;
        this.d = i;
        this.e = i2;
        this.f = enumC4935He5;
    }

    public final E20 a() {
        return this.c;
    }

    public final View b() {
        return this.a;
    }

    public final List c() {
        return this.b;
    }

    public final EnumC4935He5 d() {
        return this.f;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof W20)) {
            return false;
        }
        W20 w20 = (W20) obj;
        return AbstractC13042fc3.d(this.a, w20.a) && AbstractC13042fc3.d(this.b, w20.b) && this.c == w20.c && this.d == w20.d && this.e == w20.e && this.f == w20.f;
    }

    public final int f() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "BalloonPlacement(anchor=" + this.a + ", subAnchors=" + this.b + ", align=" + this.c + ", xOff=" + this.d + ", yOff=" + this.e + ", type=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ W20(View view, List list, E20 e20, int i, int i2, EnumC4935He5 enumC4935He5, int i3, ED1 ed1) {
        this(view, (i3 & 2) != 0 ? AbstractC10360bX0.m() : list, (i3 & 4) != 0 ? E20.c : e20, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? EnumC4935He5.a : enumC4935He5);
    }
}
