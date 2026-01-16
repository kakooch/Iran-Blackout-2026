package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class N3 extends MessageNano {
    public static volatile N3[] b;
    public M3[] a;

    public N3() {
        a();
    }

    public static N3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new N3[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final N3 a() {
        this.a = M3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        M3[] m3Arr = this.a;
        if (m3Arr != null && m3Arr.length > 0) {
            int i = 0;
            while (true) {
                M3[] m3Arr2 = this.a;
                if (i >= m3Arr2.length) {
                    break;
                }
                M3 m3 = m3Arr2[i];
                if (m3 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, m3) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        M3[] m3Arr = this.a;
        if (m3Arr != null && m3Arr.length > 0) {
            int i = 0;
            while (true) {
                M3[] m3Arr2 = this.a;
                if (i >= m3Arr2.length) {
                    break;
                }
                M3 m3 = m3Arr2[i];
                if (m3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, m3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final N3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                M3[] m3Arr = this.a;
                int length = m3Arr == null ? 0 : m3Arr.length;
                int i = repeatedFieldArrayLength + length;
                M3[] m3Arr2 = new M3[i];
                if (length != 0) {
                    System.arraycopy(m3Arr, 0, m3Arr2, 0, length);
                }
                while (length < i - 1) {
                    M3 m3 = new M3();
                    m3Arr2[length] = m3;
                    codedInputByteBufferNano.readMessage(m3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                M3 m32 = new M3();
                m3Arr2[length] = m32;
                codedInputByteBufferNano.readMessage(m32);
                this.a = m3Arr2;
            }
        }
    }

    public static N3 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new N3().mergeFrom(codedInputByteBufferNano);
    }

    public static N3 a(byte[] bArr) {
        return (N3) MessageNano.mergeFrom(new N3(), bArr);
    }
}
