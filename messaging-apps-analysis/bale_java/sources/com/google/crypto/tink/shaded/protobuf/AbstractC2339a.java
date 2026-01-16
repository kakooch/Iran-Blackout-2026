package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.I;
import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2339a implements I {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0195a implements I.a {
        protected static UninitializedMessageException d(I i) {
            return new UninitializedMessageException(i);
        }
    }

    private String d(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    abstract int a(V v);

    @Override // com.google.crypto.tink.shaded.protobuf.I
    public AbstractC2345g b() {
        try {
            AbstractC2345g.h hVarP = AbstractC2345g.P(getSerializedSize());
            c(hVarP.b());
            return hVarP.a();
        } catch (IOException e) {
            throw new RuntimeException(d("ByteString"), e);
        }
    }

    UninitializedMessageException e() {
        return new UninitializedMessageException(this);
    }

    public byte[] f() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream codedOutputStreamU = CodedOutputStream.U(bArr);
            c(codedOutputStreamU);
            codedOutputStreamU.c();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(d("byte array"), e);
        }
    }
}
