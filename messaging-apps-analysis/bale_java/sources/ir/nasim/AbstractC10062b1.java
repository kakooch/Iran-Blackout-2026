package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC19731qq6;
import ir.nasim.IZ6;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.b1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC10062b1 extends AbstractC8845Xo4 implements InterfaceC20277rk3 {
    private final AbstractC11279ck3 c;
    private final JsonElement d;
    protected final C15531jk3 e;

    public /* synthetic */ AbstractC10062b1(AbstractC11279ck3 abstractC11279ck3, JsonElement jsonElement, ED1 ed1) {
        this(abstractC11279ck3, jsonElement);
    }

    private final C5221Ik3 d0(JsonPrimitive jsonPrimitive, String str) {
        C5221Ik3 c5221Ik3 = jsonPrimitive instanceof C5221Ik3 ? (C5221Ik3) jsonPrimitive : null;
        if (c5221Ik3 != null) {
            return c5221Ik3;
        }
        throw AbstractC3802Ck3.d(-1, "Unexpected 'null' literal when non-nullable " + str + " was expected");
    }

    private final Void t0(String str) {
        throw AbstractC3802Ck3.e(-1, "Failed to parse literal as '" + str + "' value", f0().toString());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean C() {
        return !(f0() instanceof JsonNull);
    }

    @Override // ir.nasim.AbstractC8845Xo4
    protected String Z(String str, String str2) {
        AbstractC13042fc3.i(str, "parentName");
        AbstractC13042fc3.i(str2, "childName");
        return str2;
    }

    @Override // kotlinx.serialization.encoding.c
    public AbstractC3859Cq6 a() {
        return d().a();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public kotlinx.serialization.encoding.c b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        JsonElement jsonElementF0 = f0();
        AbstractC19731qq6 abstractC19731qq6F = serialDescriptor.f();
        if (AbstractC13042fc3.d(abstractC19731qq6F, IZ6.b.a) ? true : abstractC19731qq6F instanceof AbstractC12495ei5) {
            AbstractC11279ck3 abstractC11279ck3D = d();
            if (jsonElementF0 instanceof JsonArray) {
                return new C17905nl3(abstractC11279ck3D, (JsonArray) jsonElementF0);
            }
            throw AbstractC3802Ck3.d(-1, "Expected " + AbstractC10882cM5.b(JsonArray.class) + " as the serialized body of " + serialDescriptor.i() + ", but had " + AbstractC10882cM5.b(jsonElementF0.getClass()));
        }
        if (!AbstractC13042fc3.d(abstractC19731qq6F, IZ6.c.a)) {
            AbstractC11279ck3 abstractC11279ck3D2 = d();
            if (jsonElementF0 instanceof JsonObject) {
                return new C17314ml3(abstractC11279ck3D2, (JsonObject) jsonElementF0, null, null, 12, null);
            }
            throw AbstractC3802Ck3.d(-1, "Expected " + AbstractC10882cM5.b(JsonObject.class) + " as the serialized body of " + serialDescriptor.i() + ", but had " + AbstractC10882cM5.b(jsonElementF0.getClass()));
        }
        AbstractC11279ck3 abstractC11279ck3D3 = d();
        SerialDescriptor serialDescriptorA = Hb8.a(serialDescriptor.h(0), abstractC11279ck3D3.a());
        AbstractC19731qq6 abstractC19731qq6F2 = serialDescriptorA.f();
        if ((abstractC19731qq6F2 instanceof AbstractC25167zq5) || AbstractC13042fc3.d(abstractC19731qq6F2, AbstractC19731qq6.b.a)) {
            AbstractC11279ck3 abstractC11279ck3D4 = d();
            if (jsonElementF0 instanceof JsonObject) {
                return new C18496ol3(abstractC11279ck3D4, (JsonObject) jsonElementF0);
            }
            throw AbstractC3802Ck3.d(-1, "Expected " + AbstractC10882cM5.b(JsonObject.class) + " as the serialized body of " + serialDescriptor.i() + ", but had " + AbstractC10882cM5.b(jsonElementF0.getClass()));
        }
        if (!abstractC11279ck3D3.d().b()) {
            throw AbstractC3802Ck3.c(serialDescriptorA);
        }
        AbstractC11279ck3 abstractC11279ck3D5 = d();
        if (jsonElementF0 instanceof JsonArray) {
            return new C17905nl3(abstractC11279ck3D5, (JsonArray) jsonElementF0);
        }
        throw AbstractC3802Ck3.d(-1, "Expected " + AbstractC10882cM5.b(JsonArray.class) + " as the serialized body of " + serialDescriptor.i() + ", but had " + AbstractC10882cM5.b(jsonElementF0.getClass()));
    }

    @Override // kotlinx.serialization.encoding.c
    public void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
    }

    @Override // ir.nasim.InterfaceC20277rk3
    public AbstractC11279ck3 d() {
        return this.c;
    }

    protected abstract JsonElement e0(String str);

    protected final JsonElement f0() {
        JsonElement jsonElementE0;
        String str = (String) U();
        return (str == null || (jsonElementE0 = e0(str)) == null) ? s0() : jsonElementE0;
    }

    @Override // ir.nasim.InterfaceC20277rk3
    public JsonElement g() {
        return f0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public boolean J(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            Boolean boolC = AbstractC23331wk3.c(r0(str));
            if (boolC != null) {
                return boolC.booleanValue();
            }
            t0("boolean");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            t0("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public byte K(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            int iG = AbstractC23331wk3.g(r0(str));
            Byte bValueOf = (-128 > iG || iG > 127) ? null : Byte.valueOf((byte) iG);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            t0("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            t0("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public char L(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            return AbstractC22039uZ6.w1(r0(str).f());
        } catch (IllegalArgumentException unused) {
            t0("char");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public double M(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            double dE = AbstractC23331wk3.e(r0(str));
            if (d().d().a() || !(Double.isInfinite(dE) || Double.isNaN(dE))) {
                return dE;
            }
            throw AbstractC3802Ck3.a(Double.valueOf(dE), str, f0().toString());
        } catch (IllegalArgumentException unused) {
            t0("double");
            throw new KotlinNothingValueException();
        }
    }

    @Override // ir.nasim.AbstractC15525jj7, kotlinx.serialization.encoding.Decoder
    public Object k(XI1 xi1) {
        AbstractC13042fc3.i(xi1, "deserializer");
        return AbstractC13131fi5.d(this, xi1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public int N(String str, SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(serialDescriptor, "enumDescriptor");
        return AbstractC7601Sk3.j(serialDescriptor, d(), r0(str).f(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public float O(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            float f = AbstractC23331wk3.f(r0(str));
            if (d().d().a() || !(Float.isInfinite(f) || Float.isNaN(f))) {
                return f;
            }
            throw AbstractC3802Ck3.a(Float.valueOf(f), str, f0().toString());
        } catch (IllegalArgumentException unused) {
            t0("float");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public Decoder P(String str, SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(serialDescriptor, "inlineDescriptor");
        return AbstractC18962pY6.b(serialDescriptor) ? new C20868sk3(new LY6(r0(str).f()), d()) : super.P(str, serialDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public int Q(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            return AbstractC23331wk3.g(r0(str));
        } catch (IllegalArgumentException unused) {
            t0("int");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public long R(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            return AbstractC23331wk3.j(r0(str));
        } catch (IllegalArgumentException unused) {
            t0("long");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public short S(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            int iG = AbstractC23331wk3.g(r0(str));
            Short shValueOf = (-32768 > iG || iG > 32767) ? null : Short.valueOf((short) iG);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            t0("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            t0("short");
            throw new KotlinNothingValueException();
        }
    }

    @Override // ir.nasim.AbstractC15525jj7, kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return U() != null ? super.q(serialDescriptor) : new C10526bl3(d(), s0()).q(serialDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public String T(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        JsonPrimitive jsonPrimitiveR0 = r0(str);
        if (d().d().p() || d0(jsonPrimitiveR0, "string").i()) {
            if (jsonPrimitiveR0 instanceof JsonNull) {
                throw AbstractC3802Ck3.e(-1, "Unexpected 'null' value instead of string literal", f0().toString());
            }
            return jsonPrimitiveR0.f();
        }
        throw AbstractC3802Ck3.e(-1, "String literal for key '" + str + "' should be quoted.\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", f0().toString());
    }

    protected final JsonPrimitive r0(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        JsonElement jsonElementE0 = e0(str);
        JsonPrimitive jsonPrimitive = jsonElementE0 instanceof JsonPrimitive ? (JsonPrimitive) jsonElementE0 : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw AbstractC3802Ck3.e(-1, "Expected JsonPrimitive at " + str + ", found " + jsonElementE0, f0().toString());
    }

    public abstract JsonElement s0();

    private AbstractC10062b1(AbstractC11279ck3 abstractC11279ck3, JsonElement jsonElement) {
        this.c = abstractC11279ck3;
        this.d = jsonElement;
        this.e = d().d();
    }
}
