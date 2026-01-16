package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExChangedAvatar extends GeneratedMessageLite implements U64 {
    public static final int AVATAR_FIELD_NUMBER = 1;
    private static final MessagingStruct$ServiceExChangedAvatar DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private FilesStruct$Avatar avatar_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExChangedAvatar.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExChangedAvatar messagingStruct$ServiceExChangedAvatar = new MessagingStruct$ServiceExChangedAvatar();
        DEFAULT_INSTANCE = messagingStruct$ServiceExChangedAvatar;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExChangedAvatar.class, messagingStruct$ServiceExChangedAvatar);
    }

    private MessagingStruct$ServiceExChangedAvatar() {
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ServiceExChangedAvatar getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        FilesStruct$Avatar filesStruct$Avatar2 = this.avatar_;
        if (filesStruct$Avatar2 == null || filesStruct$Avatar2 == FilesStruct$Avatar.getDefaultInstance()) {
            this.avatar_ = filesStruct$Avatar;
        } else {
            this.avatar_ = (FilesStruct$Avatar) ((FilesStruct$Avatar.a) FilesStruct$Avatar.newBuilder(this.avatar_).v(filesStruct$Avatar)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExChangedAvatar parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExChangedAvatar();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "avatar_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExChangedAvatar.class) {
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

    public FilesStruct$Avatar getAvatar() {
        FilesStruct$Avatar filesStruct$Avatar = this.avatar_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ServiceExChangedAvatar messagingStruct$ServiceExChangedAvatar) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExChangedAvatar);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExChangedAvatar parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExChangedAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
