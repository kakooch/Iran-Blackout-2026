package androidx.compose.foundation.lazy.layout;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.C4272Ek5;
import ir.nasim.InterfaceC23982xq4;
import ir.nasim.InterfaceC4989Hk5;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {
    private final InterfaceC4989Hk5 a;
    private final UA2 b;
    private final C4272Ek5 c = new C4272Ek5();
    private i d;

    private final class a implements InterfaceC23982xq4 {
        private final List a = new ArrayList();

        public a() {
        }

        @Override // ir.nasim.InterfaceC23982xq4
        public void a(int i) {
            c(i, e.a);
        }

        public final List b() {
            return this.a;
        }

        public void c(int i, long j) {
            i iVarC = d.this.c();
            if (iVarC == null) {
                return;
            }
            this.a.add(iVarC.c(i, j, d.this.c));
        }
    }

    public interface b {
        void a();

        void cancel();
    }

    public d(InterfaceC4989Hk5 interfaceC4989Hk5, UA2 ua2) {
        this.a = interfaceC4989Hk5;
        this.b = ua2;
    }

    public final List b() {
        UA2 ua2 = this.b;
        if (ua2 == null) {
            return AbstractC10360bX0.m();
        }
        a aVar = new a();
        ua2.invoke(aVar);
        return aVar.b();
    }

    public final i c() {
        return this.d;
    }

    public final InterfaceC4989Hk5 d() {
        return this.a;
    }

    public final b e(int i, long j) {
        b bVarD;
        i iVar = this.d;
        return (iVar == null || (bVarD = iVar.d(i, j, this.c)) == null) ? androidx.compose.foundation.lazy.layout.a.a : bVarD;
    }

    public final void f(i iVar) {
        this.d = iVar;
    }
}
