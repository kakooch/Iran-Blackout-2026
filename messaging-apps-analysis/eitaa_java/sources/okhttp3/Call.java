package okhttp3;

import java.io.IOException;

/* loaded from: classes.dex */
public interface Call extends Cloneable {
    Response execute() throws IOException;
}
