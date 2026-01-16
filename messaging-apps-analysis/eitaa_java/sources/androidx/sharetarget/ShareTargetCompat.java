package androidx.sharetarget;

/* loaded from: classes.dex */
class ShareTargetCompat {
    final String[] mCategories;
    final String mTargetClass;
    final TargetData[] mTargetData;

    static class TargetData {
        final String mHost;
        final String mMimeType;
        final String mPath;
        final String mPathPattern;
        final String mPathPrefix;
        final String mPort;
        final String mScheme;

        TargetData(String scheme, String host, String port, String path, String pathPattern, String pathPrefix, String mimeType) {
            this.mScheme = scheme;
            this.mHost = host;
            this.mPort = port;
            this.mPath = path;
            this.mPathPattern = pathPattern;
            this.mPathPrefix = pathPrefix;
            this.mMimeType = mimeType;
        }
    }

    ShareTargetCompat(TargetData[] data, String targetClass, String[] categories) {
        this.mTargetData = data;
        this.mTargetClass = targetClass;
        this.mCategories = categories;
    }
}
