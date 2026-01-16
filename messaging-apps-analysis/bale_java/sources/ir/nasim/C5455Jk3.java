package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElement;

/* renamed from: ir.nasim.Jk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C5455Jk3 implements KSerializer {
    public static final C5455Jk3 a = new C5455Jk3();
    private static final SerialDescriptor b = AbstractC17958nq6.a("kotlinx.serialization.json.JsonLiteral", AbstractC25167zq5.i.a);

    private C5455Jk3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C5221Ik3 deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        JsonElement jsonElementG = AbstractC25105zk3.d(decoder).g();
        if (jsonElementG instanceof C5221Ik3) {
            return (C5221Ik3) jsonElementG;
        }
        throw AbstractC3802Ck3.e(-1, "Unexpected JSON element, expected JsonLiteral, had " + AbstractC10882cM5.b(jsonElementG.getClass()), jsonElementG.toString());
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, C5221Ik3 c5221Ik3) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(c5221Ik3, "value");
        AbstractC25105zk3.h(encoder);
        if (c5221Ik3.i()) {
            encoder.F(c5221Ik3.f());
            return;
        }
        if (c5221Ik3.h() != null) {
            encoder.k(c5221Ik3.h()).F(c5221Ik3.f());
            return;
        }
        Long lQ = AbstractC19562qZ6.q(c5221Ik3.f());
        if (lQ != null) {
            encoder.l(lQ.longValue());
            return;
        }
        C14599iA7 c14599iA7H = HA7.h(c5221Ik3.f());
        if (c14599iA7H != null) {
            encoder.k(AbstractC18503om0.C(C14599iA7.b).getDescriptor()).l(c14599iA7H.q());
            return;
        }
        Double dK = AbstractC18971pZ6.k(c5221Ik3.f());
        if (dK != null) {
            encoder.f(dK.doubleValue());
            return;
        }
        Boolean boolM1 = AbstractC20762sZ6.m1(c5221Ik3.f());
        if (boolM1 != null) {
            encoder.r(boolM1.booleanValue());
        } else {
            encoder.F(c5221Ik3.f());
        }
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
