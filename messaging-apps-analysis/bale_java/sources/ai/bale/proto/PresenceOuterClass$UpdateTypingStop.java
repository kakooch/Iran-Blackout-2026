package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
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
public final class PresenceOuterClass$UpdateTypingStop extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$UpdateTypingStop DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int TYPING_TYPE_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$Peer peer_;
    private int typingType_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$UpdateTypingStop.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop = new PresenceOuterClass$UpdateTypingStop();
        DEFAULT_INSTANCE = presenceOuterClass$UpdateTypingStop;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$UpdateTypingStop.class, presenceOuterClass$UpdateTypingStop);
    }

    private PresenceOuterClass$UpdateTypingStop() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTypingType() {
        this.typingType_ = 0;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static PresenceOuterClass$UpdateTypingStop getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.peer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.peer_ = peersStruct$Peer;
        } else {
            this.peer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.peer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$UpdateTypingStop parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setTypingType(EnumC5025Ho5 enumC5025Ho5) {
        this.typingType_ = enumC5025Ho5.getNumber();
    }

    private void setTypingTypeValue(int i) {
        this.typingType_ = i;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$UpdateTypingStop();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\f", new Object[]{"bitField0_", "peer_", "uid_", "typingType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$UpdateTypingStop.class) {
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

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public EnumC5025Ho5 getTypingType() {
        EnumC5025Ho5 enumC5025Ho5J = EnumC5025Ho5.j(this.typingType_);
        return enumC5025Ho5J == null ? EnumC5025Ho5.UNRECOGNIZED : enumC5025Ho5J;
    }

    public int getTypingTypeValue() {
        return this.typingType_;
    }

    public int getUid() {
        return this.uid_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$UpdateTypingStop);
    }

    public static PresenceOuterClass$UpdateTypingStop parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(byte[] bArr) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$UpdateTypingStop parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$UpdateTypingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
