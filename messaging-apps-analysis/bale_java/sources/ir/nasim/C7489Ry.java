package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Ry, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7489Ry extends AbstractC17902nl0 {
    private C12056dy a;
    private int b;
    private String c;
    private String d;
    private AbstractC21697tz e;

    public C7489Ry(C12056dy c12056dy, int i, String str, String str2, AbstractC21697tz abstractC21697tz) {
        this.a = c12056dy;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = abstractC21697tz;
    }

    public C12056dy getFileLocation() {
        return this.a;
    }

    public String getFileName() {
        return this.d;
    }

    public int getFileSize() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C12056dy) c19084pl0.z(1, new C12056dy());
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        if (c19084pl0.v(5) != null) {
            this.e = AbstractC21697tz.r(c19084pl0.d(5));
        }
    }

    public AbstractC21697tz q() {
        return this.e;
    }

    public String r() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C12056dy c12056dy = this.a;
        if (c12056dy != null) {
            c19675ql0.i(1, c12056dy);
        }
        c19675ql0.f(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        String str2 = this.d;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str2);
        AbstractC21697tz abstractC21697tz = this.e;
        if (abstractC21697tz != null) {
            c19675ql0.b(5, abstractC21697tz.q());
        }
    }

    public String toString() {
        return "struct IntroMedia{}";
    }

    public C7489Ry() {
    }
}
