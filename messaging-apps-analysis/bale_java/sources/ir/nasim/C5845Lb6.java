package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.Lb6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5845Lb6 {
    public static final a l = new a(null);
    private final int a;
    private final long b;
    private final long c;
    private final int d;
    private final int e;
    private final int f;
    private final long g;
    private final int h;
    private final long i;
    private final String j;
    private final byte[] k;

    /* renamed from: ir.nasim.Lb6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5845Lb6(int i, long j, long j2, int i2, int i3, int i4, long j3, int i5, long j4, String str, byte[] bArr) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = j3;
        this.h = i5;
        this.i = j4;
        this.j = str;
        this.k = bArr;
    }

    public final long a() {
        return this.c;
    }

    public final int b() {
        return this.h;
    }

    public final long c() {
        return this.b;
    }

    public final long d() {
        return this.g;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C5845Lb6.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.database.entity.SavedGifEntity");
        C5845Lb6 c5845Lb6 = (C5845Lb6) obj;
        return this.a == c5845Lb6.a && this.b == c5845Lb6.b;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.a;
    }

    public final String h() {
        return this.j;
    }

    public int hashCode() {
        return (this.a * 31) + Long.hashCode(this.b);
    }

    public final byte[] i() {
        return this.k;
    }

    public final long j() {
        return this.i;
    }

    public final int k() {
        return this.e;
    }

    public String toString() {
        return "SavedGifEntity(id=" + this.a + ", fileId=" + this.b + ", accessHash=" + this.c + ", fileStorageVersion=" + this.d + ", width=" + this.e + ", height=" + this.f + ", fileSize=" + this.g + ", duration=" + this.h + ", usedAt=" + this.i + ", mimeType=" + this.j + ", thumb=" + Arrays.toString(this.k) + Separators.RPAREN;
    }

    public /* synthetic */ C5845Lb6(int i, long j, long j2, int i2, int i3, int i4, long j3, int i5, long j4, String str, byte[] bArr, int i6, ED1 ed1) {
        this((i6 & 1) != 0 ? 0 : i, j, j2, i2, i3, i4, j3, i5, j4, (i6 & 512) != 0 ? null : str, (i6 & 1024) != 0 ? null : bArr);
    }
}
