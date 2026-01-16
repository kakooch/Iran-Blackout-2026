package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* renamed from: ir.nasim.oE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18186oE1 implements TK3 {
    private final HttpURLConnection a;

    public C18186oE1(HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.disconnect();
    }

    @Override // ir.nasim.TK3
    public boolean isSuccessful() {
        try {
            return this.a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // ir.nasim.TK3
    public String o0() {
        return this.a.getContentType();
    }

    @Override // ir.nasim.TK3
    public String q1() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.a.getURL() + ". Failed with " + this.a.getResponseCode() + Separators.RETURN + a(this.a);
        } catch (IOException e) {
            JI3.d("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // ir.nasim.TK3
    public InputStream u0() {
        return this.a.getInputStream();
    }
}
