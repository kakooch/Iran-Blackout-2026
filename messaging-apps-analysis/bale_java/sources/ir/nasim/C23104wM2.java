package ir.nasim;

import java.io.Serializable;
import java.util.Objects;

/* renamed from: ir.nasim.wM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23104wM2 implements Serializable {
    private C21231tK7 a;
    private final int b;
    private final int c;
    private final long d;
    private final boolean e;
    private final Integer f;
    private C24119y45 g;
    private String h;

    public C23104wM2(int i, int i2, long j, boolean z, Integer num, String str) {
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = z;
        this.f = num;
        this.h = str;
    }

    public long a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public C24119y45 c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public Integer e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23104wM2)) {
            return false;
        }
        C23104wM2 c23104wM2 = (C23104wM2) obj;
        return this.b == c23104wM2.b && this.c == c23104wM2.c && this.d == c23104wM2.d && this.e == c23104wM2.e && Objects.equals(this.h, c23104wM2.h);
    }

    public int f() {
        return this.b;
    }

    public C21231tK7 g() {
        return this.a;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Integer.valueOf(this.c), Long.valueOf(this.d), Boolean.valueOf(this.e), this.h);
    }

    public boolean j() {
        return this.e;
    }

    public void k(C24119y45 c24119y45) {
        this.g = c24119y45;
    }

    public void l(C21231tK7 c21231tK7) {
        this.a = c21231tK7;
    }
}
