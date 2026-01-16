package j$.util.stream;

import j$.util.function.C0095f;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class N1 extends O1<Double> implements C2.e {
    final /* synthetic */ P1 c;
    final /* synthetic */ j$.util.function.u d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    N1(P1 p1, j$.util.function.u uVar) {
        super(p1);
        this.c = p1;
        this.d = uVar;
    }

    @Override // j$.util.stream.O1, j$.util.stream.C2
    public void accept(double d) {
        if (this.a || ((j$.E) this.d).b(d) != this.c.b) {
            return;
        }
        this.a = true;
        this.b = this.c.c;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        S1.a(this, d);
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        sVar.getClass();
        return new C0095f(this, sVar);
    }
}
