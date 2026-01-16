package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* renamed from: io.appmetrica.analytics.impl.p8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2775p8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile C2775p8[] o;
    public int a;
    public C2751o8 b;
    public C2703m8 c;
    public C2727n8 d;
    public Y7 e;
    public C2512e8 f;

    public C2775p8() {
        a();
    }

    public static C2775p8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (o == null) {
                        o = new C2775p8[0];
                    }
                } finally {
                }
            }
        }
        return o;
    }

    public final C2775p8 a() {
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i2 = this.a;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        C2751o8 c2751o8 = this.b;
        if (c2751o8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c2751o8);
        }
        C2703m8 c2703m8 = this.c;
        if (c2703m8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c2703m8);
        }
        C2727n8 c2727n8 = this.d;
        if (c2727n8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c2727n8);
        }
        Y7 y7 = this.e;
        if (y7 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, y7);
        }
        C2512e8 c2512e8 = this.f;
        return c2512e8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, c2512e8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i2 = this.a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        C2751o8 c2751o8 = this.b;
        if (c2751o8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c2751o8);
        }
        C2703m8 c2703m8 = this.c;
        if (c2703m8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c2703m8);
        }
        C2727n8 c2727n8 = this.d;
        if (c2727n8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c2727n8);
        }
        Y7 y7 = this.e;
        if (y7 != null) {
            codedOutputByteBufferNano.writeMessage(5, y7);
        }
        C2512e8 c2512e8 = this.f;
        if (c2512e8 != null) {
            codedOutputByteBufferNano.writeMessage(6, c2512e8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2775p8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2775p8().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2775p8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.a = int32;
                        break;
                }
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C2751o8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C2703m8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C2727n8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag == 42) {
                if (this.e == null) {
                    this.e = new Y7();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.f == null) {
                    this.f = new C2512e8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            }
        }
    }

    public static C2775p8 a(byte[] bArr) {
        return (C2775p8) MessageNano.mergeFrom(new C2775p8(), bArr);
    }
}
