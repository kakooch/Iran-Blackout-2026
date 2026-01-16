package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.e9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2513e9 extends MessageNano {
    public static final int f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static volatile C2513e9[] i;
    public C2438b9[] a;
    public W8 b;
    public T8[] c;
    public C2463c9[] d;
    public String[] e;

    public C2513e9() {
        a();
    }

    public static C2513e9[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (i == null) {
                        i = new C2513e9[0];
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public final C2513e9 a() {
        this.a = C2438b9.b();
        this.b = null;
        this.c = T8.b();
        this.d = C2463c9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2438b9[] c2438b9Arr = this.a;
        int i2 = 0;
        if (c2438b9Arr != null && c2438b9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C2438b9[] c2438b9Arr2 = this.a;
                if (i3 >= c2438b9Arr2.length) {
                    break;
                }
                C2438b9 c2438b9 = c2438b9Arr2[i3];
                if (c2438b9 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(3, c2438b9) + iComputeSerializedSize;
                }
                i3++;
            }
        }
        W8 w8 = this.b;
        if (w8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, w8);
        }
        T8[] t8Arr = this.c;
        if (t8Arr != null && t8Arr.length > 0) {
            int i4 = 0;
            while (true) {
                T8[] t8Arr2 = this.c;
                if (i4 >= t8Arr2.length) {
                    break;
                }
                T8 t8 = t8Arr2[i4];
                if (t8 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, t8) + iComputeSerializedSize;
                }
                i4++;
            }
        }
        C2463c9[] c2463c9Arr = this.d;
        if (c2463c9Arr != null && c2463c9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C2463c9[] c2463c9Arr2 = this.d;
                if (i5 >= c2463c9Arr2.length) {
                    break;
                }
                C2463c9 c2463c9 = c2463c9Arr2[i5];
                if (c2463c9 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, c2463c9) + iComputeSerializedSize;
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i6 = 0;
        while (true) {
            String[] strArr2 = this.e;
            if (i2 >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + i6;
            }
            String str = strArr2[i2];
            if (str != null) {
                i6++;
                iComputeStringSizeNoTag = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + iComputeStringSizeNoTag;
            }
            i2++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2438b9[] c2438b9Arr = this.a;
        int i2 = 0;
        if (c2438b9Arr != null && c2438b9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C2438b9[] c2438b9Arr2 = this.a;
                if (i3 >= c2438b9Arr2.length) {
                    break;
                }
                C2438b9 c2438b9 = c2438b9Arr2[i3];
                if (c2438b9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c2438b9);
                }
                i3++;
            }
        }
        W8 w8 = this.b;
        if (w8 != null) {
            codedOutputByteBufferNano.writeMessage(4, w8);
        }
        T8[] t8Arr = this.c;
        if (t8Arr != null && t8Arr.length > 0) {
            int i4 = 0;
            while (true) {
                T8[] t8Arr2 = this.c;
                if (i4 >= t8Arr2.length) {
                    break;
                }
                T8 t8 = t8Arr2[i4];
                if (t8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, t8);
                }
                i4++;
            }
        }
        C2463c9[] c2463c9Arr = this.d;
        if (c2463c9Arr != null && c2463c9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C2463c9[] c2463c9Arr2 = this.d;
                if (i5 >= c2463c9Arr2.length) {
                    break;
                }
                C2463c9 c2463c9 = c2463c9Arr2[i5];
                if (c2463c9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c2463c9);
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.e;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2513e9 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2513e9().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2513e9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C2438b9[] c2438b9Arr = this.a;
                int length = c2438b9Arr == null ? 0 : c2438b9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C2438b9[] c2438b9Arr2 = new C2438b9[i2];
                if (length != 0) {
                    System.arraycopy(c2438b9Arr, 0, c2438b9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C2438b9 c2438b9 = new C2438b9();
                    c2438b9Arr2[length] = c2438b9;
                    codedInputByteBufferNano.readMessage(c2438b9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2438b9 c2438b92 = new C2438b9();
                c2438b9Arr2[length] = c2438b92;
                codedInputByteBufferNano.readMessage(c2438b92);
                this.a = c2438b9Arr2;
            } else if (tag == 34) {
                if (this.b == null) {
                    this.b = new W8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                T8[] t8Arr = this.c;
                int length2 = t8Arr == null ? 0 : t8Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                T8[] t8Arr2 = new T8[i3];
                if (length2 != 0) {
                    System.arraycopy(t8Arr, 0, t8Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    T8 t8 = new T8();
                    t8Arr2[length2] = t8;
                    codedInputByteBufferNano.readMessage(t8);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                T8 t82 = new T8();
                t8Arr2[length2] = t82;
                codedInputByteBufferNano.readMessage(t82);
                this.c = t8Arr2;
            } else if (tag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                C2463c9[] c2463c9Arr = this.d;
                int length3 = c2463c9Arr == null ? 0 : c2463c9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                C2463c9[] c2463c9Arr2 = new C2463c9[i4];
                if (length3 != 0) {
                    System.arraycopy(c2463c9Arr, 0, c2463c9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    C2463c9 c2463c9 = new C2463c9();
                    c2463c9Arr2[length3] = c2463c9;
                    codedInputByteBufferNano.readMessage(c2463c9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                C2463c9 c2463c92 = new C2463c9();
                c2463c9Arr2[length3] = c2463c92;
                codedInputByteBufferNano.readMessage(c2463c92);
                this.d = c2463c9Arr2;
            } else if (tag != 90) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                String[] strArr = this.e;
                int length4 = strArr == null ? 0 : strArr.length;
                int i5 = repeatedFieldArrayLength4 + length4;
                String[] strArr2 = new String[i5];
                if (length4 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length4);
                }
                while (length4 < i5 - 1) {
                    strArr2[length4] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length4++;
                }
                strArr2[length4] = codedInputByteBufferNano.readString();
                this.e = strArr2;
            }
        }
    }

    public static C2513e9 a(byte[] bArr) {
        return (C2513e9) MessageNano.mergeFrom(new C2513e9(), bArr);
    }
}
