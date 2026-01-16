package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC23168wT3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$GenericDeepLink extends GeneratedMessageLite implements InterfaceC23168wT3 {
    public static final int ANDROID_FIELD_NUMBER = 2;
    private static final MarketStruct$GenericDeepLink DEFAULT_INSTANCE;
    public static final int LINK_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int WEB_FIELD_NUMBER = 3;
    private StringValue android_;
    private int bitField0_;
    private String link_ = "";
    private StringValue web_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23168wT3 {
        private a() {
            super(MarketStruct$GenericDeepLink.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$GenericDeepLink marketStruct$GenericDeepLink = new MarketStruct$GenericDeepLink();
        DEFAULT_INSTANCE = marketStruct$GenericDeepLink;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$GenericDeepLink.class, marketStruct$GenericDeepLink);
    }

    private MarketStruct$GenericDeepLink() {
    }

    private void clearAndroid() {
        this.android_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearWeb() {
        this.web_ = null;
        this.bitField0_ &= -3;
    }

    public static MarketStruct$GenericDeepLink getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAndroid(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.android_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.android_ = stringValue;
        } else {
            this.android_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.android_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeWeb(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.web_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.web_ = stringValue;
        } else {
            this.web_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.web_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$GenericDeepLink parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$GenericDeepLink parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAndroid(StringValue stringValue) {
        stringValue.getClass();
        this.android_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setWeb(StringValue stringValue) {
        stringValue.getClass();
        this.web_ = stringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$GenericDeepLink();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "link_", "android_", "web_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$GenericDeepLink.class) {
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

    public StringValue getAndroid() {
        StringValue stringValue = this.android_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public StringValue getWeb() {
        StringValue stringValue = this.web_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAndroid() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWeb() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MarketStruct$GenericDeepLink marketStruct$GenericDeepLink) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$GenericDeepLink);
    }

    public static MarketStruct$GenericDeepLink parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$GenericDeepLink parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$GenericDeepLink parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$GenericDeepLink parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$GenericDeepLink parseFrom(byte[] bArr) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$GenericDeepLink parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$GenericDeepLink parseFrom(InputStream inputStream) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$GenericDeepLink parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$GenericDeepLink parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$GenericDeepLink parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$GenericDeepLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
