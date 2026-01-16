package com.google.android.gms.common;

import android.app.PendingIntent;
import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes3.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    final int a;
    private final int b;
    private final PendingIntent c;
    private final String d;
    public static final ConnectionResult e = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new g();

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.a = i;
        this.b = i2;
        this.c = pendingIntent;
        this.d = str;
    }

    static String A0(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i + Separators.RPAREN;
                }
        }
    }

    public int P() {
        return this.b;
    }

    public String S() {
        return this.d;
    }

    public PendingIntent d0() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.b == connectionResult.b && DG4.a(this.c, connectionResult.c) && DG4.a(this.d, connectionResult.d);
    }

    public int hashCode() {
        return DG4.b(Integer.valueOf(this.b), this.c, this.d);
    }

    public boolean s0() {
        return (this.b == 0 || this.c == null) ? false : true;
    }

    public String toString() {
        DG4.a aVarC = DG4.c(this);
        aVarC.a("statusCode", A0(this.b));
        aVarC.a("resolution", this.c);
        aVarC.a(DialogEntity.COLUMN_MESSAGE, this.d);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, i2);
        AbstractC21804u96.n(parcel, 2, P());
        AbstractC21804u96.s(parcel, 3, d0(), i, false);
        AbstractC21804u96.t(parcel, 4, S(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    public boolean x0() {
        return this.b == 0;
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }
}
