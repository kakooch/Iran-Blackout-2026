package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3458Ay6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SharedMediaStruct$MessageMediaResult extends GeneratedMessageLite implements InterfaceC3458Ay6 {
    public static final int CONTENT_FIELD_NUMBER = 5;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final SharedMediaStruct$MessageMediaResult DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SENDER_ID_FIELD_NUMBER = 4;
    private int bitField0_;
    private MessagingStruct$Message content_;
    private long date_;
    private PeersStruct$ExPeer exPeer_;
    private long rid_;
    private int senderId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3458Ay6 {
        private a() {
            super(SharedMediaStruct$MessageMediaResult.DEFAULT_INSTANCE);
        }
    }

    static {
        SharedMediaStruct$MessageMediaResult sharedMediaStruct$MessageMediaResult = new SharedMediaStruct$MessageMediaResult();
        DEFAULT_INSTANCE = sharedMediaStruct$MessageMediaResult;
        GeneratedMessageLite.registerDefaultInstance(SharedMediaStruct$MessageMediaResult.class, sharedMediaStruct$MessageMediaResult);
    }

    private SharedMediaStruct$MessageMediaResult() {
    }

    private void clearContent() {
        this.content_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSenderId() {
        this.senderId_ = 0;
    }

    public static SharedMediaStruct$MessageMediaResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.content_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.content_ = messagingStruct$Message;
        } else {
            this.content_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.content_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SharedMediaStruct$MessageMediaResult parseDelimitedFrom(InputStream inputStream) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(ByteBuffer byteBuffer) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.content_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSenderId(int i) {
        this.senderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b2.a[gVar.ordinal()]) {
            case 1:
                return new SharedMediaStruct$MessageMediaResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002\u0004\u0004\u0005ဉ\u0001", new Object[]{"bitField0_", "exPeer_", "rid_", "date_", "senderId_", "content_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SharedMediaStruct$MessageMediaResult.class) {
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

    public MessagingStruct$Message getContent() {
        MessagingStruct$Message messagingStruct$Message = this.content_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getSenderId() {
        return this.senderId_;
    }

    public boolean hasContent() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SharedMediaStruct$MessageMediaResult sharedMediaStruct$MessageMediaResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(sharedMediaStruct$MessageMediaResult);
    }

    public static SharedMediaStruct$MessageMediaResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(byte[] bArr) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(InputStream inputStream) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SharedMediaStruct$MessageMediaResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SharedMediaStruct$MessageMediaResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
