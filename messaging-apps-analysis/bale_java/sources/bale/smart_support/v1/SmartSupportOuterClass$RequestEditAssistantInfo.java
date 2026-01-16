package bale.smart_support.v1;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestEditAssistantInfo extends GeneratedMessageLite implements U64 {
    public static final int ABOUT_FIELD_NUMBER = 5;
    public static final int AVATAR_FIELD_NUMBER = 6;
    public static final int BOT_ID_FIELD_NUMBER = 2;
    private static final SmartSupportOuterClass$RequestEditAssistantInfo DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private StringValue about_;
    private FilesStruct$FileLocation avatar_;
    private int bitField0_;
    private int botId_;
    private StringValue name_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestEditAssistantInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestEditAssistantInfo smartSupportOuterClass$RequestEditAssistantInfo = new SmartSupportOuterClass$RequestEditAssistantInfo();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestEditAssistantInfo;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestEditAssistantInfo.class, smartSupportOuterClass$RequestEditAssistantInfo);
    }

    private SmartSupportOuterClass$RequestEditAssistantInfo() {
    }

    private void clearAbout() {
        this.about_ = null;
        this.bitField0_ &= -3;
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -5;
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearName() {
        this.name_ = null;
        this.bitField0_ &= -2;
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAbout(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.about_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.about_ = stringValue;
        } else {
            this.about_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.about_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeAvatar(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.avatar_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.avatar_ = filesStruct$FileLocation;
        } else {
            this.avatar_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.avatar_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.name_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.name_ = stringValue;
        } else {
            this.name_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.name_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAbout(StringValue stringValue) {
        stringValue.getClass();
        this.about_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setAvatar(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.avatar_ = filesStruct$FileLocation;
        this.bitField0_ |= 4;
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setName(StringValue stringValue) {
        stringValue.getClass();
        this.name_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestEditAssistantInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0002\u0006\u0004\u0000\u0000\u0000\u0002\u0004\u0003ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"bitField0_", "botId_", "name_", "about_", "avatar_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestEditAssistantInfo.class) {
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

    public StringValue getAbout() {
        StringValue stringValue = this.about_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FilesStruct$FileLocation getAvatar() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.avatar_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public int getBotId() {
        return this.botId_;
    }

    public StringValue getName() {
        StringValue stringValue = this.name_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAbout() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestEditAssistantInfo smartSupportOuterClass$RequestEditAssistantInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestEditAssistantInfo);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestEditAssistantInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditAssistantInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
