package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.Xo4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8845Xo4 extends AbstractC15525jj7 {
    protected abstract String Z(String str, String str2);

    protected String a0(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return serialDescriptor.e(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15525jj7
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final String V(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        return c0(a0(serialDescriptor, i));
    }

    protected final String c0(String str) {
        AbstractC13042fc3.i(str, "nestedName");
        String str2 = (String) U();
        if (str2 == null) {
            str2 = "";
        }
        return Z(str2, str);
    }
}
