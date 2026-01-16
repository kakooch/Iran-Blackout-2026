package ai.bale.proto;

import ai.bale.proto.MessagingStruct$CustomActionType;
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
public final class MessagingStruct$CustomAction extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$CustomAction DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String id_ = "";
    private MessagingStruct$CustomActionType type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$CustomAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$CustomAction messagingStruct$CustomAction = new MessagingStruct$CustomAction();
        DEFAULT_INSTANCE = messagingStruct$CustomAction;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$CustomAction.class, messagingStruct$CustomAction);
    }

    private MessagingStruct$CustomAction() {
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearType() {
        this.type_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$CustomAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeType(MessagingStruct$CustomActionType messagingStruct$CustomActionType) {
        messagingStruct$CustomActionType.getClass();
        MessagingStruct$CustomActionType messagingStruct$CustomActionType2 = this.type_;
        if (messagingStruct$CustomActionType2 != null && messagingStruct$CustomActionType2 != MessagingStruct$CustomActionType.getDefaultInstance()) {
            messagingStruct$CustomActionType = (MessagingStruct$CustomActionType) ((MessagingStruct$CustomActionType.a) MessagingStruct$CustomActionType.newBuilder(this.type_).v(messagingStruct$CustomActionType)).j();
        }
        this.type_ = messagingStruct$CustomActionType;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$CustomAction parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$CustomAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setType(MessagingStruct$CustomActionType messagingStruct$CustomActionType) {
        messagingStruct$CustomActionType.getClass();
        this.type_ = messagingStruct$CustomActionType;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$CustomAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "id_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$CustomAction.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public MessagingStruct$CustomActionType getType() {
        MessagingStruct$CustomActionType messagingStruct$CustomActionType = this.type_;
        return messagingStruct$CustomActionType == null ? MessagingStruct$CustomActionType.getDefaultInstance() : messagingStruct$CustomActionType;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$CustomAction messagingStruct$CustomAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$CustomAction);
    }

    public static MessagingStruct$CustomAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$CustomAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$CustomAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$CustomAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$CustomAction parseFrom(InputStream inputStream) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$CustomAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$CustomAction parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$CustomAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$CustomAction parseFrom(byte[] bArr) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$CustomAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$CustomAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
