package org.acra.attachment;

import android.content.Context;
import android.net.Uri;
import java.util.List;
import org.acra.config.CoreConfiguration;

/* loaded from: classes.dex */
public interface AttachmentUriProvider {
    List<Uri> getAttachments(Context context, CoreConfiguration coreConfiguration);
}
