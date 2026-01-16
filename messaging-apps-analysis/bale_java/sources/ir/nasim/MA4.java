package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class MA4 extends kotlinx.serialization.encoding.b {
    public static final MA4 a = new MA4();
    private static final AbstractC3859Cq6 b = AbstractC4327Eq6.a();

    private MA4() {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void F(String str) {
        AbstractC13042fc3.i(str, "value");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public AbstractC3859Cq6 a() {
        return b;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void j(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "enumDescriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void A(int i) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void f(double d) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void g(byte b2) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void l(long j) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void q(short s) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void r(boolean z) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void t(float f) {
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void u(char c) {
    }
}
