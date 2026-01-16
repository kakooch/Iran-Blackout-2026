package androidMessenger.deviceUtils;

import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidMessenger.utilites.ContactConverter;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.PhoneBookHelper;
import ir.aaap.messengercore.model.PhoneBookObject;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;

/* loaded from: classes.dex */
public class PhoneBookHelperImpl implements PhoneBookHelper {
    private String[] projectionPhones = {"lookup", "data1", "data2", "data3", "display_name", "account_type"};
    private String[] projectionNames = {"lookup", "data2", "data3", "data5"};

    @Override // ir.aaap.messengercore.PhoneBookHelper
    public ArrayList<PhoneBookObject> getPhoneBooks() {
        return ContactConverter.convertToPhoneObjects(new ArrayList(readContactsFromPhoneBook().values()));
    }

    @Override // ir.aaap.messengercore.PhoneBookHelper
    public String getVersion() {
        String string = BuildConfig.FLAVOR;
        try {
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (!hasContactsPermission()) {
            return BuildConfig.FLAVOR;
        }
        try {
            Cursor cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"version"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (cursorQuery.moveToNext()) {
                        sb.append(cursorQuery.getString(cursorQuery.getColumnIndex("version")));
                    }
                    string = sb.toString();
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
            if (cursorQuery != null) {
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:177:0x032b A[Catch: all -> 0x0343, TRY_LEAVE, TryCatch #1 {all -> 0x0343, blocks: (B:175:0x0326, B:177:0x032b), top: B:202:0x0326 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0330 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.HashMap<java.lang.String, org.rbmain.messenger.ContactsController.Contact> readContactsFromPhoneBook() {
        /*
            Method dump skipped, instructions count: 851
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.deviceUtils.PhoneBookHelperImpl.readContactsFromPhoneBook():java.util.HashMap");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x004a -> B:40:0x004d). Please report as a decompilation issue!!! */
    private boolean hasContactsPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            return ApplicationLoader.applicationContext.checkSelfPermission("android.permission.READ_CONTACTS") == 0;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, this.projectionPhones, null, null, null);
            } catch (Exception e) {
                FileLog.e(e);
            }
        } catch (Throwable th) {
            try {
                FileLog.e(th);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
            }
        }
        if (cursorQuery != null) {
            if (cursorQuery.getCount() != 0) {
                cursorQuery.close();
                return true;
            }
        }
        return false;
    }

    private boolean isNotValidNameString(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i++;
            }
        }
        return i > 3;
    }
}
