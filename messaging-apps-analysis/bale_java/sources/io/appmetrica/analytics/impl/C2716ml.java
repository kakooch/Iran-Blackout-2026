package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.ml, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2716ml extends MessageNano {
    public static volatile C2716ml[] c;
    public String a;
    public C2692ll b;

    public C2716ml() {
        a();
    }

    public static C2716ml[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new C2716ml[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2716ml a() {
        this.a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        C2692ll c2692ll = this.b;
        return c2692ll != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c2692ll) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        C2692ll c2692ll = this.b;
        if (c2692ll != null) {
            codedOutputByteBufferNano.writeMessage(2, c2692ll);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2716ml mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new C2692ll();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C2716ml b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2716ml().mergeFrom(codedInputByteBufferNano);
    }

    public static C2716ml a(byte[] bArr) {
        return (C2716ml) MessageNano.mergeFrom(new C2716ml(), bArr);
    }
}
