package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
public final /* synthetic */ class C implements InterfaceC0109b {
    public final /* synthetic */ int a;
    public final /* synthetic */ BiConsumer b;

    public /* synthetic */ C(BiConsumer biConsumer, int i) {
        this.a = i;
        if (i == 1) {
            this.b = biConsumer;
        } else if (i != 2) {
            this.b = biConsumer;
        } else {
            this.b = biConsumer;
        }
    }

    @Override // j$.util.function.BiFunction
    public BiFunction andThen(Function function) {
        switch (this.a) {
            case 0:
                function.getClass();
                break;
            case 1:
                function.getClass();
                break;
            default:
                function.getClass();
                break;
        }
        return new j$.util.concurrent.a(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                this.b.accept(obj, obj2);
                break;
            case 1:
                this.b.accept(obj, obj2);
                break;
            default:
                this.b.accept(obj, obj2);
                break;
        }
        return obj;
    }
}
