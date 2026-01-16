package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.h;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.C23600xB7;
import ir.nasim.DW5;
import ir.nasim.EnumC6212Mq5;
import ir.nasim.HL4;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC15645jv7;
import ir.nasim.InterfaceC21989uU1;
import ir.nasim.KW5;
import ir.nasim.LJ;
import ir.nasim.Z72;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class g {
    private final List a = new ArrayList();
    private final List b = new ArrayList();
    private com.bumptech.glide.d c;
    private Object d;
    private int e;
    private int f;
    private Class g;
    private h.e h;
    private HL4 i;
    private Map j;
    private Class k;
    private boolean l;
    private boolean m;
    private InterfaceC14373ho3 n;
    private EnumC6212Mq5 o;
    private AbstractC23175wU1 p;
    private boolean q;
    private boolean r;

    g() {
    }

    void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    LJ b() {
        return this.c.b();
    }

    List c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                InterfaceC13701gg4.a aVar = (InterfaceC13701gg4.a) listG.get(i);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add((InterfaceC14373ho3) aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    InterfaceC21989uU1 d() {
        return this.h.a();
    }

    AbstractC23175wU1 e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List listI = this.c.i().i(this.d);
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                InterfaceC13701gg4.a aVarB = ((InterfaceC13701gg4) listI.get(i)).b(this.d, this.e, this.f, this.i);
                if (aVarB != null) {
                    this.a.add(aVarB);
                }
            }
        }
        return this.a;
    }

    q h(Class cls) {
        return this.c.i().h(cls, this.g, this.k);
    }

    Class i() {
        return this.d.getClass();
    }

    List j(File file) {
        return this.c.i().i(file);
    }

    HL4 k() {
        return this.i;
    }

    EnumC6212Mq5 l() {
        return this.o;
    }

    List m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }

    KW5 n(DW5 dw5) {
        return this.c.i().k(dw5);
    }

    com.bumptech.glide.load.data.a o(Object obj) {
        return this.c.i().l(obj);
    }

    InterfaceC14373ho3 p() {
        return this.n;
    }

    Z72 q(Object obj) {
        return this.c.i().m(obj);
    }

    Class r() {
        return this.k;
    }

    InterfaceC15645jv7 s(Class cls) {
        InterfaceC15645jv7 interfaceC15645jv7 = (InterfaceC15645jv7) this.j.get(cls);
        if (interfaceC15645jv7 == null) {
            Iterator it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    interfaceC15645jv7 = (InterfaceC15645jv7) entry.getValue();
                    break;
                }
            }
        }
        if (interfaceC15645jv7 != null) {
            return interfaceC15645jv7;
        }
        if (!this.j.isEmpty() || !this.q) {
            return C23600xB7.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int t() {
        return this.e;
    }

    boolean u(Class cls) {
        return h(cls) != null;
    }

    void v(com.bumptech.glide.d dVar, Object obj, InterfaceC14373ho3 interfaceC14373ho3, int i, int i2, AbstractC23175wU1 abstractC23175wU1, Class cls, Class cls2, EnumC6212Mq5 enumC6212Mq5, HL4 hl4, Map map, boolean z, boolean z2, h.e eVar) {
        this.c = dVar;
        this.d = obj;
        this.n = interfaceC14373ho3;
        this.e = i;
        this.f = i2;
        this.p = abstractC23175wU1;
        this.g = cls;
        this.h = eVar;
        this.k = cls2;
        this.o = enumC6212Mq5;
        this.i = hl4;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    boolean w(DW5 dw5) {
        return this.c.i().n(dw5);
    }

    boolean x() {
        return this.r;
    }

    boolean y(InterfaceC14373ho3 interfaceC14373ho3) {
        List listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (((InterfaceC13701gg4.a) listG.get(i)).a.equals(interfaceC14373ho3)) {
                return true;
            }
        }
        return false;
    }
}
