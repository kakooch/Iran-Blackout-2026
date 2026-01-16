package kotlin.reflect.jvm.internal.impl.protobuf;

import ir.nasim.V64;

/* loaded from: classes8.dex */
public interface l extends V64 {

    public interface a extends Cloneable, V64 {
        l a();

        a d0(e eVar, f fVar);
    }

    void b(CodedOutputStream codedOutputStream);

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();
}
