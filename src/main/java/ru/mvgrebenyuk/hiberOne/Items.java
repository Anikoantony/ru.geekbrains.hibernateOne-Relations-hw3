package ru.mvgrebenyuk.hiberOne;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Items(String title) {
        this.title = title;
    }

    @Column(name = "title")
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public Items() {

    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
