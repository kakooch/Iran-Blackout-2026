package io.sentry.transport;

import io.sentry.C3134j2;
import io.sentry.I;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class s implements io.sentry.cache.g {
    private static final s a = new s();

    public static s f() {
        return a;
    }

    @Override // io.sentry.cache.g
    public void J(C3134j2 c3134j2) {
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return Collections.emptyIterator();
    }

    @Override // io.sentry.cache.g
    public boolean o1(C3134j2 c3134j2, I i) {
        return false;
    }
}
