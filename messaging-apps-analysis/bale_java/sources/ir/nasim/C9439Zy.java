package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Zy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9439Zy extends AbstractC17902nl0 {
    private String a;
    private Boolean b;
    private Boolean c;
    private Boolean d;
    private C11422cz e;
    private C10658bz f;
    private C10042az g;
    private C23610xD h;
    private C18611ox i;

    public C9439Zy(String str, Boolean bool, Boolean bool2, Boolean bool3, C11422cz c11422cz, C10658bz c10658bz, C10042az c10042az, C23610xD c23610xD, C18611ox c18611ox) {
        this.a = str;
        this.b = bool;
        this.c = bool2;
        this.d = bool3;
        this.e = c11422cz;
        this.f = c10658bz;
        this.g = c10042az;
        this.h = c23610xD;
        this.i = c18611ox;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = Boolean.valueOf(c19084pl0.u(2));
        this.c = Boolean.valueOf(c19084pl0.u(3));
        this.d = Boolean.valueOf(c19084pl0.u(9));
        this.e = (C11422cz) c19084pl0.z(4, new C11422cz());
        this.f = (C10658bz) c19084pl0.z(5, new C10658bz());
        this.g = (C10042az) c19084pl0.z(6, new C10042az());
        this.h = (C23610xD) c19084pl0.z(7, new C23610xD());
        this.i = (C18611ox) c19084pl0.z(8, new C18611ox());
    }

    public C18611ox q() {
        return this.i;
    }

    public String r() {
        return this.a;
    }

    public C23610xD s() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        Boolean bool = this.b;
        if (bool != null) {
            c19675ql0.a(2, bool.booleanValue());
        }
        Boolean bool2 = this.c;
        if (bool2 != null) {
            c19675ql0.a(3, bool2.booleanValue());
        }
        Boolean bool3 = this.d;
        if (bool3 != null) {
            c19675ql0.a(9, bool3.booleanValue());
        }
        C11422cz c11422cz = this.e;
        if (c11422cz != null) {
            c19675ql0.i(4, c11422cz);
        }
        C10658bz c10658bz = this.f;
        if (c10658bz != null) {
            c19675ql0.i(5, c10658bz);
        }
        C10042az c10042az = this.g;
        if (c10042az != null) {
            c19675ql0.i(6, c10042az);
        }
        C23610xD c23610xD = this.h;
        if (c23610xD != null) {
            c19675ql0.i(7, c23610xD);
        }
        C18611ox c18611ox = this.i;
        if (c18611ox != null) {
            c19675ql0.i(8, c18611ox);
        }
    }

    public String toString() {
        return "struct KeyboardButton{}";
    }

    public Boolean u() {
        return this.b;
    }

    public Boolean w() {
        return this.c;
    }

    public Boolean y() {
        return this.d;
    }

    public C9439Zy() {
    }
}
