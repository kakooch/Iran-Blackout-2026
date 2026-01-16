package ir.nasim;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.ql3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19678ql3 extends C22155ul3 {
    private static final Writer p = new a();
    private static final C9906al3 q = new C9906al3("closed");
    private final List m;
    private String n;
    private AbstractC22735vk3 o;

    /* renamed from: ir.nasim.ql3$a */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public C19678ql3() {
        super(p);
        this.m = new ArrayList();
        this.o = C8074Uk3.a;
    }

    private AbstractC22735vk3 f0() {
        return (AbstractC22735vk3) this.m.get(r0.size() - 1);
    }

    private void k0(AbstractC22735vk3 abstractC22735vk3) {
        if (this.n != null) {
            if (!abstractC22735vk3.x() || k()) {
                ((C8542Wk3) f0()).C(this.n, abstractC22735vk3);
            }
            this.n = null;
            return;
        }
        if (this.m.isEmpty()) {
            this.o = abstractC22735vk3;
            return;
        }
        AbstractC22735vk3 abstractC22735vk3F0 = f0();
        if (!(abstractC22735vk3F0 instanceof C13149fk3)) {
            throw new IllegalStateException();
        }
        ((C13149fk3) abstractC22735vk3F0).C(abstractC22735vk3);
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 P(double d) {
        if (m() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            k0(new C9906al3(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 S(long j) {
        k0(new C9906al3(Long.valueOf(j)));
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 T(Boolean bool) {
        if (bool == null) {
            return s();
        }
        k0(new C9906al3(bool));
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 U(Number number) {
        if (number == null) {
            return s();
        }
        if (!m()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        k0(new C9906al3(number));
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 X(String str) {
        if (str == null) {
            return s();
        }
        k0(new C9906al3(str));
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 Z(boolean z) {
        k0(new C9906al3(Boolean.valueOf(z)));
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 c() {
        C13149fk3 c13149fk3 = new C13149fk3();
        k0(c13149fk3);
        this.m.add(c13149fk3);
        return this;
    }

    @Override // ir.nasim.C22155ul3, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.m.add(q);
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 d() {
        C8542Wk3 c8542Wk3 = new C8542Wk3();
        k0(c8542Wk3);
        this.m.add(c8542Wk3);
        return this;
    }

    public AbstractC22735vk3 e0() {
        if (this.m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.m);
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 g() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(f0() instanceof C13149fk3)) {
            throw new IllegalStateException();
        }
        this.m.remove(r0.size() - 1);
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 j() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(f0() instanceof C8542Wk3)) {
            throw new IllegalStateException();
        }
        this.m.remove(r0.size() - 1);
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 p(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(f0() instanceof C8542Wk3)) {
            throw new IllegalStateException();
        }
        this.n = str;
        return this;
    }

    @Override // ir.nasim.C22155ul3
    public C22155ul3 s() {
        k0(C8074Uk3.a);
        return this;
    }

    @Override // ir.nasim.C22155ul3, java.io.Flushable
    public void flush() {
    }
}
