package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.NE2;
import java.util.Arrays;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {
    private final boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineClassDescriptor(String str, NE2 ne2) {
        super(str, ne2, 1);
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(ne2, "generatedSerializer");
        this.m = true;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InlineClassDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (AbstractC13042fc3.d(i(), serialDescriptor.i())) {
                InlineClassDescriptor inlineClassDescriptor = (InlineClassDescriptor) obj;
                if (inlineClassDescriptor.isInline() && Arrays.equals(p(), inlineClassDescriptor.p()) && d() == serialDescriptor.d()) {
                    int iD = d();
                    for (int i = 0; i < iD; i++) {
                        if (AbstractC13042fc3.d(h(i).i(), serialDescriptor.h(i).i()) && AbstractC13042fc3.d(h(i).f(), serialDescriptor.h(i).f())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.m;
    }
}
