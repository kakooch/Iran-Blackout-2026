package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.f;
import ir.nasim.EnumC21012sz1;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC8666Wy1;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
class c implements f, InterfaceC8666Wy1.a {
    private final List a;
    private final g b;
    private final f.a c;
    private int d;
    private InterfaceC14373ho3 e;
    private List f;
    private int g;
    private volatile InterfaceC13701gg4.a h;
    private File i;

    c(g gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.g < this.f.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (a() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f;
        r3 = r7.g;
        r7.g = r3 + 1;
        r7.h = ((ir.nasim.InterfaceC13701gg4) r0.get(r3)).b(r7.i, r7.b.t(), r7.b.f(), r7.b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.h == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.b.u(r7.h.c.a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.h.c.e(r7.b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.h = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    @Override // com.bumptech.glide.load.engine.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            ir.nasim.XI2.a(r0)
        L5:
            java.util.List r0 = r7.f     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.h = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List r0 = r7.f     // Catch: java.lang.Throwable -> L68
            int r3 = r7.g     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.g = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            ir.nasim.gg4 r0 = (ir.nasim.InterfaceC13701gg4) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.i     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r4 = r7.b     // Catch: java.lang.Throwable -> L68
            int r4 = r4.t()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r5 = r7.b     // Catch: java.lang.Throwable -> L68
            int r5 = r5.f()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r6 = r7.b     // Catch: java.lang.Throwable -> L68
            ir.nasim.HL4 r6 = r6.k()     // Catch: java.lang.Throwable -> L68
            ir.nasim.gg4$a r0 = r0.b(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.h = r0     // Catch: java.lang.Throwable -> L68
            ir.nasim.gg4$a r0 = r7.h     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.g r0 = r7.b     // Catch: java.lang.Throwable -> L68
            ir.nasim.gg4$a r3 = r7.h     // Catch: java.lang.Throwable -> L68
            ir.nasim.Wy1 r3 = r3.c     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            ir.nasim.gg4$a r0 = r7.h     // Catch: java.lang.Throwable -> L68
            ir.nasim.Wy1 r0 = r0.c     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r2 = r7.b     // Catch: java.lang.Throwable -> L68
            ir.nasim.Mq5 r2 = r2.l()     // Catch: java.lang.Throwable -> L68
            r0.e(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r0 = move-exception
            goto Lb0
        L6a:
            ir.nasim.XI2.e()
            return r2
        L6e:
            int r0 = r7.d     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.d = r0     // Catch: java.lang.Throwable -> L68
            java.util.List r1 = r7.a     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            ir.nasim.XI2.e()
            return r2
        L7f:
            java.util.List r0 = r7.a     // Catch: java.lang.Throwable -> L68
            int r1 = r7.d     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            ir.nasim.ho3 r0 = (ir.nasim.InterfaceC14373ho3) r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d r1 = new com.bumptech.glide.load.engine.d     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r3 = r7.b     // Catch: java.lang.Throwable -> L68
            ir.nasim.ho3 r3 = r3.p()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r3 = r7.b     // Catch: java.lang.Throwable -> L68
            ir.nasim.uU1 r3 = r3.d()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L68
            r7.i = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.e = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.g r0 = r7.b     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.j(r1)     // Catch: java.lang.Throwable -> L68
            r7.f = r0     // Catch: java.lang.Throwable -> L68
            r7.g = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            ir.nasim.XI2.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.c.b():boolean");
    }

    @Override // ir.nasim.InterfaceC8666Wy1.a
    public void c(Exception exc) {
        this.c.a(this.e, exc, this.h.c, EnumC21012sz1.DATA_DISK_CACHE);
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
        this.c.i(this.e, obj, this.h.c, EnumC21012sz1.DATA_DISK_CACHE, this.e);
    }

    c(List list, g gVar, f.a aVar) {
        this.d = -1;
        this.a = list;
        this.b = gVar;
        this.c = aVar;
    }
}
