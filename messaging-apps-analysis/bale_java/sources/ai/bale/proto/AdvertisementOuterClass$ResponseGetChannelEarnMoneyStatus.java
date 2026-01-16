package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC13706gh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus advertisementOuterClass$ResponseGetChannelEarnMoneyStatus = new AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelEarnMoneyStatus;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.class, advertisementOuterClass$ResponseGetChannelEarnMoneyStatus);
    }

    private AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus() {
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStatus(EnumC13706gh enumC13706gh) {
        this.status_ = enumC13706gh.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.class) {
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

    public EnumC13706gh getStatus() {
        EnumC13706gh enumC13706ghJ = EnumC13706gh.j(this.status_);
        return enumC13706ghJ == null ? EnumC13706gh.UNRECOGNIZED : enumC13706ghJ;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus advertisementOuterClass$ResponseGetChannelEarnMoneyStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelEarnMoneyStatus);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
