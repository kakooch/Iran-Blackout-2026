package j$;

import j$.util.function.Consumer;
import j$.util.s;
import java.util.PrimitiveIterator;

/* renamed from: j$.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0056c implements s.b {
    final /* synthetic */ PrimitiveIterator.OfInt a;

    private /* synthetic */ C0056c(PrimitiveIterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ s.b a(PrimitiveIterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0058d ? ((C0058d) ofInt).a : new C0056c(ofInt);
    }

    @Override // j$.util.s.b
    /* renamed from: c */
    public /* synthetic */ void forEachRemaining(j$.util.function.y yVar) {
        this.a.forEachRemaining(S.a(yVar));
    }

    @Override // j$.util.s.b, j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C0207x.a(consumer));
    }

    @Override // j$.util.s
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfInt) obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // j$.util.s.b, java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Integer next() {
        return this.a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // j$.util.s.b
    public /* synthetic */ int nextInt() {
        return this.a.nextInt();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}
