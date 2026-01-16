package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.l4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0187l4 extends AbstractC0193m4 implements Consumer {
    final Object[] b;

    C0187l4(int i) {
        this.b = new Object[i];
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        Object[] objArr = this.b;
        int i = this.a;
        this.a = i + 1;
        objArr[i] = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
