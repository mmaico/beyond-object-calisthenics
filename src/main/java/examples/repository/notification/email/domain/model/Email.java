package examples.repository.notification.email.domain.model;

public class Email {

    private From fom;
    private To To;
    private String subject;

    private String template;


    public From getFom() {
        return fom;
    }

    public void setFom(From fom) {
        this.fom = fom;
    }

    public examples.repository.notification.email.domain.model.To getTo() {
        return To;
    }

    public void setTo(examples.repository.notification.email.domain.model.To to) {
        To = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
