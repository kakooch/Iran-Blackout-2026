package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import org.xbill.DNS.Type;

/* renamed from: io.appmetrica.analytics.impl.l7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2678l7 extends MessageNano {
    public static volatile C2678l7[] k;
    public int a;
    public double b;
    public double c;
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public String i;
    public String j;

    public C2678l7() {
        a();
    }

    public static C2678l7[] b() {
        if (k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (k == null) {
                        k = new C2678l7[0];
                    }
                } finally {
                }
            }
        }
        return k;
    }

    public final C2678l7 a() {
        this.a = -1;
        this.b = -1.0d;
        this.c = -1.0d;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1L;
        this.i = "";
        this.j = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.a;
        if (i != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(-1.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(-1.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.c);
        }
        int i2 = this.d;
        if (i2 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
        }
        int i3 = this.e;
        if (i3 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        int i4 = this.f;
        if (i4 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        int i5 = this.g;
        if (i5 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i5);
        }
        long j = this.h;
        if (j != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j);
        }
        if (!this.i.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.i);
        }
        return !this.j.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.j) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.a;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(-1.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.b);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(-1.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.c);
        }
        int i2 = this.d;
        if (i2 != -1) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        int i3 = this.e;
        if (i3 != -1) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        int i4 = this.f;
        if (i4 != -1) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        int i5 = this.g;
        if (i5 != -1) {
            codedOutputByteBufferNano.writeInt32(7, i5);
        }
        long j = this.h;
        if (j != -1) {
            codedOutputByteBufferNano.writeInt64(8, j);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.i);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2678l7 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2678l7().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2678l7 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != -1 && int32 != 0 && int32 != 1) {
                        break;
                    } else {
                        this.a = int32;
                        break;
                    }
                    break;
                case 17:
                    this.b = codedInputByteBufferNano.readDouble();
                    break;
                case 25:
                    this.c = codedInputByteBufferNano.readDouble();
                    break;
                case 32:
                    this.d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.e = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.f = codedInputByteBufferNano.readInt32();
                    break;
                case Type.NINFO /* 56 */:
                    this.g = codedInputByteBufferNano.readInt32();
                    break;
                case 64:
                    this.h = codedInputByteBufferNano.readInt64();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static C2678l7 a(byte[] bArr) {
        return (C2678l7) MessageNano.mergeFrom(new C2678l7(), bArr);
    }
}
