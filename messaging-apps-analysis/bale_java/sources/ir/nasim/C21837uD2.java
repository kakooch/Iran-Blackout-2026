package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import ir.nasim.tgwidgets.editor.messenger.MediaController;

/* renamed from: ir.nasim.uD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21837uD2 {
    private final int a;
    private final String b;
    private final Spannable c;
    private final Long d;
    private final Integer e;
    private final String f;
    private final int g;
    private final ir.nasim.tgwidgets.editor.messenger.H h;
    private final MediaController.l i;

    public C21837uD2(int i, String str, Spannable spannable, Long l, Integer num, String str2, int i2, ir.nasim.tgwidgets.editor.messenger.H h, MediaController.l lVar) {
        AbstractC13042fc3.i(str, "path");
        this.a = i;
        this.b = str;
        this.c = spannable;
        this.d = l;
        this.e = num;
        this.f = str2;
        this.g = i2;
        this.h = h;
        this.i = lVar;
    }

    public final String a() {
        return this.f;
    }

    public final Spannable b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final MediaController.l d() {
        return this.i;
    }

    public final int e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21837uD2)) {
            return false;
        }
        C21837uD2 c21837uD2 = (C21837uD2) obj;
        return this.a == c21837uD2.a && AbstractC13042fc3.d(this.b, c21837uD2.b) && AbstractC13042fc3.d(this.c, c21837uD2.c) && AbstractC13042fc3.d(this.d, c21837uD2.d) && AbstractC13042fc3.d(this.e, c21837uD2.e) && AbstractC13042fc3.d(this.f, c21837uD2.f) && this.g == c21837uD2.g && AbstractC13042fc3.d(this.h, c21837uD2.h) && AbstractC13042fc3.d(this.i, c21837uD2.i);
    }

    public final String f() {
        return this.b;
    }

    public final Integer g() {
        return this.e;
    }

    public final Long h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Spannable spannable = this.c;
        int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
        Long l = this.d;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f;
        int iHashCode5 = (((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.g)) * 31;
        ir.nasim.tgwidgets.editor.messenger.H h = this.h;
        int iHashCode6 = (iHashCode5 + (h == null ? 0 : h.hashCode())) * 31;
        MediaController.l lVar = this.i;
        return iHashCode6 + (lVar != null ? lVar.hashCode() : 0);
    }

    public final ir.nasim.tgwidgets.editor.messenger.H i() {
        return this.h;
    }

    public String toString() {
        int i = this.a;
        String str = this.b;
        Spannable spannable = this.c;
        return "GalleryUIItem(id=" + i + ", path=" + str + ", duration=" + ((Object) spannable) + ", thumbnailFrameNumber=" + this.d + ", selectedIndex=" + this.e + ", caption=" + this.f + ", orientation=" + this.g + ", videoEditedInfo=" + this.h + ", mediaEditState=" + this.i + Separators.RPAREN;
    }

    public /* synthetic */ C21837uD2(int i, String str, Spannable spannable, Long l, Integer num, String str2, int i2, ir.nasim.tgwidgets.editor.messenger.H h, MediaController.l lVar, int i3, ED1 ed1) {
        this(i, str, spannable, l, num, str2, i2, (i3 & 128) != 0 ? null : h, (i3 & 256) != 0 ? null : lVar);
    }
}
