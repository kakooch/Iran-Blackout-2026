package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12702f35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetOuterClass$UpdatePeersInvited extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final MeetOuterClass$UpdatePeersInvited DEFAULT_INSTANCE;
    public static final int INVITEES_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int UPDATE_CREATE_DATE_FIELD_NUMBER = 9;
    private long callId_;
    private B.j invitees_ = GeneratedMessageLite.emptyProtobufList();
    private long updateCreateDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$UpdatePeersInvited.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$UpdatePeersInvited meetOuterClass$UpdatePeersInvited = new MeetOuterClass$UpdatePeersInvited();
        DEFAULT_INSTANCE = meetOuterClass$UpdatePeersInvited;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$UpdatePeersInvited.class, meetOuterClass$UpdatePeersInvited);
    }

    private MeetOuterClass$UpdatePeersInvited() {
    }

    private void addAllInvitees(Iterable<? extends PeersStruct$OutExPeer> iterable) {
        ensureInviteesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.invitees_);
    }

    private void addInvitees(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInviteesIsMutable();
        this.invitees_.add(peersStruct$OutExPeer);
    }

    private void clearCallId() {
        this.callId_ = 0L;
    }

    private void clearInvitees() {
        this.invitees_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUpdateCreateDate() {
        this.updateCreateDate_ = 0L;
    }

    private void ensureInviteesIsMutable() {
        B.j jVar = this.invitees_;
        if (jVar.u()) {
            return;
        }
        this.invitees_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$UpdatePeersInvited getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$UpdatePeersInvited parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInvitees(int i) {
        ensureInviteesIsMutable();
        this.invitees_.remove(i);
    }

    private void setCallId(long j) {
        this.callId_ = j;
    }

    private void setInvitees(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInviteesIsMutable();
        this.invitees_.set(i, peersStruct$OutExPeer);
    }

    private void setUpdateCreateDate(long j) {
        this.updateCreateDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$UpdatePeersInvited();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\t\u0003\u0000\u0001\u0000\u0001\u0002\u0002\u001b\t\u0002", new Object[]{"callId_", "invitees_", PeersStruct$OutExPeer.class, "updateCreateDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$UpdatePeersInvited.class) {
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

    public long getCallId() {
        return this.callId_;
    }

    public PeersStruct$OutExPeer getInvitees(int i) {
        return (PeersStruct$OutExPeer) this.invitees_.get(i);
    }

    public int getInviteesCount() {
        return this.invitees_.size();
    }

    public List<PeersStruct$OutExPeer> getInviteesList() {
        return this.invitees_;
    }

    public InterfaceC12702f35 getInviteesOrBuilder(int i) {
        return (InterfaceC12702f35) this.invitees_.get(i);
    }

    public List<? extends InterfaceC12702f35> getInviteesOrBuilderList() {
        return this.invitees_;
    }

    public long getUpdateCreateDate() {
        return this.updateCreateDate_;
    }

    public static a newBuilder(MeetOuterClass$UpdatePeersInvited meetOuterClass$UpdatePeersInvited) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$UpdatePeersInvited);
    }

    public static MeetOuterClass$UpdatePeersInvited parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addInvitees(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensureInviteesIsMutable();
        this.invitees_.add(i, peersStruct$OutExPeer);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(byte[] bArr) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(InputStream inputStream) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$UpdatePeersInvited parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$UpdatePeersInvited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
