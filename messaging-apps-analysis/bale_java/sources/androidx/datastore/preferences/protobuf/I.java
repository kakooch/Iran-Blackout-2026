package androidx.datastore.preferences.protobuf;

import ir.nasim.W64;

/* loaded from: classes2.dex */
public interface I extends W64 {

    public interface a extends W64, Cloneable {
        a P(I i);

        I j();
    }

    void b(CodedOutputStream codedOutputStream);

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();
}
