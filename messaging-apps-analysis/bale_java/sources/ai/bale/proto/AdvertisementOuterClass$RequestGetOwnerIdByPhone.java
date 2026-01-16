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

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetOwnerIdByPhone extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetOwnerIdByPhone DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 1;
    private String phoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetOwnerIdByPhone.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetOwnerIdByPhone advertisementOuterClass$RequestGetOwnerIdByPhone = new AdvertisementOuterClass$RequestGetOwnerIdByPhone();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetOwnerIdByPhone;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetOwnerIdByPhone.class, advertisementOuterClass$RequestGetOwnerIdByPhone);
    }

    private AdvertisementOuterClass$RequestGetOwnerIdByPhone() {
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetOwnerIdByPhone();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"phoneNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetOwnerIdByPhone.class) {
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

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetOwnerIdByPhone advertisementOuterClass$RequestGetOwnerIdByPhone) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetOwnerIdByPhone);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetOwnerIdByPhone parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOwnerIdByPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
