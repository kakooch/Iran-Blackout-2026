package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.e8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2512e8 extends MessageNano {
    public static volatile C2512e8[] b;
    public C2462c8 a;

    public C2512e8() {
        a();
    }

    public static C2512e8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new C2512e8[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final C2512e8 a() {
        this.a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2462c8 c2462c8 = this.a;
        return c2462c8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, c2462c8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2462c8 c2462c8 = this.a;
        if (c2462c8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2462c8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2512e8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.a = new C2462c8();
                }
                codedInputByteBufferNano.readMessage(this.a);
            }
        }
    }

    public static C2512e8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2512e8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2512e8 a(byte[] bArr) {
        return (C2512e8) MessageNano.mergeFrom(new C2512e8(), bArr);
    }
}
