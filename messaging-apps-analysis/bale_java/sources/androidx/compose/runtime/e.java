package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.j;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15299jL6;
import ir.nasim.AbstractC16481lL6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC17916nm4;
import ir.nasim.SG6;
import ir.nasim.UA2;
import ir.nasim.YG6;
import ir.nasim.ZG6;

/* loaded from: classes.dex */
public abstract class e extends AbstractC15299jL6 implements InterfaceC17916nm4, YG6 {
    private a b;

    private static final class a extends AbstractC16481lL6 {
        private int c;

        public a(long j, int i) {
            super(j);
            this.c = i;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public void c(AbstractC16481lL6 abstractC16481lL6) {
            AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
            this.c = ((a) abstractC16481lL6).c;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public AbstractC16481lL6 d(long j) {
            return new a(j, this.c);
        }

        public final int i() {
            return this.c;
        }

        public final void j(int i) {
            this.c = i;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(int i) {
            e.this.h(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return C19938rB7.a;
        }
    }

    public e(int i) {
        androidx.compose.runtime.snapshots.g gVarI = j.I();
        a aVar = new a(gVarI.i(), i);
        if (!(gVarI instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.g(new a(SG6.c(1), i));
        }
        this.b = aVar;
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Integer x() {
        return Integer.valueOf(d());
    }

    @Override // ir.nasim.YG6
    public ZG6 c() {
        return AbstractC10222bH6.s();
    }

    @Override // ir.nasim.InterfaceC17916nm4, ir.nasim.InterfaceC5365Ja3
    public int d() {
        return ((a) j.X(this.b, this)).i();
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 f(AbstractC16481lL6 abstractC16481lL6, AbstractC16481lL6 abstractC16481lL62, AbstractC16481lL6 abstractC16481lL63) {
        AbstractC13042fc3.g(abstractC16481lL62, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        AbstractC13042fc3.g(abstractC16481lL63, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        if (((a) abstractC16481lL62).i() == ((a) abstractC16481lL63).i()) {
            return abstractC16481lL62;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC17916nm4
    public void h(int i) {
        androidx.compose.runtime.snapshots.g gVarC;
        a aVar = (a) j.G(this.b);
        if (aVar.i() != i) {
            a aVar2 = this.b;
            synchronized (j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                ((a) j.S(aVar2, this, gVarC, aVar)).j(i);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            j.Q(gVarC, this);
        }
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public void i(AbstractC16481lL6 abstractC16481lL6) {
        AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
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
        return "MutableIntState(value=" + ((a) j.G(this.b)).i() + ")@" + hashCode();
    }
}
