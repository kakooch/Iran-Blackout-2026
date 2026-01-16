package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class Z7 extends MessageNano {
    public static volatile Z7[] e;
    public C2608i8 a;
    public C2655k8 b;
    public C2437b8 c;
    public C2584h8 d;

    public Z7() {
        a();
    }

    public static Z7[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (e == null) {
                        e = new Z7[0];
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public final Z7 a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
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
        C2655k8 c2655k8 = this.b;
        if (c2655k8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c2655k8);
        }
        C2437b8 c2437b8 = this.c;
        if (c2437b8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c2437b8);
        }
        C2584h8 c2584h8 = this.d;
        return c2584h8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, c2584h8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2608i8 c2608i8 = this.a;
        if (c2608i8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2608i8);
        }
        C2655k8 c2655k8 = this.b;
        if (c2655k8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c2655k8);
        }
        C2437b8 c2437b8 = this.c;
        if (c2437b8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c2437b8);
        }
        C2584h8 c2584h8 = this.d;
        if (c2584h8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c2584h8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Z7 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C2655k8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C2437b8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.d == null) {
                    this.d = new C2584h8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
    }

    public static Z7 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Z7().mergeFrom(codedInputByteBufferNano);
    }

    public static Z7 a(byte[] bArr) {
        return (Z7) MessageNano.mergeFrom(new Z7(), bArr);
    }
}
