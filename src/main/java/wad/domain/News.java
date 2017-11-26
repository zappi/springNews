package wad.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class News extends AbstractPersistable<Long> {

    private String heading;
    private String lead;   //ingressi
    @Lob
    private byte[] image;
    private String text;
    private int pageOpened = 0;
    private LocalDate releaseTime;
    @ManyToMany
    private List<Journalist> journalistList;
    @ManyToMany
    private List<Category> categoryList;

    public News(String heading, String lead, String text, LocalDate localDate) {
        this.heading = heading;
        this.lead = lead;
        this.text = text;
        this.releaseTime = localDate;
        this.categoryList = new ArrayList<>();
        this.journalistList = new ArrayList<>();
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDate releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<Journalist> getJournalistList() {
        return journalistList;
    }

    public void setJournalistList(List<Journalist> journalistList) {
        this.journalistList = journalistList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public int getPageOpened() {
        return pageOpened;
    }

    public void incrementPageOpened() {
        pageOpened+=1;
    }
}