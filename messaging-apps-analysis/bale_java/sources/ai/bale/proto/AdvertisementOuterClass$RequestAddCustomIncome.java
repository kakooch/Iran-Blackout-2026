package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9043Yg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestAddCustomIncome extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final AdvertisementOuterClass$RequestAddCustomIncome DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private long amount_;
    private String description_ = "";
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestAddCustomIncome.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestAddCustomIncome advertisementOuterClass$RequestAddCustomIncome = new AdvertisementOuterClass$RequestAddCustomIncome();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestAddCustomIncome;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestAddCustomIncome.class, advertisementOuterClass$RequestAddCustomIncome);
    }

    private AdvertisementOuterClass$RequestAddCustomIncome() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setType(EnumC9043Yg enumC9043Yg) {
        this.type_ = enumC9043Yg.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestAddCustomIncome();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ", new Object[]{"type_", "amount_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestAddCustomIncome.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public EnumC9043Yg getType() {
        EnumC9043Yg enumC9043YgJ = EnumC9043Yg.j(this.type_);
        return enumC9043YgJ == null ? EnumC9043Yg.UNRECOGNIZED : enumC9043YgJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestAddCustomIncome advertisementOuterClass$RequestAddCustomIncome) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestAddCustomIncome);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestAddCustomIncome parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddCustomIncome) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
