package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ClubOuterClass$RequestBuyVoucher extends GeneratedMessageLite implements U64 {
    private static final ClubOuterClass$RequestBuyVoucher DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VOUCHER_ID_FIELD_NUMBER = 1;
    private String voucherId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$RequestBuyVoucher.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$RequestBuyVoucher clubOuterClass$RequestBuyVoucher = new ClubOuterClass$RequestBuyVoucher();
        DEFAULT_INSTANCE = clubOuterClass$RequestBuyVoucher;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$RequestBuyVoucher.class, clubOuterClass$RequestBuyVoucher);
    }

    private ClubOuterClass$RequestBuyVoucher() {
    }

    private void clearVoucherId() {
        this.voucherId_ = getDefaultInstance().getVoucherId();
    }

    public static ClubOuterClass$RequestBuyVoucher getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$RequestBuyVoucher parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setVoucherId(String str) {
        str.getClass();
        this.voucherId_ = str;
    }

    private void setVoucherIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.voucherId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$RequestBuyVoucher();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"voucherId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$RequestBuyVoucher.class) {
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

    public String getVoucherId() {
        return this.voucherId_;
    }

    public AbstractC2383g getVoucherIdBytes() {
        return AbstractC2383g.N(this.voucherId_);
    }

    public static a newBuilder(ClubOuterClass$RequestBuyVoucher clubOuterClass$RequestBuyVoucher) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$RequestBuyVoucher);
    }

    public static ClubOuterClass$RequestBuyVoucher parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(byte[] bArr) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(InputStream inputStream) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$RequestBuyVoucher parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$RequestBuyVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
