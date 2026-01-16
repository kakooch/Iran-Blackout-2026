package j$.util.function;

import java.util.Comparator;

/* renamed from: j$.util.function.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0108a implements InterfaceC0109b, y {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0108a(y yVar) {
        this.a = 2;
        this.b = yVar;
    }

    @Override // j$.util.function.y
    public y a(y yVar) {
        yVar.getClass();
        return new x(this, yVar, 1);
    }

    @Override // j$.util.function.BiFunction
    public BiFunction andThen(Function function) {
        switch (this.a) {
            case 0:
                function.getClass();
                break;
            default:
                function.getClass();
                break;
        }
        return new j$.util.concurrent.a(this, function);
    }

    @Override // j$.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                if (((Comparator) this.b).compare(obj, obj2) < 0) {
                    break;
                }
                break;
            default:
                if (((Comparator) this.b).compare(obj, obj2) > 0) {
                    break;
                }
                break;
        }
        return obj2;
    }

    @Override // j$.util.function.y
    public y b(y yVar) {
        yVar.getClass();
        return new x(this, yVar, 0);
    }

    @Override // j$.util.function.y
    public y negate() {
        return new C0108a(this);
    }

    @Override // j$.util.function.y
    public boolean test(Object obj) {
        return !((y) this.b).test(obj);
    }

    public /* synthetic */ C0108a(Comparator comparator, int i) {
        this.a = i;
        if (i != 1) {
            this.b = comparator;
        } else {
            this.b = comparator;
        }
    }
}
