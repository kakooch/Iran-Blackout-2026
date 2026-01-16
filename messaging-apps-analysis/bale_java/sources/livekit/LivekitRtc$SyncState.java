package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15242jF3;
import ir.nasim.InterfaceC15833kF3;
import ir.nasim.InterfaceC21856uF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitRtc$SessionDescription;
import livekit.LivekitRtc$UpdateSubscription;

/* loaded from: classes8.dex */
public final class LivekitRtc$SyncState extends GeneratedMessageLite implements U64 {
    public static final int ANSWER_FIELD_NUMBER = 1;
    public static final int DATACHANNEL_RECEIVE_STATES_FIELD_NUMBER = 7;
    public static final int DATA_CHANNELS_FIELD_NUMBER = 4;
    private static final LivekitRtc$SyncState DEFAULT_INSTANCE;
    public static final int OFFER_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PUBLISH_TRACKS_FIELD_NUMBER = 3;
    public static final int SUBSCRIPTION_FIELD_NUMBER = 2;
    public static final int TRACK_SIDS_DISABLED_FIELD_NUMBER = 6;
    private LivekitRtc$SessionDescription answer_;
    private LivekitRtc$SessionDescription offer_;
    private LivekitRtc$UpdateSubscription subscription_;
    private B.j publishTracks_ = GeneratedMessageLite.emptyProtobufList();
    private B.j dataChannels_ = GeneratedMessageLite.emptyProtobufList();
    private B.j trackSidsDisabled_ = GeneratedMessageLite.emptyProtobufList();
    private B.j datachannelReceiveStates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(Iterable iterable) {
            q();
            ((LivekitRtc$SyncState) this.b).addAllDataChannels(iterable);
            return this;
        }

        public a B(Iterable iterable) {
            q();
            ((LivekitRtc$SyncState) this.b).addAllDatachannelReceiveStates(iterable);
            return this;
        }

        public a C(Iterable iterable) {
            q();
            ((LivekitRtc$SyncState) this.b).addAllPublishTracks(iterable);
            return this;
        }

        public a D(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
            q();
            ((LivekitRtc$SyncState) this.b).setAnswer(livekitRtc$SessionDescription);
            return this;
        }

        public a E(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
            q();
            ((LivekitRtc$SyncState) this.b).setOffer(livekitRtc$SessionDescription);
            return this;
        }

        public a F(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription) {
            q();
            ((LivekitRtc$SyncState) this.b).setSubscription(livekitRtc$UpdateSubscription);
            return this;
        }

        private a() {
            super(LivekitRtc$SyncState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SyncState livekitRtc$SyncState = new LivekitRtc$SyncState();
        DEFAULT_INSTANCE = livekitRtc$SyncState;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SyncState.class, livekitRtc$SyncState);
    }

