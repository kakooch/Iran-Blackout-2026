package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @RecentlyNonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
    private final int zaa;
    private final String[] zab;
    private Bundle zac;
    private final CursorWindow[] zad;
    private final int zae;
    private final Bundle zaf;
    private int[] zag;
    private int zah;
    private boolean zai = false;
    private boolean zaj = true;

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.zaa = i;
        this.zab = strArr;
        this.zad = cursorWindowArr;
        this.zae = i2;
        this.zaf = bundle;
    }

    public final void zaa() {
        this.zac = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zab;
            if (i2 >= strArr.length) {
                break;
            }
            this.zac.putInt(strArr[i2], i2);
            i2++;
        }
        this.zag = new int[this.zad.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zad;
            if (i < cursorWindowArr.length) {
                this.zag[i] = numRows;
                numRows += this.zad[i].getNumRows() - (numRows - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.zah = numRows;
                return;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class Builder {
        private Builder(String[] strArr, String str) {
            new ArrayList();
            new HashMap();
        }

        /* synthetic */ Builder(String[] strArr, String str, zab zabVar) {
            this(strArr, null);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zab, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zad, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, CloseCodes.NORMAL_CLOSURE, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final int getStatusCode() {
        return this.zae;
    }

    @RecentlyNullable
    public final Bundle getMetadata() {
        return this.zaf;
    }

    private final void zaa(String str, int i) {
        Bundle bundle = this.zac;
        if (bundle == null || !bundle.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "No such column: ".concat(strValueOf) : new String("No such column: "));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.zah) {
            throw new CursorIndexOutOfBoundsException(i, this.zah);
        }
    }

    public final int getInteger(@RecentlyNonNull String str, int i, int i2) {
        zaa(str, i);
        return this.zad[i2].getInt(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final String getString(@RecentlyNonNull String str, int i, int i2) {
        zaa(str, i);
        return this.zad[i2].getString(i, this.zac.getInt(str));
    }

    @RecentlyNonNull
    public final byte[] getByteArray(@RecentlyNonNull String str, int i, int i2) {
        zaa(str, i);
        return this.zad[i2].getBlob(i, this.zac.getInt(str));
    }

    public final int getCount() {
        return this.zah;
    }

    public final int getWindowIndex(int i) {
        int[] iArr;
        int i2 = 0;
        Preconditions.checkState(i >= 0 && i < this.zah);
        while (true) {
            iArr = this.zag;
            if (i2 >= iArr.length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == iArr.length ? i2 - 1 : i2;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.zai;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.zai) {
                this.zai = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zad;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.zaj && this.zad.length > 0 && !isClosed()) {
                close();
                String string = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(string);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    static {
        new zab(new String[0], null);
    }
}
