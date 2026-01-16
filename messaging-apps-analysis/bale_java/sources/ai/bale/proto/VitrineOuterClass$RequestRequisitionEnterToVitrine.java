package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$RequestRequisitionEnterToVitrine extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_CATEGORY_FIELD_NUMBER = 1;
    public static final int CHANNEL_NICKNAME_FIELD_NUMBER = 3;
    public static final int CHANNEL_TITLE_FIELD_NUMBER = 2;
    private static final VitrineOuterClass$RequestRequisitionEnterToVitrine DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String channelCategory_ = "";
    private String channelTitle_ = "";
    private String channelNickname_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$RequestRequisitionEnterToVitrine.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$RequestRequisitionEnterToVitrine vitrineOuterClass$RequestRequisitionEnterToVitrine = new VitrineOuterClass$RequestRequisitionEnterToVitrine();
        DEFAULT_INSTANCE = vitrineOuterClass$RequestRequisitionEnterToVitrine;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$RequestRequisitionEnterToVitrine.class, vitrineOuterClass$RequestRequisitionEnterToVitrine);
    }

    private VitrineOuterClass$RequestRequisitionEnterToVitrine() {
    }

    private void clearChannelCategory() {
        this.channelCategory_ = getDefaultInstance().getChannelCategory();
    }

    private void clearChannelNickname() {
        this.channelNickname_ = getDefaultInstance().getChannelNickname();
    }

    private void clearChannelTitle() {
        this.channelTitle_ = getDefaultInstance().getChannelTitle();
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelCategory(String str) {
        str.getClass();
        this.channelCategory_ = str;
    }

    private void setChannelCategoryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.channelCategory_ = abstractC2383g.f0();
    }

    private void setChannelNickname(String str) {
        str.getClass();
        this.channelNickname_ = str;
    }

    private void setChannelNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.channelNickname_ = abstractC2383g.f0();
    }

    private void setChannelTitle(String str) {
        str.getClass();
        this.channelTitle_ = str;
    }

    private void setChannelTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.channelTitle_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$RequestRequisitionEnterToVitrine();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"channelCategory_", "channelTitle_", "channelNickname_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$RequestRequisitionEnterToVitrine.class) {
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

    public String getChannelCategory() {
        return this.channelCategory_;
    }

    public AbstractC2383g getChannelCategoryBytes() {
        return AbstractC2383g.N(this.channelCategory_);
    }

    public String getChannelNickname() {
        return this.channelNickname_;
    }

    public AbstractC2383g getChannelNicknameBytes() {
        return AbstractC2383g.N(this.channelNickname_);
    }

    public String getChannelTitle() {
        return this.channelTitle_;
    }

    public AbstractC2383g getChannelTitleBytes() {
        return AbstractC2383g.N(this.channelTitle_);
    }

    public static a newBuilder(VitrineOuterClass$RequestRequisitionEnterToVitrine vitrineOuterClass$RequestRequisitionEnterToVitrine) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$RequestRequisitionEnterToVitrine);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(byte[] bArr) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$RequestRequisitionEnterToVitrine parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$RequestRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
