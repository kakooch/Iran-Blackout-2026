package io.livekit.android.room.track;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.ED1;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\b\t\n\u000b\fB\u001f\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/livekit/android/room/track/TrackException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "DuplicateTrackException", "InvalidTrackStateException", "InvalidTrackTypeException", "MediaException", "PublishException", "Lio/livekit/android/room/track/TrackException$DuplicateTrackException;", "Lio/livekit/android/room/track/TrackException$InvalidTrackStateException;", "Lio/livekit/android/room/track/TrackException$InvalidTrackTypeException;", "Lio/livekit/android/room/track/TrackException$MediaException;", "Lio/livekit/android/room/track/TrackException$PublishException;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TrackException extends Exception {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/room/track/TrackException$DuplicateTrackException;", "Lio/livekit/android/room/track/TrackException;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DuplicateTrackException extends TrackException {
        /* JADX WARN: Multi-variable type inference failed */
        public DuplicateTrackException() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ DuplicateTrackException(String str, Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        public DuplicateTrackException(String str, Throwable th) {
            super(str, th, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/room/track/TrackException$InvalidTrackStateException;", "Lio/livekit/android/room/track/TrackException;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InvalidTrackStateException extends TrackException {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidTrackStateException() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ InvalidTrackStateException(String str, Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        public InvalidTrackStateException(String str, Throwable th) {
            super(str, th, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/room/track/TrackException$InvalidTrackTypeException;", "Lio/livekit/android/room/track/TrackException;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InvalidTrackTypeException extends TrackException {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidTrackTypeException() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ InvalidTrackTypeException(String str, Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        public InvalidTrackTypeException(String str, Throwable th) {
            super(str, th, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/room/track/TrackException$MediaException;", "Lio/livekit/android/room/track/TrackException;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MediaException extends TrackException {
        /* JADX WARN: Multi-variable type inference failed */
        public MediaException() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ MediaException(String str, Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        public MediaException(String str, Throwable th) {
            super(str, th, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/room/track/TrackException$PublishException;", "Lio/livekit/android/room/track/TrackException;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PublishException extends TrackException {
        /* JADX WARN: Multi-variable type inference failed */
        public PublishException() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ PublishException(String str, Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        public PublishException(String str, Throwable th) {
            super(str, th, null);
        }
    }

    public /* synthetic */ TrackException(String str, Throwable th, ED1 ed1) {
        this(str, th);
    }

    private TrackException(String str, Throwable th) {
        super(str, th);
    }
}
