package ir.nasim;

import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.zk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC25105zk3 {

    /* renamed from: ir.nasim.zk3$a */
    public static final class a implements SerialDescriptor {
        private final InterfaceC9173Yu3 a;

        a(SA2 sa2) {
            this.a = AbstractC13269fw3.a(sa2);
        }

        private final SerialDescriptor a() {
            return (SerialDescriptor) this.a.getValue();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return SerialDescriptor.a.c(this);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String str) {
            AbstractC13042fc3.i(str, "name");
            return a().c(str);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int d() {
            return a().d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String e(int i) {
            return a().e(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public AbstractC19731qq6 f() {
            return a().f();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List g(int i) {
            return a().g(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List getAnnotations() {
            return SerialDescriptor.a.a(this);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor h(int i) {
            return a().h(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String i() {
            return a().i();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return SerialDescriptor.a.b(this);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean j(int i) {
            return a().j(i);
        }
    }

    public static final InterfaceC20277rk3 d(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "<this>");
        InterfaceC20277rk3 interfaceC20277rk3 = decoder instanceof InterfaceC20277rk3 ? (InterfaceC20277rk3) decoder : null;
        if (interfaceC20277rk3 != null) {
            return interfaceC20277rk3;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + AbstractC10882cM5.b(decoder.getClass()));
    }

    public static final InterfaceC3329Ak3 e(Encoder encoder) {
        AbstractC13042fc3.i(encoder, "<this>");
        InterfaceC3329Ak3 interfaceC3329Ak3 = encoder instanceof InterfaceC3329Ak3 ? (InterfaceC3329Ak3) encoder : null;
        if (interfaceC3329Ak3 != null) {
            return interfaceC3329Ak3;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + AbstractC10882cM5.b(encoder.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor f(SA2 sa2) {
        return new a(sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Decoder decoder) {
        d(decoder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Encoder encoder) {
        e(encoder);
    }
}
