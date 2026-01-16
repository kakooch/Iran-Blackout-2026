package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;
import org.xbill.DNS.WKSRecord;

/* renamed from: io.appmetrica.analytics.impl.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2861t extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 6;
    public static volatile C2861t[] s;
    public static byte[] t;
    public static volatile boolean u;
    public byte[] a;
    public C2837s b;
    public byte[] c;
    public int d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;

    public C2861t() {
        if (!u) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (!u) {
                        t = InternalNano.bytesDefaultValue("manual");
                        u = true;
                    }
                } finally {
                }
            }
        }
        a();
    }

    public static C2861t[] b() {
        if (s == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (s == null) {
                        s = new C2861t[0];
                    }
                } finally {
                }
            }
        }
        return s;
    }

    public final C2861t a() {
        this.a = (byte[]) t.clone();
        this.b = null;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.c = bArr;
        this.d = 0;
        this.e = bArr;
        this.f = bArr;
        this.g = bArr;
        this.h = bArr;
        this.i = bArr;
        this.j = bArr;
        this.k = bArr;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.a, t)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
        }
        C2837s c2837s = this.b;
        if (c2837s != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c2837s);
        }
        byte[] bArr = this.c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        int i = this.d;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f);
        }
        if (!Arrays.equals(this.g, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.g);
        }
        if (!Arrays.equals(this.h, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        return !Arrays.equals(this.k, bArr2) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(11, this.k) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!Arrays.equals(this.a, t)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        C2837s c2837s = this.b;
        if (c2837s != null) {
            codedOutputByteBufferNano.writeMessage(2, c2837s);
        }
        byte[] bArr = this.c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.f);
        }
        if (!Arrays.equals(this.g, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.g);
        }
        if (!Arrays.equals(this.h, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, bArr2)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        if (!Arrays.equals(this.k, bArr2)) {
            codedOutputByteBufferNano.writeBytes(11, this.k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2861t b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2861t().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2861t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.a = codedInputByteBufferNano.readBytes();
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C2837s();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readBytes();
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.d = int32;
                            break;
                    }
                case 42:
                    this.e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    this.g = codedInputByteBufferNano.readBytes();
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    this.h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                    this.j = codedInputByteBufferNano.readBytes();
                    break;
                case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                    this.k = codedInputByteBufferNano.readBytes();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static C2861t a(byte[] bArr) {
        return (C2861t) MessageNano.mergeFrom(new C2861t(), bArr);
    }
}
