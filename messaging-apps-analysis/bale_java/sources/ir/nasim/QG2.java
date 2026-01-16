package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class QG2 {
    private final FileReference a;
    private final int b;
    private final int c;
    private final int d;
    private final long e;
    private String f;
    private String g;
    private byte[] h;

    public QG2(FileReference fileReference, int i, int i2, int i3, long j, String str, String str2, byte[] bArr) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        this.a = fileReference;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = str;
        this.g = str2;
        this.h = bArr;
    }

    public final String a() {
        return this.f;
    }

    public final int b() {
        return this.d;
    }

    public final FileReference c() {
        return this.a;
    }

    public final int d() {
        return this.c;
    }

    public final String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(QG2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.features.smiles.panel.gif.Gif");
        return this.a.getFileId() == ((QG2) obj).a.getFileId();
    }

    public final byte[] f() {
        return this.h;
    }

    public final int g() {
        return this.b;
    }

    public final void h(String str) {
        this.f = str;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final void i(String str) {
        this.g = str;
    }

    public final void j(byte[] bArr) {
        this.h = bArr;
    }

    public String toString() {
        return "Gif(fileReference=" + this.a + ", width=" + this.b + ", height=" + this.c + ", duration=" + this.d + ", usedAt=" + this.e + ", descriptor=" + this.f + ", mimeType=" + this.g + ", thumb=" + Arrays.toString(this.h) + Separators.RPAREN;
    }

    public /* synthetic */ QG2(FileReference fileReference, int i, int i2, int i3, long j, String str, String str2, byte[] bArr, int i4, ED1 ed1) {
        this(fileReference, i, i2, i3, j, (i4 & 32) != 0 ? null : str, (i4 & 64) != 0 ? null : str2, (i4 & 128) != 0 ? null : bArr);
    }
}
