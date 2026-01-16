package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LahzeStruct$LiveMessageRequirements extends GeneratedMessageLite implements U64 {
    private static final LahzeStruct$LiveMessageRequirements DEFAULT_INSTANCE;
    public static final int DOCUMENT_MESSAGE_FIELD_NUMBER = 1;
    public static final int EX_PEER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$DocumentMessage documentMessage_;
    private PeersStruct$OutExPeer exPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LahzeStruct$LiveMessageRequirements.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeStruct$LiveMessageRequirements lahzeStruct$LiveMessageRequirements = new LahzeStruct$LiveMessageRequirements();
        DEFAULT_INSTANCE = lahzeStruct$LiveMessageRequirements;
        GeneratedMessageLite.registerDefaultInstance(LahzeStruct$LiveMessageRequirements.class, lahzeStruct$LiveMessageRequirements);
    }

    private LahzeStruct$LiveMessageRequirements() {
    }

    private void clearDocumentMessage() {
        this.documentMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -3;
    }

    public static LahzeStruct$LiveMessageRequirements getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = this.documentMessage_;
        if (messagingStruct$DocumentMessage2 == null || messagingStruct$DocumentMessage2 == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.documentMessage_ = messagingStruct$DocumentMessage;
        } else {
            this.documentMessage_ = (MessagingStruct$DocumentMessage) ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder(this.documentMessage_).v(messagingStruct$DocumentMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeExPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.exPeer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$OutExPeer;
        } else {
            this.exPeer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.exPeer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeStruct$LiveMessageRequirements parseDelimitedFrom(InputStream inputStream) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(ByteBuffer byteBuffer) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.documentMessage_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    private void setExPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.exPeer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1906x0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeStruct$LiveMessageRequirements();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "documentMessage_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeStruct$LiveMessageRequirements.class) {
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

    public MessagingStruct$DocumentMessage getDocumentMessage() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.documentMessage_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public PeersStruct$OutExPeer getExPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.exPeer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public boolean hasDocumentMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(LahzeStruct$LiveMessageRequirements lahzeStruct$LiveMessageRequirements) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeStruct$LiveMessageRequirements);
    }

    public static LahzeStruct$LiveMessageRequirements parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(byte[] bArr) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(InputStream inputStream) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeStruct$LiveMessageRequirements parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeStruct$LiveMessageRequirements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
