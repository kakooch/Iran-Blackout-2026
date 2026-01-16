package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17597nE3;
import ir.nasim.EnumC18188oE3;
import ir.nasim.InterfaceC19961rE3;
import ir.nasim.InterfaceC21173tE3;
import ir.nasim.InterfaceC23033wE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitEgress$FileInfo;
import livekit.LivekitEgress$ParticipantEgressRequest;
import livekit.LivekitEgress$RoomCompositeEgressRequest;
import livekit.LivekitEgress$SegmentsInfo;
import livekit.LivekitEgress$StreamInfoList;
import livekit.LivekitEgress$TrackCompositeEgressRequest;
import livekit.LivekitEgress$TrackEgressRequest;
import livekit.LivekitEgress$WebEgressRequest;

/* loaded from: classes8.dex */
public final class LivekitEgress$EgressInfo extends GeneratedMessageLite implements g {
    public static final int BACKUP_STORAGE_USED_FIELD_NUMBER = 25;
    private static final LivekitEgress$EgressInfo DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 21;
    public static final int EGRESS_ID_FIELD_NUMBER = 1;
    public static final int ENDED_AT_FIELD_NUMBER = 11;
    public static final int ERROR_CODE_FIELD_NUMBER = 22;
    public static final int ERROR_FIELD_NUMBER = 9;
    public static final int FILE_FIELD_NUMBER = 8;
    public static final int FILE_RESULTS_FIELD_NUMBER = 16;
    public static final int IMAGE_RESULTS_FIELD_NUMBER = 20;
    public static final int MANIFEST_LOCATION_FIELD_NUMBER = 23;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 19;
    public static final int ROOM_COMPOSITE_FIELD_NUMBER = 4;
    public static final int ROOM_ID_FIELD_NUMBER = 2;
    public static final int ROOM_NAME_FIELD_NUMBER = 13;
    public static final int SEGMENTS_FIELD_NUMBER = 12;
    public static final int SEGMENT_RESULTS_FIELD_NUMBER = 17;
    public static final int SOURCE_TYPE_FIELD_NUMBER = 26;
    public static final int STARTED_AT_FIELD_NUMBER = 10;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int STREAM_FIELD_NUMBER = 7;
    public static final int STREAM_RESULTS_FIELD_NUMBER = 15;
    public static final int TRACK_COMPOSITE_FIELD_NUMBER = 5;
    public static final int TRACK_FIELD_NUMBER = 6;
    public static final int UPDATED_AT_FIELD_NUMBER = 18;
    public static final int WEB_FIELD_NUMBER = 14;
    private boolean backupStorageUsed_;
    private long endedAt_;
    private int errorCode_;
    private Object request_;
    private Object result_;
    private int sourceType_;
    private long startedAt_;
    private int status_;
    private long updatedAt_;
    private int requestCase_ = 0;
    private int resultCase_ = 0;
    private String egressId_ = "";
    private String roomId_ = "";
    private String roomName_ = "";
    private String details_ = "";
    private String error_ = "";
    private B.j streamResults_ = GeneratedMessageLite.emptyProtobufList();
    private B.j fileResults_ = GeneratedMessageLite.emptyProtobufList();
    private B.j segmentResults_ = GeneratedMessageLite.emptyProtobufList();
    private B.j imageResults_ = GeneratedMessageLite.emptyProtobufList();
    private String manifestLocation_ = "";

