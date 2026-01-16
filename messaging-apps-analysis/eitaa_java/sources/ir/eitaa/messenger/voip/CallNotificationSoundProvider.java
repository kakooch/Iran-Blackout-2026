package ir.eitaa.messenger.voip;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import ir.eitaa.messenger.ApplicationLoader;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class CallNotificationSoundProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws IOException {
        if (!"r".equals(mode)) {
            throw new SecurityException("Unexpected file mode " + mode);
        }
        if (ApplicationLoader.applicationContext == null) {
            throw new FileNotFoundException("Unexpected application state");
        }
        try {
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance != null) {
                sharedInstance.startRingtoneAndVibration();
            }
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            autoCloseOutputStream.write(new byte[]{82, 73, 70, 70, 41, 0, 0, 0, 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, 1, 0, 68, -84, 0, 0, 16, -79, 2, 0, 2, 0, 16, 0, 100, 97, 116, 97, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            autoCloseOutputStream.close();
            return parcelFileDescriptorArrCreatePipe[0];
        } catch (Exception e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
