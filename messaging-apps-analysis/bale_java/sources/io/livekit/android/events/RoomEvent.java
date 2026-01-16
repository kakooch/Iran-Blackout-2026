package io.livekit.android.events;

import io.livekit.android.room.Room;
import io.livekit.android.room.participant.Participant;
import io.livekit.android.room.participant.a;
import io.livekit.android.room.participant.c;
import io.livekit.android.room.participant.d;
import io.livekit.android.room.track.TrackException;
import ir.nasim.AN5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17794na2;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC4838Gt7;
import ir.nasim.C20597sH3;
import ir.nasim.C22;
import ir.nasim.C24025xu7;
import ir.nasim.ED1;
import ir.nasim.EnumC22663vd1;
import ir.nasim.UT1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u001e\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u001e'()*+,-./0123456789:;<=>?@ABCD¨\u0006E"}, d2 = {"Lio/livekit/android/events/RoomEvent;", "Lir/nasim/na2;", "Lio/livekit/android/room/Room;", "room", "<init>", "(Lio/livekit/android/room/Room;)V", "Lio/livekit/android/room/Room;", "getRoom", "()Lio/livekit/android/room/Room;", "ActiveSpeakersChanged", "Connected", "ConnectionQualityChanged", "DataReceived", "Disconnected", "FailedToConnect", "LocalTrackSubscribed", "ParticipantAttributesChanged", "ParticipantConnected", "ParticipantDisconnected", "ParticipantMetadataChanged", "ParticipantNameChanged", "ParticipantPermissionsChanged", "ParticipantStateChanged", "Reconnected", "Reconnecting", "RecordingStatusChanged", "RoomMetadataChanged", "TrackE2EEStateEvent", "TrackMuted", "TrackPublicationFailed", "TrackPublished", "TrackStreamStateChanged", "TrackSubscribed", "TrackSubscriptionFailed", "TrackSubscriptionPermissionChanged", "TrackUnmuted", "TrackUnpublished", "TrackUnsubscribed", "TranscriptionReceived", "Lio/livekit/android/events/RoomEvent$ActiveSpeakersChanged;", "Lio/livekit/android/events/RoomEvent$Connected;", "Lio/livekit/android/events/RoomEvent$ConnectionQualityChanged;", "Lio/livekit/android/events/RoomEvent$DataReceived;", "Lio/livekit/android/events/RoomEvent$Disconnected;", "Lio/livekit/android/events/RoomEvent$FailedToConnect;", "Lio/livekit/android/events/RoomEvent$LocalTrackSubscribed;", "Lio/livekit/android/events/RoomEvent$ParticipantAttributesChanged;", "Lio/livekit/android/events/RoomEvent$ParticipantConnected;", "Lio/livekit/android/events/RoomEvent$ParticipantDisconnected;", "Lio/livekit/android/events/RoomEvent$ParticipantMetadataChanged;", "Lio/livekit/android/events/RoomEvent$ParticipantNameChanged;", "Lio/livekit/android/events/RoomEvent$ParticipantPermissionsChanged;", "Lio/livekit/android/events/RoomEvent$ParticipantStateChanged;", "Lio/livekit/android/events/RoomEvent$Reconnected;", "Lio/livekit/android/events/RoomEvent$Reconnecting;", "Lio/livekit/android/events/RoomEvent$RecordingStatusChanged;", "Lio/livekit/android/events/RoomEvent$RoomMetadataChanged;", "Lio/livekit/android/events/RoomEvent$TrackE2EEStateEvent;", "Lio/livekit/android/events/RoomEvent$TrackMuted;", "Lio/livekit/android/events/RoomEvent$TrackPublicationFailed;", "Lio/livekit/android/events/RoomEvent$TrackPublished;", "Lio/livekit/android/events/RoomEvent$TrackStreamStateChanged;", "Lio/livekit/android/events/RoomEvent$TrackSubscribed;", "Lio/livekit/android/events/RoomEvent$TrackSubscriptionFailed;", "Lio/livekit/android/events/RoomEvent$TrackSubscriptionPermissionChanged;", "Lio/livekit/android/events/RoomEvent$TrackUnmuted;", "Lio/livekit/android/events/RoomEvent$TrackUnpublished;", "Lio/livekit/android/events/RoomEvent$TrackUnsubscribed;", "Lio/livekit/android/events/RoomEvent$TranscriptionReceived;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class RoomEvent extends AbstractC17794na2 {
    private final Room room;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/livekit/android/events/RoomEvent$ActiveSpeakersChanged;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "speakers", "", "Lio/livekit/android/room/participant/Participant;", "(Lio/livekit/android/room/Room;Ljava/util/List;)V", "getSpeakers", "()Ljava/util/List;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ActiveSpeakersChanged extends RoomEvent {
        private final List<Participant> speakers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ActiveSpeakersChanged(Room room, List<? extends Participant> list) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(list, "speakers");
            this.speakers = list;
        }

        public final List<Participant> getSpeakers() {
            return this.speakers;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/livekit/android/events/RoomEvent$Connected;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "(Lio/livekit/android/room/Room;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Connected extends RoomEvent {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Connected(Room room) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$ConnectionQualityChanged;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lio/livekit/android/room/participant/Participant;", "participant", "Lir/nasim/vd1;", "quality", "<init>", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/Participant;Lir/nasim/vd1;)V", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "Lir/nasim/vd1;", "getQuality", "()Lir/nasim/vd1;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class ConnectionQualityChanged extends RoomEvent {
        private final Participant participant;
        private final EnumC22663vd1 quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectionQualityChanged(Room room, Participant participant, EnumC22663vd1 enumC22663vd1) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(enumC22663vd1, "quality");
            this.participant = participant;
            this.quality = enumC22663vd1;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final EnumC22663vd1 getQuality() {
            return this.quality;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/livekit/android/events/RoomEvent$DataReceived;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "", "data", "Lio/livekit/android/room/participant/d;", "participant", "", "topic", "<init>", "(Lio/livekit/android/room/Room;[BLio/livekit/android/room/participant/d;Ljava/lang/String;)V", "[B", "getData", "()[B", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "Ljava/lang/String;", "getTopic", "()Ljava/lang/String;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class DataReceived extends RoomEvent {
        private final byte[] data;
        private final d participant;
        private final String topic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DataReceived(Room room, byte[] bArr, d dVar, String str) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(bArr, "data");
            this.data = bArr;
            this.participant = dVar;
            this.topic = str;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final d getParticipant() {
            return this.participant;
        }

        public final String getTopic() {
            return this.topic;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/livekit/android/events/RoomEvent$Disconnected;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lir/nasim/UT1;", "reason", "<init>", "(Lio/livekit/android/room/Room;Ljava/lang/Exception;Lir/nasim/UT1;)V", "Ljava/lang/Exception;", "getError", "()Ljava/lang/Exception;", "Lir/nasim/UT1;", "getReason", "()Lir/nasim/UT1;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class Disconnected extends RoomEvent {
        private final Exception error;
        private final UT1 reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Disconnected(Room room, Exception exc, UT1 ut1) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(ut1, "reason");
            this.error = exc;
            this.reason = ut1;
        }

        public final Exception getError() {
            return this.error;
        }

        public final UT1 getReason() {
            return this.reason;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/livekit/android/events/RoomEvent$FailedToConnect;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "error", "", "(Lio/livekit/android/room/Room;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FailedToConnect extends RoomEvent {
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToConnect(Room room, Throwable th) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$LocalTrackSubscribed;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/sH3;", "publication", "Lio/livekit/android/room/participant/a;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/sH3;Lio/livekit/android/room/participant/a;)V", "Lir/nasim/sH3;", "getPublication", "()Lir/nasim/sH3;", "Lio/livekit/android/room/participant/a;", "getParticipant", "()Lio/livekit/android/room/participant/a;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class LocalTrackSubscribed extends RoomEvent {
        private final a participant;
        private final C20597sH3 publication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalTrackSubscribed(Room room, C20597sH3 c20597sH3, a aVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(c20597sH3, "publication");
            AbstractC13042fc3.i(aVar, "participant");
            this.publication = c20597sH3;
            this.participant = aVar;
        }

        public final a getParticipant() {
            return this.participant;
        }

        public final C20597sH3 getPublication() {
            return this.publication;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantAttributesChanged;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "participant", "Lio/livekit/android/room/participant/Participant;", "changedAttributes", "", "", "oldAttributes", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/Participant;Ljava/util/Map;Ljava/util/Map;)V", "getChangedAttributes", "()Ljava/util/Map;", "getOldAttributes", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ParticipantAttributesChanged extends RoomEvent {
        private final Map<String, String> changedAttributes;
        private final Map<String, String> oldAttributes;
        private final Participant participant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantAttributesChanged(Room room, Participant participant, Map<String, String> map, Map<String, String> map2) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(map, "changedAttributes");
            AbstractC13042fc3.i(map2, "oldAttributes");
            this.participant = participant;
            this.changedAttributes = map;
            this.oldAttributes = map2;
        }

        public final Map<String, String> getChangedAttributes() {
            return this.changedAttributes;
        }

        public final Map<String, String> getOldAttributes() {
            return this.oldAttributes;
        }

        public final Participant getParticipant() {
            return this.participant;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantConnected;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lio/livekit/android/room/participant/d;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/d;)V", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class ParticipantConnected extends RoomEvent {
        private final d participant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantConnected(Room room, d dVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(dVar, "participant");
            this.participant = dVar;
        }

        public final d getParticipant() {
            return this.participant;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantDisconnected;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lio/livekit/android/room/participant/d;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/d;)V", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class ParticipantDisconnected extends RoomEvent {
        private final d participant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantDisconnected(Room room, d dVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(dVar, "participant");
            this.participant = dVar;
        }

        public final d getParticipant() {
            return this.participant;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantMetadataChanged;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "participant", "Lio/livekit/android/room/participant/Participant;", "prevMetadata", "", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/Participant;Ljava/lang/String;)V", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "getPrevMetadata", "()Ljava/lang/String;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ParticipantMetadataChanged extends RoomEvent {
        private final Participant participant;
        private final String prevMetadata;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantMetadataChanged(Room room, Participant participant, String str) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(participant, "participant");
            this.participant = participant;
            this.prevMetadata = str;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final String getPrevMetadata() {
            return this.prevMetadata;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantNameChanged;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "participant", "Lio/livekit/android/room/participant/Participant;", "name", "", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/Participant;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ParticipantNameChanged extends RoomEvent {
        private final String name;
        private final Participant participant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantNameChanged(Room room, Participant participant, String str) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(participant, "participant");
            this.participant = participant;
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }

        public final Participant getParticipant() {
            return this.participant;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantPermissionsChanged;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lio/livekit/android/room/participant/Participant;", "participant", "Lio/livekit/android/room/participant/c;", "newPermissions", "oldPermissions", "<init>", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/Participant;Lio/livekit/android/room/participant/c;Lio/livekit/android/room/participant/c;)V", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "Lio/livekit/android/room/participant/c;", "getNewPermissions", "()Lio/livekit/android/room/participant/c;", "getOldPermissions", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class ParticipantPermissionsChanged extends RoomEvent {
        private final c newPermissions;
        private final c oldPermissions;
        private final Participant participant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantPermissionsChanged(Room room, Participant participant, c cVar, c cVar2) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(participant, "participant");
            this.participant = participant;
            this.newPermissions = cVar;
            this.oldPermissions = cVar2;
        }

        public final c getNewPermissions() {
            return this.newPermissions;
        }

        public final c getOldPermissions() {
            return this.oldPermissions;
        }

        public final Participant getParticipant() {
            return this.participant;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/livekit/android/events/RoomEvent$ParticipantStateChanged;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lio/livekit/android/room/participant/Participant;", "participant", "Lio/livekit/android/room/participant/Participant$b;", "newState", "oldState", "<init>", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/Participant;Lio/livekit/android/room/participant/Participant$b;Lio/livekit/android/room/participant/Participant$b;)V", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "Lio/livekit/android/room/participant/Participant$b;", "getNewState", "()Lio/livekit/android/room/participant/Participant$b;", "getOldState", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class ParticipantStateChanged extends RoomEvent {
        private final Participant.b newState;
        private final Participant.b oldState;
        private final Participant participant;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantStateChanged(Room room, Participant participant, Participant.b bVar, Participant.b bVar2) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(bVar, "newState");
            AbstractC13042fc3.i(bVar2, "oldState");
            this.participant = participant;
            this.newState = bVar;
            this.oldState = bVar2;
        }

        public final Participant.b getNewState() {
            return this.newState;
        }

        public final Participant.b getOldState() {
            return this.oldState;
        }

        public final Participant getParticipant() {
            return this.participant;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/livekit/android/events/RoomEvent$Reconnected;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "(Lio/livekit/android/room/Room;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Reconnected extends RoomEvent {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reconnected(Room room) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/livekit/android/events/RoomEvent$Reconnecting;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "(Lio/livekit/android/room/Room;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Reconnecting extends RoomEvent {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reconnecting(Room room) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/events/RoomEvent$RecordingStatusChanged;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "isRecording", "", "(Lio/livekit/android/room/Room;Z)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecordingStatusChanged extends RoomEvent {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecordingStatusChanged(Room room, boolean z) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lio/livekit/android/events/RoomEvent$RoomMetadataChanged;", "Lio/livekit/android/events/RoomEvent;", "room", "Lio/livekit/android/room/Room;", "newMetadata", "", "prevMetadata", "(Lio/livekit/android/room/Room;Ljava/lang/String;Ljava/lang/String;)V", "getNewMetadata", "()Ljava/lang/String;", "getPrevMetadata", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RoomMetadataChanged extends RoomEvent {
        private final String newMetadata;
        private final String prevMetadata;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoomMetadataChanged(Room room, String str, String str2) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            this.newMetadata = str;
            this.prevMetadata = str2;
        }

        public final String getNewMetadata() {
            return this.newMetadata;
        }

        public final String getPrevMetadata() {
            return this.prevMetadata;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackE2EEStateEvent;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/tt7;", "track", "Lir/nasim/Gt7;", "publication", "Lio/livekit/android/room/participant/Participant;", "participant", "Lir/nasim/C22;", "state", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/tt7;Lir/nasim/Gt7;Lio/livekit/android/room/participant/Participant;Lir/nasim/C22;)V", "Lir/nasim/tt7;", "getTrack", "()Lir/nasim/tt7;", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "Lir/nasim/C22;", "getState", "()Lir/nasim/C22;", "setState", "(Lir/nasim/C22;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackE2EEStateEvent extends RoomEvent {
        private final Participant participant;
        private final AbstractC4838Gt7 publication;
        private C22 state;
        private final AbstractC21649tt7 track;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackE2EEStateEvent(Room room, AbstractC21649tt7 abstractC21649tt7, AbstractC4838Gt7 abstractC4838Gt7, Participant participant, C22 c22) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(c22, "state");
            this.track = abstractC21649tt7;
            this.publication = abstractC4838Gt7;
            this.participant = participant;
            this.state = c22;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }

        public final C22 getState() {
            return this.state;
        }

        public final AbstractC21649tt7 getTrack() {
            return this.track;
        }

        public final void setState(C22 c22) {
            AbstractC13042fc3.i(c22, "<set-?>");
            this.state = c22;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackMuted;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/Gt7;", "publication", "Lio/livekit/android/room/participant/Participant;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/Gt7;Lio/livekit/android/room/participant/Participant;)V", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackMuted extends RoomEvent {
        private final Participant participant;
        private final AbstractC4838Gt7 publication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackMuted(Room room, AbstractC4838Gt7 abstractC4838Gt7, Participant participant) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(participant, "participant");
            this.publication = abstractC4838Gt7;
            this.participant = participant;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackPublicationFailed;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/tt7;", "track", "Lio/livekit/android/room/participant/a;", "participant", "Lio/livekit/android/room/track/TrackException$PublishException;", "e", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/tt7;Lio/livekit/android/room/participant/a;Lio/livekit/android/room/track/TrackException$PublishException;)V", "Lir/nasim/tt7;", "getTrack", "()Lir/nasim/tt7;", "Lio/livekit/android/room/participant/a;", "getParticipant", "()Lio/livekit/android/room/participant/a;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackPublicationFailed extends RoomEvent {
        private final a participant;
        private final AbstractC21649tt7 track;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackPublicationFailed(Room room, AbstractC21649tt7 abstractC21649tt7, a aVar, TrackException.PublishException publishException) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(aVar, "participant");
            AbstractC13042fc3.i(publishException, "e");
            this.track = abstractC21649tt7;
            this.participant = aVar;
        }

        public final a getParticipant() {
            return this.participant;
        }

        public final AbstractC21649tt7 getTrack() {
            return this.track;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackPublished;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/Gt7;", "publication", "Lio/livekit/android/room/participant/Participant;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/Gt7;Lio/livekit/android/room/participant/Participant;)V", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackPublished extends RoomEvent {
        private final Participant participant;
        private final AbstractC4838Gt7 publication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackPublished(Room room, AbstractC4838Gt7 abstractC4838Gt7, Participant participant) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(participant, "participant");
            this.publication = abstractC4838Gt7;
            this.participant = participant;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackStreamStateChanged;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/Gt7;", "trackPublication", "Lir/nasim/tt7$h;", "streamState", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/Gt7;Lir/nasim/tt7$h;)V", "Lir/nasim/Gt7;", "getTrackPublication", "()Lir/nasim/Gt7;", "Lir/nasim/tt7$h;", "getStreamState", "()Lir/nasim/tt7$h;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackStreamStateChanged extends RoomEvent {
        private final AbstractC21649tt7.h streamState;
        private final AbstractC4838Gt7 trackPublication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackStreamStateChanged(Room room, AbstractC4838Gt7 abstractC4838Gt7, AbstractC21649tt7.h hVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC4838Gt7, "trackPublication");
            AbstractC13042fc3.i(hVar, "streamState");
            this.trackPublication = abstractC4838Gt7;
            this.streamState = hVar;
        }

        public final AbstractC21649tt7.h getStreamState() {
            return this.streamState;
        }

        public final AbstractC4838Gt7 getTrackPublication() {
            return this.trackPublication;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackSubscribed;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/tt7;", "track", "Lir/nasim/Gt7;", "publication", "Lio/livekit/android/room/participant/d;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/tt7;Lir/nasim/Gt7;Lio/livekit/android/room/participant/d;)V", "Lir/nasim/tt7;", "getTrack", "()Lir/nasim/tt7;", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackSubscribed extends RoomEvent {
        private final d participant;
        private final AbstractC4838Gt7 publication;
        private final AbstractC21649tt7 track;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackSubscribed(Room room, AbstractC21649tt7 abstractC21649tt7, AbstractC4838Gt7 abstractC4838Gt7, d dVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(dVar, "participant");
            this.track = abstractC21649tt7;
            this.publication = abstractC4838Gt7;
            this.participant = dVar;
        }

        public final d getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }

        public final AbstractC21649tt7 getTrack() {
            return this.track;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackSubscriptionFailed;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "", "sid", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lio/livekit/android/room/participant/d;", "participant", "<init>", "(Lio/livekit/android/room/Room;Ljava/lang/String;Ljava/lang/Exception;Lio/livekit/android/room/participant/d;)V", "Ljava/lang/String;", "getSid", "()Ljava/lang/String;", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackSubscriptionFailed extends RoomEvent {
        private final Exception exception;
        private final d participant;
        private final String sid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackSubscriptionFailed(Room room, String str, Exception exc, d dVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(str, "sid");
            AbstractC13042fc3.i(exc, "exception");
            AbstractC13042fc3.i(dVar, "participant");
            this.sid = str;
            this.exception = exc;
            this.participant = dVar;
        }

        public final Exception getException() {
            return this.exception;
        }

        public final d getParticipant() {
            return this.participant;
        }

        public final String getSid() {
            return this.sid;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackSubscriptionPermissionChanged;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lio/livekit/android/room/participant/d;", "participant", "Lir/nasim/AN5;", "trackPublication", "", "subscriptionAllowed", "<init>", "(Lio/livekit/android/room/Room;Lio/livekit/android/room/participant/d;Lir/nasim/AN5;Z)V", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "Lir/nasim/AN5;", "getTrackPublication", "()Lir/nasim/AN5;", "Z", "getSubscriptionAllowed", "()Z", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackSubscriptionPermissionChanged extends RoomEvent {
        private final d participant;
        private final boolean subscriptionAllowed;
        private final AN5 trackPublication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackSubscriptionPermissionChanged(Room room, d dVar, AN5 an5, boolean z) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(an5, "trackPublication");
            this.participant = dVar;
            this.trackPublication = an5;
            this.subscriptionAllowed = z;
        }

        public final d getParticipant() {
            return this.participant;
        }

        public final boolean getSubscriptionAllowed() {
            return this.subscriptionAllowed;
        }

        public final AN5 getTrackPublication() {
            return this.trackPublication;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackUnmuted;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/Gt7;", "publication", "Lio/livekit/android/room/participant/Participant;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/Gt7;Lio/livekit/android/room/participant/Participant;)V", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackUnmuted extends RoomEvent {
        private final Participant participant;
        private final AbstractC4838Gt7 publication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackUnmuted(Room room, AbstractC4838Gt7 abstractC4838Gt7, Participant participant) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(participant, "participant");
            this.publication = abstractC4838Gt7;
            this.participant = participant;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackUnpublished;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/Gt7;", "publication", "Lio/livekit/android/room/participant/Participant;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/Gt7;Lio/livekit/android/room/participant/Participant;)V", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackUnpublished extends RoomEvent {
        private final Participant participant;
        private final AbstractC4838Gt7 publication;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackUnpublished(Room room, AbstractC4838Gt7 abstractC4838Gt7, Participant participant) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(participant, "participant");
            this.publication = abstractC4838Gt7;
            this.participant = participant;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/livekit/android/events/RoomEvent$TrackUnsubscribed;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "Lir/nasim/tt7;", "track", "Lir/nasim/Gt7;", "publications", "Lio/livekit/android/room/participant/d;", "participant", "<init>", "(Lio/livekit/android/room/Room;Lir/nasim/tt7;Lir/nasim/Gt7;Lio/livekit/android/room/participant/d;)V", "Lir/nasim/tt7;", "getTrack", "()Lir/nasim/tt7;", "Lir/nasim/Gt7;", "getPublications", "()Lir/nasim/Gt7;", "Lio/livekit/android/room/participant/d;", "getParticipant", "()Lio/livekit/android/room/participant/d;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TrackUnsubscribed extends RoomEvent {
        private final d participant;
        private final AbstractC4838Gt7 publications;
        private final AbstractC21649tt7 track;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackUnsubscribed(Room room, AbstractC21649tt7 abstractC21649tt7, AbstractC4838Gt7 abstractC4838Gt7, d dVar) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(abstractC4838Gt7, "publications");
            AbstractC13042fc3.i(dVar, "participant");
            this.track = abstractC21649tt7;
            this.publications = abstractC4838Gt7;
            this.participant = dVar;
        }

        public final d getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublications() {
            return this.publications;
        }

        public final AbstractC21649tt7 getTrack() {
            return this.track;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/livekit/android/events/RoomEvent$TranscriptionReceived;", "Lio/livekit/android/events/RoomEvent;", "Lio/livekit/android/room/Room;", "room", "", "Lir/nasim/xu7;", "transcriptionSegments", "Lio/livekit/android/room/participant/Participant;", "participant", "Lir/nasim/Gt7;", "publication", "<init>", "(Lio/livekit/android/room/Room;Ljava/util/List;Lio/livekit/android/room/participant/Participant;Lir/nasim/Gt7;)V", "Ljava/util/List;", "getTranscriptionSegments", "()Ljava/util/List;", "Lio/livekit/android/room/participant/Participant;", "getParticipant", "()Lio/livekit/android/room/participant/Participant;", "Lir/nasim/Gt7;", "getPublication", "()Lir/nasim/Gt7;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class TranscriptionReceived extends RoomEvent {
        private final Participant participant;
        private final AbstractC4838Gt7 publication;
        private final List<C24025xu7> transcriptionSegments;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TranscriptionReceived(Room room, List<C24025xu7> list, Participant participant, AbstractC4838Gt7 abstractC4838Gt7) {
            super(room, null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(list, "transcriptionSegments");
            this.transcriptionSegments = list;
            this.participant = participant;
            this.publication = abstractC4838Gt7;
        }

        public final Participant getParticipant() {
            return this.participant;
        }

        public final AbstractC4838Gt7 getPublication() {
            return this.publication;
        }

        public final List<C24025xu7> getTranscriptionSegments() {
            return this.transcriptionSegments;
        }
    }

    public /* synthetic */ RoomEvent(Room room, ED1 ed1) {
        this(room);
    }

    public final Room getRoom() {
        return this.room;
    }

    private RoomEvent(Room room) {
        super(null);
        this.room = room;
    }
}