    private LivekitRtc$SyncState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDataChannels(Iterable<? extends LivekitRtc$DataChannelInfo> iterable) {
        ensureDataChannelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dataChannels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDatachannelReceiveStates(Iterable<? extends LivekitRtc$DataChannelReceiveState> iterable) {
        ensureDatachannelReceiveStatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.datachannelReceiveStates_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPublishTracks(Iterable<? extends LivekitRtc$TrackPublishedResponse> iterable) {
        ensurePublishTracksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.publishTracks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrackSidsDisabled(Iterable<String> iterable) {
        ensureTrackSidsDisabledIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trackSidsDisabled_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDataChannels(LivekitRtc$DataChannelInfo livekitRtc$DataChannelInfo) {
        livekitRtc$DataChannelInfo.getClass();
        ensureDataChannelsIsMutable();
        this.dataChannels_.add(livekitRtc$DataChannelInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDatachannelReceiveStates(LivekitRtc$DataChannelReceiveState livekitRtc$DataChannelReceiveState) {
        livekitRtc$DataChannelReceiveState.getClass();
        ensureDatachannelReceiveStatesIsMutable();
        this.datachannelReceiveStates_.add(livekitRtc$DataChannelReceiveState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPublishTracks(LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        livekitRtc$TrackPublishedResponse.getClass();
        ensurePublishTracksIsMutable();
        this.publishTracks_.add(livekitRtc$TrackPublishedResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackSidsDisabled(String str) {
        str.getClass();
        ensureTrackSidsDisabledIsMutable();
        this.trackSidsDisabled_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackSidsDisabledBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureTrackSidsDisabledIsMutable();
        this.trackSidsDisabled_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnswer() {
        this.answer_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDataChannels() {
        this.dataChannels_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDatachannelReceiveStates() {
        this.datachannelReceiveStates_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOffer() {
        this.offer_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublishTracks() {
        this.publishTracks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscription() {
        this.subscription_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSidsDisabled() {
        this.trackSidsDisabled_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataChannelsIsMutable() {
        B.j jVar = this.dataChannels_;
        if (jVar.u()) {
            return;
        }
        this.dataChannels_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureDatachannelReceiveStatesIsMutable() {
        B.j jVar = this.datachannelReceiveStates_;
        if (jVar.u()) {
            return;
        }
        this.datachannelReceiveStates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePublishTracksIsMutable() {
        B.j jVar = this.publishTracks_;
        if (jVar.u()) {
            return;
        }
        this.publishTracks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTrackSidsDisabledIsMutable() {
        B.j jVar = this.trackSidsDisabled_;
        if (jVar.u()) {
            return;
        }
        this.trackSidsDisabled_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$SyncState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAnswer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        LivekitRtc$SessionDescription livekitRtc$SessionDescription2 = this.answer_;
        if (livekitRtc$SessionDescription2 == null || livekitRtc$SessionDescription2 == LivekitRtc$SessionDescription.getDefaultInstance()) {
            this.answer_ = livekitRtc$SessionDescription;
        } else {
            this.answer_ = (LivekitRtc$SessionDescription) ((LivekitRtc$SessionDescription.a) LivekitRtc$SessionDescription.newBuilder(this.answer_).v(livekitRtc$SessionDescription)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOffer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        LivekitRtc$SessionDescription livekitRtc$SessionDescription2 = this.offer_;
        if (livekitRtc$SessionDescription2 == null || livekitRtc$SessionDescription2 == LivekitRtc$SessionDescription.getDefaultInstance()) {
            this.offer_ = livekitRtc$SessionDescription;
        } else {
            this.offer_ = (LivekitRtc$SessionDescription) ((LivekitRtc$SessionDescription.a) LivekitRtc$SessionDescription.newBuilder(this.offer_).v(livekitRtc$SessionDescription)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubscription(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription) {
        livekitRtc$UpdateSubscription.getClass();
        LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription2 = this.subscription_;
        if (livekitRtc$UpdateSubscription2 == null || livekitRtc$UpdateSubscription2 == LivekitRtc$UpdateSubscription.getDefaultInstance()) {
            this.subscription_ = livekitRtc$UpdateSubscription;
        } else {
            this.subscription_ = (LivekitRtc$UpdateSubscription) ((LivekitRtc$UpdateSubscription.a) LivekitRtc$UpdateSubscription.newBuilder(this.subscription_).v(livekitRtc$UpdateSubscription)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SyncState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SyncState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDataChannels(int i) {
        ensureDataChannelsIsMutable();
        this.dataChannels_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDatachannelReceiveStates(int i) {
        ensureDatachannelReceiveStatesIsMutable();
        this.datachannelReceiveStates_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePublishTracks(int i) {
        ensurePublishTracksIsMutable();
        this.publishTracks_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnswer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        this.answer_ = livekitRtc$SessionDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataChannels(int i, LivekitRtc$DataChannelInfo livekitRtc$DataChannelInfo) {
        livekitRtc$DataChannelInfo.getClass();
        ensureDataChannelsIsMutable();
        this.dataChannels_.set(i, livekitRtc$DataChannelInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatachannelReceiveStates(int i, LivekitRtc$DataChannelReceiveState livekitRtc$DataChannelReceiveState) {
        livekitRtc$DataChannelReceiveState.getClass();
        ensureDatachannelReceiveStatesIsMutable();
        this.datachannelReceiveStates_.set(i, livekitRtc$DataChannelReceiveState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        this.offer_ = livekitRtc$SessionDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublishTracks(int i, LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        livekitRtc$TrackPublishedResponse.getClass();
        ensurePublishTracksIsMutable();
        this.publishTracks_.set(i, livekitRtc$TrackPublishedResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscription(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription) {
        livekitRtc$UpdateSubscription.getClass();
        this.subscription_ = livekitRtc$UpdateSubscription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSidsDisabled(int i, String str) {
        str.getClass();
        ensureTrackSidsDisabledIsMutable();
        this.trackSidsDisabled_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SyncState();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0004\u0000\u0001\t\u0002\t\u0003\u001b\u0004\u001b\u0005\t\u0006Ț\u0007\u001b", new Object[]{"answer_", "subscription_", "publishTracks_", LivekitRtc$TrackPublishedResponse.class, "dataChannels_", LivekitRtc$DataChannelInfo.class, "offer_", "trackSidsDisabled_", "datachannelReceiveStates_", LivekitRtc$DataChannelReceiveState.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SyncState.class) {
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

    public LivekitRtc$SessionDescription getAnswer() {
        LivekitRtc$SessionDescription livekitRtc$SessionDescription = this.answer_;
        return livekitRtc$SessionDescription == null ? LivekitRtc$SessionDescription.getDefaultInstance() : livekitRtc$SessionDescription;
    }

    public LivekitRtc$DataChannelInfo getDataChannels(int i) {
        return (LivekitRtc$DataChannelInfo) this.dataChannels_.get(i);
    }

    public int getDataChannelsCount() {
        return this.dataChannels_.size();
    }

    public List<LivekitRtc$DataChannelInfo> getDataChannelsList() {
        return this.dataChannels_;
    }

    public InterfaceC15242jF3 getDataChannelsOrBuilder(int i) {
        return (InterfaceC15242jF3) this.dataChannels_.get(i);
    }

    public List<? extends InterfaceC15242jF3> getDataChannelsOrBuilderList() {
        return this.dataChannels_;
    }

    public LivekitRtc$DataChannelReceiveState getDatachannelReceiveStates(int i) {
        return (LivekitRtc$DataChannelReceiveState) this.datachannelReceiveStates_.get(i);
    }

    public int getDatachannelReceiveStatesCount() {
        return this.datachannelReceiveStates_.size();
    }

    public List<LivekitRtc$DataChannelReceiveState> getDatachannelReceiveStatesList() {
        return this.datachannelReceiveStates_;
    }

    public InterfaceC15833kF3 getDatachannelReceiveStatesOrBuilder(int i) {
        return (InterfaceC15833kF3) this.datachannelReceiveStates_.get(i);
    }

    public List<? extends InterfaceC15833kF3> getDatachannelReceiveStatesOrBuilderList() {
        return this.datachannelReceiveStates_;
    }

    public LivekitRtc$SessionDescription getOffer() {
        LivekitRtc$SessionDescription livekitRtc$SessionDescription = this.offer_;
        return livekitRtc$SessionDescription == null ? LivekitRtc$SessionDescription.getDefaultInstance() : livekitRtc$SessionDescription;
    }

    public LivekitRtc$TrackPublishedResponse getPublishTracks(int i) {
        return (LivekitRtc$TrackPublishedResponse) this.publishTracks_.get(i);
    }

    public int getPublishTracksCount() {
        return this.publishTracks_.size();
    }

    public List<LivekitRtc$TrackPublishedResponse> getPublishTracksList() {
        return this.publishTracks_;
    }

    public InterfaceC21856uF3 getPublishTracksOrBuilder(int i) {
        return (InterfaceC21856uF3) this.publishTracks_.get(i);
    }

    public List<? extends InterfaceC21856uF3> getPublishTracksOrBuilderList() {
        return this.publishTracks_;
    }

    public LivekitRtc$UpdateSubscription getSubscription() {
        LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription = this.subscription_;
        return livekitRtc$UpdateSubscription == null ? LivekitRtc$UpdateSubscription.getDefaultInstance() : livekitRtc$UpdateSubscription;
    }

    public String getTrackSidsDisabled(int i) {
        return (String) this.trackSidsDisabled_.get(i);
    }

    public AbstractC2383g getTrackSidsDisabledBytes(int i) {
        return AbstractC2383g.N((String) this.trackSidsDisabled_.get(i));
    }

    public int getTrackSidsDisabledCount() {
        return this.trackSidsDisabled_.size();
    }

    public List<String> getTrackSidsDisabledList() {
        return this.trackSidsDisabled_;
    }

    public boolean hasAnswer() {
        return this.answer_ != null;
    }

    public boolean hasOffer() {
        return this.offer_ != null;
    }

    public boolean hasSubscription() {
        return this.subscription_ != null;
    }

    public static a newBuilder(LivekitRtc$SyncState livekitRtc$SyncState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SyncState);
    }

    public static LivekitRtc$SyncState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SyncState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SyncState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDataChannels(int i, LivekitRtc$DataChannelInfo livekitRtc$DataChannelInfo) {
        livekitRtc$DataChannelInfo.getClass();
        ensureDataChannelsIsMutable();
        this.dataChannels_.add(i, livekitRtc$DataChannelInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDatachannelReceiveStates(int i, LivekitRtc$DataChannelReceiveState livekitRtc$DataChannelReceiveState) {
        livekitRtc$DataChannelReceiveState.getClass();
        ensureDatachannelReceiveStatesIsMutable();
        this.datachannelReceiveStates_.add(i, livekitRtc$DataChannelReceiveState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPublishTracks(int i, LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        livekitRtc$TrackPublishedResponse.getClass();
        ensurePublishTracksIsMutable();
        this.publishTracks_.add(i, livekitRtc$TrackPublishedResponse);
    }

    public static LivekitRtc$SyncState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SyncState parseFrom(byte[] bArr) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SyncState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SyncState parseFrom(InputStream inputStream) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SyncState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SyncState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SyncState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SyncState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
