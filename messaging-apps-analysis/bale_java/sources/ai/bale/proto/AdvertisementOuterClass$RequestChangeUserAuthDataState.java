package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5424Jh;
import ir.nasim.EnumC5658Kh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestChangeUserAuthDataState extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestChangeUserAuthDataState DEFAULT_INSTANCE;
    public static final int OWNER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 2;
    private int ownerId_;
    private int reason_;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestChangeUserAuthDataState.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestChangeUserAuthDataState advertisementOuterClass$RequestChangeUserAuthDataState = new AdvertisementOuterClass$RequestChangeUserAuthDataState();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestChangeUserAuthDataState;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestChangeUserAuthDataState.class, advertisementOuterClass$RequestChangeUserAuthDataState);
    }

    private AdvertisementOuterClass$RequestChangeUserAuthDataState() {
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setReason(EnumC5424Jh enumC5424Jh) {
        this.reason_ = enumC5424Jh.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    private void setState(EnumC5658Kh enumC5658Kh) {
        this.state_ = enumC5658Kh.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestChangeUserAuthDataState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\f\u0003\f", new Object[]{"ownerId_", "state_", "reason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestChangeUserAuthDataState.class) {
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

    public int getOwnerId() {
        return this.ownerId_;
    }

    public EnumC5424Jh getReason() {
        EnumC5424Jh enumC5424JhJ = EnumC5424Jh.j(this.reason_);
        return enumC5424JhJ == null ? EnumC5424Jh.UNRECOGNIZED : enumC5424JhJ;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public EnumC5658Kh getState() {
        EnumC5658Kh enumC5658KhJ = EnumC5658Kh.j(this.state_);
        return enumC5658KhJ == null ? EnumC5658Kh.UNRECOGNIZED : enumC5658KhJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestChangeUserAuthDataState advertisementOuterClass$RequestChangeUserAuthDataState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestChangeUserAuthDataState);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestChangeUserAuthDataState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeUserAuthDataState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
