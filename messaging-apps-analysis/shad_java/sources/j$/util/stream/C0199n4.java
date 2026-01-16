package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: j$.util.stream.n4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0199n4 implements j$.util.t, Consumer {
    private static final Object d = new Object();
    private final j$.util.t a;
    private final ConcurrentHashMap b;
    private Object c;

    C0199n4(j$.util.t tVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = tVar;
        this.b = concurrentHashMap;
    }

    private C0199n4(j$.util.t tVar, ConcurrentHashMap concurrentHashMap) {
        this.a = tVar;
        this.b = concurrentHashMap;
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        while (this.a.a(this)) {
            ConcurrentHashMap concurrentHashMap = this.b;
            Object obj = this.c;
            if (obj == null) {
                obj = d;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.c);
                this.c = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.c = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.t
    public int characteristics() {
        return (this.a.characteristics() & (-16469)) | 1;
    }

    @Override // j$.util.t
    public long estimateSize() {
        return this.a.estimateSize();
    }

    public void f(Consumer consumer, Object obj) {
        if (this.b.putIfAbsent(obj != null ? obj : d, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(new C0200o(this, consumer));
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0102a.e(this);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }

    @Override // j$.util.t
    public j$.util.t trySplit() {
        j$.util.t tVarTrySplit = this.a.trySplit();
        if (tVarTrySplit != null) {
            return new C0199n4(tVarTrySplit, this.b);
        }
        return null;
    }
}
