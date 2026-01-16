package com.google.protobuf;

import ir.nasim.KW4;
import ir.nasim.U64;

/* loaded from: classes3.dex */
public interface P extends U64 {

    public interface a extends U64, Cloneable {
        a A0(P p);

        /* renamed from: C0 */
        a h(AbstractC2384h abstractC2384h, C2394s c2394s);

        a X0(AbstractC2383g abstractC2383g, C2394s c2394s);

        P a();

        P j();
    }

    KW4 getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    void writeTo(CodedOutputStream codedOutputStream);
}
