package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.f;
import ir.nasim.EnumC21012sz1;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC8666Wy1;
import ir.nasim.XI2;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
class s implements f, InterfaceC8666Wy1.a {
    private final f.a a;
    private final g b;
    private int c;
    private int d = -1;
    private InterfaceC14373ho3 e;
    private List f;
    private int g;
    private volatile InterfaceC13701gg4.a h;
    private File i;
    private t j;

    s(g gVar, f.a aVar) {
        this.b = gVar;
        this.a = aVar;
    }

    private boolean a() {
        return this.g < this.f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        XI2.a("ResourceCacheGenerator.startNext");
        try {
            List listC = this.b.c();
            boolean z = false;
            if (listC.isEmpty()) {
                XI2.e();
                return false;
            }
            List listM = this.b.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.b.r())) {
                    XI2.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.b.i() + " to " + this.b.r());
            }
            while (true) {
                if (this.f != null && a()) {
                    this.h = null;
                    while (!z && a()) {
                        List list = this.f;
                        int i = this.g;
                        this.g = i + 1;
                        this.h = ((InterfaceC13701gg4) list.get(i)).b(this.i, this.b.t(), this.b.f(), this.b.k());
                        if (this.h != null && this.b.u(this.h.c.a())) {
                            this.h.c.e(this.b.l(), this);
                            z = true;
                        }
                    }
                    XI2.e();
                    return z;
                }
                int i2 = this.d + 1;
                this.d = i2;
                if (i2 >= listM.size()) {
                    int i3 = this.c + 1;
                    this.c = i3;
                    if (i3 >= listC.size()) {
                        XI2.e();
                        return false;
                    }
                    this.d = 0;
                }
                InterfaceC14373ho3 interfaceC14373ho3 = (InterfaceC14373ho3) listC.get(this.c);
                Class cls = (Class) listM.get(this.d);
                this.j = new t(this.b.b(), interfaceC14373ho3, this.b.p(), this.b.t(), this.b.f(), this.b.s(cls), cls, this.b.k());
                File fileA = this.b.d().a(this.j);
                this.i = fileA;
                if (fileA != null) {
                    this.e = interfaceC14373ho3;
                    this.f = this.b.j(fileA);
                    this.g = 0;
                }
            }
        } catch (Throwable th) {
            XI2.e();
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC8666Wy1.a
    public void c(Exception exc) {
        this.a.a(this.j, exc, this.h.c, EnumC21012sz1.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        InterfaceC13701gg4.a aVar = this.h;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // ir.nasim.InterfaceC8666Wy1.a
    public void f(Object obj) {
        this.a.i(this.e, obj, this.h.c, EnumC21012sz1.RESOURCE_DISK_CACHE, this.j);
    }
}
