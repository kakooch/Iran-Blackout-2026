package j$.util;

import j$.util.function.Function;
import j$.util.function.ToIntFunction;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: j$.util.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0105d implements Comparator, Serializable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                Function function = (Function) this.b;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
            case 1:
                j$.util.function.A a = (j$.util.function.A) this.b;
                return Double.compare(a.applyAsDouble(obj), a.applyAsDouble(obj2));
            case 2:
                ToIntFunction toIntFunction = (ToIntFunction) this.b;
                return j$.lang.d.c(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
            default:
                j$.util.function.B b = (j$.util.function.B) this.b;
                return (b.applyAsLong(obj) > b.applyAsLong(obj2) ? 1 : (b.applyAsLong(obj) == b.applyAsLong(obj2) ? 0 : -1));
        }
    }
}
