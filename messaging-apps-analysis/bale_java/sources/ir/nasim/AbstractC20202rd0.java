package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.rd0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20202rd0 implements InterfaceC12511ek1, Iterator, Closeable {
    private static final InterfaceC4984Hk0 f = new a("eof ");
    private static MI3 g = MI3.a(AbstractC20202rd0.class);
    InterfaceC4984Hk0 a = null;
    long b = 0;
    long c = 0;
    long d = 0;
    private List e = new ArrayList();

    public void a(InterfaceC4984Hk0 interfaceC4984Hk0) {
        if (interfaceC4984Hk0 != null) {
            this.e = new ArrayList(b());
            interfaceC4984Hk0.k(this);
            this.e.add(interfaceC4984Hk0);
        }
    }

    public List b() {
        return this.e;
    }

    protected long c() {
        long jF = 0;
        for (int i = 0; i < b().size(); i++) {
            jF += ((InterfaceC4984Hk0) this.e.get(i)).f();
        }
        return jF;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw null;
    }

    @Override // java.util.Iterator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC4984Hk0 next() {
        InterfaceC4984Hk0 interfaceC4984Hk0 = this.a;
        if (interfaceC4984Hk0 == null || interfaceC4984Hk0 == f) {
            this.a = f;
            throw new NoSuchElementException();
        }
        this.a = null;
        return interfaceC4984Hk0;
    }

    public final void e(WritableByteChannel writableByteChannel) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            ((InterfaceC4984Hk0) it.next()).g(writableByteChannel);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        InterfaceC4984Hk0 interfaceC4984Hk0 = this.a;
        if (interfaceC4984Hk0 == f) {
            return false;
        }
        if (interfaceC4984Hk0 != null) {
            return true;
        }
        try {
            this.a = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.a = f;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.e.size(); i++) {
            if (i > 0) {
                sb.append(Separators.SEMICOLON);
            }
            sb.append(((InterfaceC4984Hk0) this.e.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: ir.nasim.rd0$a */
    class a extends D0 {
        a(String str) {
            super(str);
        }

        @Override // ir.nasim.D0
        protected long c() {
            return 0L;
        }

        @Override // ir.nasim.D0
        protected void a(ByteBuffer byteBuffer) {
        }

        @Override // ir.nasim.D0
        protected void b(ByteBuffer byteBuffer) {
        }
    }
}
