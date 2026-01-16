package okhttp3;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface Interceptor {

    public interface Chain {
        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;
}
