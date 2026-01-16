package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$SipCall;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13929h35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetOuterClass$ResponseCall extends GeneratedMessageLite implements U64 {
    public static final int CALL_FIELD_NUMBER = 1;
    private static final MeetOuterClass$ResponseCall DEFAULT_INSTANCE;
    public static final int IS_STREAM_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 2;
    public static final int SEQ_FIELD_NUMBER = 3;
    public static final int SIP_CALL_FIELD_NUMBER = 4;
    private int bitField0_;
    private MeetStruct$Call call_;
    private CollectionsStruct$BooleanValue isStream_;
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();
    private int seq_;
    private MeetStruct$SipCall sipCall_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$ResponseCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$ResponseCall meetOuterClass$ResponseCall = new MeetOuterClass$ResponseCall();
        DEFAULT_INSTANCE = meetOuterClass$ResponseCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$ResponseCall.class, meetOuterClass$ResponseCall);
    }

    private MeetOuterClass$ResponseCall() {
    }

    private void addAllParticipants(Iterable<? extends PeersStruct$OutPeer> iterable) {
        ensureParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.participants_);
    }

    private void addParticipants(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(peersStruct$OutPeer);
    }

    private void clearCall() {
        this.call_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsStream() {
        this.isStream_ = null;
        this.bitField0_ &= -5;
    }

    private void clearParticipants() {
        this.participants_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearSipCall() {
        this.sipCall_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureParticipantsIsMutable() {
        B.j jVar = this.participants_;
        if (jVar.u()) {
            return;
        }
        this.participants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$ResponseCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCall(MeetStruct$Call meetStruct$Call) {
        meetStruct$Call.getClass();
        MeetStruct$Call meetStruct$Call2 = this.call_;
        if (meetStruct$Call2 == null || meetStruct$Call2 == MeetStruct$Call.getDefaultInstance()) {
            this.call_ = meetStruct$Call;
        } else {
            this.call_ = (MeetStruct$Call) ((MeetStruct$Call.a) MeetStruct$Call.newBuilder(this.call_).v(meetStruct$Call)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeIsStream(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isStream_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isStream_ = collectionsStruct$BooleanValue;
        } else {
            this.isStream_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isStream_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeSipCall(MeetStruct$SipCall meetStruct$SipCall) {
        meetStruct$SipCall.getClass();
        MeetStruct$SipCall meetStruct$SipCall2 = this.sipCall_;
        if (meetStruct$SipCall2 == null || meetStruct$SipCall2 == MeetStruct$SipCall.getDefaultInstance()) {
            this.sipCall_ = meetStruct$SipCall;
        } else {
            this.sipCall_ = (MeetStruct$SipCall) ((MeetStruct$SipCall.a) MeetStruct$SipCall.newBuilder(this.sipCall_).v(meetStruct$SipCall)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$ResponseCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeParticipants(int i) {
        ensureParticipantsIsMutable();
        this.participants_.remove(i);
    }

    private void setCall(MeetStruct$Call meetStruct$Call) {
        meetStruct$Call.getClass();
        this.call_ = meetStruct$Call;
        this.bitField0_ |= 1;
    }

    private void setIsStream(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isStream_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 4;
    }

    private void setParticipants(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.set(i, peersStruct$OutPeer);
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setSipCall(MeetStruct$SipCall meetStruct$SipCall) {
        meetStruct$SipCall.getClass();
        this.sipCall_ = meetStruct$SipCall;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$ResponseCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u0004\u0004ဉ\u0001\u0005ဉ\u0002", new Object[]{"bitField0_", "call_", "participants_", PeersStruct$OutPeer.class, "seq_", "sipCall_", "isStream_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$ResponseCall.class) {
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

    public MeetStruct$Call getCall() {
        MeetStruct$Call meetStruct$Call = this.call_;
        return meetStruct$Call == null ? MeetStruct$Call.getDefaultInstance() : meetStruct$Call;
    }

    public CollectionsStruct$BooleanValue getIsStream() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isStream_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public PeersStruct$OutPeer getParticipants(int i) {
        return (PeersStruct$OutPeer) this.participants_.get(i);
    }

    public int getParticipantsCount() {
        return this.participants_.size();
    }

    public List<PeersStruct$OutPeer> getParticipantsList() {
        return this.participants_;
    }

    public InterfaceC13929h35 getParticipantsOrBuilder(int i) {
        return (InterfaceC13929h35) this.participants_.get(i);
    }

    public List<? extends InterfaceC13929h35> getParticipantsOrBuilderList() {
        return this.participants_;
    }

    public int getSeq() {
        return this.seq_;
    }

    public MeetStruct$SipCall getSipCall() {
        MeetStruct$SipCall meetStruct$SipCall = this.sipCall_;
        return meetStruct$SipCall == null ? MeetStruct$SipCall.getDefaultInstance() : meetStruct$SipCall;
    }

    public boolean hasCall() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIsStream() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSipCall() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$ResponseCall);
    }

    public static MeetOuterClass$ResponseCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$ResponseCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addParticipants(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, peersStruct$OutPeer);
    }

    public static MeetOuterClass$ResponseCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$ResponseCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$ResponseCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$ResponseCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$ResponseCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$ResponseCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$ResponseCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$ResponseCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
