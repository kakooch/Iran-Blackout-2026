package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* renamed from: ir.nasim.ol3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C18496ol3 extends C17314ml3 {
    private final JsonObject k;
    private final List l;
    private final int m;
    private int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18496ol3(AbstractC11279ck3 abstractC11279ck3, JsonObject jsonObject) {
        super(abstractC11279ck3, jsonObject, null, null, 12, null);
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(jsonObject, "value");
        this.k = jsonObject;
        List listM1 = AbstractC15401jX0.m1(s0().keySet());
        this.l = listM1;
        this.m = listM1.size() * 2;
        this.n = -1;
    }

    @Override // ir.nasim.C17314ml3, ir.nasim.AbstractC8845Xo4
    protected String a0(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return (String) this.l.get(i / 2);
    }

    @Override // ir.nasim.C17314ml3, ir.nasim.AbstractC10062b1, kotlinx.serialization.encoding.c
    public void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
    }

    @Override // ir.nasim.C17314ml3, ir.nasim.AbstractC10062b1
    protected JsonElement e0(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        return this.n % 2 == 0 ? AbstractC23331wk3.a(str) : (JsonElement) AbstractC20051rO3.l(s0(), str);
    }

    @Override // ir.nasim.C17314ml3, kotlinx.serialization.encoding.c
    public int o(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        int i = this.n;
        if (i >= this.m - 1) {
            return -1;
        }
        int i2 = i + 1;
        this.n = i2;
        return i2;
    }

    @Override // ir.nasim.C17314ml3, ir.nasim.AbstractC10062b1
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public JsonObject s0() {
        return this.k;
    }
}
