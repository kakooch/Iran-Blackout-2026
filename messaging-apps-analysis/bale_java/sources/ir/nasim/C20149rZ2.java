package ir.nasim;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.HttpException;
import ir.nasim.InterfaceC8666Wy1;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* renamed from: ir.nasim.rZ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20149rZ2 implements InterfaceC8666Wy1 {
    static final b g = new a();
    private final YI2 a;
    private final int b;
    private final b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    /* renamed from: ir.nasim.rZ2$a */
    private static class a implements b {
        a() {
        }

        @Override // ir.nasim.C20149rZ2.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* renamed from: ir.nasim.rZ2$b */
    interface b {
        HttpURLConnection a(URL url);
    }

    public C20149rZ2(YI2 yi2, int i) {
        this(yi2, i, g);
    }

    private HttpURLConnection c(URL url, Map map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionA = this.c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.b);
            httpURLConnectionA.setReadTimeout(this.b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e) {
            throw new HttpException("URL.openConnection threw", 0, e);
        }
    }

    private static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    private InputStream g(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.e = C7838Tk1.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.e = httpURLConnection.getInputStream();
            }
            return this.e;
        } catch (IOException e) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), e);
        }
    }

    private static boolean h(int i) {
        return i / 100 == 2;
    }

    private static boolean i(int i) {
        return i / 100 == 3;
    }

    private InputStream j(URL url, int i, URL url2, Map map) throws IOException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.e = this.d.getInputStream();
            if (this.f) {
                return null;
            }
            int iF = f(this.d);
            if (h(iF)) {
                return g(this.d);
            }
            if (!i(iF)) {
                if (iF == -1) {
                    throw new HttpException(iF);
                }
                try {
                    throw new HttpException(this.d.getResponseMessage(), iF);
                } catch (IOException e) {
                    throw new HttpException("Failed to get a response message", iF, e);
                }
            }
            String headerField = this.d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url", iF);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i + 1, url, map);
            } catch (MalformedURLException e2) {
                throw new HttpException("Bad redirect url: " + headerField, iF, e2);
            }
        } catch (IOException e3) {
            throw new HttpException("Failed to connect or obtain data", f(this.d), e3);
        }
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public Class a() {
        return InputStream.class;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void b() throws IOException {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void cancel() {
        this.f = true;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public EnumC21012sz1 d() {
        return EnumC21012sz1.REMOTE;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
        StringBuilder sb;
        long jB = EI3.b();
        try {
            try {
                aVar.f(j(this.a.h(), 0, null, this.a.e()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                aVar.c(e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(EI3.a(jB));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + EI3.a(jB));
            }
            throw th;
        }
    }

    C20149rZ2(YI2 yi2, int i, b bVar) {
        this.a = yi2;
        this.b = i;
        this.c = bVar;
    }
}
