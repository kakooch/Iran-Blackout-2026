package com.squareup.okhttp;

import com.squareup.okhttp.Headers;

/* loaded from: classes3.dex */
public final class Request {
    private final Headers headers;
    private final String method;
    private final Object tag;
    private final HttpUrl url;

    private Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        RequestBody unused = builder.body;
        this.tag = builder.tag != null ? builder.tag : this;
    }

    public HttpUrl httpUrl() {
        return this.url;
    }

    public Headers headers() {
        return this.headers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", tag=");
        Object obj = this.tag;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private RequestBody body;
        private Object tag;
        private HttpUrl url;
        private String method = "GET";
        private Headers.Builder headers = new Headers.Builder();

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.url = httpUrl;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Request build() {
            if (this.url == null) {
                throw new IllegalStateException("url == null");
            }
            return new Request(this);
        }
    }
}
