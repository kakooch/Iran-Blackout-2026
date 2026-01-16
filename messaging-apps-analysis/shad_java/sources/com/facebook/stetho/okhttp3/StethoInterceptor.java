package com.facebook.stetho.okhttp3;

import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.facebook.stetho.inspector.network.RequestBodyHelper;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes.dex */
public class StethoInterceptor implements Interceptor {
    private final NetworkEventReporter mEventReporter = NetworkEventReporterImpl.get();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RequestBodyHelper requestBodyHelper;
        MediaType mediaTypeContentType;
        InputStream inputStreamByteStream;
        String strNextRequestId = this.mEventReporter.nextRequestId();
        Request request = chain.request();
        if (this.mEventReporter.isEnabled()) {
            requestBodyHelper = new RequestBodyHelper(this.mEventReporter, strNextRequestId);
            this.mEventReporter.requestWillBeSent(new OkHttpInspectorRequest(strNextRequestId, request, requestBodyHelper));
        } else {
            requestBodyHelper = null;
        }
        try {
            Response responseProceed = chain.proceed(request);
            if (!this.mEventReporter.isEnabled()) {
                return responseProceed;
            }
            if (requestBodyHelper != null && requestBodyHelper.hasBody()) {
                requestBodyHelper.reportDataSent();
            }
            Connection connection = chain.connection();
            if (connection == null) {
                throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
            }
            this.mEventReporter.responseHeadersReceived(new OkHttpInspectorResponse(strNextRequestId, request, responseProceed, connection));
            ResponseBody responseBodyBody = responseProceed.body();
            if (responseBodyBody != null) {
                mediaTypeContentType = responseBodyBody.contentType();
                inputStreamByteStream = responseBodyBody.byteStream();
            } else {
                mediaTypeContentType = null;
                inputStreamByteStream = null;
            }
            InputStream inputStreamInterpretResponseStream = this.mEventReporter.interpretResponseStream(strNextRequestId, mediaTypeContentType != null ? mediaTypeContentType.toString() : null, responseProceed.header("Content-Encoding"), inputStreamByteStream, new DefaultResponseHandler(this.mEventReporter, strNextRequestId));
            return inputStreamInterpretResponseStream != null ? responseProceed.newBuilder().body(new ForwardingResponseBody(responseBodyBody, inputStreamInterpretResponseStream)).build() : responseProceed;
        } catch (IOException e) {
            if (this.mEventReporter.isEnabled()) {
                this.mEventReporter.httpExchangeFailed(strNextRequestId, e.toString());
            }
            throw e;
        }
    }

    private static class OkHttpInspectorRequest implements NetworkEventReporter.InspectorRequest {
        private final Request mRequest;
        private RequestBodyHelper mRequestBodyHelper;
        private final String mRequestId;

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequestCommon
        public String friendlyName() {
            return null;
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest
        public Integer friendlyNameExtra() {
            return null;
        }

        public OkHttpInspectorRequest(String str, Request request, RequestBodyHelper requestBodyHelper) {
            this.mRequestId = str;
            this.mRequest = request;
            this.mRequestBodyHelper = requestBodyHelper;
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequestCommon
        public String id() {
            return this.mRequestId;
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest
        public String url() {
            return this.mRequest.url().toString();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest
        public String method() {
            return this.mRequest.method();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest
        public byte[] body() throws IOException {
            RequestBody requestBodyBody = this.mRequest.body();
            if (requestBodyBody == null) {
                return null;
            }
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(this.mRequestBodyHelper.createBodySink(firstHeaderValue("Content-Encoding"))));
            try {
                requestBodyBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                return this.mRequestBodyHelper.getDisplayBody();
            } catch (Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public int headerCount() {
            return this.mRequest.headers().size();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public String headerName(int i) {
            return this.mRequest.headers().name(i);
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public String headerValue(int i) {
            return this.mRequest.headers().value(i);
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public String firstHeaderValue(String str) {
            return this.mRequest.header(str);
        }
    }

    private static class OkHttpInspectorResponse implements NetworkEventReporter.InspectorResponse {
        private final Connection mConnection;
        private final Request mRequest;
        private final String mRequestId;
        private final Response mResponse;

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse
        public boolean connectionReused() {
            return false;
        }

        public OkHttpInspectorResponse(String str, Request request, Response response, Connection connection) {
            this.mRequestId = str;
            this.mRequest = request;
            this.mResponse = response;
            this.mConnection = connection;
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponseCommon
        public String requestId() {
            return this.mRequestId;
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse
        public String url() {
            return this.mRequest.url().toString();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponseCommon
        public int statusCode() {
            return this.mResponse.code();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponseCommon
        public String reasonPhrase() {
            return this.mResponse.message();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse
        public int connectionId() {
            Connection connection = this.mConnection;
            if (connection == null) {
                return 0;
            }
            return connection.hashCode();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse
        public boolean fromDiskCache() {
            return this.mResponse.cacheResponse() != null;
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public int headerCount() {
            return this.mResponse.headers().size();
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public String headerName(int i) {
            return this.mResponse.headers().name(i);
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public String headerValue(int i) {
            return this.mResponse.headers().value(i);
        }

        @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders
        public String firstHeaderValue(String str) {
            return this.mResponse.header(str);
        }
    }

    private static class ForwardingResponseBody extends ResponseBody {
        private final ResponseBody mBody;
        private final BufferedSource mInterceptedSource;

        public ForwardingResponseBody(ResponseBody responseBody, InputStream inputStream) {
            this.mBody = responseBody;
            this.mInterceptedSource = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.mBody.contentType();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.mBody.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.mInterceptedSource;
        }
    }
}
