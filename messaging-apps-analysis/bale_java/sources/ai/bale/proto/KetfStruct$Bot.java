package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4780Gn3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$Bot extends GeneratedMessageLite implements InterfaceC4780Gn3 {
    private static final KetfStruct$Bot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SCORE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 4;
    public static final int USERNAME_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int score_;
    private int userId_;
    private String username_ = "";
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4780Gn3 {
        private a() {
            super(KetfStruct$Bot.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$Bot ketfStruct$Bot = new KetfStruct$Bot();
        DEFAULT_INSTANCE = ketfStruct$Bot;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$Bot.class, ketfStruct$Bot);
    }

    private KetfStruct$Bot() {
    }

    private void clearScore() {
        this.score_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void clearUsername() {
        this.username_ = getDefaultInstance().getUsername();
    }

    public static KetfStruct$Bot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$Bot parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$Bot parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setScore(int i) {
        this.score_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    private void setUsername(String str) {
        str.getClass();
        this.username_ = str;
    }

    private void setUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.username_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$Bot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004Ȉ", new Object[]{"userId_", "username_", "score_", "title_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$Bot.class) {
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

    public int getScore() {
        return this.score_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public String getUsername() {
        return this.username_;
    }

    public AbstractC2383g getUsernameBytes() {
        return AbstractC2383g.N(this.username_);
    }

    public static a newBuilder(KetfStruct$Bot ketfStruct$Bot) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$Bot);
    }

    public static KetfStruct$Bot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$Bot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$Bot parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$Bot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$Bot parseFrom(byte[] bArr) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$Bot parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$Bot parseFrom(InputStream inputStream) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$Bot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$Bot parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$Bot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$Bot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
