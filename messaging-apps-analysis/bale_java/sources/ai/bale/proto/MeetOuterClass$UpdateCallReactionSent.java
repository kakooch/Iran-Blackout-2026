package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutExPeer;
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
public final class MeetOuterClass$UpdateCallReactionSent extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$UpdateCallReactionSent DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int REACTION_FIELD_NUMBER = 3;
    public static final int SENDER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$OutExPeer peer_;
    private String reaction_ = "";
    private PeersStruct$OutExPeer sender_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallReactionSent.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent = new MeetOuterClass$UpdateCallReactionSent();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallReactionSent;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallReactionSent.class, meetOuterClass$UpdateCallReactionSent);
    }

    private MeetOuterClass$UpdateCallReactionSent() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearReaction() {
        this.reaction_ = getDefaultInstance().getReaction();
    }

    private void clearSender() {
        this.sender_ = null;
        this.bitField0_ &= -2;
    }

    public static MeetOuterClass$UpdateCallReactionSent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSender(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.sender_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.sender_ = peersStruct$OutExPeer;
        } else {
            this.sender_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.sender_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallReactionSent parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    private void setReaction(String str) {
        str.getClass();
        this.reaction_ = str;
    }

    private void setReactionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reaction_ = abstractC2383g.f0();
    }

    private void setSender(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.sender_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallReactionSent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ", new Object[]{"bitField0_", "sender_", "peer_", "reaction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallReactionSent.class) {
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

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public String getReaction() {
        return this.reaction_;
    }

    public AbstractC2383g getReactionBytes() {
        return AbstractC2383g.N(this.reaction_);
    }

    public PeersStruct$OutExPeer getSender() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.sender_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSender() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallReactionSent);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallReactionSent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallReactionSent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
