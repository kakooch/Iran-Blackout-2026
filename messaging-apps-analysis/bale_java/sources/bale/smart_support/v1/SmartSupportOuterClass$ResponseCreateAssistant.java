package bale.smart_support.v1;

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
public final class SmartSupportOuterClass$ResponseCreateAssistant extends GeneratedMessageLite implements U64 {
    public static final int AGENT_ID_FIELD_NUMBER = 2;
    public static final int AI_GROUP_INVITE_URL_FIELD_NUMBER = 4;
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$ResponseCreateAssistant DEFAULT_INSTANCE;
    public static final int NI_GROUP_INVITE_URL_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int agentId_;
    private int botId_;
    private String niGroupInviteUrl_ = "";
    private String aiGroupInviteUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseCreateAssistant.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseCreateAssistant smartSupportOuterClass$ResponseCreateAssistant = new SmartSupportOuterClass$ResponseCreateAssistant();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseCreateAssistant;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseCreateAssistant.class, smartSupportOuterClass$ResponseCreateAssistant);
    }

    private SmartSupportOuterClass$ResponseCreateAssistant() {
    }

    private void clearAgentId() {
        this.agentId_ = 0;
    }

    private void clearAiGroupInviteUrl() {
        this.aiGroupInviteUrl_ = getDefaultInstance().getAiGroupInviteUrl();
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearNiGroupInviteUrl() {
        this.niGroupInviteUrl_ = getDefaultInstance().getNiGroupInviteUrl();
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAgentId(int i) {
        this.agentId_ = i;
    }

    private void setAiGroupInviteUrl(String str) {
        str.getClass();
        this.aiGroupInviteUrl_ = str;
    }

    private void setAiGroupInviteUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.aiGroupInviteUrl_ = abstractC2383g.f0();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setNiGroupInviteUrl(String str) {
        str.getClass();
        this.niGroupInviteUrl_ = str;
    }

    private void setNiGroupInviteUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.niGroupInviteUrl_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseCreateAssistant();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ\u0004Ȉ", new Object[]{"botId_", "agentId_", "niGroupInviteUrl_", "aiGroupInviteUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseCreateAssistant.class) {
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

    public int getAgentId() {
        return this.agentId_;
    }

    public String getAiGroupInviteUrl() {
        return this.aiGroupInviteUrl_;
    }

    public AbstractC2383g getAiGroupInviteUrlBytes() {
        return AbstractC2383g.N(this.aiGroupInviteUrl_);
    }

    public int getBotId() {
        return this.botId_;
    }

    public String getNiGroupInviteUrl() {
        return this.niGroupInviteUrl_;
    }

    public AbstractC2383g getNiGroupInviteUrlBytes() {
        return AbstractC2383g.N(this.niGroupInviteUrl_);
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseCreateAssistant smartSupportOuterClass$ResponseCreateAssistant) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseCreateAssistant);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseCreateAssistant parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseCreateAssistant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
