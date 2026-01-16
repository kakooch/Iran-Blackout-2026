package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* renamed from: io.appmetrica.analytics.impl.c8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2462c8 extends MessageNano {
    public static volatile C2462c8[] f;
    public byte[] a;
    public byte[] b;
    public C2560g8 c;
    public C2487d8[] d;
    public int e;

    public C2462c8() {
        a();
    }

    public static C2462c8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (f == null) {
                        f = new C2462c8[0];
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public final C2462c8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = C2487d8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C2560g8 c2560g8 = this.c;
        if (c2560g8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c2560g8);
        }
        C2487d8[] c2487d8Arr = this.d;
        if (c2487d8Arr != null && c2487d8Arr.length > 0) {
            int i = 0;
            while (true) {
                C2487d8[] c2487d8Arr2 = this.d;
                if (i >= c2487d8Arr2.length) {
                    break;
                }
                C2487d8 c2487d8 = c2487d8Arr2[i];
                if (c2487d8 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(4, c2487d8) + iComputeSerializedSize;
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        byte[] bArr = this.a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C2560g8 c2560g8 = this.c;
        if (c2560g8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c2560g8);
        }
        C2487d8[] c2487d8Arr = this.d;
        if (c2487d8Arr != null && c2487d8Arr.length > 0) {
            int i = 0;
            while (true) {
                C2487d8[] c2487d8Arr2 = this.d;
                if (i >= c2487d8Arr2.length) {
                    break;
                }
                C2487d8 c2487d8 = c2487d8Arr2[i];
                if (c2487d8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, c2487d8);
                }
                i++;
            }
        }
        int i2 = this.e;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2462c8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2462c8().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2462c8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readBytes();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C2560g8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                C2487d8[] c2487d8Arr = this.d;
                int length = c2487d8Arr == null ? 0 : c2487d8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C2487d8[] c2487d8Arr2 = new C2487d8[i];
                if (length != 0) {
                    System.arraycopy(c2487d8Arr, 0, c2487d8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C2487d8 c2487d8 = new C2487d8();
                    c2487d8Arr2[length] = c2487d8;
                    codedInputByteBufferNano.readMessage(c2487d8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2487d8 c2487d82 = new C2487d8();
                c2487d8Arr2[length] = c2487d82;
                codedInputByteBufferNano.readMessage(c2487d82);
                this.d = c2487d8Arr2;
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.e = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static C2462c8 a(byte[] bArr) {
        return (C2462c8) MessageNano.mergeFrom(new C2462c8(), bArr);
    }
}
