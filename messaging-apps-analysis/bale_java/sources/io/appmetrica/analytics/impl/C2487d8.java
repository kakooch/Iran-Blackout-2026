package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.d8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2487d8 extends MessageNano {
    public static volatile C2487d8[] c;
    public int a;
    public Z7 b;

    public C2487d8() {
        a();
    }

    public static C2487d8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new C2487d8[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2487d8 a() {
        this.a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.a;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        Z7 z7 = this.b;
        return z7 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, z7) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        Z7 z7 = this.b;
        if (z7 != null) {
            codedOutputByteBufferNano.writeMessage(2, z7);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2487d8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.a = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new Z7();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C2487d8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2487d8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2487d8 a(byte[] bArr) {
        return (C2487d8) MessageNano.mergeFrom(new C2487d8(), bArr);
    }
}
