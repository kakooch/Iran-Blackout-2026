package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class GJ extends QB3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GJ(SerialDescriptor serialDescriptor) {
        super(serialDescriptor, null);
        AbstractC13042fc3.i(serialDescriptor, "elementDesc");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return "kotlin.collections.ArrayList";
    }
}
