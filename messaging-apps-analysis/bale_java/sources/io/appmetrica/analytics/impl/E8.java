package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class E8 extends MessageNano {
    public static volatile E8[] b;
    public D8[] a;

    public E8() {
        a();
    }

    public static E8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new E8[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final E8 a() {
        this.a = D8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        D8[] d8Arr = this.a;
        if (d8Arr != null && d8Arr.length > 0) {
            int i = 0;
            while (true) {
                D8[] d8Arr2 = this.a;
                if (i >= d8Arr2.length) {
                    break;
                }
                D8 d8 = d8Arr2[i];
                if (d8 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, d8) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        D8[] d8Arr = this.a;
        if (d8Arr != null && d8Arr.length > 0) {
            int i = 0;
            while (true) {
                D8[] d8Arr2 = this.a;
                if (i >= d8Arr2.length) {
                    break;
                }
                D8 d8 = d8Arr2[i];
                if (d8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, d8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final E8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                D8[] d8Arr = this.a;
                int length = d8Arr == null ? 0 : d8Arr.length;
                int i = repeatedFieldArrayLength + length;
                D8[] d8Arr2 = new D8[i];
                if (length != 0) {
                    System.arraycopy(d8Arr, 0, d8Arr2, 0, length);
                }
                while (length < i - 1) {
                    D8 d8 = new D8();
                    d8Arr2[length] = d8;
                    codedInputByteBufferNano.readMessage(d8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                D8 d82 = new D8();
                d8Arr2[length] = d82;
                codedInputByteBufferNano.readMessage(d82);
                this.a = d8Arr2;
            }
        }
    }

    public static E8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new E8().mergeFrom(codedInputByteBufferNano);
    }

    public static E8 a(byte[] bArr) {
        return (E8) MessageNano.mergeFrom(new E8(), bArr);
    }
}
