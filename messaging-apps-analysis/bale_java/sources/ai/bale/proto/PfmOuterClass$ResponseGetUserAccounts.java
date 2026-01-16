package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmConfig;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.E75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PfmOuterClass$ResponseGetUserAccounts extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNTS_FIELD_NUMBER = 1;
    public static final int CONFIG_FIELD_NUMBER = 2;
    private static final PfmOuterClass$ResponseGetUserAccounts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j accounts_ = GeneratedMessageLite.emptyProtobufList();
    private int bitField0_;
    private PfmStruct$PfmConfig config_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$ResponseGetUserAccounts.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$ResponseGetUserAccounts pfmOuterClass$ResponseGetUserAccounts = new PfmOuterClass$ResponseGetUserAccounts();
        DEFAULT_INSTANCE = pfmOuterClass$ResponseGetUserAccounts;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$ResponseGetUserAccounts.class, pfmOuterClass$ResponseGetUserAccounts);
    }

    private PfmOuterClass$ResponseGetUserAccounts() {
    }

    private void addAccounts(PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount) {
        pfmStruct$PfmUserAccount.getClass();
        ensureAccountsIsMutable();
        this.accounts_.add(pfmStruct$PfmUserAccount);
    }

    private void addAllAccounts(Iterable<? extends PfmStruct$PfmUserAccount> iterable) {
        ensureAccountsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.accounts_);
    }

    private void clearAccounts() {
        this.accounts_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureAccountsIsMutable() {
        B.j jVar = this.accounts_;
        if (jVar.u()) {
            return;
        }
        this.accounts_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PfmOuterClass$ResponseGetUserAccounts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(PfmStruct$PfmConfig pfmStruct$PfmConfig) {
        pfmStruct$PfmConfig.getClass();
        PfmStruct$PfmConfig pfmStruct$PfmConfig2 = this.config_;
        if (pfmStruct$PfmConfig2 == null || pfmStruct$PfmConfig2 == PfmStruct$PfmConfig.getDefaultInstance()) {
            this.config_ = pfmStruct$PfmConfig;
        } else {
            this.config_ = (PfmStruct$PfmConfig) ((PfmStruct$PfmConfig.a) PfmStruct$PfmConfig.newBuilder(this.config_).v(pfmStruct$PfmConfig)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAccounts(int i) {
        ensureAccountsIsMutable();
        this.accounts_.remove(i);
    }

    private void setAccounts(int i, PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount) {
        pfmStruct$PfmUserAccount.getClass();
        ensureAccountsIsMutable();
        this.accounts_.set(i, pfmStruct$PfmUserAccount);
    }

    private void setConfig(PfmStruct$PfmConfig pfmStruct$PfmConfig) {
        pfmStruct$PfmConfig.getClass();
        this.config_ = pfmStruct$PfmConfig;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$ResponseGetUserAccounts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "accounts_", PfmStruct$PfmUserAccount.class, "config_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$ResponseGetUserAccounts.class) {
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

    public PfmStruct$PfmUserAccount getAccounts(int i) {
        return (PfmStruct$PfmUserAccount) this.accounts_.get(i);
    }

    public int getAccountsCount() {
        return this.accounts_.size();
    }

    public List<PfmStruct$PfmUserAccount> getAccountsList() {
        return this.accounts_;
    }

    public E75 getAccountsOrBuilder(int i) {
        return (E75) this.accounts_.get(i);
    }

    public List<? extends E75> getAccountsOrBuilderList() {
        return this.accounts_;
    }

    public PfmStruct$PfmConfig getConfig() {
        PfmStruct$PfmConfig pfmStruct$PfmConfig = this.config_;
        return pfmStruct$PfmConfig == null ? PfmStruct$PfmConfig.getDefaultInstance() : pfmStruct$PfmConfig;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$ResponseGetUserAccounts pfmOuterClass$ResponseGetUserAccounts) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$ResponseGetUserAccounts);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAccounts(int i, PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount) {
        pfmStruct$PfmUserAccount.getClass();
        ensureAccountsIsMutable();
        this.accounts_.add(i, pfmStruct$PfmUserAccount);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(byte[] bArr) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(InputStream inputStream) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$ResponseGetUserAccounts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$ResponseGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
