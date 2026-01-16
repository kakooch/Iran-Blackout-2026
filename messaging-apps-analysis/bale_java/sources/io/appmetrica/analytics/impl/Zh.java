package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Zh extends MessageNano {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static volatile Zh[] i;
    public byte[] a;
    public long b;
    public int c;
    public byte[] d;
    public long e;

    public Zh() {
        a();
    }

    public static Zh[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (i == null) {
                        i = new Zh[0];
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public final Zh a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.a = bArr;
        this.b = 0L;
        this.c = 0;
        this.d = bArr;
        this.e = 0L;
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
        long j = this.b;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        int i2 = this.c;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        if (!Arrays.equals(this.d, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.d);
        }
        long j2 = this.e;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        byte[] bArr = this.a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        long j = this.b;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        int i2 = this.c;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        if (!Arrays.equals(this.d, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.d);
        }
        long j2 = this.e;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Zh b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Zh().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Zh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readBytes();
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.c = int32;
                }
            } else if (tag == 34) {
                this.d = codedInputByteBufferNano.readBytes();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.e = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static Zh a(byte[] bArr) {
        return (Zh) MessageNano.mergeFrom(new Zh(), bArr);
    }
}
