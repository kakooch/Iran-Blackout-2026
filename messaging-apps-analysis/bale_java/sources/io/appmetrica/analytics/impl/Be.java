package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class Be extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile Be[] g;
    public C3020ze a;
    public Ae[] b;

    public Be() {
        a();
    }

    public static Be[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (g == null) {
                        g = new Be[0];
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final Be a() {
        this.a = null;
        this.b = Ae.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C3020ze c3020ze = this.a;
        if (c3020ze != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c3020ze);
        }
        Ae[] aeArr = this.b;
        if (aeArr != null && aeArr.length > 0) {
            int i = 0;
            while (true) {
                Ae[] aeArr2 = this.b;
                if (i >= aeArr2.length) {
                    break;
                }
                Ae ae = aeArr2[i];
                if (ae != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, ae) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C3020ze c3020ze = this.a;
        if (c3020ze != null) {
            codedOutputByteBufferNano.writeMessage(1, c3020ze);
        }
        Ae[] aeArr = this.b;
        if (aeArr != null && aeArr.length > 0) {
            int i = 0;
            while (true) {
                Ae[] aeArr2 = this.b;
                if (i >= aeArr2.length) {
                    break;
                }
                Ae ae = aeArr2[i];
                if (ae != null) {
                    codedOutputByteBufferNano.writeMessage(2, ae);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Be mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new C3020ze();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Ae[] aeArr = this.b;
                int length = aeArr == null ? 0 : aeArr.length;
                int i = repeatedFieldArrayLength + length;
                Ae[] aeArr2 = new Ae[i];
                if (length != 0) {
                    System.arraycopy(aeArr, 0, aeArr2, 0, length);
                }
                while (length < i - 1) {
                    Ae ae = new Ae();
                    aeArr2[length] = ae;
                    codedInputByteBufferNano.readMessage(ae);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Ae ae2 = new Ae();
                aeArr2[length] = ae2;
                codedInputByteBufferNano.readMessage(ae2);
                this.b = aeArr2;
            }
        }
    }

    public static Be b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Be().mergeFrom(codedInputByteBufferNano);
    }

    public static Be a(byte[] bArr) {
        return (Be) MessageNano.mergeFrom(new Be(), bArr);
    }
}
