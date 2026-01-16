package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.KetfStruct$BotInlineMediaResult;
import ai.bale.proto.KetfStruct$BotInlineMessage;
import ai.bale.proto.KetfStruct$BotInlineResult;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5248In3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$BotResult extends GeneratedMessageLite implements InterfaceC1894t0 {
    public static final int BOT_INLINE_MEDIA_RESULT_FIELD_NUMBER = 102;
    public static final int BOT_INLINE_MESSAGE_FIELD_NUMBER = 8;
    public static final int BOT_INLINE_RESULT_FIELD_NUMBER = 101;
    private static final KetfStruct$BotResult DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private KetfStruct$BotInlineMessage botInlineMessage_;
    private CollectionsStruct$StringValue description_;
    private int eCase_ = 0;
    private Object e_;
    private CollectionsStruct$StringValue title_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1894t0 {
        private a() {
            super(KetfStruct$BotResult.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BOT_INLINE_RESULT(101),
        BOT_INLINE_MEDIA_RESULT(102),
        E_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return E_NOT_SET;
            }
            if (i == 101) {
                return BOT_INLINE_RESULT;
            }
            if (i != 102) {
                return null;
            }
            return BOT_INLINE_MEDIA_RESULT;
        }
    }

    static {
        KetfStruct$BotResult ketfStruct$BotResult = new KetfStruct$BotResult();
        DEFAULT_INSTANCE = ketfStruct$BotResult;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$BotResult.class, ketfStruct$BotResult);
    }

    private KetfStruct$BotResult() {
    }

    private void clearBotInlineMediaResult() {
        if (this.eCase_ == 102) {
            this.eCase_ = 0;
            this.e_ = null;
        }
    }

    private void clearBotInlineMessage() {
        this.botInlineMessage_ = null;
        this.bitField0_ &= -5;
    }

    private void clearBotInlineResult() {
        if (this.eCase_ == 101) {
            this.eCase_ = 0;
            this.e_ = null;
        }
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
    }

    private void clearE() {
        this.eCase_ = 0;
        this.e_ = null;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static KetfStruct$BotResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotInlineMediaResult(KetfStruct$BotInlineMediaResult ketfStruct$BotInlineMediaResult) {
        ketfStruct$BotInlineMediaResult.getClass();
        if (this.eCase_ != 102 || this.e_ == KetfStruct$BotInlineMediaResult.getDefaultInstance()) {
            this.e_ = ketfStruct$BotInlineMediaResult;
        } else {
            this.e_ = ((KetfStruct$BotInlineMediaResult.a) KetfStruct$BotInlineMediaResult.newBuilder((KetfStruct$BotInlineMediaResult) this.e_).v(ketfStruct$BotInlineMediaResult)).j();
        }
        this.eCase_ = 102;
    }

    private void mergeBotInlineMessage(KetfStruct$BotInlineMessage ketfStruct$BotInlineMessage) {
        ketfStruct$BotInlineMessage.getClass();
        KetfStruct$BotInlineMessage ketfStruct$BotInlineMessage2 = this.botInlineMessage_;
        if (ketfStruct$BotInlineMessage2 == null || ketfStruct$BotInlineMessage2 == KetfStruct$BotInlineMessage.getDefaultInstance()) {
            this.botInlineMessage_ = ketfStruct$BotInlineMessage;
        } else {
            this.botInlineMessage_ = (KetfStruct$BotInlineMessage) ((KetfStruct$BotInlineMessage.a) KetfStruct$BotInlineMessage.newBuilder(this.botInlineMessage_).v(ketfStruct$BotInlineMessage)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeBotInlineResult(KetfStruct$BotInlineResult ketfStruct$BotInlineResult) {
        ketfStruct$BotInlineResult.getClass();
        if (this.eCase_ != 101 || this.e_ == KetfStruct$BotInlineResult.getDefaultInstance()) {
            this.e_ = ketfStruct$BotInlineResult;
        } else {
            this.e_ = ((KetfStruct$BotInlineResult.a) KetfStruct$BotInlineResult.newBuilder((KetfStruct$BotInlineResult) this.e_).v(ketfStruct$BotInlineResult)).j();
        }
        this.eCase_ = 101;
    }

    private void mergeDescription(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.description_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.description_ = collectionsStruct$StringValue;
        } else {
            this.description_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.description_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.title_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.title_ = collectionsStruct$StringValue;
        } else {
            this.title_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.title_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$BotResult parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotResult parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotInlineMediaResult(KetfStruct$BotInlineMediaResult ketfStruct$BotInlineMediaResult) {
        ketfStruct$BotInlineMediaResult.getClass();
        this.e_ = ketfStruct$BotInlineMediaResult;
        this.eCase_ = 102;
    }

    private void setBotInlineMessage(KetfStruct$BotInlineMessage ketfStruct$BotInlineMessage) {
        ketfStruct$BotInlineMessage.getClass();
        this.botInlineMessage_ = ketfStruct$BotInlineMessage;
        this.bitField0_ |= 4;
    }

    private void setBotInlineResult(KetfStruct$BotInlineResult ketfStruct$BotInlineResult) {
        ketfStruct$BotInlineResult.getClass();
        this.e_ = ketfStruct$BotInlineResult;
        this.eCase_ = 101;
    }

    private void setDescription(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.description_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    private void setTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.title_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setType(EnumC5248In3 enumC5248In3) {
        this.type_ = enumC5248In3.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$BotResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0001\u0001f\u0006\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001\bဉ\u0002e<\u0000f<\u0000", new Object[]{"e_", "eCase_", "bitField0_", "type_", "title_", "description_", "botInlineMessage_", KetfStruct$BotInlineResult.class, KetfStruct$BotInlineMediaResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$BotResult.class) {
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

    public KetfStruct$BotInlineMediaResult getBotInlineMediaResult() {
        return this.eCase_ == 102 ? (KetfStruct$BotInlineMediaResult) this.e_ : KetfStruct$BotInlineMediaResult.getDefaultInstance();
    }

    public KetfStruct$BotInlineMessage getBotInlineMessage() {
        KetfStruct$BotInlineMessage ketfStruct$BotInlineMessage = this.botInlineMessage_;
        return ketfStruct$BotInlineMessage == null ? KetfStruct$BotInlineMessage.getDefaultInstance() : ketfStruct$BotInlineMessage;
    }

    public KetfStruct$BotInlineResult getBotInlineResult() {
        return this.eCase_ == 101 ? (KetfStruct$BotInlineResult) this.e_ : KetfStruct$BotInlineResult.getDefaultInstance();
    }

    public CollectionsStruct$StringValue getDescription() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.description_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public b getECase() {
        return b.j(this.eCase_);
    }

    public CollectionsStruct$StringValue getTitle() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.title_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public EnumC5248In3 getType() {
        EnumC5248In3 enumC5248In3J = EnumC5248In3.j(this.type_);
        return enumC5248In3J == null ? EnumC5248In3.UNRECOGNIZED : enumC5248In3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasBotInlineMediaResult() {
        return this.eCase_ == 102;
    }

    public boolean hasBotInlineMessage() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasBotInlineResult() {
        return this.eCase_ == 101;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfStruct$BotResult ketfStruct$BotResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$BotResult);
    }

    public static KetfStruct$BotResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$BotResult parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$BotResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$BotResult parseFrom(byte[] bArr) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$BotResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$BotResult parseFrom(InputStream inputStream) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotResult parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$BotResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$BotResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
