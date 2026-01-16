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
public final class ClubOuterClass$RequestChangePointToMoney extends GeneratedMessageLite implements U64 {
    private static final ClubOuterClass$RequestChangePointToMoney DEFAULT_INSTANCE;
    public static final int KIFPOOL_TOKEN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int POINT_FIELD_NUMBER = 1;
    private String kifpoolToken_ = "";
    private long point_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$RequestChangePointToMoney.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$RequestChangePointToMoney clubOuterClass$RequestChangePointToMoney = new ClubOuterClass$RequestChangePointToMoney();
        DEFAULT_INSTANCE = clubOuterClass$RequestChangePointToMoney;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$RequestChangePointToMoney.class, clubOuterClass$RequestChangePointToMoney);
    }

    private ClubOuterClass$RequestChangePointToMoney() {
    }

    private void clearKifpoolToken() {
        this.kifpoolToken_ = getDefaultInstance().getKifpoolToken();
    }

    private void clearPoint() {
        this.point_ = 0L;
    }

    public static ClubOuterClass$RequestChangePointToMoney getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$RequestChangePointToMoney parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKifpoolToken(String str) {
        str.getClass();
        this.kifpoolToken_ = str;
    }

    private void setKifpoolTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.kifpoolToken_ = abstractC2383g.f0();
    }

    private void setPoint(long j) {
        this.point_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$RequestChangePointToMoney();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"point_", "kifpoolToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$RequestChangePointToMoney.class) {
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

    public String getKifpoolToken() {
        return this.kifpoolToken_;
    }

    public AbstractC2383g getKifpoolTokenBytes() {
        return AbstractC2383g.N(this.kifpoolToken_);
    }

    public long getPoint() {
        return this.point_;
    }

    public static a newBuilder(ClubOuterClass$RequestChangePointToMoney clubOuterClass$RequestChangePointToMoney) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$RequestChangePointToMoney);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(byte[] bArr) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(InputStream inputStream) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$RequestChangePointToMoney parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$RequestChangePointToMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
