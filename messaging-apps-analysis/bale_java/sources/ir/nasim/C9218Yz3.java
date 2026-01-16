package ir.nasim;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Yz3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C9218Yz3 implements InterfaceC23384wp6 {
    private final BufferedReader a;

    /* renamed from: ir.nasim.Yz3$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private String a;
        private boolean b;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.a;
            this.a = null;
            AbstractC13042fc3.f(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.a == null && !this.b) {
                String line = C9218Yz3.this.a.readLine();
                this.a = line;
                if (line == null) {
                    this.b = true;
                }
            }
            return this.a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C9218Yz3(BufferedReader bufferedReader) {
        AbstractC13042fc3.i(bufferedReader, "reader");
        this.a = bufferedReader;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
