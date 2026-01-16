package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.a9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2413a9 extends MessageNano {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static volatile C2413a9[] g;
    public C2488d9 a;
    public String b;
    public int c;

    public C2413a9() {
        a();
    }

    public static C2413a9[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (g == null) {
                        g = new C2413a9[0];
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final C2413a9 a() {
        this.a = null;
        this.b = "";
        this.c = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2488d9 c2488d9 = this.a;
        if (c2488d9 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c2488d9);
        }
        int iComputeStringSize = CodedOutputByteBufferNano.computeStringSize(2, this.b) + iComputeSerializedSize;
        int i = this.c;
        return i != 0 ? iComputeStringSize + CodedOutputByteBufferNano.computeInt32Size(5, i) : iComputeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2488d9 c2488d9 = this.a;
        if (c2488d9 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2488d9);
        }
        codedOutputByteBufferNano.writeString(2, this.b);
        int i = this.c;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2413a9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new C2488d9();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.c = int32;
                }
            }
        }
    }

    public static C2413a9 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2413a9().mergeFrom(codedInputByteBufferNano);
    }

    public static C2413a9 a(byte[] bArr) {
        return (C2413a9) MessageNano.mergeFrom(new C2413a9(), bArr);
    }
}
