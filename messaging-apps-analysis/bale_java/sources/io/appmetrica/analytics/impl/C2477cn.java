package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.cn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2477cn extends MessageNano {
    public static volatile C2477cn[] c;
    public boolean a;
    public boolean b;

    public C2477cn() {
        a();
    }

    public static C2477cn[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new C2477cn[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2477cn a() {
        this.a = false;
        this.b = false;
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
        boolean z2 = this.b;
        return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
        boolean z = this.a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.b;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2477cn mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.a = codedInputByteBufferNano.readBool();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static C2477cn b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2477cn().mergeFrom(codedInputByteBufferNano);
    }

    public static C2477cn a(byte[] bArr) {
        return (C2477cn) MessageNano.mergeFrom(new C2477cn(), bArr);
    }
}
