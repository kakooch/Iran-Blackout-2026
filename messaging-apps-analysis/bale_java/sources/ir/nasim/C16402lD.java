package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.lD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16402lD extends AbstractC17902nl0 {
    private String a;
    private C6026Lw b;
    private C19784qw c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C6026Lw) c19084pl0.z(2, new C6026Lw());
        this.c = (C19784qw) c19084pl0.z(3, new C19784qw());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C6026Lw c6026Lw = this.b;
        if (c6026Lw != null) {
            c19675ql0.i(2, c6026Lw);
        }
        C19784qw c19784qw = this.c;
        if (c19784qw != null) {
            c19675ql0.i(3, c19784qw);
        }
    }

    public String toString() {
        return "struct UserCard{}";
    }
}
