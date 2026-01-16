package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.op0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18533op0 implements Comparable {
    public final String a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;

    public AbstractC18533op0(String str, long j, long j2, long j3, File file) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC18533op0 abstractC18533op0) {
        if (!this.a.equals(abstractC18533op0.a)) {
            return this.a.compareTo(abstractC18533op0.a);
        }
        long j = this.b - abstractC18533op0.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean h() {
        return !this.d;
    }

    public boolean i() {
        return this.c == -1;
    }

    public String toString() {
        return "[" + this.b + ", " + this.c + "]";
    }
}
