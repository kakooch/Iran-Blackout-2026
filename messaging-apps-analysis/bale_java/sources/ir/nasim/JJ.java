package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class JJ extends TW0 {
    private final SerialDescriptor b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JJ(KSerializer kSerializer) {
        super(kSerializer);
        AbstractC13042fc3.i(kSerializer, "element");
        this.b = new GJ(kSerializer.getDescriptor());
    }

    @Override // ir.nasim.RW0, kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ArrayList a() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<this>");
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList arrayList, int i) {
        AbstractC13042fc3.i(arrayList, "<this>");
        arrayList.ensureCapacity(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(ArrayList arrayList, int i, Object obj) {
        AbstractC13042fc3.i(arrayList, "<this>");
        arrayList.add(i, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList k(List list) {
        AbstractC13042fc3.i(list, "<this>");
        ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList(list) : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public List l(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<this>");
        return arrayList;
    }
}
