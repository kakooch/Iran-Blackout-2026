package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class O3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile O3[] g;
    public L3 a;
    public L3[] b;

    public O3() {
        a();
    }

    public static O3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (g == null) {
                        g = new O3[0];
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final O3 a() {
        this.a = null;
        this.b = L3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        L3 l3 = this.a;
        if (l3 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, l3);
        }
        L3[] l3Arr = this.b;
        if (l3Arr != null && l3Arr.length > 0) {
            int i = 0;
            while (true) {
                L3[] l3Arr2 = this.b;
                if (i >= l3Arr2.length) {
                    break;
                }
                L3 l32 = l3Arr2[i];
                if (l32 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, l32) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        L3 l3 = this.a;
        if (l3 != null) {
            codedOutputByteBufferNano.writeMessage(1, l3);
        }
        L3[] l3Arr = this.b;
        if (l3Arr != null && l3Arr.length > 0) {
            int i = 0;
            while (true) {
                L3[] l3Arr2 = this.b;
                if (i >= l3Arr2.length) {
                    break;
                }
                L3 l32 = l3Arr2[i];
                if (l32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, l32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final O3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new L3();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                L3[] l3Arr = this.b;
                int length = l3Arr == null ? 0 : l3Arr.length;
                int i = repeatedFieldArrayLength + length;
                L3[] l3Arr2 = new L3[i];
                if (length != 0) {
                    System.arraycopy(l3Arr, 0, l3Arr2, 0, length);
                }
                while (length < i - 1) {
                    L3 l3 = new L3();
                    l3Arr2[length] = l3;
                    codedInputByteBufferNano.readMessage(l3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                L3 l32 = new L3();
                l3Arr2[length] = l32;
                codedInputByteBufferNano.readMessage(l32);
                this.b = l3Arr2;
            }
        }
    }

    public static O3 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new O3().mergeFrom(codedInputByteBufferNano);
    }

    public static O3 a(byte[] bArr) {
        return (O3) MessageNano.mergeFrom(new O3(), bArr);
    }
}
