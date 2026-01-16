package ir.nasim.chat.inputbar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import ir.nasim.AbstractC15187j93;
import ir.nasim.AbstractC9511a52;
import ir.nasim.C15778k93;
import ir.nasim.C7139Ql0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class BarEditText extends EditText {
    private CopyOnWriteArrayList a;
    private a b;

    public interface a {
        void a(Uri uri);
    }

    public interface b {
        void a();
    }

    public BarEditText(Context context) {
        super(context);
        this.a = new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c(C15778k93 c15778k93, int i, Bundle bundle) {
        if (C7139Ql0.a() && (i & 1) != 0) {
            try {
                c15778k93.d();
            } catch (Exception unused) {
                return false;
            }
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(c15778k93.a());
        }
        return true;
    }

    public void b(b bVar) {
        if (this.a.contains(bVar)) {
            return;
        }
        this.a.add(bVar);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC9511a52.d(editorInfo, new String[]{"image/png", "image/gif", "image/jpeg", "image/webp"});
        return AbstractC15187j93.d(inputConnectionOnCreateInputConnection, editorInfo, new AbstractC15187j93.c() { // from class: ir.nasim.Z80
            @Override // ir.nasim.AbstractC15187j93.c
            public final boolean a(C15778k93 c15778k93, int i, Bundle bundle) {
                return this.a.c(c15778k93, i, bundle);
            }
        });
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        CopyOnWriteArrayList copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }
    }

    public void setOnRichContentSentListener(a aVar) {
        this.b = aVar;
    }

    public BarEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new CopyOnWriteArrayList();
    }

    public BarEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new CopyOnWriteArrayList();
    }
}
