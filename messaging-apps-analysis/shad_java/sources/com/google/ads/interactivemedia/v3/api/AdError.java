package com.google.ads.interactivemedia.v3.api;

import com.facebook.stetho.server.http.HttpStatus;
import ir.aaap.messengercore.db.DBHelper;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class AdError extends Exception {
    private final AdErrorCode a;
    private final AdErrorType b;

    /* compiled from: IMASDK */
    public enum AdErrorCode {
        INTERNAL_ERROR(-1),
        VAST_MALFORMED_RESPONSE(100),
        UNKNOWN_AD_RESPONSE(1010),
        VAST_TRAFFICKING_ERROR(200),
        VAST_LOAD_TIMEOUT(301),
        VAST_TOO_MANY_REDIRECTS(302),
        VIDEO_PLAY_ERROR(400),
        VAST_MEDIA_LOAD_TIMEOUT(402),
        VAST_LINEAR_ASSET_MISMATCH(403),
        OVERLAY_AD_PLAYING_FAILED(HttpStatus.HTTP_INTERNAL_SERVER_ERROR),
        OVERLAY_AD_LOADING_FAILED(502),
        VAST_NONLINEAR_ASSET_MISMATCH(503),
        COMPANION_AD_LOADING_FAILED(603),
        UNKNOWN_ERROR(DBHelper.GET_STICKER_LIMIT),
        VAST_EMPTY_RESPONSE(1009),
        FAILED_TO_REQUEST_ADS(1005),
        VAST_ASSET_NOT_FOUND(1007),
        ADS_REQUEST_NETWORK_ERROR(1012),
        INVALID_ARGUMENTS(1101),
        PLAYLIST_NO_CONTENT_TRACKING(1205);

        private final int a;

        AdErrorCode(int i) {
            this.a = i;
        }

        public boolean equals(int i) {
            return this.a == i;
        }

        public int getErrorNumber() {
            return this.a;
        }

        @Override // java.lang.Enum
        public String toString() {
            String strName = name();
            int i = this.a;
            StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 41);
            sb.append("AdErrorCode [name: ");
            sb.append(strName);
            sb.append(", number: ");
            sb.append(i);
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: IMASDK */
    public enum AdErrorType {
        LOAD,
        PLAY
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdError(AdErrorType adErrorType, int i, String str) {
        AdErrorCode adErrorCode;
        AdErrorCode[] adErrorCodeArrValues = AdErrorCode.values();
        int length = adErrorCodeArrValues.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                adErrorCode = adErrorCodeArrValues[i2];
                if (adErrorCode.getErrorNumber() == i) {
                    break;
                } else {
                    i2++;
                }
            } else {
                adErrorCode = i == 1204 ? AdErrorCode.INTERNAL_ERROR : AdErrorCode.UNKNOWN_ERROR;
            }
        }
        this(adErrorType, adErrorCode, str);
    }

    public AdErrorCode getErrorCode() {
        return this.a;
    }

    public int getErrorCodeNumber() {
        return this.a.getErrorNumber();
    }

    public AdErrorType getErrorType() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    public String toString() {
        String strValueOf = String.valueOf(this.b);
        String strValueOf2 = String.valueOf(this.a);
        String message = getMessage();
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 45 + strValueOf2.length() + String.valueOf(message).length());
        sb.append("AdError [errorType: ");
        sb.append(strValueOf);
        sb.append(", errorCode: ");
        sb.append(strValueOf2);
        sb.append(", message: ");
        sb.append(message);
        sb.append("]");
        return sb.toString();
    }

    public AdError(AdErrorType adErrorType, AdErrorCode adErrorCode, String str) {
        super(str);
        this.b = adErrorType;
        this.a = adErrorCode;
    }
}
