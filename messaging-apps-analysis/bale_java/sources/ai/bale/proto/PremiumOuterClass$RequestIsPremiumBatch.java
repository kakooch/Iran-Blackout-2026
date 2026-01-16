package ai.bale.proto;

import ai.bale.proto.PremiumStruct$WithDetailOption;
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
public final class PremiumOuterClass$RequestIsPremiumBatch extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$RequestIsPremiumBatch DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_IDS_FIELD_NUMBER = 1;
    public static final int WITH_DETAIL_OPTION_FIELD_NUMBER = 2;
    private int bitField0_;
    private int userIdsMemoizedSerializedSize = -1;
    private B.g userIds_ = GeneratedMessageLite.emptyIntList();
    private PremiumStruct$WithDetailOption withDetailOption_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PremiumOuterClass$RequestIsPremiumBatch) this.b).addAllUserIds(iterable);
            return this;
        }

        public a B(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
            q();
            ((PremiumOuterClass$RequestIsPremiumBatch) this.b).setWithDetailOption(premiumStruct$WithDetailOption);
            return this;
        }

        private a() {
            super(PremiumOuterClass$RequestIsPremiumBatch.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$RequestIsPremiumBatch premiumOuterClass$RequestIsPremiumBatch = new PremiumOuterClass$RequestIsPremiumBatch();
        DEFAULT_INSTANCE = premiumOuterClass$RequestIsPremiumBatch;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$RequestIsPremiumBatch.class, premiumOuterClass$RequestIsPremiumBatch);
    }

    private PremiumOuterClass$RequestIsPremiumBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUserIds(Iterable<? extends Integer> iterable) {
        ensureUserIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userIds_);
    }

    private void addUserIds(int i) {
        ensureUserIdsIsMutable();
        this.userIds_.b1(i);
    }

    private void clearUserIds() {
        this.userIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearWithDetailOption() {
        this.withDetailOption_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureUserIdsIsMutable() {
        B.g gVar = this.userIds_;
        if (gVar.u()) {
            return;
        }
        this.userIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeWithDetailOption(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
        premiumStruct$WithDetailOption.getClass();
        PremiumStruct$WithDetailOption premiumStruct$WithDetailOption2 = this.withDetailOption_;
        if (premiumStruct$WithDetailOption2 == null || premiumStruct$WithDetailOption2 == PremiumStruct$WithDetailOption.getDefaultInstance()) {
            this.withDetailOption_ = premiumStruct$WithDetailOption;
        } else {
            this.withDetailOption_ = (PremiumStruct$WithDetailOption) ((PremiumStruct$WithDetailOption.a) PremiumStruct$WithDetailOption.newBuilder(this.withDetailOption_).v(premiumStruct$WithDetailOption)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserIds(int i, int i2) {
        ensureUserIdsIsMutable();
        this.userIds_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWithDetailOption(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
        premiumStruct$WithDetailOption.getClass();
        this.withDetailOption_ = premiumStruct$WithDetailOption;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$RequestIsPremiumBatch();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001'\u0002ဉ\u0000", new Object[]{"bitField0_", "userIds_", "withDetailOption_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$RequestIsPremiumBatch.class) {
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

    public int getUserIds(int i) {
        return this.userIds_.getInt(i);
    }

    public int getUserIdsCount() {
        return this.userIds_.size();
    }

    public List<Integer> getUserIdsList() {
        return this.userIds_;
    }

    public PremiumStruct$WithDetailOption getWithDetailOption() {
        PremiumStruct$WithDetailOption premiumStruct$WithDetailOption = this.withDetailOption_;
        return premiumStruct$WithDetailOption == null ? PremiumStruct$WithDetailOption.getDefaultInstance() : premiumStruct$WithDetailOption;
    }

    public boolean hasWithDetailOption() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PremiumOuterClass$RequestIsPremiumBatch premiumOuterClass$RequestIsPremiumBatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$RequestIsPremiumBatch);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(byte[] bArr) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$RequestIsPremiumBatch parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$RequestIsPremiumBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
