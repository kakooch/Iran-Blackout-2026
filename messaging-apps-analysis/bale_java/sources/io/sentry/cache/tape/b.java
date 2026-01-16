package io.sentry.cache.tape;

import io.sentry.cache.tape.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class b extends c {
    private final d a;
    private final a b = new a();
    final c.a c;

    private static final class a extends ByteArrayOutputStream {
        a() {
        }

        byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    /* renamed from: io.sentry.cache.tape.b$b, reason: collision with other inner class name */
    private final class C0246b implements Iterator {
        final Iterator a;

        C0246b(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            try {
                return b.this.c.b((byte[]) this.a.next());
            } catch (IOException e) {
                throw ((Error) d.d0(e));
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    b(d dVar, c.a aVar) {
        this.a = dVar;
        this.c = aVar;
    }

    @Override // io.sentry.cache.tape.c
    public void clear() throws IOException {
        this.a.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // io.sentry.cache.tape.c
    public void f0(int i) throws IOException {
        this.a.N0(i);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new C0246b(this.a.iterator());
    }

    @Override // io.sentry.cache.tape.c
    public void j(Object obj) throws IOException {
        this.b.reset();
        this.c.a(obj, this.b);
        this.a.S(this.b.a(), 0, this.b.size());
    }

    @Override // io.sentry.cache.tape.c
    public int size() {
        return this.a.size();
    }

    public String toString() {
        return "FileObjectQueue{queueFile=" + this.a + '}';
    }
}
