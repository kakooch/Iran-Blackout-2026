package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC15263jH6;
import ir.nasim.AbstractC9628aH6;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.InterfaceC19286q55;
import ir.nasim.TG6;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class d extends g {
    private final UA2 g;
    private final g h;

    public d(long j, i iVar, UA2 ua2, g gVar) {
        super(j, iVar, null);
        this.g = ua2;
        this.h = gVar;
        gVar.m(this);
    }

    public final g A() {
        return this.h;
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public UA2 g() {
        return this.g;
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Void m(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Void n(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public Void p(InterfaceC14710iL6 interfaceC14710iL6) {
        j.Z();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public d x(UA2 ua2) {
        Map map;
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
        d dVar = new d(i(), f(), j.L(ua2, g(), false, 4, null), A());
        if (interfaceC19286q55 != null) {
            AbstractC9628aH6.b(interfaceC19286q55, this, dVar, map);
        }
        return dVar;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void d() {
        if (e()) {
            return;
        }
        if (i() != this.h.i()) {
            b();
        }
        this.h.n(this);
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
    public void o() {
    }
}
