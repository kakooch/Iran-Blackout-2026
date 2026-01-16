package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class S5 extends MessageNano {
    public static volatile S5[] d;
    public C2435b6 a;
    public C2435b6[] b;
    public String c;

    public S5() {
        a();
    }

    public static S5[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (d == null) {
                        d = new S5[0];
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public final S5 a() {
        this.a = null;
        this.b = C2435b6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2435b6 c2435b6 = this.a;
        if (c2435b6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c2435b6);
        }
        C2435b6[] c2435b6Arr = this.b;
        if (c2435b6Arr != null && c2435b6Arr.length > 0) {
            int i = 0;
            while (true) {
                C2435b6[] c2435b6Arr2 = this.b;
                if (i >= c2435b6Arr2.length) {
                    break;
                }
                C2435b6 c2435b62 = c2435b6Arr2[i];
                if (c2435b62 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c2435b62) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return !this.c.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.c) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2435b6 c2435b6 = this.a;
        if (c2435b6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2435b6);
        }
        C2435b6[] c2435b6Arr = this.b;
        if (c2435b6Arr != null && c2435b6Arr.length > 0) {
            int i = 0;
            while (true) {
                C2435b6[] c2435b6Arr2 = this.b;
                if (i >= c2435b6Arr2.length) {
                    break;
                }
                C2435b6 c2435b62 = c2435b6Arr2[i];
                if (c2435b62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c2435b62);
                }
                i++;
            }
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final S5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new C2435b6();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C2435b6[] c2435b6Arr = this.b;
                int length = c2435b6Arr == null ? 0 : c2435b6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C2435b6[] c2435b6Arr2 = new C2435b6[i];
                if (length != 0) {
                    System.arraycopy(c2435b6Arr, 0, c2435b6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C2435b6 c2435b6 = new C2435b6();
                    c2435b6Arr2[length] = c2435b6;
                    codedInputByteBufferNano.readMessage(c2435b6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2435b6 c2435b62 = new C2435b6();
                c2435b6Arr2[length] = c2435b62;
                codedInputByteBufferNano.readMessage(c2435b62);
                this.b = c2435b6Arr2;
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.c = codedInputByteBufferNano.readString();
            }
        }
    }

    public static S5 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new S5().mergeFrom(codedInputByteBufferNano);
    }

    public static S5 a(byte[] bArr) {
        return (S5) MessageNano.mergeFrom(new S5(), bArr);
    }
}
