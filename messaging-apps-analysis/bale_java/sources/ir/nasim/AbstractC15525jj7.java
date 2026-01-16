package ir.nasim;

import java.util.ArrayList;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.c;

/* renamed from: ir.nasim.jj7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15525jj7 implements Decoder, kotlinx.serialization.encoding.c {
    private final ArrayList a = new ArrayList();
    private boolean b;

    /* renamed from: ir.nasim.jj7$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ XI1 f;
        final /* synthetic */ Object g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(XI1 xi1, Object obj) {
            super(0);
            this.f = xi1;
            this.g = obj;
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            AbstractC15525jj7 abstractC15525jj7 = AbstractC15525jj7.this;
            XI1 xi1 = this.f;
            return (xi1.getDescriptor().b() || abstractC15525jj7.C()) ? abstractC15525jj7.I(xi1, this.g) : abstractC15525jj7.j();
        }
    }

    /* renamed from: ir.nasim.jj7$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ XI1 f;
        final /* synthetic */ Object g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(XI1 xi1, Object obj) {
            super(0);
            this.f = xi1;
            this.g = obj;
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC15525jj7.this.I(this.f, this.g);
        }
    }

    private final Object Y(Object obj, SA2 sa2) {
        X(obj);
        Object objInvoke = sa2.invoke();
        if (!this.b) {
            W();
        }
        this.b = false;
        return objInvoke;
    }

    @Override // kotlinx.serialization.encoding.c
    public final byte A(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return K(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final boolean B(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return J(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final short D(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return S(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final Object E(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(xi1, "deserializer");
        return Y(V(serialDescriptor, i), new b(xi1, obj));
    }

    @Override // kotlinx.serialization.encoding.c
    public final double F(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return M(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte G() {
        return K(W());
    }

    @Override // kotlinx.serialization.encoding.c
    public final Object H(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(xi1, "deserializer");
        return Y(V(serialDescriptor, i), new a(xi1, obj));
    }

    protected Object I(XI1 xi1, Object obj) {
        AbstractC13042fc3.i(xi1, "deserializer");
        return k(xi1);
    }

    protected abstract boolean J(Object obj);

    protected abstract byte K(Object obj);

    protected abstract char L(Object obj);

    protected abstract double M(Object obj);

    protected abstract int N(Object obj, SerialDescriptor serialDescriptor);

    protected abstract float O(Object obj);

    protected Decoder P(Object obj, SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "inlineDescriptor");
        X(obj);
        return this;
    }

    protected abstract int Q(Object obj);

    protected abstract long R(Object obj);

    protected abstract short S(Object obj);

    protected abstract String T(Object obj);

    protected final Object U() {
        return AbstractC15401jX0.F0(this.a);
    }

    protected abstract Object V(SerialDescriptor serialDescriptor, int i);

    protected final Object W() {
        ArrayList arrayList = this.a;
        Object objRemove = arrayList.remove(AbstractC10360bX0.o(arrayList));
        this.b = true;
        return objRemove;
    }

    protected final void X(Object obj) {
        this.a.add(obj);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int e(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "enumDescriptor");
        return N(W(), serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.c
    public final long f(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return R(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int h() {
        return Q(W());
    }

    @Override // kotlinx.serialization.encoding.c
    public final int i(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return Q(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract Object k(XI1 xi1);

    @Override // kotlinx.serialization.encoding.c
    public int l(SerialDescriptor serialDescriptor) {
        return c.a.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long m() {
        return R(W());
    }

    @Override // kotlinx.serialization.encoding.c
    public final String n(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return T(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return P(W(), serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.c
    public final Decoder r(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return P(V(serialDescriptor, i), serialDescriptor.h(i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short s() {
        return S(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float t() {
        return O(W());
    }

    @Override // kotlinx.serialization.encoding.c
    public final float u(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return O(V(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double v() {
        return M(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean w() {
        return J(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char x() {
        return L(W());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String y() {
        return T(W());
    }

    @Override // kotlinx.serialization.encoding.c
    public final char z(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return L(V(serialDescriptor, i));
    }
}
