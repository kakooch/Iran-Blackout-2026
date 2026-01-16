package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: io.appmetrica.analytics.impl.xl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2979xl extends MessageNano {
    public static final int E = -1;
    public static final int F = 0;
    public static final int G = 1;
    public static volatile C2979xl[] H;
    public C2740nl A;
    public C2931vl B;
    public C2883tl[] C;
    public C2835rl D;
    public String a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public C2812ql[] h;
    public C2859sl i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[] o;
    public C2955wl p;
    public boolean q;
    public String r;
    public long s;
    public long t;
    public boolean u;
    public C2907ul v;
    public int w;
    public int x;
    public C2788pl y;
    public C2764ol z;

    public C2979xl() {
        a();
    }

    public static C2979xl[] b() {
        if (H == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (H == null) {
                        H = new C2979xl[0];
                    }
                } finally {
                }
            }
        }
        return H;
    }

    public final C2979xl a() {
        this.a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = C2812ql.b();
        this.i = null;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = false;
        this.n = "";
        this.o = strArr;
        this.p = null;
        this.q = false;
        this.r = "";
        this.s = 0L;
        this.t = 0L;
        this.u = false;
        this.v = null;
        this.w = SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER;
        this.x = 1;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = C2883tl.b();
        this.D = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        int iComputeInt64Size = CodedOutputByteBufferNano.computeInt64Size(2, this.b) + iComputeSerializedSize;
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag + i3;
        }
        if (!this.d.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        if (!this.e.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(5, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            int iComputeStringSizeNoTag2 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    i5++;
                    iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i4++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag2 + i5;
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i6 = 0;
            int iComputeStringSizeNoTag3 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i6 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i6];
                if (str3 != null) {
                    i7++;
                    iComputeStringSizeNoTag3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i6++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag3 + i7;
        }
        C2812ql[] c2812qlArr = this.h;
        if (c2812qlArr != null && c2812qlArr.length > 0) {
            int i8 = 0;
            while (true) {
                C2812ql[] c2812qlArr2 = this.h;
                if (i8 >= c2812qlArr2.length) {
                    break;
                }
                C2812ql c2812ql = c2812qlArr2[i8];
                if (c2812ql != null) {
                    iComputeInt64Size = CodedOutputByteBufferNano.computeMessageSize(8, c2812ql) + iComputeInt64Size;
                }
                i8++;
            }
        }
        C2859sl c2859sl = this.i;
        if (c2859sl != null) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(9, c2859sl);
        }
        if (!this.j.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(10, this.j);
        }
        if (!this.k.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(11, this.k);
        }
        if (!this.l.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(12, this.l);
        }
        int iComputeBoolSize = CodedOutputByteBufferNano.computeBoolSize(13, this.m) + iComputeInt64Size;
        if (!this.n.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(14, this.n);
        }
        String[] strArr7 = this.o;
        if (strArr7 != null && strArr7.length > 0) {
            int i9 = 0;
            int iComputeStringSizeNoTag4 = 0;
            int i10 = 0;
            while (true) {
                String[] strArr8 = this.o;
                if (i9 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i9];
                if (str4 != null) {
                    i10++;
                    iComputeStringSizeNoTag4 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i9++;
            }
            iComputeBoolSize = iComputeBoolSize + iComputeStringSizeNoTag4 + i10;
        }
        C2955wl c2955wl = this.p;
        if (c2955wl != null) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(16, c2955wl);
        }
        boolean z = this.q;
        if (z) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        if (!this.r.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(20, this.r);
        }
        int iComputeInt64Size2 = CodedOutputByteBufferNano.computeInt64Size(22, this.t) + CodedOutputByteBufferNano.computeInt64Size(21, this.s) + iComputeBoolSize;
        boolean z2 = this.u;
        if (z2) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeBoolSize(23, z2);
        }
        C2907ul c2907ul = this.v;
        if (c2907ul != null) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(24, c2907ul);
        }
        int iComputeInt32Size = CodedOutputByteBufferNano.computeInt32Size(26, this.x) + CodedOutputByteBufferNano.computeInt32Size(25, this.w) + iComputeInt64Size2;
        C2788pl c2788pl = this.y;
        if (c2788pl != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(27, c2788pl);
        }
        C2764ol c2764ol = this.z;
        if (c2764ol != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(28, c2764ol);
        }
        C2740nl c2740nl = this.A;
        if (c2740nl != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, c2740nl);
        }
        C2931vl c2931vl = this.B;
        if (c2931vl != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(30, c2931vl);
        }
        C2883tl[] c2883tlArr = this.C;
        if (c2883tlArr != null && c2883tlArr.length > 0) {
            while (true) {
                C2883tl[] c2883tlArr2 = this.C;
                if (i >= c2883tlArr2.length) {
                    break;
                }
                C2883tl c2883tl = c2883tlArr2[i];
                if (c2883tl != null) {
                    iComputeInt32Size = CodedOutputByteBufferNano.computeMessageSize(31, c2883tl) + iComputeInt32Size;
                }
                i++;
            }
        }
        C2835rl c2835rl = this.D;
        return c2835rl != null ? iComputeInt32Size + CodedOutputByteBufferNano.computeMessageSize(32, c2835rl) : iComputeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        codedOutputByteBufferNano.writeInt64(2, this.b);
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i2++;
            }
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(6, str2);
                }
                i3++;
            }
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i4 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i4];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(7, str3);
                }
                i4++;
            }
        }
        C2812ql[] c2812qlArr = this.h;
        if (c2812qlArr != null && c2812qlArr.length > 0) {
            int i5 = 0;
            while (true) {
                C2812ql[] c2812qlArr2 = this.h;
                if (i5 >= c2812qlArr2.length) {
                    break;
                }
                C2812ql c2812ql = c2812qlArr2[i5];
                if (c2812ql != null) {
                    codedOutputByteBufferNano.writeMessage(8, c2812ql);
                }
                i5++;
            }
        }
        C2859sl c2859sl = this.i;
        if (c2859sl != null) {
            codedOutputByteBufferNano.writeMessage(9, c2859sl);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.j);
        }
        if (!this.k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.k);
        }
        if (!this.l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.l);
        }
        codedOutputByteBufferNano.writeBool(13, this.m);
        if (!this.n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.n);
        }
        String[] strArr7 = this.o;
        if (strArr7 != null && strArr7.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr8 = this.o;
                if (i6 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i6];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(15, str4);
                }
                i6++;
            }
        }
        C2955wl c2955wl = this.p;
        if (c2955wl != null) {
            codedOutputByteBufferNano.writeMessage(16, c2955wl);
        }
        boolean z = this.q;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        if (!this.r.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.r);
        }
        codedOutputByteBufferNano.writeInt64(21, this.s);
        codedOutputByteBufferNano.writeInt64(22, this.t);
        boolean z2 = this.u;
        if (z2) {
            codedOutputByteBufferNano.writeBool(23, z2);
        }
        C2907ul c2907ul = this.v;
        if (c2907ul != null) {
            codedOutputByteBufferNano.writeMessage(24, c2907ul);
        }
        codedOutputByteBufferNano.writeInt32(25, this.w);
        codedOutputByteBufferNano.writeInt32(26, this.x);
        C2788pl c2788pl = this.y;
        if (c2788pl != null) {
            codedOutputByteBufferNano.writeMessage(27, c2788pl);
        }
        C2764ol c2764ol = this.z;
        if (c2764ol != null) {
            codedOutputByteBufferNano.writeMessage(28, c2764ol);
        }
        C2740nl c2740nl = this.A;
        if (c2740nl != null) {
            codedOutputByteBufferNano.writeMessage(29, c2740nl);
        }
        C2931vl c2931vl = this.B;
        if (c2931vl != null) {
            codedOutputByteBufferNano.writeMessage(30, c2931vl);
        }
        C2883tl[] c2883tlArr = this.C;
        if (c2883tlArr != null && c2883tlArr.length > 0) {
            while (true) {
                C2883tl[] c2883tlArr2 = this.C;
                if (i >= c2883tlArr2.length) {
                    break;
                }
                C2883tl c2883tl = c2883tlArr2[i];
                if (c2883tl != null) {
                    codedOutputByteBufferNano.writeMessage(31, c2883tl);
                }
                i++;
            }
        }
        C2835rl c2835rl = this.D;
        if (c2835rl != null) {
            codedOutputByteBufferNano.writeMessage(32, c2835rl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C2979xl b(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new C2979xl().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2979xl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.b = codedInputByteBufferNano.readInt64();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.c;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.c = strArr2;
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr3 = this.f;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.f = strArr4;
                    break;
                case 58:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    String[] strArr5 = this.g;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i3 = repeatedFieldArrayLength3 + length3;
                    String[] strArr6 = new String[i3];
                    if (length3 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.g = strArr6;
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    C2812ql[] c2812qlArr = this.h;
                    int length4 = c2812qlArr == null ? 0 : c2812qlArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    C2812ql[] c2812qlArr2 = new C2812ql[i4];
                    if (length4 != 0) {
                        System.arraycopy(c2812qlArr, 0, c2812qlArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        C2812ql c2812ql = new C2812ql();
                        c2812qlArr2[length4] = c2812ql;
                        codedInputByteBufferNano.readMessage(c2812ql);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    C2812ql c2812ql2 = new C2812ql();
                    c2812qlArr2[length4] = c2812ql2;
                    codedInputByteBufferNano.readMessage(c2812ql2);
                    this.h = c2812qlArr2;
                    break;
                case 74:
                    if (this.i == null) {
                        this.i = new C2859sl();
                    }
                    codedInputByteBufferNano.readMessage(this.i);
                    break;
                case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                    this.k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.m = codedInputByteBufferNano.readBool();
                    break;
                case 114:
                    this.n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    String[] strArr7 = this.o;
                    int length5 = strArr7 == null ? 0 : strArr7.length;
                    int i5 = repeatedFieldArrayLength5 + length5;
                    String[] strArr8 = new String[i5];
                    if (length5 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length5);
                    }
                    while (length5 < i5 - 1) {
                        strArr8[length5] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    strArr8[length5] = codedInputByteBufferNano.readString();
                    this.o = strArr8;
                    break;
                case 130:
                    if (this.p == null) {
                        this.p = new C2955wl();
                    }
                    codedInputByteBufferNano.readMessage(this.p);
                    break;
                case 136:
                    this.q = codedInputByteBufferNano.readBool();
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER /* 162 */:
                    this.r = codedInputByteBufferNano.readString();
                    break;
                case 168:
                    this.s = codedInputByteBufferNano.readInt64();
                    break;
                case 176:
                    this.t = codedInputByteBufferNano.readInt64();
                    break;
                case 184:
                    this.u = codedInputByteBufferNano.readBool();
                    break;
                case 194:
                    if (this.v == null) {
                        this.v = new C2907ul();
                    }
                    codedInputByteBufferNano.readMessage(this.v);
                    break;
                case 200:
                    this.w = codedInputByteBufferNano.readInt32();
                    break;
                case 208:
                    this.x = codedInputByteBufferNano.readInt32();
                    break;
                case 218:
                    if (this.y == null) {
                        this.y = new C2788pl();
                    }
                    codedInputByteBufferNano.readMessage(this.y);
                    break;
                case 226:
                    if (this.z == null) {
                        this.z = new C2764ol();
                    }
                    codedInputByteBufferNano.readMessage(this.z);
                    break;
                case SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER /* 234 */:
                    if (this.A == null) {
                        this.A = new C2740nl();
                    }
                    codedInputByteBufferNano.readMessage(this.A);
                    break;
                case 242:
                    if (this.B == null) {
                        this.B = new C2931vl();
                    }
                    codedInputByteBufferNano.readMessage(this.B);
                    break;
                case Type.TSIG /* 250 */:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, Type.TSIG);
                    C2883tl[] c2883tlArr = this.C;
                    int length6 = c2883tlArr == null ? 0 : c2883tlArr.length;
                    int i6 = repeatedFieldArrayLength6 + length6;
                    C2883tl[] c2883tlArr2 = new C2883tl[i6];
                    if (length6 != 0) {
                        System.arraycopy(c2883tlArr, 0, c2883tlArr2, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        C2883tl c2883tl = new C2883tl();
                        c2883tlArr2[length6] = c2883tl;
                        codedInputByteBufferNano.readMessage(c2883tl);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    C2883tl c2883tl2 = new C2883tl();
                    c2883tlArr2[length6] = c2883tl2;
                    codedInputByteBufferNano.readMessage(c2883tl2);
                    this.C = c2883tlArr2;
                    break;
                case Type.AVC /* 258 */:
                    if (this.D == null) {
                        this.D = new C2835rl();
                    }
                    codedInputByteBufferNano.readMessage(this.D);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static C2979xl a(byte[] bArr) {
        return (C2979xl) MessageNano.mergeFrom(new C2979xl(), bArr);
    }
}
