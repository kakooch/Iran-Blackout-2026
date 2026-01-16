package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9043Yg;
import ir.nasim.InterfaceC8768Xg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$CustomIncomeRecord extends GeneratedMessageLite implements InterfaceC8768Xg {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    public static final int CREATED_BY_FIELD_NUMBER = 6;
    private static final AdvertisementStruct$CustomIncomeRecord DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private long amount_;
    private long createdAt_;
    private int createdBy_;
    private int type_;
    private String id_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8768Xg {
        private a() {
            super(AdvertisementStruct$CustomIncomeRecord.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$CustomIncomeRecord advertisementStruct$CustomIncomeRecord = new AdvertisementStruct$CustomIncomeRecord();
        DEFAULT_INSTANCE = advertisementStruct$CustomIncomeRecord;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$CustomIncomeRecord.class, advertisementStruct$CustomIncomeRecord);
    }

    private AdvertisementStruct$CustomIncomeRecord() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearCreatedBy() {
        this.createdBy_ = 0;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static AdvertisementStruct$CustomIncomeRecord getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$CustomIncomeRecord parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setCreatedBy(int i) {
        this.createdBy_ = i;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setType(EnumC9043Yg enumC9043Yg) {
        this.type_ = enumC9043Yg.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$CustomIncomeRecord();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0004", new Object[]{"id_", "type_", "amount_", "description_", "createdAt_", "createdBy_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$CustomIncomeRecord.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public int getCreatedBy() {
        return this.createdBy_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public EnumC9043Yg getType() {
        EnumC9043Yg enumC9043YgJ = EnumC9043Yg.j(this.type_);
        return enumC9043YgJ == null ? EnumC9043Yg.UNRECOGNIZED : enumC9043YgJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(AdvertisementStruct$CustomIncomeRecord advertisementStruct$CustomIncomeRecord) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$CustomIncomeRecord);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(byte[] bArr) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$CustomIncomeRecord parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$CustomIncomeRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
