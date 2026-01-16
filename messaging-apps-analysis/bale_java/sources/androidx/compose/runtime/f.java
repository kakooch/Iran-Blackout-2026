package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.j;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15299jL6;
import ir.nasim.AbstractC16481lL6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC23352wm4;
import ir.nasim.SG6;
import ir.nasim.UA2;
import ir.nasim.YG6;
import ir.nasim.ZG6;

/* loaded from: classes.dex */
public abstract class f extends AbstractC15299jL6 implements InterfaceC23352wm4, YG6 {
    private a b;

    private static final class a extends AbstractC16481lL6 {
        private long c;

        public a(long j, long j2) {
            super(j);
            this.c = j2;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public void c(AbstractC16481lL6 abstractC16481lL6) {
            AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
            this.c = ((a) abstractC16481lL6).c;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public AbstractC16481lL6 d(long j) {
            return new a(j, this.c);
        }

        public final long i() {
            return this.c;
        }

        public final void j(long j) {
            this.c = j;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(long j) {
            f.this.w(j);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).longValue());
            return C19938rB7.a;
        }
    }

    public f(long j) {
        androidx.compose.runtime.snapshots.g gVarI = j.I();
        a aVar = new a(gVarI.i(), j);
        if (!(gVarI instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.g(new a(SG6.c(1), j));
        }
        this.b = aVar;
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Long x() {
        return Long.valueOf(getLongValue());
    }

    @Override // ir.nasim.YG6
    public ZG6 c() {
        return AbstractC10222bH6.s();
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 f(AbstractC16481lL6 abstractC16481lL6, AbstractC16481lL6 abstractC16481lL62, AbstractC16481lL6 abstractC16481lL63) {
        AbstractC13042fc3.g(abstractC16481lL62, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        AbstractC13042fc3.g(abstractC16481lL63, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        if (((a) abstractC16481lL62).i() == ((a) abstractC16481lL63).i()) {
            return abstractC16481lL62;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC23352wm4, ir.nasim.InterfaceC23668xJ3
    public long getLongValue() {
        return ((a) j.X(this.b, this)).i();
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public void i(AbstractC16481lL6 abstractC16481lL6) {
        AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.b = (a) abstractC16481lL6;
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 j() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public UA2 o() {
        return new b();
    }

    public String toString() {
        return "MutableLongState(value=" + ((a) j.G(this.b)).i() + ")@" + hashCode();
    }

    @Override // ir.nasim.InterfaceC23352wm4
    public void w(long j) {
        androidx.compose.runtime.snapshots.g gVarC;
        a aVar = (a) j.G(this.b);
        if (aVar.i() != j) {
            a aVar2 = this.b;
            synchronized (j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                ((a) j.S(aVar2, this, gVarC, aVar)).j(j);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            j.Q(gVarC, this);
        }
    }
}
