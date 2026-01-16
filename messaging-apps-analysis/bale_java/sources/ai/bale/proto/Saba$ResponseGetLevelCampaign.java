package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10149b96;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Saba$ResponseGetLevelCampaign extends GeneratedMessageLite implements U64 {
    private static final Saba$ResponseGetLevelCampaign DEFAULT_INSTANCE;
    public static final int LEVELTYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int levelType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$ResponseGetLevelCampaign.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$ResponseGetLevelCampaign saba$ResponseGetLevelCampaign = new Saba$ResponseGetLevelCampaign();
        DEFAULT_INSTANCE = saba$ResponseGetLevelCampaign;
        GeneratedMessageLite.registerDefaultInstance(Saba$ResponseGetLevelCampaign.class, saba$ResponseGetLevelCampaign);
    }

    private Saba$ResponseGetLevelCampaign() {
    }

    private void clearLevelType() {
        this.levelType_ = 0;
    }

    public static Saba$ResponseGetLevelCampaign getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$ResponseGetLevelCampaign parseDelimitedFrom(InputStream inputStream) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(ByteBuffer byteBuffer) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLevelType(EnumC10149b96 enumC10149b96) {
        this.levelType_ = enumC10149b96.getNumber();
    }

    private void setLevelTypeValue(int i) {
        this.levelType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$ResponseGetLevelCampaign();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"levelType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$ResponseGetLevelCampaign.class) {
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

    public EnumC10149b96 getLevelType() {
        EnumC10149b96 enumC10149b96J = EnumC10149b96.j(this.levelType_);
        return enumC10149b96J == null ? EnumC10149b96.UNRECOGNIZED : enumC10149b96J;
    }

    public int getLevelTypeValue() {
        return this.levelType_;
    }

    public static a newBuilder(Saba$ResponseGetLevelCampaign saba$ResponseGetLevelCampaign) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$ResponseGetLevelCampaign);
    }

    public static Saba$ResponseGetLevelCampaign parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(byte[] bArr) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(InputStream inputStream) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$ResponseGetLevelCampaign parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$ResponseGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
