package ai.bale.proto;

import ai.bale.proto.KetfStruct$DoneResult;
import ai.bale.proto.KetfStruct$OpenDialogActionResult;
import ai.bale.proto.MessagingStruct$MessageId;
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
public final class KetfOuterClass$RequestInvokeCustomAction extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$RequestInvokeCustomAction DEFAULT_INSTANCE;
    public static final int DONE_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_ID_FIELD_NUMBER = 2;
    public static final int OPEN_DIALOG_ACTION_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 3;
    private int bitField0_;
    private MessagingStruct$MessageId messageId_;
    private PeersStruct$OutExPeer peer_;
    private Object result_;
    private int resultCase_ = 0;
    private String id_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(KetfStruct$DoneResult ketfStruct$DoneResult) {
            q();
            ((KetfOuterClass$RequestInvokeCustomAction) this.b).setDone(ketfStruct$DoneResult);
            return this;
        }

        public a B(String str) {
            q();
            ((KetfOuterClass$RequestInvokeCustomAction) this.b).setId(str);
            return this;
        }

        public a C(MessagingStruct$MessageId messagingStruct$MessageId) {
            q();
            ((KetfOuterClass$RequestInvokeCustomAction) this.b).setMessageId(messagingStruct$MessageId);
            return this;
        }

        public a D(KetfStruct$OpenDialogActionResult ketfStruct$OpenDialogActionResult) {
            q();
            ((KetfOuterClass$RequestInvokeCustomAction) this.b).setOpenDialogAction(ketfStruct$OpenDialogActionResult);
            return this;
        }

        public a E(PeersStruct$OutExPeer peersStruct$OutExPeer) {
            q();
            ((KetfOuterClass$RequestInvokeCustomAction) this.b).setPeer(peersStruct$OutExPeer);
            return this;
        }

        private a() {
            super(KetfOuterClass$RequestInvokeCustomAction.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        OPEN_DIALOG_ACTION(4),
        DONE(5),
        RESULT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 4) {
                return OPEN_DIALOG_ACTION;
            }
            if (i != 5) {
                return null;
            }
            return DONE;
        }
    }

    static {
        KetfOuterClass$RequestInvokeCustomAction ketfOuterClass$RequestInvokeCustomAction = new KetfOuterClass$RequestInvokeCustomAction();
        DEFAULT_INSTANCE = ketfOuterClass$RequestInvokeCustomAction;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestInvokeCustomAction.class, ketfOuterClass$RequestInvokeCustomAction);
    }

    private KetfOuterClass$RequestInvokeCustomAction() {
    }

    private void clearDone() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOpenDialogAction() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    public static KetfOuterClass$RequestInvokeCustomAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDone(KetfStruct$DoneResult ketfStruct$DoneResult) {
        ketfStruct$DoneResult.getClass();
        if (this.resultCase_ != 5 || this.result_ == KetfStruct$DoneResult.getDefaultInstance()) {
            this.result_ = ketfStruct$DoneResult;
        } else {
            this.result_ = ((KetfStruct$DoneResult.a) KetfStruct$DoneResult.newBuilder((KetfStruct$DoneResult) this.result_).v(ketfStruct$DoneResult)).j();
        }
        this.resultCase_ = 5;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeOpenDialogAction(KetfStruct$OpenDialogActionResult ketfStruct$OpenDialogActionResult) {
        ketfStruct$OpenDialogActionResult.getClass();
        if (this.resultCase_ != 4 || this.result_ == KetfStruct$OpenDialogActionResult.getDefaultInstance()) {
            this.result_ = ketfStruct$OpenDialogActionResult;
        } else {
            this.result_ = ((KetfStruct$OpenDialogActionResult.a) KetfStruct$OpenDialogActionResult.newBuilder((KetfStruct$OpenDialogActionResult) this.result_).v(ketfStruct$OpenDialogActionResult)).j();
        }
        this.resultCase_ = 4;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(KetfStruct$DoneResult ketfStruct$DoneResult) {
        ketfStruct$DoneResult.getClass();
        this.result_ = ketfStruct$DoneResult;
        this.resultCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOpenDialogAction(KetfStruct$OpenDialogActionResult ketfStruct$OpenDialogActionResult) {
        ketfStruct$OpenDialogActionResult.getClass();
        this.result_ = ketfStruct$OpenDialogActionResult;
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestInvokeCustomAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004<\u0000\u0005<\u0000", new Object[]{"result_", "resultCase_", "bitField0_", "id_", "messageId_", "peer_", KetfStruct$OpenDialogActionResult.class, KetfStruct$DoneResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestInvokeCustomAction.class) {
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

    public KetfStruct$DoneResult getDone() {
        return this.resultCase_ == 5 ? (KetfStruct$DoneResult) this.result_ : KetfStruct$DoneResult.getDefaultInstance();
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public KetfStruct$OpenDialogActionResult getOpenDialogAction() {
        return this.resultCase_ == 4 ? (KetfStruct$OpenDialogActionResult) this.result_ : KetfStruct$OpenDialogActionResult.getDefaultInstance();
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public b getResultCase() {
        return b.j(this.resultCase_);
    }

    public boolean hasDone() {
        return this.resultCase_ == 5;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOpenDialogAction() {
        return this.resultCase_ == 4;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KetfOuterClass$RequestInvokeCustomAction ketfOuterClass$RequestInvokeCustomAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestInvokeCustomAction);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestInvokeCustomAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestInvokeCustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
