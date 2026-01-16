package io.livekit.android.room;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.ED1;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\bB\u001f\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u0082\u0001\u0001\t¨\u0006\n"}, d2 = {"Lio/livekit/android/room/RoomException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ConnectException", "Lio/livekit/android/room/RoomException$ConnectException;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RoomException extends Exception {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/livekit/android/room/RoomException$ConnectException;", "Lio/livekit/android/room/RoomException;", DialogEntity.COLUMN_MESSAGE, "", ParameterNames.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectException extends RoomException {
        /* JADX WARN: Multi-variable type inference failed */
        public ConnectException() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ ConnectException(String str, Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
        }

        public ConnectException(String str, Throwable th) {
            super(str, th, null);
        }
    }

    public /* synthetic */ RoomException(String str, Throwable th, ED1 ed1) {
        this(str, th);
    }

    private RoomException(String str, Throwable th) {
        super(str, th);
    }
}
