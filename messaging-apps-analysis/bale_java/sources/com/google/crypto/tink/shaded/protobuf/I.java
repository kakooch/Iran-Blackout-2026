package com.google.crypto.tink.shaded.protobuf;

import ir.nasim.T64;

/* loaded from: classes3.dex */
public interface I extends T64 {

    public interface a extends T64, Cloneable {
        I j();
    }

    AbstractC2345g b();

    void c(CodedOutputStream codedOutputStream);

    int getSerializedSize();

    a newBuilderForType();
}
