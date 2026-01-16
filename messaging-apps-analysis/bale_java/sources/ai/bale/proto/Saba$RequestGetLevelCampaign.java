package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Saba$RequestGetLevelCampaign extends GeneratedMessageLite implements U64 {
    private static final Saba$RequestGetLevelCampaign DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$RequestGetLevelCampaign.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$RequestGetLevelCampaign saba$RequestGetLevelCampaign = new Saba$RequestGetLevelCampaign();
        DEFAULT_INSTANCE = saba$RequestGetLevelCampaign;
        GeneratedMessageLite.registerDefaultInstance(Saba$RequestGetLevelCampaign.class, saba$RequestGetLevelCampaign);
    }

    private Saba$RequestGetLevelCampaign() {
    }

    public static Saba$RequestGetLevelCampaign getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$RequestGetLevelCampaign parseDelimitedFrom(InputStream inputStream) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(ByteBuffer byteBuffer) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$RequestGetLevelCampaign();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$RequestGetLevelCampaign.class) {
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

    public static a newBuilder(Saba$RequestGetLevelCampaign saba$RequestGetLevelCampaign) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$RequestGetLevelCampaign);
    }

    public static Saba$RequestGetLevelCampaign parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(byte[] bArr) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(InputStream inputStream) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$RequestGetLevelCampaign parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$RequestGetLevelCampaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
