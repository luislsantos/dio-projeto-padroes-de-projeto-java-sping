package one.digitalinnovation.gof.model;

import javax.persistence.*;

/**
 * Conterá o template com o nome, a imagem, e a quote
 *
 * @see <a href="https://www.jsonschema2pojo.org">sonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */

@Entity
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String imgUrl;

    @ManyToOne
    private Quote quote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
