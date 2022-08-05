package one.digitalinnovation.gof.model;

import javax.persistence.*;

/**
 * Contém apenas as estruturas de quote da API que nos interessam, qual sejam, quote e autor. O ID consiste na quote sem formação
 */
@Entity
public class Quote {

    @Id
    public String id;

    public String q;
    public String a;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    /**
     * Retira espaços e pontos do corpo da quote e retorna o resultado para ser usado como id
     * @return Uma string que pode ser utilizada como id
     */
    public String generateId() {
        String formattedQuote = this.q.replaceAll(" ", "");
        formattedQuote = formattedQuote.replaceAll("\\.", "");
        return formattedQuote.toLowerCase();

    }

/*    public Long getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }*/

/*    public String getH() {
        return h;
    }*/

/*    public void setH(String h) {
        this.h = h;
    }*/
}
