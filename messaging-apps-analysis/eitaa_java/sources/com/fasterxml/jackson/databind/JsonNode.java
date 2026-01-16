package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.ClassUtil;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.u;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class JsonNode extends JsonSerializable.Base implements Iterable<JsonNode>, Iterable {
    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return u.o(iterator(), 0);
    }

    protected JsonNode() {
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public final Iterator<JsonNode> iterator() {
        return elements();
    }

    public Iterator<JsonNode> elements() {
        return ClassUtil.emptyIterator();
    }
}
