package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.bn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2452bn extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile C2452bn[] i;
    public byte[] a;
    public int b;
    public C2477cn c;
    public C2502dn d;

    public C2452bn() {
        a();
    }

    public static C2452bn[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (i == null) {
                        i = new C2452bn[0];
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public final C2452bn a() {
        this.a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.a) + super.computeSerializedSize();
        C2477cn c2477cn = this.c;
        if (c2477cn != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c2477cn);
        }
        C2502dn c2502dn = this.d;
        return c2502dn != null ? iComputeInt32Size + CodedOutputByteBufferNano.computeMessageSize(4, c2502dn) : iComputeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        codedOutputByteBufferNano.writeBytes(1, this.a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        C2477cn c2477cn = this.c;
        if (c2477cn != null) {
            codedOutputByteBufferNano.writeMessage(3, c2477cn);
        }
        C2502dn c2502dn = this.d;
        if (c2502dn != null) {
            codedOutputByteBufferNano.writeMessage(4, c2502dn);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2452bn mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readBytes();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.b = int32;
                }
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C2477cn();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.d == null) {
                    this.d = new C2502dn();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
    }

    public static C2452bn b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2452bn().mergeFrom(codedInputByteBufferNano);
    }

    public static C2452bn a(byte[] bArr) {
        return (C2452bn) MessageNano.mergeFrom(new C2452bn(), bArr);
    }
}
