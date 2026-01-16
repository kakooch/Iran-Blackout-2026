package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class ContactList extends SIPHeaderList<Contact> {
    private static final long serialVersionUID = 1224806837758986814L;

    public ContactList() {
        super(Contact.class, SIPHeaderNames.CONTACT);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ContactList contactList = new ContactList();
        contactList.clonehlist(this.hlist);
        return contactList;
    }
}
