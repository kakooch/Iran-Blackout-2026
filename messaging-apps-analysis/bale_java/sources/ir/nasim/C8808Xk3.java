package ir.nasim;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonObject;

/* renamed from: ir.nasim.Xk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8808Xk3 implements KSerializer {
    public static final C8808Xk3 a = new C8808Xk3();
    private static final SerialDescriptor b = a.b;

    /* renamed from: ir.nasim.Xk3$a */
    private static final class a implements SerialDescriptor {
        public static final a b = new a();
        private static final String c = "kotlinx.serialization.json.JsonObject";
        private final /* synthetic */ SerialDescriptor a = AbstractC18503om0.i(AbstractC18503om0.z(DY6.a), C24511yk3.a).getDescriptor();

        private a() {
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String str) {
            AbstractC13042fc3.i(str, "name");
            return this.a.c(str);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int d() {
            return this.a.d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String e(int i) {
            return this.a.e(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public AbstractC19731qq6 f() {
            return this.a.f();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List g(int i) {
            return this.a.g(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List getAnnotations() {
            return this.a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor h(int i) {
            return this.a.h(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String i() {
            return c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.a.isInline();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean j(int i) {
            return this.a.j(i);
        }
    }

    private C8808Xk3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonObject deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        AbstractC25105zk3.g(decoder);
        return new JsonObject((Map) AbstractC18503om0.i(AbstractC18503om0.z(DY6.a), C24511yk3.a).deserialize(decoder));
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonObject jsonObject) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(jsonObject, "value");
        AbstractC25105zk3.h(encoder);
        AbstractC18503om0.i(AbstractC18503om0.z(DY6.a), C24511yk3.a).serialize(encoder, jsonObject);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
