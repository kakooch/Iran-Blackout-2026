package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22121ui;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Advertisementnew$ResponseGetBonusCodes extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetBonusCodes DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j data_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetBonusCodes.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetBonusCodes advertisementnew$ResponseGetBonusCodes = new Advertisementnew$ResponseGetBonusCodes();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetBonusCodes;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetBonusCodes.class, advertisementnew$ResponseGetBonusCodes);
    }

    private Advertisementnew$ResponseGetBonusCodes() {
    }

    private void addAllData(Iterable<? extends AdvertisementnewStruct$BonusCodeData> iterable) {
        ensureDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.data_);
    }

    private void addData(AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData) {
        advertisementnewStruct$BonusCodeData.getClass();
        ensureDataIsMutable();
        this.data_.add(advertisementnewStruct$BonusCodeData);
    }

    private void clearData() {
        this.data_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataIsMutable() {
        B.j jVar = this.data_;
        if (jVar.u()) {
            return;
        }
        this.data_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Advertisementnew$ResponseGetBonusCodes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetBonusCodes parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    private void setData(int i, AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData) {
        advertisementnewStruct$BonusCodeData.getClass();
        ensureDataIsMutable();
        this.data_.set(i, advertisementnewStruct$BonusCodeData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetBonusCodes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", AdvertisementnewStruct$BonusCodeData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetBonusCodes.class) {
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

    public AdvertisementnewStruct$BonusCodeData getData(int i) {
        return (AdvertisementnewStruct$BonusCodeData) this.data_.get(i);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<AdvertisementnewStruct$BonusCodeData> getDataList() {
        return this.data_;
    }

    public InterfaceC22121ui getDataOrBuilder(int i) {
        return (InterfaceC22121ui) this.data_.get(i);
    }

    public List<? extends InterfaceC22121ui> getDataOrBuilderList() {
        return this.data_;
    }

    public static a newBuilder(Advertisementnew$ResponseGetBonusCodes advertisementnew$ResponseGetBonusCodes) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetBonusCodes);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addData(int i, AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData) {
        advertisementnewStruct$BonusCodeData.getClass();
        ensureDataIsMutable();
        this.data_.add(i, advertisementnewStruct$BonusCodeData);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetBonusCodes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
