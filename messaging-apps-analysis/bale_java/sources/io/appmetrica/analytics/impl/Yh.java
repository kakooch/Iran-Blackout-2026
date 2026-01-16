package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class Yh extends MessageNano {
    public static volatile Yh[] d;
    public boolean a;
    public Xh b;
    public Wh c;

    public Yh() {
        a();
    }

    public static Yh[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (d == null) {
                        d = new Yh[0];
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public final Yh a() {
        this.a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.a;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        Xh xh = this.b;
        if (xh != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, xh);
        }
        Wh wh = this.c;
        return wh != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, wh) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        Xh xh = this.b;
        if (xh != null) {
            codedOutputByteBufferNano.writeMessage(2, xh);
        }
        Wh wh = this.c;
        if (wh != null) {
            codedOutputByteBufferNano.writeMessage(3, wh);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Yh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.a = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new Xh();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.c == null) {
                    this.c = new Wh();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
    }

    public static Yh b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Yh().mergeFrom(codedInputByteBufferNano);
    }

    public static Yh a(byte[] bArr) {
        return (Yh) MessageNano.mergeFrom(new Yh(), bArr);
    }
}
