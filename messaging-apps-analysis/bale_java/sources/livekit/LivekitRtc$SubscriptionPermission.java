package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21182tF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$SubscriptionPermission extends GeneratedMessageLite implements U64 {
    public static final int ALL_PARTICIPANTS_FIELD_NUMBER = 1;
    private static final LivekitRtc$SubscriptionPermission DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_PERMISSIONS_FIELD_NUMBER = 2;
    private boolean allParticipants_;
    private B.j trackPermissions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SubscriptionPermission.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SubscriptionPermission livekitRtc$SubscriptionPermission = new LivekitRtc$SubscriptionPermission();
        DEFAULT_INSTANCE = livekitRtc$SubscriptionPermission;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SubscriptionPermission.class, livekitRtc$SubscriptionPermission);
    }

    private LivekitRtc$SubscriptionPermission() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrackPermissions(Iterable<? extends LivekitRtc$TrackPermission> iterable) {
        ensureTrackPermissionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trackPermissions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackPermissions(LivekitRtc$TrackPermission livekitRtc$TrackPermission) {
        livekitRtc$TrackPermission.getClass();
        ensureTrackPermissionsIsMutable();
        this.trackPermissions_.add(livekitRtc$TrackPermission);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllParticipants() {
        this.allParticipants_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackPermissions() {
        this.trackPermissions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTrackPermissionsIsMutable() {
        B.j jVar = this.trackPermissions_;
        if (jVar.u()) {
            return;
        }
        this.trackPermissions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$SubscriptionPermission getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SubscriptionPermission parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTrackPermissions(int i) {
        ensureTrackPermissionsIsMutable();
        this.trackPermissions_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllParticipants(boolean z) {
        this.allParticipants_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackPermissions(int i, LivekitRtc$TrackPermission livekitRtc$TrackPermission) {
        livekitRtc$TrackPermission.getClass();
        ensureTrackPermissionsIsMutable();
        this.trackPermissions_.set(i, livekitRtc$TrackPermission);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SubscriptionPermission();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0007\u0002\u001b", new Object[]{"allParticipants_", "trackPermissions_", LivekitRtc$TrackPermission.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SubscriptionPermission.class) {
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

    public boolean getAllParticipants() {
        return this.allParticipants_;
    }

    public LivekitRtc$TrackPermission getTrackPermissions(int i) {
        return (LivekitRtc$TrackPermission) this.trackPermissions_.get(i);
    }

    public int getTrackPermissionsCount() {
        return this.trackPermissions_.size();
    }

    public List<LivekitRtc$TrackPermission> getTrackPermissionsList() {
        return this.trackPermissions_;
    }

    public InterfaceC21182tF3 getTrackPermissionsOrBuilder(int i) {
        return (InterfaceC21182tF3) this.trackPermissions_.get(i);
    }

    public List<? extends InterfaceC21182tF3> getTrackPermissionsOrBuilderList() {
        return this.trackPermissions_;
    }

    public static a newBuilder(LivekitRtc$SubscriptionPermission livekitRtc$SubscriptionPermission) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SubscriptionPermission);
    }

    public static LivekitRtc$SubscriptionPermission parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackPermissions(int i, LivekitRtc$TrackPermission livekitRtc$TrackPermission) {
        livekitRtc$TrackPermission.getClass();
        ensureTrackPermissionsIsMutable();
        this.trackPermissions_.add(i, livekitRtc$TrackPermission);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(byte[] bArr) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(InputStream inputStream) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SubscriptionPermission parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
