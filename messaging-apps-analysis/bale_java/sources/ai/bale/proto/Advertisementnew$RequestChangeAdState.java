package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20844si;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestChangeAdState extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    private static final Advertisementnew$RequestChangeAdState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 2;
    private String adId_ = "";
    private String reason_ = "";
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestChangeAdState.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestChangeAdState advertisementnew$RequestChangeAdState = new Advertisementnew$RequestChangeAdState();
        DEFAULT_INSTANCE = advertisementnew$RequestChangeAdState;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestChangeAdState.class, advertisementnew$RequestChangeAdState);
    }

    private Advertisementnew$RequestChangeAdState() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static Advertisementnew$RequestChangeAdState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestChangeAdState parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdId(String str) {
        str.getClass();
        this.adId_ = str;
    }

    private void setAdIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adId_ = abstractC2383g.f0();
    }

    private void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    private void setReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reason_ = abstractC2383g.f0();
    }

    private void setState(EnumC20844si enumC20844si) {
        this.state_ = enumC20844si.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestChangeAdState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003Ȉ", new Object[]{"adId_", "state_", "reason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestChangeAdState.class) {
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

    public String getAdId() {
        return this.adId_;
    }

    public AbstractC2383g getAdIdBytes() {
        return AbstractC2383g.N(this.adId_);
    }

    public String getReason() {
        return this.reason_;
    }

    public AbstractC2383g getReasonBytes() {
        return AbstractC2383g.N(this.reason_);
    }

    public EnumC20844si getState() {
        EnumC20844si enumC20844siJ = EnumC20844si.j(this.state_);
        return enumC20844siJ == null ? EnumC20844si.UNRECOGNIZED : enumC20844siJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(Advertisementnew$RequestChangeAdState advertisementnew$RequestChangeAdState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestChangeAdState);
    }

    public static Advertisementnew$RequestChangeAdState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestChangeAdState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestChangeAdState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
