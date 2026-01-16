package com.google.android.exoplayer2t.upstream;

import com.google.android.exoplayer2t.upstream.DataSource;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface HttpDataSource extends DataSource {

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements DataSource.Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        protected abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @Override // com.google.android.exoplayer2t.upstream.DataSource.Factory
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    public static class HttpDataSourceException extends IOException {
        public HttpDataSourceException(String str, DataSpec dataSpec, int i) {
            super(str);
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException);
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i) {
            super(str, iOException);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 1);
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, String str, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i, dataSpec, 1);
            this.responseCode = i;
            this.headerFields = map;
        }
    }
}
