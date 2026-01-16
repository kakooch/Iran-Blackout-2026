package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC15487jg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestChangeBonusCodeState extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestChangeBonusCodeState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 2;
    private String code_ = "";
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestChangeBonusCodeState.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestChangeBonusCodeState advertisementOuterClass$RequestChangeBonusCodeState = new AdvertisementOuterClass$RequestChangeBonusCodeState();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestChangeBonusCodeState;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestChangeBonusCodeState.class, advertisementOuterClass$RequestChangeBonusCodeState);
    }

    private AdvertisementOuterClass$RequestChangeBonusCodeState() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setState(EnumC15487jg enumC15487jg) {
        this.state_ = enumC15487jg.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestChangeBonusCodeState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"code_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestChangeBonusCodeState.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public EnumC15487jg getState() {
        EnumC15487jg enumC15487jgJ = EnumC15487jg.j(this.state_);
        return enumC15487jgJ == null ? EnumC15487jg.UNRECOGNIZED : enumC15487jgJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestChangeBonusCodeState advertisementOuterClass$RequestChangeBonusCodeState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestChangeBonusCodeState);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestChangeBonusCodeState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
