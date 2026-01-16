package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.engine.f;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.EI3;
import ir.nasim.EnumC21012sz1;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC21989uU1;
import ir.nasim.InterfaceC8666Wy1;
import ir.nasim.Z72;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class v implements f, f.a {
    private final g a;
    private final f.a b;
    private volatile int c;
    private volatile c d;
    private volatile Object e;
    private volatile InterfaceC13701gg4.a f;
    private volatile d g;

    class a implements InterfaceC8666Wy1.a {
        final /* synthetic */ InterfaceC13701gg4.a a;

        a(InterfaceC13701gg4.a aVar) {
            this.a = aVar;
        }

        @Override // ir.nasim.InterfaceC8666Wy1.a
        public void c(Exception exc) {
            if (v.this.e(this.a)) {
                v.this.g(this.a, exc);
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1.a
        public void f(Object obj) {
            if (v.this.e(this.a)) {
                v.this.f(this.a, obj);
            }
        }
    }

    v(g gVar, f.a aVar) {
        this.a = gVar;
        this.b = aVar;
    }

    private boolean c(Object obj) throws Throwable {
        long jB = EI3.b();
        boolean z = false;
        try {
            com.bumptech.glide.load.data.a aVarO = this.a.o(obj);
            Object objC = aVarO.c();
            Z72 z72Q = this.a.q(objC);
            e eVar = new e(z72Q, objC, this.a.k());
            d dVar = new d(this.f.a, this.a.p());
            InterfaceC21989uU1 interfaceC21989uU1D = this.a.d();
            interfaceC21989uU1D.b(dVar, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + z72Q + ", duration: " + EI3.a(jB));
            }
            if (interfaceC21989uU1D.a(dVar) != null) {
                this.g = dVar;
                this.d = new c(Collections.singletonList(this.f.a), this.a, this);
                this.f.c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.b.i(this.f.a, aVarO.c(), this.f.c, this.f.c.d(), this.f.a);
                return false;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.f.c.b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean d() {
        return this.c < this.a.g().size();
    }

    private void h(InterfaceC13701gg4.a aVar) {
        this.f.c.e(this.a.l(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(InterfaceC14373ho3 interfaceC14373ho3, Exception exc, InterfaceC8666Wy1 interfaceC8666Wy1, EnumC21012sz1 enumC21012sz1) {
        this.b.a(interfaceC14373ho3, exc, interfaceC8666Wy1, this.f.c.d());
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        if (this.e != null) {
            Object obj = this.e;
            this.e = null;
            try {
                if (!c(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.d != null && this.d.b()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z && d()) {
            List listG = this.a.g();
            int i = this.c;
            this.c = i + 1;
            this.f = (InterfaceC13701gg4.a) listG.get(i);
            if (this.f != null && (this.a.e().c(this.f.c.d()) || this.a.u(this.f.c.a()))) {
                h(this.f);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        InterfaceC13701gg4.a aVar = this.f;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    boolean e(InterfaceC13701gg4.a aVar) {
        InterfaceC13701gg4.a aVar2 = this.f;
        return aVar2 != null && aVar2 == aVar;
    }

    void f(InterfaceC13701gg4.a aVar, Object obj) {
        AbstractC23175wU1 abstractC23175wU1E = this.a.e();
        if (obj != null && abstractC23175wU1E.c(aVar.c.d())) {
            this.e = obj;
            this.b.j();
        } else {
            f.a aVar2 = this.b;
            InterfaceC14373ho3 interfaceC14373ho3 = aVar.a;
            InterfaceC8666Wy1 interfaceC8666Wy1 = aVar.c;
            aVar2.i(interfaceC14373ho3, obj, interfaceC8666Wy1, interfaceC8666Wy1.d(), this.g);
        }
    }

    void g(InterfaceC13701gg4.a aVar, Exception exc) {
        f.a aVar2 = this.b;
        d dVar = this.g;
        InterfaceC8666Wy1 interfaceC8666Wy1 = aVar.c;
        aVar2.a(dVar, exc, interfaceC8666Wy1, interfaceC8666Wy1.d());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void i(InterfaceC14373ho3 interfaceC14373ho3, Object obj, InterfaceC8666Wy1 interfaceC8666Wy1, EnumC21012sz1 enumC21012sz1, InterfaceC14373ho3 interfaceC14373ho32) {
        this.b.i(interfaceC14373ho3, obj, interfaceC8666Wy1, this.f.c.d(), interfaceC14373ho3);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void j() {
        throw new UnsupportedOperationException();
    }
}
