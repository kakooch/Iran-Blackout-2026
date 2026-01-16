package bale.smart_support.v1;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestCreateAssistant extends GeneratedMessageLite implements U64 {
    public static final int AVATAR_FIELD_NUMBER = 5;
    public static final int BOT_NAME_FIELD_NUMBER = 2;
    public static final int BOT_NICKNAME_FIELD_NUMBER = 3;
    private static final SmartSupportOuterClass$RequestCreateAssistant DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private FilesStruct$FileLocation avatar_;
    private int bitField0_;
    private String botName_ = "";
    private String botNickname_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestCreateAssistant.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestCreateAssistant smartSupportOuterClass$RequestCreateAssistant = new SmartSupportOuterClass$RequestCreateAssistant();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestCreateAssistant;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestCreateAssistant.class, smartSupportOuterClass$RequestCreateAssistant);
    }

    private SmartSupportOuterClass$RequestCreateAssistant() {
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBotName() {
        this.botName_ = getDefaultInstance().getBotName();
    }

    private void clearBotNickname() {
        this.botNickname_ = getDefaultInstance().getBotNickname();
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    public static SmartSupportOuterClass$RequestCreateAssistant getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvatar(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.avatar_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.avatar_ = filesStruct$FileLocation;
        } else {
            this.avatar_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.avatar_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatar(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.avatar_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setBotName(String str) {
        str.getClass();
        this.botName_ = str;
    }

    private void setBotNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botName_ = abstractC2383g.f0();
    }

    private void setBotNickname(String str) {
        str.getClass();
        this.botNickname_ = str;
    }

    private void setBotNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botNickname_ = abstractC2383g.f0();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestCreateAssistant();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005ဉ\u0000", new Object[]{"bitField0_", "botName_", "botNickname_", "description_", "avatar_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestCreateAssistant.class) {
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

    public FilesStruct$FileLocation getAvatar() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.avatar_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getBotName() {
        return this.botName_;
    }

    public AbstractC2383g getBotNameBytes() {
        return AbstractC2383g.N(this.botName_);
    }

    public String getBotNickname() {
        return this.botNickname_;
    }

    public AbstractC2383g getBotNicknameBytes() {
        return AbstractC2383g.N(this.botNickname_);
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestCreateAssistant smartSupportOuterClass$RequestCreateAssistant) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestCreateAssistant);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestCreateAssistant parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
