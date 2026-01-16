package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.vq5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22797vq5 extends QB3 {
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22797vq5(SerialDescriptor serialDescriptor) {
        super(serialDescriptor, null);
        AbstractC13042fc3.i(serialDescriptor, "primitive");
        this.c = serialDescriptor.i() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.c;
    }
}
