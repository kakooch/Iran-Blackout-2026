package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0090a;

/* renamed from: j$.util.stream.k1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0144k1 implements BiConsumer {
    public static final /* synthetic */ C0144k1 a = new C0144k1();

    private /* synthetic */ C0144k1() {
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        biConsumer.getClass();
        return new C0090a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((j$.util.v) obj).a((CharSequence) obj2);
    }
}
