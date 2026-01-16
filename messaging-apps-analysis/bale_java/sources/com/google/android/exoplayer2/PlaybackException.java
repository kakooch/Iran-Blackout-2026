package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.InterfaceC2029g;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC9683aN7;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public class PlaybackException extends Exception implements InterfaceC2029g {
    private static final String c = AbstractC9683aN7.r0(0);
    private static final String d = AbstractC9683aN7.r0(1);
    private static final String e = AbstractC9683aN7.r0(2);
    private static final String f = AbstractC9683aN7.r0(3);
    private static final String g = AbstractC9683aN7.r0(4);
    public static final InterfaceC2029g.a h = new InterfaceC2029g.a() { // from class: com.google.android.exoplayer2.w0
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return new PlaybackException(bundle);
        }
    };
    public final int a;
    public final long b;

    protected PlaybackException(Bundle bundle) {
        this(bundle.getString(e), d(bundle), bundle.getInt(c, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), bundle.getLong(d, SystemClock.elapsedRealtime()));
    }

    private static RemoteException b(String str) {
        return new RemoteException(str);
    }

    private static Throwable c(Class cls, String str) {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    private static Throwable d(Bundle bundle) {
        String string = bundle.getString(f);
        String string2 = bundle.getString(g);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, PlaybackException.class.getClassLoader());
            Throwable thC = Throwable.class.isAssignableFrom(cls) ? c(cls, string2) : null;
            if (thC != null) {
                return thC;
            }
        } catch (Throwable unused) {
        }
        return b(string2);
    }

    public static String f(int i) {
        if (i == 5001) {
            return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
        }
        if (i == 5002) {
            return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
        }
        switch (i) {
            case AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT /* 1000 */:
                return "ERROR_CODE_UNSPECIFIED";
            case WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY /* 1001 */:
                return "ERROR_CODE_REMOTE_ERROR";
            case 1002:
                return "ERROR_CODE_BEHIND_LIVE_WINDOW";
            case 1003:
                return "ERROR_CODE_TIMEOUT";
            case 1004:
                return "ERROR_CODE_FAILED_RUNTIME_CHECK";
            default:
                switch (i) {
                    case 2000:
                        return "ERROR_CODE_IO_UNSPECIFIED";
                    case 2001:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                    case 2002:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                    case 2003:
                        return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                    case 2004:
                        return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                    case 2005:
                        return "ERROR_CODE_IO_FILE_NOT_FOUND";
                    case 2006:
                        return "ERROR_CODE_IO_NO_PERMISSION";
                    case 2007:
                        return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                    case 2008:
                        return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                    default:
                        switch (i) {
                            case 3001:
                                return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                            case 3002:
                                return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                            case 3003:
                                return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                            case 3004:
                                return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                            default:
                                switch (i) {
                                    case 4001:
                                        return "ERROR_CODE_DECODER_INIT_FAILED";
                                    case 4002:
                                        return "ERROR_CODE_DECODER_QUERY_FAILED";
                                    case 4003:
                                        return "ERROR_CODE_DECODING_FAILED";
                                    case 4004:
                                        return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                    case 4005:
                                        return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                    default:
                                        switch (i) {
                                            case 6000:
                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                            case 6001:
                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                            case 6002:
                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                            case 6003:
                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                            case 6004:
                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                            case 6005:
                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                            case 6006:
                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                            case 6007:
                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                            case 6008:
                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                            default:
                                                return i >= 1000000 ? "custom error code" : "invalid error code";
                                        }
                                }
                        }
                }
        }
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(c, this.a);
        bundle.putLong(d, this.b);
        bundle.putString(e, getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(f, cause.getClass().getName());
            bundle.putString(g, cause.getMessage());
        }
        return bundle;
    }

    public final String e() {
        return f(this.a);
    }

    protected PlaybackException(String str, Throwable th, int i, long j) {
        super(str, th);
        this.a = i;
        this.b = j;
    }
}
