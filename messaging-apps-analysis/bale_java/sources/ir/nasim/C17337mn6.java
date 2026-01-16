package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.tgwidgets.editor.messenger.MediaController;

/* renamed from: ir.nasim.mn6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17337mn6 {
    private final int a;
    private final String b;
    private final String c;
    private final boolean d;
    private final ir.nasim.tgwidgets.editor.messenger.H e;
    private final MediaController.l f;

    public C17337mn6(int i, String str, String str2, boolean z, ir.nasim.tgwidgets.editor.messenger.H h, MediaController.l lVar) {
        AbstractC13042fc3.i(str, "path");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = h;
        this.f = lVar;
    }

    public static /* synthetic */ C17337mn6 b(C17337mn6 c17337mn6, int i, String str, String str2, boolean z, ir.nasim.tgwidgets.editor.messenger.H h, MediaController.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c17337mn6.a;
        }
        if ((i2 & 2) != 0) {
            str = c17337mn6.b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = c17337mn6.c;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            z = c17337mn6.d;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            h = c17337mn6.e;
        }
        ir.nasim.tgwidgets.editor.messenger.H h2 = h;
        if ((i2 & 32) != 0) {
            lVar = c17337mn6.f;
        }
        return c17337mn6.a(i, str3, str4, z2, h2, lVar);
    }

    public final C17337mn6 a(int i, String str, String str2, boolean z, ir.nasim.tgwidgets.editor.messenger.H h, MediaController.l lVar) {
        AbstractC13042fc3.i(str, "path");
        return new C17337mn6(i, str, str2, z, h, lVar);
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final MediaController.l e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17337mn6)) {
            return false;
        }
        C17337mn6 c17337mn6 = (C17337mn6) obj;
        return this.a == c17337mn6.a && AbstractC13042fc3.d(this.b, c17337mn6.b) && AbstractC13042fc3.d(this.c, c17337mn6.c) && this.d == c17337mn6.d && AbstractC13042fc3.d(this.e, c17337mn6.e) && AbstractC13042fc3.d(this.f, c17337mn6.f);
    }

    public final String f() {
        return this.b;
    }

    public final ir.nasim.tgwidgets.editor.messenger.H g() {
        return this.e;
    }

    public final boolean h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31;
        ir.nasim.tgwidgets.editor.messenger.H h = this.e;
        int iHashCode3 = (iHashCode2 + (h == null ? 0 : h.hashCode())) * 31;
        MediaController.l lVar = this.f;
        return iHashCode3 + (lVar != null ? lVar.hashCode() : 0);
    }

    public String toString() {
        return "SelectedItem(id=" + this.a + ", path=" + this.b + ", caption=" + this.c + ", isVideo=" + this.d + ", videoEditedInfo=" + this.e + ", mediaEditState=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C17337mn6(int i, String str, String str2, boolean z, ir.nasim.tgwidgets.editor.messenger.H h, MediaController.l lVar, int i2, ED1 ed1) {
        this(i, str, str2, z, (i2 & 16) != 0 ? null : h, (i2 & 32) != 0 ? null : lVar);
    }
}
