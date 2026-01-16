package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5025Ho5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PresenceOuterClass$RequestStopTyping extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$RequestStopTyping DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int TYPING_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$OutPeer peer_;
    private int typingType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((PresenceOuterClass$RequestStopTyping) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        public a B(EnumC5025Ho5 enumC5025Ho5) {
            q();
            ((PresenceOuterClass$RequestStopTyping) this.b).setTypingType(enumC5025Ho5);
            return this;
        }

        private a() {
            super(PresenceOuterClass$RequestStopTyping.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$RequestStopTyping presenceOuterClass$RequestStopTyping = new PresenceOuterClass$RequestStopTyping();
        DEFAULT_INSTANCE = presenceOuterClass$RequestStopTyping;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$RequestStopTyping.class, presenceOuterClass$RequestStopTyping);
    }

    private PresenceOuterClass$RequestStopTyping() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTypingType() {
        this.typingType_ = 0;
    }

    public static PresenceOuterClass$RequestStopTyping getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$RequestStopTyping parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypingType(EnumC5025Ho5 enumC5025Ho5) {
        this.typingType_ = enumC5025Ho5.getNumber();
    }

    private void setTypingTypeValue(int i) {
        this.typingType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$RequestStopTyping();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "peer_", "typingType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$RequestStopTyping.class) {
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

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public EnumC5025Ho5 getTypingType() {
        EnumC5025Ho5 enumC5025Ho5J = EnumC5025Ho5.j(this.typingType_);
        return enumC5025Ho5J == null ? EnumC5025Ho5.UNRECOGNIZED : enumC5025Ho5J;
    }

    public int getTypingTypeValue() {
        return this.typingType_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PresenceOuterClass$RequestStopTyping presenceOuterClass$RequestStopTyping) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$RequestStopTyping);
    }

    public static PresenceOuterClass$RequestStopTyping parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(byte[] bArr) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$RequestStopTyping parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$RequestStopTyping) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
