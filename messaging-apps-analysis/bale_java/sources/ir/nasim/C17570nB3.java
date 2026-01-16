package ir.nasim;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.nB3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17570nB3 extends UN3 {
    private final SerialDescriptor c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17570nB3(KSerializer kSerializer, KSerializer kSerializer2) {
        super(kSerializer, kSerializer2, null);
        AbstractC13042fc3.i(kSerializer, "kSerializer");
        AbstractC13042fc3.i(kSerializer2, "vSerializer");
        this.c = new C16979mB3(kSerializer.getDescriptor(), kSerializer2.getDescriptor());
    }

    @Override // ir.nasim.UN3, kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap a() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(LinkedHashMap linkedHashMap) {
        AbstractC13042fc3.i(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(LinkedHashMap linkedHashMap, int i) {
        AbstractC13042fc3.i(linkedHashMap, "<this>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Iterator d(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        return map.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public int e(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        return map.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap k(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        LinkedHashMap linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap(map) : linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Map l(LinkedHashMap linkedHashMap) {
        AbstractC13042fc3.i(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
