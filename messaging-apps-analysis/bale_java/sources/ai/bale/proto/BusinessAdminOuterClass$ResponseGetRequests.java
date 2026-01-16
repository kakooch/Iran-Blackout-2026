package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$ResponseGetRequests extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$ResponseGetRequests DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTS_FIELD_NUMBER = 1;
    private B.j requests_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$ResponseGetRequests.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$ResponseGetRequests businessAdminOuterClass$ResponseGetRequests = new BusinessAdminOuterClass$ResponseGetRequests();
        DEFAULT_INSTANCE = businessAdminOuterClass$ResponseGetRequests;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$ResponseGetRequests.class, businessAdminOuterClass$ResponseGetRequests);
    }

    private BusinessAdminOuterClass$ResponseGetRequests() {
    }

    private void addAllRequests(Iterable<? extends BusinessStruct$BusinessRequest> iterable) {
        ensureRequestsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.requests_);
    }

    private void addRequests(BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.add(businessStruct$BusinessRequest);
    }

    private void clearRequests() {
        this.requests_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRequestsIsMutable() {
        B.j jVar = this.requests_;
        if (jVar.u()) {
            return;
        }
        this.requests_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRequests(int i) {
        ensureRequestsIsMutable();
        this.requests_.remove(i);
    }

    private void setRequests(int i, BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.set(i, businessStruct$BusinessRequest);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$ResponseGetRequests();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"requests_", BusinessStruct$BusinessRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$ResponseGetRequests.class) {
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

    public BusinessStruct$BusinessRequest getRequests(int i) {
        return (BusinessStruct$BusinessRequest) this.requests_.get(i);
    }

    public int getRequestsCount() {
        return this.requests_.size();
    }

    public List<BusinessStruct$BusinessRequest> getRequestsList() {
        return this.requests_;
    }

    public InterfaceC1902w getRequestsOrBuilder(int i) {
        return (InterfaceC1902w) this.requests_.get(i);
    }

    public List<? extends InterfaceC1902w> getRequestsOrBuilderList() {
        return this.requests_;
    }

    public static a newBuilder(BusinessAdminOuterClass$ResponseGetRequests businessAdminOuterClass$ResponseGetRequests) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$ResponseGetRequests);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRequests(int i, BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.add(i, businessStruct$BusinessRequest);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$ResponseGetRequests parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
