package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC19731qq6;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.ml3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C17314ml3 extends AbstractC10062b1 {
    private final JsonObject f;
    private final String g;
    private final SerialDescriptor h;
    private int i;
    private boolean j;

    public /* synthetic */ C17314ml3(AbstractC11279ck3 abstractC11279ck3, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i, ED1 ed1) {
        this(abstractC11279ck3, jsonObject, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : serialDescriptor);
    }

    private final boolean u0(SerialDescriptor serialDescriptor, int i) {
        boolean z = (d().d().i() || serialDescriptor.j(i) || !serialDescriptor.h(i).b()) ? false : true;
        this.j = z;
        return z;
    }

    private final boolean v0(SerialDescriptor serialDescriptor, int i, String str) {
        AbstractC11279ck3 abstractC11279ck3D = d();
        if (!serialDescriptor.j(i)) {
            return false;
        }
        SerialDescriptor serialDescriptorH = serialDescriptor.h(i);
        if (serialDescriptorH.b() || !(e0(str) instanceof JsonNull)) {
            if (!AbstractC13042fc3.d(serialDescriptorH.f(), AbstractC19731qq6.b.a)) {
                return false;
            }
            if (serialDescriptorH.b() && (e0(str) instanceof JsonNull)) {
                return false;
            }
            JsonElement jsonElementE0 = e0(str);
            JsonPrimitive jsonPrimitive = jsonElementE0 instanceof JsonPrimitive ? (JsonPrimitive) jsonElementE0 : null;
            String strD = jsonPrimitive != null ? AbstractC23331wk3.d(jsonPrimitive) : null;
            if (strD == null || AbstractC7601Sk3.h(serialDescriptorH, abstractC11279ck3D, strD) != -3) {
                return false;
            }
        }
        return true;
    }

    @Override // ir.nasim.AbstractC10062b1, kotlinx.serialization.encoding.Decoder
    public boolean C() {
        return !this.j && super.C();
    }

    @Override // ir.nasim.AbstractC8845Xo4
    protected String a0(SerialDescriptor serialDescriptor, int i) {
        Object next;
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC7601Sk3.l(serialDescriptor, d());
        String strE = serialDescriptor.e(i);
        if (!this.e.n() || s0().keySet().contains(strE)) {
            return strE;
        }
        Map mapE = AbstractC7601Sk3.e(d(), serialDescriptor);
        Iterator<T> it = s0().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Integer num = (Integer) mapE.get((String) next);
            if (num != null && num.intValue() == i) {
                break;
            }
        }
        String str = (String) next;
        return str != null ? str : strE;
    }

    @Override // ir.nasim.AbstractC10062b1, kotlinx.serialization.encoding.Decoder
    public kotlinx.serialization.encoding.c b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (serialDescriptor != this.h) {
            return super.b(serialDescriptor);
        }
        AbstractC11279ck3 abstractC11279ck3D = d();
        JsonElement jsonElementF0 = f0();
        SerialDescriptor serialDescriptor2 = this.h;
        if (jsonElementF0 instanceof JsonObject) {
            return new C17314ml3(abstractC11279ck3D, (JsonObject) jsonElementF0, this.g, serialDescriptor2);
        }
        throw AbstractC3802Ck3.d(-1, "Expected " + AbstractC10882cM5.b(JsonObject.class) + " as the serialized body of " + serialDescriptor2.i() + ", but had " + AbstractC10882cM5.b(jsonElementF0.getClass()));
    }

    @Override // ir.nasim.AbstractC10062b1, kotlinx.serialization.encoding.c
    public void c(SerialDescriptor serialDescriptor) {
        Set setL;
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (this.e.j() || (serialDescriptor.f() instanceof AbstractC12495ei5)) {
            return;
        }
        AbstractC7601Sk3.l(serialDescriptor, d());
        if (this.e.n()) {
            Set setA = AbstractC4753Gk3.a(serialDescriptor);
            Map map = (Map) AbstractC13750gl3.a(d()).a(serialDescriptor, AbstractC7601Sk3.f());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = AbstractC4597Fu6.d();
            }
            setL = AbstractC4846Gu6.l(setA, setKeySet);
        } else {
            setL = AbstractC4753Gk3.a(serialDescriptor);
        }
        for (String str : s0().keySet()) {
            if (!setL.contains(str) && !AbstractC13042fc3.d(str, this.g)) {
                throw AbstractC3802Ck3.f(str, s0().toString());
            }
        }
    }

    @Override // ir.nasim.AbstractC10062b1
    protected JsonElement e0(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        return (JsonElement) AbstractC20051rO3.l(s0(), str);
    }

    @Override // kotlinx.serialization.encoding.c
    public int o(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        while (this.i < serialDescriptor.d()) {
            int i = this.i;
            this.i = i + 1;
            String strV = V(serialDescriptor, i);
            int i2 = this.i - 1;
            this.j = false;
            if (s0().containsKey(strV) || u0(serialDescriptor, i2)) {
                if (!this.e.f() || !v0(serialDescriptor, i2, strV)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    @Override // ir.nasim.AbstractC10062b1
    /* renamed from: w0 */
    public JsonObject s0() {
        return this.f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17314ml3(AbstractC11279ck3 abstractC11279ck3, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        super(abstractC11279ck3, jsonObject, null);
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(jsonObject, "value");
        this.f = jsonObject;
        this.g = str;
        this.h = serialDescriptor;
    }
}
