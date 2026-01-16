package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5484Jn5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$ResponseIsPremiumBatch extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$ResponseIsPremiumBatch DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERS_STATUS_FIELD_NUMBER = 1;
    private B.j usersStatus_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$ResponseIsPremiumBatch.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$ResponseIsPremiumBatch premiumOuterClass$ResponseIsPremiumBatch = new PremiumOuterClass$ResponseIsPremiumBatch();
        DEFAULT_INSTANCE = premiumOuterClass$ResponseIsPremiumBatch;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$ResponseIsPremiumBatch.class, premiumOuterClass$ResponseIsPremiumBatch);
    }

    private PremiumOuterClass$ResponseIsPremiumBatch() {
    }

    private void addAllUsersStatus(Iterable<? extends PremiumStruct$UserPremiumStatus> iterable) {
        ensureUsersStatusIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.usersStatus_);
    }

    private void addUsersStatus(PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus) {
        premiumStruct$UserPremiumStatus.getClass();
        ensureUsersStatusIsMutable();
        this.usersStatus_.add(premiumStruct$UserPremiumStatus);
    }

    private void clearUsersStatus() {
        this.usersStatus_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersStatusIsMutable() {
        B.j jVar = this.usersStatus_;
        if (jVar.u()) {
            return;
        }
        this.usersStatus_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsersStatus(int i) {
        ensureUsersStatusIsMutable();
        this.usersStatus_.remove(i);
    }

    private void setUsersStatus(int i, PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus) {
        premiumStruct$UserPremiumStatus.getClass();
        ensureUsersStatusIsMutable();
        this.usersStatus_.set(i, premiumStruct$UserPremiumStatus);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$ResponseIsPremiumBatch();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"usersStatus_", PremiumStruct$UserPremiumStatus.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$ResponseIsPremiumBatch.class) {
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

    public PremiumStruct$UserPremiumStatus getUsersStatus(int i) {
        return (PremiumStruct$UserPremiumStatus) this.usersStatus_.get(i);
    }

    public int getUsersStatusCount() {
        return this.usersStatus_.size();
    }

    public List<PremiumStruct$UserPremiumStatus> getUsersStatusList() {
        return this.usersStatus_;
    }

    public InterfaceC5484Jn5 getUsersStatusOrBuilder(int i) {
        return (InterfaceC5484Jn5) this.usersStatus_.get(i);
    }

    public List<? extends InterfaceC5484Jn5> getUsersStatusOrBuilderList() {
        return this.usersStatus_;
    }

    public static a newBuilder(PremiumOuterClass$ResponseIsPremiumBatch premiumOuterClass$ResponseIsPremiumBatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$ResponseIsPremiumBatch);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsersStatus(int i, PremiumStruct$UserPremiumStatus premiumStruct$UserPremiumStatus) {
        premiumStruct$UserPremiumStatus.getClass();
        ensureUsersStatusIsMutable();
        this.usersStatus_.add(i, premiumStruct$UserPremiumStatus);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(byte[] bArr) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$ResponseIsPremiumBatch parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$ResponseIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
