package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.j;
import ir.nasim.AbstractC13438gE;
import ir.nasim.C12361eU5;
import ir.nasim.C13697gg0;
import ir.nasim.C14096hL3;
import ir.nasim.C14698iL3;
import ir.nasim.C19433qL3;
import ir.nasim.C20107rU5;
import ir.nasim.C4189Eb3;
import ir.nasim.DD1;
import ir.nasim.InterfaceC13106fg0;
import ir.nasim.InterfaceC21989uU1;
import ir.nasim.InterfaceC4688Gd1;
import ir.nasim.K34;
import ir.nasim.KJ;
import ir.nasim.LJ;
import ir.nasim.PI2;
import ir.nasim.U34;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {
    private j c;
    private InterfaceC13106fg0 d;
    private LJ e;
    private K34 f;
    private PI2 g;
    private PI2 h;
    private InterfaceC21989uU1.a i;
    private U34 j;
    private InterfaceC4688Gd1 k;
    private C12361eU5.b n;
    private PI2 o;
    private boolean p;
    private List q;
    private final Map a = new KJ();
    private final e.a b = new e.a();
    private int l = 4;
    private b.a m = new a();

    class a implements b.a {
        a() {
        }

        @Override // com.bumptech.glide.b.a
        public C20107rU5 a() {
            return new C20107rU5();
        }
    }

    static final class b {
    }

    /* renamed from: com.bumptech.glide.c$c, reason: collision with other inner class name */
    public static final class C0144c {
    }

    com.bumptech.glide.b a(Context context, List list, AbstractC13438gE abstractC13438gE) {
        if (this.g == null) {
            this.g = PI2.h();
        }
        if (this.h == null) {
            this.h = PI2.f();
        }
        if (this.o == null) {
            this.o = PI2.d();
        }
        if (this.j == null) {
            this.j = new U34.a(context).a();
        }
        if (this.k == null) {
            this.k = new DD1();
        }
        if (this.d == null) {
            int iB = this.j.b();
            if (iB > 0) {
                this.d = new C14698iL3(iB);
            } else {
                this.d = new C13697gg0();
            }
        }
        if (this.e == null) {
            this.e = new C14096hL3(this.j.a());
        }
        if (this.f == null) {
            this.f = new C19433qL3(this.j.d());
        }
        if (this.i == null) {
            this.i = new C4189Eb3(context);
        }
        if (this.c == null) {
            this.c = new j(this.f, this.i, this.h, this.g, PI2.i(), this.o, this.p);
        }
        List list2 = this.q;
        if (list2 == null) {
            this.q = Collections.emptyList();
        } else {
            this.q = Collections.unmodifiableList(list2);
        }
        return new com.bumptech.glide.b(context, this.c, this.f, this.d, this.e, new C12361eU5(this.n), this.k, this.l, this.m, this.a, this.q, list, abstractC13438gE, this.b.b());
    }

    void b(C12361eU5.b bVar) {
        this.n = bVar;
    }
}
