package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;

/* renamed from: ir.nasim.bl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C10526bl3 extends AbstractC10062b1 {
    private final JsonElement f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10526bl3(AbstractC11279ck3 abstractC11279ck3, JsonElement jsonElement) {
        super(abstractC11279ck3, jsonElement, null);
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(jsonElement, "value");
        this.f = jsonElement;
        X("primitive");
    }

    @Override // ir.nasim.AbstractC10062b1
    protected JsonElement e0(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        if (str == "primitive") {
            return s0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    @Override // kotlinx.serialization.encoding.c
    public int o(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return 0;
    }

    @Override // ir.nasim.AbstractC10062b1
    public JsonElement s0() {
        return this.f;
    }
}
