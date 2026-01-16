package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.util.Arrays;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class W5 extends MessageNano {
    public static final int k = 0;
    public static final int l = 1;
    public static volatile W5[] m;
    public static byte[] n;
    public static volatile boolean o;
    public C2460c6 a;
    public S5 b;
    public String c;
    public int d;
    public C2410a6[] e;
    public int f;
    public V5 g;
    public byte[] h;
    public byte[] i;
    public U5[] j;

    public W5() {
        if (!o) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (!o) {
                        n = InternalNano.bytesDefaultValue("JVM");
                        o = true;
                    }
                } finally {
                }
            }
        }
        a();
    }

    public static W5[] b() {
        if (m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (m == null) {
                        m = new W5[0];
                    }
                } finally {
                }
            }
        }
        return m;
    }

    public final W5 a() {
        this.a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C2410a6.b();
        this.f = 0;
        this.g = null;
        this.h = (byte[]) n.clone();
        this.i = WireFormatNano.EMPTY_BYTES;
        this.j = U5.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C2460c6 c2460c6 = this.a;
        if (c2460c6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c2460c6);
        }
        S5 s5 = this.b;
        if (s5 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, s5);
        }
        if (!this.c.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C2410a6[] c2410a6Arr = this.e;
        int i2 = 0;
        if (c2410a6Arr != null && c2410a6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C2410a6[] c2410a6Arr2 = this.e;
                if (i3 >= c2410a6Arr2.length) {
                    break;
                }
                C2410a6 c2410a6 = c2410a6Arr2[i3];
                if (c2410a6 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(5, c2410a6) + iComputeSerializedSize;
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        V5 v5 = this.g;
        if (v5 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, v5);
        }
        if (!Arrays.equals(this.h, n)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        U5[] u5Arr = this.j;
        if (u5Arr != null && u5Arr.length > 0) {
            while (true) {
                U5[] u5Arr2 = this.j;
                if (i2 >= u5Arr2.length) {
                    break;
                }
                U5 u5 = u5Arr2[i2];
                if (u5 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, u5) + iComputeSerializedSize;
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        C2460c6 c2460c6 = this.a;
        if (c2460c6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c2460c6);
        }
        S5 s5 = this.b;
        if (s5 != null) {
            codedOutputByteBufferNano.writeMessage(2, s5);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C2410a6[] c2410a6Arr = this.e;
        int i2 = 0;
        if (c2410a6Arr != null && c2410a6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C2410a6[] c2410a6Arr2 = this.e;
                if (i3 >= c2410a6Arr2.length) {
                    break;
                }
                C2410a6 c2410a6 = c2410a6Arr2[i3];
                if (c2410a6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c2410a6);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        V5 v5 = this.g;
        if (v5 != null) {
            codedOutputByteBufferNano.writeMessage(7, v5);
        }
        if (!Arrays.equals(this.h, n)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        U5[] u5Arr = this.j;
        if (u5Arr != null && u5Arr.length > 0) {
            while (true) {
                U5[] u5Arr2 = this.j;
                if (i2 >= u5Arr2.length) {
                    break;
                }
                U5 u5 = u5Arr2[i2];
                if (u5 != null) {
                    codedOutputByteBufferNano.writeMessage(10, u5);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static W5 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new W5().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final W5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.a == null) {
                        this.a = new C2460c6();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new S5();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != -1 && int32 != 0 && int32 != 1) {
                        break;
                    } else {
                        this.d = int32;
                        break;
                    }
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    C2410a6[] c2410a6Arr = this.e;
                    int length = c2410a6Arr == null ? 0 : c2410a6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C2410a6[] c2410a6Arr2 = new C2410a6[i];
                    if (length != 0) {
                        System.arraycopy(c2410a6Arr, 0, c2410a6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C2410a6 c2410a6 = new C2410a6();
                        c2410a6Arr2[length] = c2410a6;
                        codedInputByteBufferNano.readMessage(c2410a6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C2410a6 c2410a62 = new C2410a6();
                    c2410a6Arr2[length] = c2410a62;
                    codedInputByteBufferNano.readMessage(c2410a62);
                    this.e = c2410a6Arr2;
                    break;
                case 48:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1) {
                        break;
                    } else {
                        this.f = int322;
                        break;
                    }
                    break;
                case 58:
                    if (this.g == null) {
                        this.g = new V5();
                    }
                    codedInputByteBufferNano.readMessage(this.g);
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    this.h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    U5[] u5Arr = this.j;
                    int length2 = u5Arr == null ? 0 : u5Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    U5[] u5Arr2 = new U5[i2];
                    if (length2 != 0) {
                        System.arraycopy(u5Arr, 0, u5Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        U5 u5 = new U5();
                        u5Arr2[length2] = u5;
                        codedInputByteBufferNano.readMessage(u5);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    U5 u52 = new U5();
                    u5Arr2[length2] = u52;
                    codedInputByteBufferNano.readMessage(u52);
                    this.j = u5Arr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static W5 a(byte[] bArr) {
        return (W5) MessageNano.mergeFrom(new W5(), bArr);
    }
}
