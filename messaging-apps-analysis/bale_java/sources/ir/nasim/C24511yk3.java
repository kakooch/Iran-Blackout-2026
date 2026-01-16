package ir.nasim;

import ir.nasim.AbstractC12495ei5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.yk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24511yk3 implements KSerializer {
    public static final C24511yk3 a = new C24511yk3();
    private static final SerialDescriptor b = AbstractC17958nq6.b("kotlinx.serialization.json.JsonElement", AbstractC12495ei5.a.a, new SerialDescriptor[0], a.e);

    /* renamed from: ir.nasim.yk3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.yk3$a$a, reason: collision with other inner class name */
        static final class C1798a extends AbstractC8614Ws3 implements SA2 {
            public static final C1798a e = new C1798a();

            C1798a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return C11289cl3.a.getDescriptor();
            }
        }

        /* renamed from: ir.nasim.yk3$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            public static final b e = new b();

            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return C8308Vk3.a.getDescriptor();
            }
        }

        /* renamed from: ir.nasim.yk3$a$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            public static final c e = new c();

            c() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return C5455Jk3.a.getDescriptor();
            }
        }

        /* renamed from: ir.nasim.yk3$a$d */
        static final class d extends AbstractC8614Ws3 implements SA2 {
            public static final d e = new d();

            d() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return C8808Xk3.a.getDescriptor();
            }
        }

        /* renamed from: ir.nasim.yk3$a$e */
        static final class e extends AbstractC8614Ws3 implements SA2 {
            public static final e e = new e();

            e() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SerialDescriptor invoke() {
                return C13740gk3.a.getDescriptor();
            }
        }

        a() {
            super(1);
        }

        public final void a(FU0 fu0) {
            AbstractC13042fc3.i(fu0, "$this$buildSerialDescriptor");
            FU0.b(fu0, "JsonPrimitive", AbstractC25105zk3.f(C1798a.e), null, false, 12, null);
            FU0.b(fu0, "JsonNull", AbstractC25105zk3.f(b.e), null, false, 12, null);
            FU0.b(fu0, "JsonLiteral", AbstractC25105zk3.f(c.e), null, false, 12, null);
            FU0.b(fu0, "JsonObject", AbstractC25105zk3.f(d.e), null, false, 12, null);
            FU0.b(fu0, "JsonArray", AbstractC25105zk3.f(e.e), null, false, 12, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((FU0) obj);
            return C19938rB7.a;
        }
    }

    private C24511yk3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonElement deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return AbstractC25105zk3.d(decoder).g();
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonElement jsonElement) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(jsonElement, "value");
        AbstractC25105zk3.h(encoder);
        if (jsonElement instanceof JsonPrimitive) {
            encoder.h(C11289cl3.a, jsonElement);
        } else if (jsonElement instanceof JsonObject) {
            encoder.h(C8808Xk3.a, jsonElement);
        } else if (jsonElement instanceof JsonArray) {
            encoder.h(C13740gk3.a, jsonElement);
        }
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
