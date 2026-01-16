package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3996Dg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor DEFAULT_INSTANCE;
    public static final int FACTORS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j factors_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor advertisementOuterClass$ResponseGetAllChannelIncomesFactor = new AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAllChannelIncomesFactor;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor.class, advertisementOuterClass$ResponseGetAllChannelIncomesFactor);
    }

    private AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor() {
    }

    private void addAllFactors(Iterable<? extends AdvertisementStruct$ChannelIncomeFactor> iterable) {
        ensureFactorsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.factors_);
    }

    private void addFactors(AdvertisementStruct$ChannelIncomeFactor advertisementStruct$ChannelIncomeFactor) {
        advertisementStruct$ChannelIncomeFactor.getClass();
        ensureFactorsIsMutable();
        this.factors_.add(advertisementStruct$ChannelIncomeFactor);
    }

    private void clearFactors() {
        this.factors_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFactorsIsMutable() {
        B.j jVar = this.factors_;
        if (jVar.u()) {
            return;
        }
        this.factors_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFactors(int i) {
        ensureFactorsIsMutable();
        this.factors_.remove(i);
    }

    private void setFactors(int i, AdvertisementStruct$ChannelIncomeFactor advertisementStruct$ChannelIncomeFactor) {
        advertisementStruct$ChannelIncomeFactor.getClass();
        ensureFactorsIsMutable();
        this.factors_.set(i, advertisementStruct$ChannelIncomeFactor);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"factors_", AdvertisementStruct$ChannelIncomeFactor.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor.class) {
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

    public AdvertisementStruct$ChannelIncomeFactor getFactors(int i) {
        return (AdvertisementStruct$ChannelIncomeFactor) this.factors_.get(i);
    }

    public int getFactorsCount() {
        return this.factors_.size();
    }

    public List<AdvertisementStruct$ChannelIncomeFactor> getFactorsList() {
        return this.factors_;
    }

    public InterfaceC3996Dg getFactorsOrBuilder(int i) {
        return (InterfaceC3996Dg) this.factors_.get(i);
    }

    public List<? extends InterfaceC3996Dg> getFactorsOrBuilderList() {
        return this.factors_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor advertisementOuterClass$ResponseGetAllChannelIncomesFactor) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAllChannelIncomesFactor);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFactors(int i, AdvertisementStruct$ChannelIncomeFactor advertisementStruct$ChannelIncomeFactor) {
        advertisementStruct$ChannelIncomeFactor.getClass();
        ensureFactorsIsMutable();
        this.factors_.add(i, advertisementStruct$ChannelIncomeFactor);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAllChannelIncomesFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
