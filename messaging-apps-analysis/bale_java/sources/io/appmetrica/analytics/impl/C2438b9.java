package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.b9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2438b9 extends MessageNano {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 6;
    public static final int k = 7;
    public static final int l = 8;
    public static final int m = 9;
    public static final int n = 10;
    public static final int o = 11;
    public static final int p = 12;
    public static volatile C2438b9[] q;
    public long a;
    public C2413a9 b;
    public Z8[] c;

    public C2438b9() {
        a();
    }

    public static C2438b9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (q == null) {
                        q = new C2438b9[0];
                    }
                } finally {
                }
            }
        }
        return q;
    }

    public final C2438b9 a() {
        this.a = 0L;
        this.b = null;
        this.c = Z8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + super.computeSerializedSize();
        C2413a9 c2413a9 = this.b;
        if (c2413a9 != null) {
            iComputeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, c2413a9);
        }
        Z8[] z8Arr = this.c;
        if (z8Arr != null && z8Arr.length > 0) {
            int i2 = 0;
            while (true) {
                Z8[] z8Arr2 = this.c;
                if (i2 >= z8Arr2.length) {
                    break;
                }
                Z8 z8 = z8Arr2[i2];
                if (z8 != null) {
                    iComputeUInt64Size = CodedOutputByteBufferNano.computeMessageSize(3, z8) + iComputeUInt64Size;
                }
                i2++;
            }
        }
        return iComputeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        codedOutputByteBufferNano.writeUInt64(1, this.a);
        C2413a9 c2413a9 = this.b;
        if (c2413a9 != null) {
            codedOutputByteBufferNano.writeMessage(2, c2413a9);
        }
        Z8[] z8Arr = this.c;
        if (z8Arr != null && z8Arr.length > 0) {
            int i2 = 0;
            while (true) {
                Z8[] z8Arr2 = this.c;
                if (i2 >= z8Arr2.length) {
                    break;
                }
                Z8 z8 = z8Arr2[i2];
                if (z8 != null) {
                    codedOutputByteBufferNano.writeMessage(3, z8);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2438b9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.a = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C2413a9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                Z8[] z8Arr = this.c;
                int length = z8Arr == null ? 0 : z8Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                Z8[] z8Arr2 = new Z8[i2];
                if (length != 0) {
                    System.arraycopy(z8Arr, 0, z8Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    Z8 z8 = new Z8();
                    z8Arr2[length] = z8;
                    codedInputByteBufferNano.readMessage(z8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Z8 z82 = new Z8();
                z8Arr2[length] = z82;
                codedInputByteBufferNano.readMessage(z82);
                this.c = z8Arr2;
            }
        }
    }

    public static C2438b9 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2438b9().mergeFrom(codedInputByteBufferNano);
    }

    public static C2438b9 a(byte[] bArr) {
        return (C2438b9) MessageNano.mergeFrom(new C2438b9(), bArr);
    }
}
