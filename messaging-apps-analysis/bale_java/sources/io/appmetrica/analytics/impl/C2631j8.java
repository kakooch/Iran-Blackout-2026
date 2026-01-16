package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* renamed from: io.appmetrica.analytics.impl.j8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2631j8 extends MessageNano {
    public static volatile C2631j8[] b;
    public byte[] a;

    public C2631j8() {
        a();
    }

    public static C2631j8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new C2631j8[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final C2631j8 a() {
        this.a = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(1, this.a) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2631j8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
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
                this.a = codedInputByteBufferNano.readBytes();
            }
        }
    }

    public static C2631j8 a(byte[] bArr) {
        return (C2631j8) MessageNano.mergeFrom(new C2631j8(), bArr);
    }

    public static C2631j8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2631j8().mergeFrom(codedInputByteBufferNano);
    }
}
