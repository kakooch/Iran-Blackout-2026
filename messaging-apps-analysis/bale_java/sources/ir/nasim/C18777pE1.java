package ir.nasim;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: ir.nasim.pE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18777pE1 implements ZK3 {
    @Override // ir.nasim.ZK3
    public TK3 a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new C18186oE1(httpURLConnection);
    }
}
