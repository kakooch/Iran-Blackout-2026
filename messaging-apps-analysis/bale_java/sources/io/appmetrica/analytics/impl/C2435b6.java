package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.b6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2435b6 extends MessageNano {
    public static volatile C2435b6[] g;
    public String a;
    public int b;
    public long c;
    public String d;
    public int e;
    public C2410a6[] f;

    public C2435b6() {
        a();
    }

    public static C2435b6[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (g == null) {
                        g = new C2435b6[0];
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final C2435b6 a() {
        this.a = "";
        this.b = 0;
        this.c = 0L;
        this.d = "";
        this.e = 0;
        this.f = C2410a6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSInt64Size = CodedOutputByteBufferNano.computeSInt64Size(3, this.c) + CodedOutputByteBufferNano.computeSInt32Size(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.a) + super.computeSerializedSize();
        if (!this.d.equals("")) {
            iComputeSInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            iComputeSInt64Size += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        C2410a6[] c2410a6Arr = this.f;
        if (c2410a6Arr != null && c2410a6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C2410a6[] c2410a6Arr2 = this.f;
                if (i2 >= c2410a6Arr2.length) {
                    break;
                }
                C2410a6 c2410a6 = c2410a6Arr2[i2];
                if (c2410a6 != null) {
                    iComputeSInt64Size = CodedOutputByteBufferNano.computeMessageSize(6, c2410a6) + iComputeSInt64Size;
                }
                i2++;
            }
        }
        return iComputeSInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        codedOutputByteBufferNano.writeString(1, this.a);
        codedOutputByteBufferNano.writeSInt32(2, this.b);
        codedOutputByteBufferNano.writeSInt64(3, this.c);
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        C2410a6[] c2410a6Arr = this.f;
        if (c2410a6Arr != null && c2410a6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C2410a6[] c2410a6Arr2 = this.f;
                if (i2 >= c2410a6Arr2.length) {
                    break;
                }
                C2410a6 c2410a6 = c2410a6Arr2[i2];
                if (c2410a6 != null) {
                    codedOutputByteBufferNano.writeMessage(6, c2410a6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2435b6 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2435b6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2435b6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readSInt32();
            } else if (tag == 24) {
                this.c = codedInputByteBufferNano.readSInt64();
            } else if (tag == 34) {
                this.d = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.e = codedInputByteBufferNano.readUInt32();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                C2410a6[] c2410a6Arr = this.f;
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
                this.f = c2410a6Arr2;
            }
        }
    }

    public static C2435b6 a(byte[] bArr) {
        return (C2435b6) MessageNano.mergeFrom(new C2435b6(), bArr);
    }
}
