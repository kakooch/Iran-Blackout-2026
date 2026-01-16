package ir.nasim;

import ai.bale.proto.ConfigsOuterClass$UpdateParameterChanged;

/* renamed from: ir.nasim.fF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12837fF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12228eF7 a(ConfigsOuterClass$UpdateParameterChanged configsOuterClass$UpdateParameterChanged) {
        AbstractC13042fc3.i(configsOuterClass$UpdateParameterChanged, "input");
        String key = configsOuterClass$UpdateParameterChanged.getKey();
        AbstractC13042fc3.h(key, "getKey(...)");
        return new C12228eF7(key, configsOuterClass$UpdateParameterChanged.getValue().getValue());
    }
}
