package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15299jL6;
import ir.nasim.AbstractC16481lL6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.SG6;
import ir.nasim.UA2;
import ir.nasim.YG6;
import ir.nasim.ZG6;

/* loaded from: classes.dex */
public abstract class g extends AbstractC15299jL6 implements YG6 {
    private final ZG6 b;
    private a c;

    private static final class a extends AbstractC16481lL6 {
        private Object c;

        public a(long j, Object obj) {
            super(j);
            this.c = obj;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public void c(AbstractC16481lL6 abstractC16481lL6) {
            AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.c = ((a) abstractC16481lL6).c;
        }

        @Override // ir.nasim.AbstractC16481lL6
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a d(long j) {
            return new a(j.I().i(), this.c);
        }

        public final Object j() {
            return this.c;
        }

        public final void k(Object obj) {
            this.c = obj;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(Object obj) {
            g.this.setValue(obj);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    public g(Object obj, ZG6 zg6) {
        this.b = zg6;
        androidx.compose.runtime.snapshots.g gVarI = j.I();
        a aVar = new a(gVarI.i(), obj);
        if (!(gVarI instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.g(new a(SG6.c(1), obj));
        }
        this.c = aVar;
    }

    @Override // ir.nasim.YG6
    public ZG6 c() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 f(AbstractC16481lL6 abstractC16481lL6, AbstractC16481lL6 abstractC16481lL62, AbstractC16481lL6 abstractC16481lL63) {
        AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar = (a) abstractC16481lL6;
        AbstractC13042fc3.g(abstractC16481lL62, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar2 = (a) abstractC16481lL62;
        AbstractC13042fc3.g(abstractC16481lL63, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar3 = (a) abstractC16481lL63;
        if (c().b(aVar2.j(), aVar3.j())) {
            return abstractC16481lL62;
        }
        Object objA = c().a(aVar.j(), aVar2.j(), aVar3.j());
        if (objA == null) {
            return null;
        }
        a aVarD = aVar3.d(aVar3.f());
        aVarD.k(objA);
        return aVarD;
    }

    @Override // ir.nasim.InterfaceC9102Ym4, ir.nasim.InterfaceC9664aL6
    public Object getValue() {
        return ((a) j.X(this.c, this)).j();
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public void i(AbstractC16481lL6 abstractC16481lL6) {
        AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.c = (a) abstractC16481lL6;
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 j() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public UA2 o() {
        return new b();
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public void setValue(Object obj) {
        androidx.compose.runtime.snapshots.g gVarC;
        a aVar = (a) j.G(this.c);
        if (c().b(aVar.j(), obj)) {
            return;
        }
        a aVar2 = this.c;
        synchronized (j.J()) {
            gVarC = androidx.compose.runtime.snapshots.g.e.c();
            ((a) j.S(aVar2, this, gVarC, aVar)).k(obj);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        j.Q(gVarC, this);
    }

    public String toString() {
        return "MutableState(value=" + ((a) j.G(this.c)).j() + ")@" + hashCode();
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public Object x() {
        return getValue();
    }
}
