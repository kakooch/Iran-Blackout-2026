package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8857Xp7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TimcheStruct$BotPreview extends GeneratedMessageLite implements InterfaceC8857Xp7 {
    public static final int AVATAR_FIELD_NUMBER = 3;
    public static final int AVERAGE_RATING_FIELD_NUMBER = 4;
    private static final TimcheStruct$BotPreview DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private FilesStruct$Avatar avatar_;
    private FloatValue averageRating_;
    private int bitField0_;
    private int id_;
    private String name_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8857Xp7 {
        private a() {
            super(TimcheStruct$BotPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheStruct$BotPreview timcheStruct$BotPreview = new TimcheStruct$BotPreview();
        DEFAULT_INSTANCE = timcheStruct$BotPreview;
        GeneratedMessageLite.registerDefaultInstance(TimcheStruct$BotPreview.class, timcheStruct$BotPreview);
    }

    private TimcheStruct$BotPreview() {
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -2;
    }

    private void clearAverageRating() {
        this.averageRating_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static TimcheStruct$BotPreview getDefaultInstance() {
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

    private void mergeAverageRating(FloatValue floatValue) {
        floatValue.getClass();
        FloatValue floatValue2 = this.averageRating_;
        if (floatValue2 == null || floatValue2 == FloatValue.getDefaultInstance()) {
            this.averageRating_ = floatValue;
        } else {
            this.averageRating_ = (FloatValue) ((FloatValue.b) FloatValue.newBuilder(this.averageRating_).v(floatValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheStruct$BotPreview parseDelimitedFrom(InputStream inputStream) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheStruct$BotPreview parseFrom(ByteBuffer byteBuffer) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 1;
    }

    private void setAverageRating(FloatValue floatValue) {
        floatValue.getClass();
        this.averageRating_ = floatValue;
        this.bitField0_ |= 2;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (j2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheStruct$BotPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001\u0005Ȉ", new Object[]{"bitField0_", "id_", "name_", "avatar_", "averageRating_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheStruct$BotPreview.class) {
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

    public FloatValue getAverageRating() {
        FloatValue floatValue = this.averageRating_;
        return floatValue == null ? FloatValue.getDefaultInstance() : floatValue;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public int getId() {
        return this.id_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasAverageRating() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(TimcheStruct$BotPreview timcheStruct$BotPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheStruct$BotPreview);
    }

    public static TimcheStruct$BotPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheStruct$BotPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheStruct$BotPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheStruct$BotPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheStruct$BotPreview parseFrom(byte[] bArr) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheStruct$BotPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheStruct$BotPreview parseFrom(InputStream inputStream) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheStruct$BotPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheStruct$BotPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheStruct$BotPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheStruct$BotPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
