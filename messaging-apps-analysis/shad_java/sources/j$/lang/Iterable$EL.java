package j$.lang;

import j$.util.AbstractC0102a;
import j$.util.DesugarCollections;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: j$.lang.Iterable$-EL, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class Iterable$EL {
    public static void forEach(Iterable iterable, Consumer consumer) {
        if (iterable instanceof e) {
            ((e) iterable).a(consumer);
            return;
        }
        if (iterable instanceof Collection) {
            AbstractC0102a.a((Collection) iterable, consumer);
            return;
        }
        if (DesugarCollections.a.isInstance(iterable)) {
            DesugarCollections.c(iterable, consumer);
            return;
        }
        consumer.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }
}
