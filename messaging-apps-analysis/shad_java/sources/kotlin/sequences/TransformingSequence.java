package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class TransformingSequence<T, R> implements Sequence<R> {
    private final Sequence<T> sequence;
    private final Function1<T, R> transformer;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.sequence = sequence;
        this.transformer = transformer;
    }

    /* compiled from: Sequences.kt */
    /* renamed from: kotlin.sequences.TransformingSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<R>, j$.util.Iterator {
        private final Iterator<T> iterator;
        final /* synthetic */ TransformingSequence<T, R> this$0;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(TransformingSequence<T, R> transformingSequence) {
            this.this$0 = transformingSequence;
            this.iterator = ((TransformingSequence) transformingSequence).sequence.iterator();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public R next() {
            return (R) ((TransformingSequence) this.this$0).transformer.invoke(this.iterator.next());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

    @Override // kotlin.sequences.Sequence
    public java.util.Iterator<R> iterator() {
        return new AnonymousClass1(this);
    }
}
