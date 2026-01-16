package kotlinx.serialization.encoding;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC22798vq6;
import ir.nasim.MA4;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.encoding.d;

/* loaded from: classes8.dex */
public abstract class b implements Encoder, d {
    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void A(int i);

    @Override // kotlinx.serialization.encoding.d
    public void B(SerialDescriptor serialDescriptor, int i, InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(interfaceC22798vq6, "serializer");
        if (G(serialDescriptor, i)) {
            h(interfaceC22798vq6, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void C(SerialDescriptor serialDescriptor, int i, short s) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            q(s);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void D(SerialDescriptor serialDescriptor, int i, double d) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            f(d);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void E(SerialDescriptor serialDescriptor, int i, long j) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            l(j);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void F(String str);

    public boolean G(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return true;
    }

    public void H(InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
        Encoder.a.c(this, interfaceC22798vq6, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public d b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.d
    public final Encoder e(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return G(serialDescriptor, i) ? k(serialDescriptor.h(i)) : MA4.a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void f(double d);

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void g(byte b);

    @Override // kotlinx.serialization.encoding.Encoder
    public void h(InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
        Encoder.a.d(this, interfaceC22798vq6, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public d i(SerialDescriptor serialDescriptor, int i) {
        return Encoder.a.a(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder k(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void l(long j);

    public void m(SerialDescriptor serialDescriptor, int i, InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(interfaceC22798vq6, "serializer");
        if (G(serialDescriptor, i)) {
            H(interfaceC22798vq6, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void n(SerialDescriptor serialDescriptor, int i, char c) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            u(c);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void p(SerialDescriptor serialDescriptor, int i, byte b) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            g(b);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void q(short s);

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void r(boolean z);

    @Override // kotlinx.serialization.encoding.d
    public final void s(SerialDescriptor serialDescriptor, int i, float f) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            t(f);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void t(float f);

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void u(char c);

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
        Encoder.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void w(SerialDescriptor serialDescriptor, int i, int i2) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            A(i2);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void x(SerialDescriptor serialDescriptor, int i, boolean z) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (G(serialDescriptor, i)) {
            r(z);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void y(SerialDescriptor serialDescriptor, int i, String str) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(str, "value");
        if (G(serialDescriptor, i)) {
            F(str);
        }
    }

    public boolean z(SerialDescriptor serialDescriptor, int i) {
        return d.a.a(this, serialDescriptor, i);
    }
}
