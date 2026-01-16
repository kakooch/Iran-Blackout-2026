package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC21804u96;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
/* loaded from: classes3.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new b();
    private static final a k = new com.google.android.gms.common.data.a(new String[0], null);
    final int a;
    private final String[] b;
    Bundle c;
    private final CursorWindow[] d;
    private final int e;
    private final Bundle f;
    int[] g;
    int h;
    boolean i = false;
    private boolean j = true;

    public static class a {
        private final String[] a;
        private final ArrayList b = new ArrayList();
        private final HashMap c = new HashMap();
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    public Bundle P() {
        return this.f;
    }

    public int S() {
        return this.e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (!this.i) {
                    this.i = true;
                    int i = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.d;
                        if (i >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i].close();
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d0() {
        this.c = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.b;
            if (i2 >= strArr.length) {
                break;
            }
            this.c.putInt(strArr[i2], i2);
            i2++;
        }
        this.g = new int[this.d.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.d;
            if (i >= cursorWindowArr.length) {
                this.h = numRows;
                return;
            }
            this.g[i] = numRows;
            numRows += this.d[i].getNumRows() - (numRows - cursorWindowArr[i].getStartPosition());
            i++;
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.j && this.d.length > 0 && !isClosed()) {
                close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + Separators.RPAREN);
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.u(parcel, 1, this.b, false);
        AbstractC21804u96.w(parcel, 2, this.d, i, false);
        AbstractC21804u96.n(parcel, 3, S());
        AbstractC21804u96.e(parcel, 4, P(), false);
        AbstractC21804u96.n(parcel, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.a);
        AbstractC21804u96.b(parcel, iA);
        if ((i & 1) != 0) {
            close();
        }
    }
}
