package ai.bale.proto;

import ai.bale.proto.ClubStruct$ClubVoucher;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ClubOuterClass$ResponseBuyVoucher extends GeneratedMessageLite implements U64 {
    private static final ClubOuterClass$ResponseBuyVoucher DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VOUCHER_FIELD_NUMBER = 1;
    private int bitField0_;
    private ClubStruct$ClubVoucher voucher_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$ResponseBuyVoucher.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$ResponseBuyVoucher clubOuterClass$ResponseBuyVoucher = new ClubOuterClass$ResponseBuyVoucher();
        DEFAULT_INSTANCE = clubOuterClass$ResponseBuyVoucher;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$ResponseBuyVoucher.class, clubOuterClass$ResponseBuyVoucher);
    }

    private ClubOuterClass$ResponseBuyVoucher() {
    }

    private void clearVoucher() {
        this.voucher_ = null;
        this.bitField0_ &= -2;
    }

    public static ClubOuterClass$ResponseBuyVoucher getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeVoucher(ClubStruct$ClubVoucher clubStruct$ClubVoucher) {
        clubStruct$ClubVoucher.getClass();
        ClubStruct$ClubVoucher clubStruct$ClubVoucher2 = this.voucher_;
        if (clubStruct$ClubVoucher2 == null || clubStruct$ClubVoucher2 == ClubStruct$ClubVoucher.getDefaultInstance()) {
            this.voucher_ = clubStruct$ClubVoucher;
        } else {
            this.voucher_ = (ClubStruct$ClubVoucher) ((ClubStruct$ClubVoucher.a) ClubStruct$ClubVoucher.newBuilder(this.voucher_).v(clubStruct$ClubVoucher)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$ResponseBuyVoucher parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setVoucher(ClubStruct$ClubVoucher clubStruct$ClubVoucher) {
        clubStruct$ClubVoucher.getClass();
        this.voucher_ = clubStruct$ClubVoucher;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$ResponseBuyVoucher();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "voucher_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$ResponseBuyVoucher.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public ClubStruct$ClubVoucher getVoucher() {
        ClubStruct$ClubVoucher clubStruct$ClubVoucher = this.voucher_;
        return clubStruct$ClubVoucher == null ? ClubStruct$ClubVoucher.getDefaultInstance() : clubStruct$ClubVoucher;
    }

    public boolean hasVoucher() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ClubOuterClass$ResponseBuyVoucher clubOuterClass$ResponseBuyVoucher) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$ResponseBuyVoucher);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(byte[] bArr) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$ResponseBuyVoucher parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$ResponseBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
