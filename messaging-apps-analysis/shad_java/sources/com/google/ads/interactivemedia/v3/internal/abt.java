package com.google.ads.interactivemedia.v3.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abt extends abr {
    private final ContentResolver a;
    private Uri b;
    private AssetFileDescriptor c;
    private FileInputStream d;
    private long e;
    private boolean f;

    public abt(Context context) {
        super(false);
        this.a = context.getContentResolver();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new abs(e);
            }
        }
        FileInputStream fileInputStream = this.d;
        int i3 = aeu.a;
        int i4 = fileInputStream.read(bArr, i, i2);
        if (i4 == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new abs(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - i4;
        }
        i(i4);
        return i4;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        try {
            Uri uri = acbVar.a;
            this.b = uri;
            g(acbVar);
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, "r");
            this.c = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
                sb.append("Could not open file descriptor for: ");
                sb.append(strValueOf);
                throw new FileNotFoundException(sb.toString());
            }
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.d = fileInputStream;
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(acbVar.e + startOffset) - startOffset;
            if (jSkip != acbVar.e) {
                throw new EOFException();
            }
            long j = acbVar.f;
            if (j != -1) {
                this.e = j;
            } else {
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.e = -1L;
                    } else {
                        long jPosition = size - channel.position();
                        this.e = jPosition;
                        if (jPosition < 0) {
                            throw new EOFException();
                        }
                    }
                } else {
                    long j2 = length - jSkip;
                    this.e = j2;
                    if (j2 < 0) {
                        throw new EOFException();
                    }
                }
            }
            this.f = true;
            h(acbVar);
            return this.e;
        } catch (IOException e) {
            throw new abs(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws abs {
        this.b = null;
        try {
            try {
                FileInputStream fileInputStream = this.d;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.d = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.c;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.c = null;
                        if (this.f) {
                            this.f = false;
                            j();
                        }
                    }
                } catch (IOException e) {
                    throw new abs(e);
                }
            } catch (IOException e2) {
                throw new abs(e2);
            }
        } catch (Throwable th) {
            this.d = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.c;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.c = null;
                    if (this.f) {
                        this.f = false;
                        j();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new abs(e3);
                }
            } catch (Throwable th2) {
                this.c = null;
                if (this.f) {
                    this.f = false;
                    j();
                }
                throw th2;
            }
        }
    }
}
