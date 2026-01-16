package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class a3<T> implements Spliterator<T>, Consumer<T> {
    private static final Object a = new Object();
    private final Spliterator b;
    private final ConcurrentHashMap c;
    private Object d;

    a3(Spliterator spliterator) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = spliterator;
        this.c = concurrentHashMap;
    }

    private a3(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.b = spliterator;
        this.c = concurrentHashMap;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.d = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public boolean b(Consumer consumer) {
        while (this.b.b(this)) {
            ConcurrentHashMap concurrentHashMap = this.c;
            Object obj = this.d;
            if (obj == null) {
                obj = a;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.d);
                this.d = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public int characteristics() {
        return (this.b.characteristics() & (-16469)) | 1;
    }

    @Override // j$.util.Spliterator
    public long estimateSize() {
        return this.b.estimateSize();
    }

    public void f(Consumer consumer, Object obj) {
        if (this.c.putIfAbsent(obj != null ? obj : a, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(final Consumer consumer) {
        this.b.forEachRemaining(new Consumer() { // from class: j$.util.stream.z0
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                this.a.f(consumer, obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer.CC.$default$andThen(this, consumer2);
            }
        });
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        return this.b.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return j$.time.a.g(this);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.time.a.h(this, i);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.b.trySplit();
        if (spliteratorTrySplit != null) {
            return new a3(spliteratorTrySplit, this.c);
        }
        return null;
    }
}
