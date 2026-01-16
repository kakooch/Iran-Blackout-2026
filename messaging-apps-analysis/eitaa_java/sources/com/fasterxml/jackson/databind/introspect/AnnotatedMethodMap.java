package com.fasterxml.jackson.databind.introspect;

import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class AnnotatedMethodMap implements Iterable<AnnotatedMethod>, Iterable {
    protected Map<MemberKey, AnnotatedMethod> _methods;

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return u.o(iterator(), 0);
    }

    public AnnotatedMethodMap() {
    }

    public AnnotatedMethodMap(Map<MemberKey, AnnotatedMethod> map) {
        this._methods = map;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public Iterator<AnnotatedMethod> iterator() {
        Map<MemberKey, AnnotatedMethod> map = this._methods;
        if (map == null) {
            return Collections.emptyList().iterator();
        }
        return map.values().iterator();
    }
}
