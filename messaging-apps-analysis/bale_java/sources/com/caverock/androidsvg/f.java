package com.caverock.androidsvg;

import com.caverock.androidsvg.b;
import com.caverock.androidsvg.g;

/* loaded from: classes2.dex */
public class f {
    b.r a;
    e b;
    String c;
    g.C1991b d;
    String e;
    g.C1991b f;

    public f() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public f a(String str) {
        this.a = new b(b.u.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        b.r rVar = this.a;
        return rVar != null && rVar.f() > 0;
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public f h(float f, float f2, float f3, float f4) {
        this.f = new g.C1991b(f, f2, f3, f4);
        return this;
    }

    public f(f fVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        if (fVar == null) {
            return;
        }
        this.a = fVar.a;
        this.b = fVar.b;
        this.d = fVar.d;
        this.e = fVar.e;
        this.f = fVar.f;
    }
}
