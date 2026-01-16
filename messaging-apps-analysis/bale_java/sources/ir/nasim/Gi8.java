package ir.nasim;

import com.google.android.gms.internal.clearcut.AbstractC2071a;

/* loaded from: classes3.dex */
public abstract class Gi8 implements InterfaceC21580tm8 {
    @Override // ir.nasim.InterfaceC21580tm8
    public final /* synthetic */ InterfaceC21580tm8 S1(InterfaceC20302rm8 interfaceC20302rm8) {
        if (f().getClass().isInstance(interfaceC20302rm8)) {
            return h((AbstractC2071a) interfaceC20302rm8);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    protected abstract Gi8 h(AbstractC2071a abstractC2071a);
}
