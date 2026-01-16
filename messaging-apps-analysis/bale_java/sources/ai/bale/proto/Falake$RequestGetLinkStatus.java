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
public final class Falake$RequestGetLinkStatus extends GeneratedMessageLite implements U64 {
    private static final Falake$RequestGetLinkStatus DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String exPeer_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Falake$RequestGetLinkStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        Falake$RequestGetLinkStatus falake$RequestGetLinkStatus = new Falake$RequestGetLinkStatus();
        DEFAULT_INSTANCE = falake$RequestGetLinkStatus;
        GeneratedMessageLite.registerDefaultInstance(Falake$RequestGetLinkStatus.class, falake$RequestGetLinkStatus);
    }

    private Falake$RequestGetLinkStatus() {
    }

    private void clearExPeer() {
        this.exPeer_ = getDefaultInstance().getExPeer();
    }

    public static Falake$RequestGetLinkStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Falake$RequestGetLinkStatus parseDelimitedFrom(InputStream inputStream) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Falake$RequestGetLinkStatus parseFrom(ByteBuffer byteBuffer) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(String str) {
        str.getClass();
        this.exPeer_ = str;
    }

    private void setExPeerBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.exPeer_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (W.a[gVar.ordinal()]) {
            case 1:
                return new Falake$RequestGetLinkStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Falake$RequestGetLinkStatus.class) {
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

    public String getExPeer() {
        return this.exPeer_;
    }

    public AbstractC2383g getExPeerBytes() {
        return AbstractC2383g.N(this.exPeer_);
    }

    public static a newBuilder(Falake$RequestGetLinkStatus falake$RequestGetLinkStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(falake$RequestGetLinkStatus);
    }

    public static Falake$RequestGetLinkStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Falake$RequestGetLinkStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Falake$RequestGetLinkStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Falake$RequestGetLinkStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Falake$RequestGetLinkStatus parseFrom(byte[] bArr) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Falake$RequestGetLinkStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Falake$RequestGetLinkStatus parseFrom(InputStream inputStream) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Falake$RequestGetLinkStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Falake$RequestGetLinkStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Falake$RequestGetLinkStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Falake$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
