package okio;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "Ljava/io/IOException;", ParameterNames.CAUSE, "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lir/nasim/rB7;", "timedOut", "()V", "Ljava/net/Socket;", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        AbstractC13042fc3.i(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    protected IOException newTimeoutException(IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() throws IOException {
        try {
            this.socket.close();
        } catch (AssertionError e) {
            if (!Okio.isAndroidGetsocknameError(e)) {
                throw e;
            }
            Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e);
        } catch (Exception e2) {
            Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e2);
        }
    }
}
