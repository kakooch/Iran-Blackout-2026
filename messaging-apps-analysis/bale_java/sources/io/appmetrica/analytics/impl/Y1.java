package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class Y1 extends MessageNano {
    public static volatile Y1[] d;
    public X1[] a;
    public W1 b;
    public String[] c;

    public Y1() {
        a();
    }

    public static Y1[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (d == null) {
                        d = new Y1[0];
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public final Y1 a() {
        this.a = X1.b();
        this.b = null;
        this.c = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        X1[] x1Arr = this.a;
        int i = 0;
        if (x1Arr != null && x1Arr.length > 0) {
            int i2 = 0;
            while (true) {
                X1[] x1Arr2 = this.a;
                if (i2 >= x1Arr2.length) {
                    break;
                }
                X1 x1 = x1Arr2[i2];
                if (x1 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, x1) + iComputeSerializedSize;
                }
                i2++;
            }
        }
        W1 w1 = this.b;
        if (w1 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, w1);
        }
        String[] strArr = this.c;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.c;
            if (i >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + i3;
            }
            String str = strArr2[i];
            if (str != null) {
                i3++;
                iComputeStringSizeNoTag = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + iComputeStringSizeNoTag;
            }
            i++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        X1[] x1Arr = this.a;
        int i = 0;
        if (x1Arr != null && x1Arr.length > 0) {
            int i2 = 0;
            while (true) {
                X1[] x1Arr2 = this.a;
                if (i2 >= x1Arr2.length) {
                    break;
                }
                X1 x1 = x1Arr2[i2];
                if (x1 != null) {
                    codedOutputByteBufferNano.writeMessage(1, x1);
                }
                i2++;
            }
        }
        W1 w1 = this.b;
        if (w1 != null) {
            codedOutputByteBufferNano.writeMessage(2, w1);
        }
        String[] strArr = this.c;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.c;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y1 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                X1[] x1Arr = this.a;
                int length = x1Arr == null ? 0 : x1Arr.length;
                int i = repeatedFieldArrayLength + length;
                X1[] x1Arr2 = new X1[i];
                if (length != 0) {
                    System.arraycopy(x1Arr, 0, x1Arr2, 0, length);
                }
                while (length < i - 1) {
                    X1 x1 = new X1();
                    x1Arr2[length] = x1;
                    codedInputByteBufferNano.readMessage(x1);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                X1 x12 = new X1();
                x1Arr2[length] = x12;
                codedInputByteBufferNano.readMessage(x12);
                this.a = x1Arr2;
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new W1();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                String[] strArr = this.c;
                int length2 = strArr == null ? 0 : strArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                String[] strArr2 = new String[i2];
                if (length2 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr2[length2] = codedInputByteBufferNano.readString();
                this.c = strArr2;
            }
        }
    }

    public static Y1 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Y1().mergeFrom(codedInputByteBufferNano);
    }

    public static Y1 a(byte[] bArr) {
        return (Y1) MessageNano.mergeFrom(new Y1(), bArr);
    }
}
