package j$.util.stream;

import j$.C0071j0;
import j$.util.function.C0099j;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class M1 extends O1<Long> implements C2.g {
    final /* synthetic */ P1 c;
    final /* synthetic */ j$.util.function.G d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    M1(P1 p1, j$.util.function.G g) {
        super(p1);
        this.c = p1;
        this.d = g;
    }

    @Override // j$.util.stream.O1, j$.util.stream.C2
    public void accept(long j) {
        if (this.a || ((C0071j0) this.d).b(j) != this.c.b) {
            return;
        }
        this.a = true;
        this.b = this.c.c;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        S1.c(this, l);
    }

    @Override // j$.util.function.E
    public j$.util.function.E f(j$.util.function.E e) {
        e.getClass();
        return new C0099j(this, e);
    }
}
