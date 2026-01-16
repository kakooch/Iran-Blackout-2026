package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC9742aU3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$Product extends GeneratedMessageLite implements InterfaceC9742aU3 {
    private static final MarketStruct$Product DEFAULT_INSTANCE;
    public static final int DISCOUNT_PERCENT_FIELD_NUMBER = 8;
    public static final int FINAL_PRICE_FIELD_NUMBER = 7;
    public static final int IMAGE_URL_FIELD_NUMBER = 11;
    public static final int MARKET_ID_FIELD_NUMBER = 4;
    public static final int NUMBER_OF_PARTICIPANTS_FIELD_NUMBER = 10;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 6;
    public static final int PRODUCT_IMAGE_LOCATION_FIELD_NUMBER = 1;
    public static final int PRODUCT_IMAGE_NAME_FIELD_NUMBER = 2;
    public static final int PRODUCT_MESSAGE_FIELD_NUMBER = 3;
    public static final int SCORE_FIELD_NUMBER = 9;
    public static final int TITLE_FIELD_NUMBER = 5;
    public static final int URL_FIELD_NUMBER = 12;
    private int bitField0_;
    private Int32Value discountPercent_;
    private Int32Value finalPrice_;
    private StringValue imageUrl_;
    private StringValue marketId_;
    private Int32Value numberOfParticipants_;
    private Int32Value price_;
    private FilesStruct$ImageLocation productImageLocation_;
    private String productImageName_ = "";
    private MessagingStruct$HistoryMessageIdentifier productMessage_;
    private StringValue score_;
    private StringValue title_;
    private StringValue url_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9742aU3 {
        private a() {
            super(MarketStruct$Product.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$Product marketStruct$Product = new MarketStruct$Product();
        DEFAULT_INSTANCE = marketStruct$Product;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$Product.class, marketStruct$Product);
    }

    private MarketStruct$Product() {
    }

    private void clearDiscountPercent() {
        this.discountPercent_ = null;
        this.bitField0_ &= -65;
    }

    private void clearFinalPrice() {
        this.finalPrice_ = null;
        this.bitField0_ &= -33;
    }

    private void clearImageUrl() {
        this.imageUrl_ = null;
        this.bitField0_ &= -513;
    }

    private void clearMarketId() {
        this.marketId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearNumberOfParticipants() {
        this.numberOfParticipants_ = null;
        this.bitField0_ &= -257;
    }

    private void clearPrice() {
        this.price_ = null;
        this.bitField0_ &= -17;
    }

    private void clearProductImageLocation() {
        this.productImageLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearProductImageName() {
        this.productImageName_ = getDefaultInstance().getProductImageName();
    }

    private void clearProductMessage() {
        this.productMessage_ = null;
        this.bitField0_ &= -3;
    }

    private void clearScore() {
        this.score_ = null;
        this.bitField0_ &= -129;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -9;
    }

    private void clearUrl() {
        this.url_ = null;
        this.bitField0_ &= -1025;
    }

    public static MarketStruct$Product getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDiscountPercent(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.discountPercent_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.discountPercent_ = int32Value;
        } else {
            this.discountPercent_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.discountPercent_).v(int32Value)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeFinalPrice(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.finalPrice_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.finalPrice_ = int32Value;
        } else {
            this.finalPrice_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.finalPrice_).v(int32Value)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeImageUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.imageUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.imageUrl_ = stringValue;
        } else {
            this.imageUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.imageUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeMarketId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.marketId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.marketId_ = stringValue;
        } else {
            this.marketId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.marketId_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeNumberOfParticipants(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.numberOfParticipants_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.numberOfParticipants_ = int32Value;
        } else {
            this.numberOfParticipants_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.numberOfParticipants_).v(int32Value)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergePrice(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.price_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.price_ = int32Value;
        } else {
            this.price_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.price_).v(int32Value)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeProductImageLocation(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.productImageLocation_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.productImageLocation_ = filesStruct$ImageLocation;
        } else {
            this.productImageLocation_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.productImageLocation_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeProductMessage(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.productMessage_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.productMessage_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.productMessage_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.productMessage_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeScore(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.score_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.score_ = stringValue;
        } else {
            this.score_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.score_).v(stringValue)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.title_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.title_ = stringValue;
        } else {
            this.title_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.title_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.url_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.url_ = stringValue;
        } else {
            this.url_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.url_).v(stringValue)).j();
        }
        this.bitField0_ |= 1024;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$Product parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$Product) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$Product parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscountPercent(Int32Value int32Value) {
        int32Value.getClass();
        this.discountPercent_ = int32Value;
        this.bitField0_ |= 64;
    }

    private void setFinalPrice(Int32Value int32Value) {
        int32Value.getClass();
        this.finalPrice_ = int32Value;
        this.bitField0_ |= 32;
    }

    private void setImageUrl(StringValue stringValue) {
        stringValue.getClass();
        this.imageUrl_ = stringValue;
        this.bitField0_ |= 512;
    }

    private void setMarketId(StringValue stringValue) {
        stringValue.getClass();
        this.marketId_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setNumberOfParticipants(Int32Value int32Value) {
        int32Value.getClass();
        this.numberOfParticipants_ = int32Value;
        this.bitField0_ |= 256;
    }

    private void setPrice(Int32Value int32Value) {
        int32Value.getClass();
        this.price_ = int32Value;
        this.bitField0_ |= 16;
    }

    private void setProductImageLocation(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.productImageLocation_ = filesStruct$ImageLocation;
        this.bitField0_ |= 1;
    }

    private void setProductImageName(String str) {
        str.getClass();
        this.productImageName_ = str;
    }

    private void setProductImageNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.productImageName_ = abstractC2383g.f0();
    }

    private void setProductMessage(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.productMessage_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 2;
    }

    private void setScore(StringValue stringValue) {
        stringValue.getClass();
        this.score_ = stringValue;
        this.bitField0_ |= 128;
    }

    private void setTitle(StringValue stringValue) {
        stringValue.getClass();
        this.title_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setUrl(StringValue stringValue) {
        stringValue.getClass();
        this.url_ = stringValue;
        this.bitField0_ |= 1024;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$Product();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006ဉ\u0004\u0007ဉ\u0005\bဉ\u0006\tဉ\u0007\nဉ\b\u000bဉ\t\fဉ\n", new Object[]{"bitField0_", "productImageLocation_", "productImageName_", "productMessage_", "marketId_", "title_", "price_", "finalPrice_", "discountPercent_", "score_", "numberOfParticipants_", "imageUrl_", "url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$Product.class) {
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

    public Int32Value getDiscountPercent() {
        Int32Value int32Value = this.discountPercent_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getFinalPrice() {
        Int32Value int32Value = this.finalPrice_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public StringValue getImageUrl() {
        StringValue stringValue = this.imageUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getMarketId() {
        StringValue stringValue = this.marketId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public Int32Value getNumberOfParticipants() {
        Int32Value int32Value = this.numberOfParticipants_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getPrice() {
        Int32Value int32Value = this.price_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public FilesStruct$ImageLocation getProductImageLocation() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.productImageLocation_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public String getProductImageName() {
        return this.productImageName_;
    }

    public AbstractC2383g getProductImageNameBytes() {
        return AbstractC2383g.N(this.productImageName_);
    }

    public MessagingStruct$HistoryMessageIdentifier getProductMessage() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.productMessage_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public StringValue getScore() {
        StringValue stringValue = this.score_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getTitle() {
        StringValue stringValue = this.title_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getUrl() {
        StringValue stringValue = this.url_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasDiscountPercent() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasFinalPrice() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasImageUrl() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasMarketId() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasNumberOfParticipants() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasPrice() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasProductImageLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasProductMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasScore() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1024) != 0;
    }

    public static a newBuilder(MarketStruct$Product marketStruct$Product) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$Product);
    }

    public static MarketStruct$Product parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$Product) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$Product parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$Product parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$Product parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$Product parseFrom(byte[] bArr) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$Product parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$Product parseFrom(InputStream inputStream) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$Product parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$Product parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$Product parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$Product) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
