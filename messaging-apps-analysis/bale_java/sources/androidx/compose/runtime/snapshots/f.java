package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC9628aH6;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.InterfaceC19286q55;
import ir.nasim.TG6;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class f extends g {
    private final UA2 g;
    private int h;

    public f(long j, i iVar, UA2 ua2) {
        super(j, iVar, null);
        this.g = ua2;
        this.h = 1;
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public UA2 g() {
        return this.g;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void d() {
        if (e()) {
            return;
        }
        n(this);
        super.d();
        AbstractC9628aH6.d(this);
    }

    @Override // androidx.compose.runtime.snapshots.g
    public boolean h() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public UA2 k() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void m(g gVar) {
        this.h++;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void n(g gVar) {
        int i = this.h - 1;
        this.h = i;
        if (i == 0) {
            b();
        }
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void o() {
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void p(InterfaceC14710iL6 interfaceC14710iL6) {
        j.Z();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public g x(UA2 ua2) {
        Map map;
        j.g0(this);
        InterfaceC19286q55 interfaceC19286q55 = AbstractC9628aH6.a;
        if (interfaceC19286q55 != null) {
            XV4 xv4E = AbstractC9628aH6.e(interfaceC19286q55, this, true, ua2, null);
            TG6 tg6 = (TG6) xv4E.e();
            UA2 ua2A = tg6.a();
            tg6.b();
            map = (Map) xv4E.f();
            ua2 = ua2A;
        } else {
            map = null;
        }
        d dVar = new d(i(), f(), j.L(ua2, g(), false, 4, null), this);
        if (interfaceC19286q55 != null) {
            AbstractC9628aH6.b(interfaceC19286q55, this, dVar, map);
        }
        return dVar;
    }
}
