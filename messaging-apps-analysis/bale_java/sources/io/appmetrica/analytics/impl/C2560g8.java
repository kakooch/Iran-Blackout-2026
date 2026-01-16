package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.g8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2560g8 extends MessageNano {
    public static volatile C2560g8[] c;
    public C2536f8[] a;
    public int b;

    public C2560g8() {
        a();
    }

    public static C2560g8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new C2560g8[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2560g8 a() {
        this.a = C2536f8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2536f8[] c2536f8Arr = this.a;
        if (c2536f8Arr != null && c2536f8Arr.length > 0) {
            int i = 0;
            while (true) {
                C2536f8[] c2536f8Arr2 = this.a;
                if (i >= c2536f8Arr2.length) {
                    break;
                }
                C2536f8 c2536f8 = c2536f8Arr2[i];
                if (c2536f8 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c2536f8) + iComputeSerializedSize;
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2536f8[] c2536f8Arr = this.a;
        if (c2536f8Arr != null && c2536f8Arr.length > 0) {
            int i = 0;
            while (true) {
                C2536f8[] c2536f8Arr2 = this.a;
                if (i >= c2536f8Arr2.length) {
                    break;
                }
                C2536f8 c2536f8 = c2536f8Arr2[i];
                if (c2536f8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c2536f8);
                }
                i++;
            }
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2560g8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C2536f8[] c2536f8Arr = this.a;
                int length = c2536f8Arr == null ? 0 : c2536f8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C2536f8[] c2536f8Arr2 = new C2536f8[i];
                if (length != 0) {
                    System.arraycopy(c2536f8Arr, 0, c2536f8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C2536f8 c2536f8 = new C2536f8();
                    c2536f8Arr2[length] = c2536f8;
                    codedInputByteBufferNano.readMessage(c2536f8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2536f8 c2536f82 = new C2536f8();
                c2536f8Arr2[length] = c2536f82;
                codedInputByteBufferNano.readMessage(c2536f82);
                this.a = c2536f8Arr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static C2560g8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2560g8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2560g8 a(byte[] bArr) {
        return (C2560g8) MessageNano.mergeFrom(new C2560g8(), bArr);
    }
}
