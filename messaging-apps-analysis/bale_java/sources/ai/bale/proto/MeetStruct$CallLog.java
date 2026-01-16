package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MeetStruct$GroupCallLog;
import ai.bale.proto.MeetStruct$MultiPeerCallLog;
import ai.bale.proto.MeetStruct$PrivateCallLog;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MeetStruct$CallLog extends GeneratedMessageLite implements H0 {
    public static final int CALL_ID_FIELD_NUMBER = 10;
    public static final int CREATION_DATE_FIELD_NUMBER = 16;
    private static final MeetStruct$CallLog DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 4;
    public static final int END_DATE_FIELD_NUMBER = 15;
    public static final int EXTRA_FIELD_NUMBER = 6;
    public static final int EXT_FIELD_NUMBER = 9;
    public static final int FINISHER_FIELD_NUMBER = 3;
    public static final int GROUP_CALL_LOG_FIELD_NUMBER = 8;
    public static final int INITIATOR_FIELD_NUMBER = 1;
    public static final int IS_PUBLIC_FIELD_NUMBER = 14;
    public static final int LINK_FIELD_NUMBER = 13;
    public static final int MULTI_PEER_CALL_LOG_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int PRIVATE_CALL_LOG_FIELD_NUMBER = 7;
    public static final int START_DATE_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 12;
    private int bitField0_;
    private CollectionsStruct$Int64Value callId_;
    private long creationDate_;
    private long duration_;
    private long endDate_;
    private PeersStruct$OutExPeer finisher_;
    private PeersStruct$OutExPeer initiator_;
    private boolean isPublic_;
    private PeersStruct$OutExPeer peer_;
    private long startDate_;
    private Object trait_;
    private int traitCase_ = 0;
    private com.google.protobuf.J extra_ = com.google.protobuf.J.e();
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private String title_ = "";
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements H0 {
        private a() {
            super(MeetStruct$CallLog.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    private static final class c {
        static final com.google.protobuf.I a;

        static {
            r0.b bVar = r0.b.k;
            a = com.google.protobuf.I.d(bVar, "", bVar, "");
        }
    }

    public enum d {
        PRIVATE_CALL_LOG(7),
        GROUP_CALL_LOG(8),
        MULTI_PEER_CALL_LOG(11),
        TRAIT_NOT_SET(0);

        private final int a;

        d(int i) {
            this.a = i;
        }

        public static d j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 11) {
                return MULTI_PEER_CALL_LOG;
            }
            if (i == 7) {
                return PRIVATE_CALL_LOG;
            }
            if (i != 8) {
                return null;
            }
            return GROUP_CALL_LOG;
        }
    }

    static {
        MeetStruct$CallLog meetStruct$CallLog = new MeetStruct$CallLog();
        DEFAULT_INSTANCE = meetStruct$CallLog;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$CallLog.class, meetStruct$CallLog);
    }

    private MeetStruct$CallLog() {
    }

    private void clearCallId() {
        this.callId_ = null;
        this.bitField0_ &= -9;
    }

    private void clearCreationDate() {
        this.creationDate_ = 0L;
    }

    private void clearDuration() {
        this.duration_ = 0L;
    }

    private void clearEndDate() {
        this.endDate_ = 0L;
    }

    private void clearFinisher() {
        this.finisher_ = null;
        this.bitField0_ &= -5;
    }

    private void clearGroupCallLog() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInitiator() {
        this.initiator_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsPublic() {
        this.isPublic_ = false;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearMultiPeerCallLog() {
        if (this.traitCase_ == 11) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPrivateCallLog() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStartDate() {
        this.startDate_ = 0L;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MeetStruct$CallLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private Map<String, String> getMutableExtraMap() {
        return internalGetMutableExtra();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetExtra() {
        return this.extra_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExtra() {
        if (!this.extra_.n()) {
            this.extra_ = this.extra_.s();
        }
        return this.extra_;
    }

    private void mergeCallId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.callId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.callId_ = collectionsStruct$Int64Value;
        } else {
            this.callId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.callId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeFinisher(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.finisher_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.finisher_ = peersStruct$OutExPeer;
        } else {
            this.finisher_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.finisher_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeGroupCallLog(MeetStruct$GroupCallLog meetStruct$GroupCallLog) {
        meetStruct$GroupCallLog.getClass();
        if (this.traitCase_ != 8 || this.trait_ == MeetStruct$GroupCallLog.getDefaultInstance()) {
            this.trait_ = meetStruct$GroupCallLog;
        } else {
            this.trait_ = ((MeetStruct$GroupCallLog.a) MeetStruct$GroupCallLog.newBuilder((MeetStruct$GroupCallLog) this.trait_).v(meetStruct$GroupCallLog)).j();
        }
        this.traitCase_ = 8;
    }

    private void mergeInitiator(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.initiator_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.initiator_ = peersStruct$OutExPeer;
        } else {
            this.initiator_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.initiator_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMultiPeerCallLog(MeetStruct$MultiPeerCallLog meetStruct$MultiPeerCallLog) {
        meetStruct$MultiPeerCallLog.getClass();
        if (this.traitCase_ != 11 || this.trait_ == MeetStruct$MultiPeerCallLog.getDefaultInstance()) {
            this.trait_ = meetStruct$MultiPeerCallLog;
        } else {
            this.trait_ = ((MeetStruct$MultiPeerCallLog.a) MeetStruct$MultiPeerCallLog.newBuilder((MeetStruct$MultiPeerCallLog) this.trait_).v(meetStruct$MultiPeerCallLog)).j();
        }
        this.traitCase_ = 11;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePrivateCallLog(MeetStruct$PrivateCallLog meetStruct$PrivateCallLog) {
        meetStruct$PrivateCallLog.getClass();
        if (this.traitCase_ != 7 || this.trait_ == MeetStruct$PrivateCallLog.getDefaultInstance()) {
            this.trait_ = meetStruct$PrivateCallLog;
        } else {
            this.trait_ = ((MeetStruct$PrivateCallLog.a) MeetStruct$PrivateCallLog.newBuilder((MeetStruct$PrivateCallLog) this.trait_).v(meetStruct$PrivateCallLog)).j();
        }
        this.traitCase_ = 7;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$CallLog parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$CallLog parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCallId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.callId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 8;
    }

    private void setCreationDate(long j) {
        this.creationDate_ = j;
    }

    private void setDuration(long j) {
        this.duration_ = j;
    }

    private void setEndDate(long j) {
        this.endDate_ = j;
    }

    private void setFinisher(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.finisher_ = peersStruct$OutExPeer;
        this.bitField0_ |= 4;
    }

    private void setGroupCallLog(MeetStruct$GroupCallLog meetStruct$GroupCallLog) {
        meetStruct$GroupCallLog.getClass();
        this.trait_ = meetStruct$GroupCallLog;
        this.traitCase_ = 8;
    }

    private void setInitiator(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.initiator_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    private void setIsPublic(boolean z) {
        this.isPublic_ = z;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setMultiPeerCallLog(MeetStruct$MultiPeerCallLog meetStruct$MultiPeerCallLog) {
        meetStruct$MultiPeerCallLog.getClass();
        this.trait_ = meetStruct$MultiPeerCallLog;
        this.traitCase_ = 11;
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 2;
    }

    private void setPrivateCallLog(MeetStruct$PrivateCallLog meetStruct$PrivateCallLog) {
        meetStruct$PrivateCallLog.getClass();
        this.trait_ = meetStruct$PrivateCallLog;
        this.traitCase_ = 7;
    }

    private void setStartDate(long j) {
        this.startDate_ = j;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Deprecated
    public boolean containsExtra(String str) {
        str.getClass();
        return internalGetExtra().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$CallLog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0001\u0001\u0001\u0010\u0010\u0002\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u0002\u0005\u0002\u00062\u0007<\u0000\b<\u0000\t2\nဉ\u0003\u000b<\u0000\fȈ\rȈ\u000e\u0007\u000f\u0002\u0010\u0002", new Object[]{"trait_", "traitCase_", "bitField0_", "initiator_", "peer_", "finisher_", "duration_", "startDate_", "extra_", c.a, MeetStruct$PrivateCallLog.class, MeetStruct$GroupCallLog.class, "ext_", b.a, "callId_", MeetStruct$MultiPeerCallLog.class, "title_", "link_", "isPublic_", "endDate_", "creationDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$CallLog.class) {
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

    public CollectionsStruct$Int64Value getCallId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.callId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public long getCreationDate() {
        return this.creationDate_;
    }

    public long getDuration() {
        return this.duration_;
    }

    public long getEndDate() {
        return this.endDate_;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExt() {
        return getExtMap();
    }

    public int getExtCount() {
        return internalGetExt().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtMap() {
        return Collections.unmodifiableMap(internalGetExt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        return jInternalGetExt.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExt.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        if (jInternalGetExt.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExt.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public Map<String, String> getExtra() {
        return getExtraMap();
    }

    @Deprecated
    public int getExtraCount() {
        return internalGetExtra().size();
    }

    @Deprecated
    public Map<String, String> getExtraMap() {
        return Collections.unmodifiableMap(internalGetExtra());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getExtraOrDefault(String str, String str2) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        return jInternalGetExtra.containsKey(str) ? (String) jInternalGetExtra.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String getExtraOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExtra = internalGetExtra();
        if (jInternalGetExtra.containsKey(str)) {
            return (String) jInternalGetExtra.get(str);
        }
        throw new IllegalArgumentException();
    }

    public PeersStruct$OutExPeer getFinisher() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.finisher_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public MeetStruct$GroupCallLog getGroupCallLog() {
        return this.traitCase_ == 8 ? (MeetStruct$GroupCallLog) this.trait_ : MeetStruct$GroupCallLog.getDefaultInstance();
    }

    public PeersStruct$OutExPeer getInitiator() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.initiator_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public boolean getIsPublic() {
        return this.isPublic_;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public MeetStruct$MultiPeerCallLog getMultiPeerCallLog() {
        return this.traitCase_ == 11 ? (MeetStruct$MultiPeerCallLog) this.trait_ : MeetStruct$MultiPeerCallLog.getDefaultInstance();
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public MeetStruct$PrivateCallLog getPrivateCallLog() {
        return this.traitCase_ == 7 ? (MeetStruct$PrivateCallLog) this.trait_ : MeetStruct$PrivateCallLog.getDefaultInstance();
    }

    public long getStartDate() {
        return this.startDate_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public d getTraitCase() {
        return d.j(this.traitCase_);
    }

    public boolean hasCallId() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasFinisher() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasGroupCallLog() {
        return this.traitCase_ == 8;
    }

    public boolean hasInitiator() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMultiPeerCallLog() {
        return this.traitCase_ == 11;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPrivateCallLog() {
        return this.traitCase_ == 7;
    }

    public static a newBuilder(MeetStruct$CallLog meetStruct$CallLog) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$CallLog);
    }

    public static MeetStruct$CallLog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$CallLog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$CallLog parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$CallLog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$CallLog parseFrom(byte[] bArr) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$CallLog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$CallLog parseFrom(InputStream inputStream) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$CallLog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$CallLog parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$CallLog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$CallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
