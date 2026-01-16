package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5190Ih;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetUsersAuthDataByState extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetUsersAuthDataByState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERS_DATA_FIELD_NUMBER = 1;
    private B.j usersData_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetUsersAuthDataByState.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetUsersAuthDataByState advertisementOuterClass$ResponseGetUsersAuthDataByState = new AdvertisementOuterClass$ResponseGetUsersAuthDataByState();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetUsersAuthDataByState;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetUsersAuthDataByState.class, advertisementOuterClass$ResponseGetUsersAuthDataByState);
    }

    private AdvertisementOuterClass$ResponseGetUsersAuthDataByState() {
    }

    private void addAllUsersData(Iterable<? extends AdvertisementStruct$UserAuthData> iterable) {
        ensureUsersDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.usersData_);
    }

    private void addUsersData(AdvertisementStruct$UserAuthData advertisementStruct$UserAuthData) {
        advertisementStruct$UserAuthData.getClass();
        ensureUsersDataIsMutable();
        this.usersData_.add(advertisementStruct$UserAuthData);
    }

    private void clearUsersData() {
        this.usersData_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersDataIsMutable() {
        B.j jVar = this.usersData_;
        if (jVar.u()) {
            return;
        }
        this.usersData_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsersData(int i) {
        ensureUsersDataIsMutable();
        this.usersData_.remove(i);
    }

    private void setUsersData(int i, AdvertisementStruct$UserAuthData advertisementStruct$UserAuthData) {
        advertisementStruct$UserAuthData.getClass();
        ensureUsersDataIsMutable();
        this.usersData_.set(i, advertisementStruct$UserAuthData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetUsersAuthDataByState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"usersData_", AdvertisementStruct$UserAuthData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetUsersAuthDataByState.class) {
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

    public AdvertisementStruct$UserAuthData getUsersData(int i) {
        return (AdvertisementStruct$UserAuthData) this.usersData_.get(i);
    }

    public int getUsersDataCount() {
        return this.usersData_.size();
    }

    public List<AdvertisementStruct$UserAuthData> getUsersDataList() {
        return this.usersData_;
    }

    public InterfaceC5190Ih getUsersDataOrBuilder(int i) {
        return (InterfaceC5190Ih) this.usersData_.get(i);
    }

    public List<? extends InterfaceC5190Ih> getUsersDataOrBuilderList() {
        return this.usersData_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetUsersAuthDataByState advertisementOuterClass$ResponseGetUsersAuthDataByState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetUsersAuthDataByState);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsersData(int i, AdvertisementStruct$UserAuthData advertisementStruct$UserAuthData) {
        advertisementStruct$UserAuthData.getClass();
        ensureUsersDataIsMutable();
        this.usersData_.add(i, advertisementStruct$UserAuthData);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetUsersAuthDataByState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUsersAuthDataByState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
