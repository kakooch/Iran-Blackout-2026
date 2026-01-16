package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC25078zh6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$MarketSearchResult extends GeneratedMessageLite implements InterfaceC25078zh6 {
    public static final int CHANNEL_ABOUT_FIELD_NUMBER = 4;
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    public static final int CHANNEL_NICK_FIELD_NUMBER = 3;
    public static final int CHANNEL_TITLE_FIELD_NUMBER = 2;
    private static final SearchStruct$MarketSearchResult DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue channelAbout_;
    private int channelId_;
    private StringValue channelNick_;
    private String channelTitle_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC25078zh6 {
        private a() {
            super(SearchStruct$MarketSearchResult.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$MarketSearchResult searchStruct$MarketSearchResult = new SearchStruct$MarketSearchResult();
        DEFAULT_INSTANCE = searchStruct$MarketSearchResult;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$MarketSearchResult.class, searchStruct$MarketSearchResult);
    }

    private SearchStruct$MarketSearchResult() {
    }

    private void clearChannelAbout() {
        this.channelAbout_ = null;
        this.bitField0_ &= -3;
    }

    private void clearChannelId() {
        this.channelId_ = 0;
    }

    private void clearChannelNick() {
        this.channelNick_ = null;
        this.bitField0_ &= -2;
    }

    private void clearChannelTitle() {
        this.channelTitle_ = getDefaultInstance().getChannelTitle();
    }

    public static SearchStruct$MarketSearchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeChannelAbout(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.channelAbout_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.channelAbout_ = stringValue;
        } else {
            this.channelAbout_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.channelAbout_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeChannelNick(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.channelNick_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.channelNick_ = stringValue;
        } else {
            this.channelNick_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.channelNick_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$MarketSearchResult parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$MarketSearchResult parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelAbout(StringValue stringValue) {
        stringValue.getClass();
        this.channelAbout_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setChannelId(int i) {
        this.channelId_ = i;
    }

    private void setChannelNick(StringValue stringValue) {
        stringValue.getClass();
        this.channelNick_ = stringValue;
        this.bitField0_ |= 1;
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
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$MarketSearchResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "channelId_", "channelTitle_", "channelNick_", "channelAbout_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$MarketSearchResult.class) {
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

    public StringValue getChannelAbout() {
        StringValue stringValue = this.channelAbout_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getChannelId() {
        return this.channelId_;
    }

    public StringValue getChannelNick() {
        StringValue stringValue = this.channelNick_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getChannelTitle() {
        return this.channelTitle_;
    }

    public AbstractC2383g getChannelTitleBytes() {
        return AbstractC2383g.N(this.channelTitle_);
    }

    public boolean hasChannelAbout() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasChannelNick() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchStruct$MarketSearchResult searchStruct$MarketSearchResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$MarketSearchResult);
    }

    public static SearchStruct$MarketSearchResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$MarketSearchResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$MarketSearchResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$MarketSearchResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$MarketSearchResult parseFrom(byte[] bArr) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$MarketSearchResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$MarketSearchResult parseFrom(InputStream inputStream) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$MarketSearchResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$MarketSearchResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$MarketSearchResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$MarketSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
