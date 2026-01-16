package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5658Kh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetUsersAuthDataByState extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetUsersAuthDataByState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetUsersAuthDataByState.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetUsersAuthDataByState advertisementOuterClass$RequestGetUsersAuthDataByState = new AdvertisementOuterClass$RequestGetUsersAuthDataByState();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetUsersAuthDataByState;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetUsersAuthDataByState.class, advertisementOuterClass$RequestGetUsersAuthDataByState);
    }

    private AdvertisementOuterClass$RequestGetUsersAuthDataByState() {
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
                return new AdvertisementOuterClass$RequestGetUsersAuthDataByState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetUsersAuthDataByState.class) {
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

    public EnumC5658Kh getState() {
        EnumC5658Kh enumC5658KhJ = EnumC5658Kh.j(this.state_);
        return enumC5658KhJ == null ? EnumC5658Kh.UNRECOGNIZED : enumC5658KhJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetUsersAuthDataByState advertisementOuterClass$RequestGetUsersAuthDataByState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetUsersAuthDataByState);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetUsersAuthDataByState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
