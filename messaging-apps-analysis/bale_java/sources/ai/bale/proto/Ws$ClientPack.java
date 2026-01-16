package ai.bale.proto;

import ai.bale.proto.Ws$HandshakeRequest;
import ai.bale.proto.Ws$Ping;
import ai.bale.proto.Ws$Request;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ws$ClientPack extends GeneratedMessageLite implements U64 {
    private static final Ws$ClientPack DEFAULT_INSTANCE;
    public static final int HANDSHAKE_REQUEST_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PING_FIELD_NUMBER = 2;
    public static final int REQUEST_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$ClientPack.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        REQUEST(1),
        PING(2),
        HANDSHAKE_REQUEST(3),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return REQUEST;
            }
            if (i == 2) {
                return PING;
            }
            if (i != 3) {
                return null;
            }
            return HANDSHAKE_REQUEST;
        }
    }

    static {
        Ws$ClientPack ws$ClientPack = new Ws$ClientPack();
        DEFAULT_INSTANCE = ws$ClientPack;
        GeneratedMessageLite.registerDefaultInstance(Ws$ClientPack.class, ws$ClientPack);
    }

    private Ws$ClientPack() {
    }

    private void clearHandshakeRequest() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPing() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRequest() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static Ws$ClientPack getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeHandshakeRequest(Ws$HandshakeRequest ws$HandshakeRequest) {
        ws$HandshakeRequest.getClass();
        if (this.traitCase_ != 3 || this.trait_ == Ws$HandshakeRequest.getDefaultInstance()) {
            this.trait_ = ws$HandshakeRequest;
        } else {
            this.trait_ = ((Ws$HandshakeRequest.a) Ws$HandshakeRequest.newBuilder((Ws$HandshakeRequest) this.trait_).v(ws$HandshakeRequest)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergePing(Ws$Ping ws$Ping) {
        ws$Ping.getClass();
        if (this.traitCase_ != 2 || this.trait_ == Ws$Ping.getDefaultInstance()) {
            this.trait_ = ws$Ping;
        } else {
            this.trait_ = ((Ws$Ping.a) Ws$Ping.newBuilder((Ws$Ping) this.trait_).v(ws$Ping)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeRequest(Ws$Request ws$Request) {
        ws$Request.getClass();
        if (this.traitCase_ != 1 || this.trait_ == Ws$Request.getDefaultInstance()) {
            this.trait_ = ws$Request;
        } else {
            this.trait_ = ((Ws$Request.a) Ws$Request.newBuilder((Ws$Request) this.trait_).v(ws$Request)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$ClientPack parseDelimitedFrom(InputStream inputStream) {
        return (Ws$ClientPack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$ClientPack parseFrom(ByteBuffer byteBuffer) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHandshakeRequest(Ws$HandshakeRequest ws$HandshakeRequest) {
        ws$HandshakeRequest.getClass();
        this.trait_ = ws$HandshakeRequest;
        this.traitCase_ = 3;
    }

    private void setPing(Ws$Ping ws$Ping) {
        ws$Ping.getClass();
        this.trait_ = ws$Ping;
        this.traitCase_ = 2;
    }

    private void setRequest(Ws$Request ws$Request) {
        ws$Request.getClass();
        this.trait_ = ws$Request;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$ClientPack();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"trait_", "traitCase_", Ws$Request.class, Ws$Ping.class, Ws$HandshakeRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$ClientPack.class) {
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

    public Ws$HandshakeRequest getHandshakeRequest() {
        return this.traitCase_ == 3 ? (Ws$HandshakeRequest) this.trait_ : Ws$HandshakeRequest.getDefaultInstance();
    }

    public Ws$Ping getPing() {
        return this.traitCase_ == 2 ? (Ws$Ping) this.trait_ : Ws$Ping.getDefaultInstance();
    }

    public Ws$Request getRequest() {
        return this.traitCase_ == 1 ? (Ws$Request) this.trait_ : Ws$Request.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasHandshakeRequest() {
        return this.traitCase_ == 3;
    }

    public boolean hasPing() {
        return this.traitCase_ == 2;
    }

    public boolean hasRequest() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(Ws$ClientPack ws$ClientPack) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$ClientPack);
    }

    public static Ws$ClientPack parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$ClientPack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$ClientPack parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$ClientPack parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$ClientPack parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$ClientPack parseFrom(byte[] bArr) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$ClientPack parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$ClientPack parseFrom(InputStream inputStream) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$ClientPack parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$ClientPack parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$ClientPack parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$ClientPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
