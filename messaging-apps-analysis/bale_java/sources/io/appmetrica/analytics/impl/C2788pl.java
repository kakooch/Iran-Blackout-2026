package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.pl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2788pl extends MessageNano {
    public static volatile C2788pl[] b;
    public long a;

    public C2788pl() {
        a();
    }

    public static C2788pl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (b == null) {
                        b = new C2788pl[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final C2788pl a() {
        this.a = 10000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.a;
        return j != 10000 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, j) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.a;
        if (j != 10000) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2788pl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.a = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static C2788pl a(byte[] bArr) {
        return (C2788pl) MessageNano.mergeFrom(new C2788pl(), bArr);
    }

    public static C2788pl b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2788pl().mergeFrom(codedInputByteBufferNano);
    }
}
