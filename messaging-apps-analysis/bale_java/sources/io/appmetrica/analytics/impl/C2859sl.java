package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.sl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2859sl extends MessageNano {
    public static volatile C2859sl[] g;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;

    public C2859sl() {
        a();
    }

    public static C2859sl[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (g == null) {
                        g = new C2859sl[0];
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final C2859sl a() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeBoolSize = CodedOutputByteBufferNano.computeBoolSize(4, this.d) + CodedOutputByteBufferNano.computeBoolSize(3, this.c) + CodedOutputByteBufferNano.computeBoolSize(2, this.b) + CodedOutputByteBufferNano.computeBoolSize(1, this.a) + super.computeSerializedSize();
        boolean z = this.e;
        if (z) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i = this.f;
        return i != -1 ? iComputeBoolSize + CodedOutputByteBufferNano.computeInt32Size(6, i) : iComputeBoolSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
        codedOutputByteBufferNano.writeBool(1, this.a);
        codedOutputByteBufferNano.writeBool(2, this.b);
        codedOutputByteBufferNano.writeBool(3, this.c);
        codedOutputByteBufferNano.writeBool(4, this.d);
        boolean z = this.e;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i = this.f;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2859sl b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2859sl().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2859sl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.a = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readBool();
            } else if (tag == 24) {
                this.c = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.d = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.e = codedInputByteBufferNano.readBool();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == -1 || int32 == 0 || int32 == 1) {
                    this.f = int32;
                }
            }
        }
    }

    public static C2859sl a(byte[] bArr) {
        return (C2859sl) MessageNano.mergeFrom(new C2859sl(), bArr);
    }
}
