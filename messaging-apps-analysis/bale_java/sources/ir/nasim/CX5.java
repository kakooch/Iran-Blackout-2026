package ir.nasim;

import java.util.EventObject;

/* loaded from: classes.dex */
public abstract class CX5 extends EventObject {
    private InterfaceC17658nL1 m_dialog;
    private InterfaceC10981cX5 m_response;
    private CV0 m_transaction;

    public CX5(Object obj, CV0 cv0, InterfaceC17658nL1 interfaceC17658nL1, InterfaceC10981cX5 interfaceC10981cX5) {
        super(obj);
        this.m_response = interfaceC10981cX5;
        this.m_transaction = cv0;
        this.m_dialog = interfaceC17658nL1;
    }

    public CV0 getClientTransaction() {
        return this.m_transaction;
    }

    public InterfaceC17658nL1 getDialog() {
        return this.m_dialog;
    }

    public InterfaceC10981cX5 getResponse() {
        return this.m_response;
    }
}
