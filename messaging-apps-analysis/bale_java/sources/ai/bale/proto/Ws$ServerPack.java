package ai.bale.proto;

import ai.bale.proto.Ws$HandshakeResponse;
import ai.bale.proto.Ws$Pong;
import ai.bale.proto.Ws$Response;
import ai.bale.proto.Ws$TerminateSession;
import ai.bale.proto.Ws$Update;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ws$ServerPack extends GeneratedMessageLite implements U64 {
    private static final Ws$ServerPack DEFAULT_INSTANCE;
    public static final int HANDSHAKE_RESPONSE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PONG_FIELD_NUMBER = 4;
    public static final int RESPONSE_FIELD_NUMBER = 1;
    public static final int TERMINATE_SESSION_FIELD_NUMBER = 3;
    public static final int UPDATE_FIELD_NUMBER = 2;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$ServerPack.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        RESPONSE(1),
        UPDATE(2),
        TERMINATE_SESSION(3),
        PONG(4),
        HANDSHAKE_RESPONSE(5),
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
                return RESPONSE;
            }
            if (i == 2) {
                return UPDATE;
            }
            if (i == 3) {
                return TERMINATE_SESSION;
            }
            if (i == 4) {
                return PONG;
            }
            if (i != 5) {
                return null;
            }
            return HANDSHAKE_RESPONSE;
        }
    }

    static {
        Ws$ServerPack ws$ServerPack = new Ws$ServerPack();
        DEFAULT_INSTANCE = ws$ServerPack;
        GeneratedMessageLite.registerDefaultInstance(Ws$ServerPack.class, ws$ServerPack);
    }

    private Ws$ServerPack() {
    }

    private void clearHandshakeResponse() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPong() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponse() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTerminateSession() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearUpdate() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static Ws$ServerPack getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeHandshakeResponse(Ws$HandshakeResponse ws$HandshakeResponse) {
        ws$HandshakeResponse.getClass();
        if (this.traitCase_ != 5 || this.trait_ == Ws$HandshakeResponse.getDefaultInstance()) {
            this.trait_ = ws$HandshakeResponse;
        } else {
            this.trait_ = ((Ws$HandshakeResponse.a) Ws$HandshakeResponse.newBuilder((Ws$HandshakeResponse) this.trait_).v(ws$HandshakeResponse)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergePong(Ws$Pong ws$Pong) {
        ws$Pong.getClass();
        if (this.traitCase_ != 4 || this.trait_ == Ws$Pong.getDefaultInstance()) {
            this.trait_ = ws$Pong;
        } else {
            this.trait_ = ((Ws$Pong.a) Ws$Pong.newBuilder((Ws$Pong) this.trait_).v(ws$Pong)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeResponse(Ws$Response ws$Response) {
        ws$Response.getClass();
        if (this.traitCase_ != 1 || this.trait_ == Ws$Response.getDefaultInstance()) {
            this.trait_ = ws$Response;
        } else {
            this.trait_ = ((Ws$Response.a) Ws$Response.newBuilder((Ws$Response) this.trait_).v(ws$Response)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeTerminateSession(Ws$TerminateSession ws$TerminateSession) {
        ws$TerminateSession.getClass();
        if (this.traitCase_ != 3 || this.trait_ == Ws$TerminateSession.getDefaultInstance()) {
            this.trait_ = ws$TerminateSession;
        } else {
            this.trait_ = ((Ws$TerminateSession.a) Ws$TerminateSession.newBuilder((Ws$TerminateSession) this.trait_).v(ws$TerminateSession)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeUpdate(Ws$Update ws$Update) {
        ws$Update.getClass();
        if (this.traitCase_ != 2 || this.trait_ == Ws$Update.getDefaultInstance()) {
            this.trait_ = ws$Update;
        } else {
            this.trait_ = ((Ws$Update.a) Ws$Update.newBuilder((Ws$Update) this.trait_).v(ws$Update)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$ServerPack parseDelimitedFrom(InputStream inputStream) {
        return (Ws$ServerPack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$ServerPack parseFrom(ByteBuffer byteBuffer) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHandshakeResponse(Ws$HandshakeResponse ws$HandshakeResponse) {
        ws$HandshakeResponse.getClass();
        this.trait_ = ws$HandshakeResponse;
        this.traitCase_ = 5;
    }

    private void setPong(Ws$Pong ws$Pong) {
        ws$Pong.getClass();
        this.trait_ = ws$Pong;
        this.traitCase_ = 4;
    }

    private void setResponse(Ws$Response ws$Response) {
        ws$Response.getClass();
        this.trait_ = ws$Response;
        this.traitCase_ = 1;
    }

    private void setTerminateSession(Ws$TerminateSession ws$TerminateSession) {
        ws$TerminateSession.getClass();
        this.trait_ = ws$TerminateSession;
        this.traitCase_ = 3;
    }

    private void setUpdate(Ws$Update ws$Update) {
        ws$Update.getClass();
        this.trait_ = ws$Update;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$ServerPack();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"trait_", "traitCase_", Ws$Response.class, Ws$Update.class, Ws$TerminateSession.class, Ws$Pong.class, Ws$HandshakeResponse.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$ServerPack.class) {
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

    public Ws$HandshakeResponse getHandshakeResponse() {
        return this.traitCase_ == 5 ? (Ws$HandshakeResponse) this.trait_ : Ws$HandshakeResponse.getDefaultInstance();
    }

    public Ws$Pong getPong() {
        return this.traitCase_ == 4 ? (Ws$Pong) this.trait_ : Ws$Pong.getDefaultInstance();
    }

    public Ws$Response getResponse() {
        return this.traitCase_ == 1 ? (Ws$Response) this.trait_ : Ws$Response.getDefaultInstance();
    }

    public Ws$TerminateSession getTerminateSession() {
        return this.traitCase_ == 3 ? (Ws$TerminateSession) this.trait_ : Ws$TerminateSession.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public Ws$Update getUpdate() {
        return this.traitCase_ == 2 ? (Ws$Update) this.trait_ : Ws$Update.getDefaultInstance();
    }

    public boolean hasHandshakeResponse() {
        return this.traitCase_ == 5;
    }

    public boolean hasPong() {
        return this.traitCase_ == 4;
    }

    public boolean hasResponse() {
        return this.traitCase_ == 1;
    }

    public boolean hasTerminateSession() {
        return this.traitCase_ == 3;
    }

    public boolean hasUpdate() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(Ws$ServerPack ws$ServerPack) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$ServerPack);
    }

    public static Ws$ServerPack parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$ServerPack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$ServerPack parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$ServerPack parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$ServerPack parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$ServerPack parseFrom(byte[] bArr) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$ServerPack parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$ServerPack parseFrom(InputStream inputStream) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$ServerPack parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$ServerPack parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$ServerPack parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$ServerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
