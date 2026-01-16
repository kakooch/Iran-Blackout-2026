package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class C extends D {

    static class a implements Map.Entry {
        public abstract C a();
    }

    static class b implements Iterator {
        private Iterator a;

        public b(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.a.next();
            entry.getValue();
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }
}
