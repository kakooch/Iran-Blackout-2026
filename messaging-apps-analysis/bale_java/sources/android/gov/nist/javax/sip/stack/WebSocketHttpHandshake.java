package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class WebSocketHttpHandshake {
    private static StackLogger logger = CommonLogger.getLogger(WebSocketHttpHandshake.class);
    private HashMap<String, String> headers = new HashMap<>();

    public static String computeRev13Response(String str) throws NoSuchAlgorithmException {
        String str2 = str + WebSocketProtocol.ACCEPT_MAGIC;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bArrDigest = messageDigest.digest(str2.getBytes());
        new ByteArrayOutputStream();
        return Base64.encodeBytes(bArrDigest);
    }

    private String readLine(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            if (i == 13) {
                z = true;
            } else {
                if (i == 10 && z) {
                    return sb.toString();
                }
                if (i == 10) {
                    return null;
                }
                sb.append((char) i);
            }
        }
    }

    public byte[] createHttpResponse(String str) throws IOException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Request=" + str);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        String line = readLine(byteArrayInputStream);
        if (line == null) {
            return null;
        }
        String[] strArrSplit = line.split(Separators.SP);
        if (strArrSplit.length >= 3) {
            this.headers.put("ctx", strArrSplit[1]);
        }
        boolean z = false;
        while (!line.isEmpty()) {
            line = readLine(byteArrayInputStream);
            if (line != null && !line.isEmpty()) {
                String[] strArrSplit2 = line.split(":", 2);
                if (strArrSplit2.length == 2) {
                    if (strArrSplit2[0].toLowerCase().startsWith("sec-websocket-key")) {
                        z = true;
                    }
                    this.headers.put(strArrSplit2[0].trim(), strArrSplit2[1].trim());
                }
            }
        }
        if (z) {
            byteArrayInputStream.read(new byte[8]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 101 Web Socket Protocol Handshake");
        sb.append(Separators.NEWLINE);
        sb.append("Upgrade: WebSocket");
        sb.append(Separators.NEWLINE);
        sb.append("Connection: Upgrade");
        sb.append(Separators.NEWLINE);
        if (z) {
            sb.append("Sec-");
        }
        sb.append("WebSocket-Origin: ");
        sb.append(this.headers.get("Origin"));
        sb.append(Separators.NEWLINE);
        if (z) {
            sb.append("Sec-");
        }
        sb.append("WebSocket-Location: ws://");
        sb.append(this.headers.get("Host"));
        sb.append(this.headers.get("ctx"));
        sb.append(Separators.NEWLINE);
        sb.append("Sec-WebSocket-Accept: ");
        sb.append(computeRev13Response(this.headers.get("Sec-WebSocket-Key")));
        sb.append(Separators.NEWLINE);
        if (this.headers.get("Protocol") != null) {
            if (z) {
                sb.append("Sec-");
            }
            sb.append("Protocol: ");
            sb.append(this.headers.get("Protocol"));
            sb.append(Separators.NEWLINE);
        }
        if (this.headers.get("Sec-WebSocket-Protocol") != null) {
            sb.append("Sec-WebSocket-Protocol: ");
            sb.append(this.headers.get("Sec-WebSocket-Protocol"));
            sb.append(Separators.NEWLINE);
        }
        sb.append(Separators.NEWLINE);
        String string = sb.toString();
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Response=" + string);
        }
        return sb.toString().getBytes();
    }
}
