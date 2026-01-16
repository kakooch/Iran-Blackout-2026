package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.model.file.FileState;

/* loaded from: classes5.dex */
public final class XY1 {
    public static final a g = new a(null);
    private final long a;
    private final long b;
    private final String c;
    private final long d;
    private final String e;
    private final FileState f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public XY1(long j, long j2, String str, long j3, String str2, FileState fileState) {
        AbstractC13042fc3.i(str, "fileName");
        AbstractC13042fc3.i(str2, "filePath");
        AbstractC13042fc3.i(fileState, "fileState");
        this.a = j;
        this.b = j2;
        this.c = str;
        this.d = j3;
        this.e = str2;
        this.f = fileState;
    }

    public final XY1 a(long j, long j2, String str, long j3, String str2, FileState fileState) {
        AbstractC13042fc3.i(str, "fileName");
        AbstractC13042fc3.i(str2, "filePath");
        AbstractC13042fc3.i(fileState, "fileState");
        return new XY1(j, j2, str, j3, str2, fileState);
    }

    public final long c() {
        return this.b;
    }

    public final long d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XY1)) {
            return false;
        }
        XY1 xy1 = (XY1) obj;
        return this.a == xy1.a && this.b == xy1.b && AbstractC13042fc3.d(this.c, xy1.c) && this.d == xy1.d && AbstractC13042fc3.d(this.e, xy1.e) && AbstractC13042fc3.d(this.f, xy1.f);
    }

    public final String f() {
        return this.e;
    }

    public final long g() {
        return this.d;
    }

    public final FileState h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "DownloadStateEntity(fileId=" + this.a + ", accessHash=" + this.b + ", fileName=" + this.c + ", fileSize=" + this.d + ", filePath=" + this.e + ", fileState=" + this.f + Separators.RPAREN;
    }
}
