package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5318Iv1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Crowdfunding$ResponseGetParticipants extends GeneratedMessageLite implements U64 {
    private static final Crowdfunding$ResponseGetParticipants DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_PAYMENTS_FIELD_NUMBER = 1;
    private B.j userPayments_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Crowdfunding$ResponseGetParticipants.DEFAULT_INSTANCE);
        }
    }

    static {
        Crowdfunding$ResponseGetParticipants crowdfunding$ResponseGetParticipants = new Crowdfunding$ResponseGetParticipants();
        DEFAULT_INSTANCE = crowdfunding$ResponseGetParticipants;
        GeneratedMessageLite.registerDefaultInstance(Crowdfunding$ResponseGetParticipants.class, crowdfunding$ResponseGetParticipants);
    }

    private Crowdfunding$ResponseGetParticipants() {
    }

    private void addAllUserPayments(Iterable<? extends CrowdfundingStruct$UserPayment> iterable) {
        ensureUserPaymentsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPayments_);
    }

    private void addUserPayments(CrowdfundingStruct$UserPayment crowdfundingStruct$UserPayment) {
        crowdfundingStruct$UserPayment.getClass();
        ensureUserPaymentsIsMutable();
        this.userPayments_.add(crowdfundingStruct$UserPayment);
    }

    private void clearUserPayments() {
        this.userPayments_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserPaymentsIsMutable() {
        B.j jVar = this.userPayments_;
        if (jVar.u()) {
            return;
        }
        this.userPayments_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Crowdfunding$ResponseGetParticipants getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Crowdfunding$ResponseGetParticipants parseDelimitedFrom(InputStream inputStream) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(ByteBuffer byteBuffer) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserPayments(int i) {
        ensureUserPaymentsIsMutable();
        this.userPayments_.remove(i);
    }

    private void setUserPayments(int i, CrowdfundingStruct$UserPayment crowdfundingStruct$UserPayment) {
        crowdfundingStruct$UserPayment.getClass();
        ensureUserPaymentsIsMutable();
        this.userPayments_.set(i, crowdfundingStruct$UserPayment);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K.a[gVar.ordinal()]) {
            case 1:
                return new Crowdfunding$ResponseGetParticipants();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userPayments_", CrowdfundingStruct$UserPayment.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Crowdfunding$ResponseGetParticipants.class) {
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

    public CrowdfundingStruct$UserPayment getUserPayments(int i) {
        return (CrowdfundingStruct$UserPayment) this.userPayments_.get(i);
    }

    public int getUserPaymentsCount() {
        return this.userPayments_.size();
    }

    public List<CrowdfundingStruct$UserPayment> getUserPaymentsList() {
        return this.userPayments_;
    }

    public InterfaceC5318Iv1 getUserPaymentsOrBuilder(int i) {
        return (InterfaceC5318Iv1) this.userPayments_.get(i);
    }

    public List<? extends InterfaceC5318Iv1> getUserPaymentsOrBuilderList() {
        return this.userPayments_;
    }

    public static a newBuilder(Crowdfunding$ResponseGetParticipants crowdfunding$ResponseGetParticipants) {
        return (a) DEFAULT_INSTANCE.createBuilder(crowdfunding$ResponseGetParticipants);
    }

    public static Crowdfunding$ResponseGetParticipants parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(AbstractC2383g abstractC2383g) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserPayments(int i, CrowdfundingStruct$UserPayment crowdfundingStruct$UserPayment) {
        crowdfundingStruct$UserPayment.getClass();
        ensureUserPaymentsIsMutable();
        this.userPayments_.add(i, crowdfundingStruct$UserPayment);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(byte[] bArr) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(byte[] bArr, C2394s c2394s) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(InputStream inputStream) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(AbstractC2384h abstractC2384h) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Crowdfunding$ResponseGetParticipants parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Crowdfunding$ResponseGetParticipants) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
