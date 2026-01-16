package j$.util.function;

/* renamed from: j$.util.function.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0090a implements BiConsumer {
    public final /* synthetic */ BiConsumer a;
    public final /* synthetic */ BiConsumer b;

    public /* synthetic */ C0090a(BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.a = biConsumer;
        this.b = biConsumer2;
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        biConsumer.getClass();
        return new C0090a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        BiConsumer biConsumer = this.a;
        BiConsumer biConsumer2 = this.b;
        biConsumer.accept(obj, obj2);
        biConsumer2.accept(obj, obj2);
    }
}
