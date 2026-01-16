package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.m8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2703m8 extends MessageNano {
    public static volatile C2703m8[] c;
    public C2608i8 a;
    public C2679l8 b;

    public C2703m8() {
        a();
    }

    public static C2703m8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new C2703m8[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2703m8 a() {
        this.a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2608i8 c2608i8 = this.a;
        if (c2608i8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c2608i8);
        }
        C2679l8 c2679l8 = this.b;
        return c2679l8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c2679l8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2608i8 c2608i8 = this.a;
        if (c2608i8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2608i8);
        }
        C2679l8 c2679l8 = this.b;
        if (c2679l8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c2679l8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2703m8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new C2608i8();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new C2679l8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C2703m8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2703m8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2703m8 a(byte[] bArr) {
        return (C2703m8) MessageNano.mergeFrom(new C2703m8(), bArr);
    }
}
