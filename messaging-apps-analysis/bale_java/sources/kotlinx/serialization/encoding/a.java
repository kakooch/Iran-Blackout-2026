package kotlinx.serialization.encoding;

import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.XI1;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.c;

/* loaded from: classes8.dex */
public abstract class a implements Decoder, c {
    @Override // kotlinx.serialization.encoding.c
    public final byte A(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return G();
    }

    @Override // kotlinx.serialization.encoding.c
    public final boolean B(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return w();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean C() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.c
    public final short D(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return s();
    }

    public Object E(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(xi1, "deserializer");
        return I(xi1, obj);
    }

    @Override // kotlinx.serialization.encoding.c
    public final double F(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return v();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract byte G();

    @Override // kotlinx.serialization.encoding.c
    public final Object H(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(xi1, "deserializer");
        return (xi1.getDescriptor().b() || C()) ? I(xi1, obj) : j();
    }

    public Object I(XI1 xi1, Object obj) {
        AbstractC13042fc3.i(xi1, "deserializer");
        return k(xi1);
    }

    public Object J() {
        throw new SerializationException(AbstractC10882cM5.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public c b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "enumDescriptor");
        Object objJ = J();
        AbstractC13042fc3.g(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // kotlinx.serialization.encoding.c
    public final long f(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return m();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract int h();

    @Override // kotlinx.serialization.encoding.c
    public final int i(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return h();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object k(XI1 xi1) {
        return Decoder.a.a(this, xi1);
    }

    @Override // kotlinx.serialization.encoding.c
    public int l(SerialDescriptor serialDescriptor) {
        return c.a.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract long m();

    @Override // kotlinx.serialization.encoding.c
    public final String n(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return y();
    }

    @Override // kotlinx.serialization.encoding.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.c
    public Decoder r(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return q(serialDescriptor.h(i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract short s();

    @Override // kotlinx.serialization.encoding.Decoder
    public float t() {
        Object objJ = J();
        AbstractC13042fc3.g(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // kotlinx.serialization.encoding.c
    public final float u(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return t();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double v() {
        Object objJ = J();
        AbstractC13042fc3.g(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean w() {
        Object objJ = J();
        AbstractC13042fc3.g(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char x() {
        Object objJ = J();
        AbstractC13042fc3.g(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String y() {
        Object objJ = J();
        AbstractC13042fc3.g(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }

    @Override // kotlinx.serialization.encoding.c
    public final char z(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return x();
    }
}
