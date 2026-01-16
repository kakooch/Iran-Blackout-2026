package ir.nasim;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.io.IOException;

/* renamed from: ir.nasim.Kw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5795Kw1 {
    public static final Cursor a(Cursor cursor) throws IOException {
        AbstractC13042fc3.i(cursor, "c");
        Cursor cursor2 = cursor;
        try {
            Cursor cursor3 = cursor2;
            MatrixCursor matrixCursor = new MatrixCursor(cursor3.getColumnNames(), cursor3.getCount());
            while (cursor3.moveToNext()) {
                Object[] objArr = new Object[cursor3.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor3.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor3.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor3.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor3.getString(i);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i] = cursor3.getBlob(i);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            YV0.a(cursor2, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int b(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        AbstractC13042fc3.h(columnNames, "columnNames");
        return c(columnNames, str);
    }

    public static final int c(String[] strArr, String str) {
        AbstractC13042fc3.i(strArr, "columnNames");
        AbstractC13042fc3.i(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str4 = strArr[i];
            int i3 = i2 + 1;
            if (str4.length() >= str.length() + 2) {
                if (AbstractC20153rZ6.C(str4, str2, false, 2, null)) {
                    return i2;
                }
                if (str4.charAt(0) == '`' && AbstractC20153rZ6.C(str4, str3, false, 2, null)) {
                    return i2;
                }
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    public static final int d(Cursor cursor, String str) {
        AbstractC13042fc3.i(cursor, "c");
        AbstractC13042fc3.i(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : b(cursor, str);
    }

    public static final int e(Cursor cursor, String str) {
        String strD0;
        AbstractC13042fc3.i(cursor, "c");
        AbstractC13042fc3.i(str, "name");
        int iD = d(cursor, str);
        if (iD >= 0) {
            return iD;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            AbstractC13042fc3.h(columnNames, "c.columnNames");
            strD0 = AbstractC10242bK.D0(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strD0 = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strD0);
    }
}
