package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC15263jH6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9628aH6;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC19286q55;
import ir.nasim.TG6;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class a extends androidx.compose.runtime.snapshots.b {

    /* renamed from: androidx.compose.runtime.snapshots.a$a, reason: collision with other inner class name */
    static final class C0059a extends AbstractC8614Ws3 implements UA2 {
        public static final C0059a e = new C0059a();

        C0059a() {
            super(1);
        }

        public final void a(Object obj) {
            synchronized (j.J()) {
                try {
                    List list = j.j;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ((UA2) list.get(i)).invoke(obj);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, UA2 ua22) {
            super(1);
            this.e = ua2;
            this.f = ua22;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.runtime.snapshots.b invoke(i iVar) {
            long j;
            synchronized (j.J()) {
                j = j.f;
                j.f++;
            }
            return new androidx.compose.runtime.snapshots.b(j, iVar, this.e, this.f);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f invoke(i iVar) {
            long j;
            synchronized (j.J()) {
                j = j.f;
                j.f++;
            }
            return new f(j, iVar, this.e);
        }
    }

    public a(long j, i iVar) {
        super(j, iVar, null, C0059a.e);
    }

    @Override // androidx.compose.runtime.snapshots.b
    public h C() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    @Override // androidx.compose.runtime.snapshots.b
    public androidx.compose.runtime.snapshots.b R(UA2 ua2, UA2 ua22) {
        UA2 ua23;
        Map map;
        InterfaceC19286q55 interfaceC19286q55 = AbstractC9628aH6.a;
        if (interfaceC19286q55 != null) {
            XV4 xv4E = AbstractC9628aH6.e(interfaceC19286q55, null, false, ua2, ua22);
            TG6 tg6 = (TG6) xv4E.e();
            UA2 ua2A = tg6.a();
            UA2 ua2B = tg6.b();
            map = (Map) xv4E.f();
            ua2 = ua2A;
            ua23 = ua2B;
        } else {
            ua23 = ua22;
            map = null;
        }
        androidx.compose.runtime.snapshots.b bVar = (androidx.compose.runtime.snapshots.b) j.b0(new b(ua2, ua23));
        if (interfaceC19286q55 != null) {
            AbstractC9628aH6.b(interfaceC19286q55, null, bVar, map);
        }
        return bVar;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public Void m(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public Void n(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void d() {
        synchronized (j.J()) {
            q();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void o() {
        j.C();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public g x(UA2 ua2) {
        Map map;
        InterfaceC19286q55 interfaceC19286q55 = AbstractC9628aH6.a;
        if (interfaceC19286q55 != null) {
            XV4 xv4E = AbstractC9628aH6.e(interfaceC19286q55, null, true, ua2, null);
            TG6 tg6 = (TG6) xv4E.e();
            UA2 ua2A = tg6.a();
            tg6.b();
            map = (Map) xv4E.f();
            ua2 = ua2A;
        } else {
            map = null;
        }
        f fVar = (f) j.b0(new c(ua2));
        if (interfaceC19286q55 != null) {
            AbstractC9628aH6.b(interfaceC19286q55, null, fVar, map);
        }
        return fVar;
    }
}
