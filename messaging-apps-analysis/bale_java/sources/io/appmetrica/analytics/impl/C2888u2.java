package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.u2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2888u2 extends MessageNano {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static volatile C2888u2[] f;
    public C2864t2[] a;
    public boolean b;

    public C2888u2() {
        a();
    }

    public static C2888u2[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (f == null) {
                        f = new C2888u2[0];
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public final C2888u2 a() {
        this.a = C2864t2.b();
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2864t2[] c2864t2Arr = this.a;
        if (c2864t2Arr != null && c2864t2Arr.length > 0) {
            int i = 0;
            while (true) {
                C2864t2[] c2864t2Arr2 = this.a;
                if (i >= c2864t2Arr2.length) {
                    break;
                }
                C2864t2 c2864t2 = c2864t2Arr2[i];
                if (c2864t2 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c2864t2) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return CodedOutputByteBufferNano.computeBoolSize(2, this.b) + iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2864t2[] c2864t2Arr = this.a;
        if (c2864t2Arr != null && c2864t2Arr.length > 0) {
            int i = 0;
            while (true) {
                C2864t2[] c2864t2Arr2 = this.a;
                if (i >= c2864t2Arr2.length) {
                    break;
                }
                C2864t2 c2864t2 = c2864t2Arr2[i];
                if (c2864t2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c2864t2);
                }
                i++;
            }
        }
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2888u2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C2864t2[] c2864t2Arr = this.a;
                int length = c2864t2Arr == null ? 0 : c2864t2Arr.length;
                int i = repeatedFieldArrayLength + length;
                C2864t2[] c2864t2Arr2 = new C2864t2[i];
                if (length != 0) {
                    System.arraycopy(c2864t2Arr, 0, c2864t2Arr2, 0, length);
                }
                while (length < i - 1) {
                    C2864t2 c2864t2 = new C2864t2();
                    c2864t2Arr2[length] = c2864t2;
                    codedInputByteBufferNano.readMessage(c2864t2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2864t2 c2864t22 = new C2864t2();
                c2864t2Arr2[length] = c2864t22;
                codedInputByteBufferNano.readMessage(c2864t22);
                this.a = c2864t2Arr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static C2888u2 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2888u2().mergeFrom(codedInputByteBufferNano);
    }

    public static C2888u2 a(byte[] bArr) {
        return (C2888u2) MessageNano.mergeFrom(new C2888u2(), bArr);
    }
}
