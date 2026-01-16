package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class Lj extends MessageNano {
    public static volatile Lj[] b;
    public Mj[] a;

    public Lj() {
        a();
    }

    public static Lj[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new Lj[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final Lj a() {
        this.a = Mj.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Mj[] mjArr = this.a;
        if (mjArr != null && mjArr.length > 0) {
            int i = 0;
            while (true) {
                Mj[] mjArr2 = this.a;
                if (i >= mjArr2.length) {
                    break;
                }
                Mj mj = mjArr2[i];
                if (mj != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, mj) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        Mj[] mjArr = this.a;
        if (mjArr != null && mjArr.length > 0) {
            int i = 0;
            while (true) {
                Mj[] mjArr2 = this.a;
                if (i >= mjArr2.length) {
                    break;
                }
                Mj mj = mjArr2[i];
                if (mj != null) {
                    codedOutputByteBufferNano.writeMessage(1, mj);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Lj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                Mj[] mjArr = this.a;
                int length = mjArr == null ? 0 : mjArr.length;
                int i = repeatedFieldArrayLength + length;
                Mj[] mjArr2 = new Mj[i];
                if (length != 0) {
                    System.arraycopy(mjArr, 0, mjArr2, 0, length);
                }
                while (length < i - 1) {
                    Mj mj = new Mj();
                    mjArr2[length] = mj;
                    codedInputByteBufferNano.readMessage(mj);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Mj mj2 = new Mj();
                mjArr2[length] = mj2;
                codedInputByteBufferNano.readMessage(mj2);
                this.a = mjArr2;
            }
        }
    }

    public static Lj b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Lj().mergeFrom(codedInputByteBufferNano);
    }

    public static Lj a(byte[] bArr) {
        return (Lj) MessageNano.mergeFrom(new Lj(), bArr);
    }
}
