package ir.nasim;

import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.pY6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18962pY6 {
    private static final Set a = AbstractC4597Fu6.i(AbstractC18503om0.B(C11540dA7.b).getDescriptor(), AbstractC18503om0.C(C14599iA7.b).getDescriptor(), AbstractC18503om0.A(C7743Sz7.b).getDescriptor(), AbstractC18503om0.D(C24771zA7.b).getDescriptor());

    public static final boolean a(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && AbstractC13042fc3.d(serialDescriptor, AbstractC23331wk3.i());
    }

    public static final boolean b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && a.contains(serialDescriptor);
    }
}
