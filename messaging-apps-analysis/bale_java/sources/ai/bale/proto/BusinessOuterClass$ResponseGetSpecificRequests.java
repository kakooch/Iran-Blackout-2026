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
public final class BusinessOuterClass$ResponseGetSpecificRequests extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$ResponseGetSpecificRequests DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTS_FIELD_NUMBER = 1;
    private B.j requests_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$ResponseGetSpecificRequests.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$ResponseGetSpecificRequests businessOuterClass$ResponseGetSpecificRequests = new BusinessOuterClass$ResponseGetSpecificRequests();
        DEFAULT_INSTANCE = businessOuterClass$ResponseGetSpecificRequests;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$ResponseGetSpecificRequests.class, businessOuterClass$ResponseGetSpecificRequests);
    }

    private BusinessOuterClass$ResponseGetSpecificRequests() {
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

    public static BusinessOuterClass$ResponseGetSpecificRequests getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$ResponseGetSpecificRequests();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"requests_", BusinessStruct$BusinessRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$ResponseGetSpecificRequests.class) {
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

    public static a newBuilder(BusinessOuterClass$ResponseGetSpecificRequests businessOuterClass$ResponseGetSpecificRequests) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$ResponseGetSpecificRequests);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRequests(int i, BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.add(i, businessStruct$BusinessRequest);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(byte[] bArr) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$ResponseGetSpecificRequests parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
