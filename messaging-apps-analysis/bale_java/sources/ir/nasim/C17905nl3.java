package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

/* renamed from: ir.nasim.nl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C17905nl3 extends AbstractC10062b1 {
    private final JsonArray f;
    private final int g;
    private int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17905nl3(AbstractC11279ck3 abstractC11279ck3, JsonArray jsonArray) {
        super(abstractC11279ck3, jsonArray, null);
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(jsonArray, "value");
        this.f = jsonArray;
        this.g = s0().size();
        this.h = -1;
    }

    @Override // ir.nasim.AbstractC8845Xo4
    protected String a0(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return String.valueOf(i);
    }

    @Override // ir.nasim.AbstractC10062b1
    protected JsonElement e0(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        return s0().get(Integer.parseInt(str));
    }

    @Override // kotlinx.serialization.encoding.c
    public int o(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        int i = this.h;
        if (i >= this.g - 1) {
            return -1;
        }
        int i2 = i + 1;
        this.h = i2;
        return i2;
    }

    @Override // ir.nasim.AbstractC10062b1
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public JsonArray s0() {
        return this.f;
    }
}
