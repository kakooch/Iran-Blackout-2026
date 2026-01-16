package j$.util.stream;

import j$.util.function.C0098i;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class L1 extends O1<Integer> implements C2.f {
    final /* synthetic */ P1 c;
    final /* synthetic */ j$.util.function.A d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    L1(P1 p1, j$.util.function.A a) {
        super(p1);
        this.c = p1;
        this.d = a;
    }

    @Override // j$.util.stream.O1, j$.util.stream.C2, j$.util.function.y
    public void accept(int i) {
        if (this.a || ((j$.V) this.d).b(i) != this.c.b) {
            return;
        }
        this.a = true;
        this.b = this.c.c;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        S1.b(this, num);
    }

    @Override // j$.util.function.y
    public j$.util.function.y k(j$.util.function.y yVar) {
        yVar.getClass();
        return new C0098i(this, yVar);
    }
}
