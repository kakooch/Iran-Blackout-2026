package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class Y7 extends MessageNano {
    public static volatile Y7[] b;
    public Z7 a;

    public Y7() {
        a();
    }

    public static Y7[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new Y7[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final Y7 a() {
        this.a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Z7 z7 = this.a;
        return z7 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, z7) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        Z7 z7 = this.a;
        if (z7 != null) {
            codedOutputByteBufferNano.writeMessage(1, z7);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y7 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.a == null) {
                    this.a = new Z7();
                }
                codedInputByteBufferNano.readMessage(this.a);
            }
        }
    }

    public static Y7 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Y7().mergeFrom(codedInputByteBufferNano);
    }

    public static Y7 a(byte[] bArr) {
        return (Y7) MessageNano.mergeFrom(new Y7(), bArr);
    }
}
