package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.R60;
import ir.nasim.T60;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Microbanki$ResponseGetMoneyRequestPaymentList extends GeneratedMessageLite implements U64 {
    private static final Microbanki$ResponseGetMoneyRequestPaymentList DEFAULT_INSTANCE;
    public static final int GROUP_PEERS_FIELD_NUMBER = 5;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_FIELD_NUMBER = 1;
    public static final int RESPONSE_TYPE_FIELD_NUMBER = 3;
    public static final int USER_PEERS_FIELD_NUMBER = 4;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private int responseType_;
    private B.j payment_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Microbanki$ResponseGetMoneyRequestPaymentList.DEFAULT_INSTANCE);
        }
    }

    static {
        Microbanki$ResponseGetMoneyRequestPaymentList microbanki$ResponseGetMoneyRequestPaymentList = new Microbanki$ResponseGetMoneyRequestPaymentList();
        DEFAULT_INSTANCE = microbanki$ResponseGetMoneyRequestPaymentList;
        GeneratedMessageLite.registerDefaultInstance(Microbanki$ResponseGetMoneyRequestPaymentList.class, microbanki$ResponseGetMoneyRequestPaymentList);
    }

    private Microbanki$ResponseGetMoneyRequestPaymentList() {
    }

    private void addAllGroupPeers(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupPeers_);
    }

    private void addAllPayment(Iterable<? extends BankStruct$MoneyRequestPayment> iterable) {
        ensurePaymentIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.payment_);
    }

    private void addAllUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPeers_);
    }

    private void addGroupPeers(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.add(peersStruct$GroupOutPeer);
    }

    private void addPayment(BankStruct$MoneyRequestPayment bankStruct$MoneyRequestPayment) {
        bankStruct$MoneyRequestPayment.getClass();
        ensurePaymentIsMutable();
        this.payment_.add(bankStruct$MoneyRequestPayment);
    }

    private void addUserPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(peersStruct$UserOutPeer);
    }

    private void clearGroupPeers() {
        this.groupPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPayment() {
        this.payment_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearResponseType() {
        this.responseType_ = 0;
    }

    private void clearUserPeers() {
        this.userPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupPeersIsMutable() {
        B.j jVar = this.groupPeers_;
        if (jVar.u()) {
            return;
        }
        this.groupPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePaymentIsMutable() {
        B.j jVar = this.payment_;
        if (jVar.u()) {
            return;
        }
        this.payment_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUserPeersIsMutable() {
        B.j jVar = this.userPeers_;
        if (jVar.u()) {
            return;
        }
        this.userPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseDelimitedFrom(InputStream inputStream) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(ByteBuffer byteBuffer) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroupPeers(int i) {
        ensureGroupPeersIsMutable();
        this.groupPeers_.remove(i);
    }

    private void removePayment(int i) {
        ensurePaymentIsMutable();
        this.payment_.remove(i);
    }

    private void removeUserPeers(int i) {
        ensureUserPeersIsMutable();
        this.userPeers_.remove(i);
    }

    private void setGroupPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.set(i, peersStruct$GroupOutPeer);
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setPayment(int i, BankStruct$MoneyRequestPayment bankStruct$MoneyRequestPayment) {
        bankStruct$MoneyRequestPayment.getClass();
        ensurePaymentIsMutable();
        this.payment_.set(i, bankStruct$MoneyRequestPayment);
    }

    private void setResponseType(R60 r60) {
        this.responseType_ = r60.getNumber();
    }

    private void setResponseTypeValue(int i) {
        this.responseType_ = i;
    }

    private void setUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M0.a[gVar.ordinal()]) {
            case 1:
                return new Microbanki$ResponseGetMoneyRequestPaymentList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u001b\u0002ဉ\u0000\u0003\f\u0004\u001b\u0005\u001b", new Object[]{"bitField0_", "payment_", BankStruct$MoneyRequestPayment.class, "loadMoreState_", "responseType_", "userPeers_", PeersStruct$UserOutPeer.class, "groupPeers_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Microbanki$ResponseGetMoneyRequestPaymentList.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeers(int i) {
        return (PeersStruct$GroupOutPeer) this.groupPeers_.get(i);
    }

    public int getGroupPeersCount() {
        return this.groupPeers_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupPeersList() {
        return this.groupPeers_;
    }

    public InterfaceC11468d35 getGroupPeersOrBuilder(int i) {
        return (InterfaceC11468d35) this.groupPeers_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupPeersOrBuilderList() {
        return this.groupPeers_;
    }

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public BankStruct$MoneyRequestPayment getPayment(int i) {
        return (BankStruct$MoneyRequestPayment) this.payment_.get(i);
    }

    public int getPaymentCount() {
        return this.payment_.size();
    }

    public List<BankStruct$MoneyRequestPayment> getPaymentList() {
        return this.payment_;
    }

    public T60 getPaymentOrBuilder(int i) {
        return (T60) this.payment_.get(i);
    }

    public List<? extends T60> getPaymentOrBuilderList() {
        return this.payment_;
    }

    public R60 getResponseType() {
        R60 r60J = R60.j(this.responseType_);
        return r60J == null ? R60.UNRECOGNIZED : r60J;
    }

    public int getResponseTypeValue() {
        return this.responseType_;
    }

    public PeersStruct$UserOutPeer getUserPeers(int i) {
        return (PeersStruct$UserOutPeer) this.userPeers_.get(i);
    }

    public int getUserPeersCount() {
        return this.userPeers_.size();
    }

    public List<PeersStruct$UserOutPeer> getUserPeersList() {
        return this.userPeers_;
    }

    public InterfaceC18084o35 getUserPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.userPeers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUserPeersOrBuilderList() {
        return this.userPeers_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Microbanki$ResponseGetMoneyRequestPaymentList microbanki$ResponseGetMoneyRequestPaymentList) {
        return (a) DEFAULT_INSTANCE.createBuilder(microbanki$ResponseGetMoneyRequestPaymentList);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(AbstractC2383g abstractC2383g) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroupPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.add(i, peersStruct$GroupOutPeer);
    }

    private void addPayment(int i, BankStruct$MoneyRequestPayment bankStruct$MoneyRequestPayment) {
        bankStruct$MoneyRequestPayment.getClass();
        ensurePaymentIsMutable();
        this.payment_.add(i, bankStruct$MoneyRequestPayment);
    }

    private void addUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(i, peersStruct$UserOutPeer);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(byte[] bArr) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(byte[] bArr, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(InputStream inputStream) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(AbstractC2384h abstractC2384h) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Microbanki$ResponseGetMoneyRequestPaymentList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestPaymentList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