    public static final class a extends GeneratedMessageLite.b implements g {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$EgressInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        ROOM_COMPOSITE(4),
        WEB(14),
        PARTICIPANT(19),
        TRACK_COMPOSITE(5),
        TRACK(6),
        REQUEST_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return REQUEST_NOT_SET;
            }
            if (i == 14) {
                return WEB;
            }
            if (i == 19) {
                return PARTICIPANT;
            }
            if (i == 4) {
                return ROOM_COMPOSITE;
            }
            if (i == 5) {
                return TRACK_COMPOSITE;
            }
            if (i != 6) {
                return null;
            }
            return TRACK;
        }
    }

    public enum c {
        STREAM(7),
        FILE(8),
        SEGMENTS(12),
        RESULT_NOT_SET(0);

        private final int a;

        c(int i) {
            this.a = i;
        }

        public static c j(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 12) {
                return SEGMENTS;
            }
            if (i == 7) {
                return STREAM;
            }
            if (i != 8) {
                return null;
            }
            return FILE;
        }
    }

    static {
        LivekitEgress$EgressInfo livekitEgress$EgressInfo = new LivekitEgress$EgressInfo();
        DEFAULT_INSTANCE = livekitEgress$EgressInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$EgressInfo.class, livekitEgress$EgressInfo);
    }

    private LivekitEgress$EgressInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFileResults(Iterable<? extends LivekitEgress$FileInfo> iterable) {
        ensureFileResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fileResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllImageResults(Iterable<? extends LivekitEgress$ImagesInfo> iterable) {
        ensureImageResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.imageResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSegmentResults(Iterable<? extends LivekitEgress$SegmentsInfo> iterable) {
        ensureSegmentResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.segmentResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStreamResults(Iterable<? extends LivekitEgress$StreamInfo> iterable) {
        ensureStreamResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.streamResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileResults(LivekitEgress$FileInfo livekitEgress$FileInfo) {
        livekitEgress$FileInfo.getClass();
        ensureFileResultsIsMutable();
        this.fileResults_.add(livekitEgress$FileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImageResults(LivekitEgress$ImagesInfo livekitEgress$ImagesInfo) {
        livekitEgress$ImagesInfo.getClass();
        ensureImageResultsIsMutable();
        this.imageResults_.add(livekitEgress$ImagesInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegmentResults(LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo) {
        livekitEgress$SegmentsInfo.getClass();
        ensureSegmentResultsIsMutable();
        this.segmentResults_.add(livekitEgress$SegmentsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreamResults(LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        livekitEgress$StreamInfo.getClass();
        ensureStreamResultsIsMutable();
        this.streamResults_.add(livekitEgress$StreamInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackupStorageUsed() {
        this.backupStorageUsed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetails() {
        this.details_ = getDefaultInstance().getDetails();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressId() {
        this.egressId_ = getDefaultInstance().getEgressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorCode() {
        this.errorCode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFile() {
        if (this.resultCase_ == 8) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFileResults() {
        this.fileResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageResults() {
        this.imageResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearManifestLocation() {
        this.manifestLocation_ = getDefaultInstance().getManifestLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipant() {
        if (this.requestCase_ == 19) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomComposite() {
        if (this.requestCase_ == 4) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomId() {
        this.roomId_ = getDefaultInstance().getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegmentResults() {
        this.segmentResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegments() {
        if (this.resultCase_ == 12) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSourceType() {
        this.sourceType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStream() {
        if (this.resultCase_ == 7) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamResults() {
        this.streamResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrack() {
        if (this.requestCase_ == 6) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackComposite() {
        if (this.requestCase_ == 5) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWeb() {
        if (this.requestCase_ == 14) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    private void ensureFileResultsIsMutable() {
        B.j jVar = this.fileResults_;
        if (jVar.u()) {
            return;
        }
        this.fileResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureImageResultsIsMutable() {
        B.j jVar = this.imageResults_;
        if (jVar.u()) {
            return;
        }
        this.imageResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSegmentResultsIsMutable() {
        B.j jVar = this.segmentResults_;
        if (jVar.u()) {
            return;
        }
        this.segmentResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureStreamResultsIsMutable() {
        B.j jVar = this.streamResults_;
        if (jVar.u()) {
            return;
        }
        this.streamResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$EgressInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFile(LivekitEgress$FileInfo livekitEgress$FileInfo) {
        livekitEgress$FileInfo.getClass();
        if (this.resultCase_ != 8 || this.result_ == LivekitEgress$FileInfo.getDefaultInstance()) {
            this.result_ = livekitEgress$FileInfo;
        } else {
            this.result_ = ((LivekitEgress$FileInfo.a) LivekitEgress$FileInfo.newBuilder((LivekitEgress$FileInfo) this.result_).v(livekitEgress$FileInfo)).j();
        }
        this.resultCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParticipant(LivekitEgress$ParticipantEgressRequest livekitEgress$ParticipantEgressRequest) {
        livekitEgress$ParticipantEgressRequest.getClass();
        if (this.requestCase_ != 19 || this.request_ == LivekitEgress$ParticipantEgressRequest.getDefaultInstance()) {
            this.request_ = livekitEgress$ParticipantEgressRequest;
        } else {
            this.request_ = ((LivekitEgress$ParticipantEgressRequest.a) LivekitEgress$ParticipantEgressRequest.newBuilder((LivekitEgress$ParticipantEgressRequest) this.request_).v(livekitEgress$ParticipantEgressRequest)).j();
        }
        this.requestCase_ = 19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoomComposite(LivekitEgress$RoomCompositeEgressRequest livekitEgress$RoomCompositeEgressRequest) {
        livekitEgress$RoomCompositeEgressRequest.getClass();
        if (this.requestCase_ != 4 || this.request_ == LivekitEgress$RoomCompositeEgressRequest.getDefaultInstance()) {
            this.request_ = livekitEgress$RoomCompositeEgressRequest;
        } else {
            this.request_ = ((LivekitEgress$RoomCompositeEgressRequest.a) LivekitEgress$RoomCompositeEgressRequest.newBuilder((LivekitEgress$RoomCompositeEgressRequest) this.request_).v(livekitEgress$RoomCompositeEgressRequest)).j();
        }
        this.requestCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSegments(LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo) {
        livekitEgress$SegmentsInfo.getClass();
        if (this.resultCase_ != 12 || this.result_ == LivekitEgress$SegmentsInfo.getDefaultInstance()) {
            this.result_ = livekitEgress$SegmentsInfo;
        } else {
            this.result_ = ((LivekitEgress$SegmentsInfo.a) LivekitEgress$SegmentsInfo.newBuilder((LivekitEgress$SegmentsInfo) this.result_).v(livekitEgress$SegmentsInfo)).j();
        }
        this.resultCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStream(LivekitEgress$StreamInfoList livekitEgress$StreamInfoList) {
        livekitEgress$StreamInfoList.getClass();
        if (this.resultCase_ != 7 || this.result_ == LivekitEgress$StreamInfoList.getDefaultInstance()) {
            this.result_ = livekitEgress$StreamInfoList;
        } else {
            this.result_ = ((LivekitEgress$StreamInfoList.a) LivekitEgress$StreamInfoList.newBuilder((LivekitEgress$StreamInfoList) this.result_).v(livekitEgress$StreamInfoList)).j();
        }
        this.resultCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrack(LivekitEgress$TrackEgressRequest livekitEgress$TrackEgressRequest) {
        livekitEgress$TrackEgressRequest.getClass();
        if (this.requestCase_ != 6 || this.request_ == LivekitEgress$TrackEgressRequest.getDefaultInstance()) {
            this.request_ = livekitEgress$TrackEgressRequest;
        } else {
            this.request_ = ((LivekitEgress$TrackEgressRequest.a) LivekitEgress$TrackEgressRequest.newBuilder((LivekitEgress$TrackEgressRequest) this.request_).v(livekitEgress$TrackEgressRequest)).j();
        }
        this.requestCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrackComposite(LivekitEgress$TrackCompositeEgressRequest livekitEgress$TrackCompositeEgressRequest) {
        livekitEgress$TrackCompositeEgressRequest.getClass();
        if (this.requestCase_ != 5 || this.request_ == LivekitEgress$TrackCompositeEgressRequest.getDefaultInstance()) {
            this.request_ = livekitEgress$TrackCompositeEgressRequest;
        } else {
            this.request_ = ((LivekitEgress$TrackCompositeEgressRequest.a) LivekitEgress$TrackCompositeEgressRequest.newBuilder((LivekitEgress$TrackCompositeEgressRequest) this.request_).v(livekitEgress$TrackCompositeEgressRequest)).j();
        }
        this.requestCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeWeb(LivekitEgress$WebEgressRequest livekitEgress$WebEgressRequest) {
        livekitEgress$WebEgressRequest.getClass();
        if (this.requestCase_ != 14 || this.request_ == LivekitEgress$WebEgressRequest.getDefaultInstance()) {
            this.request_ = livekitEgress$WebEgressRequest;
        } else {
            this.request_ = ((LivekitEgress$WebEgressRequest.a) LivekitEgress$WebEgressRequest.newBuilder((LivekitEgress$WebEgressRequest) this.request_).v(livekitEgress$WebEgressRequest)).j();
        }
        this.requestCase_ = 14;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$EgressInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$EgressInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFileResults(int i) {
        ensureFileResultsIsMutable();
        this.fileResults_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImageResults(int i) {
        ensureImageResultsIsMutable();
        this.imageResults_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSegmentResults(int i) {
        ensureSegmentResultsIsMutable();
        this.segmentResults_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStreamResults(int i) {
        ensureStreamResultsIsMutable();
        this.streamResults_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackupStorageUsed(boolean z) {
        this.backupStorageUsed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetails(String str) {
        str.getClass();
        this.details_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.details_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressId(String str) {
        str.getClass();
        this.egressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.egressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCode(int i) {
        this.errorCode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFile(LivekitEgress$FileInfo livekitEgress$FileInfo) {
        livekitEgress$FileInfo.getClass();
        this.result_ = livekitEgress$FileInfo;
        this.resultCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileResults(int i, LivekitEgress$FileInfo livekitEgress$FileInfo) {
        livekitEgress$FileInfo.getClass();
        ensureFileResultsIsMutable();
        this.fileResults_.set(i, livekitEgress$FileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageResults(int i, LivekitEgress$ImagesInfo livekitEgress$ImagesInfo) {
        livekitEgress$ImagesInfo.getClass();
        ensureImageResultsIsMutable();
        this.imageResults_.set(i, livekitEgress$ImagesInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setManifestLocation(String str) {
        str.getClass();
        this.manifestLocation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setManifestLocationBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.manifestLocation_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitEgress$ParticipantEgressRequest livekitEgress$ParticipantEgressRequest) {
        livekitEgress$ParticipantEgressRequest.getClass();
        this.request_ = livekitEgress$ParticipantEgressRequest;
        this.requestCase_ = 19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomComposite(LivekitEgress$RoomCompositeEgressRequest livekitEgress$RoomCompositeEgressRequest) {
        livekitEgress$RoomCompositeEgressRequest.getClass();
        this.request_ = livekitEgress$RoomCompositeEgressRequest;
        this.requestCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomId(String str) {
        str.getClass();
        this.roomId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegmentResults(int i, LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo) {
        livekitEgress$SegmentsInfo.getClass();
        ensureSegmentResultsIsMutable();
        this.segmentResults_.set(i, livekitEgress$SegmentsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegments(LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo) {
        livekitEgress$SegmentsInfo.getClass();
        this.result_ = livekitEgress$SegmentsInfo;
        this.resultCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceType(EnumC17597nE3 enumC17597nE3) {
        this.sourceType_ = enumC17597nE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceTypeValue(int i) {
        this.sourceType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(EnumC18188oE3 enumC18188oE3) {
        this.status_ = enumC18188oE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStream(LivekitEgress$StreamInfoList livekitEgress$StreamInfoList) {
        livekitEgress$StreamInfoList.getClass();
        this.result_ = livekitEgress$StreamInfoList;
        this.resultCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamResults(int i, LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        livekitEgress$StreamInfo.getClass();
        ensureStreamResultsIsMutable();
        this.streamResults_.set(i, livekitEgress$StreamInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrack(LivekitEgress$TrackEgressRequest livekitEgress$TrackEgressRequest) {
        livekitEgress$TrackEgressRequest.getClass();
        this.request_ = livekitEgress$TrackEgressRequest;
        this.requestCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackComposite(LivekitEgress$TrackCompositeEgressRequest livekitEgress$TrackCompositeEgressRequest) {
        livekitEgress$TrackCompositeEgressRequest.getClass();
        this.request_ = livekitEgress$TrackCompositeEgressRequest;
        this.requestCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdatedAt(long j) {
        this.updatedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeb(LivekitEgress$WebEgressRequest livekitEgress$WebEgressRequest) {
        livekitEgress$WebEgressRequest.getClass();
        this.request_ = livekitEgress$WebEgressRequest;
        this.requestCase_ = 14;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$EgressInfo();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0019\u0002\u0000\u0001\u001a\u0019\u0000\u0004\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0001\b<\u0001\tȈ\n\u0002\u000b\u0002\f<\u0001\rȈ\u000e<\u0000\u000f\u001b\u0010\u001b\u0011\u001b\u0012\u0002\u0013<\u0000\u0014\u001b\u0015Ȉ\u0016\u0004\u0017Ȉ\u0019\u0007\u001a\f", new Object[]{"request_", "requestCase_", "result_", "resultCase_", "egressId_", "roomId_", "status_", LivekitEgress$RoomCompositeEgressRequest.class, LivekitEgress$TrackCompositeEgressRequest.class, LivekitEgress$TrackEgressRequest.class, LivekitEgress$StreamInfoList.class, LivekitEgress$FileInfo.class, "error_", "startedAt_", "endedAt_", LivekitEgress$SegmentsInfo.class, "roomName_", LivekitEgress$WebEgressRequest.class, "streamResults_", LivekitEgress$StreamInfo.class, "fileResults_", LivekitEgress$FileInfo.class, "segmentResults_", LivekitEgress$SegmentsInfo.class, "updatedAt_", LivekitEgress$ParticipantEgressRequest.class, "imageResults_", LivekitEgress$ImagesInfo.class, "details_", "errorCode_", "manifestLocation_", "backupStorageUsed_", "sourceType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$EgressInfo.class) {
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

    public boolean getBackupStorageUsed() {
        return this.backupStorageUsed_;
    }

    public String getDetails() {
        return this.details_;
    }

    public AbstractC2383g getDetailsBytes() {
        return AbstractC2383g.N(this.details_);
    }

    public String getEgressId() {
        return this.egressId_;
    }

    public AbstractC2383g getEgressIdBytes() {
        return AbstractC2383g.N(this.egressId_);
    }

    public long getEndedAt() {
        return this.endedAt_;
    }

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    @Deprecated
    public LivekitEgress$FileInfo getFile() {
        return this.resultCase_ == 8 ? (LivekitEgress$FileInfo) this.result_ : LivekitEgress$FileInfo.getDefaultInstance();
    }

    public LivekitEgress$FileInfo getFileResults(int i) {
        return (LivekitEgress$FileInfo) this.fileResults_.get(i);
    }

    public int getFileResultsCount() {
        return this.fileResults_.size();
    }

    public List<LivekitEgress$FileInfo> getFileResultsList() {
        return this.fileResults_;
    }

    public InterfaceC19961rE3 getFileResultsOrBuilder(int i) {
        return (InterfaceC19961rE3) this.fileResults_.get(i);
    }

    public List<? extends InterfaceC19961rE3> getFileResultsOrBuilderList() {
        return this.fileResults_;
    }

    public LivekitEgress$ImagesInfo getImageResults(int i) {
        return (LivekitEgress$ImagesInfo) this.imageResults_.get(i);
    }

    public int getImageResultsCount() {
        return this.imageResults_.size();
    }

    public List<LivekitEgress$ImagesInfo> getImageResultsList() {
        return this.imageResults_;
    }

    public InterfaceC21173tE3 getImageResultsOrBuilder(int i) {
        return (InterfaceC21173tE3) this.imageResults_.get(i);
    }

    public List<? extends InterfaceC21173tE3> getImageResultsOrBuilderList() {
        return this.imageResults_;
    }

    public String getManifestLocation() {
        return this.manifestLocation_;
    }

    public AbstractC2383g getManifestLocationBytes() {
        return AbstractC2383g.N(this.manifestLocation_);
    }

    public LivekitEgress$ParticipantEgressRequest getParticipant() {
        return this.requestCase_ == 19 ? (LivekitEgress$ParticipantEgressRequest) this.request_ : LivekitEgress$ParticipantEgressRequest.getDefaultInstance();
    }

    public b getRequestCase() {
        return b.j(this.requestCase_);
    }

    public c getResultCase() {
        return c.j(this.resultCase_);
    }

    public LivekitEgress$RoomCompositeEgressRequest getRoomComposite() {
        return this.requestCase_ == 4 ? (LivekitEgress$RoomCompositeEgressRequest) this.request_ : LivekitEgress$RoomCompositeEgressRequest.getDefaultInstance();
    }

    public String getRoomId() {
        return this.roomId_;
    }

    public AbstractC2383g getRoomIdBytes() {
        return AbstractC2383g.N(this.roomId_);
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public LivekitEgress$SegmentsInfo getSegmentResults(int i) {
        return (LivekitEgress$SegmentsInfo) this.segmentResults_.get(i);
    }

    public int getSegmentResultsCount() {
        return this.segmentResults_.size();
    }

    public List<LivekitEgress$SegmentsInfo> getSegmentResultsList() {
        return this.segmentResults_;
    }

    public InterfaceC23033wE3 getSegmentResultsOrBuilder(int i) {
        return (InterfaceC23033wE3) this.segmentResults_.get(i);
    }

    public List<? extends InterfaceC23033wE3> getSegmentResultsOrBuilderList() {
        return this.segmentResults_;
    }

    @Deprecated
    public LivekitEgress$SegmentsInfo getSegments() {
        return this.resultCase_ == 12 ? (LivekitEgress$SegmentsInfo) this.result_ : LivekitEgress$SegmentsInfo.getDefaultInstance();
    }

    public EnumC17597nE3 getSourceType() {
        EnumC17597nE3 enumC17597nE3J = EnumC17597nE3.j(this.sourceType_);
        return enumC17597nE3J == null ? EnumC17597nE3.UNRECOGNIZED : enumC17597nE3J;
    }

    public int getSourceTypeValue() {
        return this.sourceType_;
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public EnumC18188oE3 getStatus() {
        EnumC18188oE3 enumC18188oE3J = EnumC18188oE3.j(this.status_);
        return enumC18188oE3J == null ? EnumC18188oE3.UNRECOGNIZED : enumC18188oE3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    @Deprecated
    public LivekitEgress$StreamInfoList getStream() {
        return this.resultCase_ == 7 ? (LivekitEgress$StreamInfoList) this.result_ : LivekitEgress$StreamInfoList.getDefaultInstance();
    }

    public LivekitEgress$StreamInfo getStreamResults(int i) {
        return (LivekitEgress$StreamInfo) this.streamResults_.get(i);
    }

    public int getStreamResultsCount() {
        return this.streamResults_.size();
    }

    public List<LivekitEgress$StreamInfo> getStreamResultsList() {
        return this.streamResults_;
    }

    public k getStreamResultsOrBuilder(int i) {
        return (k) this.streamResults_.get(i);
    }

    public List<? extends k> getStreamResultsOrBuilderList() {
        return this.streamResults_;
    }

    public LivekitEgress$TrackEgressRequest getTrack() {
        return this.requestCase_ == 6 ? (LivekitEgress$TrackEgressRequest) this.request_ : LivekitEgress$TrackEgressRequest.getDefaultInstance();
    }

    public LivekitEgress$TrackCompositeEgressRequest getTrackComposite() {
        return this.requestCase_ == 5 ? (LivekitEgress$TrackCompositeEgressRequest) this.request_ : LivekitEgress$TrackCompositeEgressRequest.getDefaultInstance();
    }

    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    public LivekitEgress$WebEgressRequest getWeb() {
        return this.requestCase_ == 14 ? (LivekitEgress$WebEgressRequest) this.request_ : LivekitEgress$WebEgressRequest.getDefaultInstance();
    }

    @Deprecated
    public boolean hasFile() {
        return this.resultCase_ == 8;
    }

    public boolean hasParticipant() {
        return this.requestCase_ == 19;
    }

    public boolean hasRoomComposite() {
        return this.requestCase_ == 4;
    }

    @Deprecated
    public boolean hasSegments() {
        return this.resultCase_ == 12;
    }

    @Deprecated
    public boolean hasStream() {
        return this.resultCase_ == 7;
    }

    public boolean hasTrack() {
        return this.requestCase_ == 6;
    }

    public boolean hasTrackComposite() {
        return this.requestCase_ == 5;
    }

    public boolean hasWeb() {
        return this.requestCase_ == 14;
    }

    public static a newBuilder(LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$EgressInfo);
    }

    public static LivekitEgress$EgressInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$EgressInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$EgressInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileResults(int i, LivekitEgress$FileInfo livekitEgress$FileInfo) {
        livekitEgress$FileInfo.getClass();
        ensureFileResultsIsMutable();
        this.fileResults_.add(i, livekitEgress$FileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImageResults(int i, LivekitEgress$ImagesInfo livekitEgress$ImagesInfo) {
        livekitEgress$ImagesInfo.getClass();
        ensureImageResultsIsMutable();
        this.imageResults_.add(i, livekitEgress$ImagesInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegmentResults(int i, LivekitEgress$SegmentsInfo livekitEgress$SegmentsInfo) {
        livekitEgress$SegmentsInfo.getClass();
        ensureSegmentResultsIsMutable();
        this.segmentResults_.add(i, livekitEgress$SegmentsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreamResults(int i, LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        livekitEgress$StreamInfo.getClass();
        ensureStreamResultsIsMutable();
        this.streamResults_.add(i, livekitEgress$StreamInfo);
    }

    public static LivekitEgress$EgressInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$EgressInfo parseFrom(byte[] bArr) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$EgressInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$EgressInfo parseFrom(InputStream inputStream) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$EgressInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$EgressInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$EgressInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$EgressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
