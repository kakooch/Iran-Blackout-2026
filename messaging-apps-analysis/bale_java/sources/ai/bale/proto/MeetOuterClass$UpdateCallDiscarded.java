package ai.bale.proto;

import ai.bale.proto.MeetStruct$Call;
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
public final class MeetOuterClass$UpdateCallDiscarded extends GeneratedMessageLite implements U64 {
    public static final int CALL_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdateCallDiscarded DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 2;
    private int bitField0_;
    private MeetStruct$Call call_;
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdateCallDiscarded.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdateCallDiscarded meetOuterClass$UpdateCallDiscarded = new MeetOuterClass$UpdateCallDiscarded();
        DEFAULT_INSTANCE = meetOuterClass$UpdateCallDiscarded;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdateCallDiscarded.class, meetOuterClass$UpdateCallDiscarded);
    }

    private MeetOuterClass$UpdateCallDiscarded() {
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

    private void clearParticipants() {
        this.participants_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureParticipantsIsMutable() {
        B.j jVar = this.participants_;
        if (jVar.u()) {
            return;
        }
        this.participants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$UpdateCallDiscarded getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdateCallDiscarded parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setParticipants(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.set(i, peersStruct$OutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdateCallDiscarded();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "call_", "participants_", PeersStruct$OutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdateCallDiscarded.class) {
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

    public boolean hasCall() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$UpdateCallDiscarded meetOuterClass$UpdateCallDiscarded) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdateCallDiscarded);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addParticipants(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, peersStruct$OutPeer);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdateCallDiscarded parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdateCallDiscarded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
