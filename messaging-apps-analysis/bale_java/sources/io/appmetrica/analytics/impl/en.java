package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class en extends MessageNano {
    public static volatile en[] b;
    public C2452bn[] a;

    public en() {
        a();
    }

    public static en[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new en[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final en a() {
        this.a = C2452bn.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2452bn[] c2452bnArr = this.a;
        if (c2452bnArr != null && c2452bnArr.length > 0) {
            int i = 0;
            while (true) {
                C2452bn[] c2452bnArr2 = this.a;
                if (i >= c2452bnArr2.length) {
                    break;
                }
                C2452bn c2452bn = c2452bnArr2[i];
                if (c2452bn != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c2452bn) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2452bn[] c2452bnArr = this.a;
        if (c2452bnArr != null && c2452bnArr.length > 0) {
            int i = 0;
            while (true) {
                C2452bn[] c2452bnArr2 = this.a;
                if (i >= c2452bnArr2.length) {
                    break;
                }
                C2452bn c2452bn = c2452bnArr2[i];
                if (c2452bn != null) {
                    codedOutputByteBufferNano.writeMessage(1, c2452bn);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final en mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                C2452bn[] c2452bnArr = this.a;
                int length = c2452bnArr == null ? 0 : c2452bnArr.length;
                int i = repeatedFieldArrayLength + length;
                C2452bn[] c2452bnArr2 = new C2452bn[i];
                if (length != 0) {
                    System.arraycopy(c2452bnArr, 0, c2452bnArr2, 0, length);
                }
                while (length < i - 1) {
                    C2452bn c2452bn = new C2452bn();
                    c2452bnArr2[length] = c2452bn;
                    codedInputByteBufferNano.readMessage(c2452bn);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2452bn c2452bn2 = new C2452bn();
                c2452bnArr2[length] = c2452bn2;
                codedInputByteBufferNano.readMessage(c2452bn2);
                this.a = c2452bnArr2;
            }
        }
    }

    public static en b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new en().mergeFrom(codedInputByteBufferNano);
    }

    public static en a(byte[] bArr) {
        return (en) MessageNano.mergeFrom(new en(), bArr);
    }
}
