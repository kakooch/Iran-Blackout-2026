package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.a;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ParcelFileDescriptorRewinder implements com.bumptech.glide.load.data.a {
    private final InternalRewinder a;

    private static final class InternalRewinder {
        private final ParcelFileDescriptor a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        ParcelFileDescriptor rewind() throws IOException, ErrnoException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    public static final class a implements a.InterfaceC0146a {
        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        public Class a() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.load.data.a b(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean a() {
        return !"robolectric".equals(Build.FINGERPRINT);
    }

    @Override // com.bumptech.glide.load.data.a
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor c() {
        return this.a.rewind();
    }
}
