package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23277wf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAccounts extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetAccounts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j data_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAccounts.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAccounts advertisementOuterClass$ResponseGetAccounts = new AdvertisementOuterClass$ResponseGetAccounts();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAccounts;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAccounts.class, advertisementOuterClass$ResponseGetAccounts);
    }

    private AdvertisementOuterClass$ResponseGetAccounts() {
    }

    private void addAllData(Iterable<? extends AdvertisementStruct$AccountData> iterable) {
        ensureDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.data_);
    }

    private void addData(AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        ensureDataIsMutable();
        this.data_.add(advertisementStruct$AccountData);
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

    public static AdvertisementOuterClass$ResponseGetAccounts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    private void setData(int i, AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        ensureDataIsMutable();
        this.data_.set(i, advertisementStruct$AccountData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAccounts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", AdvertisementStruct$AccountData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAccounts.class) {
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

    public AdvertisementStruct$AccountData getData(int i) {
        return (AdvertisementStruct$AccountData) this.data_.get(i);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<AdvertisementStruct$AccountData> getDataList() {
        return this.data_;
    }

    public InterfaceC23277wf getDataOrBuilder(int i) {
        return (InterfaceC23277wf) this.data_.get(i);
    }

    public List<? extends InterfaceC23277wf> getDataOrBuilderList() {
        return this.data_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAccounts advertisementOuterClass$ResponseGetAccounts) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAccounts);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addData(int i, AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        advertisementStruct$AccountData.getClass();
        ensureDataIsMutable();
        this.data_.add(i, advertisementStruct$AccountData);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAccounts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
