package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: ir.nasim.Ql1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7140Ql1 {
    private final View a;
    private final ViewGroup b;
    private final Point c;
    private final RS4 d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;

    public C7140Ql1(View view, ViewGroup viewGroup, Point point, RS4 rs4, boolean z, int i, int i2, int i3, boolean z2) {
        AbstractC13042fc3.i(view, "anchor");
        AbstractC13042fc3.i(viewGroup, "container");
        AbstractC13042fc3.i(point, "point");
        AbstractC13042fc3.i(rs4, "contentViewPadding");
        this.a = view;
        this.b = viewGroup;
        this.c = point;
        this.d = rs4;
        this.e = z;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = z2;
    }

    public final View a() {
        return this.a;
    }

    public final ViewGroup b() {
        return this.b;
    }

    public final RS4 c() {
        return this.d;
    }

    public final boolean d() {
        return this.e;
    }

    public final Point e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7140Ql1)) {
            return false;
        }
        C7140Ql1 c7140Ql1 = (C7140Ql1) obj;
        return AbstractC13042fc3.d(this.a, c7140Ql1.a) && AbstractC13042fc3.d(this.b, c7140Ql1.b) && AbstractC13042fc3.d(this.c, c7140Ql1.c) && AbstractC13042fc3.d(this.d, c7140Ql1.d) && this.e == c7140Ql1.e && this.f == c7140Ql1.f && this.g == c7140Ql1.g && this.h == c7140Ql1.h && this.i == c7140Ql1.i;
    }

    public final int f() {
        return this.h;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Boolean.hashCode(this.i);
    }

    public final boolean i() {
        return this.i;
    }

    public String toString() {
        return "ContextMenuData(anchor=" + this.a + ", container=" + this.b + ", point=" + this.c + ", contentViewPadding=" + this.d + ", dimScreen=" + this.e + ", yShift=" + this.f + ", xShift=" + this.g + ", windowPadding=" + this.h + ", isMeasureContentForCompose=" + this.i + Separators.RPAREN;
    }

    public /* synthetic */ C7140Ql1(View view, ViewGroup viewGroup, Point point, RS4 rs4, boolean z, int i, int i2, int i3, boolean z2, int i4, ED1 ed1) {
        this(view, viewGroup, (i4 & 4) != 0 ? new Point(0, 0) : point, (i4 & 8) != 0 ? new RS4(0.0f, 0.0f, 0.0f, 0.0f) : rs4, (i4 & 16) != 0 ? false : z, (i4 & 32) != 0 ? 0 : i, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? 0 : i3, (i4 & 256) != 0 ? false : z2);
    }
}
