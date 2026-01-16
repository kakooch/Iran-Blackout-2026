package ai.bale.proto;

import ai.bale.proto.FilesStruct$Avatar;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class TimcheOuterClass$ResponseGetBotPage extends GeneratedMessageLite implements U64 {
    public static final int ACTIVE_USERS_FIELD_NUMBER = 3;
    public static final int AVATAR_FIELD_NUMBER = 7;
    public static final int AVERAGE_RATING_FIELD_NUMBER = 4;
    private static final TimcheOuterClass$ResponseGetBotPage DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int IMAGE_LINKS_FIELD_NUMBER = 8;
    public static final int INTRO_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NICKNAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int activeUsers_;
    private FilesStruct$Avatar avatar_;
    private FloatValue averageRating_;
    private int bitField0_;
    private String name_ = "";
    private String nickname_ = "";
    private String description_ = "";
    private String intro_ = "";
    private B.j imageLinks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$ResponseGetBotPage.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$ResponseGetBotPage timcheOuterClass$ResponseGetBotPage = new TimcheOuterClass$ResponseGetBotPage();
        DEFAULT_INSTANCE = timcheOuterClass$ResponseGetBotPage;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$ResponseGetBotPage.class, timcheOuterClass$ResponseGetBotPage);
    }

    private TimcheOuterClass$ResponseGetBotPage() {
    }

    private void addAllImageLinks(Iterable<String> iterable) {
        ensureImageLinksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.imageLinks_);
    }

    private void addImageLinks(String str) {
        str.getClass();
        ensureImageLinksIsMutable();
        this.imageLinks_.add(str);
    }

    private void addImageLinksBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureImageLinksIsMutable();
        this.imageLinks_.add(abstractC2383g.f0());
    }

    private void clearActiveUsers() {
        this.activeUsers_ = 0;
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

    private void clearImageLinks() {
        this.imageLinks_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIntro() {
        this.intro_ = getDefaultInstance().getIntro();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNickname() {
        this.nickname_ = getDefaultInstance().getNickname();
    }

    private void ensureImageLinksIsMutable() {
        B.j jVar = this.imageLinks_;
        if (jVar.u()) {
            return;
        }
        this.imageLinks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static TimcheOuterClass$ResponseGetBotPage getDefaultInstance() {
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

    public static TimcheOuterClass$ResponseGetBotPage parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setActiveUsers(int i) {
        this.activeUsers_ = i;
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

    private void setImageLinks(int i, String str) {
        str.getClass();
        ensureImageLinksIsMutable();
        this.imageLinks_.set(i, str);
    }

    private void setIntro(String str) {
        str.getClass();
        this.intro_ = str;
    }

    private void setIntroBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.intro_ = abstractC2383g.f0();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setNickname(String str) {
        str.getClass();
        this.nickname_ = str;
    }

    private void setNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickname_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$ResponseGetBotPage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004ဉ\u0001\u0005Ȉ\u0006Ȉ\u0007ဉ\u0000\bȚ", new Object[]{"bitField0_", "name_", "nickname_", "activeUsers_", "averageRating_", "description_", "intro_", "avatar_", "imageLinks_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$ResponseGetBotPage.class) {
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

    public int getActiveUsers() {
        return this.activeUsers_;
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

    public String getImageLinks(int i) {
        return (String) this.imageLinks_.get(i);
    }

    public AbstractC2383g getImageLinksBytes(int i) {
        return AbstractC2383g.N((String) this.imageLinks_.get(i));
    }

    public int getImageLinksCount() {
        return this.imageLinks_.size();
    }

    public List<String> getImageLinksList() {
        return this.imageLinks_;
    }

    public String getIntro() {
        return this.intro_;
    }

    public AbstractC2383g getIntroBytes() {
        return AbstractC2383g.N(this.intro_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getNickname() {
        return this.nickname_;
    }

    public AbstractC2383g getNicknameBytes() {
        return AbstractC2383g.N(this.nickname_);
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasAverageRating() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(TimcheOuterClass$ResponseGetBotPage timcheOuterClass$ResponseGetBotPage) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$ResponseGetBotPage);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(byte[] bArr) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$ResponseGetBotPage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
