package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.nl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2740nl extends MessageNano {
    public static volatile C2740nl[] b;
    public C2716ml[] a;

    public C2740nl() {
        a();
    }

    public static C2740nl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new C2740nl[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final C2740nl a() {
        this.a = C2716ml.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2716ml[] c2716mlArr = this.a;
        if (c2716mlArr != null && c2716mlArr.length > 0) {
            int i = 0;
            while (true) {
                C2716ml[] c2716mlArr2 = this.a;
                if (i >= c2716mlArr2.length) {
                    break;
                }
                C2716ml c2716ml = c2716mlArr2[i];
                if (c2716ml != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c2716ml) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2716ml[] c2716mlArr = this.a;
        if (c2716mlArr != null && c2716mlArr.length > 0) {
            int i = 0;
            while (true) {
                C2716ml[] c2716mlArr2 = this.a;
                if (i >= c2716mlArr2.length) {
                    break;
                }
                C2716ml c2716ml = c2716mlArr2[i];
                if (c2716ml != null) {
                    codedOutputByteBufferNano.writeMessage(1, c2716ml);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2740nl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                C2716ml[] c2716mlArr = this.a;
                int length = c2716mlArr == null ? 0 : c2716mlArr.length;
                int i = repeatedFieldArrayLength + length;
                C2716ml[] c2716mlArr2 = new C2716ml[i];
                if (length != 0) {
                    System.arraycopy(c2716mlArr, 0, c2716mlArr2, 0, length);
                }
                while (length < i - 1) {
                    C2716ml c2716ml = new C2716ml();
                    c2716mlArr2[length] = c2716ml;
                    codedInputByteBufferNano.readMessage(c2716ml);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2716ml c2716ml2 = new C2716ml();
                c2716mlArr2[length] = c2716ml2;
                codedInputByteBufferNano.readMessage(c2716ml2);
                this.a = c2716mlArr2;
            }
        }
    }

    public static C2740nl b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2740nl().mergeFrom(codedInputByteBufferNano);
    }

    public static C2740nl a(byte[] bArr) {
        return (C2740nl) MessageNano.mergeFrom(new C2740nl(), bArr);
    }
}
