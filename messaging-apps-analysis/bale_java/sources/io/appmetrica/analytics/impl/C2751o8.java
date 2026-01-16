package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.o8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2751o8 extends MessageNano {
    public static volatile C2751o8[] b;
    public C2679l8 a;

    public C2751o8() {
        a();
    }

    public static C2751o8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new C2751o8[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final C2751o8 a() {
        this.a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2679l8 c2679l8 = this.a;
        return c2679l8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, c2679l8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2679l8 c2679l8 = this.a;
        if (c2679l8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2679l8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2751o8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.a = new C2679l8();
                }
                codedInputByteBufferNano.readMessage(this.a);
            }
        }
    }

    public static C2751o8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2751o8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2751o8 a(byte[] bArr) {
        return (C2751o8) MessageNano.mergeFrom(new C2751o8(), bArr);
    }
}
