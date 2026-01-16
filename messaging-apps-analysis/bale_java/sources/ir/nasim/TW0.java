package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public abstract class TW0 extends RW0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TW0(KSerializer kSerializer) {
        super(kSerializer, null);
        AbstractC13042fc3.i(kSerializer, "element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Iterator d(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int e(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        return collection.size();
    }
}
