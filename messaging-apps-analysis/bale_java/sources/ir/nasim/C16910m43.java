package ir.nasim;

import java.util.Objects;

/* renamed from: ir.nasim.m43, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16910m43 extends AbstractC17902nl0 {
    private long a;
    private String b;

    public C16910m43(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C16910m43 c16910m43 = (C16910m43) obj;
        return this.a == c16910m43.a && Objects.equals(this.b, c16910m43.b);
    }

    public String getName() {
        return this.b;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.a), this.b);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
    }

    public long q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.o(2, this.b);
    }

    public C16910m43() {
    }
}
