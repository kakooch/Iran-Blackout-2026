package ir.nasim;

import kotlinx.serialization.json.JsonObject;

/* renamed from: ir.nasim.Zv7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9420Zv7 {
    public static final Object a(AbstractC11279ck3 abstractC11279ck3, String str, JsonObject jsonObject, XI1 xi1) {
        AbstractC13042fc3.i(abstractC11279ck3, "<this>");
        AbstractC13042fc3.i(str, "discriminator");
        AbstractC13042fc3.i(jsonObject, "element");
        AbstractC13042fc3.i(xi1, "deserializer");
        return new C17314ml3(abstractC11279ck3, jsonObject, str, xi1.getDescriptor()).k(xi1);
    }
}
