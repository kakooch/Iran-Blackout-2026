package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.mP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17103mP1 {
    private final FileReference a;
    private InterfaceC24823zG1 b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final long g;
    private final int h;
    private final int i;
    private final String j;
    private InterfaceC24823zG1 k;

    public C17103mP1(FileReference fileReference, InterfaceC24823zG1 interfaceC24823zG1, String str, String str2, String str3, String str4, long j, int i, int i2, String str5, InterfaceC24823zG1 interfaceC24823zG12) {
        AbstractC13042fc3.i(fileReference, "imageFileReference");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "link");
        AbstractC13042fc3.i(str4, "id");
        AbstractC13042fc3.i(str5, "linkTitle");
        this.a = fileReference;
        this.b = interfaceC24823zG1;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = j;
        this.h = i;
        this.i = i2;
        this.j = str5;
        this.k = interfaceC24823zG12;
    }

    public final String a() {
        return this.d;
    }

    public final String b() {
        return this.f;
    }

    public final InterfaceC24823zG1 c() {
        return this.b;
    }

    public final FileReference d() {
        return this.a;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17103mP1)) {
            return false;
        }
        C17103mP1 c17103mP1 = (C17103mP1) obj;
        return AbstractC13042fc3.d(this.a, c17103mP1.a) && AbstractC13042fc3.d(this.b, c17103mP1.b) && AbstractC13042fc3.d(this.c, c17103mP1.c) && AbstractC13042fc3.d(this.d, c17103mP1.d) && AbstractC13042fc3.d(this.e, c17103mP1.e) && AbstractC13042fc3.d(this.f, c17103mP1.f) && this.g == c17103mP1.g && this.h == c17103mP1.h && this.i == c17103mP1.i && AbstractC13042fc3.d(this.j, c17103mP1.j) && AbstractC13042fc3.d(this.k, c17103mP1.k);
    }

    public final InterfaceC24823zG1 f() {
        return this.k;
    }

    public final String g() {
        return this.j;
    }

    public final int h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        InterfaceC24823zG1 interfaceC24823zG1 = this.b;
        int iHashCode2 = (((((((((((((((((iHashCode + (interfaceC24823zG1 == null ? 0 : interfaceC24823zG1.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + this.j.hashCode()) * 31;
        InterfaceC24823zG1 interfaceC24823zG12 = this.k;
        return iHashCode2 + (interfaceC24823zG12 != null ? interfaceC24823zG12.hashCode() : 0);
    }

    public final int i() {
        return this.i;
    }

    public final String j() {
        return this.c;
    }

    public final void k(InterfaceC24823zG1 interfaceC24823zG1) {
        this.b = interfaceC24823zG1;
    }

    public final void l(InterfaceC24823zG1 interfaceC24823zG1) {
        this.k = interfaceC24823zG1;
    }

    public String toString() {
        return "DialogPinAd(imageFileReference=" + this.a + ", imageDrawable=" + this.b + ", title=" + this.c + ", description=" + this.d + ", link=" + this.e + ", id=" + this.f + ", accessHash=" + this.g + ", tag1=" + this.h + ", tag2=" + this.i + ", linkTitle=" + this.j + ", linkAction=" + this.k + Separators.RPAREN;
    }

    public /* synthetic */ C17103mP1(FileReference fileReference, InterfaceC24823zG1 interfaceC24823zG1, String str, String str2, String str3, String str4, long j, int i, int i2, String str5, InterfaceC24823zG1 interfaceC24823zG12, int i3, ED1 ed1) {
        this(fileReference, (i3 & 2) != 0 ? null : interfaceC24823zG1, str, str2, str3, str4, j, i, i2, str5, (i3 & 1024) != 0 ? null : interfaceC24823zG12);
    }
}
