package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* renamed from: io.appmetrica.analytics.impl.l8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2679l8 extends MessageNano {
    public static volatile C2679l8[] e;
    public byte[] a;
    public C2412a8 b;
    public byte[] c;
    public C2560g8 d;

    public C2679l8() {
        a();
    }

    public static C2679l8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (e == null) {
                        e = new C2679l8[0];
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public final C2679l8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.a = bArr;
        this.b = null;
        this.c = bArr;
        this.d = null;
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
        C2412a8 c2412a8 = this.b;
        if (c2412a8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c2412a8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        C2560g8 c2560g8 = this.d;
        return c2560g8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, c2560g8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        byte[] bArr = this.a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        C2412a8 c2412a8 = this.b;
        if (c2412a8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c2412a8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        C2560g8 c2560g8 = this.d;
        if (c2560g8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c2560g8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2679l8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readBytes();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C2412a8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 26) {
                this.c = codedInputByteBufferNano.readBytes();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.d == null) {
                    this.d = new C2560g8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
    }

    public static C2679l8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2679l8().mergeFrom(codedInputByteBufferNano);
    }

    public static C2679l8 a(byte[] bArr) {
        return (C2679l8) MessageNano.mergeFrom(new C2679l8(), bArr);
    }
}
