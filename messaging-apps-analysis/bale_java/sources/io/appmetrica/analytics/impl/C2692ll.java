package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.ll, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2692ll extends MessageNano {
    public static volatile C2692ll[] b;
    public String a;

    public C2692ll() {
        a();
    }

    public static C2692ll[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new C2692ll[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final C2692ll a() {
        this.a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.a.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.a) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2692ll mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.a = codedInputByteBufferNano.readString();
            }
        }
    }

    public static C2692ll a(byte[] bArr) {
        return (C2692ll) MessageNano.mergeFrom(new C2692ll(), bArr);
    }

    public static C2692ll b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2692ll().mergeFrom(codedInputByteBufferNano);
    }
}
