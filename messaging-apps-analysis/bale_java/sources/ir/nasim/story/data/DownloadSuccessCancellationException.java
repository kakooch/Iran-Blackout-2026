package ir.nasim.story.data;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0002j\u0002`\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lir/nasim/story/data/DownloadSuccessCancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "Ljava/util/concurrent/CancellationException;", "<init>", "()V", "story_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DownloadSuccessCancellationException extends CancellationException {
    public DownloadSuccessCancellationException() {
        super("download completes");
    }
}
