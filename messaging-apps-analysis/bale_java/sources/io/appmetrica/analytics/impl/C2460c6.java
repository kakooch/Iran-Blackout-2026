package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.c6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2460c6 extends MessageNano {
    public static volatile C2460c6[] f;
    public String a;
    public String b;
    public C2410a6[] c;
    public C2460c6 d;
    public C2460c6[] e;

    public C2460c6() {
        a();
    }

    public static C2460c6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (f == null) {
                        f = new C2460c6[0];
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public final C2460c6 a() {
        this.a = "";
        this.b = "";
        this.c = C2410a6.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            iComputeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C2410a6[] c2410a6Arr = this.c;
        int i = 0;
        if (c2410a6Arr != null && c2410a6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C2410a6[] c2410a6Arr2 = this.c;
                if (i2 >= c2410a6Arr2.length) {
                    break;
                }
                C2410a6 c2410a6 = c2410a6Arr2[i2];
                if (c2410a6 != null) {
                    iComputeStringSize = CodedOutputByteBufferNano.computeMessageSize(3, c2410a6) + iComputeStringSize;
                }
                i2++;
            }
        }
        C2460c6 c2460c6 = this.d;
        if (c2460c6 != null) {
            iComputeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, c2460c6);
        }
        C2460c6[] c2460c6Arr = this.e;
        if (c2460c6Arr != null && c2460c6Arr.length > 0) {
            while (true) {
                C2460c6[] c2460c6Arr2 = this.e;
                if (i >= c2460c6Arr2.length) {
                    break;
                }
                C2460c6 c2460c62 = c2460c6Arr2[i];
                if (c2460c62 != null) {
                    iComputeStringSize = CodedOutputByteBufferNano.computeMessageSize(5, c2460c62) + iComputeStringSize;
                }
                i++;
            }
        }
        return iComputeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        codedOutputByteBufferNano.writeString(1, this.a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C2410a6[] c2410a6Arr = this.c;
        int i = 0;
        if (c2410a6Arr != null && c2410a6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C2410a6[] c2410a6Arr2 = this.c;
                if (i2 >= c2410a6Arr2.length) {
                    break;
                }
                C2410a6 c2410a6 = c2410a6Arr2[i2];
                if (c2410a6 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c2410a6);
                }
                i2++;
            }
        }
        C2460c6 c2460c6 = this.d;
        if (c2460c6 != null) {
            codedOutputByteBufferNano.writeMessage(4, c2460c6);
        }
        C2460c6[] c2460c6Arr = this.e;
        if (c2460c6Arr != null && c2460c6Arr.length > 0) {
            while (true) {
                C2460c6[] c2460c6Arr2 = this.e;
                if (i >= c2460c6Arr2.length) {
                    break;
                }
                C2460c6 c2460c62 = c2460c6Arr2[i];
                if (c2460c62 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c2460c62);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2460c6 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2460c6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2460c6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C2410a6[] c2410a6Arr = this.c;
                int length = c2410a6Arr == null ? 0 : c2410a6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C2410a6[] c2410a6Arr2 = new C2410a6[i];
                if (length != 0) {
                    System.arraycopy(c2410a6Arr, 0, c2410a6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C2410a6 c2410a6 = new C2410a6();
                    c2410a6Arr2[length] = c2410a6;
                    codedInputByteBufferNano.readMessage(c2410a6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2410a6 c2410a62 = new C2410a6();
                c2410a6Arr2[length] = c2410a62;
                codedInputByteBufferNano.readMessage(c2410a62);
                this.c = c2410a6Arr2;
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C2460c6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C2460c6[] c2460c6Arr = this.e;
                int length2 = c2460c6Arr == null ? 0 : c2460c6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C2460c6[] c2460c6Arr2 = new C2460c6[i2];
                if (length2 != 0) {
                    System.arraycopy(c2460c6Arr, 0, c2460c6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C2460c6 c2460c6 = new C2460c6();
                    c2460c6Arr2[length2] = c2460c6;
                    codedInputByteBufferNano.readMessage(c2460c6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C2460c6 c2460c62 = new C2460c6();
                c2460c6Arr2[length2] = c2460c62;
                codedInputByteBufferNano.readMessage(c2460c62);
                this.e = c2460c6Arr2;
            }
        }
    }

    public static C2460c6 a(byte[] bArr) {
        return (C2460c6) MessageNano.mergeFrom(new C2460c6(), bArr);
    }
}
