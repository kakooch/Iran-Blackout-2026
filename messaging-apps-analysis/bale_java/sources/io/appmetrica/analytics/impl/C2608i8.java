package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* renamed from: io.appmetrica.analytics.impl.i8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2608i8 extends MessageNano {
    public static volatile C2608i8[] h;
    public byte[] a;
    public byte[] b;
    public C2412a8 c;
    public C2560g8 d;
    public C2584h8 e;
    public C2584h8 f;
    public C2631j8[] g;

    public C2608i8() {
        a();
    }

    public static C2608i8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (h == null) {
                        h = new C2608i8[0];
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public final C2608i8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = C2631j8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C2412a8 c2412a8 = this.c;
        if (c2412a8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c2412a8);
        }
        C2560g8 c2560g8 = this.d;
        if (c2560g8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c2560g8);
        }
        C2584h8 c2584h8 = this.e;
        if (c2584h8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c2584h8);
        }
        C2584h8 c2584h82 = this.f;
        if (c2584h82 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, c2584h82);
        }
        C2631j8[] c2631j8Arr = this.g;
        if (c2631j8Arr != null && c2631j8Arr.length > 0) {
            int i = 0;
            while (true) {
                C2631j8[] c2631j8Arr2 = this.g;
                if (i >= c2631j8Arr2.length) {
                    break;
                }
                C2631j8 c2631j8 = c2631j8Arr2[i];
                if (c2631j8 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c2631j8) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        byte[] bArr = this.a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C2412a8 c2412a8 = this.c;
        if (c2412a8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c2412a8);
        }
        C2560g8 c2560g8 = this.d;
        if (c2560g8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c2560g8);
        }
        C2584h8 c2584h8 = this.e;
        if (c2584h8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c2584h8);
        }
        C2584h8 c2584h82 = this.f;
        if (c2584h82 != null) {
            codedOutputByteBufferNano.writeMessage(6, c2584h82);
        }
        C2631j8[] c2631j8Arr = this.g;
        if (c2631j8Arr != null && c2631j8Arr.length > 0) {
            int i = 0;
            while (true) {
                C2631j8[] c2631j8Arr2 = this.g;
                if (i >= c2631j8Arr2.length) {
                    break;
                }
                C2631j8 c2631j8 = c2631j8Arr2[i];
                if (c2631j8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c2631j8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2608i8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2608i8().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2608i8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readBytes();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C2412a8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C2560g8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag == 42) {
                if (this.e == null) {
                    this.e = new C2584h8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (tag == 50) {
                if (this.f == null) {
                    this.f = new C2584h8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C2631j8[] c2631j8Arr = this.g;
                int length = c2631j8Arr == null ? 0 : c2631j8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C2631j8[] c2631j8Arr2 = new C2631j8[i];
                if (length != 0) {
                    System.arraycopy(c2631j8Arr, 0, c2631j8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C2631j8 c2631j8 = new C2631j8();
                    c2631j8Arr2[length] = c2631j8;
                    codedInputByteBufferNano.readMessage(c2631j8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C2631j8 c2631j82 = new C2631j8();
                c2631j8Arr2[length] = c2631j82;
                codedInputByteBufferNano.readMessage(c2631j82);
                this.g = c2631j8Arr2;
            }
        }
    }

    public static C2608i8 a(byte[] bArr) {
        return (C2608i8) MessageNano.mergeFrom(new C2608i8(), bArr);
    }
}
