package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.eZ1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12402eZ1 {
    public static final int e = FileReference.$stable;
    private final FileReference a;
    private final boolean b;
    private final boolean c;
    private final UA2 d;

    public C12402eZ1(FileReference fileReference, boolean z, boolean z2, UA2 ua2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(ua2, "downloadStateCallback");
        this.a = fileReference;
        this.b = z;
        this.c = z2;
        this.d = ua2;
    }

    public final UA2 a() {
        return this.d;
    }

    public final FileReference b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12402eZ1)) {
            return false;
        }
        C12402eZ1 c12402eZ1 = (C12402eZ1) obj;
        return AbstractC13042fc3.d(this.a, c12402eZ1.a) && this.b == c12402eZ1.b && this.c == c12402eZ1.c && AbstractC13042fc3.d(this.d, c12402eZ1.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DownloaderData(fileReference=" + this.a + ", supportsStream=" + this.b + ", reverse=" + this.c + ", downloadStateCallback=" + this.d + Separators.RPAREN;
    }
}
