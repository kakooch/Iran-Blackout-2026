package okio;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC14067hI1;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@InterfaceC14067hI1
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes8.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @InterfaceC14067hI1
    public final Sink appendingSink(File file) {
        AbstractC13042fc3.i(file, "file");
        return Okio.appendingSink(file);
    }

    @InterfaceC14067hI1
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @InterfaceC14067hI1
    public final BufferedSink buffer(Sink sink) {
        AbstractC13042fc3.i(sink, "sink");
        return Okio.buffer(sink);
    }

    @InterfaceC14067hI1
    public final Sink sink(File file) {
        AbstractC13042fc3.i(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @InterfaceC14067hI1
    public final Source source(File file) {
        AbstractC13042fc3.i(file, "file");
        return Okio.source(file);
    }

    @InterfaceC14067hI1
    public final BufferedSource buffer(Source source) {
        AbstractC13042fc3.i(source, "source");
        return Okio.buffer(source);
    }

    @InterfaceC14067hI1
    public final Sink sink(OutputStream outputStream) {
        AbstractC13042fc3.i(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @InterfaceC14067hI1
    public final Source source(InputStream inputStream) {
        AbstractC13042fc3.i(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @InterfaceC14067hI1
    public final Sink sink(java.nio.file.Path path, OpenOption... options) {
        AbstractC13042fc3.i(path, "path");
        AbstractC13042fc3.i(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @InterfaceC14067hI1
    public final Source source(java.nio.file.Path path, OpenOption... options) {
        AbstractC13042fc3.i(path, "path");
        AbstractC13042fc3.i(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @InterfaceC14067hI1
    public final Sink sink(Socket socket) {
        AbstractC13042fc3.i(socket, "socket");
        return Okio.sink(socket);
    }

    @InterfaceC14067hI1
    public final Source source(Socket socket) {
        AbstractC13042fc3.i(socket, "socket");
        return Okio.source(socket);
    }
}
