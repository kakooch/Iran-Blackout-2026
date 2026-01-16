package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.h8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2584h8 extends MessageNano {
    public static volatile C2584h8[] c;
    public X7 a;
    public X7[] b;

    public C2584h8() {
        a();
    }

    public static C2584h8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new C2584h8[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2584h8 a() {
        this.a = null;
        this.b = X7.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        X7 x7 = this.a;
        if (x7 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, x7);
        }
        X7[] x7Arr = this.b;
        if (x7Arr != null && x7Arr.length > 0) {
            int i = 0;
            while (true) {
                X7[] x7Arr2 = this.b;
                if (i >= x7Arr2.length) {
                    break;
                }
                X7 x72 = x7Arr2[i];
                if (x72 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, x72) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        X7 x7 = this.a;
        if (x7 != null) {
            codedOutputByteBufferNano.writeMessage(1, x7);
        }
        X7[] x7Arr = this.b;
        if (x7Arr != null && x7Arr.length > 0) {
            int i = 0;
            while (true) {
                X7[] x7Arr2 = this.b;
                if (i >= x7Arr2.length) {
                    break;
                }
                X7 x72 = x7Arr2[i];
                if (x72 != null) {
                    codedOutputByteBufferNano.writeMessage(2, x72);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2584h8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new X7();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                X7[] x7Arr = this.b;
                int length = x7Arr == null ? 0 : x7Arr.length;
                int i = repeatedFieldArrayLength + length;
                X7[] x7Arr2 = new X7[i];
                if (length != 0) {
                    System.arraycopy(x7Arr, 0, x7Arr2, 0, length);
                }
                while (length < i - 1) {
                    X7 x7 = new X7();
                    x7Arr2[length] = x7;
                    codedInputByteBufferNano.readMessage(x7);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                X7 x72 = new X7();
                x7Arr2[length] = x72;
                codedInputByteBufferNano.readMessage(x72);
                this.b = x7Arr2;
            }
        }
    }

    public static C2584h8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2584h8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2584h8 a(byte[] bArr) {
        return (C2584h8) MessageNano.mergeFrom(new C2584h8(), bArr);
    }
}
