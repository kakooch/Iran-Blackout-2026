package livekit;

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
import livekit.LivekitModels$DataPacket;

/* loaded from: classes8.dex */
public final class LivekitRoom$SendDataRequest extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 2;
    private static final LivekitRoom$SendDataRequest DEFAULT_INSTANCE;
    public static final int DESTINATION_IDENTITIES_FIELD_NUMBER = 6;
    public static final int DESTINATION_SIDS_FIELD_NUMBER = 4;
    public static final int KIND_FIELD_NUMBER = 3;
    public static final int NONCE_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_FIELD_NUMBER = 1;
    public static final int TOPIC_FIELD_NUMBER = 5;
    private int bitField0_;
    private AbstractC2383g data_;
    private B.j destinationIdentities_;
    private B.j destinationSids_;
    private int kind_;
    private AbstractC2383g nonce_;
    private String room_ = "";
    private String topic_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$SendDataRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$SendDataRequest livekitRoom$SendDataRequest = new LivekitRoom$SendDataRequest();
        DEFAULT_INSTANCE = livekitRoom$SendDataRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$SendDataRequest.class, livekitRoom$SendDataRequest);
    }

    private LivekitRoom$SendDataRequest() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.data_ = abstractC2383g;
        this.destinationSids_ = GeneratedMessageLite.emptyProtobufList();
        this.destinationIdentities_ = GeneratedMessageLite.emptyProtobufList();
        this.topic_ = "";
        this.nonce_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinationIdentities(Iterable<String> iterable) {
        ensureDestinationIdentitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.destinationIdentities_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinationSids(Iterable<String> iterable) {
        ensureDestinationSidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.destinationSids_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationIdentities(String str) {
        str.getClass();
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationIdentitiesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationSids(String str) {
        str.getClass();
        ensureDestinationSidsIsMutable();
        this.destinationSids_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationSidsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureDestinationSidsIsMutable();
        this.destinationSids_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationIdentities() {
        this.destinationIdentities_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationSids() {
        this.destinationSids_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNonce() {
        this.nonce_ = getDefaultInstance().getNonce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = getDefaultInstance().getRoom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTopic() {
        this.bitField0_ &= -2;
        this.topic_ = getDefaultInstance().getTopic();
    }

    private void ensureDestinationIdentitiesIsMutable() {
        B.j jVar = this.destinationIdentities_;
        if (jVar.u()) {
            return;
        }
        this.destinationIdentities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureDestinationSidsIsMutable() {
        B.j jVar = this.destinationSids_;
        if (jVar.u()) {
            return;
        }
        this.destinationSids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRoom$SendDataRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$SendDataRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$SendDataRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.data_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationIdentities(int i, String str) {
        str.getClass();
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationSids(int i, String str) {
        str.getClass();
        ensureDestinationSidsIsMutable();
        this.destinationSids_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(LivekitModels$DataPacket.b bVar) {
        this.kind_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNonce(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.nonce_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(String str) {
        str.getClass();
        this.room_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.room_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopic(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.topic_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopicBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.topic_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$SendDataRequest();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001Ȉ\u0002\n\u0003\f\u0004Ț\u0005ለ\u0000\u0006Ț\u0007\n", new Object[]{"bitField0_", "room_", "data_", "kind_", "destinationSids_", "topic_", "destinationIdentities_", "nonce_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$SendDataRequest.class) {
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

    public AbstractC2383g getData() {
        return this.data_;
    }

    public String getDestinationIdentities(int i) {
        return (String) this.destinationIdentities_.get(i);
    }

    public AbstractC2383g getDestinationIdentitiesBytes(int i) {
        return AbstractC2383g.N((String) this.destinationIdentities_.get(i));
    }

    public int getDestinationIdentitiesCount() {
        return this.destinationIdentities_.size();
    }

    public List<String> getDestinationIdentitiesList() {
        return this.destinationIdentities_;
    }

    @Deprecated
    public String getDestinationSids(int i) {
        return (String) this.destinationSids_.get(i);
    }

    @Deprecated
    public AbstractC2383g getDestinationSidsBytes(int i) {
        return AbstractC2383g.N((String) this.destinationSids_.get(i));
    }

    @Deprecated
    public int getDestinationSidsCount() {
        return this.destinationSids_.size();
    }

    @Deprecated
    public List<String> getDestinationSidsList() {
        return this.destinationSids_;
    }

    public LivekitModels$DataPacket.b getKind() {
        LivekitModels$DataPacket.b bVarJ = LivekitModels$DataPacket.b.j(this.kind_);
        return bVarJ == null ? LivekitModels$DataPacket.b.UNRECOGNIZED : bVarJ;
    }

    public int getKindValue() {
        return this.kind_;
    }

    public AbstractC2383g getNonce() {
        return this.nonce_;
    }

    public String getRoom() {
        return this.room_;
    }

    public AbstractC2383g getRoomBytes() {
        return AbstractC2383g.N(this.room_);
    }

    public String getTopic() {
        return this.topic_;
    }

    public AbstractC2383g getTopicBytes() {
        return AbstractC2383g.N(this.topic_);
    }

    public boolean hasTopic() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitRoom$SendDataRequest livekitRoom$SendDataRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$SendDataRequest);
    }

    public static LivekitRoom$SendDataRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$SendDataRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$SendDataRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRoom$SendDataRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$SendDataRequest parseFrom(byte[] bArr) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$SendDataRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$SendDataRequest parseFrom(InputStream inputStream) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$SendDataRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$SendDataRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$SendDataRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$SendDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
