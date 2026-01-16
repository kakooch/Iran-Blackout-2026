package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExUserInvited extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExUserInvited DEFAULT_INSTANCE;
    public static final int INVITED_UID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int invitedUid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExUserInvited.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExUserInvited messagingStruct$ServiceExUserInvited = new MessagingStruct$ServiceExUserInvited();
        DEFAULT_INSTANCE = messagingStruct$ServiceExUserInvited;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExUserInvited.class, messagingStruct$ServiceExUserInvited);
    }

    private MessagingStruct$ServiceExUserInvited() {
    }

    private void clearInvitedUid() {
        this.invitedUid_ = 0;
    }

    public static MessagingStruct$ServiceExUserInvited getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExUserInvited parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInvitedUid(int i) {
        this.invitedUid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExUserInvited();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"invitedUid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExUserInvited.class) {
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

    public int getInvitedUid() {
        return this.invitedUid_;
    }

    public static a newBuilder(MessagingStruct$ServiceExUserInvited messagingStruct$ServiceExUserInvited) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExUserInvited);
    }

    public static MessagingStruct$ServiceExUserInvited parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExUserInvited parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExUserInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
