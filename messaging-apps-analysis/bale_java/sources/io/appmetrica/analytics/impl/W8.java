package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;

/* loaded from: classes3.dex */
public final class W8 extends MessageNano {
    public static volatile W8[] n;
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public String i;
    public String j;
    public int k;
    public V8[] l;
    public String m;

    public W8() {
        a();
    }

    public static W8[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (n == null) {
                        n = new W8[0];
                    }
                } finally {
                }
            }
        }
        return n;
    }

    public final W8 a() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = 0;
        this.i = "";
        this.j = "";
        this.k = 0;
        this.l = V8.b();
        this.m = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        if (!this.b.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        if (!this.c.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.c);
        }
        int i = this.d;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        if (!this.e.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.e);
        }
        if (!this.f.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f);
        }
        boolean z = this.g;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        int i2 = this.h;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i2);
        }
        if (!this.i.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.i);
        }
        if (!this.j.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i3);
        }
        V8[] v8Arr = this.l;
        if (v8Arr != null && v8Arr.length > 0) {
            int i4 = 0;
            while (true) {
                V8[] v8Arr2 = this.l;
                if (i4 >= v8Arr2.length) {
                    break;
                }
                V8 v8 = v8Arr2[i4];
                if (v8 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(23, v8) + iComputeSerializedSize;
                }
                i4++;
            }
        }
        return !this.m.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(24, this.m) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.c);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.e);
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f);
        }
        boolean z = this.g;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        int i2 = this.h;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i2);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.i);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i3);
        }
        V8[] v8Arr = this.l;
        if (v8Arr != null && v8Arr.length > 0) {
            int i4 = 0;
            while (true) {
                V8[] v8Arr2 = this.l;
                if (i4 >= v8Arr2.length) {
                    break;
                }
                V8 v8 = v8Arr2[i4];
                if (v8 != null) {
                    codedOutputByteBufferNano.writeMessage(23, v8);
                }
                i4++;
            }
        }
        if (!this.m.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.m);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static W8 b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new W8().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final W8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.b = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.d = codedInputByteBufferNano.readUInt32();
                    break;
                case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.g = codedInputByteBufferNano.readBool();
                    break;
                case SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER /* 144 */:
                    this.h = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.k = codedInputByteBufferNano.readUInt32();
                    break;
                case 186:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    V8[] v8Arr = this.l;
                    int length = v8Arr == null ? 0 : v8Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    V8[] v8Arr2 = new V8[i];
                    if (length != 0) {
                        System.arraycopy(v8Arr, 0, v8Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        V8 v8 = new V8();
                        v8Arr2[length] = v8;
                        codedInputByteBufferNano.readMessage(v8);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    V8 v82 = new V8();
                    v8Arr2[length] = v82;
                    codedInputByteBufferNano.readMessage(v82);
                    this.l = v8Arr2;
                    break;
                case 194:
                    this.m = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static W8 a(byte[] bArr) {
        return (W8) MessageNano.mergeFrom(new W8(), bArr);
    }
}
