package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class DataSpec {
    public final long absoluteStreamPosition;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map<String, String> httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;

    private static int inferHttpMethod(byte[] postBody) {
        return postBody != null ? 2 : 1;
    }

    public DataSpec(Uri uri, int flags) {
        this(uri, 0L, -1L, null, flags);
    }

    public DataSpec(Uri uri, long absoluteStreamPosition, long length, String key) {
        this(uri, absoluteStreamPosition, absoluteStreamPosition, length, key, 0);
    }

    public DataSpec(Uri uri, long absoluteStreamPosition, long length, String key, int flags) {
        this(uri, absoluteStreamPosition, absoluteStreamPosition, length, key, flags);
    }

    public DataSpec(Uri uri, long absoluteStreamPosition, long length, String key, int flags, Map<String, String> httpRequestHeaders) {
        this(uri, inferHttpMethod(null), null, absoluteStreamPosition, absoluteStreamPosition, length, key, flags, httpRequestHeaders);
    }

    public DataSpec(Uri uri, long absoluteStreamPosition, long position, long length, String key, int flags) {
        this(uri, null, absoluteStreamPosition, position, length, key, flags);
    }

    public DataSpec(Uri uri, byte[] postBody, long absoluteStreamPosition, long position, long length, String key, int flags) {
        this(uri, inferHttpMethod(postBody), postBody, absoluteStreamPosition, position, length, key, flags);
    }

    public DataSpec(Uri uri, int httpMethod, byte[] httpBody, long absoluteStreamPosition, long position, long length, String key, int flags) {
        this(uri, httpMethod, httpBody, absoluteStreamPosition, position, length, key, flags, Collections.emptyMap());
    }

    public DataSpec(Uri uri, int httpMethod, byte[] httpBody, long absoluteStreamPosition, long position, long length, String key, int flags, Map<String, String> httpRequestHeaders) {
        byte[] bArr = httpBody;
        boolean z = true;
        Assertions.checkArgument(absoluteStreamPosition >= 0);
        Assertions.checkArgument(position >= 0);
        if (length <= 0 && length != -1) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.uri = uri;
        this.httpMethod = httpMethod;
        this.httpBody = (bArr == null || bArr.length == 0) ? null : bArr;
        this.absoluteStreamPosition = absoluteStreamPosition;
        this.position = position;
        this.length = length;
        this.key = key;
        this.flags = flags;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(httpRequestHeaders));
    }

    public boolean isFlagSet(int flag) {
        return (this.flags & flag) == flag;
    }

    public String toString() {
        return "DataSpec[" + getHttpMethodString() + " " + this.uri + ", " + Arrays.toString(this.httpBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public final String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public static String getStringForHttpMethod(int httpMethod) {
        if (httpMethod == 1) {
            return "GET";
        }
        if (httpMethod == 2) {
            return "POST";
        }
        if (httpMethod == 3) {
            return "HEAD";
        }
        throw new AssertionError(httpMethod);
    }

    public DataSpec subrange(long offset) {
        long j = this.length;
        return subrange(offset, j != -1 ? j - offset : -1L);
    }

    public DataSpec subrange(long offset, long length) {
        return (offset == 0 && this.length == length) ? this : new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition + offset, this.position + offset, length, this.key, this.flags, this.httpRequestHeaders);
    }
}
